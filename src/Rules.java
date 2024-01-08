import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JDialog {
    private JTextArea rulesTextArea;
    private JButton agreeButton;

    public Rules(Frame parent) {
        super(parent, "규정 확인", true);
        components();
        rulesLayout();
        rulesListeners();
    }

    private void components() {
        rulesTextArea = new JTextArea(15, 40);
        String rulesText = "1. 기기는 예약한 날짜로부터 3일 이내에 학과 사무실에서 수령해야만 합니다.\n\n" +
                "2. 대여 기간은 총 7일입니다.\n\n" +
                "3. 같은 종류의 기기를 이미 대여/예약한 경우 새로운 예약이 불가능합니다.\n\n" +
                "4. 장기 휴학하는 경우(3학기 이상) 기기를 반납해야 합니다.\n\n" +
                "5. 물품 번호가 적혀 있는 라벨지는 보존이 필수적이며, 라벨이 떨어질 경우 학과에 연락을 취해야 합니다.\n\n" +
                "6. 기기 손상 및 분실 시 마이페이지의 내 기기 항목에서 신고를 한 후 학과사무실에 방문해야 합니다.\n\n" +
                "7. 기기 반납 시 검사용 설문조사에 참여해야 합니다.";
        rulesTextArea.setText(rulesText);
        rulesTextArea.setEditable(false);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        agreeButton = new JButton("동의");
        agreeButton.setBackground(new Color(167, 206, 167)); // 연한 초록색
        agreeButton.setOpaque(true);
        agreeButton.setBorderPainted(false);
    }

    private void rulesLayout() {
        setLayout(new BorderLayout());
        add(new JScrollPane(rulesTextArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(agreeButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getParent());
    }

    private void rulesListeners() {
        agreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Rules.this,
                        "예약/대여되었습니다.",
                        "확인",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }
}
