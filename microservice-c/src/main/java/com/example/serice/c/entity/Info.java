package com.example.serice.c.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (Info)表实体类
 *
 * @author guochen
 * @since 2021-05-06 17:38:57
 */
@SuppressWarnings("serial")
public class Info extends Model<Info> {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    //端口
    private String port;
    //服务名
    private String serviceName;

    @Version /* 乐观锁*/
    @TableField(value = "version",fill = FieldFill.INSERT)
    private Integer version;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    //json
    private String content;

    private Double money;

    private Object dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Object getDateTime() {
        return dateTime;
    }

    public void setDateTime(Object dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
