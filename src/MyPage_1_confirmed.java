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
        setSize(800, 1400); // 크기 조정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font1 = new Font("고딕체", Font.BOLD, 20);
        Font font2 = new Font("고딕체", Font.PLAIN, 12);
        Font font3 = new Font("고딕체", Font.BOLD, 12);

        JPanel myPagePanel = new JPanel();
        myPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(myPagePanel);
        myPagePanel.setLayout(null);
        myPagePanel.setBackground(new Color(238, 238, 238));

        ImageIcon backIcon = new ImageIcon("backButton.png");
        JButton backButton = new JButton(backIcon);
        backButton.setBounds(20, 20, 30, 30);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new sampleMain(userID).setVisible(true);
                dispose();
            }
        });
        myPagePanel.add(backButton);

        JLabel label_ID = new JLabel(userID + " 님, 환영합니다!");
        label_ID.setBounds(0, 20, getWidth() - 50, 20);
        label_ID.setHorizontalAlignment(JLabel.RIGHT);
        myPagePanel.add(label_ID);

        JLabel label1 = new JLabel("마이페이지");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(getWidth() / 2 - 75, 60, 150, 20);
        label1.setFont(font1);
        myPagePanel.add(label1);

        JButton confirmed = new JButton("수령 대기");
        confirmed.setBounds(50, 100, getWidth() / 2 - 75, 30);
        confirmed.setBackground(Color.WHITE);
        confirmed.setFont(font3);
        myPagePanel.add(confirmed);
        showDeviceDetails();

        JButton renting = new JButton("대여중");
        renting.setBounds(getWidth() / 2, 100, getWidth() / 2 - 75, 30);
        renting.setBackground(new Color(238, 238, 238));
        renting.setFont(font2);
        myPagePanel.add(renting);

        confirmed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed.setBackground(Color.WHITE);
                confirmed.setFont(font3);
                renting.setBackground(new Color(238, 238, 238));
                renting.setFont(font2);
                showDeviceDetails();
            }
        });

        renting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed.setBackground(new Color(238, 238, 238));
                confirmed.setFont(font2);
                renting.setBackground(Color.WHITE);
                renting.setFont(font3);
            }
        });

        devices = new ArrayList<>();
        devices.add(new Device("deviceImage.png", "스마트폰1", "Android", "Snapdragon 865", "8GB", "사용 가능"));
        devices.add(new Device("deviceImage.png", "스마트폰2", "iOS", "A14 Bionic", "6GB", "사용 중지"));
        devices.add(new Device("deviceImage.png", "노트북", "Windows 10", "Intel i7", "16GB", "대여 중"));

        int startY = 150; // 시작 위치 조정

        for (Device device : devices) {
            addDeviceLabels(myPagePanel, device, startY);
            startY += 180; // 간격 조정
        }

        deviceDisplay = new DeviceDisplay(new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel());

        setVisible(true);
    }

    private void showDeviceDetails() {
        for (Device device : devices) {
            deviceDisplay.displayDevice(device);
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    private void addDeviceLabels(JPanel panel, Device device, int startY) {
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(50, startY, 150, 150);
        panel.add(imageLabel);

        JLabel devnameLabel = new JLabel();
        devnameLabel.setBounds(220, startY, 400, 20);
        panel.add(devnameLabel);

        JLabel osLabel = new JLabel();
        osLabel.setBounds(220, startY + 30, 400, 20);
        panel.add(osLabel);

        JLabel cpuLabel = new JLabel();
        cpuLabel.setBounds(220, startY + 60, 400, 20);
        panel.add(cpuLabel);

        JLabel ramLabel = new JLabel();
        ramLabel.setBounds(220, startY + 90, 400, 20);
        panel.add(ramLabel);

        JLabel statusLabel = new JLabel();
        statusLabel.setBounds(220, startY + 120, 400, 20);
        panel.add(statusLabel);

        deviceDisplay = new DeviceDisplay(imageLabel, devnameLabel, osLabel, cpuLabel, ramLabel, statusLabel);
    }

    public static void main(String[] args) {
        new MyPage_1_confirmed("YourUserID");
    }
}
