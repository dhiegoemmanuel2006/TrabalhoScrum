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
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;

    public User(UserDTO data){
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
    }
}
