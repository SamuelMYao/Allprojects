import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Sammy Student
public class SimpleGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JLabel l1, l2, l3, l4, l5;
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    JCheckBox check1;

    SimpleGUI() {
        l1 = new JLabel(" INPUT 1");
        l2 = new JLabel(" INPUT 2");
        l3 = new JLabel(" OUTPUT");
        l4 = new JLabel(" ");
        l5 = new JLabel(" Difference");

        b1 = new JButton("Compute");
        b2 = new JButton("EXIT");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);

        check1 = new JCheckBox("click to select");
        check1.setSelected(true);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(b1);
        add(check1);
        add(b2);
        add(l5);
        add(t4);

        b1.addActionListener(this);
        b2.addActionListener(e -> System.exit(0));

        setLayout(new GridLayout(5, 2));
        setTitle("Simple Java GUI");
        setSize(500, 300);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                float currentSalary = Float.parseFloat(t1.getText());
                float newSalary = Float.parseFloat(t2.getText());
                float difference = newSalary - currentSalary;
                t4.setText(String.format("%.2f", difference));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.");
            }
        }
    }

    public static void main(String args[]) {
        SimpleGUI a = new SimpleGUI();
        a.setVisible(true);
        a.setLocationRelativeTo(null); // Center the frame on the screen
    }
}