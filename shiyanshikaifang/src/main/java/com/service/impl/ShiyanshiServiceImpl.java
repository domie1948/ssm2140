package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShiyanshiDao;
import com.entity.ShiyanshiEntity;
import com.service.ShiyanshiService;
import com.entity.view.ShiyanshiView;

/**
 * 实验室 服务实现类
 * @since 2021-03-19
 */
@Service("shiyanshiService")
@Transactional
public class ShiyanshiServiceImpl extends ServiceImpl<ShiyanshiDao, ShiyanshiEntity> implements ShiyanshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShiyanshiView> page =new Query<ShiyanshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
