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

        JLabel title = new JLabel("HOME");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setBounds(100, 70, 300, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

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
            JDialog dialog = new JDialog(win, "문의하기");
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 330);

            ImageIcon qrCode = new ImageIcon(getClass().getResource("/resources/images/qrcode.png"));
            JLabel qrCodeLabel = new JLabel(qrCode);
            qrCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel timerLabel = new JLabel("15초 후에 자동으로 닫힙니다.", SwingConstants.CENTER);
            timerLabel.setFont(new Font("SanSerif", Font.BOLD, 15));

            dialog.add(qrCodeLabel, BorderLayout.CENTER);
            dialog.add(timerLabel, BorderLayout.SOUTH);

            Thread thread = new Thread(new Runnable() {
                private int count = 15;

                @Override
                public void run() {
                    while (count >= 0) {
                        try {
                            SwingUtilities.invokeLater(() -> timerLabel.setText(count + "초 후에 자동으로 닫힙니다."));
                            Thread.sleep(1000); // 1초 대기
                            count--;
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    dialog.dispose(); // 다이얼로그 닫기
                }
            });

            thread.start(); // 쓰레드 시작
            dialog.setVisible(true); // 다이얼로그 보여주기
        }
    }
}