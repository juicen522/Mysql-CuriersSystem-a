package com.itShuai.mapper;

import com.itShuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    /*
    * 根据id删除数据
    * */


    /*
    * 根据id查询用户
    * */
    User selectUserId(@Param("UserId") Integer UserId);
}
