package su.goodcat.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.domain.dto.UserDTO;

import javax.crypto.spec.PSource;

@Mapper(config = MapstructConfig.class)
public interface UserMapper {

    @Mapping(source = "login", target = "name")
    public User fromDtoToUser(UserDTO dto);
}
