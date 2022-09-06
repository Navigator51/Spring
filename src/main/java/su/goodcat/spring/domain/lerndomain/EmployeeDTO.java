package su.goodcat.spring.domain.lerndomain;

// класс для создания промежуточного объекта employee, хранящего сведения о полях, полученных из JSON с фронта, которые
// необходимо изменить в базе данных на хранимом там объекте.
import lombok.Value;
import java.time.LocalDate;

@Value  // аннотация, содержащая в себе много других, и объявляющая все поля класса private final !!!
public class EmployeeDTO {

    LocalDate birthday;
    String bornPlace;
    String name;
    Long salary;


}
