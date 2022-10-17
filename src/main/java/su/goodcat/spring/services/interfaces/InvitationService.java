package su.goodcat.spring.services.interfaces;

import su.goodcat.commonlib.domain.UserInvitatorDTO;
import su.goodcat.spring.domain.docproject.InvitationStatus;

import java.util.List;

/**
 *  Сервис для работы с приглашениями.
 */
public interface InvitationService {

    /**
     * Метод сохраняет в базу данных приглашения.
     *
     * @param senderId ID отправителя приглашения
     * @param recipientId ID получателя приглашения
     * @param status Статус приглашения
     */
    void putInvitation(Long senderId, Long recipientId, InvitationStatus status);

    /**
     *  Метод для получения списка DTO пользователей, отправивших новые приглашения данному пользователю.
     *
     * @param userId ID пользователя, для которого получаем список приглашений
     * @return список DTO пользователей, отправивших приглашения
     */
    List<UserInvitatorDTO> getInvitationsByUserId(Long userId);

    void changeInvitationStatus(Long senderId, Long recipientId, String status);
}
