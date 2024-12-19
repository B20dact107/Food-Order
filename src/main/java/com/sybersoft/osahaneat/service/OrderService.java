package com.sybersoft.osahaneat.service;

import com.sybersoft.osahaneat.entity.*;
import com.sybersoft.osahaneat.entity.keys.KeyOrderItem;
import com.sybersoft.osahaneat.payload.request.OrderResquest;
import com.sybersoft.osahaneat.responsity.OrderItemRepository;
import com.sybersoft.osahaneat.responsity.OrderReponsitory;
import com.sybersoft.osahaneat.service.imp.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class OrderService implements OrderServiceImp {


    @Autowired
    OrderReponsitory orderReponsitory;
    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public boolean insertOrder(OrderResquest orderResquest) {
        try{
            Users users= new Users();
            users.setId(orderResquest.getUserId());
            Restaurant restaurant=new Restaurant();
            restaurant.setId(orderResquest.getResId());
            Orders orders =new Orders();
            orders.setUser(users);
            orders.setRestaurant(restaurant);
            orderReponsitory.save(orders);


            List<OrderItem> items= new ArrayList<>();
            for(int idFood : orderResquest.getFoodIds()){
                Food food=new Food();
                food.setId(idFood);
                OrderItem orderItem= new OrderItem();
                KeyOrderItem keyOrderItem=new KeyOrderItem(orders.getId(),idFood);
                orderItem.setKeyOrderItem(keyOrderItem);

                items.add(orderItem);
            }
            orderItemRepository.saveAll(items);
            return true;

        }catch(Exception e){
            System.out.println("Error insert order"+e.getMessage());
            return false;
        }



    }
}
