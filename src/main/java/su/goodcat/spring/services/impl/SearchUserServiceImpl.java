package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.goodcat.spring.domain.dto.UserSearchDTO;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.SearchUserService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SearchUserServiceImpl implements SearchUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserSearchDTO> getUserByQuery(String query) {
        return null;
    }
}
