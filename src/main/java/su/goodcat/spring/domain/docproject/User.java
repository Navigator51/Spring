package su.goodcat.spring.domain.docproject;


import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;
import su.goodcat.spring.domain.lerndomain.Gender;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "plan")
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class) // создание типа данных для базы
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;

    @Column(nullable = false)
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    private String surname;

    @Column(name = "born_date")
    private LocalDate bornDate;

    @Type(type = "postgresEnum") // объявление типа данных для базы
    @Enumerated(EnumType.STRING) // запись енама в базу по значению
    private Gender gender;

    private String about;

    @Column(name = "creation_date_time")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "modify_date_time")
    @UpdateTimestamp
    private LocalDateTime modifyDateTime;

}
