package com.construction.tasks.repository;

import com.construction.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjetId(Long projetId);
}
