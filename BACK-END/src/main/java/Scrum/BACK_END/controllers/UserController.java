package Scrum.BACK_END.controllers;

import Scrum.BACK_END.entities.User;
import Scrum.BACK_END.service.UserService;
import Scrum.BACK_END.DTOS.UserDTO;
import Scrum.BACK_END.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService services;

    @RequestMapping(value = "/cadastrarUser", method = RequestMethod.GET)
    public ModelAndView formEvento() {
        return new ModelAndView("index.html"); // Certifique-se de que "index" é o nome correto do template HTML
    }

    @RequestMapping(value = "/cadastrarUser", method = RequestMethod.POST)
    public String form(@Validated UserDTO userDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarUser";
        }

        User user = new User(userDTO);  // Converte o DTO para User
        repository.save(user);
        attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");

        return "redirect:/user"; // Redireciona para a lista de usuários
    }

    @RequestMapping("/user")
    public ModelAndView listarUser() {
        ModelAndView mv = new ModelAndView("index"); // "index" é o template HTML que renderiza a lista de usuários
        Iterable<User> users = repository.findAll(); // Busca todos os usuários do banco de dados
        mv.addObject("user", users); // Adiciona a lista de usuários ao modelo
        return mv; // Retorna a view com os dados
    }

}
