package su.goodcat.spring.domain.dto;

import lombok.Value;
import su.goodcat.spring.domain.docproject.EnumRole;
import su.goodcat.spring.domain.docproject.Role;


@Value
public class UserDTO {

    String login;
    String password;

}
