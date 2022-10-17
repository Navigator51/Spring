package su.goodcat.spring.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import su.goodcat.commonlib.domain.UserInvitatorDTO;
import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.InvitationService;

import java.util.List;

import static su.goodcat.spring.constants.DebugMessagesConstants.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvitationController {

    private final InvitationService invitationService;
    private final UserRepository userRepository;

    @PutMapping(path = "/api/v1/user/{recipientId}/invitation")
    public ResponseEntity<Void> sendInvitation(@PathVariable Long recipientId, @AuthenticationPrincipal UserDetails userDetails) {
        log.debug(SAVE_INVITATION_START);
        Long senderId = userRepository.getUserByLogin(userDetails.getUsername()).getId();
        invitationService.putInvitation(senderId, recipientId, InvitationStatus.SENT);
        log.debug(SAVE_INVITATION_FINISH);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path ="/api/v1/user/invitation")
    public ResponseEntity<List<UserInvitatorDTO>> getInvitationsForCurrentUser(@Parameter(hidden = true)@AuthenticationPrincipal UserDetails userDetails) {
        log.debug(GET_INVITATION_LIST_START);
        Long userId = userRepository.getUserByLogin(userDetails.getUsername()).getId();
        List<UserInvitatorDTO> result = invitationService.getInvitationsByUserId(userId);
        log.debug(GET_INVITATION_LIST_FINISH);
        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/api/v1/user/{senderId}/invitation/{status}")
    public ResponseEntity<Void> changeInvitationStatus(@PathVariable Long senderId, @AuthenticationPrincipal UserDetails userDetails, @PathVariable String status) {
        Long recipientId = userRepository.getUserByLogin(userDetails.getUsername()).getId();
        invitationService.changeInvitationStatus(senderId, recipientId, status);
        return ResponseEntity.ok().build();
    }


}
