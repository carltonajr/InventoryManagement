import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

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
                ArrayList <Object[]> ids = new ArrayList<>();
                while(resultSet.next()){
                    String seasons = resultSet.getString("product_id");
                    //ids.add(seasons);
                    //System.out.println(ids);
                }
            
            }
            
            }
            catch (SQLException e) {
                System.out.println(e);
            }
            System.exit(0);
    }
}
