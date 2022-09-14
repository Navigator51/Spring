package su.goodcat.spring.mapper;

import org.mapstruct.*;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.lerndomain.Employee;
import su.goodcat.spring.domain.lerndomain.EmployeeDTO;

@Mapper(config = MapstructConfig.class)      // проверяем поля на null, если null, то не перекладываем
public interface EmployeeMapper {

        void fromDtoToEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee a);
}
