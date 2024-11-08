package iuh.hpt.elearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // auto generate method getter, setter, to String
@NoArgsConstructor // auto generate no arg constructor
@AllArgsConstructor // // auto generate all arg constructor

@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "sex", nullable = false)
    private boolean gender;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", length = 20, nullable = false)
    private String email;

    @Column(name = "degree", length = 20, nullable = false)
    private String degree;

    @OneToMany(mappedBy = "lecturer")
    private List<ClassRoom> classRoom;

    @OneToMany(mappedBy = "lecturer")
    private List<TimeTable> timeTable;
}
