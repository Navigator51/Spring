package su.goodcat.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.lerndomain.Employee;
import su.goodcat.spring.domain.lerndomain.EmployeeDTO;

@Mapper(config = MapstructConfig.class)
public interface EmployeeMapper {

    void fromDtoToEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee a);
}
