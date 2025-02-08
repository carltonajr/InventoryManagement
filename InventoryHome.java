import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InventoryItem {
    // Declare private variables for the attributes
    private String productId;
    private boolean isActive;
    private String lastUpdated;
    private String metalType;
    private float thicknessIn;
    private float thicknessMm;
    private String sheetSizeWL;
    private float totalCounts;
    private String locationArea;
    private String rack;
    private String notes;

    // Constructor to initialize the attributes
    public InventoryItem(String productId, boolean isActive, String lastUpdated, String metalType,
                         float thicknessIn, float thicknessMm, String sheetSizeWL, float totalCounts,
                         String locationArea, String rack, String notes) {
        this.productId = productId;
        this.isActive = isActive;
        this.lastUpdated = lastUpdated;
        this.metalType = metalType;
        this.thicknessIn = thicknessIn;
        this.thicknessMm = thicknessMm;
        this.sheetSizeWL = sheetSizeWL;
        this.totalCounts = totalCounts;
        this.locationArea = locationArea;
        this.rack = rack;
        this.notes = notes;
    }

    // Getters and Setters for each attribute
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMetalType() {
        return metalType;
    }

    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    public float getThicknessIn() {
        return thicknessIn;
    }

    public void setThicknessIn(float thicknessIn) {
        this.thicknessIn = thicknessIn;
    }

    public float getThicknessMm() {
        return thicknessMm;
    }

    public void setThicknessMm(float thicknessMm) {
        this.thicknessMm = thicknessMm;
    }

    public String getSheetSizeWL() {
        return sheetSizeWL;
    }

    public void setSheetSizeWL(String sheetSizeWL) {
        this.sheetSizeWL = sheetSizeWL;
    }

    public float getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(float totalCounts) {
        this.totalCounts = totalCounts;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

class SELECTDatabaseConnection {

}
public class InventoryHome extends JFrame implements ActionListener{
    public static TableModel tableModel;

    {
        String[] columnNames = {"Metal ID", "Active Status", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", 
                "Sheet Size [WxL]", "Total Counts", "Location Area", "Rack"}; // Column headers
        final String CONNECTION = "jdbc:sqlite:C:lib/inventory.db";
        
        String select_all = "SELECT * FROM company_inventory;";
        try (Connection conn = DriverManager.getConnection(CONNECTION);
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(select_all);
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            
            {
                while(resultSet.next()){
                    Object[] rowData = {
                        resultSet.getString("product_id"),
                        resultSet.getBoolean("is_active"),
                        resultSet.getDate("last_updated"),
                        resultSet.getString("metal_type"),
                        resultSet.getFloat("thickness_in"),
                        resultSet.getFloat("thickness_mm"),
                        resultSet.getString("sheet_size_WL"),
                        resultSet.getFloat("total_counts"),
                        resultSet.getString("location"),
                        resultSet.getString("rack"),
                        resultSet.getString("notes")
                    };  
                    tableModel.addRow(rowData);
                }
            }
            }
            catch (SQLException e) {
                System.out.println(e);
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
            inventory_home.add(new JScrollPane(new JTable(tableModel))); // Add table to panel
    
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
