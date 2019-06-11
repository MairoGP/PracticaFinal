public enum Developer {
    EA("Electronic Arts"),
    NINTENDO("Nintendo"),
    ACTIVISION("Activision"),
    SONY("Sony Computer Entertaiment"),
    MICROSOFT("Microsoft Game Studios"),
    UBISOFT("Ubisoft"),
    BETHESDA("Bethesda"),
    KONAMI("Konami"),
    CAPCOM("Campcom"),
    ROCKSTAR("RockStar"),
    BLZ("Blizzard");

    private final String name;

    Developer(String s) {
        this.name = s;
    }

    public String getName(){
        return name;
    }
}
