package com.donghua.ssm.dao;

import com.donghua.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {
    //根据id查询
    @Select("select * from product where id=#{id}")
    public Product findById(String id);


    @Select("select * from product")
    /*@Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "productNum",column = "productNum"),
            @Result(property = "productName",column = "productName"),
            @Result(property = "cityName",column = "cityName"),
            @Result(property = "departureTime",column = "departureTime"),
            @Result(property = "productPrice",column = "productPrice"),
            @Result(property = "productDesc",column = "productDesc"),
            @Result(property = "productStatus",column = "productStatus"),

    })*/
    public List<Product> findall();

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    //@Insert("insert into product(productNum,productName,cityName,productPrice,departureTime,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{productPrice},#{departureTime},#{productDesc},#{productStatus})")
    void save(Product product);
}
