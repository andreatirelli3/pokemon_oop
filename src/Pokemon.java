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

    public boolean isExhausted() {
      return currentHP <= 0;
    }
    
    public Move getSelectedMove() {
        // You can select a move randomly or based on some other logic
        int randomIndex = (int)(Math.random() * moves.size());
        return moves.get(randomIndex);
    }
    
    public void printMoves() {
        System.out.println("Available moves:");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(i + ": " + moves.get(i).getName());
        }
    }
  
    public void printPokemon() {
      System.out.println("Pokemon name: " + name);
      System.out.println("Pokemon type: " + type);
    }
  }