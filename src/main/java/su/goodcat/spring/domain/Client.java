package su.goodcat.spring.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client extends Human {

    @Id
    private long id;
    @Embedded
    private Money money;
}
