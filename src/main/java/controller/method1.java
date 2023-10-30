package controller;

import KWIC.Main_.demo1;

/**
 * 主程序--子程序
 */
public class method1 {
    public static String MainHandle(String filePath){
        demo1 kwic = new demo1();
        kwic.input(filePath);
        kwic.shift();
        kwic.alphabetizer();
        kwic.output("D:\\output.txt");//输出文件
        return "D:\\output.txt";
    }
}
