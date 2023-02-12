import java.util.List;

/**
 * Pokemon class
 */
public class Pokemon {
    // Nome del pokemon
    private String name;

    // Tipo del pokemon
    private Type type;

    // Punti vita massimi
    private int maxHP;

    // Punti vita attuali
    private int currentHP;

    // Lista di mosse
    private List<Move> moves;


    /*
     * Costruttore del pokemon
     */
    public Pokemon(String name, Type type, int maxHP, List<Move> moves) {
      this.name = name;
      this.type = type;
      this.maxHP = maxHP;
      this.currentHP = maxHP;
      this.moves = moves;
    }

    /*
     * Getter del nome del pokemon
     */
    public String getName() {
        return name;
    }

    /*
     * Getter del tipo del pokemon
     */
    public Type getType() {
        return type;
    }

    /*
     * Getter dei punti vita massimi del pokemon
     */
    public int getMaxHP() {
        return maxHP;
    }

    /*
     * Getter dei punti vita attuali del pokemon
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /*
     * Getter delle mosse del pokemon
     */
    public List<Move> getMoves() {
        return moves;
    }


    /*
     * Metodo che permette al pokemon di attaccare un altro pokemon
     */
    public void useMove(Move move, Pokemon target) {
      int damage = move.getDamage();
      target.takeDamage(damage);
    }

    /*
     * Metodo che permette al pokemon di subire dei danni
     */
    public void takeDamage(int damage) {
      currentHP -= damage;
    }

    /*
     * Metodo che permette di verificare se il pokemon è esausto
     */
    public boolean isExhausted() {
      return currentHP <= 0;
    }

    /*
     * Metodo che permette di ottenere la mossa selezionata casualmente (per l'IA)
     */
    public Move getSelectedMove() {
        int randomIndex = (int)(Math.random() * moves.size());
        return moves.get(randomIndex);
    }
    
    /*
     * Metodo che permette di stampare le mosse del pokemon
     */
    public void printMoves() {
        System.out.println("Available moves:");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(i + ": " + moves.get(i).getName());
        }
    }
    
    /*
     * Metodo che permette di stampare le informazioni del pokemon
     */
    public void printPokemon() {
      System.out.println("Pokemon name: " + name);
      System.out.println("Pokemon type: " + type);
    }
  }