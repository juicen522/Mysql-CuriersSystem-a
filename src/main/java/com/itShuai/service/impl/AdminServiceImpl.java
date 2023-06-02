package com.itShuai.service.impl;

import com.itShuai.mapper.AdminMapper;
import com.itShuai.mapper.DeliveryMapper;
import com.itShuai.pojo.Admin;
import com.itShuai.pojo.Delivery;
import com.itShuai.service.AdminService;
import com.itShuai.util.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public Admin LoginAsAdmin(String Account, String Password) {
        //开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.LoginAsAdmin(Account,Password);
    }

    @Override
    public List<Delivery> FindAllDelivery() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.FindAllDelivery();
    }

    @Override
    public Delivery selectDeliveryByDeliveryID(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.selectDeliveryByDeliveryID(DeliveryId);
    }
}
