package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.domain.dto.UserInvitatorDTO;
import su.goodcat.spring.exceptions.HimselfInvitationException;
import su.goodcat.spring.mapper.UserInvitatorMapper;
import su.goodcat.spring.repositories.InvitationRepository;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.InvitationService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository invitationRepository;
    private final UserRepository userRepository;

    @Override
    public void putInvitation(Long senderId, Long recipientId, InvitationStatus status) {

        if (Objects.equals(senderId, recipientId)) {
            throw new HimselfInvitationException();
        }
        invitationRepository.save(new Invitation().setSenderId(senderId).setStatus(status).setRecipientId(recipientId));
    }

    @Override
    public List<UserInvitatorDTO> getInvitationsByUserId(Long userId) {
        List<Invitation> invitationList = invitationRepository.getInvitationsByRecipientIdAndStatus(userId, InvitationStatus.SENT);
        List<Long> listSenderId = invitationList.stream()
                        .map(Invitation::getSenderId)
                        .toList();
        List<User> userList = userRepository.findAllById(listSenderId);
        Map<Invitation, User> userMap = invitationList.stream()
                        .collect(Collectors.groupingBy(Function.identity(), inv ->
        Mappers.getMapper(UserInvitatorMapper.class).fromUserToUserInvitatorDTO()
        return null;
    }
}
