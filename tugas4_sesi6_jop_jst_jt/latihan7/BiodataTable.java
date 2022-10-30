package latihan7;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BiodataTable extends JFrame {

    private boolean checkBoxSelected;

    public BiodataTable() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputNama = new JLabel("Nama:");
        labelInputNama.setBounds(15, 40, 350, 10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelInputHP = new JLabel("Nomor HP:");
        labelInputHP.setBounds(15, 100, 350, 10);

        JTextField textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 120, 350, 30);

        JLabel labelJK = new JLabel("Jenis Kelamin:");
        labelJK.setBounds(15, 160, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 180, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 210, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 240, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 280, 100, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 330, 350, 200);

        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                String statusWNA = "Bukan";
                if (checkBoxSelected) {
                    statusWNA = "Ya";
                }

                String nama = textFieldNama.getText();
                String noHP = textFieldHP.getText();
                tableModel.add(new ArrayList<>(Arrays.asList(nama, noHP, jenisKelamin, statusWNA)));
            }
        });

        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputHP);
        this.add(textFieldHP);
        this.add(labelJK);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInputHP);
        this.add(checkBox);
        this.add(button);
        this.add(scrollableTable);

        this.setSize(400, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTable bt = new BiodataTable();
                bt.setVisible(true);
            }
        });
    }
}
