package com.construction.tasks.mapper;

import com.construction.tasks.dto.TaskDTO;
import com.construction.tasks.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toDTO(Task task);

    Task toEntity(TaskDTO taskDTO);
}
