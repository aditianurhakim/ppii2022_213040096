package view;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainTombolEksporActionListener implements ActionListener {
    private MainFrame mainFrame;
    DateTimeFormatter dtf;

    public MainTombolEksporActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    }

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

            for (int i = 0; i < this.mainFrame.table.getRowCount(); i++) {
                for (int j = 0; j < this.mainFrame.table.getColumnCount(); j++) {
                    if (j == this.mainFrame.table.getColumnCount() - 1) {
                        bw.write((String) this.mainFrame.table.getModel().getValueAt(i, j));
                    } else {
                        bw.write((String) this.mainFrame.table.getModel().getValueAt(i, j) + ",");
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
}
