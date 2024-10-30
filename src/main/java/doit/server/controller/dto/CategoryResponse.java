package doit.server.controller.dto;

import doit.server.repository.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    private Long id;
    private String exerciseName;
    private Integer minute;
    private String exerciseType;
    private String place;

    public static CategoryResponse from(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .exerciseName(category.getExerciseName())
                .minute(category.getMinute())
                .exerciseType(category.getExerciseType())
                .place(category.getPlace())
                .build();
    }
}
