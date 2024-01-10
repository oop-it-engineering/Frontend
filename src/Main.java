import javax.swing.*;

public class Main extends JFrame {
    public ReservationLaptop reservationLaptop = null;
    public ReservationMobile reservationMobile = null;
    public ReservationTablet reservationTablet = null;
    public ReservationOthers reservationOthers = null;
    public SelectEquipPanel selectEquipPanel = null;


    public void change(String panelName) {
        getContentPane().removeAll();

        if (panelName.equals("장비 선택 화면으로")) {
            getContentPane().add(selectEquipPanel);
        } else if (panelName.equals("랩탑")) {
            getContentPane().add(reservationLaptop);
        } else if (panelName.equals("모바일")) {
            getContentPane().add(reservationMobile);
        } else if (panelName.equals("패드")) {
            getContentPane().add(reservationTablet);
        } else if (panelName.equals("기타 기기")) {
            getContentPane().add(reservationOthers);
        }

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Main win = new Main();
        win.setTitle("IT공학과 기기 대여 시스템");

        // 모든 예약 패널 초기화
        win.reservationLaptop = new ReservationLaptop("눈송이", win);
        win.reservationMobile = new ReservationMobile("눈송이", win);
        win.reservationTablet = new ReservationTablet("눈송이", win);
        win.reservationOthers = new ReservationOthers("눈송이", win);

        // SelectEquipPanel을 첫 화면으로 설정
        win.selectEquipPanel = new SelectEquipPanel(win);
        win.getContentPane().add(win.selectEquipPanel);

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(860, 700);
        win.setVisible(true);
        win.setResizable(false);
    }

}

