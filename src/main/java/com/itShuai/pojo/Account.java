package com.itShuai.pojo;


public class Account {
    private Integer AccountId;
    private Integer UserId;
    private String Password;
    private String Phone;

    @Override
    public String toString() {
        return "Account{" +
                "AccountId=" + AccountId +
                ", UserId=" + UserId +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }

    public Integer getAccountId() {
        return AccountId;
    }

    public void setAccountId(Integer accountId) {
        AccountId = accountId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
}
