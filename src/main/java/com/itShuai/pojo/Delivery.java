package com.itShuai.pojo;


import java.time.LocalDateTime;


public class Delivery {
    private Integer DeliveryId;
    private Integer SenderId;
    private Integer RecipientId;
    private String SenderAddress;
    private String RecipientAddress;
    private LocalDateTime ShippingTime;
    private LocalDateTime DeliveryTime;
    private String StationId;
    private LocalDateTime EntryTime;
    private LocalDateTime ExitTime;
    private String Name;

    @Override
    public String toString() {
        return "Delivery{" +
                "DeliveryId=" + DeliveryId +
                ", SenderId=" + SenderId +
                ", RecipientId=" + RecipientId +
                ", SenderAddress='" + SenderAddress + '\'' +
                ", RecipientAddress='" + RecipientAddress + '\'' +
                ", ShippingTime=" + ShippingTime +
                ", DeliveryTime=" + DeliveryTime +
                ", StationId='" + StationId + '\'' +
                ", EntryTime=" + EntryTime +
                ", ExitTime=" + ExitTime +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getDeliveryId() {
        return DeliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        DeliveryId = deliveryId;
    }

    public Integer getSenderId() {
        return SenderId;
    }

    public void setSenderId(Integer senderId) {
        SenderId = senderId;
    }

    public Integer getRecipientId() {
        return RecipientId;
    }

    public void setRecipientId(Integer recipientId) {
        RecipientId = recipientId;
    }

    public String getSenderAddress() {
        return SenderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        SenderAddress = senderAddress;
    }

    public String getRecipientAddress() {
        return RecipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        RecipientAddress = recipientAddress;
    }

    public LocalDateTime getShippingTime() {
        return ShippingTime;
    }

    public void setShippingTime(LocalDateTime shippingTime) {
        ShippingTime = shippingTime;
    }

    public LocalDateTime getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public String getStationId() {
        return StationId;
    }

    public void setStationId(String stationId) {
        StationId = stationId;
    }

    public LocalDateTime getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        EntryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return ExitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        ExitTime = exitTime;
    }
}
