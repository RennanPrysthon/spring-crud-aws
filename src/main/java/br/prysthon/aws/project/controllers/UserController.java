package br.prysthon.aws.project.controllers;

import br.prysthon.aws.project.dtos.UserDTO;
import br.prysthon.aws.project.response.Response;
import br.prysthon.aws.project.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("")
    public ResponseEntity<Response<Page<UserDTO>>> getAllUser(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "1") Integer size
    ) {
        Response<Page<UserDTO>> response = new Response<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<UserDTO> pageUsers = this.service.getAllUsers(pageable);
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setData(pageUsers);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> getUserById(@PathVariable("id") Long id) {
        Response<UserDTO> response = new Response<>();
        UserDTO user = service.findUserById(id);
        response.setData(user);
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("")
    public ResponseEntity<Response<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
        Response<UserDTO> response = new Response<>();
        UserDTO user = this.service.save(userDTO);
        response.setStatus(HttpStatus.CREATED.value());
        response.setData(user);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
