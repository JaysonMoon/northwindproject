import javax.swing.*;
import java.awt.*;
import java.awt.image.renderable.RenderableImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DashboardForm extends JFrame {
    private JPanel dashboardPanel;
    private JLabel lbAdmin;
    private JButton brnRegister;


    public DashboardForm(){
        setTitle("Dashboard");
            setContentPane(dashboardPanel);
            setMinimumSize(new Dimension(500, 429));
            setSize(1200, 700);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            boolean hasRegisteredUsers= connectToDatabase();
            if(hasRegisteredUsers){
                LoginForm loginForm = new LoginForm(this);
                User user = loginForm.user;

                if (user != null){
                    lbAdmin.setText("User: " + user.username);
                    setLocationRelativeTo(null);
                    setVisible(true);
                }
                else{
                    dispose();
                }
            }
            else{
                RegistrationForm registrationForm = new RegistrationForm(this);
                User user = registrationForm.user;

                if (user != null){
                    lbAdmin.setText("User: " + user.username);
                    setLocationRelativeTo(null);
                    setVisible(true);
                }
                else { dispose();}
            }
    }

    private boolean connectToDatabase(){
        boolean hasRegisteredUsers = false;

        final String DB_URL = "jdbc:mysql://localhost/northwind";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate(" ");
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasRegisteredUsers;

    }
}
