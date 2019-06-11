import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class StartUpPanel extends JPanel {

    JLabel instructions = new JLabel("Please, enter your identifier");
    JTextField identifier = new JTextField(15);
    JLabel newUser = new JLabel("New here? Sing Up!");
    JButton Up = new JButton("Sign Up");
    JButton In = new JButton("Sign In");

    StartUpPanel(){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Identify"));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx=0;
        constraints.gridy=0;
        add(instructions,constraints);

        constraints.gridx=1;
        constraints.gridy=0;
        add(identifier,constraints);

        constraints.gridx=1;
        constraints.gridy=1;
        add(Up,constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        add(newUser,constraints);

        constraints.gridx=2;
        constraints.gridy=0;
        add(In,constraints);

        setVisible(true);

        In.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.UserAccess(identifier.getText());
            }
        });

        Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.UserSignUp(Up.getText());
            }
        });

    }
}
