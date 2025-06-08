package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiyanshiEntity;
import java.util.Map;

/**
 * 实验室 服务类
 * @since 2021-03-19
 */
public interface ShiyanshiService extends IService<ShiyanshiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}