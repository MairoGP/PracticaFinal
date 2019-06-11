import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsPanel extends JPanel {

    JButton deleteGame = new JButton("Delete any Game of the List");
    JButton addGame = new JButton("Add a new VideoGame");

    InstructionsPanel(User u){
        setLayout(new GridLayout(0,1));
        setBorder(BorderFactory.createEmptyBorder());
        add(deleteGame);
        deleteGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectToDelete(u);
            }
        });
        add(addGame);
        addGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewGame(u);
            }
        });
    }

    private void addNewGame(User u) {
        VideoGame newGame = VideoGame.createNewGame();
        u.addVideoGame(newGame);
        LibraryPanel.addGamePanel(newGame);
    }

    private void selectToDelete(User u) {
        JDialog deletePanel = new JDialog();
        deletePanel.setLayout(new GridLayout(0,2));
        for (VideoGame v:
                u.getLibrary()) {
            GamePanel games = new GamePanel(v);
            deletePanel.add(games);
            JButton choose = new JButton("Delete");
            choose.setBounds(400,400,30,games.getHeight());
            choose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteGame(u,v);
                    JOptionPane.showMessageDialog(null,
                            "VideoGame Deleted Succesfully",
                            "Delete",JOptionPane.INFORMATION_MESSAGE);
                    deletePanel.dispose();
                }
            });
            deletePanel.add(choose);
            deletePanel.pack();
            deletePanel.setVisible(true);
        }
    }

    private void deleteGame(User u, VideoGame v) {
        for (VideoGame vg:
                u.getLibrary()) {
            if (vg.getTitle().equals(v.getTitle())){
                u.deleteVideoGame(vg);
                LibraryPanel.deleteGamePanel(v);
                break;
            }
        }
    }
}
