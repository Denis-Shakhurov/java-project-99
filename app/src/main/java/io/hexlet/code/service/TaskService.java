package io.hexlet.code.service;

import io.hexlet.code.dto.TaskCreateDTO;
import io.hexlet.code.dto.TaskDTO;
import io.hexlet.code.dto.TaskUpdateDTO;
import io.hexlet.code.exception.ResourceNotFoundException;
import io.hexlet.code.mapper.TaskMapper;
import io.hexlet.code.repository.TaskRepository;
import io.hexlet.code.repository.TaskStatusRepository;
import io.hexlet.code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> getAll() {
        var tasks = taskRepository.findAll();
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
        var taskStatus = taskStatusRepository.findBySlug(dataDTO.getStatus())
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus not found"));
        var assignee = userRepository.findById(dataDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        task.setTaskStatus(taskStatus);
        task.setAssignee(assignee);
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
        var task = taskRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        var user = task.getAssignee();
        user.removeTask(task);
        taskRepository.deleteById(id);
    }
}
