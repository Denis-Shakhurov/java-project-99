package io.hexlet.code.service;

import io.hexlet.code.dto.TaskCreateDTO;
import io.hexlet.code.dto.TaskDTO;
import io.hexlet.code.dto.TaskParamDTO;
import io.hexlet.code.dto.TaskUpdateDTO;
import io.hexlet.code.exception.ResourceNotFoundException;
import io.hexlet.code.mapper.TaskMapper;
import io.hexlet.code.repository.TaskRepository;
import io.hexlet.code.specification.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskSpecification specBuilder;

    public List<TaskDTO> getAll(TaskParamDTO params) {
        var spec = specBuilder.build(params);
        var tasks = taskRepository.findAll(spec);
        return tasks.stream()
                .map(taskMapper::map)
                .toList();
    }

    public TaskDTO show(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        return taskMapper.map(task);
    }

    public TaskDTO create(TaskCreateDTO dataDTO) {
        var task = taskMapper.map(dataDTO);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    public TaskDTO update(TaskUpdateDTO dataDTO, Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        taskMapper.update(dataDTO, task);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
