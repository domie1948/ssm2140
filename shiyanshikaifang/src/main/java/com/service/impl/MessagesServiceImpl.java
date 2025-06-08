package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.MessagesDao;
import com.entity.MessagesEntity;
import com.service.MessagesService;
import com.entity.view.MessagesView;

/**
 * 留言板 服务实现类
 * @since 2021-03-19
 */
@Service("messagesService")
@Transactional
public class MessagesServiceImpl extends ServiceImpl<MessagesDao, MessagesEntity> implements MessagesService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<MessagesView> page =new Query<MessagesView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
