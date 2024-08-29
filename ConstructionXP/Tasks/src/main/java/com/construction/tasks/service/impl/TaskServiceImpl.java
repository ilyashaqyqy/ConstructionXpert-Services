package com.construction.tasks.service.impl;

import com.construction.tasks.dto.TaskDTO;
import com.construction.tasks.model.Task;
import com.construction.tasks.mapper.TaskMapper;
import com.construction.tasks.repository.TaskRepository;
import com.construction.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceimpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.INSTANCE.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.INSTANCE.toDTO(savedTask);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        Task task = TaskMapper.INSTANCE.toEntity(taskDTO);
        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        return TaskMapper.INSTANCE.toDTO(updatedTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    public TaskDTO getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found");
        }
        return TaskMapper.INSTANCE.toDTO(task.get());
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public List<TaskDTO> getTasksByProjectId(Long projectId) {
        List<Task> tasks = taskRepository.findByProjetId(projectId);
        return tasks.stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
