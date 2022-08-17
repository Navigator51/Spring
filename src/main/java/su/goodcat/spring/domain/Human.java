package su.goodcat.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Human {

    @Id
    private long id;

    public LocalDate birthday;

    @Column(name = "born_place", length = 30)
    public String bornPlace = "Higher Canibalovka";
}
