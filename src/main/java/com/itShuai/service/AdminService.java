package com.itShuai.service;

import com.itShuai.pojo.Admin;
import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
//    通过输入账号密码进行登录操作
    Admin LoginAsAdmin(String Account,String Password);
    List<Delivery> FindAllDelivery();
    Delivery selectDeliveryByDeliveryID(@Param("DeliveryId") Integer DeliveryId);
    void ChangeDeliveryStatus(@Param("DeliveryId") Integer DeliveryId,@Param("DeliveryStatus") String DeliveryStatus);
    void DeleteUserById(@Param("UserId") Integer UserId);
    User selectUserByUserId(@Param("UserId") Integer UserId);
    void deleteDeliveryStatus(@Param("DeliveryId")Integer DeliveryId);
    void deleteDeliveryById(@Param("DeliveryId")Integer DeliveryId);
    Courier selectCourierById(@Param("CourierId")Integer CourierId);
    void updateCourierById(@Param("CourierId")Integer CourierId,@Param("Name")String Name,@Param("Sex")String Sex,@Param("Phone")String Phone,@Param("StationId")Integer StationId,@Param("Password")String Password);
    void addCourier(@Param("Name")String Name,@Param("Sex")String Sex,@Param("Phone")String Phone,@Param("StationId")Integer StationId,@Param("Password")String Password);

}
