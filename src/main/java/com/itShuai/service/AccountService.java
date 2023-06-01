package com.itShuai.service;

import com.itShuai.pojo.Account;


public interface AccountService {
    Account LoginAsUser(String Phone,String Password);
}
