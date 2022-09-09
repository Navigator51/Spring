package su.goodcat.spring.domain.docproject;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import su.goodcat.spring.domain.lerndomain.Gender;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "plan")
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class) // создание типа данных для базы
public class User implements UserDetails {

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

    @ManyToOne(fetch = FetchType.EAGER)
     private Role role;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
