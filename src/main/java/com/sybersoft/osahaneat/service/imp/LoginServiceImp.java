package com.sybersoft.osahaneat.service.imp;

import com.sybersoft.osahaneat.dto.UserDTO;
import com.sybersoft.osahaneat.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String username,String password);
    boolean addUser(SignUpRequest signUpRequest);
}
