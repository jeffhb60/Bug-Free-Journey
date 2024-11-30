package com.jeffhb60.bugfreejourney.security.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserInfoResponse {
    private Long id;
    private String jwtToken;
    private String username;
    private List<String> roles;

    public UserInfoResponse(Long id, String username, List<String> roles, String jwtToken) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

}



