import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SignUpPanel extends JPanel {
    JLabel identity = new JLabel("Identifier: ");
    JTextField identityIn = new JTextField(10);

    JLabel name = new JLabel("Name: ");
    JTextField nameIn = new JTextField(10);

    JLabel surname = new JLabel("Surname: ");
    JTextField surnameIn = new JTextField(10);

    JLabel email = new JLabel("E-mail: ");
    JTextField emailIn = new JTextField(10);

    JLabel psswd = new JLabel("Password: ");
    JTextField psswdIn = new JTextField(10);

    JLabel psswdRep = new JLabel("Repeat the password: ");
    JTextField psswdRepIn = new JTextField(10);

    JButton signUp = new JButton("Sign Up");
    SignUpPanel(JDialog d){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Sign Up"));

        Container container = new Container();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx=0;
        constraints.gridy=0;
        container.add(identity,constraints);

        constraints.gridx=1;
        constraints.gridy=0;
        container.add(identityIn,constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        container.add(name,constraints);

        constraints.gridx=1;
        constraints.gridy=1;
        container.add(nameIn,constraints);

        constraints.gridx=0;
        constraints.gridy=2;
        container.add(surname,constraints);

        constraints.gridx=1;
        constraints.gridy=2;
        container.add(surnameIn,constraints);

        constraints.gridx=0;
        constraints.gridy=3;
        container.add(email,constraints);

        constraints.gridx=1;
        constraints.gridy=3;
        container.add(emailIn,constraints);

        constraints.gridx=0;
        constraints.gridy=4;
        container.add(psswd,constraints);

        constraints.gridx=1;
        constraints.gridy=4;
        container.add(psswdIn,constraints);

        constraints.fill=1;
        constraints.gridx=0;
        constraints.gridy=6;
        container.add(signUp,constraints);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData(container);
                d.dispose();
            }
        });
        add(container);
        container.setVisible(true);
        setVisible(true);
    }

    private void getData(Container c) {
        List<String> data = new ArrayList<>();
        for (Component comp:
             c.getComponents()) {
            if (comp instanceof JTextField){
                data.add(((JTextField) comp).getText());
            }
        }
        Main.userRegistration((ArrayList<String>) data);
        JOptionPane.showMessageDialog(c,"User created succesfully","Succes",JOptionPane.INFORMATION_MESSAGE);
    }
}
