package com.itShuai.service.impl;

import com.itShuai.mapper.UserMapper;
import com.itShuai.pojo.Account;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import com.itShuai.service.UserService;
import com.itShuai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User selectUserId(Integer UserId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUserId(UserId);
    }

    @Override
    public User LoginAsUser(String Phone, String Password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.LoginAsUser(Phone,Password);
    }

    @Override
    public void RegisterUserAccount(String Sex, String Name, String Address, String Phone, String Password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.RegisterUserAccount(Sex,Name,Address,Phone,Password);
        sqlSession.commit();
    }

    @Override
    public List<Delivery> AllRecDelivery(Integer RecipientId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.AllRecDelivery(RecipientId);
    }

    @Override
    public List<Delivery> AllSendDelivery(Integer SenderId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.AllSendDelivery(SenderId);
    }

    @Override
    public Delivery SearchDeliveryById(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.SearchDeliveryById(DeliveryId);
    }

    @Override
    public void SendDelivery(Integer SenderId, Integer RecipientId, String SenderAddress, String RecipientAddress) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.SendDelivery(SenderId,RecipientId,SenderAddress,RecipientAddress);
        sqlSession.commit();
    }


}
