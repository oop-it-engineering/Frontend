import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListLaptopPanel extends JPanel implements ActionListener {
    private Main win;
    private JList<String> laptopList;
    private JButton backBtn;

    public ListLaptopPanel(Main win) {
        this.win = win;
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        JLabel title = new JLabel("랩탑");
        title.setFont(new Font("SanSerif", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(100, 20, 300, 30);
        add(title);

        // 랩탑 목록 JList
        String[] laptops = {"삼성 갤럭시 북 4", "LG 그램", "맥북 에어"};
        laptopList = new JList<>(laptops);
        laptopList.setFont(new Font("SanSerif", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(laptopList);
        scrollPane.setBounds(100, 120, 300, 100);
        add(scrollPane);

        JButton selectBtn = new JButton("선택");
        selectBtn.setBounds(100, 240, 300, 40);
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLaptop = laptopList.getSelectedValue();
                // 선택된 랩탑에 대한 처리
            }
        });
        add(selectBtn);

        backBtn = new JButton("뒤");
        backBtn.setBounds(10, 20, 80, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        JLabel welcomeLabel = new JLabel("눈송이님, 환영합니다!");
        welcomeLabel.setFont(new Font("SanSerif", Font.BOLD, 10));
        welcomeLabel.setBounds(360, 20, 200, 30);
        add(welcomeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("장비 선택 화면으로");
        }
    }
}
