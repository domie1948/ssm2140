package com.entity.vo;

import com.entity.ShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-19
 */
@TableName("shenqing")
public class ShenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 申请结果 Search
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
	 * 设置：申请结果 Search
	 */
    public Integer getSqTypes() {
        return sqTypes;
    }


    /**
	 * 获取：申请结果 Search
	 */

    public void setSqTypes(Integer sqTypes) {
        this.sqTypes = sqTypes;
    }

}
