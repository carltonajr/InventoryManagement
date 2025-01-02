import javax.swing.*;
import java.awt.*;


public class inventoryapp {
    public static void main(String[] args){
        JFrame frame = new JFrame("W.H. Rogers - Inventory Management");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x_screen = screenSize.width;
        int y_screen = screenSize.height;

        int x = (x_screen - frame.getWidth()) / 4;  // Center horizontally
        int y = (y_screen - frame.getWidth()) /4;  // Top of the screen
        frame.setLocation(x, y);  // Centers the window on the screen

        frame.setSize(250,250); ; // Width: 400 pixels, Height: 300 pixels
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel welcome = new JLabel("jshdbckn");
        frame.add(welcome);
        JPanel login = new JPanel();
        frame.add(login);

        GridLayout gridLayout = new GridLayout(6, 1);

        frame.setContentPane(login); 
        login.setLayout(gridLayout); 
        login.add(new JLabel("Username:"));
        login.add(new JTextField(20));
        login.add(new JLabel("Password:"));
        login.add(new JPasswordField(20));
        login.add(new JButton("Login"));
        login.add(new JButton("Exit Program"));
        login.setMaximumSize(new Dimension(250, 400));

        
        frame.setMaximizedBounds(new Rectangle(x*2, y, x*2, y));
        
        frame.setVisible(true);
    }
}
