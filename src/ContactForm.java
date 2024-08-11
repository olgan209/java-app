import javax.swing.*;
import java.awt.*; // able to create objects
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ContactForm extends JFrame {
    JTextField nameField;
    JTextField emailField;
    JRadioButton male, female;
    JCheckBox check;

    public ContactForm() {
        super("Contact Form");
        setBounds(200, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));

        JLabel nameLabel = new JLabel("Write your name");
        nameField = new JTextField("", 15);
        JLabel emailLabel = new JLabel("Write your email");
        emailField = new JTextField("@", 15);

        container.add(nameLabel);
        container.add(nameField);
        container.add(emailLabel);
        container.add(emailField);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        check = new JCheckBox("Creator of this app is industrial. Agree?", false);
        JButton sendButton = new JButton("Send");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(sendButton);

        sendButton.addActionListener(new ButtonEvent());
    }

    class ButtonEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Male";
            if (female.isSelected()) {
                isMale = "Female";
            }

            boolean checkbox = check.isSelected();
            JOptionPane.showMessageDialog(null,
                    "Your email: " + email + "\nYour gender: " + isMale + "\nAre you agree? " + checkbox,
                    "Hello, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}