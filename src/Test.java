import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Platform> rdr2P = new ArrayList<>();
        rdr2P.add(Platform.XBOXONE);
        rdr2P.add(Platform.PC);
        List<Category> rdr2C = new ArrayList<>();
        rdr2C.add(Category.ACTION);
        rdr2C.add(Category.ADVENTURES);

        VideoGame rdr2 = new VideoGame("Red Dead Redemption 2","19-07-2018",rdr2P,Developer.BETHESDA,rdr2C);
        JFrame frame = new JFrame();
        frame.add(new GamePanel(rdr2));

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
