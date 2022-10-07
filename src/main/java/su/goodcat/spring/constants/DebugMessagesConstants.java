package su.goodcat.spring.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DebugMessagesConstants {
    public static final String GET_EMPLOYEE_START = "[SPR-D001] Начато получение сотрудника из базы по имени {}";
    public static final String GET_EMPLOYEE_FINISH = "[SPR-D002] Завершено получение сотрудника из базы по имени {}";
    public static final String SAVE_USER_CONTROLLER_START = "[SPR-D003] Начало регистрации нового пользователя с логином {}";
    public static final String SAVE_USER_CONTROLLER_FINISH = "[SPR-D004] Завершена регистрация нового пользователя с логином {}";
    public static final String SAVE_INVITATION_START = "[SPR-D005] Начало сохранения нового приглашения в базу";
    public static final String SAVE_INVITATION_FINISH = "[SPR-D006] Завершено сохранения нового приглашения в базу";
    public static final String GET_INVITATION_LIST_START = "[SPR-D007] Начато получение списка приглашений";
    public static final String GET_INVITATION_LIST_FINISH = "[SPR-D008] Завершено получение списка приглашений";
}
