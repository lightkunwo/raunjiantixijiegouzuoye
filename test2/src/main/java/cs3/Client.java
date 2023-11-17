package cs3;

import cs3.Service.lianxirenService;

import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    static Scanner sc=new Scanner(System.in);
    static lianxirenService service=new lianxirenService();
    public static void main(String[] args) throws SQLException {
        boolean flag = true;
        while (flag) {
            int c;
            System.out.println("请输入您想要的选择:");
            System.out.println("1-添加联系人，2-删除联系人，3-修改联系人，4-查看联系人信息,5-退出");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    service.insert();
                    break;
                case 2:
                    service.delete();
                    break;
                case 3:
                    service.update();
                    break;
                case 4:
                    service.select();
                    break;
                case 5:
                    flag=false;
                    System.out.println("bye~");
                    break;
            }
        }
    }
}
