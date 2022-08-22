package su.goodcat.spring.domain;

import lombok.*;

import javax.persistence.*;
//import javax.persistence.IdClass;


@Entity
@Getter
@Setter
@NoArgsConstructor
//@IdClass(su.goodcat.spring.domain.IdClass.class)

public class Employee extends Human{



    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee chief;

    @Column(nullable = false)
    private String name;

    private long salary;
    @Transient // указывает, что это поле не вносится в базу данных
    private String temporary;

//    @Id
//    private int inn;
//    @Id
//    private int kpp;
    // закоментированные поля - пример создания составного primary key

}
