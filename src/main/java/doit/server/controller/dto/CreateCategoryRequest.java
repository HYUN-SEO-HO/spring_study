package doit.server.controller.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCategoryRequest {
    private String exerciseName;
    private Integer minute;
    private String exerciseType;
    private String place;
}
