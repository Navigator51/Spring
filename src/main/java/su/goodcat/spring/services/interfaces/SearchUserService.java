package su.goodcat.spring.services.interfaces;

import su.goodcat.commonlib.domain.UserSearchDTO;
import su.goodcat.spring.domain.docproject.User;

import java.util.List;

public interface SearchUserService {

    List<UserSearchDTO> getUserByQuery(String query);

    User getUserById(long id);

    User getUserByName(String name);
}
