import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPagePanel_2 extends JPanel implements ActionListener {
    private Main win;
    private DeviceDisplay deviceDisplay;
    private List<Device> devices;
    private JButton confirmed, backBtn, lostBtn;

    public MyPagePanel_2(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        //setTitle("앱 이름 - 마이페이지");

        // 폰트 객체 생성
        Font font1 = new Font("고딕체", Font.BOLD, 20);
        Font font2 = new Font("고딕체", Font.PLAIN, 12);
        Font font3 = new Font("고딕체", Font.BOLD, 12);

        // 뒤로 가기 버튼
        //ImageIcon backIcon = new ImageIcon("backButton.png");
        backBtn = new JButton("Back");
        backBtn.setBounds(20, 20, 90, 30);
        backBtn.setContentAreaFilled(false); // 버튼 투명화
        //backBtn.setBorderPainted(false); // border 제거
        backBtn.addActionListener(this);
        add(backBtn);

        JLabel welcomeLabel = new JLabel("눈송이님, 환영합니다!");
        welcomeLabel.setFont(new Font("SanSerif", Font.BOLD, 10));
        welcomeLabel.setBounds(360, 20, 200, 30);
        add(welcomeLabel);

        JLabel label1 = new JLabel("마이페이지");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(150, 60, 150, 20);
        label1.setFont(font1);
        add(label1);

        confirmed = new JButton("수령 대기");
        confirmed.setBounds(50, 100, 175, 30);
        confirmed.setBackground(new Color(238, 238, 238));
        confirmed.setFont(font2);
        confirmed.addActionListener(this);
        add(confirmed);

        JButton renting = new JButton("대여중");
        renting.setBounds(225, 100, 175, 30);
        renting.setBackground(Color.WHITE);
        renting.setFont(font3);
        add(renting);

        devices = new ArrayList<>();
        devices.add(new Device("samsung_mobile.jpeg", "스마트폰", "iOS", "A14 Bionic", "6GB", "대여중"));
        devices.add(new Device("samsung_laptop.png", "노트북", "Windows 10", "Intel i7", "16GB", "대여중"));

        for (int i = 0; i < devices.size(); i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(70, 150 + 150 * i, 100, 100);
            add(imageLabel);

            JLabel devnameLabel = new JLabel();
            devnameLabel.setBounds(180, 157 + 150 * i, 400, 15);
            add(devnameLabel);

            JLabel osLabel = new JLabel();
            osLabel.setBounds(180, 180 + 150 * i, 400, 15);
            add(osLabel);

            JLabel cpuLabel = new JLabel();
            cpuLabel.setBounds(180, 195 + 150 * i, 400, 15);
            add(cpuLabel);

            JLabel ramLabel = new JLabel();
            ramLabel.setBounds(180, 210 + 150 * i, 400, 15);
            add(ramLabel);

            JLabel statusLabel = new JLabel();
            statusLabel.setBounds(180, 225 + 150 * i, 400, 15);
            add(statusLabel);

            deviceDisplay = new DeviceDisplay(imageLabel, devnameLabel, osLabel, cpuLabel, ramLabel, statusLabel);
            showDeviceDetails(deviceDisplay, devices.get(i));

            lostBtn = new JButton("기기 신고");
            lostBtn.setBounds(200, 250 + 150 * i, 150, 20);
            lostBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] options = {"분실 신고", "손상 신고", "불량 신고", "기타"};
                    Object searchType = JOptionPane.showInputDialog(
                            null,
                            "신고 사항을 알려주세요.",
                            "신고 유형 선택",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    if (searchType != null) {
                        // 사용자가 '예'를 누른 경우
                        String selectedOption = searchType.toString();
                        JOptionPane.showMessageDialog(
                                null,
                                "선택한 신고 유형: " + selectedOption +
                                "\n 빠른 시일 내로 학과 사무실에 방문해 주세요.",
                                "알림",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // 사용자가 취소 버튼을 눌렀을 경우
                        JOptionPane.showMessageDialog(
                                null,
                                "신고가 취소되었습니다.",
                                "알림",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    //JOptionPane.showMessageDialog(win, "분실 신고가 완료되었습니다.", "분실 신고", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            add(lostBtn);

            /*lostBtn = new JButton("손상");
            lostBtn.setBounds(290, 250 + 150 * i, 80, 20);
            lostBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(win, "손상 신고가 완료되었습니다.", "손상 신고", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            add(lostBtn);*/
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == confirmed) {
            win.change("마이페이지 수령 대기 화면으로");
        }
        /*else if (e.getSource() == lostBtn) {
            JOptionPane.showMessageDialog(win, "분실 신고가 완료되었습니다.", "분실 신고", JOptionPane.INFORMATION_MESSAGE);
        }*/
    }

    private void showDeviceDetails(DeviceDisplay deviceDisplay, Device device) {
        deviceDisplay.displayDevice(device);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}