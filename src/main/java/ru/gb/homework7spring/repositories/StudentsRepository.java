package ru.gb.homework7spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.homework7spring.model.Student;


@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
}
