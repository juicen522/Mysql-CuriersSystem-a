package com.itShuai.pojo;



public class User {
    private Integer UserId;
    private String Sex;
    private String Name;
    private String Address;

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", Sex='" + Sex + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
