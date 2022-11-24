package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame {

    JTextField textFieldNama;
    JTextField textFieldNomorHP;
    JTextArea textAreaAlamatRumah;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    MainFrameTableModel tableModel;
    javax.swing.JTable table;
    JButton tombolTambah;
    JButton tombolEkspor;
    JButton tombolSunting;
    JButton tombolHapus;

    public MainFrame() {

        this.setLayout(new FlowLayout());

        // konfigurasi elemen-elemen pada aplikasi

        JLabel labelInputNama = new JLabel("Nama:");
        labelInputNama.setBounds(20, 20, 100, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(20, 50, 170, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(20, 100, 350, 20);

        radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(20, 120, 100, 30);

        radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(20, 145, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JLabel labelInputNomorHP = new JLabel("Nomor HP:");
        labelInputNomorHP.setBounds(200, 20, 100, 20);

        textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(200, 50, 170, 30);
        textFieldNomorHP.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textFieldNomorHP.setEditable(true);
                } else {
                    textFieldNomorHP.setEditable(false);
                }
            }
        });

        JLabel labelAlamatRumah = new JLabel("Alamat Rumah:");
        labelAlamatRumah.setBounds(200, 100, 100, 20);

        textAreaAlamatRumah = new JTextArea();
        textAreaAlamatRumah.setLineWrap(true);
        textAreaAlamatRumah.setWrapStyleWord(true);
        JScrollPane scrollableTextArea = new JScrollPane(textAreaAlamatRumah);
        scrollableTextArea.setBounds(200, 130, 170, 40);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        tombolTambah = new JButton("+");
        tombolTambah.setBounds(20, 190, 45, 30);

        tombolEkspor = new JButton("Ekspor");
        tombolEkspor.setBounds(200, 190, 80, 30);

        tombolSunting = new JButton("Sunting");
        tombolSunting.setBounds(110, 190, 80, 30);

        tombolHapus = new JButton("X");
        tombolHapus.setBounds(325, 190, 45, 30);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(20, 240, 350, 350);

        // penggunaan model tabel yang dikustomisasi

        tableModel = new MainFrameTableModel();
        table.setModel(tableModel);

        // action listener bagi tombol penambah data pada tabel
        MainTombolTambahActionListener aLTambah = new MainTombolTambahActionListener(this);
        this.tombolTambah.addActionListener(aLTambah);

        // action listener bagi tombol penyimpan data pada tabel dalam bentuk .txt
        MainTombolEksporActionListener aLEkspor = new MainTombolEksporActionListener(this);
        this.tombolEkspor.addActionListener(aLEkspor);

        // action listener bagi tombol penyunting data pada tabel
        MainTombolSuntingActionListener aLSunting = new MainTombolSuntingActionListener(this);
        this.tombolSunting.addActionListener(aLSunting);

        // action listener bagi tombol penghapus baris data pada tabel
        MainTombolHapusActionListener aLHapus = new MainTombolHapusActionListener(this);
        this.tombolHapus.addActionListener(aLHapus);

        // data pada tabel direpresentasikan pada kolom inputan saat di-klik
        TableMouseClickListener mLTable = new TableMouseClickListener(this);
        this.table.addMouseListener(mLTable);

        // memunculkan elemen-elemen yang telah dikonfigurasi
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelJenisKelamin);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelAlamatRumah);
        this.add(scrollableTextArea);
        this.add(tombolTambah);
        this.add(tombolEkspor);
        this.add(tombolSunting);
        this.add(tombolHapus);
        this.add(scrollableTable);

        // konfigurasi frame
        this.setSize(400, 650);
        this.setLayout(null);
        this.setTitle("Bio Collector");

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame bc = new MainFrame();
                bc.setLocationRelativeTo(null);
                bc.setVisible(true);
                // konfirmasi keluar aplikasi
                bc.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        int result = JOptionPane.showConfirmDialog(bc,
                                "Apakah anda yakin akan keluar ?", "Konfirmasi",
                                JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION)
                            bc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        else if (result == JOptionPane.NO_OPTION)
                            bc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                });
            }
        });
    }
}
