package com.hexagonal.demo.infrastructure.adapters.in;

import com.hexagonal.demo.application.dto.UserRequestDTO;
import com.hexagonal.demo.application.dto.UserResponseDTO;
import com.hexagonal.demo.application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO response = userService.save(requestDTO);
        return ResponseEntity.created(URI.create("/api/users/" + response.getId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findOne(@PathVariable Long id) {
        UserResponseDTO response = userService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO response = userService.update(requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
