//import java.util.Scanner;  // Import the Scanner class
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class oop_inventory {
    public static void main(String[] args) {
        JFrame main_frame = new JFrame();
        main_frame.setResizable(false);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;

        main_frame.setTitle("Inventory App - Landing Page");
        main_frame.setSize(x_screen/2,y_screen/2);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inventory_home = new JPanel();
        main_frame.add(inventory_home);
        JButton clickinventory_add = new JButton("New Inventory Entry");
        clickinventory_add.setBounds(200,10,1,3);
        inventory_home.add(clickinventory_add);
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JPanel new_entry_panel = new JPanel();
                    new_entry_panel.setLayout(new BoxLayout(new_entry_panel, BoxLayout.Y_AXIS));
                    main_frame.add(new_entry_panel);
                    JLabel select_metal_type = new JLabel("Metal Type");
                    JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"","Mild Steel", "Stainless Steel", "Aluminum","Other"});
                    
                    JLabel select_metal_finish = new JLabel("Metal Finish");
                    JComboBox<String> dropdown_finish = new JComboBox<>(new String[] {"Mill", "2B", "Option 3"});

                    JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"20ga", "18ga", "16ga", "14ga", "12ga", "10ga", "8ga", "7ga", "3/16", "1/4", "5/16", "3/8"});
                    JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"48x96", "60x96", "48x120", "60x120"});
                    JLabel enter_counts_label = new JLabel("Enter total number of sheets.");
                    JTextField enter_counts = new JTextField("", 20);
                   
                    int x = (x_screen - main_frame.getWidth()) / 4;
                    int y = (y_screen - main_frame.getWidth()) / 4;
                    new_entry_panel.setSize(x, y);
                    new_entry_panel.add(select_metal_type);
                    new_entry_panel.add(dropdown_type);
                    new_entry_panel.add(select_metal_finish);
                    new_entry_panel.add(dropdown_finish);
                    new_entry_panel.add(dropdown_thickness_gauges_inches);
                    new_entry_panel.add(dropdown_size);
                    new_entry_panel.add(enter_counts_label);
                    new_entry_panel.add(enter_counts);

                    JButton cancel_entry = new JButton("Cancel New Entry");
                    cancel_entry.setBounds(0,150,1,30);
                    new_entry_panel.add(cancel_entry);
                        
                    cancel_entry.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    inventory_home.setVisible(true);
                    new_entry_panel.setVisible(false);
                    main_frame.setVisible(true);
                    }
                    });
                    inventory_home.setVisible(false);
                    main_frame.setVisible(true);
                    }});
                JButton clickinventory_update = new JButton("Update Current Inventory");
                clickinventory_update.setBounds(200,10,1,3);
                inventory_home.add(clickinventory_update);


                JButton clickexit = new JButton("Exit");
                clickexit.setBounds(200,10,-1,-30);
                inventory_home.add(clickexit);
        
                main_frame.setAutoRequestFocus(true);
                
                clickexit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    main_frame.dispose();
                    }
                    });
        main_frame.setVisible(true);
        //myObj.close();
    }
}
