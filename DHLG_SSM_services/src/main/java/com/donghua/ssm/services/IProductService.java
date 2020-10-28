package com.donghua.ssm.services;

import com.donghua.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findall(int page,int size);

    void save(Product product);

    void deleteProduct(String productId);
}
