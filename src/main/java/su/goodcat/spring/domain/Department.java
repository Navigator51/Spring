package su.goodcat.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Access(AccessType.FIELD)

public class Department {

    // @GeneratedValue(strategy = GenerationType.SEQUENCE) - выбирает стратегию автогенерации id
    @Id
    private long id;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Employee> employeeList;

    @Column(nullable = false, length = 20)
    private String name;

    /*аннотация @Basic неявно присутствует над каждым полем в энтити. Она имеет по умолчанию 2 атрибута:
    * FetchType.EAGER
     и optional = true, что значит, что поле может быть null*/

    /* аннотация  @Access  позволяет вносить(извлекать) данные в базу через нестандартные геттеры и сеттеры.
    * имеет 2 типа доступа: FIELD (доступ из поля) и PROPERTY (доступ через геттер и сеттер)*/

}
