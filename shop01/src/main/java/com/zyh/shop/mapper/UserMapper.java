package com.zyh.shop.mapper;

import com.zyh.shop.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from ec_user where login_name = #{dfff} ")
    User login(String loginNmae);
}
