package com.github.ssackteun.portal.jwt.auth.service;

import com.github.ssackteun.portal.jwt.auth.entity.LoginRequestDTO;
import com.github.ssackteun.portal.jwt.utils.TokenDTO;

public interface AuthServiceInterface {

    TokenDTO login(LoginRequestDTO loginRequestDTO);
}
