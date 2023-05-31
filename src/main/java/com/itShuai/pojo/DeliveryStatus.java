package com.itShuai.pojo;


import java.time.LocalDateTime;


public class DeliveryStatus {
    private Integer CourierId;
    private Integer DeliveryId;
    private String DeliveryStatus;
    private LocalDateTime EstimatedDeliveryTime;
    private LocalDateTime ActualDeliveryTime;

    @Override
    public String toString() {
        return "DeliveryStatus{" +
                "CourierId=" + CourierId +
                ", DeliveryId=" + DeliveryId +
                ", DeliveryStatus='" + DeliveryStatus + '\'' +
                ", EstimatedDeliveryTime=" + EstimatedDeliveryTime +
                ", ActualDeliveryTime=" + ActualDeliveryTime +
                '}';
    }

    public Integer getCourierId() {
        return CourierId;
    }

    public void setCourierId(Integer courierId) {
        CourierId = courierId;
    }

    public Integer getDeliveryId() {
        return DeliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        DeliveryId = deliveryId;
    }

    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return EstimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        EstimatedDeliveryTime = estimatedDeliveryTime;
    }

    public LocalDateTime getActualDeliveryTime() {
        return ActualDeliveryTime;
    }

    public void setActualDeliveryTime(LocalDateTime actualDeliveryTime) {
        ActualDeliveryTime = actualDeliveryTime;
    }
}
