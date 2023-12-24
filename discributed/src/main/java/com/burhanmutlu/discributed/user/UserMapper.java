package com.burhanmutlu.discributed.user;

import com.burhanmutlu.discributed.user.dto.req.UserRegisterRequest;
import com.burhanmutlu.discributed.user.dto.resp.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    User toUser(UserRegisterRequest userRegisterRequest) {
        return User.builder()
                .name(userRegisterRequest.getName())
                .username(userRegisterRequest.getUsername())
                .password(userRegisterRequest.getPassword())
                .build();
    }

    UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }


}
