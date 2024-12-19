package com.sybersoft.osahaneat.controller;

import com.sybersoft.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userServiceImp.getAllUser(), HttpStatus.OK);
    }
}
