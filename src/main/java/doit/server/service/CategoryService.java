package doit.server.service;

import doit.server.controller.dto.CategoryResponse;
import doit.server.controller.dto.CreateCategoryRequest;
import doit.server.repository.Category;
import doit.server.repository.CategoryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 개별 ID 조회
    public CategoryResponse findOneCategory(Long CategoryId) {
        Optional<Category> category = categoryRepository.findById(CategoryId);
        if (category.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
        }

        return CategoryResponse.from(category.get());
    }

    // 전체 조회
    public List<CategoryResponse> findAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(CategoryResponse::from)
                .toList();
    }

    public List<CategoryResponse> searchCategoriesWithName(String exerciseName) {

        List<Category> categories = categoryRepository.findByExerciseName(exerciseName);

        return categories.stream()
                .map(CategoryResponse::from)
                .toList();
    }

    // 타입별로 검색.
    public List<CategoryResponse> searchCategoriesWithType(String exerciseType) {

        List<Category> categories = categoryRepository.findByExerciseType(exerciseType);

        return categories.stream()
                .map(CategoryResponse::from)
                .toList();
    }

    public List<CategoryResponse> searchCategoriesWithPlace(String place) {

        List<Category> categories = categoryRepository.findByPlace(place);

        return categories.stream()
                .map(CategoryResponse::from)
                .toList();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public CategoryResponse updateCategory(Long categoryId, CreateCategoryRequest request) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        category.setExerciseName(request.getExerciseName());
        category.setMinute(request.getMinute());
        category.setExerciseType(request.getExerciseType());
        category.setPlace(request.getPlace());

        return CategoryResponse.from(categoryRepository.save(category));
    }

    public void deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
        }
        categoryRepository.deleteById(categoryId);
    }
}
