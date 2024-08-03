package grade_management_system.grade_management_system.controller;

import grade_management_system.grade_management_system.entities.Marks;
import grade_management_system.grade_management_system.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping
    public Marks addMarksByDetails(@RequestBody AddMarksRequest request) {
        return marksService.addMarksByDetails(request.getSubjectCode(), request.getSubjectTitle(), request.getSemester(), request.getMark(), request.getStatus(), request.getStudentId());
    }
}
