/*
 * This class represents a move that a Pokemon can use in battle.
 */
public class Move {
  // Nome della mossa
  private String name;

  // Tipo della mossa
  private Type type;

  // Danni della mossa
  private int damage;

  /*
   * Costruttore della mossa
   */
  public Move(String name, Type type, int damage) {
    this.name = name;
    this.type = type;
    this.damage = damage;
  }

  /*
   * Getter del nome della mossa
   */
  public String getName() {
    return name;
  }

  /*
   * Getter del tipo della mossa
   */
  public Type getType() {
    return type;
  }

  /*
   * Getter dei danni della mossa
   */
  public int getDamage() {
    return damage;
  }

}