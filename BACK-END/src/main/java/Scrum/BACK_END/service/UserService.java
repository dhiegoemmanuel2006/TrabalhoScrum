package Scrum.BACK_END.service;


import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.ExceptionHandler.EmailAlreadyUsedException;
import Scrum.BACK_END.ExceptionHandler.PhoneAlreadyUsedException;
import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.ExceptionHandler.ErrorResponse;
import Scrum.BACK_END.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<Object> createUser(UserDTO user) throws Exception {
        try {
            User auxUser = new User(user);
            CheckEmail(auxUser);
            CheckPhone(auxUser);
            repository.save(auxUser);
            return ResponseEntity.ok(auxUser);
        } catch (EmailAlreadyUsedException | PhoneAlreadyUsedException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
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

    public void CheckEmail(User request) {
        if(repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyUsedException("O email já está em uso!");
        }
    }

    public void CheckPhone(User request) {
        if(repository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new PhoneAlreadyUsedException("O Phone já está em uso!");
        }
    }
}
