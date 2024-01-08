import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ReservationMobile extends JFrame {

    private JLabel reservationStatusLabel;
    private JLabel reservationAvailabilityLabel;
    private JFrame previousFrame;

    public ReservationMobile(String userName, JFrame previousFrame) {
        this.previousFrame = previousFrame;
        setTitle("IT공학과 실습 기기 대여 시스템");
        setSize(960, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));

        // topPanel: 백 버튼, 제목, 눈송이님 포함
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        topPanel.setBackground(new Color(72, 162, 96)); // 진한 초록

        // 백 버튼
        ImageIcon backIconOriginal = new ImageIcon(getClass().getResource("/images/back.png"));
        Image backImageScaled = backIconOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon backIconScaled = new ImageIcon(backImageScaled);
        JButton backButton = new JButton(backIconScaled);
        backButton.addActionListener(e -> {
            if (previousFrame != null) {
                previousFrame.setVisible(true);
            }
            this.dispose();
        });
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

        // mobile icon + 크기고정
        ImageIcon mobileIconOriginal = new ImageIcon(getClass().getResource("/images/samsung_mobile.jpeg"));
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
        JButton reserveButton = new JButton("규정 확인하기");
        reserveButton.setPreferredSize(new Dimension(200, 50));
        styleButton(reserveButton, new Color(72, 162, 96)); // 진한 초록
        reserveButton.addActionListener(e -> showRulesDialog());
        bottomPanel.add(reserveButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
        // 예약 상태 정보 백엔드와 연동 시 (일단 더미 데이터)
        fetchData();
    }

    // 규정 확인하기 버튼 눌렀을 때 Rules Dialog 보여주는 메서드
    private void showRulesDialog() {
        Rules dialog = new Rules(this);
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
}
