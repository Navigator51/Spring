package su.goodcat.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import su.goodcat.commonlib.domain.UserDTO;
import su.goodcat.commonlib.domain.UserSearchDTO;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.docproject.User;

import java.util.List;

@Mapper(config = MapstructConfig.class)
public interface UserMapper {

    @Mapping(source = "login", target = "name")
    User fromDtoToUser(UserDTO dto);

    UserSearchDTO fromUserToUserSearchDTO(User user);

    List<UserSearchDTO> fromUserToUserSearchDTO(List<User> userList);
}
