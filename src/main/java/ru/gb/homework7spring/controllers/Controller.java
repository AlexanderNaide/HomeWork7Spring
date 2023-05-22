package ru.gb.homework7spring.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.homework7spring.dao.GroupDao;
import ru.gb.homework7spring.dao.StudentDao;
import ru.gb.homework7spring.model.Group;
import ru.gb.homework7spring.model.Student;
import ru.gb.homework7spring.services.GroupService;
import ru.gb.homework7spring.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class Controller {

    private final StudentService studentService;

    private final GroupService groupService;

//    @PostConstruct
//    private void init(){
//
//        for (int i = 0; i < 17; i++) {
//            Group group = new Group();
//            group.setGroupNumber("mash23_" + (i + 1));
//            groupService.save(group);
//        }
//
//        // создание 500 студентов
//        for (int i = 0; i < 500; i++) {
//            Student student = new Student();
//            student.setName("Student №" + (i + 1));
//            Group currentGroup = groupService.getGroup((long) (Math.random() * 17) + 1);
//            student.setGroup(currentGroup);
//            studentService.save(student);
//            if(currentGroup.getElder() == null){
//                currentGroup.setElder(student);
//                groupService.save(currentGroup);
//            }
//        }
//
//        // изменение - накидаем 200 произвольным студентам до 50 баллов
//        for (int i = 0; i < 200; i++) {
//            Student student = studentService.findById((long) (Math.random() * 500) + 1);
//            student.setMark((int) (Math.random() * 50) + 1);
//            studentService.save(student);
//        }
//    }

    @GetMapping("/group")
    public GroupDao getGroup(@RequestParam Long id){
        Group group = groupService.getGroup(id);
        if (group != null){
            return new GroupDao(groupService.getGroup(id));
        } else {
            return null;
        }
    }

    @GetMapping
    public List<StudentDao> getStudents(){
        return studentService.findAll().stream().map(StudentDao::new).toList();
    }

    @GetMapping("/{id}")
    public StudentDao getStudent(@RequestParam Long id){
        return new StudentDao(studentService.findById(id));
    }


}
