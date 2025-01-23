import java.sql.*;

public class SQLDatabaseConnection {

    public static void main(String[] args) {
        final String CONNECTION = "jdbc:sqlite:C:lib/inventory.db";
        String select_all = "SELECT * FROM company_inventory;";
        try (Connection conn = DriverManager.getConnection(CONNECTION);
            Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(select_all);
            {
                while(resultSet.next()){
                    System.out.print(resultSet.getString("product_id") + " | "
                                    + resultSet.getString("is_active") + " | "
                                    + resultSet.getString("last_updated") + " | "
                                    + resultSet.getString("metal_type") + " | "
                                    + resultSet.getString("thickness_in") + " | "
                                    + resultSet.getString("thickness_mm") + " | "
                                    + resultSet.getString("sheet_size_WL") + " | "
                                    + resultSet.getString("total_counts") + " | "
                                    + resultSet.getString("location_area") + " | "
                                    + resultSet.getString("rack"));
                }
            }
            
            }
            catch (SQLException e) {
                System.out.println(e);
            }
            System.exit(0);
    }
}
