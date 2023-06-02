package com.itShuai.mapper;

import com.itShuai.pojo.Account;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    /*根据id查询用户*/
    User selectUserId(@Param("UserId") Integer UserId);
    /*登录*/
    Account LoginAsUser(@Param("Phone") String Phone,@Param("Password") String Password);
    /*注册*/
    User RegisterUserAccount(@Param("Phone") String Phone,@Param("Password") String Password,@Param("Name")String Name,@Param("Sex") String Sex,@Param("Address") String Address);
    /*根据用户ID查询出可收取的所有的快递*/
    List<Delivery> AllRecDelivery(@Param("RecipientId")Integer RecipientId);
    /*根据用户ID查询寄出的快递*/
    List<Delivery> AllSendDelivery(@Param("SenderId")Integer SenderId);
    /*根据快递ID找快递*/
    Delivery SearchDeliveryById(@Param("DeliveryId") Integer DeliveryId);
}
