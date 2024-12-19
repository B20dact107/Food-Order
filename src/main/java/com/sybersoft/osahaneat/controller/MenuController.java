package com.sybersoft.osahaneat.controller;

import com.sybersoft.osahaneat.payload.ResponseData;
import com.sybersoft.osahaneat.service.imp.FileServiceImp;
import com.sybersoft.osahaneat.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    MenuServiceImp menuServiceImp;
    @PostMapping("")
    public ResponseEntity<?> createMenu(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String time_ship,
            @RequestParam BigDecimal price,
            @RequestParam int cate_id,
            @RequestParam boolean is_freeship){
        ResponseData responseData= new ResponseData();
        boolean isSuccess = menuServiceImp.createMenu(file,title, time_ship, price, cate_id, is_freeship) ;
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
