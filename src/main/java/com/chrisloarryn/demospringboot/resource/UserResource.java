package com.chrisloarryn.demospringboot.resource;

import com.chrisloarryn.demospringboot.model.User;
import com.chrisloarryn.demospringboot.service.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/v1/users"
)
public class UserResource {
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<User> fetchUsers(@QueryParam("gender") String gender) {
        return userService.getAllUsers(Optional.ofNullable(gender));
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertNewUser(@RequestBody User user) {
        int result = userService.insertUser(user);
        return getIntegerResponseEntity(result);
    }

    @PutMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        int result = userService.updateUser(user);
        return getIntegerResponseEntity(result);
    }

    @DeleteMapping("{userUid}")
    public ResponseEntity<?> deleteUser(@PathVariable("userUid") UUID userUid) {
        int result = userService.removeUser(userUid);
        return getIntegerResponseEntity(result);
    }

    @GetMapping("{userUid}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fetchUser(@PathVariable("userUid") UUID userUid) {
        System.out.println("userUid = " + userUid);

        return userService.getUser(userUid)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorMessage("User " + userUid + " was not found.")));
    }

    private static ResponseEntity<?> getIntegerResponseEntity(int result) {
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(new ErrorMessage("no rows affected"));
    }

    static class ErrorMessage {
        public ErrorMessage(String message) {
            this.errorMessage = message;
        }

        public String errorMessage = "An error occurred";

        public String getMessage() {
            return errorMessage;
        }
    }

}
