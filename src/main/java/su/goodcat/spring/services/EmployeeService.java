package su.goodcat.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.domain.EmployeeDTO;
import su.goodcat.spring.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired //внедрение через setter
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //    @Autowired
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
    //  }

    public List<Employee> getEmployeeListByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }
    @Transactional
    public void saveNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDTO employee, Long id) {
        Optional<Employee> a = employeeRepository.findById(id);
    }
}
