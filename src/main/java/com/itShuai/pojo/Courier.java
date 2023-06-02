package com.itShuai.pojo;

public class Courier {
    private Integer CourierId;
    private Integer StationId;
    private String Name;
    private String Sex;
    private String Phone;
    private String Password;

    @Override
    public String toString() {
        return "Courier{" +
                "CourierId=" + CourierId +
                ", StationId=" + StationId +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getCourierId() {
        return CourierId;
    }

    public void setCourierId(Integer courierId) {
        CourierId = courierId;
    }

    public Integer getStationId() {
        return StationId;
    }

    public void setStationId(Integer stationId) {
        StationId = stationId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
