package io.hexlet.code.component;

import io.hexlet.code.dto.LabelCreateDTO;
import io.hexlet.code.dto.TaskStatusCreateDTO;
import io.hexlet.code.model.User;
import io.hexlet.code.repository.LabelRepository;
import io.hexlet.code.repository.TaskStatusRepository;
import io.hexlet.code.repository.UserRepository;
import io.hexlet.code.service.CustomUserDetailsService;
import io.hexlet.code.service.LabelService;
import io.hexlet.code.service.TaskStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var email = "hexlet@example.com";
        var userData = new User();
        userData.setEmail(email);
        userData.setPasswordDigest("qwerty");
        userDetailsService.createUser(userData);

        Map<String, String> taskStatuses = Map.of(
                "Draft", "draft",
                "toReview", "to_review",
                "toBeFixed", "to_be_fixed",
                "toPublish", "to_publish",
                "Published", "published"
        );
        //taskStatuses.forEach((key, value) -> taskStatusService.create(new TaskStatusCreateDTO(key, value)));
        var currentTaskStatusesSlug = taskStatusRepository.findAll().stream()
                .map(t -> t.getSlug())
                .toList();
        taskStatuses.keySet().stream()
                .filter(k -> !currentTaskStatusesSlug.contains(taskStatuses.get(k)))
                .forEach(k -> taskStatusService.create(new TaskStatusCreateDTO(k, taskStatuses.get(k))));

        List<String> labels = List.of("feature", "bug");

        var currentLabels = labelRepository.findAll().stream()
                .map(l -> l.getName())
                .toList();
        labels.stream()
                .filter(n -> !currentLabels.contains(n))
                .forEach(l -> labelService.create(new LabelCreateDTO(l)));
    }
}
