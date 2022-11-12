package tugas6_sesi10_kelas_model;

import javax.swing.table.*;
import java.util.ArrayList;

public class BCTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nama", "Jenis Kelamin", "Nomor HP", "Alamat" };
    private ArrayList<Member> data = new ArrayList<Member>();

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void setValueAt(String aValue, int rowIndex, int columnIndex) {
        Member rowItem = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                rowItem.setNama(aValue);
                break;
            case 1:
                rowItem.setJenisKelamin(aValue);
                break;
            case 2:
                rowItem.setNomorHP(aValue);
                break;
            case 3:
                rowItem.setAlamatRumah(aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisKelamin();
                break;
            case 2:
                value = rowItem.getNomorHP();
                break;
            case 3:
                value = rowItem.getAlamatRumah();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
