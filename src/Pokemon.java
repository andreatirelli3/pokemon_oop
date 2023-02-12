import java.util.List;

public class Pokemon {
    private String name;
    private Type type;
    private int maxHP;
    private int currentHP;
    private List<Move> moves;
  
    public Pokemon(String name, Type type, int maxHP, List<Move> moves) {
      this.name = name;
      this.type = type;
      this.maxHP = maxHP;
      this.currentHP = maxHP;
      this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public List<Move> getMoves() {
        return moves;
    }

  
    public void useMove(Move move, Pokemon target) {
      int damage = move.getDamage();
      target.takeDamage(damage);
    }
  
    public void takeDamage(int damage) {
      currentHP -= damage;
    }
  
    // getters and setters omitted for brevity
  }