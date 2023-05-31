package com.itShuai.pojo;


public class Station {
    private Integer StationId;
    private Integer AdminId;
    private String Address;
    private String StationName;

    public Integer getStationId() {
        return StationId;
    }

    public void setStationId(Integer stationId) {
        StationId = stationId;
    }

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer adminId) {
        AdminId = adminId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    @Override
    public String toString() {
        return "Station{" +
                "StationId=" + StationId +
                ", AdminId=" + AdminId +
                ", Address='" + Address + '\'' +
                ", StationName='" + StationName + '\'' +
                '}';
    }
}
