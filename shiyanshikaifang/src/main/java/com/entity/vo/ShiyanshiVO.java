package com.entity.vo;

import com.entity.ShiyanshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 实验室
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-19
 */
@TableName("shiyanshi")
public class ShiyanshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 实验室名称 Search
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaifang_time")
    private Date kaifangTime;


    /**
     * 实验室结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieshu_time")
    private Date jieshuTime;


    /**
     * 是否被使用 Search
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
