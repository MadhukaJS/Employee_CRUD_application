import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Employee() {
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
