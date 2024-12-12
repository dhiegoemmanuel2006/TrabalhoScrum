package Scrum.BACK_END.repositories;

import Scrum.BACK_END.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    User findByEmail(String email);
    User findByUsername(String username);
}
