package su.goodcat.spring.exceptions;

public class HimselfInvitationException extends RuntimeException{


    @Override
    public String getMessage() {
        return "Пользователь отправил приглашение самому себе";
    }
}
