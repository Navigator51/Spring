package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.goodcat.commonlib.domain.UserDTO;
import su.goodcat.spring.mapper.UserMapper;
import su.goodcat.spring.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void saveNewUser(UserDTO userDTO) {
        userRepository.save(Mappers.getMapper(UserMapper.class).fromDtoToUser(userDTO));
    }
}
