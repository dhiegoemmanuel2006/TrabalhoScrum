package Scrum.BACK_END.controllers;

import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.service.UserService;
import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService services;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO user) throws Exception {
        System.out.println("Tentativa de cadastro");
        return services.createUser(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws Exception {
        return services.getAllUsers();
    }

}
