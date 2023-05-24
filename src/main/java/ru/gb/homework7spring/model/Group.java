package ru.gb.homework7spring.model;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "group_students")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "group_number")
    private String groupNumber;

    @OneToOne
    @JoinColumn(name = "elder_id")
    private Student elder;

    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
