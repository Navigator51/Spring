package su.goodcat.spring.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeNotFoundException extends RuntimeException {

    private final long id;

    @Override
    public String getMessage() {

        return String.format("Сотрудник с таким ID  %s  не найден, проверьте правильность ввода!", id);
    }
}
