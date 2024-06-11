package org.example.test.controller;

import org.example.test.model.User;
import org.example.test.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    public String userlogin(String username,String password){
        try {
            UserService userService = new UserService();
            userService.userService(10);
            User[] userList = userService.getUsers();

            for (int i = 0; i < userList.length; i++) {
                System.out.println(userList[i]);
            }
            //查询的用户下面没有内容，返回用户不存在

            //刚才的rs中已经读取到了关于用户的所有信息，我们将他通过数据库中的字段名称获取后，通过User类的构造方法储存
//            User user = new User(rs.getString("userId"),
//                                 rs.getString("password"));
//            //如果数据库中存储对应的密码与你输入的密码不匹配，返回密码错误，把不为空的值放在前可以有效避免空指针异常，
//            if(!(user.getPassword()).equals(password)){
//                return "你的密码错误";
//            }
//            conn.close();
//            ps.close();
//            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "登录成功";
    }
}
