package su.goodcat.spring.services.interfaces;

import su.goodcat.spring.domain.dto.UserSearchDTO;

import java.util.List;

public interface SearchUserService {

    List<UserSearchDTO> getUserByQuery(String query);
}
