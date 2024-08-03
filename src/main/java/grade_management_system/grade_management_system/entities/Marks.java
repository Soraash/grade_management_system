package grade_management_system.grade_management_system.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mark;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonBackReference
    private Subject subject;


public enum Status{
        PASS,FAIL
    }
}
