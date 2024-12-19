package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.dto.UserDTO;
import com.sybersoft.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReponsity extends JpaRepository<Users,Integer> {
    List<Users> findByUsernameAndPassword(String username,String password);
    //List<Users> findByUsername(String username,String password);
    Users findByUsername(String userName);
}
