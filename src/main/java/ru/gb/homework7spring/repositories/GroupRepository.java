package ru.gb.homework7spring.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.homework7spring.model.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

//    @Transactional
//    Optional<Group> findById (Long id);

    Optional<Group> findByGroupNumber (String groupNumber);

    @Modifying
    @Query("select g.id, g.groupNumber from Group as g")
    List<Object[]> findListGroups();
}
