public enum Platform {
    PS4("PlayStation 4"),
    XBOXONE("Xbox One"),
    XBOX360("Xbox 360"),
    PC("PC"),
    SWITCH("Nintendo Switch"),
    WIIU("Wii U"),
    PS3("PlayStation 3"),
    DS("Nintendo DS");

    private final String name;

    Platform(String s) {
        this.name = s;
    }

    public String getName(){
        return name;
    }

}
