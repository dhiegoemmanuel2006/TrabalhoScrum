package Scrum.BACK_END.service;


import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<User> createUser(@RequestBody UserDTO user) throws Exception {
        try {
            User auxUser = new User(user);
            repository.save(auxUser);
            return ResponseEntity.ok(auxUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<User>> getAllUsers() throws Exception {
       try {
           List<User> users = repository.findAll();
           return ResponseEntity.ok(users);
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }
}
