package com.donghua.ssm.services.impl;

import com.donghua.ssm.dao.IOrdersDao;
import com.donghua.ssm.domain.Orders;
import com.donghua.ssm.services.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        //这个分页的必须放在方法调用的上面紧贴着，不然没用 pagenum：页码值（就是第几页第几页），pagesize：每页有几条数据
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) {
        return iOrdersDao.findById(ordersId);
    }

    @Override
    public void deleteOrder(String orderId) {
        iOrdersDao.deleteOrder_travellerByOrderId(orderId);
        iOrdersDao.deleteOrder(orderId);
    }

    @Override
    public void save(Orders orders) {
        iOrdersDao.save(orders);
    }
}
