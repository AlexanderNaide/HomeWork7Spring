package ru.gb.homework7spring.model;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_s")
    private String name;

    @Column(name = "mark_s")
    private int mark;

    @OneToOne(mappedBy = "elder")
    private Group managedGroup;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
