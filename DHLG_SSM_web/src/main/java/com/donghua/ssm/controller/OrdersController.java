package com.donghua.ssm.controller;

import com.donghua.ssm.domain.Orders;
import com.donghua.ssm.services.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    /*未分页

    @Autowired
    private IOrdersService ordersService;
     @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
         ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ordersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/

    @Autowired
    private IOrdersService ordersService;
    @RequestMapping("/findAll.do")
    //@Secured("ROLE_USER")//第二种设置权限的 注意ROLE_前缀不能省
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ordersService.findAll(page,size);
        //pageinfo就是一个分页bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId){
        ModelAndView mv=new ModelAndView();
        Orders orders=ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return  mv;
    }

    @RequestMapping("/deleteOrder.do")
    public String deleteOrder(@RequestParam(name = "id",required = true) String orderId){
        ordersService.deleteOrder(orderId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    public String save(Orders orders){
        ordersService.save(orders);
        return "redirect:findAll.do";
    }



}
