package com.donghua.ssm.dao;

import com.donghua.ssm.domain.Member;
import com.donghua.ssm.domain.Orders;
import com.donghua.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.donghua.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll();

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.donghua.ssm.dao.IProductDao.findById")),
            @Result(property ="member",column = "memberId",javaType = Member.class,one = @One(select="com.donghua.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class, many = @Many(select = "com.donghua.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);

    @Delete("delete from orders where id=#{orderId}")
    void deleteOrder(String orderId);
    @Delete("delete from order_traveller where orderId=#{orderId}")
    void deleteOrder_travellerByOrderId(String orderId);

    @Insert("insert into orders(orderNum,orderTime,orderStatus,peopleCount,payType,orderDesc) values(#{orderNum},#{orderTime},#{orderStatus},#{peopleCount},#{payType},#{orderDesc})")
    void save(Orders orders);
}
