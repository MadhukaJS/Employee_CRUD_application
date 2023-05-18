import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Employee {
    private JPanel MAIN;
    private JTextField txtName;
    private JTextField txtSallary;
    private JTextField txtMobile;
    private JButton saveButton;
    private JTable table1;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField txtId;
    private JScrollPane Table_1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(new Employee().MAIN);
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
            ex.printStackTrace();
            System.out.println("error");

        }
        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("error");
        }
    }

    public void table_load(){
        try{
            pst= con.prepareStatement("select * from employee");
            ResultSet rs= pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }





    public Employee() {

        connect();
        table_load();


    saveButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {


            String empName,sallary,mobile;

            empName=txtName.getText();
            sallary=txtSallary.getText();
            mobile=txtMobile.getText();

            try{
                pst=con.prepareStatement("insert into employee(empName,sallary,mobile)values (?,?,?)");
                pst.setString(1,empName);
                pst.setString(2,sallary);
                pst.setString(3,mobile);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Saves successfully");

                txtName.setText("");
                txtSallary.setText("");
                txtMobile.setText("");
                txtName.requestFocus();



            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }





    });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empName,sallary,mobile,ID;

                empName=txtName.getText();
                sallary=txtSallary.getText();
                mobile=txtMobile.getText();
                ID=txtId.getText();

                try{
                    pst=con.prepareStatement("update employee set empName=?,sallary=?,mobile=?");
                    pst.setString(1,empName);
                    pst.setString(2,sallary);
                    pst.setString(3,mobile);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"update successfully");

                    txtName.setText("");
                    txtSallary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                    table_load();



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        //delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID;


                ID=txtId.getText();

                try{
                    pst=con.prepareStatement("delete from employee where id=?");
                    pst.setString(1,ID);


                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"delete successfully");

                    table_load();



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


//        //search button
//        searchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    String ID = txtId.getText();
//
//                    pst = con.prepareStatement("select ID,empName,Sallary,Mobile from employee where ID=?");
//                }
//                catch (SQLException ex){
//                    ex.printStackTrace();
//
//                }
//            }
//        });

    }
}
