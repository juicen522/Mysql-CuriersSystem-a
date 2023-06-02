package com.itShuai.web.Service;

import com.alibaba.fastjson.JSON;
import com.itShuai.pojo.*;
import com.itShuai.service.AdminService;
import com.itShuai.service.CourierService;
import com.itShuai.service.UserService;
import com.itShuai.service.impl.AdminServiceImpl;
import com.itShuai.service.impl.CourierServiceImpl;
import com.itShuai.service.impl.UserServiceImpl;
import com.itShuai.web.BaseServlet;
import com.sun.org.apache.bcel.internal.generic.PUSH;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.List;

@WebServlet("/*")
public class SystemServlet extends BaseServlet {
    private UserService userService =new UserServiceImpl();
    private AdminService adminService = new AdminServiceImpl();
    private CourierService courierService = new CourierServiceImpl();



    public void addCourier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
            String Name = request.getParameter("Name");
            String Sex = request.getParameter("Sex");
            String Phone = request.getParameter("Phone");
            if (request.getParameter("StationId")==null)
            {
                response.getWriter().write("NULL");
            }else {
                Integer StationId = Integer.valueOf(request.getParameter("StationId"));
                String Password = request.getParameter("Password");
                try {
                    adminService.addCourier(Name,Sex,Phone,StationId,Password);
                    response.getWriter().write("SUCCESS");
                }catch (Exception e){
                    e.printStackTrace();
                    response.getWriter().write("ERROR");
                }

            }
    }
    public void updateCourierById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        if(request.getParameter("CourierId")==null){
            response.getWriter().write("NULL");
        }else{
            Integer CourierId = Integer.valueOf(request.getParameter("CourierId"));
            String Name = request.getParameter("Name");
            String Sex = request.getParameter("Sex");
            String Phone = request.getParameter("Phone");
            if (request.getParameter("StationId")==null)
            {
                response.getWriter().write("NULL");
            }else {
                Integer StationId = Integer.valueOf(request.getParameter("StationId"));
                String Password = request.getParameter("Password");
                try {
                    adminService.updateCourierById(CourierId,Name,Sex,Phone,StationId,Password);
                    response.getWriter().write("SUCCESS");
                }catch (Exception e){
                    e.printStackTrace();
                    response.getWriter().write("ERROR");
                }

            }
        }
    }
    public void selectCourierById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        if(request.getParameter("CourierId")==null){
            response.getWriter().write("NULL");
        }else{
            Integer CourierId = Integer.valueOf(request.getParameter("CourierId"));

            Courier  courier = adminService.selectCourierById(CourierId);

            if (courier == null) {
                response.getWriter().write("NULL");
            } else {
                //把查询结果转为json
                String jsonString = JSON.toJSONString(courier);
                //写数据
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(jsonString);
            }
        }

    }

    public void deleteDeliveryById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        if (request.getParameter("DeliveryId")==null){
            response.getWriter().write("NULL");
        }else {
            Integer DeliveryId = Integer.valueOf(request.getParameter("DeliveryId"));
            try {
                adminService.deleteDeliveryById(DeliveryId);
                response.getWriter().write("SUCCESS");
            }catch (Exception e){
                e.printStackTrace();
                response.getWriter().write("ERROR");
            }

        }
    }
    public void deleteDeliveryStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        if (request.getParameter("DeliveryId")==null){
            response.getWriter().write("NULL");
        }else {
            Integer DeliveryId = Integer.valueOf(request.getParameter("DeliveryId"));
            try {
                adminService.deleteDeliveryStatus(DeliveryId);
                response.getWriter().write("SUCCESS");
            }catch (Exception e){
                e.printStackTrace();
                response.getWriter().write("ERROR");
            }

        }
    }

    public void CourierLogIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        //获取请求头的账号和密码
        String Phone = request.getParameter("Phone");
        String Password = request.getParameter("Password");
        //用service查询
        Courier courier = courierService.CourierLogIn(Phone, Password);
        if (courier == null) {
            //
            response.getWriter().write("null");
        } else {
            //转换为Json
            String jsonString = JSON.toJSONString(courier);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void selectDeliveryStatusByCourierId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //封装DeliveryStatus数据传送给前端
        response = ResolveCrossdomainRequests(response);

        Integer CourierId = Integer.valueOf(request.getParameter("CourierId"));

        List<DeliveryStatus>  deliveryStatuses = courierService.selectDeliveryStatusByCourierId(CourierId);

        if (deliveryStatuses == null) {
            response.getWriter().write("该快递员无包裹");
        } else {
            //把查询结果转为json
            String jsonString = JSON.toJSONString(deliveryStatuses);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void selectDeliveryByDeliveryId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectDeliveryByDeliveryId方法,封装json数据传送到前端

        response = ResolveCrossdomainRequests(response);
        Integer DeliveryId = Integer.valueOf(request.getParameter("DeliveryId"));
        Delivery delivery = courierService.selectDeliveryByDeliveryId(DeliveryId);

        if (delivery == null) {
            response.getWriter().write("查询失败，不存在该包裹");
        } else {
            //把查询结果转为json
            String jsonString = JSON.toJSONString(delivery);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void getDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //给Courier包裹

        response = ResolveCrossdomainRequests(response);
        Integer CourierId = Integer.valueOf(request.getParameter("CourierId"));
        courierService.getDelivery(CourierId);
    }

    public void setDeliveryStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //给Courier包裹

        response = ResolveCrossdomainRequests(response);
        Integer DeliveryId = Integer.valueOf(request.getParameter("DeliveryId"));
        courierService.setDeliveryStatus(DeliveryId);
    }

    public void SendDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        Integer SenderId = Integer.valueOf(request.getParameter("SenderId"));
        Integer RecipientId = Integer.valueOf(request.getParameter("RecipientId"));
        String SenderAddress = new String(request.getParameter("SenderAddress").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String RecipientAddress = new String(request.getParameter("RecipientAddress").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        try {
            userService.SendDelivery(SenderId,RecipientId,SenderAddress,RecipientAddress);
            response.getWriter().write("SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write("null");
        }
    }
    public void DeleteUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        Integer UserId = Integer.valueOf(request.getParameter("UserId"));
        try {
            adminService.DeleteUserById(UserId);
            response.getWriter().write("SUCCESS DELETE");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write("ERROR");
        }

    }
    public void selectUserByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        Integer UserId = Integer.valueOf(request.getParameter("UserId"));
        User user = adminService.selectUserByUserId(UserId);
        if (user==null){
            response.getWriter().write("NULL");
        }else {
            String jsonString = JSON.toJSONString(user);
//            写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void deleteCourierById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        Integer CourierId = Integer.valueOf(request.getParameter("CourierId"));
        try {
            courierService.deleteCourierById(CourierId);
            response.getWriter().write("SUCCESS DELETE");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write("ERROR");
        }
    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        User user = userService.selectUserId(Integer.valueOf(request.getParameter("id")));
        System.out.println(user);
        if(user == null){
            response.getWriter().write("null");
        }else {
//            数据转换为json
            String jsonString = JSON.toJSONString(user);
//            写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }
    public void RegisterUserAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决跨域请求
        response = ResolveCrossdomainRequests(response);
        System.out.println(request.getParameter("Sex"));
        String Sex = new String(request.getParameter("Sex").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String Name = new String(request.getParameter("Name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String Address = new String(request.getParameter("Address").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String Phone = new String(request.getParameter("Phone").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String Password = new String(request.getParameter("Password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(Sex+Name+Address+Phone+Password);
        try {
            userService.RegisterUserAccount(Sex,Name,Address,Phone,Password);
//            写数据
            response.setContentType("application/json;charset=utf-8");

            response.getWriter().write("SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write("null");
        }
    }
    public void LoginAsAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决跨域请求
        response = ResolveCrossdomainRequests(response);
        Admin admin = adminService.LoginAsAdmin(request.getParameter("Account"),request.getParameter("Password"));
        System.out.println(admin);
        System.out.println(request.getParameter("Account")+request.getParameter("Password"));
        if (admin==null){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(admin);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void LoginAsUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        User user = userService.LoginAsUser(request.getParameter("Phone"),request.getParameter("Password"));
        System.out.println(user);
        if (user==null){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(user);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void ChangeDeliveryStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        Integer DeliveryId = Integer.valueOf(request.getParameter("DeliveryId"));
        String Status = new String(request.getParameter("DeliveryStatus").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        try {
            adminService.ChangeDeliveryStatus(DeliveryId,Status);
            response.getWriter().write("SUCCESS UPDATE");
        }catch (Exception e){
            response.getWriter().write("ERROR");
        }


    }
    public void AllRecDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        List<Delivery> deliveries = userService.AllRecDelivery(Integer.valueOf(request.getParameter("UserId")));
        System.out.println(deliveries);
        if (deliveries.isEmpty()){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(deliveries);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void AllSendDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        List<Delivery> deliveries = userService.AllRecDelivery(Integer.valueOf(request.getParameter("UserId")));
        System.out.println(deliveries);
        if (deliveries.isEmpty()){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(deliveries);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void FindAllDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        List<Delivery> deliveries = adminService.FindAllDelivery();
        System.out.println(deliveries);
        if (deliveries.isEmpty()){
            response.getWriter().write("null");
        }else {
            String jsonString = JSON.toJSONString(deliveries);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }
    public void selectDeliveryByDeliveryID(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response = ResolveCrossdomainRequests(response);
        if (request.getParameter("DeliveryId")==null)
        {
            response.getWriter().write("null");
        }
        else {
            Delivery delivery = adminService.selectDeliveryByDeliveryID(Integer.valueOf(request.getParameter("DeliveryId")));
            System.out.println(delivery);
            if (delivery==null){
                response.getWriter().write("null");
            }else {
                String jsonString = JSON.toJSONString(delivery);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(jsonString);
            }
        }

    }
    public HttpServletResponse ResolveCrossdomainRequests(HttpServletResponse response){
        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        return response;
    }
}
