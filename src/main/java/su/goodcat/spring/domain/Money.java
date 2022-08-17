package su.goodcat.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class Money {

    private long cash;

    @Column(length = 30)
    private String valuta;
}
