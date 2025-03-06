import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;


class oop_inventory {

    public static <picks> void main(String[] args) {
        JFrame main_frame = new JFrame();
        main_frame.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;
        System.out.println();
        main_frame.setTitle("Inventory App - Landing Page");
        main_frame.setSize(x_screen/2,y_screen/2);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inventory_home = new JPanel();
        JPanel buttons = new JPanel();
        main_frame.add(inventory_home);

        JButton clickinventory_add = new JButton("New Inventory Entry");
        clickinventory_add.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_add);

        JPanel inventory_panel_template = new JPanel();
        int x_template = (x_screen - main_frame.getWidth()) / 8;
        int y_template = (y_screen - main_frame.getWidth()) / 8;
        inventory_panel_template.setLayout(new BoxLayout(inventory_panel_template, BoxLayout.Y_AXIS));
        inventory_panel_template.setSize(x_template, y_template);
        JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum","Other"});
        JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option", "", "18ga", "16ga", "14ga", "12ga", "10ga", "8ga", "7ga", "3/16", "1/4", "5/16", "3/8", "Other"});
        JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});
        
        inventory_panel_template.setSize(x_template, y_template);
        inventory_panel_template.add(new JLabel("Metal Type"));
        inventory_panel_template.add(dropdown_type);
        inventory_panel_template.add(new JLabel("Sheet Thickness [inches]"));
        inventory_panel_template.add(dropdown_thickness_gauges_inches);
        inventory_panel_template.add(new JLabel("Sheet Size [WxL]"));
        inventory_panel_template.add(dropdown_size);

        inventory_panel_template.add(buttons);

        JButton filter_entry = new JButton("Filter Selections");
        filter_entry.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> selections_map = new HashMap<>();
                //metal_type, thickness, sheet_size

                selections_map.put("metal_type", dropdown_type.getSelectedItem().toString());
                selections_map.put("thickness_in", dropdown_thickness_gauges_inches.getSelectedItem().toString());
                selections_map.put("sheet_size_WL", dropdown_size.getSelectedItem().toString());
                System.out.println(selections_map);
                Collection<String> items = new ArrayList<>();
                items.add(dropdown_size.getSelectedItem().toString());
                
                Collection<String> filters = new ArrayList<>();
                // map.keySet()
                for (String item : selections_map.values()) {
                    if (!"Select Option".equals(item)){
                    filters.add(item);}
                }
                System.out.println(filters);
                try {
            // Create a statement
            String url = "jdbc:sqlite:C:lib/inventory.db";
            
            
            // metal_type, thickness, sheet_size
            // Updated query syntax for modern databases
            String query_select_all = new String("SELECT * FROM company_inventory;");
            String query_select_filter = new String("");
            String query_insert = new String("");
            String query_delete = new String("");
            Statement conn_statement = DriverManager.getConnection(url).createStatement();
            
            // Execute the query
            int row_count = 0;
            ResultSet run_connection = conn_statement.executeQuery(query_select_all);
            Collection<String> product = new ArrayList<>();
            Collection<Boolean> is_active = new ArrayList<>();
            Collection<String> last_updates = new ArrayList<>();
            Collection<Float> metal_thickness_in = new ArrayList<>();
            Collection<Float> metal_thickness_mm = new ArrayList<>();
            Collection<String> sheet_size_WL = new ArrayList<>();
            Collection<Float> counts = new ArrayList<>();
            Collection<String> location = new ArrayList<>();
            Collection<String> rack = new ArrayList<>();
            Collection<String> notes = new ArrayList<>();

            while(run_connection.next()){
                String product_id = run_connection.getString("product_id");
                Boolean active = run_connection.getBoolean("is_active");
                String updated = run_connection.getString("last_updated");
                Float in_thick = run_connection.getFloat("thickness_in");
                Float mm_thick = run_connection.getFloat("thickness_mm");
                String sheet_size = run_connection.getString("sheet_size_WL");
                Float total_counts = run_connection.getFloat("total_counts");
                String rack_location = run_connection.getString("location_area");
                String in_rack = run_connection.getString("rack");
                String item_notes = run_connection.getString("notes");
                
                product.add(product_id);
                is_active.add(active);
                last_updates.add(updated);
                metal_thickness_in.add(in_thick);
                metal_thickness_mm.add(mm_thick);
                sheet_size_WL.add(sheet_size);
                counts.add(total_counts);
                location.add(rack_location);
                rack.add(in_rack);
                notes.add(item_notes);
                row_count = row_count + 1;
            }

            System.out.println("Number of rows affected by this query: " + row_count);

            // Close the connection
            conn_statement.close();
            //System.out.println("Connection closed.");
        }
        catch (SQLException error_sql_query) {
            System.err.println("SQL Error: " + error_sql_query.getMessage());
        }
                
        System.out.println(filters);
                JOptionPane.showMessageDialog(inventory_home, ("Filtering with criteria: " + filters));
                }          
            });
        buttons.add(Box.createVerticalStrut(50)); 

        JButton cancel_entry = new JButton("Cancel Entry");
        buttons.add(filter_entry);
        buttons.add(cancel_entry);
        
        
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    
                    JPanel new_entry_panel = inventory_panel_template;
                    JTextField enter_counts = new JTextField(1);
                    enter_counts.setMaximumSize(screenSize);
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
