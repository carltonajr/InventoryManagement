import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InventoryHome extends JFrame implements ActionListener{
    String[] columnNames = {"Metal ID", "Active Status", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", 
                "Sheet Size [WxL]", "Total Counts", "Location Area", "Rack"}; // Column headers
    //public static DefaultTableModel datatable = new DefaultTableModel();
        static TableModel datatable;
        {
            try {
                Connection connect = DriverManager.getConnection("jdbc:sqlite:C:lib/inventory.db");
                Statement statement = connect.createStatement();
                ResultSet resultset = statement.executeQuery("SELECT * FROM company_inventory;");
                // While loop that executes there is another instance of 'resultset' during debugging
                while (resultset.next()){
                    // Create a new row of data stored in object 'rowData', contains each row from the SQL table
                    Object[] rowData = {
                        resultset.getString("product_id"),
                        resultset.getBoolean("is_active"),
                        resultset.getDate("last_updated"),
                        resultset.getString("metal_type"),
                        resultset.getFloat("thickness_in"),
                        resultset.getFloat("thickness_mm"),
                        resultset.getString("sheet_size_WL"),
                        resultset.getFloat("total_counts"),
                        resultset.getString("location"),
                        resultset.getString("rack"),
                        resultset.getString("notes")
                    };
                    // Adds the new row to the full table 'datatable'
                    // loop will run again if there is another row found in SQL table
            ((DefaultTableModel) datatable).addRow(rowData);
            JScrollPane SQL = new JScrollPane(new JTable(datatable)); // Add table to panel
            }
        }
                catch (SQLException e) {
                    System.out.println(e); // Display inputs
        }
    }
            public static void main(String[] args){
                //Reformated 'frame' to JFrame 
                JFrame frame = new JFrame();
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension screenSize = toolkit.getScreenSize();
                int x_screen = screenSize.width;
                int y_screen = screenSize.height;
        
                int x = (x_screen - frame.getWidth()) / 8;
                int y = (y_screen - frame.getWidth()) / 20;
                frame.setLocation(x, y);
                frame.setTitle("Inventory App - Landing Page");
                frame.setSize(1500,1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel inventory_home = new JPanel();
                frame.add(inventory_home);
        
                //'inventory_home' layout cleaner definition
                frame.setContentPane(inventory_home); 
                inventory_home.setLayout(new GridLayout(4, 3));
                inventory_home.add(new JScrollPane(new JTable())); // Add table to panel
    
            JButton clickinventory_add = new JButton("New Entries");
            clickinventory_add.setBounds(50,80,100,30);
            clickinventory_add.setPreferredSize(new Dimension(150, 200));
            inventory_home.add(clickinventory_add);
            
            clickinventory_add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox<String> dropdown = new JComboBox<>(new String[] {"Test 1", "Text2", "Option 3"});
                    frame.add(dropdown);
                    frame.setVisible(true);
                }});
            

            //
            
        JButton clickexit = new JButton("Exit");
        clickexit.setBounds(200,10,-1,-30);
        inventory_home.add(clickexit);


        //frame.setAlwaysOnTop(true);
        frame.setAutoRequestFocus(true);
        
        clickexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            }
            });
        frame.setVisible(true);
    }
    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e) { 
    }
}
