package su.goodcat.spring.services.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.goodcat.commonlib.domain.UserInvitatorDTO;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.exceptions.BadStatusException;
import su.goodcat.spring.exceptions.HimselfInvitationException;
import su.goodcat.spring.mapper.UserInvitatorMapper;
import su.goodcat.spring.repositories.InvitationRepository;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.InvitationService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        UserInvitatorMapper mapper = Mappers.getMapper(UserInvitatorMapper.class);
        List<Invitation> invitationList = invitationRepository.getInvitationsByRecipientIdAndStatus(userId, InvitationStatus.SENT);

        // Достаём из списка приглашений список id юзеров, отправивших эти приглашения
        List<Long> listSenderId = invitationList.stream()
                .map(Invitation::getSenderId)
                .distinct()
                .toList();

        List<User> userList = userRepository.findAllById(listSenderId);

        // Сосздаём мапу для сохранения связки id отправителя приглашения и приглашения
        Map<Long, Invitation> invitationMap = invitationList.stream()
                .collect(Collectors.toMap(Invitation::getSenderId, inv -> inv));

        // Мапим в сприсок ДТО для отправки на фронт
        return userList.stream()
                .map(user -> mapper.fromUserToUserInvitatorDTO(user, invitationMap.get(user.getId())))
                .toList();

    }

    @Override
    @Transactional
    public void changeInvitationStatus(Long senderId, Long recipientId, String status) {
        try {
            InvitationStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException badStatus) {
            throw new BadStatusException();
        }
       Invitation invitation = invitationRepository.getInvitationBySenderIdAndRecipientId(senderId, recipientId);
       invitation.setStatus(InvitationStatus.valueOf(status.toUpperCase()));
    }
}
