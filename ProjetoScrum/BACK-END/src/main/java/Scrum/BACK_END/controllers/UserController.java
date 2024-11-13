package Scrum.BACK_END.controllers;


import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    @PostMapping("/create")
    public ResponseEntity<List<String>> createUser(@RequestBody UserDTO userDTO) throws Exception {
        return uService.createUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody String login, @RequestBody String password) throws Exception {
        return uService.login(login, password);
    }
}