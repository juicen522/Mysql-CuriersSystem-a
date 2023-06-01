package com.itShuai.service.impl;

import com.itShuai.mapper.AccountMapper;
import com.itShuai.pojo.Account;
import com.itShuai.service.AccountService;
import com.itShuai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AccountServiceImpl implements AccountService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public Account LoginAsUser(String Phone, String Password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        return mapper.LoginAsUser(Phone,Password);
    }
}
