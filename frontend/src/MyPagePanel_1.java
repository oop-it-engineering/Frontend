import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPagePanel_1 extends JPanel implements ActionListener {
    private Main win;
    private DeviceDisplay deviceDisplay;
    private List<Device> devices;
    private JButton renting, backBtn;

    public MyPagePanel_1(Main win) {
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

        JButton confirmed = new JButton("수령 대기");
        confirmed.setBounds(50, 100, 175, 30);
        confirmed.setBackground(Color.WHITE);
        confirmed.setFont(font3);
        add(confirmed);

        renting = new JButton("대여중");
        renting.setBounds(225, 100, 175, 30);
        renting.setBackground(new Color(238, 238, 238));
        renting.setFont(font2);
        renting.addActionListener(this);
        add(renting);

        devices = new ArrayList<>();
        devices.add(new Device("samsung_tablet.jpeg", "타블렛", "Android", "Snapdragon 865", "8GB", "수령 대기"));
        devices.add(new Device("samsung_mobile.jpeg", "스마트폰", "iOS", "A14 Bionic", "6GB", "예약중"));
        devices.add(new Device("samsung_laptop.png", "노트북", "Windows 10", "Intel i7", "16GB", "예약중"));

        for (int i = 0; i < devices.size(); i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(70, 150 + 120 * i, 100, 100);
            add(imageLabel);

            JLabel devnameLabel = new JLabel();
            devnameLabel.setBounds(180, 157 + 120 * i, 400, 15);
            add(devnameLabel);

            JLabel osLabel = new JLabel();
            osLabel.setBounds(180, 180 + 120 * i, 400, 15);
            add(osLabel);

            JLabel cpuLabel = new JLabel();
            cpuLabel.setBounds(180, 195 + 120 * i, 400, 15);
            add(cpuLabel);

            JLabel ramLabel = new JLabel();
            ramLabel.setBounds(180, 210 + 120 * i, 400, 15);
            add(ramLabel);

            JLabel statusLabel = new JLabel();
            statusLabel.setBounds(180, 225 + 120 * i, 400, 15);
            add(statusLabel);

            deviceDisplay = new DeviceDisplay(imageLabel, devnameLabel, osLabel, cpuLabel, ramLabel, statusLabel);
            showDeviceDetails(deviceDisplay, devices.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == renting) {
            win.change("마이페이지 대여중 화면으로");
        }
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