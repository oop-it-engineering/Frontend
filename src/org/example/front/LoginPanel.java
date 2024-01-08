package org.example.front;

import org.example.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton loginBtn, signupBtn;
    private JTextField idField;  // 학번 입력 필드

    public LoginPanel(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        
        JLabel title = new JLabel("IT공학과 기기 대여 시스템");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setBounds(100, 20, 300, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

        JLabel idFieldLabel = new JLabel("학번:");
        idFieldLabel.setFont(new Font("SanSerif", Font.PLAIN, 16));
        idFieldLabel.setBounds(50, 120, 50, 30);
        add(idFieldLabel);
        
        idField = new JTextField();
        idField.setBounds(110, 120, 290, 30);
        add(idField);
        
        loginBtn = new JButton("로그인");
        loginBtn.setBounds(110, 170, 290, 40);
        loginBtn.addActionListener(this);
        add(loginBtn);

        signupBtn = new JButton("회원가입");
        signupBtn.setBounds(110, 230, 290, 40);
        signupBtn.addActionListener(this);
        add(signupBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if(e.getSource() == signupBtn) {
            win.change("회원가입 화면으로");
        }
    }
}
