package com.burhanmutlu.discributed.user.dto.req;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private String name;

    private String username;

    private String password;

}
