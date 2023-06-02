package com.itShuai.pojo;

public class Admin {
    private Integer AdminId;
    private String Password;
    private String Phone;
    private String Account;
    private String Name;

    @Override
    public String toString() {
        return "Admin{" +
                "AdminId=" + AdminId +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Account='" + Account + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAdminId() {
        return AdminId;
    }

    public void setAdminId(Integer adminId) {
        AdminId = adminId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }
}

