package com.construction.projets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProjectWithTasksDTO {
    private ProjetDTO projet;
    private List<TaskDTO> tasks;

}
