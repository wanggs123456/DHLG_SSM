package com.donghua.ssm.services;

import com.donghua.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(int page,int size);
    Orders findById(String ordersId);
}
