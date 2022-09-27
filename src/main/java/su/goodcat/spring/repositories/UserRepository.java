package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.goodcat.spring.domain.docproject.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String username);

    @Query("select distinct u from User u where u.name like %:name% or u.email like %:email%")
    List<User> getDistinctByNameOrEmail(String name, String email);
}
