import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private VideoGame videoGame;
    /*
        JTextField titleText = new JTextField();
        GridBagConstraints titleCons = new GridBagConstraints();
        ts developerCons = new GridBagConstraints();

        JLabel platform = new JLabel("Platf
        JLabel developer = new JLabel("Developer: ");
        JTextField developerText = new JTextField();
        GridBagConstrainorms: ");
        JTextField platformText = new JTextField();
        GridBagConstraints platformCons = new GridBagConstraints();

        JLabel category = new JLabel("Categories: ");
        JTextField categoryText = new JTextField();
        GridBagConstraints categoryCons = new GridBagConstraints();

        JLabel launchDate = new JLabel("Launch Date: ");
        JTextField launchDateText = new JTextField();
        GridBagConstraints launchCons = new GridBagConstraints();
      */
    GamePanel(VideoGame v){
        setLayout(new GridBagLayout());

        System.out.println(v.getTitle());

        GridBagConstraints devTitCons = new GridBagConstraints();
        devTitCons.gridx= 1;
        devTitCons.gridy= 0;

        GridBagConstraints developerCons = new GridBagConstraints();
        developerCons.gridx= 1;
        developerCons.gridy= 1;

        GridBagConstraints platTitCons = new GridBagConstraints();
        platTitCons.gridx= 2;
        platTitCons.gridy= 0;

        GridBagConstraints platformCons = new GridBagConstraints();
        platformCons.gridx=2;
        platformCons.gridy=1;

        GridBagConstraints catTitCons = new GridBagConstraints();
        catTitCons.gridx=3;
        catTitCons.gridy=0;

        GridBagConstraints categoryCons = new GridBagConstraints();
        categoryCons.gridx=3;
        categoryCons.gridy=1;

        GridBagConstraints launchTitCons = new GridBagConstraints();
        launchTitCons.gridx=4;
        launchTitCons.gridy=0;

        GridBagConstraints launchCons = new GridBagConstraints();
        launchCons.gridx=4;
        launchCons.gridy=1;

        add(new JLabel("Developer  "),devTitCons);
        add(new JLabel(v.getDeveloper().getName()),developerCons);
        add(new JLabel("Platforms  "),platTitCons);
        add(new JLabel(v.getPlatform()),platformCons);
        add(new JLabel("Category  "),catTitCons);
        add(new JLabel(v.getCategory()),categoryCons);
        add(new JLabel("Launch Date"),launchTitCons);
        add(new JLabel(v.getLaunchDate()),launchCons);

        setBorder(BorderFactory.createTitledBorder(v.getTitle()));
        setBounds(10,20,400,500);
        setVisible(true);
    }

    public VideoGame getVideoGame(){
        return this.videoGame;
    }
}
