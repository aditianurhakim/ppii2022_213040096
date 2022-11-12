package tugas6_sesi10_kelas_model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class BioCollector extends JFrame {
    public BioCollector() {
        this.setLayout(new FlowLayout());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        // konfigurasi elemen-elemen pada aplikasi

        JLabel labelInputNama = new JLabel("Nama:");
        labelInputNama.setBounds(20, 20, 100, 20);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(20, 50, 170, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(20, 100, 350, 20);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(20, 120, 100, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(20, 145, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JLabel labelInputNomorHP = new JLabel("Nomor HP:");
        labelInputNomorHP.setBounds(200, 20, 100, 20);

        JTextField textFieldNomorHP = new JTextField();
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

        JTextArea textAreaAlamatRumah = new JTextArea();
        textAreaAlamatRumah.setLineWrap(true);
        textAreaAlamatRumah.setWrapStyleWord(true);
        JScrollPane scrollableTextArea = new JScrollPane(textAreaAlamatRumah);
        scrollableTextArea.setBounds(200, 130, 170, 40);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton tombolTambah = new JButton("+");
        tombolTambah.setBounds(20, 190, 45, 30);

        JButton tombolEkspor = new JButton("Ekspor");
        tombolEkspor.setBounds(200, 190, 80, 30);

        JButton tombolSunting = new JButton("Sunting");
        tombolSunting.setBounds(110, 190, 80, 30);

        JButton tombolHapus = new JButton("X");
        tombolHapus.setBounds(325, 190, 45, 30);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(20, 240, 350, 350);

        // penggunaan model tabel yang dikustomisasi

        BCTableModel tableModel = new BCTableModel();
        table.setModel(tableModel);

        // tombol untuk menambahkan data pada tabel
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // menampung data sementara
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String alamatRumah = textAreaAlamatRumah.getText();
                // String nama = "Aditia Nurhakim";
                // String nomorHP = "082387231371";
                // String alamatRumah = "Jl. Sukahaji No. 131 A";
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                // pemeriksaan data kosong
                if (nama.isEmpty()) {
                    JOptionPane.showMessageDialog(BioCollector.this,
                            "Nama belum terisi.", "Galat!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (nomorHP.isEmpty()) {
                    JOptionPane.showMessageDialog(BioCollector.this,
                            "Nomor HP belum terisi.", "Galat!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (alamatRumah.isEmpty()) {
                    JOptionPane.showMessageDialog(BioCollector.this,
                            "Alamat rumah belum terisi.", "Galat!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // konfirmasi menambahkan data
                    int confirmation = JOptionPane.showConfirmDialog(BioCollector.this,
                            "Apakah anda yakin akan menambahkan data tersebut?", "Konfirmasi",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // penggunaan kelas model Member
                        Member member = new Member();
                        member.setNama(nama);
                        member.setJenisKelamin(jenisKelamin);
                        member.setNomorHP(nomorHP);
                        member.setAlamatRumah(alamatRumah);

                        // menambahkan data ke tabel
                        tableModel.add(member);

                        // mengembalikan ke keadaan default
                        textFieldNama.setText("");
                        textFieldNomorHP.setText("");
                        textAreaAlamatRumah.setText("");
                        textFieldNomorHP.setEditable(true);
                    } else {
                        // kembali ke aplikasi
                    }
                }
            }
        });

        // tombol untuk menyimpan data pada tabel dalam bentuk .txt
        tombolEkspor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime now = LocalDateTime.now();
                    File file = new File("Bio_" + dtf.format(now) + ".txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("Nama,Jenis Kelamin,Nomor HP,Alamat Rumah\n");

                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            if (j == table.getColumnCount() - 1) {
                                bw.write((String) table.getModel().getValueAt(i, j));
                            } else {
                                bw.write((String) table.getModel().getValueAt(i, j) + ",");
                            }
                        }
                        bw.write("\n");
                    }
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Ekspor data berhasil.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // data pada tabel direpresentasikan pada kolom inputan saat di-klik
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                textFieldNama.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
                textFieldNomorHP.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
                textAreaAlamatRumah.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
                if (table.getModel().getValueAt(table.getSelectedRow(), 1).toString().equals("Laki-Laki")) {
                    radioButton1.setSelected(true);
                } else {
                    radioButton2.setSelected(true);
                }
            }
        });

        // tombol untuk menyunting data pada tabel
        tombolSunting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRowCount() == 1) {
                    // menampung data sementara
                    String nama = textFieldNama.getText();
                    String nomorHP = textFieldNomorHP.getText();
                    String alamatRumah = textAreaAlamatRumah.getText();
                    String jenisKelamin = "";
                    if (radioButton1.isSelected()) {
                        jenisKelamin = radioButton1.getText();
                    }
                    if (radioButton2.isSelected()) {
                        jenisKelamin = radioButton2.getText();
                    }

                    // pemeriksaan data kosong
                    if (nama.isEmpty()) {
                        JOptionPane.showMessageDialog(BioCollector.this,
                                "Nama belum terisi.", "Galat!",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (nomorHP.isEmpty()) {
                        JOptionPane.showMessageDialog(BioCollector.this,
                                "Nomor HP belum terisi.", "Galat!",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (alamatRumah.isEmpty()) {
                        JOptionPane.showMessageDialog(BioCollector.this,
                                "Alamat rumah belum terisi.", "Galat!",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        // konfirmasi menambahkan data
                        int confirmation = JOptionPane.showConfirmDialog(BioCollector.this,
                                "Apakah anda yakin akan memperbaharui data tersebut?", "Konfirmasi",
                                JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            // memperbaharui data ke tabel
                            tableModel.setValueAt(nama, table.getSelectedRow(), 0);
                            tableModel.setValueAt(jenisKelamin, table.getSelectedRow(), 1);
                            tableModel.setValueAt(nomorHP, table.getSelectedRow(), 2);
                            tableModel.setValueAt(alamatRumah, table.getSelectedRow(), 3);

                            // mengembalikan ke keadaan default
                            textFieldNama.setText("");
                            textFieldNomorHP.setText("");
                            textAreaAlamatRumah.setText("");
                            textFieldNomorHP.setEditable(true);
                        } else {
                            // kembali ke aplikasi
                        }
                    }
                }
            }
        });

        // tombol untuk menghapus baris data pada tabel
        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(BioCollector.this,
                        "Apakah anda yakin akan menghapus data pada baris tersebut ?", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    tableModel.removeRow(table.getSelectedRow());
                else if (result == JOptionPane.NO_OPTION)
                    // kembali ke aplikasi
                    ;
            }
        });

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
                BioCollector bc = new BioCollector();
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
