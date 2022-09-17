package su.goodcat.spring.domain.lerndomain;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@TypeDef(name = "postgresEnum", typeClass = PostgreSQLEnumType.class)
@Table(schema = "plan")
@PrimaryKeyJoinColumn(name = "human_id")
public class Client extends Human {

    @Embedded
    private Money money;

    @Convert(converter = EnumConverter.class, disableConversion = true)
    @Type(type = "postgresEnum")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //создаём поле, содержащее список (не entity) Для этого списка создаётся отдельная таблица, содержащая
    // значение списка и внешний ключ, ссылающийся на id клиента, которому принадлежит этот элесент списка.
    // т.е. таблица будет общая для всех клиентов, а выборка заказов из неё по id клиента.
    @ElementCollection
    // аннотация, указывающая на то, что это поле является коллекцией. она создаёт таблицу с одной калонкой.
    @Column(name = "order")
    // этой единственной колонке задали имя order
    @CollectionTable(schema = "plan", name = "order_list", joinColumns = @JoinColumn(name = "client_id"))
    // эта аннотация задаёт новой таблице имя (ордерЛист),
    // а вторым атрибутом добавляет ещё одну колонку с именем client_id
    private List<String> orderList;

    @ManyToMany
    @JoinTable(schema = "plan", name = "client_goods",
            joinColumns = @JoinColumn(name = "client_id"),
               inverseJoinColumns = @JoinColumn(name = "goods_id"))
    private List<Goods> goodsList;
}
