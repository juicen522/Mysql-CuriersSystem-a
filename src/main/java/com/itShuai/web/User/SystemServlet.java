package com.itShuai.web.User;

import com.alibaba.fastjson.JSON;
import com.itShuai.pojo.Account;
import com.itShuai.pojo.Admin;
import com.itShuai.pojo.Delivery;
import com.itShuai.pojo.User;
import com.itShuai.service.AccountService;
import com.itShuai.service.AdminService;
import com.itShuai.service.DeliveryService;
import com.itShuai.service.UserService;
import com.itShuai.service.impl.AccountServiceImpl;
import com.itShuai.service.impl.AdminServiceImpl;
import com.itShuai.service.impl.DeliveryServiceImpl;
import com.itShuai.service.impl.UserServiceImpl;
import com.itShuai.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/*")
public class SystemServlet extends BaseServlet {
    private UserService userService =new UserServiceImpl();
    private AdminService adminService = new AdminServiceImpl();
    private AccountService accountService = new AccountServiceImpl();
    private DeliveryService deliveryService = new DeliveryServiceImpl();

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String allowedOrigin = "*";
        response = ResolveCrossdomainRequests(response,allowedOrigin);
        User user = userService.selectUserId(Integer.valueOf(request.getParameter("id")));
        System.out.println(user);
        if(user == null){
            response.getWriter().write(" ");
        }else {
//            数据转换为json
            String jsonString = JSON.toJSONString(user);
//            写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }
    public void LoginAsAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决跨域请求
        String allowedOrigin = "*";
        response = ResolveCrossdomainRequests(response,allowedOrigin);
        Admin admin = adminService.LoginAsAdmin(request.getParameter("Account"),request.getParameter("Password"));
        System.out.println(admin);
        if (admin==null){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(admin);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void LoginAsUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决跨域请求
        String allowedOrigin = "*";
        response = ResolveCrossdomainRequests(response,allowedOrigin);
        Account account = accountService.LoginAsUser(request.getParameter("Phone"),request.getParameter("Password"));
        System.out.println(account);
        if (account==null){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(account);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void GetDeliveryInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决跨域请求
        String allowedOrigin = "*";
        response = ResolveCrossdomainRequests(response,allowedOrigin);
        Delivery delivery = deliveryService.GetDeliveryInfo(Integer.valueOf(request.getParameter("DeliveryId")));
        System.out.println(delivery);
        if (delivery==null){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(delivery);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }


    }
    public HttpServletResponse ResolveCrossdomainRequests(HttpServletResponse response,String allowedOrigin){
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        return response;
    }
}
