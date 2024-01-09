import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton signinBtn, backBtn;
    private JTextField nameField;  // 이름 입력 필드
    private JTextField idField;  // 학번 입력 필드

    public SignupPanel(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        JLabel title = new JLabel("회원가입");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setBounds(100, 20, 300, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);

        JLabel nameLabel = new JLabel("학번:");
        nameLabel.setFont(new Font("SanSerif", Font.PLAIN, 16));
        nameLabel.setBounds(50, 120, 50, 30);
        add(nameLabel);

        idField = new JTextField();
        idField.setBounds(110, 120, 290, 30);
        add(idField);

        JLabel idLabel = new JLabel("이름:");
        idLabel.setFont(new Font("SanSerif", Font.PLAIN, 16));
        idLabel.setBounds(50, 170, 50, 30);
        add(idLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 170, 290, 30);
        add(nameField);

        signinBtn = new JButton("완료");
        signinBtn.setBounds(110, 220, 290, 40);
        signinBtn.addActionListener(this);
        add(signinBtn);

        backBtn = new JButton("뒤");
        backBtn.setBounds(10, 20, 80, 30);
        backBtn.addActionListener(this);
        add(backBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("로그인 화면으로");
        } else if (e.getSource() == signinBtn) {
            JOptionPane.showMessageDialog(win, "회원가입이 완료되었습니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
            win.change("로그인 화면으로");
        }
    }
}
