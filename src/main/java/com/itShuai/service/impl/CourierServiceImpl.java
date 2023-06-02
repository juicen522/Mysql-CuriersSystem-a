package com.itShuai.service.impl;

import com.itShuai.mapper.CourierMapper;
import com.itShuai.pojo.Courier;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.DeliveryStatus;
import com.itShuai.service.CourierService;
import com.itShuai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourierServiceImpl implements CourierService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public Courier CourierLogIn(String Phone, String Password) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        CourierMapper mapper = sqlSession.getMapper(CourierMapper.class);

        //3.执行查询所有
        Courier courier = mapper.CourierLogIn(Phone,Password);

        return courier;
    }

    @Override
    public List<DeliveryStatus> selectDeliveryStatusByCourierId(Integer CourierId) {
       SqlSession sqlSession = sqlSessionFactory.openSession();
       CourierMapper mapper = sqlSession.getMapper(CourierMapper.class);
       List<DeliveryStatus> deliveryStatus = mapper.selectDeliveryStatusByCourierId(CourierId);
       return deliveryStatus;
    }

    @Override
    public Delivery selectDeliveryByDeliveryId(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourierMapper mapper = sqlSession.getMapper(CourierMapper.class);
        Delivery delivery = mapper.selectDeliveryByDeliveryId(DeliveryId);
        return delivery;
    }

    @Override
    public void getDelivery(Integer CourierId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourierMapper mapper = sqlSession.getMapper(CourierMapper.class);
        mapper.getDelivery(CourierId);
        sqlSession.commit();
    }
    @Override
    public void setDeliveryStatus(Integer DeliveryId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourierMapper mapper = sqlSession.getMapper(CourierMapper.class);
        mapper.setDeliveryStatus(DeliveryId);
        sqlSession.commit();
    }

}
