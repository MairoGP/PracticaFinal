import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {
    JTextField identifyOut = new JTextField();
    JTextField nameOut = new JTextField();
    JTextField surnameOut = new JTextField();
    JTextField emailOut = new JTextField();
    JTextField passwordOut = new JTextField();

    JButton signIn = new JButton("Sign In");
    UserPanel(User user){
        setLayout(new GridLayout(0,2));
        add(new JLabel("Identifier: "));
        identifyOut.setText(user.getIdentity());
        add(identifyOut);

        add(new JLabel("Name: "));
        nameOut.setText(user.getName());
        add(nameOut);

        add(new JLabel("Surname: "));
        surnameOut.setText(user.getSurname());
        add(surnameOut);

        add(new JLabel("E-mail: "));
        emailOut.setText(user.getEmail());
        add(emailOut);

        add(new JLabel("Password: "));
        passwordOut.setText(user.getPassword());
        add(passwordOut);

        setBorder(BorderFactory.createTitledBorder("User"));
        setVisible(true);
    }
}
