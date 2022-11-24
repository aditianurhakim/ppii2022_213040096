package view;

import java.awt.event.*;

public class TableMouseClickListener implements MouseListener {
    private MainFrame mainFrame;

    public TableMouseClickListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        this.mainFrame.textFieldNama.setText(
                this.mainFrame.table.getModel().getValueAt(this.mainFrame.table.getSelectedRow(),
                        0).toString());
        this.mainFrame.textFieldNomorHP.setText(
                this.mainFrame.table.getModel().getValueAt(this.mainFrame.table.getSelectedRow(),
                        2).toString());
        this.mainFrame.textAreaAlamatRumah.setText(
                this.mainFrame.table.getModel().getValueAt(this.mainFrame.table.getSelectedRow(),
                        3).toString());
        if (this.mainFrame.table.getModel().getValueAt(this.mainFrame.table.getSelectedRow(),
                1).toString()
                .equals("Laki-Laki")) {
            this.mainFrame.radioButton1.setSelected(true);
        } else {
            this.mainFrame.radioButton2.setSelected(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
