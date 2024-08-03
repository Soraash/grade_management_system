package grade_management_system.grade_management_system.repository;


import grade_management_system.grade_management_system.entities.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudentId(Long studentId);
}

