import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

class oop_inventory {
    private String product_id;
    private Boolean isactive;
    private Date last_updated;
    private String metal_type;
    private float metal_thickness_in;
    private float metal_thickness_mm;    
    private String sheet_size_WL;
    private float total_counts;
    private String location_area;
    private String rack;
    private String notes;
    public static void main(String[] args) {
        JFrame main_frame = new JFrame();
        main_frame.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;

        main_frame.setTitle("Inventory App - Landing Page");
        main_frame.setSize(x_screen/2,y_screen/2);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inventory_home = new JPanel();
        JPanel buttons = new JPanel();
        main_frame.add(inventory_home);
        //main_frame.add(buttons);
        JButton clickinventory_add = new JButton("New Inventory Entry");
        clickinventory_add.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_add);

        JPanel inventory_panel_template = new JPanel();
        int x_template = (x_screen - main_frame.getWidth()) / 8;
        int y_template = (y_screen - main_frame.getWidth()) / 8;
        inventory_panel_template.setLayout(new BoxLayout(inventory_panel_template, BoxLayout.Y_AXIS));
        inventory_panel_template.setSize(x_template, y_template);
        JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum","Other"});
        JComboBox<String> dropdown_finish = new JComboBox<>(new String[] {"Select Option", "Mill", "2B", "#3", "Other"});
        JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option", "20ga", "18ga", "16ga", "14ga", "12ga", "10ga", "8ga", "7ga", "3/16", "1/4", "5/16", "3/8", "Other"});
        JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});
        JTextField enter_counts = new JTextField(1);
        enter_counts.setMaximumSize(screenSize);
        inventory_panel_template.setSize(x_template, y_template);
        inventory_panel_template.add(new JLabel("Metal Type"));
        inventory_panel_template.add(dropdown_type);
        inventory_panel_template.add(new JLabel("Metal Finish"));
        inventory_panel_template.add(dropdown_finish);
        inventory_panel_template.add(new JLabel("Sheet Thickness"));
        inventory_panel_template.add(dropdown_thickness_gauges_inches);
        inventory_panel_template.add(new JLabel("Sheet Size"));
        inventory_panel_template.add(dropdown_size);
        inventory_panel_template.add(new JLabel("Enter total number of sheets."));
        inventory_panel_template.add(enter_counts);

        inventory_panel_template.add(buttons);

        JButton filter_entry = new JButton("Filter Selections");
        filter_entry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Select Option".equals(dropdown_type.getSelectedItem()) &&
                    "Select Option".equals(dropdown_finish.getSelectedItem()) &&
                    "Select Option".equals(dropdown_thickness_gauges_inches.getSelectedItem()) &&
                    "Select Option".equals(dropdown_size.getSelectedItem())) {
                        JOptionPane.showMessageDialog(inventory_home, "No filters provided. Change one or more of the filters to search.");
                    }
                if (!"Select Option".equals(dropdown_type.getSelectedItem())){}

            }
            });
        buttons.add(Box.createVerticalStrut(50)); 

        JButton cancel_entry = new JButton("Cancel Entry");
        buttons.add(filter_entry);
        buttons.add(cancel_entry);
        
        
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    
                    JPanel new_entry_panel = inventory_panel_template;
                    main_frame.add(new_entry_panel);
                    main_frame.setTitle("Inventory App - New Inventory");  
                        
                    cancel_entry.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    inventory_home.setVisible(true);
                    inventory_panel_template.setVisible(false);
                    main_frame.setTitle("Inventory App - Landing Page");
                    }
                    });
                    inventory_home.setVisible(false);
                    inventory_panel_template.setVisible(true);
                    }});
        JButton clickinventory_update = new JButton("Update Current Inventory");
        clickinventory_update.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_update);
        clickinventory_update.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JPanel update_entry_panel = inventory_panel_template;
            main_frame.add(update_entry_panel);
            inventory_home.setVisible(false);
            update_entry_panel.setVisible(true);
            main_frame.setTitle("Inventory App - Update Current Inventory");  

            cancel_entry.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inventory_home.setVisible(true);
                    update_entry_panel.setVisible(false);
                    main_frame.setTitle("Inventory App - Landing Page");
                    }
                    });
            }});
    JButton clickexit = new JButton("Exit");
    clickexit.setBounds(200,10,-1,-30);
    inventory_home.add(clickexit);
    main_frame.setAutoRequestFocus(true);
    clickexit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            main_frame.dispose(); }});  
    main_frame.setVisible(true);
    }
}
