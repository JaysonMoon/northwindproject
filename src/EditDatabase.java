import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;

public class EditDatabase extends JFrame{

    Connection con;
    PreparedStatement pst;
    private JPanel panelEdit;
    private JButton btnShippers;
    private JButton suppliersButton;
    private JButton productsButton;
    private JButton ordersButton;
    private JButton orderDetailsButton;
    private JButton customersButton;
    private JButton categoriesButton;
    private JTable tableShippers;

    public EditDatabase() {
        connect();
  //      table_load();

        setTitle("Login");
        setContentPane(panelEdit);
        setMinimumSize(new Dimension(450, 474));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        categoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from categories");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        customersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from customers");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        orderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from order_details");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from orders");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from products");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        suppliersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from suppliers");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnShippers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("select * from shippers");
                    ResultSet rs = pst.executeQuery();
                    tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        tableShippers.addComponentListener(new ComponentAdapter() {
        });
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
 /*   void table_load(){
        try{
            pst = con.prepareStatement("select * from categories");
            ResultSet rs = pst.executeQuery();
            tableShippers.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }*/




    public static void main(String[] args) {
        EditDatabase database = new EditDatabase();

    }
}