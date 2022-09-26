package su.goodcat.spring.domain.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class UserSearchDTO {

    String name;
    String email;
    long id;
}
