import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private Container cp;
    private JButton jbtE = new JButton("EXIT");
    private JButton jbt = new JButton("轉換");
    private JLabel jlb = new JLabel("password");
    private JPasswordField jps = new JPasswordField();
    private JTextArea jta = new JTextArea();
    private JTextArea jta1 = new JTextArea();
    private JPanel jpnL = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jpnR = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jp = new JPanel(new GridLayout(4,1,1,1));

    public Frame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(1,1));
        cp.add(jpnL,BorderLayout.WEST);
        cp.add(jpnR,BorderLayout.EAST);
        cp.add(jp,BorderLayout.CENTER);
        jpnL.add(jta);
        jpnR.add(jta1);
        jp.add(jlb);
        jp.add(jps);
        jp.add(jbt);
        jp.add(jbtE);
        jta1.setLineWrap(true);
        jpnL.setPreferredSize(new Dimension(230,400));
        jpnR.setPreferredSize(new Dimension(230,400));

        jbtE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char plainData[] = jta.getText().toCharArray();
                int len = plainData.length;
                char cipherData[] = new char[len];
                char keyData[] = (new String(jps.getPassword())).toCharArray();
                int keylen = keyData.length;
                for (int i = 0 ; i < len ; i++){
                    cipherData[i] = (char)((int)plainData[i] ^ (int) keyData [i % keylen]);
                }
                jta1.setText(new String (cipherData));
            }
        });
    }
}
