package com.construction.projets.client;


import com.construction.projets.dto.TaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "tasks")
public interface TaskServiceClient {
    @GetMapping("/api/tasks/project/{projectId}")
    List<TaskDTO> getTasksForProject(@PathVariable Long projectId);
}
