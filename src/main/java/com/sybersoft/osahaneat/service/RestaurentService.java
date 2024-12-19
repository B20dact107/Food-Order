package com.sybersoft.osahaneat.service;

import com.sybersoft.osahaneat.dto.CategoryDTO;
import com.sybersoft.osahaneat.dto.MenuDTO;
import com.sybersoft.osahaneat.dto.RestaurenntDTO;
import com.sybersoft.osahaneat.entity.Food;
import com.sybersoft.osahaneat.entity.MenuRestaurant;
import com.sybersoft.osahaneat.entity.RatingRestaurant;
import com.sybersoft.osahaneat.entity.Restaurant;
import com.sybersoft.osahaneat.responsity.FoodReponsitory;
import com.sybersoft.osahaneat.responsity.RestaurentReponsitory;
import com.sybersoft.osahaneat.service.imp.FileServiceImp;
import com.sybersoft.osahaneat.service.imp.RestaurentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class RestaurentService implements RestaurentServiceImp {
    @Autowired
    RestaurentReponsitory restaurentReponsitory;
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    FoodReponsitory foodReponsitory;
    @Override
    public boolean insertRestaurent(MultipartFile file, String title, String subtitle, String description, boolean is_freeship, String address, String open_date) {
        boolean isInsertSucces =false;
        try{
            boolean isSaveFileSuccess =fileServiceImp.saveFile(file);
            if(isSaveFileSuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(is_freeship);
                restaurant.setAddress(address);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime openDate = LocalDateTime.parse(open_date, formatter);
                restaurant.setOpenDate(openDate);
                restaurentReponsitory.save(restaurant);
                isInsertSucces=true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurent "+e.getMessage());
        }


        return isInsertSucces;
    }

    @Override
    public List<RestaurenntDTO> getHomePageRestaurent() {
        List<RestaurenntDTO> restaurenntDTOS= new ArrayList<>();
        PageRequest pageRequest= PageRequest.of(0,6);
        Page<Restaurant> listData=restaurentReponsitory.findAll(pageRequest);
        for(Restaurant data: listData){
            RestaurenntDTO restaurenntDTO= new RestaurenntDTO();
            restaurenntDTO.setId(data.getId());
            restaurenntDTO.setImage(data.getImage());
            restaurenntDTO.setTitle(data.getTitle());
            restaurenntDTO.setSubtitle(data.getSubtitle());
            restaurenntDTO.setFreeship(data.isFreeship());
            restaurenntDTO.setRating(caculatorRating(data.getRatingRestaurants()));
            restaurenntDTOS.add(restaurenntDTO);
        }

        return restaurenntDTOS;
    }

    @Override
    public RestaurenntDTO getDetailRestaunrent(int id) {
        Optional<Restaurant> restaurant=restaurentReponsitory.findById(id);
        RestaurenntDTO restaurenntDTO= new RestaurenntDTO();
        if(restaurant.isPresent()){
            List<CategoryDTO> categoryDTOList= new ArrayList<>();
            Restaurant data= restaurant.get();
            restaurenntDTO.setId(data.getId());
            restaurenntDTO.setTitle(data.getTitle());
            restaurenntDTO.setSubtitle(data.getSubtitle());
            restaurenntDTO.setDesc(data.getDescription());
            restaurenntDTO.setImage(data.getImage());
            restaurenntDTO.setRating(caculatorRating(data.getRatingRestaurants()));
            restaurenntDTO.setFreeship(data.isFreeship());
            restaurenntDTO.setOpenDate(data.getOpenDate());

            //category
            for(MenuRestaurant menuRestaurant:data.getMenuRestaurants()){
                List<MenuDTO> menuDTOList= new ArrayList<>();
                CategoryDTO categoryDTO= new CategoryDTO();
                //menu
                categoryDTO.setName(menuRestaurant.getCategory().getNameCate());
                for(Food food :menuRestaurant.getCategory().getFoods()){
                    MenuDTO menuDTO= new MenuDTO();
                    menuDTO.setId(food.getId());
                    menuDTO.setImage(food.getImage());
                    menuDTO.setFreeship(food.isFreeship());
                    menuDTO.setTitle(food.getTitle());
                    menuDTO.setPrice(food.getPrice());

                    menuDTOList.add(menuDTO);
                }
                categoryDTO.setMenus(menuDTOList);
                categoryDTOList.add(categoryDTO);
            }
            restaurenntDTO.setCategories(categoryDTOList);
        }
        return restaurenntDTO;
    }

    @Override
    public MenuDTO getFoodDetail(int foodId) {
        Optional<Food> food= foodReponsitory.findById(foodId);
        if (food.isPresent()) {
            Food data = food.get();
            MenuDTO menuDTO= new MenuDTO();
            menuDTO.setId(data.getId());
            menuDTO.setImage(data.getImage());
            menuDTO.setFreeship(data.isFreeship());
            menuDTO.setTitle(data.getTitle());
            menuDTO.setPrice(data.getPrice());
            menuDTO.setDesc(data.getDesc());
            return menuDTO;

        } else {
       //("Food not found with id " + foodId); // Xử lý trường hợp không tìm thấy món ăn
    }
           return null;

    }

    private double caculatorRating(Set<RatingRestaurant> listRating){
        double total=0;
        for(RatingRestaurant data: listRating){
            total+=data.getRatePoint();
        }
        return total/listRating.size();
    }
}
