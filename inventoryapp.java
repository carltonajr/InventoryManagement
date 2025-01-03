import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class inventoryapp {
    public static void main(String[] args){
        JFrame frame = new JFrame("W.H. Rogers - Login");

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
        JPanel login = new JPanel();
        frame.add(login);

        GridLayout gridLayout = new GridLayout(6, 1);

        frame.setContentPane(login); 
        login.setLayout(gridLayout); 
        login.add(new JLabel("Username:"));
        JTextField userinput = new JTextField("", 15);
        login.add(userinput);
        login.add(new JLabel("Password:"));
        JPasswordField passinput = new JPasswordField("", 20);
        passinput.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent passinput) {
                String text = new String(((JPasswordField) passinput).getPassword());
                if (text.length() >= 25 && text.length() <= 5){
                    JOptionPane.showMessageDialog(frame, "Password must be 30 characters or less.");
                return true; // Reject invalid input
        }
                return false; // Allow valid input
                }
            }
        );
        
        login.add(passinput);
        JButton clicklogin = new JButton("Login");
        login.add(clicklogin);
        JButton clickexit = new JButton("Exit");
        login.add(clickexit);
        login.setMaximumSize(new Dimension(250, 400));

        
        frame.setMaximizedBounds(new Rectangle(x*2, y, x*2, y));
        frame.setAlwaysOnTop(true);
        frame.setAutoRequestFocus(true);
        
        clicklogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String username = userinput.getText(); // Retrieve username
        char[] password = passinput.getPassword(); // Retrieve password
        JOptionPane.showMessageDialog(frame, "Username: " + username + "\nPassword: " + String.valueOf(password)); // Display inputs

            }
        });
        clickexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            }
            });

        frame.setVisible(true);
    }
}
