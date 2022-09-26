package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.spring.domain.dto.UserSearchDTO;
import su.goodcat.spring.services.interfaces.SearchUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchUserController {

    private final SearchUserService searchUserServise;

    @GetMapping(path = "/api/v1/search/user")
    public ResponseEntity<List<UserSearchDTO>> searchUserByQuery(String query) {
        return ResponseEntity.ok(searchUserServise.getUserByQuery(query));
    }
}
