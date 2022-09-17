package su.goodcat.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.domain.dto.UserDTO;

@Mapper(config = MapstructConfig.class)
public interface UserMapper {

    @Mapping(source = "login", target = "name")
    User fromDtoToUser(UserDTO dto);
}
