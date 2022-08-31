package su.goodcat.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
//import javax.persistence.IdClass;
@Entity
@Getter
@Setter
@NoArgsConstructor
//@IdClass(su.goodcat.spring.domain.IdClass.class)
@Table(schema = "plan")
@PrimaryKeyJoinColumn(name = "human_id")
public class Employee extends Human {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_id")
    @JsonIgnore
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
