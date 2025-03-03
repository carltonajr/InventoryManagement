// Java program to implement a simple JDBC application
import java.sql.*;
import java.util.*;

public class SQLDatabaseConnection{
    public static void main(String[] args)
        {
        // Replace with your database name
        String url = "jdbc:sqlite:C:lib/inventory.db";

        // Updated query syntax for modern databases
        String query_select_all = "SELECT * FROM company_inventory";

        // Establish JDBC Connection
        try {
            // Load Type-4 Driver
            // MySQL Type-4 driver class
            // Establish connection
            //
            // Create a statement
            Statement conn_statement = DriverManager.getConnection(url).createStatement();
            
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
            System.out.println(product);
            System.out.println(last_updates);
            System.out.println(sheet_size_WL);
            System.out.println(sheet_size_WL);
            System.out.println(counts);
            System.out.println(notes);
            System.out.println("Number of rows affected by this query: " + row_count);

            // Close the connection
            conn_statement.close();
            System.out.println("Connection closed.");
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
