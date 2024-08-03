package grade_management_system.grade_management_system.controller;

import lombok.Data;

@Data
public class AddMarksRequest {
    private String subjectCode;
    private String subjectTitle;
    private int semester;
    private int mark;
    private String status;
    private Long studentId;
}
