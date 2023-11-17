package view;
import controller.method1;
import controller.method2;
import controller.method3;
import controller.method4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class showSystem extends JFrame {
    JPanel functionPanel = new JPanel();//功能面板
    JScrollPane inputScrollPane;//输入框
    JScrollPane outputScrollPane;//输出框
    JFileChooser fileChooser = new JFileChooser();
    JTextArea outputArea = new JTextArea();
    JFrame frame = new JFrame("原理图片");

    private JTextArea inputArea;
    JComboBox<String> methodBox = new JComboBox<>(new String[]{"主程序-子程序软件体系结构", "面向对象软件体系结构", "事件系统软件体系结构", "管道-过滤软件体系结构"});

    public static void main(String[] args) {
        showSystem GUI = new showSystem();
        GUI.showFrame();

    }
    public void showFrame() {
        this.setVisible(true);
        this.setTitle("经典软件体系结构教学软件");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1000, 500);
        // 添加功能面板
        functionPanel.setLayout(new GridLayout(3,2));
        functionPanel.setBounds(0, 0, 300, 300);
        functionPanel.add(new JLabel("请选择选择处理方式(KWIC算法处理)："));
        methodBox.setBackground(Color.green);
        functionPanel.add(methodBox);
        JButton button = new JButton("选择处理文件:需为TXT类型文件");
        button.setBackground(Color.pink);
        functionPanel.add(button);
        JLabel jLabel=new JLabel("PS:输出文件为电脑D盘output.txt文件");
//        jLabel.setBounds(0,0,100,100);
        jLabel.setHorizontalTextPosition(0);
        jLabel.setBounds(0, 0, 100, 100);
        JLabel jLabel2 = new JLabel("Welcome to FHH's System");
        functionPanel.add(jLabel);
        functionPanel.add(jLabel2);
        functionPanel.setBackground(Color.yellow);
//        按钮
//        JButton jButton = new JButton("弹窗显灵！");
//        jButton.setBounds(100, 100, 100, 70);
////       点击此按钮，会有弹窗。
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////
//
//            }
//        });
//        container.add(jButton);

        // 添加输入输出区域
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setEditable(false);
        inputScrollPane = new JScrollPane(inputArea);

        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        outputScrollPane = new JScrollPane(outputArea);
        addFunction(this);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProcessing();
            }
        });


    }

    public static void addFunction(showSystem showSystem) {
        // 将构件添加到主面板
        showSystem.getContentPane().add(showSystem.functionPanel, BorderLayout.NORTH);
        showSystem.getContentPane().add(showSystem.inputScrollPane, BorderLayout.WEST);
        showSystem.getContentPane().add(showSystem.outputScrollPane, BorderLayout.EAST);
    }

    private void startProcessing() {
//        选择看文件的方式
        Object selectedItem = methodBox.getSelectedItem();
        switch ((String) selectedItem) {
            case "主程序-子程序软件体系结构":
                MethodOne();
                break;
            case "面向对象软件体系结构":
                MethodTwo();
                break;
            case "事件系统软件体系结构":
                MethodThree();
                break;
            case "管道-过滤软件体系结构":
                MethodFour();
                break;
        }
    }
    private void MethodOne() {
        if (isFileRight() == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String inputContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));//Files的获取文件方法
                inputArea.setText(inputContent);//将文本显示到输入框上
                String outputPath = method1.MainHandle(selectedFile.getAbsolutePath());
                String outputContent = new String(Files.readAllBytes(Paths.get(outputPath)));
                outputArea.setText(outputContent);
                ImageIcon imageIcon = new ImageIcon("src/main/java/view/Main.png");
                JOptionPane.showMessageDialog(frame, "", frame.getTitle(), JOptionPane.PLAIN_MESSAGE, imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void MethodTwo() {
      

        if (isFileRight() == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String inputContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));//Files的获取文件方法
                inputArea.setText(inputContent);//将文本显示到输入框上
                String inputPath=selectedFile.getAbsolutePath();

                String outputPath = method2.mianxiangduixiangHandle(inputPath);
                String outputContent = new String(Files.readAllBytes(Paths.get(outputPath)));
                outputArea.setText(outputContent);
                ImageIcon imageIcon = new ImageIcon("src/main/java/view/mianxiangduixiang.png");
                JOptionPane.showMessageDialog(frame, "", frame.getTitle(), JOptionPane.PLAIN_MESSAGE, imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void MethodThree() {
      

        if (isFileRight() == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String inputContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));//Files的获取文件方法
                inputArea.setText(inputContent);//将文本显示到输入框上
                String inputPath=selectedFile.getAbsolutePath();
                String outputPath = method3.observe(inputPath);
                String outputContent = new String(Files.readAllBytes(Paths.get(outputPath)));
                outputArea.setText(outputContent);
                ImageIcon imageIcon = new ImageIcon("src/main/java/view/pipe.png");
                JOptionPane.showMessageDialog(frame, "", frame.getTitle(), JOptionPane.PLAIN_MESSAGE, imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void MethodFour() {
        
        if (isFileRight()== JFileChooser.APPROVE_OPTION) {//存在文件
            File selectedFile = fileChooser.getSelectedFile();
            try {
                String inputContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));//Files的获取文件方法
                inputArea.setText(inputContent);//将文本显示到输入框上
                String inputPath=selectedFile.getAbsolutePath();
                String outputPath = method4.pipe(inputPath);
                String outputContent = new String(Files.readAllBytes(Paths.get(outputPath)));
                outputArea.setText(outputContent);
                ImageIcon imageIcon = new ImageIcon("src/main/java/view/shijianSystem.png");
                JOptionPane.showMessageDialog(frame, "", frame.getTitle(), JOptionPane.PLAIN_MESSAGE, imageIcon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private int isFileRight(){
        int result = fileChooser.showOpenDialog(this);
        return result;
    }

}
