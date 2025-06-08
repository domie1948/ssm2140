package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.ShenqingEntity;
import com.service.ShenqingService;
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

import com.entity.ShiyanshiEntity;

import com.service.ShiyanshiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 实验室
 * 后端接口
 * @author
 * @email
 * @date 2021-03-19
*/
@RestController
@Controller
@RequestMapping("/shiyanshi")
public class ShiyanshiController {
    private static final Logger logger = LoggerFactory.getLogger(ShiyanshiController.class);

    @Autowired
    private ShiyanshiService shiyanshiService;


    @Autowired
    private ShenqingService shenqingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = shiyanshiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShiyanshiEntity shiyanshi = shiyanshiService.selectById(id);
        if(shiyanshi!=null){
            return R.ok().put("data", shiyanshi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyanshiEntity shiyanshi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShiyanshiEntity> queryWrapper = new EntityWrapper<ShiyanshiEntity>()
            .eq("name", shiyanshi.getName())
            .eq("sf_types", shiyanshi.getSfTypes())
            .eq("shiyanshi_content", shiyanshi.getShiyanshiContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiyanshiEntity shiyanshiEntity = shiyanshiService.selectOne(queryWrapper);
        if("".equals(shiyanshi.getImgPhoto()) || "null".equals(shiyanshi.getImgPhoto())){
            shiyanshi.setImgPhoto(null);
        }
        if(shiyanshiEntity==null){
            shiyanshiService.insert(shiyanshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiyanshiEntity shiyanshi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShiyanshiEntity> queryWrapper = new EntityWrapper<ShiyanshiEntity>()
            .notIn("id",shiyanshi.getId())
            .eq("name", shiyanshi.getName())
            .eq("sf_types", shiyanshi.getSfTypes())
            .eq("shiyanshi_content", shiyanshi.getShiyanshiContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShiyanshiEntity shiyanshiEntity = shiyanshiService.selectOne(queryWrapper);
        if("".equals(shiyanshi.getImgPhoto()) || "null".equals(shiyanshi.getImgPhoto())){
                shiyanshi.setImgPhoto(null);
        }
        if(shiyanshiEntity==null){
            shiyanshiService.updateById(shiyanshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }




    /**
    * 申请
    */
    @RequestMapping("/apply")
    public R apply(Integer ids, HttpServletRequest request){
        ShiyanshiEntity shiyanshi = shiyanshiService.selectById(ids);
        if(shiyanshi == null){
            return R.error();
        }
        shiyanshi.setSfTypes(1);
        ShenqingEntity shenqing = new ShenqingEntity();
        shenqing.setCreateTime(new Date());
        shenqing.setSqTypes(0);
        shenqing.setSysTypes(shiyanshi.getId());
        shenqing.setYhTypes((Integer)request.getSession().getAttribute("userId"));
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
                .eq("sys_types", shenqing.getSysTypes())
                .eq("yh_types", shenqing.getYhTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity==null){
            shiyanshiService.updateById(shiyanshi);
            shenqingService.insert(shenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 同意
    */
    @RequestMapping("/consent")
    public R consent(Integer ids){
        ShenqingEntity shenqing = shenqingService.selectById(ids);
        if(shenqing == null){
            return R.error();
        }
        shenqing.setSqTypes(2);
        shenqingService.updateById(shenqing);
        return R.ok();
    }
    /**
    * 拒绝
    */
    @RequestMapping("/refuse")
    public R refuse(Integer ids){
        ShenqingEntity shenqing = shenqingService.selectById(ids);
        if(shenqing == null){
            return R.error();
        }
        shenqing.setSqTypes(1);
        shenqingService.updateById(shenqing);
        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        shiyanshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

