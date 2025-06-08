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
 * 申请
 *
 * @email
 * @date 2021-03-19
 */
@TableName("shenqing")
public class ShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShenqingEntity() {

    }

    public ShenqingEntity(T t) {
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
     * 申请实验室
     */
    @TableField(value = "sys_types")

    private Integer sysTypes;


    /**
     * 申请人
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
     * 申请结果
     */
    @TableField(value = "sq_types")

    private Integer sqTypes;


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
	 * 设置：申请实验室
	 */
    public Integer getSysTypes() {
        return sysTypes;
    }


    /**
	 * 获取：申请实验室
	 */

    public void setSysTypes(Integer sysTypes) {
        this.sysTypes = sysTypes;
    }
    /**
	 * 设置：申请人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：申请人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：申请结果
	 */
    public Integer getSqTypes() {
        return sqTypes;
    }


    /**
	 * 获取：申请结果
	 */

    public void setSqTypes(Integer sqTypes) {
        this.sqTypes = sqTypes;
    }

    @Override
    public String toString() {
    return "Shenqing{" +
            "id=" + id +
            ", sysTypes=" + sysTypes +
            ", yhTypes=" + yhTypes +
            ", createTime=" + createTime +
            ", sqTypes=" + sqTypes +
    "}";
    }
    }
