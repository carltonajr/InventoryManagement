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
