package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodReponsitory extends JpaRepository<Food,Integer> {
}
