package su.goodcat.spring.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.goodcat.spring.domain.lerndomain.Employee;
import su.goodcat.spring.domain.lerndomain.EmployeeDTO;
import su.goodcat.spring.exceptions.EmployeeNotFoundException;
import su.goodcat.spring.mapper.EmployeeMapper;
import su.goodcat.spring.repositories.EmployeeRepository;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    //внедрение через setter
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeListByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    @Transactional
    public void saveNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(EmployeeDTO employee, Long id) {
        // eсли объекта с заданным id в базе не существует, выбрасываем исключение, прописанное в нашем классе исключений
        Employee a = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        // перекладываем значения из DTO через маппер
        Mappers.getMapper(EmployeeMapper.class).fromDtoToEmployee(employee, a);
    }

    @Transactional
    public void deleteEmployeeById(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            log.error("Этого до тебя удалили!");
            throw new EmployeeNotFoundException(id);
        }
    }
}
