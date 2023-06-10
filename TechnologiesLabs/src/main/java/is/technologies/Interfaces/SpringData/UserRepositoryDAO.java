package is.technologies.Interfaces.SpringData;

import is.technologies.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepositoryDAO extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}