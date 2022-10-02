package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.spring.domain.docproject.InvitationStatus;
import su.goodcat.spring.domain.dto.UserInvitatorDTO;
import su.goodcat.spring.repositories.UserRepository;
import su.goodcat.spring.services.interfaces.InvitationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;
    private final UserRepository userRepository;

    @PutMapping(path = "/api/v1/user/{recipientId}/invitation")
    public ResponseEntity<Void> sendInvitation(@PathVariable Long recipientId, @AuthenticationPrincipal UserDetails userDetails) {
        Long senderId = userRepository.getUserByLogin(userDetails.getUsername()).getUserId();
        invitationService.putInvitation(senderId, recipientId, InvitationStatus.SENT);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path ="/api/v1/user/invitation")
    public ResponseEntity<List<UserInvitatorDTO>> getInvitationsForCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        Long userId = userRepository.getUserByLogin(userDetails.getUsername()).getUserId();
        return ResponseEntity.ok(invitationService.getInvitationsByUserId(userId));
    }
}
