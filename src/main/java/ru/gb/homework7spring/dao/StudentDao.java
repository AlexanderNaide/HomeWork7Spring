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

    public StudentDao(Object[] rows) {
        this.id = (Long) rows[0];
        this.name = (String) rows[1];
        this.mark = (int) rows[2];
        this.group = (String) rows[3];
    }
}
