package Scrum.BACK_END.entities;

import Scrum.BACK_END.DTOS.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name_user", nullable = false)
    private String name;

    @Column(name = "email_user", nullable = false, unique = true)
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    @Column(name = "senha", nullable = false)
    private String senha;

    public User(UserDTO data){
        this.name = data.name();
        this.email = data.email();
        this.senha = data.senha();
        this.funcao = data.funcao();
        this.username = data.username();
    }


}
