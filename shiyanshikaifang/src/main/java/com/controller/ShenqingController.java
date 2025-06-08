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

import com.entity.ShenqingEntity;

import com.service.ShenqingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 申请
 * 后端接口
 * @author
 * @email
 * @date 2021-03-19
*/
@RestController
@Controller
@RequestMapping("/shenqing")
public class ShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(ShenqingController.class);

    @Autowired
    private ShenqingService shenqingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
        }
        PageUtils page = shenqingService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShenqingEntity shenqing = shenqingService.selectById(id);
        if(shenqing!=null){
            return R.ok().put("data", shenqing);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingEntity shenqing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
            .eq("sys_types", shenqing.getSysTypes())
            .eq("yh_types", shenqing.getYhTypes())
            .eq("sq_types", shenqing.getSqTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity==null){
            shenqingService.insert(shenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShenqingEntity shenqing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
            .notIn("id",shenqing.getId())
            .eq("sys_types", shenqing.getSysTypes())
            .eq("yh_types", shenqing.getYhTypes())
            .eq("sq_types", shenqing.getSqTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity==null){
            shenqingService.updateById(shenqing);//根据id更新
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
        shenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

