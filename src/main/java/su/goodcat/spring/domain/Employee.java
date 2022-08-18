package su.goodcat.spring.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Employee extends Human{

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
