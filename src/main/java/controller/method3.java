package controller;

import KWIC.observe_.*;

/**
 * 事件系统
 */
public class method3 {
    public static String observe(String filePath){
        //创建主题
        KWICSubject kwicSubject = new KWICSubject();
        //创建观察者
        Input input = new Input(filePath);
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "D:\\output.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
         return "D:\\output.txt";
    }
}
