import javax.swing.*;
import java.awt.*;

public class DeviceSelection extends JFrame {

    public DeviceSelection() {
        setTitle("IT공학과 실습 기기 대여 시스템 - 기기 선택");
        setSize(960, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton laptopButton = new JButton("랩탑");
        laptopButton.addActionListener(e -> openReservationScreen(new ReservationLaptop("눈송이", this)));
        add(laptopButton);

        JButton mobileButton = new JButton("모바일");
        mobileButton.addActionListener(e -> openReservationScreen(new ReservationMobile("눈송이", this)));
        add(mobileButton);

        JButton tabletButton = new JButton("태블릿");
        tabletButton.addActionListener(e -> openReservationScreen(new ReservationTablet("눈송이", this)));
        add(tabletButton);

        JButton othersButton = new JButton("기타 기기");
        othersButton.addActionListener(e -> openReservationScreen(new ReservationOthers("눈송이", this)));
        add(othersButton);

        setVisible(true);
    }

    private void openReservationScreen(JFrame reservationScreen) {
        reservationScreen.setVisible(true);
        this.setVisible(false);
    }
}
