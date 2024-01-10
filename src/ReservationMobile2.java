import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationMobile2 extends JPanel implements ActionListener {

    private Main win;
    private JLabel reservationStatusLabel;
    private JLabel reservationAvailabilityLabel;
    //private JFrame previousFrame;
    private JButton backButton;

    public ReservationMobile2(String userName, Main win) {
        this.win = win;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // topPanel: 백 버튼, 제목, 눈송이님 포함
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        topPanel.setBackground(new Color(72, 162, 96)); // 진한 초록

        // 백 버튼
        ImageIcon backIconOriginal = new ImageIcon(getClass().getResource("/images/back.png"));
        Image backImageScaled = backIconOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon backIconScaled = new ImageIcon(backImageScaled);
        backButton = new JButton(backIconScaled);
        backButton.addActionListener(this);
        topPanel.add(backButton, BorderLayout.WEST);

        // 가운데 제목 라벨
        JLabel titleLabel = new JLabel("예약 페이지", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // 눈송이님, 환영합니다!
        JLabel welcomeLabel = new JLabel(userName + "님, 환영합니다!", SwingConstants.RIGHT);
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // centerPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        centerPanel.setBackground(Color.WHITE);

        // 제목 라벨 추가
        JLabel deviceTitleLabel = new JLabel("iPhone 15");
        deviceTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        deviceTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(deviceTitleLabel);

        // mobile icon + 크기고정
        ImageIcon mobileIconOriginal = new ImageIcon(getClass().getResource("/images/apple_mobile.jpeg"));
        Image mobileImageScaled = mobileIconOriginal.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon mobileIconScaled = new ImageIcon(mobileImageScaled);
        JLabel mobileLabel = new JLabel(mobileIconScaled);
        mobileLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(mobileLabel);

        // 상세 사양 Panel
        JPanel infoPanel = createInfoPanel(mobileIconScaled.getIconWidth());
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(infoPanel);

        // 예약 상태 Panel
        JPanel statusPanel = createStatusPanel(mobileIconScaled.getIconWidth());
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(statusPanel);

        add(centerPanel, BorderLayout.CENTER);

        // bottomPanel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        bottomPanel.setBackground(Color.WHITE);

        // '규정 확인하기' -> 규정 확인 창으로 넘어가는 버튼
        JButton reserveButton = new JButton("예약하기");
        reserveButton.setPreferredSize(new Dimension(200, 50));
        styleButton(reserveButton, new Color(72, 162, 96)); // 진한 초록
        reserveButton.addActionListener(e -> showRulesDialog());
        bottomPanel.add(reserveButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
        // 예약 상태 정보 백엔드와 연동 시 (일단 더미 데이터)
        fetchData();
    }

    private void showRulesDialog() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Rules dialog = new Rules(frame);
        dialog.setVisible(true);
    }

    // styleButton
    private void styleButton(JButton button, Color color) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setOpaque(true);
    }

    // 상세 사양 패널 Detail
    private JPanel createInfoPanel(int width) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 1, 0, 0));
        infoPanel.setBorder(new LineBorder(Color.BLACK));
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.setBackground(new Color(230, 244, 250));
        infoPanel.setMaximumSize(new Dimension(width, 120));

        JLabel infoTitleLabel = new JLabel("상세 사양", SwingConstants.CENTER);
        infoTitleLabel.setFont(infoTitleLabel.getFont().deriveFont(Font.BOLD));
        infoPanel.add(infoTitleLabel);

        String[] specs = {"OS: Android", "CPU: Snapdragon", "RAM: 8GB"};
        for (String spec : specs) {
            JLabel label = new JLabel(spec, SwingConstants.CENTER);
            infoPanel.add(label);
        }
        return infoPanel;
    }

    // 예약 상태 패널 Detail
    private JPanel createStatusPanel(int width) {
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(3, 1, 0, 0));
        statusPanel.setBorder(new LineBorder(Color.BLACK));
        statusPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusPanel.setBackground(new Color(255, 250, 205));
        statusPanel.setMaximumSize(new Dimension(width, 70));

        JLabel statusTitleLabel = new JLabel("예약 상태", SwingConstants.CENTER);
        statusTitleLabel.setFont(statusTitleLabel.getFont().deriveFont(Font.BOLD));
        statusPanel.add(statusTitleLabel);

        reservationStatusLabel = new JLabel("대여(39/40)", SwingConstants.CENTER);
        reservationAvailabilityLabel = new JLabel("가능", SwingConstants.CENTER);
        statusPanel.add(reservationStatusLabel);
        statusPanel.add(reservationAvailabilityLabel);
        return statusPanel;
    }

    // 데이터베이스에서 예약 정보를 가져오는 메서드
    private void fetchData() {
        String fetchedStatus = "대여(39/40)";
        String fetchedAvailability = "가능";

        reservationStatusLabel.setText(fetchedStatus);
        reservationAvailabilityLabel.setText(fetchedAvailability);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            win.change("장비 선택 화면으로");
        }
    }
}
