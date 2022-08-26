package su.goodcat.spring.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "plan")
public class Human {

    @Id
    private long id;

    public LocalDate birthday;

    @Column(name = "born_place", length = 30)
    public String bornPlace = "Higher Canibalovka";

    @CreationTimestamp
    @Column(name = "creation_date_time")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date_time")
    private LocalDateTime lastModifiedDate;

}
