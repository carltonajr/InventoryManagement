import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;


class SQLDatabaseConnection {
    public static void main(String[] args) {
        final String CONNECTION = "jdbc:sqlite:C:lib/inventory.db";
        String select_all = "SELECT * FROM company_inventory;";
        String[] columnNames = {"Metal ID", "Active Status", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", 
                                "Sheet Size [WxL]", "Total Counts", "Location Area", "Rack"}; // Column headers
        try (Connection conn = DriverManager.getConnection(CONNECTION);
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(select_all);
            {
                while(resultSet.next()){
                    Object[][] table_data = {
                    {
                    resultSet.getString("product_id"),
                    resultSet.getString("is_active"),
                    resultSet.getString("last_updated"),
                    resultSet.getString("metal_type"),
                    resultSet.getString("thickness_in"),
                    resultSet.getString("thickness_mm"),
                    resultSet.getString("sheet_size_WL"),
                    resultSet.getString("total_counts"),
                    resultSet.getString("location_area"),
                    resultSet.getString("rack")}
                    };
                JScrollPane sqlscrollPane = new JScrollPane(new JTable(new DefaultTableModel(table_data, columnNames)));
                }
                
            }
            
            }
            catch (SQLException e) {
                System.out.println(e);
            }
            System.exit(0);
    }
}

public class InventoryHome extends JFrame implements ActionListener{
    
        public static void main(String[] args){
            //Reformated 'frame' to JFrame 
            JFrame frame = new JFrame();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x_screen = screenSize.width;
            int y_screen = screenSize.height;
            SQLDatabaseConnection SQLDatabaseConnection = new SQLDatabaseConnection();
    
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
    
            JButton clickinventory_add = new JButton("New Entries");
            clickinventory_add.setBounds(50,80,100,30);
            clickinventory_add.setPreferredSize(new Dimension(150, 200));
            inventory_home.add(clickinventory_add);
            
            clickinventory_add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox<String> dropdown = new JComboBox<>(new String[] {"Test 1", "Text2", "Option 3"});
                    frame.add(dropdown);
                    frame.setVisible(true);
    
                }
            });
            //
            String[] columnNames = {"Metal ID", "Active Status", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", "Sheet Size [WxL]", "Total Counts", "Location Area", "Rack"}; // Column headers
            Object[][] data = {{
                SQLDatabaseConnection.sqlscrollPane.product_id,
                "true",
                "1/7/2025",
                "430 Stainless",
                "0.60",
                "1.5",
                "48x96",
                "12",
                "ITW",
                "ITW1"
            }};
            JTable table = new JTable(data, columnNames); // Create the table
            //JScrollPane scrollPane = new JScrollPane(table); // Add scrollable feature
            //inventory_home.addSQLDatabaseConnection(SQLDatabaseConnection); // Add table to panel

        JButton clickexit = new JButton("Exit");
        clickexit.setBounds(200,10,-1,-30);
        inventory_home.add(clickexit);


        frame.setAlwaysOnTop(true);
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
