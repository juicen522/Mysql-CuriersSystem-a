package com.itShuai.mapper;


import com.itShuai.pojo.Delivery;
import org.apache.ibatis.annotations.Param;

public interface DeliveryMapper {
    Delivery GetDeliveryInfo(@Param("DeliveryId") Integer DeliveryId);
}
