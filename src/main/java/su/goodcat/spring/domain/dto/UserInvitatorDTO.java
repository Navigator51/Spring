package su.goodcat.spring.domain.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor
@Builder
public class UserInvitatorDTO {

    Long senderId;
    String senderName;
    String senderMiddleName;
    String senderSurname;
    LocalDateTime invitationCreationDate;

}
