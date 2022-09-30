package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.exceptions.HimselfInvitationException;
import su.goodcat.spring.repositories.InvitationRepository;
import su.goodcat.spring.services.interfaces.InvitationService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository invitationRepository;

    @Override
    public void putInvitation(Long senderId, Long recipientId, InvitationStatus status) {

        if (Objects.equals(senderId, recipientId)) {
            throw new HimselfInvitationException();
        }
        invitationRepository.save(new Invitation().setSenderId(senderId).setStatus(status).setRecipient_id(recipientId));
    }
}
