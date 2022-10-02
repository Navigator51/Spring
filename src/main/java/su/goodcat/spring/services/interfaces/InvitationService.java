package su.goodcat.spring.services.interfaces;

import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.domain.dto.UserInvitatorDTO;

import java.util.List;

public interface InvitationService {

    void putInvitation(Long senderId, Long recipientId, InvitationStatus status);

    List<UserInvitatorDTO> getInvitationsByUserId(Long userId);
}
