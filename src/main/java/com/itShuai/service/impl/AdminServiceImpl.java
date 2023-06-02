package com.itShuai.service.impl;

import com.itShuai.mapper.AdminMapper;
import com.itShuai.mapper.DeliveryMapper;
import com.itShuai.mapper.UserMapper;
import com.itShuai.pojo.Admin;
import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import com.itShuai.service.AdminService;
import com.itShuai.util.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

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

    @Override
    public void ChangeDeliveryStatus(Integer DeliveryId, String DeliveryStatus) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.ChangeDeliveryStatus(DeliveryId,DeliveryStatus);
        sqlSession.commit();
    }
    @Override
    public void DeleteUserById(Integer UserId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.DeleteUserById(UserId);
        sqlSession.commit();
    }

    @Override
    public User selectUserByUserId(Integer UserId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.selectUserByUserId(UserId);
    }

    @Override
    public void deleteDeliveryStatus(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.deleteDeliveryStatus(DeliveryId);
        sqlSession.commit();
    }

    @Override
    public void deleteDeliveryById(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.deleteDeliveryById(DeliveryId);
        sqlSession.commit();
    }

    @Override
    public Courier selectCourierById(Integer CourierId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        return mapper.selectCourierById(CourierId);
    }

    @Override
    public void updateCourierById(Integer CourierId, String Name, String Sex, String Phone, Integer StationId, String Password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.updateCourierById(CourierId,Name,Sex,Phone,StationId,Password);
    }

    @Override
    public void addCourier(String Name, String Sex, String Phone, Integer StationId, String Password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.addCourier(Name,Sex,Phone,StationId,Password);
    }


}
