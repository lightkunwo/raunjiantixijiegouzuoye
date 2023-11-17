package cs3.Service;


import cs3.Dao.JDBC;
import cs3.pojo.lianxiren;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class lianxirenService {
    static Scanner sc=new Scanner(System.in);
    public void insert(){
        System.out.println("请输入联系人姓名和电话");
        String name=sc.next();
        String phone=sc.next();
        while (phone.length()!=11){
            System.out.println("请重新输入电话号码!");
            phone=sc.next();
        }
        if(cs2_.Dao.JDBC.insert(name,phone)==1) System.out.println("添加成功!");
        else System.out.println("添加失败");

    }

    public void delete(){
        System.out.println("请输入要删除的联系人姓名");
        String name2=sc.next();
        if(cs2_.Dao.JDBC.delete(name2)==1) System.out.println("删除成功！");else System.out.println("删除失败");

    }
    public void update(){
        System.out.println("请输入要修改的联系人姓名");
        String name3=sc.next();
        System.out.println("请输入新的联系人姓名");
        String newName=sc.next();
        System.out.println("请输入新的联系人电话");
        String newPhone=sc.next();
        if(cs2_.Dao.JDBC.update(name3,newName,newPhone)==1) System.out.println("修改成功");else System.out.println("修改失败");
    }
    public void select(){
        try {
            List<lianxiren> query = JDBC.query();
            System.out.println(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
