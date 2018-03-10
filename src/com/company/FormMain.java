package com.company;

import javax.swing.*;

public class FormMain {
    private static int progress = 0;
    private int countThreads = 0;
    private JButton button1;
    public JPanel panel1;
    private JProgressBar progressBar1;
    private JButton button2;
    private JProgressBar progressBar2;
    private JLabel text1;

    JPanel init() {
        button1.addActionListener(e -> startProgress());
        button2.addActionListener(e -> startProgress2());
        button1.setText("Simple method");
        button2.setText("Synchronized method");
        text1.setText("Threads : "+countThreads);
        return this.panel1;
    }

    private void startProgress2() {
        text1.setText("Threads : "+countThreads++);
        new Thread(this::progressUpS).start();
    }


    private void startProgress() {
        countThreads++;
        text1.setText("Threads : "+countThreads);
        new Thread(this::progressUp).start();
    }

    private synchronized void progressUpS() {

        for (; progress <= 101; progress++) {
            if (progress > 100) {
                progress = 0;
                System.out.println(Thread.currentThread() + " Break");
                countThreads--;
                text1.setText("Threads : "+countThreads);
                break;
            }

            setProgress();

            System.out.println(Thread.currentThread() + " Progress : " + progress);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    private  void progressUp() {

        for (; progress <= 101; progress++) {
            if (progress > 100) {
                progress = 0;
                System.out.println(Thread.currentThread() + " Break");
                countThreads--;
                text1.setText("Threads : "+countThreads);
                break;
            }

            setProgress();

            System.out.println(Thread.currentThread() + " Progress : " + progress);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    private void setProgress() {

        progressBar1.setValue(progress);
        progressBar2.setValue(progress);
    }


}
