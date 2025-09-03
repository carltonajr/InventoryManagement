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
    main_frame.setResizable(false);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int x_screen = screenSize.width;
    int y_screen = screenSize.height;
    main_frame.setTitle("Inventory App - Landing Page [Testing Env.]");
    main_frame.setSize(x_screen/2,y_screen/2);
    main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Table data + column names
    String[] columns = {"Rack Location", "Thickness [in]","Metal Type", "Sheet Size"};
    Object[][] data = {
        {"Select Option", "Select Option", "Select Option", "Select Option"},
        {"Select Option", "Select Option", "Select Option", "Select Option"}};

    JTable table = new JTable(data, columns);

    // Create a dropdown (combo box) for the "Category" column

    JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum", "430", "Other"});
    JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option","0.03", "0.04", "0.05", "0.06", "0.07", "0.105", "0.12", "8ga", "0.188", "0.25", "0.3125", "0.375", "0.625", "0.50", "0.75","Other"});
    JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});
    JComboBox<String> dropdown_locate = new JComboBox<>(new String[] {"Select Option", "Laser","ITW", "TWR", "1", "2", "3", "4", "5", "6"});

    // Assign dropdown as the editor for column 1 (second column)
    table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(dropdown_locate));
    table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(dropdown_thickness_gauges_inches));
    table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(dropdown_size));
    table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(dropdown_type));

    // Put table inside scroll pane + panel
    JScrollPane scrollPane = new JScrollPane(table);
    JPanel panel = new JPanel();
    panel.add(scrollPane);
    main_frame.add(panel);
    main_frame.setVisible(true);
    }
}
