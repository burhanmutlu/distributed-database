package com.burhanmutlu.discributed.user;

import com.burhanmutlu.discributed.shared.GenericResponse;
import com.burhanmutlu.discributed.user.dto.req.UserRegisterRequest;
import com.burhanmutlu.discributed.user.dto.resp.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        UserResponse userResponse = userService.createUser(userRegisterRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id,
                                                   @RequestBody UserRegisterRequest userRegisterRequest) {
        UserResponse userResponse = userService.updateUserById(id, userRegisterRequest);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<GenericResponse> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(new GenericResponse(true, "User is deleted"));
    }


}
