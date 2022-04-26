import javax.swing.*;
import java.awt.*;

public class EditDatabase extends JFrame{
    private JPanel panelEdit;
       private JButton btnShippers;
    private JTable tableShippers;

    public EditDatabase() {

        setTitle("Login");
        setContentPane(panelEdit);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        EditDatabase database = new EditDatabase();

    }
}

