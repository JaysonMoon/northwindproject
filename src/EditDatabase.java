import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.*;

public class EditDatabase extends JFrame{

    Connection con;
    PreparedStatement pst;
    private JPanel panelEdit;
       private JButton btnShippers;
    private JTable tableShippers;

    public EditDatabase() {
        connect();
        table_load();

        setTitle("Login");
        setContentPane(panelEdit);
        setMinimumSize(new Dimension(450, 474));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/northwind", "root", "root");
            System.out.println("Success");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
}
void table_load(){
        try{
            pst = con.prepareStatement("select * from categories");
            ResultSet rs = pst.executeQuery();
            tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
}




    public static void main(String[] args) {
        EditDatabase database = new EditDatabase();

    }
}

