package grade_management_system.grade_management_system.service;

import grade_management_system.grade_management_system.entities.Student;
import grade_management_system.grade_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByRollNumberAndSemester(String rollNumber, int semester) {
        return studentRepository.findByRollNumberAndSemester(rollNumber, semester);
    }
}
