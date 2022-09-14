package su.goodcat.spring.constants;

public final class DebugMessagesConstants {

    private DebugMessagesConstants() {
    }

    public static final String GET_EMPLOYEE_START = "[001]Начато получение сотрудника из базы по имени {}";
    public static final String GET_EMPLOYEE_FINISH = "[002]Завершено получение сотрудника из базы по имени {}";

    public static final String SAVE_USER_CONTROLLER_START = "[003]Начало регистрации нового пользователя с логином {}";

    public static final String SAVE_USER_CONTROLLER_FINISH = "[004]Завершена регистрация нового пользователя с логином {}";



}
