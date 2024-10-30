package doit.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByExerciseName(String exerciseName);

    List<Category> findByExerciseType(String exerciseType);

    List<Category> findByPlace(String place);
}
