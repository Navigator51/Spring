package su.goodcat.spring.domain.docproject;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import su.goodcat.spring.domain.lerndomain.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "plan")
// создание типа данных для базы
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class)
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

    // объявление типа данных для базы
    @Type(type = "postgresEnum")
    // запись енама в базу по значению
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String about;

    @Column(name = "creation_date_time")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "modify_date_time")
    @UpdateTimestamp
    private LocalDateTime modifyDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    // запись в объект через builder
    private Role role = Role.builder()
            .id(1L)
            .build();

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

    // cпециальный сеттер для поля пароль
    public void setPassword(String password) {
        // который запишет в базу пароль в зашифрованном виде
        this.password = new BCryptPasswordEncoder().encode(password);
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
