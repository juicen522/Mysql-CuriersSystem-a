package com.itShuai.service;

import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.DeliveryStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierService {
    Courier CourierLogIn(String Phone, String Password);
    List<DeliveryStatus>  selectDeliveryStatusByCourierId(Integer DeliveryId);

    Delivery selectDeliveryByDeliveryId(Integer DeliveryId);

    void getDelivery(Integer CourierId);
    void setDeliveryStatus(Integer DeliveryId);
    void deleteCourierById(@Param("CourierId") Integer CourierId);
}
