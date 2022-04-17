package com.chrisren.learnmybatis3.diy.mapper;

import com.chrisren.learnmybatis3.diy.entity.User;

import java.util.List;

public interface UserMapper {
    User selectByPrimaryKey(long userId);
    List<User> selectAll();
}
