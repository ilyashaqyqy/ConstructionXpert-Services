package com.construction.tasks.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String resources;
    private Long projetId ;


}
