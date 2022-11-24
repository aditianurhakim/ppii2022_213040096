package view;

import java.awt.event.*;
import javax.swing.JOptionPane;
import model.Member;

public class MainTombolTambahActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainTombolTambahActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // menampung data sementara
        String nama = this.mainFrame.textFieldNama.getText();
        String nomorHP = this.mainFrame.textFieldNomorHP.getText();
        String alamatRumah = this.mainFrame.textAreaAlamatRumah.getText();
        // String nama = "Aditia Nurhakim";
        // String nomorHP = "082387231371";
        // String alamatRumah = "Jl. Sukahaji No. 131 A";
        String jenisKelamin = "";
        if (this.mainFrame.radioButton1.isSelected()) {
            jenisKelamin = this.mainFrame.radioButton1.getText();
        }
        if (this.mainFrame.radioButton2.isSelected()) {
            jenisKelamin = this.mainFrame.radioButton2.getText();
        }

        // pemeriksaan data kosong
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this.mainFrame,
                    "Nama belum terisi.", "Galat!",
                    JOptionPane.ERROR_MESSAGE);
        } else if (nomorHP.isEmpty()) {
            JOptionPane.showMessageDialog(this.mainFrame,
                    "Nomor HP belum terisi.", "Galat!",
                    JOptionPane.ERROR_MESSAGE);
        } else if (alamatRumah.isEmpty()) {
            JOptionPane.showMessageDialog(this.mainFrame,
                    "Alamat rumah belum terisi.", "Galat!",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // konfirmasi menambahkan data
            int confirmation = JOptionPane.showConfirmDialog(this.mainFrame,
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
                this.mainFrame.tableModel.add(member);

                // mengembalikan ke keadaan default
                this.mainFrame.textFieldNama.setText("");
                this.mainFrame.textFieldNomorHP.setText("");
                this.mainFrame.textAreaAlamatRumah.setText("");
                this.mainFrame.textFieldNomorHP.setEditable(true);
            } else {
                // kembali ke aplikasi
            }
        }
    }
}
