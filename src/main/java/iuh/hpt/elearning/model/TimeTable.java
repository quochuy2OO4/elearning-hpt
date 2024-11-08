package iuh.hpt.elearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data // auto generate method getter, setter, to String
@NoArgsConstructor // auto generate no arg constructor
@AllArgsConstructor // // auto generate all arg constructor

@Table(name = "time_table")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long timeTableId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id",referencedColumnName = "id", nullable = false)
    private Course course;

    @Column(name = "course_start", nullable = false)
    private LocalTime courseStart;

    @Column(name = "course_end", nullable = false)
    private LocalTime courseEnd;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Lecturer lecturer;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
