package com.chen.mapper;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll() ;
    @Select("select * from mybatis.tb_user where id = #{id}")
    User selectById(int id);
}
