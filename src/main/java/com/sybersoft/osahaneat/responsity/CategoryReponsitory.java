package com.sybersoft.osahaneat.responsity;

import com.sybersoft.osahaneat.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category,Integer> {
}
