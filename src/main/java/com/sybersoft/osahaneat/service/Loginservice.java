package com.sybersoft.osahaneat.service;

import com.sybersoft.osahaneat.dto.UserDTO;
import com.sybersoft.osahaneat.entity.Roles;
import com.sybersoft.osahaneat.entity.Users;
import com.sybersoft.osahaneat.payload.request.SignUpRequest;
import com.sybersoft.osahaneat.responsity.UserReponsity;
import com.sybersoft.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Loginservice implements LoginServiceImp {
    @Autowired
    UserReponsity userReponsity;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
     public List<UserDTO> getAllUser(){
        List<Users> listUser =userReponsity.findAll();
        List<UserDTO> listUserDto = new ArrayList<>();
        for(Users users: listUser){
            UserDTO userDTO= new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUsername(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullname(users.getFullname());
            listUserDto.add(userDTO);

        }
        return listUserDto;

    }

    @Override
    public boolean checkLogin(String username, String password) {
        Users users= userReponsity.findByUsername(username);

        return passwordEncoder.matches(password,users.getPassword());

    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Roles roles= new Roles();
        roles.setId(signUpRequest.getRoleId());
        Users users=new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUsername(signUpRequest.getEmail());
     //   users.setPassword(signUpRequest.getPassword());
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        users.setPassword(encodedPassword);
        users.setRole(roles);
        try {
            userReponsity.save(users);
            return true;
        }catch (Exception e){
            return false;
        }


    }


}
