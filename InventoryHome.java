import java.util.Scanner;  // Import the Scanner class
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class oop_inventory {
    public static void main(String[] args) {
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
        JButton clickinventory_add = new JButton("New Entries");
        clickinventory_add.setBounds(200,10,-1,-30);
        //clickinventory_add.setPreferredSize(new Dimension(150, 200));
        inventory_home.add(clickinventory_add);
            
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JPanel add_new = new JPanel();
                    frame.add(add_new);
                    JLabel select = new JLabel("Metal Type");
                    add_new.add(select);
                    JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Steel", "Stainless Steel", "Option 3"});
                    //JComboBox<String> dropdown_type = new JComboBox<>(new String[] {"Steel", "Stainless Steel", "Option 3"});
                    JComboBox<String> dropdown_thickness_gauges_inches = new JComboBox<>(new String[] {"20ga", "18ga", "16ga", "14ga", "12ga", "10ga", "8ga", "7ga", "3/16", "1/4", "5/16", "3/8"});
                    JComboBox<String> dropdown_size = new JComboBox<>(new String[] {"48x96", "60x96", "48x120", "60x120"});
                    JLabel countfield = new JLabel("Enter Amount of Sheets");
                    JTextField enter_counts = new JTextField("", 20);

                    //dropdown.setLocation(x, y);
                    dropdown_type.setBounds(0,75,100, 100);
                    inventory_home.add(dropdown_type);
                    inventory_home.add(dropdown_thickness_gauges_inches);
                    inventory_home.add(dropdown_size);
                    inventory_home.add(countfield);
                    inventory_home.add(enter_counts);
                }});
        
                JButton clickexit = new JButton("Exit");
                clickexit.setBounds(200,10,-1,-30);
                inventory_home.add(clickexit);
        
                frame.setAutoRequestFocus(true);
                
                clickexit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    }
                    });
        frame.setVisible(true);
        //myObj.close();   
    }
}
