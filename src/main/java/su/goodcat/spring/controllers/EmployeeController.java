package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.services.EmployeeService;
import java.util.List;

@Controller
@RequiredArgsConstructor //внедрение зависимостей для всех private Final полей через конструнстрор (Ломбок сахар)
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping(path = "employee")

    public ResponseEntity<List<Employee>> getEmployeeListByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getEmployeeListByName(name));
    }
}
