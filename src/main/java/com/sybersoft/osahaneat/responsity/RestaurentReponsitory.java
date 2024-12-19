package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurentReponsitory extends JpaRepository<Restaurant,Integer> {
}
