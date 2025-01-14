import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InventoryHome extends JFrame implements ActionListener{
    public static void main(String[] args){
        LoginFrame frame = new LoginFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;

        int x = (x_screen - frame.getWidth()) / 8;  // Center horizontally
        int y = (y_screen - frame.getWidth()) / 20;  // Top of the screen
        frame.setLocation(x, y);  // Centers the window on the screen
        frame.setResizable(false);

        frame.setSize(1500,1000); ; // Width: 400 pixels, Height: 300 pixels
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inventory_home = new JPanel();
        frame.add(inventory_home);

        GridLayout gridLayout = new GridLayout(25, 30);

        frame.setContentPane(inventory_home); 
        inventory_home.setLayout(gridLayout);

        JButton clickinventory_add = new JButton("New Entry");
        clickinventory_add.setBounds(50,80,100,30);
        clickinventory_add.setPreferredSize(new Dimension(150, 200));
        inventory_home.add(clickinventory_add);
        
        clickinventory_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> dropdown = new JComboBox<>(new String[] {"Test 1", "Text2", "Option 3"});
                frame.add(dropdown); // Close the current frame (optional)
                frame.setVisible(true);

            }
        });

        String[] columnNames = {"Active", "Last Updated", "Metal Type", "Thickness [in.]", "Thickness [MM]", "Sheet Size [WxL]", "Total Counts", "Area", "Rack"}; // Column headers
        Object[][] data = { // Table data
        {"true", "1/7/2025", "430 Stainless", "0.60", "1.5", "48x96", "12", "ITW", "ITW1"},

        };
        JTable table = new JTable(data, columnNames); // Create the table
        JScrollPane scrollPane = new JScrollPane(table); // Add scrollable feature
        inventory_home.add(scrollPane); // Add table to panel

        JButton clickexit = new JButton("Exit");
        clickexit.setBounds(200,10,-1,-30);
        inventory_home.add(clickexit);


        inventory_home.setMaximumSize(new Dimension(250, 400));


        
        frame.setMaximizedBounds(new Rectangle(x*2, y, x*2, y));
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
//

}
