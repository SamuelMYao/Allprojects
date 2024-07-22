import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoffeeMachine extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JLabel l1, l2;
    JButton b1, b2;
    JTextField t1, t2;
    JCheckBox cream, raw;
    private JRadioButton small;
    private JRadioButton large;
    private ButtonGroup group;

    CoffeeMachine() {
        // Components initialization
        l1 = new JLabel(" Customer Name");
        l2 = new JLabel(" amount to pay");
        b1 = new JButton("COMPUTE");
        b2 = new JButton("EXIT");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        small = new JRadioButton("small", true);
        large = new JRadioButton("large", false);
        group = new ButtonGroup();
        group.add(small);
        group.add(large);
        cream = new JCheckBox("cream", false);
        raw = new JCheckBox("raw sugar", false);

        // Menu Bar initialization
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // File menu
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        // File -> Exit menu item
        JMenuItem mntmExit = new JMenuItem("Exit");
        mnFile.add(mntmExit);
        mntmExit.addActionListener(e -> System.exit(0));

        // Help menu
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        // Help -> About menu item
        JMenuItem mntmAbout = new JMenuItem("About");
        mnHelp.add(mntmAbout);
        mntmAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String aboutMessage = "Programmed by Sammy Student\n"
                        + "Coffee Machine GUI Application\n"
                        + "Version 1.0";
                JOptionPane.showMessageDialog(null, aboutMessage, "About", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // GUI Layout
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(l1);
        panel.add(t1);
        panel.add(small);
        panel.add(cream);
        panel.add(large);
        panel.add(raw);
        panel.add(l2);
        panel.add(t2);
        panel.add(b1);
        panel.add(b2);
        add(panel);

        // Action Listeners
        b1.addActionListener(this);
        b2.addActionListener(e -> System.exit(0));

        // Frame Settings
        setSize(500, 400); // Adjusted size to fit the animated GIF
        setTitle("Coffee Machine");

        // Animated GIF (Assuming you have an animated GIF named coffee.gif in the same directory)
        ImageIcon coffeeIcon = new ImageIcon("coffee.gif");
        JLabel animatedLabel = new JLabel(coffeeIcon);
        add(animatedLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        // Handle button action (Compute)
        float price = 0;
        String a = "", message = "";

        // Exception handling for numeric input
        try {
            a = t1.getText();
            price = Float.parseFloat(a); // Parse input as float
            message = "Your order: " + a + " $" + price;
            t2.setText("Thank you: " + a);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric characters only.", "Input Error", JOptionPane.ERROR_MESSAGE);
            t1.setText(""); // Clear text field for re-input
        }

        JOptionPane.showMessageDialog(null, "Summary: \n" + message,
                "Order Summary", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            CoffeeMachine a = new CoffeeMachine();
            a.setVisible(true);
        });
    }
}
