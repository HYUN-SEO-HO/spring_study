package doit.server.repository;


import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    private String exerciseName;
    private Integer minute;
    private String exerciseType;
    private String place;

    @Builder
    public Category(String exerciseName, Integer minute, String exerciseType, String place) {
        this.exerciseName = exerciseName;
        this.minute = minute;
        this.exerciseType = exerciseType;
        this.place = place;
    }

}
