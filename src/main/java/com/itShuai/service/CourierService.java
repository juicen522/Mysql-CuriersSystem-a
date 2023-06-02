package com.itShuai.service;

import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.DeliveryStatus;

import java.util.List;

public interface CourierService {
    Courier CourierLogIn(String Phone, String Password);
    List<DeliveryStatus>  selectDeliveryStatusByCourierId(Integer CourierId);

    Delivery selectDeliveryByDeliveryId(Integer DeliveryId);

    void getDelivery(Integer CourierId);
    void setDeliveryStatus(Integer DeliveryId);
}
