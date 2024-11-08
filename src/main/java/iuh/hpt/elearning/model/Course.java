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

@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 70)
    private String courseName;

    @Column(name = "number_lessons")
    private int numberLessons;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<TimeTable> timeTable;

}
