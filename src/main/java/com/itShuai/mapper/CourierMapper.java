package com.itShuai.mapper;

import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.DeliveryStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierMapper {
    Courier CourierLogIn(@Param("Phone") String Phone, @Param("Password")String Password);
    List<DeliveryStatus>  selectDeliveryStatusByCourierId(@Param("CourierId")Integer DeliveryId);

    Delivery selectDeliveryByDeliveryId(@Param("DeliveryId") Integer DeliveryId);

    void getDelivery(@Param("CourierId")Integer CourierId);
    void setDeliveryStatus(@Param("DeliveryId") Integer DeliveryId);
    void deleteCourierById(@Param("CourierId") Integer CourierId);
}
