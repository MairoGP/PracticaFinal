import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private final String identity;
    private final String password;
    private final String name;
    private final String surname;
    private final String email;
    private final String entryDate;
    private List<VideoGame> library;

    public User(String identity, String name, String surname, String email, String password) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.entryDate = getEntryDate();
        this.library = createDemoGames();
    }

    private List<VideoGame> createDemoGames() {
        List<VideoGame> demoGames = new ArrayList<>();
        List<Category> demoCategory = new ArrayList<>();
        demoCategory.add(Category.ADVENTURES);
        demoCategory.add(Category.MMO);
        List<Platform> demoPlatform = new ArrayList<>();
        demoPlatform.add(Platform.XBOXONE);

        demoGames.add(new VideoGame("rdr2","01-11-2010",demoPlatform,Developer.BETHESDA,demoCategory));
        demoGames.add(new VideoGame("TESO","01-11-2010",demoPlatform,Developer.BETHESDA,demoCategory));
        demoGames.add(new VideoGame("WOW","01-11-2010",demoPlatform,Developer.BETHESDA,demoCategory));
        return demoGames;
    }

    private String getEntryDate() {
        Date date = new Date();
        DateFormat hourDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String entryDate = hourDateFormat.format(date);
        return entryDate;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public List<VideoGame> getLibrary() {
        return library;
    }

    public void addVideoGame(VideoGame v){
        this.getLibrary().add(v);
    }

    public void deleteVideoGame(VideoGame v){
        this.getLibrary().remove(v);
    }
}