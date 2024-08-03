package grade_management_system.grade_management_system.service;

import grade_management_system.grade_management_system.entities.Marks;
import grade_management_system.grade_management_system.entities.Student;
import grade_management_system.grade_management_system.entities.Subject;
import grade_management_system.grade_management_system.repository.MarksRepository;
import grade_management_system.grade_management_system.repository.StudentRepository;
import grade_management_system.grade_management_system.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Marks addMarksByDetails(String subjectCode, String subjectTitle, int semester, int mark, String status, Long studentId) {
        Marks marks = new Marks();
        marks.setMark(mark);
        marks.setStatus(Marks.Status.valueOf(status));

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        marks.setStudent(student);

        Subject subject = subjectRepository.findBySubjectCodeAndSemester(subjectCode, semester).orElseGet(() -> {
            Subject newSubject = new Subject();
            newSubject.setSubjectCode(subjectCode);
            newSubject.setSubjectTitle(subjectTitle);
            newSubject.setSemester(semester);
            return subjectRepository.save(newSubject);
        });
        marks.setSubject(subject);

        return marksRepository.save(marks);
    }
}
