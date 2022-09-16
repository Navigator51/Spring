package su.goodcat.spring.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.goodcat.spring.constants.DebugMessagesConstants;
import su.goodcat.spring.domain.dto.UserDTO;
import su.goodcat.spring.services.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/api/v1/registry/controller")
    public ResponseEntity<Void> saveNewUser(@RequestBody UserDTO userDTO) {
        log.debug(DebugMessagesConstants.SAVE_USER_CONTROLLER_START, userDTO.getLogin());
        userService.saveNewUser(userDTO);
        log.debug(DebugMessagesConstants.SAVE_USER_CONTROLLER_FINISH, userDTO.getLogin());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
