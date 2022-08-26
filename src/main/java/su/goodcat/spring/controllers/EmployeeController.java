package su.goodcat.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import su.goodcat.spring.domain.Employee;
import su.goodcat.spring.services.EmployeeService;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "employee")

    public ResponseEntity<List<Employee>> getEmployeeListByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getEmployeeListByName(name));
    }
}
