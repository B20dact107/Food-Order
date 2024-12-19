package com.sybersoft.osahaneat.controller;

import com.sybersoft.osahaneat.payload.request.OrderResquest;
import com.sybersoft.osahaneat.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping("")
    public ResponseEntity<?> getorder(@RequestBody OrderResquest orderResquest){

        return new ResponseEntity<>(orderServiceImp.insertOrder(orderResquest), HttpStatus.OK);
    }
}
