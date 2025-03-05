import java.sql.*;
import java.sql.Date;
import java.util.*;


public class buildoutSQLConnection_Class {
    public buildoutSQLConnection_Class(
        String product_id, Boolean is_active, Date last_updated, String metal_type, Float thick_in,
        Float thick_mm, String sheet_size, Float counts, String location, String rack, String item_notes){
        
            this.product_id = product_id;
            this.is_active = is_active;
            this.last_updated = last_updated;
            this.metal_type = metal_type;
            this.thick_in = thick_in;
            this.thick_mm = thick_mm;
            this.sheet_size = sheet_size;
            this.counts = counts;
            this.location = location;
            this.rack = rack;
            this.item_notes = item_notes;

    }
    //columns from the SQL table
    private String product_id;
    private Boolean is_active;
    private Date last_updated;
    private String metal_type;
    private Float thick_in;
    private Float thick_mm;
    private String sheet_size;
    private Float counts;
    private String location;
    private String rack;
    private String item_notes;



    String url = "jdbc:sqlite:C:lib/inventory.db";

    // Updated query syntax for modern databases
    String query_select_all = new String("");
    String query_select_filter = new String("");
    String query_insert = new String("");
    String query_delete = new String("");

    int row_count = 0;
    //ResultSet run_connection = conn_statement.executeQuery(query_select_all);
    Collection<String> product_id_array = new ArrayList<>();
    Collection<Boolean> is_active_array = new ArrayList<>();
    Collection<String> last_updated_array = new ArrayList<>();
    Collection<Float> thick_in_array = new ArrayList<>();
    Collection<Float> thick_mm_array = new ArrayList<>();
    Collection<String> sheet_size_array = new ArrayList<>();
    Collection<Float> counts_array = new ArrayList<>();
    Collection<String> location_array = new ArrayList<>();
    Collection<String> rack_array = new ArrayList<>();
    Collection<String> item_notes_array = new ArrayList<>();

    public void run_connection(){
        try {
            // Load Type-4 Driver
            // MySQL Type-4 driver class
            // Establish connection
            //
            // Create a statement
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
            System.out.println(product);
            System.out.println(last_updates);
            System.out.println(location);
            System.out.println(rack);
            System.out.println(sheet_size_WL);
            System.out.println(counts);
            System.out.println(notes);
            System.out.println("Number of rows affected by this query: " + row_count);

            // Close the connection
            conn_statement.close();
            System.out.println("Connection closed.");
        }
        catch (SQLException e) {
            System.err.println("SQL Error: "
                               + e.getMessage());
        }
    }
}
