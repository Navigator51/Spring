package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import su.goodcat.spring.domain.lerndomain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select emp from Employee emp  join fetch emp.department dep where emp.name = :name")
    List<Employee> getEmployeeByName(String name);
}
