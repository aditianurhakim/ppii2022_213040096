package tugas5_sesi8_studi_kasus;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BioCollector extends JFrame {
    public BioCollector() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputTanggal = new JLabel("Tanggal (dd/mm/yyyy):");
        labelInputTanggal.setBounds(20, 20, 350, 20);

        DateFormat formatPenanggalan = new SimpleDateFormat("dd/mm/yyyy");
        JFormattedTextField textFieldTanggal = new JFormattedTextField(formatPenanggalan);
        textFieldTanggal.setBounds(20, 50, 350, 30);
        textFieldTanggal.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '/'
                        || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textFieldTanggal.setEditable(true);
                } else {
                    textFieldTanggal.setEditable(false);
                }
            }
        });

        JLabel labelInputNominal = new JLabel("Nominal (Rp):");
        labelInputNominal.setBounds(20, 90, 350, 20);

        JTextField textFieldNominal = new JTextField();
        textFieldNominal.setBounds(20, 120, 350, 30);
        textFieldNominal.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textFieldNominal.setEditable(true);
                } else {
                    textFieldNominal.setEditable(false);
                }
            }
        });

        JLabel labelJenis = new JLabel("Jenis:");
        labelJenis.setBounds(20, 160, 350, 20);

        JRadioButton radioButton1 = new JRadioButton("Pemasukan", true);
        radioButton1.setBounds(20, 180, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Pengeluaran");
        radioButton2.setBounds(20, 205, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JLabel labelKeterangan = new JLabel("Keterangan:");
        labelKeterangan.setBounds(20, 240, 350, 20);

        JTextArea textAreaKeterangan = new JTextArea();
        JScrollPane scrollableTextArea = new JScrollPane(textAreaKeterangan);
        scrollableTextArea.setBounds(20, 270, 350, 60);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton button = new JButton("Catat");
        button.setBounds(20, 350, 100, 30);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(20, 400, 350, 200);

        BCTableModel tableModel = new BCTableModel();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldTanggal.getText().length() == 10) {
                    String jenis = "";
                    if (radioButton1.isSelected()) {
                        jenis = radioButton1.getText();
                    }
                    if (radioButton2.isSelected()) {
                        jenis = radioButton2.getText();
                    }

                    String tanggal = textFieldTanggal.getText();
                    String nominal = textFieldNominal.getText();
                    String keterangan = textAreaKeterangan.getText();
                    tableModel.add(new ArrayList<>(Arrays.asList(tanggal, nominal, jenis, keterangan)));

                }

                // mengembalikan ke keadaan default
                textFieldTanggal.setText("");
                textFieldNominal.setText("");
                textAreaKeterangan.setText("");
                textFieldNominal.setEditable(true);
            }
        });

        this.add(labelInputTanggal);
        this.add(textFieldTanggal);
        this.add(labelInputNominal);
        this.add(textFieldNominal);
        this.add(labelJenis);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelKeterangan);
        this.add(scrollableTextArea);
        this.add(button);
        this.add(scrollableTable);

        this.setSize(400, 650);
        this.setLayout(null);
        this.setTitle("Financial Recorder");

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BioCollector fr = new BioCollector();
                fr.setVisible(true);
            }
        });
    }
}
