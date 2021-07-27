package GUI;

import Actions.MyKey;

import javax.swing.*;

public class Board extends JFrame {
    public static int width = 800, height = 600;
    public static int xoff = 130, yoff = 20;

    public Board() {
        this.setSize(width,height);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //nut dong
        this.setLocationRelativeTo(null);   //dua khung component vao giua man hinh
        this.setResizable(false);  // co dinh man hinh
        this.addKeyListener(new MyKey());
        Controller d = new Controller();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        this.add(d);
        this.requestFocus();
        this.setVisible(true);
    }
}
