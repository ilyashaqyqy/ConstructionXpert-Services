package com.construction.tasks.mapper;

import com.construction.tasks.dto.TaskDTO;
import com.construction.tasks.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "projetId", target = "projetId")
    TaskDTO toDTO(Task task);

    @Mapping(source = "projetId", target = "projetId")
    Task toEntity(TaskDTO taskDTO);
}
