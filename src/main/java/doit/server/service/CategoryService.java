package doit.server.service;

import doit.server.controller.dto.CategoryResponse;
import doit.server.repository.Category;
import doit.server.repository.CategoryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // 이 어노테이션이 추가되어야합니다! JPA 관련된 이유니까 한 번 찾아보세용
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
}

/**
 * @Id
 *     @GeneratedValue(strategy = GenerationType.AUTO)
 *     @Column(name = "category_id")
 *     private Long id;
 *     private String exerciseName;
 *     private Integer minute;
 *     private String exerciseType;
 *     private String place;
 */
