import javax.swing.*;
import java.awt.*;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryPanel extends JPanel {
    static LibraryPanel myself;
    static List<GamePanel> panels = new ArrayList<GamePanel>();

    JLabel title = new JLabel("Welcome to your Library");
    GridBagConstraints titleConst = new GridBagConstraints();

    JLabel owner = new JLabel("Owner");
    GridBagConstraints ownerConst = new GridBagConstraints();

    JLabel none = new JLabel("No VideoGames saved yet");
    GridBagConstraints noneConst = new GridBagConstraints();
    LibraryPanel(User u){
        myself = this;
        setLayout(new GridLayout(0,1));
        setBorder(BorderFactory.createRaisedSoftBevelBorder());

        owner.setText(u.getName());
        owner.setSize(600,40);

        Map<Component,GridBagConstraints> constraints = new HashMap<>();
        titleConst.gridx=1;
        titleConst.gridy=0;
        constraints.put(title,titleConst);

        ownerConst.gridx=0;
        ownerConst.gridy=1;
        constraints.put(owner,ownerConst);

        for (Map.Entry<Component,GridBagConstraints> entry :
             constraints.entrySet()) {
            add(entry.getKey(),entry.getValue());
        }

        if (u.getLibrary() == null){
            noneConst.gridx=1;
            noneConst.gridy=3;
            noneConst.gridheight=10;
            add(none,noneConst);
        } else {
            for (VideoGame v:
                 u.getLibrary()) {
                GamePanel g = new GamePanel(v);
                add(g);
                panels.add(g);
            }
        }
    }

    public static void addGamePanel(VideoGame v){
        GamePanel newGamePanel = new GamePanel(v);
        myself.add(newGamePanel);
    }

    public static void deleteGamePanel(VideoGame v){
        for (GamePanel gp:
             panels) {
            if(gp.getVideoGame().getTitle().equals(v.getTitle())){
                myself.remove(gp);
                myself.updateUI();
                break;
            }
        }
    }
}
