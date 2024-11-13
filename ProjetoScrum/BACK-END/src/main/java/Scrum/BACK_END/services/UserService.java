package Scrum.BACK_END.services;

import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Service
public class UserService {
    @Autowired
    private UserRepository uRepository; //repositório de usuários

    public ResponseEntity<List<String>> createUser(UserDTO request) throws Exception {
        List<String> exceptions = new ArrayList<>();
        if(uRepository.existsByEmail(request.email())){
            exceptions.add("Email já está sendo usado");
        }
        if(uRepository.existsByUsername(request.username())){
            exceptions.add("Username já está sendo usado!");
        }
        if(request.senha().length() < 6){
            exceptions.add("A senha necessita de mais de 6 caracteres!");
        }
        if(request.name().length() > 50 || !request.name().matches("^[a-zA-Z]+$")){
            exceptions.add("O nome deve ter menos de 50 caracteres, ter somente letras");
        }
        if(exceptions.size() > 0){
            return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
        }
        User saveUser = new User(request);
        uRepository.save(saveUser);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<User> login(String login, String password) throws Exception {
        if(!uRepository.existsByEmail(login) && !uRepository.existsByUsername(login)){
            throw new Exception("Não existe este cadastro!");
        }

        User user = uRepository.existsByEmail(login) ? uRepository.findByEmail(login) : uRepository.findByUsername(login);

        if(user.getSenha().equals(password)){
            return ResponseEntity.ok(user);
        } else {
            throw new Exception("Senha incorreta!");
        }
    }

}
