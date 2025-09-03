import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class inventory_entry {
    public static void main(String[] args) {
    JFrame main_frame = new JFrame();
    // Table data + column names
String[] columns = {"Item", "Category"};
Object[][] data = {
    {"Apple", "Fruit"},
    {"Carrot", "Vegetable"}
};

JTable table = new JTable(data, columns);

// Create a dropdown (combo box) for the "Category" column
String[] categories = {"Fruit", "Vegetable", "Dairy"};
JComboBox<String> comboBox = new JComboBox<>(categories);

// Assign dropdown as the editor for column 1 (second column)
table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));

// Put table inside scroll pane + panel
JScrollPane scrollPane = new JScrollPane(table);
JPanel panel = new JPanel();
panel.add(scrollPane);
main_frame.add(panel);
main_frame.setVisible(true);
    }
}
