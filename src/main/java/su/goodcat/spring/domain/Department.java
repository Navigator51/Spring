package su.goodcat.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Department {
    @Id
    private long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    @Column(nullable = false)
    private String name;

}
