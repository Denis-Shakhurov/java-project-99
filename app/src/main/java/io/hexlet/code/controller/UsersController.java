package io.hexlet.code.controller;

import io.hexlet.code.dto.UserCreateDTO;
import io.hexlet.code.dto.UserDTO;
import io.hexlet.code.dto.UserUpdateDTO;
import io.hexlet.code.mapper.UserMapper;
import io.hexlet.code.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "")
    public List<UserDTO> index() {
        var users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public UserDTO show(@PathVariable Long id) {
        var user = userRepository.findById(id).get();
        return userMapper.map(user);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO dto) {
        var user = userMapper.map(dto);
        userRepository.save(user);
        return userMapper.map(user);
    }

    @PutMapping(path = "/{id}")
    public UserDTO update(@RequestBody UserUpdateDTO dto, @PathVariable Long id) {
        var user = userRepository.findById(id).get();
        userMapper.update(dto, user);
        userRepository.save(user);
        return userMapper.map(user);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
