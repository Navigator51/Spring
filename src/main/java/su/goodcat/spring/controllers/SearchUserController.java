package su.goodcat.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import su.goodcat.commonlib.domain.UserSearchDTO;
import su.goodcat.spring.domain.docproject.User;
import su.goodcat.spring.services.interfaces.SearchUserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchUserController {

    private final SearchUserService searchUserServise;

    @GetMapping(path = "/api/v1/search/user")
    public ResponseEntity<List<UserSearchDTO>> searchUserByQuery(@RequestParam String query) {
        return ResponseEntity.ok(searchUserServise.getUserByQuery(query));
    }

    @GetMapping(path = "/api/v1/search/user/{id}")
    public ResponseEntity <User> searchUserById(@PathVariable long id) {
        return ResponseEntity.ok(searchUserServise.getUserById(id));
    }

    @GetMapping(path = "/api/v1/search/user/{name}")
    public ResponseEntity <User> searchUserByName(@PathVariable String name) {
        return ResponseEntity.ok(searchUserServise.getUserByName(name));
    }
}
