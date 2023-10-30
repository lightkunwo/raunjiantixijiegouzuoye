package controller;

import KWIC.Pipe_.*;

import java.io.File;
import java.io.IOException;

/**
 * 管道-过滤软件
 */
public class method4 {
    public static String pipe(String filePath) throws IOException {
        File inFile = new File(filePath);
        File outFile = new File("D:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
        return "D:\\output.txt";
    }
}
