package view;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class MainTombolSuntingActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainTombolSuntingActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.mainFrame.table.getSelectedRowCount() == 1) {
            // menampung data sementara
            String nama = this.mainFrame.textFieldNama.getText();
            String nomorHP = this.mainFrame.textFieldNomorHP.getText();
            String alamatRumah = this.mainFrame.textAreaAlamatRumah.getText();
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
                        "Apakah anda yakin akan memperbaharui data tersebut?", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    // memperbaharui data ke tabel
                    this.mainFrame.tableModel.setValueAt(nama, this.mainFrame.table.getSelectedRow(), 0);
                    this.mainFrame.tableModel.setValueAt(jenisKelamin, this.mainFrame.table.getSelectedRow(), 1);
                    this.mainFrame.tableModel.setValueAt(nomorHP, this.mainFrame.table.getSelectedRow(), 2);
                    this.mainFrame.tableModel.setValueAt(alamatRumah, this.mainFrame.table.getSelectedRow(), 3);

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

}
