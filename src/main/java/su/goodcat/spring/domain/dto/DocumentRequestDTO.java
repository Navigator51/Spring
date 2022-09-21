package su.goodcat.spring.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import su.goodcat.spring.domain.docproject.FrontStatus;

@Getter
@RequiredArgsConstructor
public class DocumentRequestDTO {

    private final FrontStatus status;
}
