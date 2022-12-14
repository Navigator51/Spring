package su.goodcat.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import su.goodcat.commonlib.domain.UserInvitatorDTO;
import su.goodcat.spring.config.MapstructConfig;
import su.goodcat.spring.domain.docproject.Invitation;
import su.goodcat.spring.domain.docproject.User;

@Mapper(config = MapstructConfig.class)
public interface UserInvitatorMapper {

    @Mapping(source = "user.name", target = "senderName")
    @Mapping(source = "user.middleName", target = "senderMiddleName")
    @Mapping(source = "user.surname", target = "senderSurname")
    @Mapping(source = "user.id", target = "senderId")
    @Mapping(source = "invitation.creationDate", target = "invitationCreationDate")
    UserInvitatorDTO fromUserToUserInvitatorDTO(User user, Invitation invitation);
}
