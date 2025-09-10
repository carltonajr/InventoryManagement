import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;
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
    String[] columns = {"Rack Location", "Thickness [in]","Sheet Size", "Metal Type", "On Hand", "Metal Finish", "Total Used", "Notes"};
    Object[][] data = {
        {"Select Option", "Select Option", "Select Option", "Select Option", "Value", "Select Option", "", ""},
        {"Select Option", "Select Option", "Select Option", "Select Option", "value","Select Option", "", ""}};

    JTable table = new JTable(data, columns);

    // Create a dropdown (combo box) for the "Category" column

    JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum", "430", "Other"});
    JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option","0.039", "0.049", "0.06", "0.07", "0.105", "0.12", "", "0.188", "0.25", "0.3125", "0.375", "0.625", "0.50", "0.75", "1.0", "Other"});
    JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});
    JComboBox<String> dropdown_locate = new JComboBox<>(new String[] {"Select Option", "Laser","ITW", "TWR", "1", "2", "3", "4", "5", "6"});
    JLabel onhandJLabel = new JLabel("# of sheets");
    JTextField numericField = new JTextField();
    JTextField notesField = new JTextField();

    // Attach a DocumentFilter to the text field
    ((AbstractDocument) numericField.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        // Check input before allowing insert
        // (rules: digits + decimal point, no negatives, max 999)
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        // Check replacement text with same rules
    }
});
    // Assign dropdown as the editor for column 1 (second column)
    table.setAutoResizeMode(JTable.WIDTH);
    table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(dropdown_locate));
    table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(dropdown_thickness_gauges_inches));
    table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(dropdown_size));
    table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(dropdown_type));
    table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(dropdown_type));
    table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(numericField));
    table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(notesField));

    // Put table inside scroll pane + panel
    JScrollPane scrollPane = new JScrollPane(table);
    JPanel panel = new JPanel();
    panel.add(scrollPane);
    main_frame.add(panel);
    main_frame.setVisible(true);
    }
}
