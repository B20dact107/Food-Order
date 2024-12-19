package com.sybersoft.osahaneat.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sybersoft.osahaneat.dto.CategoryDTO;
import com.sybersoft.osahaneat.dto.MenuDTO;
import com.sybersoft.osahaneat.entity.Category;
import com.sybersoft.osahaneat.entity.Food;
import com.sybersoft.osahaneat.responsity.CategoryReponsitory;
import com.sybersoft.osahaneat.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryReponsitory categoryReponsitory;
    @Autowired
    RedisTemplate redisTemplate;

    private Gson gson=new Gson();
    @Override
    public List<CategoryDTO> getCategoryHomePage() {

        String dataRedis= (String) redisTemplate.opsForValue().get("category");
        List<CategoryDTO>listCategoryDTO = new ArrayList<>();
        if(dataRedis==null){
            System.out.println("chua co data");
            PageRequest pageRequest= PageRequest.of(0,2, Sort.by("id"));
            Page<Category> listCategory= categoryReponsitory.findAll(pageRequest);

            for(Category data:listCategory){
                CategoryDTO c=new CategoryDTO();
                c.setName(data.getNameCate());
                List<MenuDTO> menuDTOS= new ArrayList<>();
                for(Food datafood : data.getFoods()){
                    MenuDTO menuDTO=new MenuDTO();
                    menuDTO.setTitle(datafood.getTitle());
                    menuDTO.setFreeship(datafood.isFreeship());
                    menuDTO.setImage(datafood.getImage());
                    menuDTOS.add(menuDTO);
                }
                c.setMenus(menuDTOS);
                listCategoryDTO.add(c);
            }
            String dataJson = gson.toJson(listCategoryDTO);
            redisTemplate.opsForValue().set("category",dataJson);
        }else{
            Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
            listCategoryDTO= gson.fromJson(dataRedis,listType);
            System.out.println("co data");
        }


        return listCategoryDTO;
    }
}
