import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static Map<String,User> users = new TreeMap<>();
    private static JFrame frame = new JFrame("VideoGames Library");
    private static JButton userList = new JButton("Users");
    private static List<Component> components = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //readUsersFile("users.otm");
        List<User> usersExample = new ArrayList<>();

        usersExample.add(new User("987","Julia","Gomez","soe@hto","987"));
        usersExample.add(new User("654","Maria","Sebastian","ms@hot","petunia"));
        usersExample.add(new User("321","Ramon","Cabellestre","rcbll@hot","fornudo"));

        for (User u:
             usersExample) {
            addUser(u);
        }

        frame.setLayout(new FlowLayout());


        components.add(new StartUpPanel());
        components.add(userList);
        userList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUsers();
            }
        });

        for (Component c:
             components) {
            frame.add(c);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }


    private static void listUsers() {
        JDialog userList = new JDialog();
        userList.setLayout(new FlowLayout());
        for (Map.Entry<String,User> u:
             users.entrySet()) {
            userList.getContentPane().add(new UserPanel(u.getValue()));
        }
        userList.pack();

        userList.setVisible(true);
    }

    public static void UserSignUp(String identifier){
        JDialog newUser = new JDialog(frame);
        newUser.getContentPane().add(new SignUpPanel(newUser));
        newUser.pack();
        newUser.setModal(true);
        newUser.setVisible(true);
    }

    public static void UserAccess (String identifier){
        String salida="";
        for (Map.Entry<String,User> entry : users.entrySet()
             ) {
            if (entry.getKey().equals(identifier)) {
                salida = "User found. Loggin In...";
                JOptionPane.showMessageDialog(null,salida,"Log In",JOptionPane.INFORMATION_MESSAGE);
                launchApplication(entry.getValue());
                break;
            }
        }
        if (salida==""){
            salida="User not fuound. Try again";
            JOptionPane.showMessageDialog(frame,salida,"Log In",JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void launchApplication(User u) {
        for (Component c:
             components) {
            frame.remove(c);
        }
        SwingUtilities.updateComponentTreeUI(frame);
        Container ct = new Container();
        ct.setLayout(new FlowLayout());
        ct.add(new LibraryPanel(u));
        ct.add(new InstructionsPanel(u));
        ct.setVisible(true);
        frame.add(ct);
        frame.pack();

    }

    public static void userRegistration(ArrayList<String> data){
        User newUser = new User(data.get(0),
                data.get(1),
                data.get(2),
                data.get(3),
                data.get(4));
        addUser(newUser);
//        addUserFile("users.otm",newUser);
    }
    private static long manyUser(String s){
        File f = new File(s);
        return f.length()/(30);
    }

    private static void addUser(User newUser) {
        users.put(newUser.getIdentity(),newUser);
    }

    private static void readUsersFile(String s) {

        try {
            List<String> lineas = Files.readAllLines(Paths.get(s));
            for (String st:
                 lineas) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long userNumber = manyUser(s);
        Integer[] chooseNumber = new Integer[(int)userNumber];
        for (int i = 0; i < chooseNumber.length; i++) {
            chooseNumber[i] = i;
            //readFileUser(s,i);
        }
    }
      /*
    private static void readFileUser(String s, int pos){
        try (RandomAccessFile raf = new RandomAccessFile(s,"r")) {
            raf.seek(pos*30);
            String identifier = raf.readUTF();
        } catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
*/
      /*
        private static void addUserFile(String s, User u) {
            String usuario = u.getIdentity()+u.getName()+u.getSurname()+u.getEmail()+u.getPassword()+u.getLibrary();
            try () {
                long lastPosition = raf.length();
                raf.seek(lastPosition);
                raf.writeUTF(u.getIdentity());
                raf.seek(lastPosition+30);
                raf.writeUTF(u.getPassword());
            } catch (FileNotFoundException fnf){
                fnf.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

       */
}
