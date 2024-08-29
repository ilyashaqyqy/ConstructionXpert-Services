package com.construction.projets.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private Long id;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String resources;
    private Long projetId;
}