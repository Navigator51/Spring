package su.goodcat.spring.services.interfaces;

import su.goodcat.spring.domain.docproject.InvitationStatus;

public interface InvitationService {

    public void putInvitation(Long senderId, Long recipientId, InvitationStatus status);
}
