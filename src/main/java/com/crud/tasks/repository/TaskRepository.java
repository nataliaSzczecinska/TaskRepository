package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Long taskId);
}