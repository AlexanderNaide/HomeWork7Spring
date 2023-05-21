package ru.gb.homework7spring.dao;

import lombok.Data;
import ru.gb.homework7spring.model.Group;
import ru.gb.homework7spring.model.Student;


@Data
public class StudentDao {

    private Long id;

    private String name;

    private int mark;

    private String group;

    public StudentDao(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.mark = student.getMark();
        this.group = student.getGroup().getGroupNumber();
    }
}
