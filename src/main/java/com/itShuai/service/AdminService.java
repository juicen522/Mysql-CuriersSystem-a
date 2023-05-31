package com.itShuai.service;

import com.itShuai.pojo.Admin;

public interface AdminService {
//    通过输入账号密码进行登录操作
    Admin LoginAsAdmin(String Account,String Password);
}
