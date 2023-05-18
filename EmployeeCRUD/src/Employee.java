import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Employee {
    private JPanel main;
    private JTextField txtName;
    private JTextField txtSallary;
    private JTextField txtMobile;
    private JButton saveButton;
    private JTable table1;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField txtId;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(new Employee().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //database connection

    Connection con;
    PreparedStatement pst;
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/rbcompany","root","");
            System.out.println("successfully connected!");
        }
        catch(ClassNotFoundException ex){
            System.out.println("error");
        }
        catch (SQLException ex){
            System.out.println("error");
        }
    }





    public Employee() {

        connect();
    saveButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    }
}
