package ru.gb.homework7spring.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework7spring.model.Group;
import ru.gb.homework7spring.repositories.GroupRepository;
import ru.gb.homework7spring.repositories.StudentsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

//    private final StudentService studentService;

    public void save(Group group){
        groupRepository.save(group);
    }

    public Group getGroup(Long id){
        return groupRepository.findById(id).orElse(null);
    }

}
