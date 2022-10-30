package latihan2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloMessageDialog extends JFrame {
    public HelloMessageDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(HelloMessageDialog.this,
                // "Halo, selamat datang di Praktikum Pemrograman II.", "Error Message",
                // JOptionPane.ERROR_MESSAGE);
                // JOptionPane.showMessageDialog(HelloMessageDialog.this,
                // "Halo, selamat datang di Praktikum Pemrograman II.", "Information Message",
                // JOptionPane.INFORMATION_MESSAGE);
                // JOptionPane.showMessageDialog(HelloMessageDialog.this,
                // "Halo, selamat datang di Praktikum Pemrograman II.", "Warning Message",
                // JOptionPane.WARNING_MESSAGE);
                // JOptionPane.showMessageDialog(HelloMessageDialog.this,
                // "Halo, selamat datang di Praktikum Pemrograman II.", "Question Message",
                // JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(HelloMessageDialog.this,
                        "Halo, selamat datang di Praktikum Pemrograman II.", "Plain Message",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

        this.add(button);

        this.setSize(200, 200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }
}
