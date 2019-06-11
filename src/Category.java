public enum Category {
  ACTION("Actión"),
  ADVENTURES("Adventures"),
  ARCADE("Arcade"),
  SPORTIVE("Sportive"),
  STRATEGY("Strategy"),
  SIMULATION("Simulation"),
  FIGHTING("Fighting"),
  PLATFORMS("Platforms"),
  DRIVING("Driving"),
  TERROR("Terror"),
  RPG("Role Play Game"),
  ACTIONRPG("Action RPG"),
  MOBA("Multiplayer Online Battle Arena"),
  SINGLEPLAYER("Un solo jugador"),
  MULTIPLAYER("Varios jugadores"),
  HACKNSLASH("Hack and Slash"),
  MMO("Masive Multiplayer Online"),
  MMORPG("Massive Multiplayer Online Role Play Game"),
  COOPERATIVO("Cooperativo"),
  INDIE("Indie"),
  OPENWORLD("Mundo abierto");
  
  private final String name;
      
  Category(String s){
    this.name = s;
  }

  public String toString(){
  return name;
  }
}
