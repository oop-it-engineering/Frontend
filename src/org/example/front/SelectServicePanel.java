package org.example.front;

import org.example.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectServicePanel extends JPanel implements ActionListener {
    private Main win;
    private JButton rentBtn, inquiryBtn, backBtn, myPageBtn;

    public SelectServicePanel(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        rentBtn = new JButton("대여하기");
        rentBtn.setBounds(100, 120, 300, 50);
        rentBtn.addActionListener(this);
        add(rentBtn);

        inquiryBtn = new JButton("문의하기");
        inquiryBtn.setBounds(100, 200, 300, 50);
        inquiryBtn.addActionListener(this);
        add(inquiryBtn);

        backBtn = new JButton("뒤");
        backBtn.setBounds(10, 20, 80, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        myPageBtn = new JButton("마이페이지");
        myPageBtn.setBounds(100, 20, 140, 30);
        myPageBtn.addActionListener(this);
        add(myPageBtn);

        JLabel welcomeLabel = new JLabel("눈송이님, 환영합니다!");
        welcomeLabel.setFont(new Font("SanSerif", Font.BOLD, 10));
        welcomeLabel.setBounds(360, 20, 200, 30);
        add(welcomeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("로그인 화면으로");
        }
        else if (e.getSource() == rentBtn) {
            win.change("장비 선택 화면으로");
        }
        else if (e.getSource() == inquiryBtn) {
            JOptionPane.showMessageDialog(win, "QR 코드", "문의하기", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}