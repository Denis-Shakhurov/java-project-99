package io.hexlet.code.controller;

import io.hexlet.code.dto.TaskStatusCreateDTO;
import io.hexlet.code.dto.TaskStatusDTO;
import io.hexlet.code.dto.TaskStatusUpdateDTO;
import io.hexlet.code.service.TaskStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskStatusesController {

    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping(path = "/task_statuses")
    public ResponseEntity<List<TaskStatusDTO>> index() {
        var taskStatuses = taskStatusService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(taskStatuses.size()))
                .body(taskStatuses);
    }

    @GetMapping(path = "/task_statuses/{id}")
    public TaskStatusDTO show(@PathVariable Long id) {
        return taskStatusService.show(id);
    }

    @PostMapping(path = "/task_statuses")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskStatusDTO create(@Valid @RequestBody TaskStatusCreateDTO dataDTO) {
        return taskStatusService.create(dataDTO);
    }

    @PutMapping(path = "/task_statuses/{id}")
    public TaskStatusDTO update(@Valid @RequestBody TaskStatusUpdateDTO dataDTO, @PathVariable Long id) {
        return taskStatusService.update(dataDTO, id);
    }

    @DeleteMapping(path = "/task_statuses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        taskStatusService.delete(id);
    }
}
