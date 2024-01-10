import javax.swing.*;

public class Main extends JFrame {
    public ReservationLaptop reservationLaptop = null;
    public ReservationLaptop2 reservationLaptop2 = null;
    public ReservationMobile reservationMobile = null;
    public ReservationMobile2 reservationMobile2 = null;
    public ReservationPad reservationPad = null;
    public ReservationPad2 reservationPad2 = null;
    public ReservationOthers reservationOthers = null;
    public SelectEquipPanel selectEquipPanel = null;
    public ListLaptopPanel listLaptopPanel = null;
    public ListMobilePanel listMobilePanel = null;
    public ListPadPanel listPadPanel = null;
    public ListOtherPanel listOtherPanel = null;



    public void change(String panelName) {
        getContentPane().removeAll();

        if (panelName.equals("장비 선택 화면으로")) {
            getContentPane().add(selectEquipPanel);
        }
        else if (panelName.equals("랩탑 선택 화면으로")) {
            getContentPane().add(listLaptopPanel);
        }
        else if (panelName.equals("모바일 기기 선택 화면으로")) {
            getContentPane().add(listMobilePanel);
        }
        else if (panelName.equals("패드 선택 화면으로")) {
            getContentPane().add(listPadPanel);
        }
        else if (panelName.equals("기타 기기 선택 화면으로")) {
            getContentPane().add(listOtherPanel);
          }
        else if (panelName.equals("랩탑")) {
            getContentPane().add(reservationLaptop);
        }
        else if (panelName.equals("랩탑2")) {
            getContentPane().add(reservationLaptop2);
        }
        else if (panelName.equals("모바일")) {
            getContentPane().add(reservationMobile);
        }
        else if (panelName.equals("모바일2")) {
            getContentPane().add(reservationMobile2);
        }
        else if (panelName.equals("패드")) {
            getContentPane().add(reservationPad);
        }
        else if (panelName.equals("패드2")) {
            getContentPane().add(reservationPad2);
        }
        else if (panelName.equals("기타 기기")) {
            getContentPane().add(reservationOthers);
        }

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Main win = new Main();
        win.setTitle("IT공학과 기기 대여 시스템");


        // 예약 패널 초기화
        win.reservationLaptop = new ReservationLaptop("눈송이", win);
        win.reservationLaptop2 = new ReservationLaptop2("눈송이", win);
        win.reservationMobile = new ReservationMobile("눈송이", win);
        win.reservationMobile2 = new ReservationMobile2("눈송이", win);
        win.reservationPad = new ReservationPad("눈송이", win);
        win.reservationPad2 = new ReservationPad2("눈송이", win);
        win.reservationOthers = new ReservationOthers("눈송이", win);

        // SelectEquipPanel을 첫 화면으로 설정 (임시이므로 나중에 로그인 때 바꿔주세요!)
        win.selectEquipPanel = new SelectEquipPanel(win);
        win.getContentPane().add(win.selectEquipPanel);

        // list 관련 패널 초기화
        win.listLaptopPanel = new ListLaptopPanel(win);
        win.listMobilePanel = new ListMobilePanel(win);
        win.listPadPanel = new ListPadPanel(win);
        win.listOtherPanel = new ListOtherPanel(win);

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(860, 700);
        win.setVisible(true);
        win.setResizable(false);
    }

}

