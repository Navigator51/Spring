package su.goodcat.spring.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessagesConstants {
    public static final String DELETE_EXISTED_USER_ERROR = "[SPR-E001] Сотрудник с таким ID  %s  не найден, проверьте правильность ввода!";
    public static final String BAD_VALUES_FORMAT_ERROR = "[SPR-E002] Неверный формат ввода данных";
    public static final String BAD_STATUS_FORMAT_ERROR = "[SPR-E003] Неверный формат статуса приглашения";


}
