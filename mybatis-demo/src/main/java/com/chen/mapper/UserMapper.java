package com.chen.mapper;

import com.chen.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll() ;
    User selectById(int id);
}
