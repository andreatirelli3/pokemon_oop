public class Move {
  private String name;
  private Type type;
  private int damage;

  public Move(String name, Type type, int damage) {
    this.name = name;
    this.type = type;
    this.damage = damage;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public int getDamage() {
    return damage;
  }

}