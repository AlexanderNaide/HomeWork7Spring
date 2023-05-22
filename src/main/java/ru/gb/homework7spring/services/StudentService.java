package ru.gb.homework7spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework7spring.model.Student;
import ru.gb.homework7spring.repositories.StudentsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentsRepository studentsRepository;

//    private final GroupService groupService;

    public void save(Student student){
        studentsRepository.save(student);
    }

    public Student findById(Long id){
        return studentsRepository.findById(id).orElse(null);
    }

    public List<Object[]> findAll(){
        return studentsRepository.findListStudents();
    }
}
