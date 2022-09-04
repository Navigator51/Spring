package su.goodcat.spring.mapper;

import org.mapstruct.*;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.domain.EmployeeDTO;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE,
builder = @Builder(disableBuilder = true))      // проверяем поля на null, если null, то не перекладываем
public interface EmployeeMapper {

    Employee fromDtoToEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee a);
}
