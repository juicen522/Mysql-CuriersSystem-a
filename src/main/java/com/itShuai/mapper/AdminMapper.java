package com.itShuai.mapper;


import com.itShuai.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin LoginAsAdmin(@Param("Account") String Account, @Param("Password") String Password);
}
