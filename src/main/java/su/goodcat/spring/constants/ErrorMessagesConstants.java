package su.goodcat.spring.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessagesConstants {
    public static final String DELETE_EXISTED_USER_ERROR = "[SPR-E001] Сотрудник с таким ID  %s  не найден, проверьте правильность ввода!";
}
