import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEquipPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton laptopBtn, padBtn, mobileBtn, otherBtn, backBtn;

    public SelectEquipPanel(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        JLabel title = new JLabel("장비 선택");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setBounds(150, 20, 200, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

        laptopBtn = new JButton("랩탑");
        laptopBtn.setBounds(90, 120, 150, 50);
        laptopBtn.addActionListener(this);
        add(laptopBtn);

        padBtn = new JButton("패드");
        padBtn.setBounds(250, 120, 150, 50);
        padBtn.addActionListener(this);
        add(padBtn);

        mobileBtn = new JButton("모바일 기기");
        mobileBtn.setBounds(90, 180, 150, 50);
        mobileBtn.addActionListener(this);
        add(mobileBtn);

        otherBtn = new JButton("<html>기타 기기<br/>(아두이노)</html>");
        otherBtn.setBounds(250, 180, 150, 50);
        otherBtn.addActionListener(this);
        add(otherBtn);

        backBtn = new JButton("뒤");
        backBtn.setBounds(10, 20, 80, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        JLabel welcomeLabel = new JLabel("눈송이님, 환영합니다!");
        welcomeLabel.setFont(new Font("SanSerif", Font.BOLD, 10));
        welcomeLabel.setBounds(360, 20, 200, 30);
        add(welcomeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == laptopBtn) {
            win.change("랩탑 선택 화면으로");
        }
        else if (e.getSource() == padBtn) {
            win.change("패드 선택 화면으로");
        }
        else if (e.getSource() == mobileBtn) {
            win.change("모바일 기기 선택 화면으로");
        }
        else if (e.getSource() == otherBtn) {
            win.change("기타 기기 선택 화면으로");
        }
    }
}