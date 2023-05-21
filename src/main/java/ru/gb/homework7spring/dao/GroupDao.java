package ru.gb.homework7spring.dao;

import lombok.Data;
import ru.gb.homework7spring.model.Group;
import ru.gb.homework7spring.model.Student;

import java.util.List;

@Data
public class GroupDao {

    private long id;

    private String groupNumber;

    private StudentDao elder;

    private List<StudentDao> students;

    public GroupDao(Group group) {
        this.id = group.getId();
        this.groupNumber = group.getGroupNumber();
        this.elder = new StudentDao(group.getElder());
        this.students = group.getStudents().stream().map(StudentDao::new).toList();
    }
}
