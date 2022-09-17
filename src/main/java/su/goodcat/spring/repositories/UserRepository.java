package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.goodcat.spring.domain.docproject.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String username);
}
