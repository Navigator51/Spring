package su.goodcat.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.InvitationStatus;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
