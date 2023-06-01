package com.itShuai.mapper;


import com.itShuai.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /*管理员登录*/
    Admin LoginAsAdmin(@Param("Account") String Account, @Param("Password") String Password);
    /*通过快递ID找快递，管理快递*/
    Delivery selectDeliveryByDeliveryID(@Param("DeliveryId") Integer DeliveryId);
    /*通过快递号找快递状态，管理快递状态*/
    DeliveryStatus selectDeliveryStatusByDeliveryId(@Param("DeliveryId") Integer DeliveryId);
    /*通过站点号选择站点，管理站点*/
    Station selectStationByStationId(@Param("StationId")Integer StationId);
    /*通过账号ID找出账号，管理账号*/
    Account selectAccountByAccountId(@Param("AccountId") Integer AccountId);

}
