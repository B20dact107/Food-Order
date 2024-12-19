package com.sybersoft.osahaneat.service.imp;

import com.sybersoft.osahaneat.dto.MenuDTO;
import com.sybersoft.osahaneat.dto.RestaurenntDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurentServiceImp {
    boolean insertRestaurent( MultipartFile file,
                              String title,
                              String subtitle,
                              String description,
                              boolean is_freeship,
                              String address,
                              String open_date);
    List<RestaurenntDTO> getHomePageRestaurent();
    RestaurenntDTO getDetailRestaunrent(int id);
    MenuDTO  getFoodDetail(int foodId);
}
