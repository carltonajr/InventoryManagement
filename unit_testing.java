// imports
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
//Need to create a function that will temporarily store filters and clear them when set.
public class unit_testing {
    public static <picks> void main(String[] args)
    {
    JFrame main_frame = new JFrame();
    main_frame.setResizable(false);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension screenSize = toolkit.getScreenSize();
    int x_screen = screenSize.width;
    int y_screen = screenSize.height;
    main_frame.setTitle("Inventory App - Landing Page");
    main_frame.setSize(x_screen/2,y_screen/2);
    main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    int x_template = (x_screen - main_frame.getWidth()) / 4;
    int y_template = (y_screen - main_frame.getWidth()) / 4;
    JPanel home = new JPanel();
    JPanel buttons = new JPanel();
    main_frame.add(home);
    

    JButton clickinventory_add = new JButton("New Inventory Entry");
        clickinventory_add.setBounds(200,10,1,3);
        home.add(clickinventory_add);
    
    JButton filter_entry = new JButton("Filter Selections");
        buttons.add(Box.createVerticalStrut(50));
    
    JButton cancel_entry = new JButton("Cancel Entry");
        buttons.add(filter_entry);
        buttons.add(cancel_entry);
    clickinventory_add.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JPanel new_inventory_panel = new JPanel();
            new_inventory_panel.setLayout(new BoxLayout(new_inventory_panel, BoxLayout.Y_AXIS));
            new_inventory_panel.setSize(x_template, y_template);
            JTextField enter_counts = new JTextField(1);
            enter_counts.setMaximumSize(screenSize);
            main_frame.add(new_inventory_panel);
            main_frame.setTitle("Inventory App - New Inventory");  
                        
            cancel_entry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home.setVisible(true);
                new_inventory_panel.setVisible(false);
                main_frame.setTitle("Inventory App - Landing Page");
                }});
                home.setVisible(false);
                new_inventory_panel.setVisible(true);
                }});
    JButton clickexit = new JButton("Exit");
    clickexit.setBounds(200,10,-1,-30);
    home.add(clickexit);
    main_frame.setAutoRequestFocus(true);
    clickexit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            main_frame  .dispose(); }});  
    main_frame.setVisible(true);
    }
}
