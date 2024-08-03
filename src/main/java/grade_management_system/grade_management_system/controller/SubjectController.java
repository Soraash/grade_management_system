package grade_management_system.grade_management_system.controller;

import grade_management_system.grade_management_system.entities.Subject;
import grade_management_system.grade_management_system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/semester/{semester}")
    public List<Subject> getSubjectsBySemester(@PathVariable int semester) {
        return subjectService.getSubjectsBySemester(semester);
    }
}
