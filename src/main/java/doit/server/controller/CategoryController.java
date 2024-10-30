package doit.server.controller;

import doit.server.controller.dto.CategoryResponse;
import doit.server.repository.Category;
import doit.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Id 조회
    @GetMapping("/categories/{categoryId}")
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
    public CategoryResponse createNewCateogry(@RequestBody CreateCategoryRequest request){
        return null;
    }

}
