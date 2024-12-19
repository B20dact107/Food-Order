package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.entity.OrderItem;
import com.sybersoft.osahaneat.entity.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
