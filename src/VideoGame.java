import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VideoGame {
    private final String title;
    private Developer developer;
    private final String launchDate;
    private List<Platform> platform;
    private List<Category> category;

    public VideoGame(String title, String launchDate, List<Platform> platforms, Developer developer, List<Category> categories) {
        this.title = title;
        this.developer = developer;
        this.launchDate = launchDate;
        this.platform = platforms;
        this.category = categories;
    }

    public String getTitle() {
        return title;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public String getPlatform() {
        String salida = "";
        for (Platform p:
             this.platform) {
            salida+=p.getName()+" ";
        }
        return salida;
    }

    public String getCategory(){
        String salida = "";
        for (Category c:
             this.category) {
            salida+=c.toString()+" ";
        }
        return salida;
    }

    public void setDeveloper(){
        this.developer = askDeveloper();
    }

    public void setPlatform(){
        this.platform = askPlatforms();
    }

    public void setCategory(){
        this.category = askCategories();
    }

    public static ArrayList<Platform> askPlatforms() {
        ArrayList<Platform> platforms = new ArrayList<>();
        Platform answer;
        String title="Platforms";
        String message="Introduce a platform (Cancel to Stop)";
        do{
            answer = (Platform) JOptionPane.showInputDialog(null,
                    message,
                    title,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    null,
                    Platform.values(),
                    Platform.values()[0]);
            if(answer==null){
                break;
            } else {
                platforms.add(answer);
            }
        }while(answer!=null);
        return platforms;
    }

    public static Developer askDeveloper(){
        Developer answer;
        String title="Developer";
        String message="Introduce a Developer(Cancel to Stop)";
        do {
            answer = (Developer) JOptionPane.showInputDialog(null,
                    message,
                    title,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    null,
                    Developer.values(),
                    Developer.values()[0]);
        }while(answer!=null);
        return answer;
    }

    public static ArrayList<Category> askCategories(){
    ArrayList<Category> categories = new ArrayList<Category>();
    Category answer= null;
    String title="Categorias";
    String message="Introduce a category(Cancel to Stop)";
    do{
        answer = (Category) JOptionPane.showInputDialog(null,
                                message,
                                title,
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                null,
                                Category.values(),
                                Category.values()[0]
                                );
        if(answer==null){
            break;
        } else {
        categories.add(answer);
        }
    }while(answer!=null);
    return categories;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", developer=" + developer +
                ", launchDate='" + launchDate + '\'' +
                ", platform=" + platform +
                ", category=" + category +
                '}';
    }

    public static VideoGame createNewGame(){
        String title = JOptionPane.showInputDialog(null,"Enter the title of the game","SetTitle",JOptionPane.OK_CANCEL_OPTION);
        Developer develp = askDeveloper();
        String launchDate = JOptionPane.showInputDialog(null,"Enter the Launch Date","SetLaunchDate",JOptionPane.OK_CANCEL_OPTION);
        List<Platform> platf = askPlatforms();
        List<Category> categ = askCategories();

        return new VideoGame(title,launchDate,platf,develp,categ);
    }
}
