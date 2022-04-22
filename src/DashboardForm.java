import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.renderable.RenderableImage;
import java.sql.*;

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
        brnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm = new RegistrationForm(DashboardForm.this);
                User user = registrationForm.user;

                if (user != null){
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "New User: " + user.username,
                            "Successful Registration",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
    }

    private boolean connectToDatabase(){
        boolean hasRegisteredUsers = false;

        final String DB_URL = "jdbc:mysql://localhost/northwind";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS northwind");
            statement.close();
            conn.close();
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if(resultSet.next()){
                int numUsers = resultSet.getInt(1);
                if(numUsers > 0){
                    hasRegisteredUsers = true;
                }
            }

            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasRegisteredUsers;

    }

    public static void main(String[] args) {
        DashboardForm myForm = new DashboardForm();
    }
}
