package org.example.test;

import org.example.test.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class Test2 {
    @RequestMapping("/login")
    public String userLogin(String userId, String password) throws SQLException {
        Connection connection = null;
        try {
            //先连上数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            //jdbc查账号
            PreparedStatement stmt = connection.prepareStatement("select * from user where user_id = ?");
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            //先验证账号
            if (!rs.next()) {
                return "账号密码错误";
            }
            //刚才的rs中已经读取到了关于用户的所有信息，我们将他通过数据库中的字段名称获取后，通过User类的构造方法储存
            User user = new User(
                    rs.getString("user_id"),
                    rs.getString("user_pwd"));
            //如果数据库中存储对应的密码与你输入的密码不匹配，返回密码错误，把不为空的值放在前可以有效避免空指针异常，
            if (!(user.getPassword()).equals(password)) {
                return "账号密码错误";
            }

            return "登录成功";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
        }
    }
}
