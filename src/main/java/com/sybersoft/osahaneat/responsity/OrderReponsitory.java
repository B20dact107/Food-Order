package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReponsitory extends JpaRepository<Orders,Integer> {
}
