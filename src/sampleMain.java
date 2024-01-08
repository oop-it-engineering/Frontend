import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class sampleMain extends JFrame {

    public sampleMain(String userID) {
        setTitle("앱 이름 - 메인");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myPagePanel = new JPanel();
        myPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(myPagePanel);
        myPagePanel.setLayout(null);
        myPagePanel.setBackground(Color.WHITE); //배경 색


        JLabel label_ID = new JLabel(userID + " 님, 환영합니다!");
        label_ID.setBounds(0, 20, 400, 20);
        label_ID.setHorizontalAlignment(JLabel.RIGHT);
        myPagePanel.add(label_ID);

        JLabel label1 = new JLabel("메인페이지");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(150, 60, 150, 20);
        myPagePanel.add(label1);
        setVisible(true);
    }
}
