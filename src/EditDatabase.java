import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditDatabase extends JFrame{
    private JPanel panelEdit;
       private JButton btnCustomers;
    private JScrollPane table;

    public EditDatabase() {

    }

    public static void main(String[] args) {
        EditDatabase database = new EditDatabase();

    }
}

