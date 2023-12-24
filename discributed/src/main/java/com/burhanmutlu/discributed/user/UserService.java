package com.burhanmutlu.discributed.user;

import com.burhanmutlu.discributed.user.dto.req.UserRegisterRequest;
import com.burhanmutlu.discributed.user.dto.resp.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRegisterRequest userRegisterRequest);

    List<UserResponse> getAllUsers();

    UserResponse updateUserById(String id, UserRegisterRequest userRegisterRequest);

    void deleteUserById(String id);
}
