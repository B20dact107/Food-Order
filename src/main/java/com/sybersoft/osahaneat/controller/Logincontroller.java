package com.sybersoft.osahaneat.controller;

import com.sybersoft.osahaneat.Utils.JwtUtilsHelper;
import com.sybersoft.osahaneat.payload.ResponseData;
import com.sybersoft.osahaneat.payload.request.SignUpRequest;
import com.sybersoft.osahaneat.service.Loginservice;
import com.sybersoft.osahaneat.service.imp.LoginServiceImp;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.beans.Encoder;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class Logincontroller {

    @Autowired
    LoginServiceImp loginServiceImp;
    @Autowired
    JwtUtilsHelper jwtUtilsHelper;
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password){
        ResponseData responseData= new ResponseData();
        System.out.println(username);
        System.out.println(password);
////        SecretKey secretKey= Keys.secretKeyFor(SignatureAlgorithm.HS256);
////        String encrypted= Encoders.BASE64.encode(secretKey.getEncoded());
////        System.out.println("+++++++++++++++++++++++++++++");
//        System.out.println(encrypted);
        if(loginServiceImp.checkLogin(username,password)){

            String token =jwtUtilsHelper.generateToken(username);
            responseData.setData(token);
        }else{
            responseData.setData("");
            responseData.setSeccess(false);
        }


        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData= new ResponseData();
            responseData.setData(loginServiceImp.addUser(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
