package alpha1.o.com.genericeventmgtsystem.repository;


import alpha1.o.com.genericeventmgtsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}