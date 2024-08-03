package grade_management_system.grade_management_system.service;

import grade_management_system.grade_management_system.entities.Subject;
import grade_management_system.grade_management_system.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getSubjectsBySemester(int semester) {
        return subjectRepository.findBySemester(semester);
    }


}