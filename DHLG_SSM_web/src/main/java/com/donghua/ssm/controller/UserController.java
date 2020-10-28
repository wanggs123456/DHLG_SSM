package com.donghua.ssm.controller;


import com.donghua.ssm.domain.Role;
import com.donghua.ssm.domain.UserInfo;
import com.donghua.ssm.services.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @RequestMapping("/save.do")
    //@PreAuthorize("authentication.principal.username=='wgs'")第三种
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    //@PreAuthorize("hasRole('Role_ADMIN')") 第三种
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer pageSize){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> userList= (List<UserInfo>) userService.findAll(page,pageSize);
        PageInfo pageInfo=new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }



    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;

    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(userId);
        List<Role> otherRoles= userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    /*@RequestMapping("/deleteOrder.do")
    public String deleteOrder(@RequestParam(name = "id",required = true) String orderId){
        ordersService.deleteOrder(orderId);
        return "redirect:findAll.do";
    }*/

    @RequestMapping("/deleteUser.do")
    public String deleteUser(@RequestParam(name = "id",required = true) String userId){
        userService.deleteUser(userId);
        return "redirect:findAll.do";
    }


}
