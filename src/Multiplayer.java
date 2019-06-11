import java.util.ArrayList;

public class Multiplayer extends VideoGame {
    protected boolean multiplayer;

    public Multiplayer(String titulo, String fechaLanzamiento, ArrayList<Platform> plataformas, Developer desarrolladora, ArrayList<Category> categorias) {
        super(titulo, fechaLanzamiento, plataformas, desarrolladora, categorias);
        this.multiplayer=true;
    }
}
