package com.sybersoft.osahaneat.service;

import com.sybersoft.osahaneat.entity.Category;
import com.sybersoft.osahaneat.entity.Food;
import com.sybersoft.osahaneat.entity.Restaurant;
import com.sybersoft.osahaneat.responsity.FoodReponsitory;
import com.sybersoft.osahaneat.service.imp.FileServiceImp;
import com.sybersoft.osahaneat.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    FoodReponsitory foodReponsitory;
    @Override
    public boolean createMenu(MultipartFile file, String title, String time_ship, BigDecimal price, int cate_id, boolean is_freeship) {
        boolean isInsertSucces =false;
        try{
            boolean isSaveFileSuccess =fileServiceImp.saveFile(file);
            if(isSaveFileSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setTimeShip(time_ship);
                food.setImage(file.getOriginalFilename());
                food.setPrice(price);
                food.setFreeship(is_freeship);
                Category category= new Category();
                category.setId(cate_id);
                food.setCategory(category);
                foodReponsitory.save(food);
                isInsertSucces=true;
            }
        }catch (Exception e){
            System.out.println("Error insert food "+e.getMessage());
        }


        return isInsertSucces;
    }
}
