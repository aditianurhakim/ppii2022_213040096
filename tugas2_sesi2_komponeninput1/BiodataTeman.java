import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*;

/**
 * BiodataTeman
 */
public class BiodataTeman extends JFrame {
    public BiodataTeman() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputNama = new JLabel("Input Nama:");
        labelInputNama.setBounds(50, 40, 100, 20);

        JLabel labelInputTelepon = new JLabel("Input Nomor Telepon:");
        labelInputTelepon.setBounds(200, 40, 200, 20);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(50, 60, 130, 30);

        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(200, 60, 130, 30);

        JButton button = new JButton("Klik");
        button.setBounds(50, 100, 280, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(50, 150, 280, 100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();
                txtOutput.append(nama + " - " + telepon + "\n");
                textFieldNama.setText("");
                textFieldTelepon.setText("");
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(textFieldTelepon);
        this.add(labelInputNama);
        this.add(labelInputTelepon);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTeman bt = new BiodataTeman();
                bt.setVisible(true);
            }
        });
    }
}