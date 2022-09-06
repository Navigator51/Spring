package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.goodcat.spring.domain.lerndomain.Employee;
import su.goodcat.spring.domain.lerndomain.EmployeeDTO;
import su.goodcat.spring.services.EmployeeService;
import java.util.List;

import static su.goodcat.spring.constants.DebugMessagesConstants.GET_EMPLOYEE_FINISH;
import static su.goodcat.spring.constants.DebugMessagesConstants.GET_EMPLOYEE_START;

@RestController//отличается от контроллера тем, что отдаёт JSON, а не готовую HTML страницу
@RequiredArgsConstructor //внедрение зависимостей для всех private final полей через конструнстрор (Ломбок сахар)
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping(path = "employee")
    public ResponseEntity<List<Employee>> getEmployeeListByName(@RequestParam String name) {
        log.debug(GET_EMPLOYEE_START,name);
        ResponseEntity<List<Employee>> result = ResponseEntity.ok(employeeService.getEmployeeListByName(name));
        log.debug(GET_EMPLOYEE_FINISH, name);
        return result;
    }

    @PostMapping(path = "employee/save")
    public ResponseEntity<Void> saveNewEmployee(@RequestBody Employee employee) {
        employeeService.saveNewEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.OK); // с Java 9 можно не писать тип дженерика внутри < > при созданиии new.
                                                        // В нашем случае <Void>. Такая возможность названа Алмазный Оператор
    }

    @PutMapping(path = "employee/{id}/update")
    public ResponseEntity<Void> putEmployee(@RequestBody EmployeeDTO employee, @PathVariable("id") Long id) {
        employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "employee/{id}/delete")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

}
