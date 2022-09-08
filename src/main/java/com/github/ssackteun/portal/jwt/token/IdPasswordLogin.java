package com.github.ssackteun.portal.jwt.token;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdPasswordLogin {
    private String userId;
    private String password;
}
