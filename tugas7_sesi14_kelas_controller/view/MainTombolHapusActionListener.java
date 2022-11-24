package view;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class MainTombolHapusActionListener implements ActionListener {
    private MainFrame mainFrame;

    public MainTombolHapusActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(
                this.mainFrame,
                "Apakah anda yakin akan menghapus data pada baris tersebut ?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION)
            this.mainFrame.tableModel.removeRow(this.mainFrame.table.getSelectedRow());
        else if (result == JOptionPane.NO_OPTION)
            // kembali ke aplikasi
            ;
    }
}
