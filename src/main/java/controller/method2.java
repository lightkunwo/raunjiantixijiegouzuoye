package controller;

import KWIC.mianxiang.*;

/**
 * 方法2:面向对象
 */
public class method2 {
    public static String mianxiangduixiangHandle(String filePath){
        Input input = new Input();
        input.input(filePath);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");
        return "D:\\output.txt";
    }
}
