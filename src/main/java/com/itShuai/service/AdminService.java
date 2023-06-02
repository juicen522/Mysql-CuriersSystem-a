package com.itShuai.service;

import com.itShuai.pojo.Admin;
import com.itShuai.pojo.Delivery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
//    通过输入账号密码进行登录操作
    Admin LoginAsAdmin(String Account,String Password);
    List<Delivery> FindAllDelivery();
    Delivery selectDeliveryByDeliveryID(@Param("DeliveryId") Integer DeliveryId);
}
