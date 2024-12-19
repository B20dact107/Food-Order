package com.sybersoft.osahaneat.service.imp;

import com.sybersoft.osahaneat.dto.MenuDTO;
import com.sybersoft.osahaneat.entity.Food;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface MenuServiceImp {
    boolean createMenu(MultipartFile file, String title, String time_ship, BigDecimal price, int cate_id, boolean is_freeship);


}
