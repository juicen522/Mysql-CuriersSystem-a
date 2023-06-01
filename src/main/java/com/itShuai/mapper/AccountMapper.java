package com.itShuai.mapper;


import com.itShuai.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    Account LoginAsUser(@Param("Phone") String Phone,@Param("Password") String Password);
}
