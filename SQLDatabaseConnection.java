import java.sql.*;
import javax.swing.JTable;

public class SQLDatabaseConnection {

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
                JTable loadedTable = new JTable(table_data, columnNames);
                System.out.print(loadedTable);
                }
                
            }
            
            }
            catch (SQLException e) {
                System.out.println(e);
            }
            System.exit(0);
    }
}
