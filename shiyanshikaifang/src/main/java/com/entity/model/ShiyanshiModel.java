package com.entity.model;

import com.entity.ShiyanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 实验室
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-19
 */
public class ShiyanshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 实验室名称 Search
     */
    private String name;


    /**
     * 实验室图片
     */
    private String imgPhoto;


    /**
     * 实验室开放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaifangTime;


    /**
     * 实验室结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 是否被使用 Search
     */
    private Integer sfTypes;


    /**
     * 实验室内容
     */
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
	 * 设置：实验室名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：实验室名称 Search
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
	 * 设置：是否被使用 Search
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否被使用 Search
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

    }
