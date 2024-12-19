package com.sybersoft.osahaneat.service;

import com.sybersoft.osahaneat.dto.UserDTO;
import com.sybersoft.osahaneat.entity.Users;
import com.sybersoft.osahaneat.responsity.UserReponsity;
import com.sybersoft.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Userservice implements UserServiceImp {
    @Autowired
    UserReponsity userReponsity;
    @Override
    public List<UserDTO> getAllUser() {
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
}
