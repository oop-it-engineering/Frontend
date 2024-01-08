import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MyPage_1_confirmed extends JFrame {

    private DeviceDisplay deviceDisplay;
    private List<Device> devices;

    public MyPage_1_confirmed(String userID) {
        setTitle("앱 이름 - 마이페이지");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 폰트 객체 생성
        Font font1 = new Font("고딕체", Font.BOLD, 20);
        Font font2 = new Font("고딕체", Font.PLAIN, 12);
        Font font3 = new Font("고딕체", Font.BOLD, 12);

        JPanel myPagePanel = new JPanel();
        myPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(myPagePanel);
        myPagePanel.setLayout(null);
        myPagePanel.setBackground(new Color(238, 238, 238)); // 배경 색

        // 뒤로 가기 버튼
        ImageIcon backIcon = new ImageIcon("backButton.png");
        JButton backButton = new JButton(backIcon);
        backButton.setBounds(20, 20, 30, 30);
        backButton.setContentAreaFilled(false); // 버튼 투명화
        backButton.setBorderPainted(false); // border 제거
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assuming Main.java is your main screen class
                new sampleMain(userID).setVisible(true);
                dispose(); // Close the current frame
            }
        });
        myPagePanel.add(backButton);

        JLabel label_ID = new JLabel(userID + " 님, 환영합니다!");
        label_ID.setBounds(0, 20, 400, 20);
        label_ID.setHorizontalAlignment(JLabel.RIGHT);
        myPagePanel.add(label_ID);

        JLabel label1 = new JLabel("마이페이지");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(150, 60, 150, 20);
        label1.setFont(font1);
        myPagePanel.add(label1);

        JButton confirmed = new JButton("수령 대기");
        confirmed.setBounds(50, 100, 175, 30);
        confirmed.setBackground(Color.WHITE);
        confirmed.setFont(font3);
        myPagePanel.add(confirmed);

        JButton renting = new JButton("대여중");
        renting.setBounds(225, 100, 175, 30);
        renting.setBackground(new Color(238, 238, 238));
        renting.setFont(font2);
        myPagePanel.add(renting);

        renting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyPage_2_renting(userID).setVisible(true);
                dispose();
            }
        });

        devices = new ArrayList<>();
        devices.add(new Device("deviceImage.png", "스마트폰1", "Android", "Snapdragon 865", "8GB", "수령 대기"));
        devices.add(new Device("deviceImage2.png", "스마트폰2", "iOS", "A14 Bionic", "6GB", "예약중"));
        devices.add(new Device("deviceImage3.png", "노트북", "Windows 10", "Intel i7", "16GB", "예약중"));

        for (int i = 0; i < devices.size(); i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setBounds(70, 150 + 120 * i, 100, 100);
            myPagePanel.add(imageLabel);

            JLabel devnameLabel = new JLabel();
            devnameLabel.setBounds(180, 150 + 120 * i, 400, 15);
            myPagePanel.add(devnameLabel);

            JLabel osLabel = new JLabel();
            osLabel.setBounds(180, 180 + 120 * i, 400, 15);
            myPagePanel.add(osLabel);

            JLabel cpuLabel = new JLabel();
            cpuLabel.setBounds(180, 195 + 120 * i, 400, 15);
            myPagePanel.add(cpuLabel);

            JLabel ramLabel = new JLabel();
            ramLabel.setBounds(180, 210 + 120 * i, 400, 15);
            myPagePanel.add(ramLabel);

            JLabel statusLabel = new JLabel();
            statusLabel.setBounds(180, 225 + 120 * i, 400, 15);
            myPagePanel.add(statusLabel);

            deviceDisplay = new DeviceDisplay(imageLabel, devnameLabel, osLabel, cpuLabel, ramLabel, statusLabel);
            showDeviceDetails(deviceDisplay, devices.get(i));
        }

        setVisible(true);
    }

    private void showDeviceDetails(DeviceDisplay deviceDisplay, Device device) {
        deviceDisplay.displayDevice(device);
    }

    public static void main(String[] args) {
        new MyPage_1_confirmed("YourUserID");
    }
}