package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import su.goodcat.commonlib.domain.UserSearchDTO;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.mapper.UserMapper;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.SearchUserService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SearchUserServiceImpl implements SearchUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserSearchDTO> getUserByQuery(String query) {
        List<User> userList = userRepository.getDistinctByNameOrEmail(query, query);
        return Mappers.getMapper(UserMapper.class).fromUserToUserSearchDTO(userList);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByLogin(name);
    }

    public long squareNumber(int a){
        return (long) a * a;
    }
}
