package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MessagesEntity;
import java.util.Map;

/**
 * 留言板 服务类
 * @since 2021-03-19
 */
public interface MessagesService extends IService<MessagesEntity> {

     PageUtils queryPage(Map<String, Object> params);

}