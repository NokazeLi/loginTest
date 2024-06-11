import org.example.test.model.User;
import org.example.test.service.UserService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //数据库用数组代替
        UserService userService = new UserService();
        userService.userService(10);
        User[] userList = userService.getUsers();
        //输入账号密码
        Scanner myScanner = new Scanner(System.in);
        System.out.print("账号：");
        String inputId = myScanner.next();
        System.out.print("密码：");
        String inputPwd = myScanner.next();

        //查看数组里的用户信息
        for (int i = 0; i < userList.length; i++) {
            //验证账号密码
            if(userList[i] == null){
                return;
            }
            if(!((userList[i].getPassword()).equals(inputPwd) && (userList[i].getUserId()).equals(inputId))){
                System.out.println("你的密码错误");
            }else{
                System.out.println("登陆成功");
            }
            System.out.println(userList[i]);
        }
    }
}
