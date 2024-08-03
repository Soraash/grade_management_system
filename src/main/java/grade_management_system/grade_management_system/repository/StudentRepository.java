package grade_management_system.grade_management_system.repository;

import grade_management_system.grade_management_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRollNumberAndSemester(String rollNumber, int semester);
}
