package com.itShuai.service.impl;

import com.itShuai.mapper.DeliveryMapper;
import com.itShuai.pojo.Delivery;
import com.itShuai.service.DeliveryService;
import com.itShuai.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeliveryServiceImpl implements DeliveryService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public Delivery GetDeliveryInfo(Integer DeliveryId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeliveryMapper mapper = sqlSession.getMapper(DeliveryMapper.class);
        return mapper.GetDeliveryInfo(DeliveryId);
    }
}
