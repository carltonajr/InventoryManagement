
//Imports for SQL, JavaX.Swing, AWT
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class unit_testing_file{

    public static void main(String[] args){
        // JFrame that will house operations
        // Not Resizable
        // Set window title and defined sizing; End program if window is exited.
        JFrame main_frame = new JFrame();
        main_frame.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;
        main_frame.setTitle("Inventory App - Landing Page [Testing Env.]");
        main_frame.setSize(x_screen/2,y_screen/2);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Landing JPanel on start.
        // 2nd JPanel will house buttons
        JPanel inventory_home = new JPanel();
        JPanel buttons = new JPanel();
        main_frame.add(inventory_home);

        // JPanel for updating inventory will appear on click of the updating button.
        // Set the layout to 
        // 3 Combo boxes for filtering results
        JPanel update_inventory_panel_template = new JPanel();
        int x_template = (x_screen - main_frame.getWidth()) / 4;
        int y_template = (y_screen - main_frame.getWidth()) / 4;
        update_inventory_panel_template.setLayout(new BoxLayout(update_inventory_panel_template, BoxLayout.Y_AXIS));
        update_inventory_panel_template.setSize(x_template, y_template);
        JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum", "430", "Other"});
        JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option","0.03", "0.04", "0.05", "0.06", "0.07", "0.105", "0.12", "8ga", "0.188", "0.25", "0.3125", "0.375", "0.625", "0.50", "0.75","Other"});
        JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});

        //
        update_inventory_panel_template.setSize(x_template, y_template);
        update_inventory_panel_template.add(new JLabel("Metal Type"));
        update_inventory_panel_template.add(dropdown_type);
        update_inventory_panel_template.add(new JLabel("Sheet Thickness [inches]"));
        update_inventory_panel_template.add(dropdown_thickness_gauges_inches);
        update_inventory_panel_template.add(new JLabel("Sheet Size [WxL]"));
        update_inventory_panel_template.add(dropdown_size);
        update_inventory_panel_template.add(buttons);
        
        JButton filter_entry = new JButton("Filter Selections");
        buttons.add(Box.createVerticalStrut(50));
        JButton cancel_entry = new JButton("Cancel Entry");
        buttons.add(filter_entry);
        buttons.add(cancel_entry);


        JPanel new_inventory_panel = new JPanel();
        new_inventory_panel.setLayout(new BoxLayout(new_inventory_panel, BoxLayout.Y_AXIS));
        new_inventory_panel.setSize(x_template, y_template);


        JButton clickinventory_update = new JButton("New Inventory Entry");
        clickinventory_update.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_update);

        DefaultTableModel search_results = new DefaultTableModel(
            new Object[]{"product_id", "is_active", "last_updated", "metal_type",
            "thickness_in", "thickness_mm", "sheet_size_WL", "total_counts", 
            "location_area", "rack", "notes"}, 0);
            
        JScrollPane ScrollPane = new JScrollPane(new JTable(search_results));

        clickinventory_update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JPanel new_entry_panel = update_inventory_panel_template;
                    for (Component comp : new_entry_panel.getComponents()) {comp.setEnabled(true);}
                    new_entry_panel.setEnabled(false); 

                    
                    JTextField enter_counts = new JTextField(2);
                    enter_counts.setMaximumSize(screenSize);
                    main_frame.add(enter_counts);
                    main_frame.add(new_entry_panel);
                    main_frame.setTitle("Inventory App - New Inventory");  
                    
                    filter_entry.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            new_entry_panel.add(new JLabel("/////////////////////////////////////////////////Test"));
                            filter_entry.setEnabled(false);
                            ScrollPane.setVisible(true);
                            new_entry_panel.setLayout(new BorderLayout());
                            
                            //for(Component comp : new_entry_panel.getComponents()){comp.setEnabled(false);}
                            
                    }});
                    cancel_entry.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            inventory_home.setVisible(true);
                            main_frame.setTitle("Inventory App - Landing Page");
                            buttons.setVisible(false);
                            buttons.setEnabled(false);
                            new_entry_panel.setEnabled(false);
                            for(Component comp : new_entry_panel.getComponents()){comp.setEnabled(false);}
                    }});
                    inventory_home.setVisible(false);
                    buttons.setVisible(true);
                    }});
        JButton clickexit = new JButton("Exit");
        clickexit.setBounds(200,10,-1,-30);
        inventory_home.add(clickexit);
        main_frame.setAutoRequestFocus(true);
        clickexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main_frame  .dispose(); }});  
        main_frame.setVisible(true);
    }
}
