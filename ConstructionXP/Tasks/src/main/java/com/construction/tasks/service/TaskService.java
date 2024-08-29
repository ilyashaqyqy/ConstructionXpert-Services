package com.construction.tasks.service;

import com.construction.tasks.dto.TaskDTO;
import com.construction.tasks.model.Task;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getAllTasks();
    List<TaskDTO> getTasksByProjectId(Long projectId);
}
