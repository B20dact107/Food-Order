package com.sybersoft.osahaneat.security;

import com.sybersoft.osahaneat.entity.Users;
import com.sybersoft.osahaneat.responsity.UserReponsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustorUserDetailService implements UserDetailsService {
    @Autowired
    UserReponsity userReponsity;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=userReponsity.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException("User can't exits");
        }
        return new User(username,users.getPassword(), new ArrayList<>());
    }
}
