package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.domain.EmployeeDTO;
import su.goodcat.spring.services.EmployeeService;
import java.util.List;

@RestController//отличается от контроллера тем, что отдаёт JSON, а не готовую HTML страницу
@RequiredArgsConstructor //внедрение зависимостей для всех private final полей через конструнстрор (Ломбок сахар)
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping(path = "employee")
    public ResponseEntity<List<Employee>> getEmployeeListByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getEmployeeListByName(name));
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

}
