package grade_management_system.grade_management_system.repository;

import grade_management_system.grade_management_system.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectCodeAndSemester(String subjectCode, int semester);

    List<Subject> findBySemester(int semester);
}
