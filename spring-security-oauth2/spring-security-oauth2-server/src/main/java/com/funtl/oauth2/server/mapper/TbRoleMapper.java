package com.funtl.oauth2.server.mapper;

import com.funtl.oauth2.server.domain.TbRole;
import com.funtl.oauth2.server.domain.TbRoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbRoleMapper {
    long countByExample(TbRoleExample example);

    int deleteByExample(TbRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    List<TbRole> selectByExample(TbRoleExample example);

    TbRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByExample(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);
}