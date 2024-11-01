package doit.server.controller;

import doit.server.controller.dto.CategoryResponse;
import doit.server.controller.dto.CreateCategoryRequest;
import doit.server.repository.Category;
import doit.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Id 조회
    @GetMapping("/cagetgories/{categoryId}")
    public CategoryResponse findOneCategory(@PathVariable Long categoryId) {
        return categoryService.findOneCategory(categoryId);
    }

    @GetMapping("/categories")
    public List<CategoryResponse> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/categories/search")
    public List<CategoryResponse> searchCategories(@RequestParam String categoryName) {
        return categoryService.searchCategoriesWithName(categoryName);
    }

    @PostMapping("/categories")
    public CategoryResponse createNewCategory(@RequestBody CreateCategoryRequest request) {
        Category category = Category.builder()
                .exerciseName(request.getExerciseName())
                .minute(request.getMinute())
                .exerciseType(request.getExerciseType())
                .place(request.getPlace())
                .build();

        Category savedCategory = categoryService.createCategory(category);
        return CategoryResponse.from(savedCategory);
    }

    @PutMapping("/categories/{categoryId}")
    public CategoryResponse updateCategory(@PathVariable Long categoryId, @RequestBody CreateCategoryRequest request) {
        return categoryService.updateCategory(categoryId, request);
    }

    @DeleteMapping("/categories/{categoriesId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
