package com.burhanmutlu.discributed.user;

import com.burhanmutlu.discributed.user.dto.req.UserRegisterRequest;
import com.burhanmutlu.discributed.user.dto.resp.UserResponse;
import com.burhanmutlu.discributed.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRegisterRequest userRegisterRequest) {
        User user = userRepository.save(userMapper.toUser(userRegisterRequest));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponses = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            userResponses.add(userMapper.toUserResponse(user));
        });
        return userResponses;
    }

    @Override
    public UserResponse updateUserById(String id, UserRegisterRequest userRegisterRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        user = userMapper.toUser(userRegisterRequest);
        user.setId(id);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        userRepository.deleteById(id);
    }
}
