package grade_management_system.grade_management_system.controller;

import grade_management_system.grade_management_system.entities.Student;
import grade_management_system.grade_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/byRollNumberAndSemester")
    public Student getStudentByRollNumberAndSemester(@RequestParam String rollNumber, @RequestParam int semester) {
        return studentService.getStudentByRollNumberAndSemester(rollNumber, semester);
    }
}
