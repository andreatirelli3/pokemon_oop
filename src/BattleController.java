import java.util.Scanner;

public class BattleController {
    private Pokemon userPokemon;
    private Pokemon computerPokemon;
    

    public BattleController(Pokemon userPokemon, Pokemon computerPokemon) {
        this.userPokemon = userPokemon;
        this.computerPokemon = computerPokemon;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
    
        while (userPokemon.getCurrentHP() > 0 && computerPokemon.getCurrentHP() > 0) {
            displayPokemonStatus();
            int moveIndex = selectMove(input);
            useMove(userPokemon, moveIndex);
            if (computerPokemon.getCurrentHP() > 0) {
                useMove(computerPokemon, 0);
            }
            System.out.println();
        }

        displayResult();
    }

    private void displayPokemonStatus() {
        System.out.println("Your Pokemon: " + userPokemon.getName());
        System.out.println("HP: " + userPokemon.getCurrentHP() + "/" + userPokemon.getMaxHP());
        System.out.println("Opponent's Pokemon: " + computerPokemon.getName());
        System.out.println("HP: " + computerPokemon.getCurrentHP() + "/" + computerPokemon.getMaxHP());
        System.out.println();
    }

    private int selectMove(Scanner input) {
        System.out.println("Choose a move:");
        for (int i = 0; i < userPokemon.getMoves().size(); i++) {
            Move move = userPokemon.getMoves().get(i);
            System.out.println((i + 1) + ": " + move.getName());
        }
        return input.nextInt() - 1;
    }

    private void useMove(Pokemon pokemon, int moveIndex) {
        Move selectedMove = pokemon.getMoves().get(moveIndex);
        pokemon.useMove(selectedMove, (pokemon == userPokemon) ? computerPokemon : userPokemon);
        System.out.println();
        System.out.println(pokemon.getName() + " used " + selectedMove.getName() + "!");
    }

    private void displayResult() {
        if (userPokemon.getCurrentHP() > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose...");
        }
    }

}
