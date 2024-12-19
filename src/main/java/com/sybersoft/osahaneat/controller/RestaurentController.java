package com.sybersoft.osahaneat.controller;

import com.sybersoft.osahaneat.payload.ResponseData;
import com.sybersoft.osahaneat.service.RestaurentService;
import com.sybersoft.osahaneat.service.imp.FileServiceImp;
import com.sybersoft.osahaneat.service.imp.RestaurentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
@RequestMapping("/restaurent")
public class RestaurentController {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    RestaurentServiceImp restaurentServiceImp;
    @PostMapping("")
    public ResponseEntity<?> creaResponseEntity(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam String description,
            @RequestParam boolean is_freeship,
            @RequestParam String address,
            @RequestParam String open_date){
        ResponseData responseData= new ResponseData();
        boolean isSuccess = restaurentServiceImp.insertRestaurent(file,title, subtitle, description, is_freeship, address, open_date) ;
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
    @GetMapping ("")
    public ResponseEntity<?> getHomePageRestaurent(){
        ResponseData responseData= new ResponseData();
        responseData.setData(restaurentServiceImp.getHomePageRestaurent());
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFResponseEntity(@PathVariable String filename){
        Resource resource =fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

    }
    @GetMapping ("/detail")
    public ResponseEntity<?> getDetailRestaurent(@RequestParam int id){
        ResponseData responseData= new ResponseData();
        responseData.setData(restaurentServiceImp.getDetailRestaunrent(id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
    @GetMapping ("/food")
    public ResponseEntity<?> getFood(@RequestParam int id){
        ResponseData responseData= new ResponseData();
        responseData.setData(restaurentServiceImp.getFoodDetail(id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
