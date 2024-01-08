package org.example;

import org.example.front.*;
import javax.swing.*;

public class Main extends JFrame {
    public LoginPanel loginPanel = null;
    public SignupPanel signupPanel = null;
    public SelectServicePanel selectServicePanel = null;
    public SelectEquipPanel selectEquipPanel = null;
    public ListLaptopPanel listLaptopPanel = null;
    public ListPadPanel listPadPanel = null;
    public ListMobilePanel listMobilePanel = null;
    public ListOtherPanel listOtherPanel = null;

    public void change(String panelName) {
        getContentPane().removeAll();

        if (panelName.equals("로그인 화면으로")) {
            getContentPane().add(loginPanel);
        }
        else if (panelName.equals("회원가입 화면으로")) {
            getContentPane().add(signupPanel);
        }
        else if (panelName.equals("대여/문의 선택 화면으로")) {
            getContentPane().add(selectServicePanel);
        }
        else if (panelName.equals("장비 선택 화면으로")) {
            getContentPane().add(selectEquipPanel);
        }
        else if (panelName.equals("랩탑 선택 화면으로")) {
            getContentPane().add(listLaptopPanel);
        }
        else if (panelName.equals("패드 선택 화면으로")) {
            getContentPane().add(listPadPanel);
        }
        else if (panelName.equals("모바일 기기 선택 화면으로")) {
            getContentPane().add(listMobilePanel);
        }
        else if (panelName.equals("기타 기기 선택 화면으로")) {
            getContentPane().add(listOtherPanel);
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Main win = new Main();
        win.setTitle("IT공학과 기기 대여 시스템");
        win.loginPanel = new LoginPanel(win);
        win.signupPanel = new SignupPanel(win);
        win.selectServicePanel = new SelectServicePanel(win);
        win.selectEquipPanel = new SelectEquipPanel(win);
        win.listLaptopPanel = new ListLaptopPanel(win);
        win.listPadPanel = new ListPadPanel(win);
        win.listMobilePanel = new ListMobilePanel(win);
        win.listOtherPanel = new ListOtherPanel(win);
        win.add(win.loginPanel);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 650);
        win.setVisible(true);
        win.setResizable(false);
    }
}
