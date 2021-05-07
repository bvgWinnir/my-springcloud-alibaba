package com.example.serice.b.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.serice.b.entity.Info;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Info)表数据库访问层
 *
 * @author guochen
 * @since 2021-05-07 09:52:48
 */
@Mapper
public interface InfoDao extends BaseMapper<Info> {

}
