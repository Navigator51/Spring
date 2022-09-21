package su.goodcat.spring.domain.docproject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public enum FrontStatus {

    INCOMING (List.of(Status.RECEIVED, Status.AGREED, Status.REJECTED)),
    OUTCOMING (List.of(Status.PREPARED, Status.SAND)),
    ALL (Arrays.stream(Status.values()).toList()),
    DRAFT (List.of(Status.DRAFT));

    @Getter
    private final List<Status> statusList;
}
