//Imports for SQL, JavaX.Swing, AWT
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class oop_inventory {

    public static <picks> void main(String[] args) {
        //create intial JFrame for starting point/ homepage
        //Do not make it resizeable
        //Set the size of the window relative to the PC screen size
        //Set Styling such as Title at the top of the window, define size of window.
        //Clicking the window closed will end the program.
        JFrame main_frame = new JFrame();
        main_frame.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;
        main_frame.setTitle("Inventory App - Landing Page");
        main_frame.setSize(x_screen/2,y_screen/2);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JPanels to hold user interaction fields. Store in the JFrame created earlier.
        JPanel inventory_home = new JPanel();
        JPanel buttons = new JPanel();
        main_frame.add(inventory_home);

        //Button to open field to add new data 
        JButton clickinventory_add = new JButton("New Inventory Entry");
        clickinventory_add.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_add);

        //Field to update existing inventory
        JPanel update_inventory_panel_template = new JPanel();
        int x_template = (x_screen - main_frame.getWidth()) / 4;
        int y_template = (y_screen - main_frame.getWidth()) / 4;
        update_inventory_panel_template.setLayout(new BoxLayout(update_inventory_panel_template, BoxLayout.Y_AXIS));
        update_inventory_panel_template.setSize(x_template, y_template);
        JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Select Option","Mild Steel", "Stainless Steel", "Aluminum", "430", "Other"});
        JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"Select Option","0.03", "0.04", "0.05", "0.06", "0.07", "0.105", "0.12", "8ga", "0.188", "0.25", "0.3125", "0.375", "0.625", "0.50", "0.75","Other"});
        JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"Select Option", "48x96", "60x96", "48x120", "60x120", "Other"});
        
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
        StringBuilder query = new StringBuilder("SELECT * FROM company_inventory WHERE ");
        StringBuffer query_select_filter = new StringBuffer("");
        
        JFrame found_inventory_frame = new JFrame();
        JPanel panel = new JPanel();
        found_inventory_frame.setSize(x_screen/4, y_screen/4);

        //On Click of the Filter Entry Button
        filter_entry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> selections_map = new HashMap<>();
                Object type = dropdown_type.getSelectedItem();
                Object thickness_in = dropdown_thickness_gauges_inches.getSelectedItem();
                Object sheet_size = dropdown_size.getSelectedItem();
                
                selections_map.put("metal_type", type.toString());
                selections_map.put("thickness_in", thickness_in.toString());
                selections_map.put("sheet_size_WL", sheet_size.toString());
                
                //Reset the ComboBoxes [Dropdowns] to the default 
                dropdown_type.setSelectedItem("Select Option");
                dropdown_thickness_gauges_inches.setSelectedItem("Select Option");
                dropdown_size.setSelectedItem("Select Option");

                
                Set<Map.Entry<String, String>> selections_map_entrySet = selections_map.entrySet();
                int counting = 0;
                Collection<String> filters = new ArrayList<>();
                Collection<String> searchingStrings = new ArrayList<>();
                
                for (Map.Entry<String, String> item : selections_map_entrySet)
                {
                    if (!"Select Option".equals(item.getValue())){
                        filters.add(item.getValue().toString());
                        searchingStrings.add(item.getKey() + " = \"" + item.getValue()+"\"");
                        query_select_filter.append(item.getKey() + " = \"" + item.getValue()+"\"");
                        
                    System.out.println("\nFilters:" + filters.size());
                    if (filters.size() > 3 && filters.size() > counting){
                        query_select_filter.append(" AND ");
                        System.out.println(query_select_filter);
                        }
                    counting += 1;
                    }
                    
                }
                selections_map.clear();
                System.out.println(selections_map);
                System.out.println(query);

                try {
            String[] columnNames = {"Metal ID", "Active Status", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", 
                                "Sheet Size [WxL]", "Total Counts", "Location Area", "Rack"}; // Column headers
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            
            // Updated query syntax for modern databases
            Statement conn_statement = DriverManager.getConnection("jdbc:sqlite:C:lib/inventory.db").createStatement();
            query.append(query_select_filter);
            // Execute the query

            //count the rows being created 
            int row_count = 0;
            System.out.println(query + ";");
            ResultSet run_connection = conn_statement.executeQuery(query + ";");
            while(run_connection.next()){
                Object[] row = {run_connection.getString("product_id"),
                run_connection.getBoolean("is_active"),
                run_connection.getString("last_updated"),
                run_connection.getString("metal_type"),
                run_connection.getFloat("thickness_in"),
                run_connection.getFloat("thickness_mm"),
                run_connection.getString("sheet_size_WL"),
                run_connection.getFloat("total_counts"),
                run_connection.getString("location_area"),
                run_connection.getString("rack"),
                run_connection.getString("notes")};
                model.addRow(row);
                row_count = row_count + 1;
            }
            
            JScrollPane scrollPane = new JScrollPane(new JTable(model));
            found_inventory_frame.add(panel.add(scrollPane));

            System.out.println("Number of rows affected by this query: " + row_count);

            // Close the connection
            conn_statement.close();
            System.out.println("Connection closed.");
            found_inventory_frame.setVisible(true);
        }
        catch (SQLException error_sql_query) {
            System.err.println("SQL Error: " + error_sql_query.getMessage());
        }
                }          
            });
        
        
        
        
        /////////
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JPanel new_entry_panel = update_inventory_panel_template;
                    JTextField enter_counts = new JTextField(1);
                    enter_counts.setMaximumSize(screenSize);
                    main_frame.add(new_entry_panel);
                    main_frame.setTitle("Inventory App - New Inventory");  
                        
                    cancel_entry.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    inventory_home.setVisible(true);
                    update_inventory_panel_template.setVisible(false);
                    main_frame.setTitle("Inventory App - Landing Page");
                    }
                    });
                    inventory_home.setVisible(false);
                    update_inventory_panel_template.setVisible(true);
                    }});
        JButton clickinventory_update = new JButton("Update Current Inventory");
        clickinventory_update.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_update);
        clickinventory_update.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JPanel update_entry_panel = update_inventory_panel_template;
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
            main_frame  .dispose(); }});  
    main_frame.setVisible(true);

    }
}
