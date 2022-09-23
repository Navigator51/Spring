package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.goodcat.spring.domain.lerndomain.Employee;
import su.goodcat.spring.domain.lerndomain.EmployeeDTO;
import su.goodcat.spring.services.impl.EmployeeService;
import java.util.List;

import static su.goodcat.spring.constants.DebugMessagesConstants.GET_EMPLOYEE_FINISH;
import static su.goodcat.spring.constants.DebugMessagesConstants.GET_EMPLOYEE_START;

//отличается от контроллера тем, что отдаёт JSON, а не готовую HTML страницу
@RestController
//внедрение зависимостей для всех private final полей через конструктор (Lombok синтаксический сахар)
@RequiredArgsConstructor
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
        // с Java 9 можно не писать тип дженерика внутри <> при создании нового объекта через new. В нашем случае <Void>. Такая возможность названа Алмазный Оператор
        return new ResponseEntity<>(HttpStatus.OK);
                                                        //
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
