package su.goodcat.spring.domain.lerndomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
//import javax.persistence.IdClass;
@Entity
@Getter
@Setter
@NoArgsConstructor
//@IdClass(su.goodcat.spring.domain.lerndomain.IdClass.class)
@Table(schema = "plan")
@PrimaryKeyJoinColumn(name = "human_id")
public class Employee extends Human {

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_id")
    @JsonIgnore
    private Employee chief;

    @Column(nullable = false)
    private String name;

    private int salary;

    // указывает, что это поле не вносится в базу данных
    @Transient
    private String temporary;

//    @Id
//    private int inn;
//    @Id
//    private int kpp;
    // закомментированные поля - пример создания составного primary key

}
