package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.MessagesEntity;

import com.service.MessagesService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 留言板
 * 后端接口
 * @author
 * @email
 * @date 2021-03-19
*/
@RestController
@Controller
@RequestMapping("/messages")
public class MessagesController {
    private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);

    @Autowired
    private MessagesService messagesService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = messagesService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        MessagesEntity messages = messagesService.selectById(id);
        if(messages!=null){
            return R.ok().put("data", messages);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MessagesEntity messages, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<MessagesEntity> queryWrapper = new EntityWrapper<MessagesEntity>()
            .eq("userid", messages.getUserid())
            .eq("username", messages.getUsername())
            .eq("content", messages.getContent())
            .eq("reply", messages.getReply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MessagesEntity messagesEntity = messagesService.selectOne(queryWrapper);
        if(messagesEntity==null){
            messagesService.insert(messages);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MessagesEntity messages, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<MessagesEntity> queryWrapper = new EntityWrapper<MessagesEntity>()
            .notIn("id",messages.getId())
            .eq("userid", messages.getUserid())
            .eq("username", messages.getUsername())
            .eq("content", messages.getContent())
            .eq("reply", messages.getReply())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MessagesEntity messagesEntity = messagesService.selectOne(queryWrapper);
        if(messagesEntity==null){
            messagesService.updateById(messages);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        messagesService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

