package com.company;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        // write your code here

        JFrame frame = new JFrame();
        frame.setContentPane(new FormMain().init());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
