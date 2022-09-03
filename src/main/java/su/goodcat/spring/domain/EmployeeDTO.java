package su.goodcat.spring.domain;

import lombok.Value;

import java.time.LocalDate;
@Value
public class EmployeeDTO {

    LocalDate birthday;
    String bornPlace;
    String name;
    Long salary;


}
