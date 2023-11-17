package cs2_;

import cs2_.Dao.JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        boolean flag=true;
        while(flag) {
        int c;
        System.out.println("请输入您想要的选择:");
        System.out.println("1-添加联系人，2-删除联系人，3-修改联系人，4-查看联系人信息,5-退出");
        c=sc.nextInt();
            switch (c) {
                case 1:
                    System.out.println("请输入联系人姓名和电话");
                    String name = sc.next();
                    String phone = sc.next();
                    if (JDBC.insert(name, phone) == 1) System.out.println("添加成功!");
                    else System.out.println("添加失败");
                    break;
                case 2:
                    System.out.println("请输入要删除的联系人姓名");
                    String name2 = sc.next();
                    if (JDBC.delete(name2) == 1) System.out.println("删除成功！");
                    else System.out.println("删除失败");
                    break;
                case 3:
                    System.out.println("请输入要修改的联系人姓名");
                    String name3 = sc.next();
                    System.out.println("请输入新的联系人姓名");
                    String newName = sc.next();
                    System.out.println("请输入新的联系人电话");
                    String newPhone = sc.next();
                    if (JDBC.update(name3, newName, newPhone) == 1) System.out.println("修改成功");
                    else System.out.println("修改失败");
                    break;
                case 4:
                    JDBC.query();
                    break;
                case 5:
                    System.out.println("bye~~");
                    flag=false;
            }
        }
    }
}
