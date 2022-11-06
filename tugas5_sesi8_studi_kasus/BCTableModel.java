package tugas5_sesi8_studi_kasus;

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class BCTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nama", "Jenis Kelamin", "Nomor HP", "Alamat" };
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(ArrayList<String> value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
