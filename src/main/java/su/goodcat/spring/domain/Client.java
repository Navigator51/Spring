package su.goodcat.spring.domain;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class)
public class Client extends Human {

    @Id
    private long id;

    @Embedded
    private Money money;

    @Convert(converter = EnumConverter.class, disableConversion = true)
    @Type(type = "postgresEnum")
    private Gender gender;

}
