package com.donghua.ssm.services.impl;

import com.donghua.ssm.dao.IProductDao;
import com.donghua.ssm.domain.Product;
import com.donghua.ssm.services.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
   @Autowired
   private IProductDao productDao;
    @Override
    public List<Product> findall(int page,int size) {
        //这个分页的必须放在方法调用的上面紧贴着，不然没用 pagenum：页码值（就是第几页第几页），pagesize：每页有几条数据
        PageHelper.startPage(page,size);
        return productDao.findall();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
