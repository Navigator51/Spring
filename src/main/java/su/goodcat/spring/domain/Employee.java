package su.goodcat.spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Employee {

    @Id
    private long id;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Employee chief;

    @Column(nullable = false)
    private String name;

    private long salary;

}
