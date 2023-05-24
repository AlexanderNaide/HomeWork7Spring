package ru.gb.homework7spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.homework7spring.model.Student;

import java.util.List;


@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query("select s.id, s.name, s.mark, g.groupNumber from Student as s left join Group as g on s.group = g")
    List<Object[]> findListStudents();

    @Modifying
    @Query("select s.id, s.name, s.mark, g.groupNumber from Student as s left join Group as g on s.group = g where s.name like %?1% or g.groupNumber like %?1%")
    List<Object[]> searchListStudents(String searchValue);
}
