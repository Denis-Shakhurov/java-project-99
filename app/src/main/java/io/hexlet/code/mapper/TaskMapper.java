package io.hexlet.code.mapper;

import io.hexlet.code.dto.TaskCreateDTO;
import io.hexlet.code.dto.TaskDTO;
import io.hexlet.code.dto.TaskUpdateDTO;
import io.hexlet.code.model.Label;
import io.hexlet.code.model.Task;
import io.hexlet.code.model.TaskStatus;
import io.hexlet.code.repository.LabelRepository;
import io.hexlet.code.repository.TaskStatusRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Mapping(target = "assignee.id", source = "assigneeId")
    @Mapping(target = "taskStatus.slug", source = "slug")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "description", source = "content")
    @Mapping(target = "labels", source = "labelIds")
    public abstract Task map(TaskDTO dto);

    @Mapping(target = "assignee", source = "assigneeId")
    @Mapping(target = "taskStatus", source = "slug")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "description", source = "content")
    @Mapping(target = "labels", source = "labelIds")
    public abstract Task map(TaskCreateDTO dto);

    @Mapping(source = "assignee.id", target = "assigneeId")
    @Mapping(source = "taskStatus.slug", target = "slug")
    @Mapping(source = "name", target = "title")
    @Mapping(source = "description", target = "content")
    @Mapping(source = "labels", target = "labelIds")
    public abstract TaskDTO map(Task model);

    @Mapping(target = "assignee", source = "assigneeId")
    @Mapping(target = "taskStatus", source = "slug")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "description", source = "content")
    @Mapping(target = "labels", source = "labelIds")
    public abstract void update(TaskUpdateDTO dto, @MappingTarget Task model);

    public List<Long> labelsToLong(List<Label> labels) {
        if (labels == null) {
            return new ArrayList<>();
        } else {
            return labels.stream()
                    .map(Label::getId)
                    .toList();
        }
    }

    public List<Label> longToLabel(List<Long> labelIds) {
        return labelIds.stream()
                .map(id -> labelRepository.findById(id).orElseThrow())
                .toList();
    }

    public TaskStatus toTaskStatus(String slug) {
        return taskStatusRepository.findBySlug(slug).orElseThrow();
    }
}
