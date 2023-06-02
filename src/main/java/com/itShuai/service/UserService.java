package com.itShuai.service;

import com.itShuai.pojo.Account;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /*根据id查询用户*/
    User selectUserId(@Param("UserId") Integer UserId);
    /*登录*/
    User LoginAsUser(@Param("Phone") String Phone, @Param("Password") String Password);
    /*注册*/
    void RegisterUserAccount(@Param("Sex") String Sex,@Param("Name") String Name,@Param("Address") String Address,@Param("Phone") String Phone,@Param("Password") String Password);
    /*根据用户ID查询出可收取的所有的快递*/
    List<Delivery> AllRecDelivery(@Param("RecipientId")Integer RecipientId);
    /*根据用户ID查询寄出的快递*/
    List<Delivery> AllSendDelivery(@Param("SenderId")Integer SenderId);
    /*根据快递ID找快递*/
    Delivery SearchDeliveryById(@Param("DeliveryId") Integer DeliveryId);
    void SendDelivery(@Param("SenderId") Integer SenderId,@Param("RecipientId")Integer RecipientId,@Param("SenderAddress") String SenderAddress,@Param("RecipientAddress") String RecipientAddress);

}
