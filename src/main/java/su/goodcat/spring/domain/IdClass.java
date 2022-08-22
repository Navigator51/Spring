package su.goodcat.spring.domain;
/*  класс создан для создания составного ключа primary key для какой-нибудь таблице в базе данных
* например, ключом может быть связка колонок  ИНН/КПП */

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode

public class IdClass implements Serializable {
     private int inn;
     private int kpp;

}
