import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employee {
    private JButton button1;
    private JPanel employee;

    public static void main(String[] args) {
        JFrame frame = new JFrame("employee");
        frame.setContentPane(new employee().employee);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public employee() {
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
