package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 实验室
 *
 * @email
 * @date 2021-03-19
 */
@TableName("shiyanshi")
public class ShiyanshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShiyanshiEntity() {

    }

    public ShiyanshiEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 实验室名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 实验室图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 实验室开放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat
    @TableField(value = "kaifang_time")
    private Date kaifangTime;


    /**
     * 实验室结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat
    @TableField(value = "jieshu_time")
    private Date jieshuTime;


    /**
     * 是否被使用
     */
    @TableField(value = "sf_types")

    private Integer sfTypes;


    /**
     * 实验室内容
     */
    @TableField(value = "shiyanshi_content")

    private String shiyanshiContent;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：实验室名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：实验室名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：实验室图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：实验室图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：实验室开放时间
	 */
    public Date getKaifangTime() {
        return kaifangTime;
    }


    /**
	 * 获取：实验室开放时间
	 */

    public void setKaifangTime(Date kaifangTime) {
        this.kaifangTime = kaifangTime;
    }
    /**
	 * 设置：实验室结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 获取：实验室结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：是否被使用
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否被使用
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }
    /**
	 * 设置：实验室内容
	 */
    public String getShiyanshiContent() {
        return shiyanshiContent;
    }


    /**
	 * 获取：实验室内容
	 */

    public void setShiyanshiContent(String shiyanshiContent) {
        this.shiyanshiContent = shiyanshiContent;
    }

    @Override
    public String toString() {
    return "Shiyanshi{" +
            "id=" + id +
            ", name=" + name +
            ", imgPhoto=" + imgPhoto +
            ", kaifangTime=" + kaifangTime +
            ", jieshuTime=" + jieshuTime +
            ", sfTypes=" + sfTypes +
            ", shiyanshiContent=" + shiyanshiContent +
    "}";
    }
    }
