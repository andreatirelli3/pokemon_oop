import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        List<Move> userMoves = new ArrayList<>();
        userMoves.add(new Move("Ember", Type.FIRE, 10));
        userMoves.add(new Move("Quick Attack", Type.NORMAL, 5));
        Pokemon userPokemon = new Pokemon("Charmander", Type.FIRE, 100, userMoves);

        List<Move> computerMoves = new ArrayList<>();
        computerMoves.add(new Move("Bubble", Type.WATER, 10));
        computerMoves.add(new Move("Thunder Shock", Type.ELECTRIC, 15));
        Pokemon computerPokemon = new Pokemon("Squirtle", Type.WATER, 100, computerMoves);

        BattleController battleController = new BattleController(userPokemon, computerPokemon);
        battleController.start();
      }

}