package su.goodcat.spring.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DebugMessagesConstants {
    public static final String GET_EMPLOYEE_START = "[SPR-D001] Начато получение сотрудника из базы по имени {}";
    public static final String GET_EMPLOYEE_FINISH = "[SPR-D002] Завершено получение сотрудника из базы по имени {}";
    public static final String SAVE_USER_CONTROLLER_START = "[SPR-D003] Начало регистрации нового пользователя с логином {}";
    public static final String SAVE_USER_CONTROLLER_FINISH = "[SPR-D004] Завершена регистрация нового пользователя с логином {}";
}
