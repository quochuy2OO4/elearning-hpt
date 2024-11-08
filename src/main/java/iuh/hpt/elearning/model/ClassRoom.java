package iuh.hpt.elearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data // auto generate method getter, setter, to String
@NoArgsConstructor // auto generate no arg constructor
@AllArgsConstructor // // auto generate all arg constructor

@Table(name = "classroom")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String className;

    @Column(name = "number_student", nullable = false)
    private int numberStudent;

    // Relationship one to many. map to class_id in table student
    @OneToMany(mappedBy = "classRoom")
    private List<Student> students;

    // Relationship one to one. teacher_id on table class   to   id on lecturer
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Lecturer lecturer;
}
