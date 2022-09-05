package su.goodcat.spring.mapper;

import org.mapstruct.*;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.domain.EmployeeDTO;

@Mapper(config = MapstructConfig.class)      // проверяем поля на null, если null, то не перекладываем
public interface EmployeeMapper {

    @Mapping(source = "employeeDTO.name", target = "a.name")
    void fromDtoToEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee a);
}
