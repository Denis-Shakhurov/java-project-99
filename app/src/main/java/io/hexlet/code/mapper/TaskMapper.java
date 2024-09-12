package io.hexlet.code.mapper;

import io.hexlet.code.dto.TaskCreateDTO;
import io.hexlet.code.dto.TaskDTO;
import io.hexlet.code.dto.TaskUpdateDTO;
import io.hexlet.code.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {

    @Mapping(target = "assignee.id", source = "assigneeId")
    @Mapping(target = "taskStatus.slug", source = "taskStatusSlug")
    public abstract Task map(TaskDTO dto);

    @Mapping(target = "assignee.id", source = "assigneeId")
    @Mapping(target = "taskStatus.slug", source = "taskStatusSlug")
    public abstract Task map(TaskCreateDTO dto);

    @Mapping(source = "assignee.id", target = "assigneeId")
    @Mapping(source = "taskStatus.slug", target = "taskStatusSlug")
    public abstract TaskDTO map(Task model);

    public abstract void update(TaskUpdateDTO dto, @MappingTarget Task model);
}
