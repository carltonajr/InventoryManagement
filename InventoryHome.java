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

        frame.setSize(1500,1000); ; // Width: 400 pixels, Height: 300 pixels
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inventory_home = new JPanel();
        frame.add(inventory_home);

        GridLayout gridLayout = new GridLayout(6, 1);

        frame.setContentPane(inventory_home); 
        inventory_home.setLayout(gridLayout);
        JLabel userlabel = new JLabel("Username:");
        //inventory_home.add(userlabel);
        JTextField userinput = new JTextField("", 15);
        //inventory_home.add(userinput);
        JLabel passlabel = new JLabel("Password:");
        //inventory_home.add(passlabel);
        JPasswordField passinput = new JPasswordField("", 20);

        passinput.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent passinput) {
                String usernameString = new String(userinput.getText());
                String passwordString = new String(((JPasswordField) passinput).getPassword());
                if (passwordString.length() >= 25 && passwordString.length() <= 5){
                    JOptionPane.showMessageDialog(frame, "Password must be 30 characters or less.");
                return true; // Reject invalid input
        }
                return false; // Allow valid input
                }
            }
        );
        
        userlabel.setBounds(50,150,100,30);
        passlabel.setBounds(50,220,100,30);
        userinput.setBounds(150,150,150,30);
        passinput.setBounds(150,220,150,30);
        //showPassword.setBounds(150,250,150,30);
        

        inventory_home.add(passinput);
        JButton clickinventory_home = new JButton("Login");
        clickinventory_home.setBounds(50,300,100,30);
        
        inventory_home.add(clickinventory_home);
        JButton clickexit = new JButton("Exit");
        clickexit.setBounds(200,300,100,30);
        inventory_home.add(clickexit);
        inventory_home.setMaximumSize(new Dimension(250, 400));


        
        frame.setMaximizedBounds(new Rectangle(x*2, y, x*2, y));
        frame.setAlwaysOnTop(true);
        frame.setAutoRequestFocus(true);
        
        clickinventory_home.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String userinput_string = userinput.getText(); // Retrieve username
        char[] passinput_string = passinput.getPassword(); // Retrieve password
        JOptionPane.showMessageDialog(frame, "Username: " + userinput_string + "\nPassword: " + String.valueOf(passinput_string)); // Display inputs

            }
        });
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

