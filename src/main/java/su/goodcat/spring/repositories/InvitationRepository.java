package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.InvitationStatus;

import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    List<Invitation> getInvitationsByRecipientIdAndStatus(Long recipientID, InvitationStatus status);

    Invitation getInvitationBySenderIdAndRecipientId(Long senderId, Long recipientId);
}
