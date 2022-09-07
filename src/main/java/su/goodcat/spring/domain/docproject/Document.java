package su.goodcat.spring.domain.docproject;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class)
@Table(schema = "plan")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "plan", name = "document_recipient", joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> recipients;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private List<File> fileList;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @Type(type = "postgresEnum") // объявление типа данных для базы
    @Enumerated(EnumType.STRING) // запись енама в базу по значению
    private Status status;
}
