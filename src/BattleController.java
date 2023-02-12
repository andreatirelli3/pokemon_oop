import java.util.Scanner;

public class BattleController {
    private Pokemon userPokemon;
    private Pokemon computerPokemon;
    private Pokedex pokedex;

    public BattleController(Pokemon userPokemon, Pokemon computerPokemon) {
        this.userPokemon = userPokemon;
        this.computerPokemon = computerPokemon;
        this.pokedex = new Pokedex();
        // this.pokedex = Pokedex.getInstance();
  }

    public void start() {
        Scanner input = new Scanner(System.in);

        while (userPokemon.getCurrentHP() > 0 && computerPokemon.getCurrentHP() > 0) {
            displayStatus();

            System.out.println("Choose a move:");
            Move selectedMove = selectMove();
            userPokemon.useMove(selectedMove, computerPokemon);

            System.out.println();
            System.out.println(userPokemon.getName() + " used " + selectedMove.getName() + "!");

            if (computerPokemon.getCurrentHP() > 0) {
                Move computerMove = computerPokemon.getMoves().get(0);
                computerPokemon.useMove(computerMove, userPokemon);

                System.out.println(computerPokemon.getName() + " used " + computerMove.getName() + "!");
            }

            System.out.println();
        }

        displayResult();
    }

    private void displayStatus() {
        System.out.println("Your Pokemon: " + userPokemon.getName());
        System.out.println("HP: " + userPokemon.getCurrentHP() + "/" + userPokemon.getMaxHP());
        System.out.println("Opponent's Pokemon: " + computerPokemon.getName());
        System.out.println("HP: " + computerPokemon.getCurrentHP() + "/" + computerPokemon.getMaxHP());
        System.out.println();
    }

    private Move selectMove() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < userPokemon.getMoves().size(); i++) {
            Move move = userPokemon.getMoves().get(i);
            System.out.println((i + 1) + ": " + move.getName());
        }

        int moveIndex = input.nextInt() - 1;
        return userPokemon.getMoves().get(moveIndex);
    }

    private void displayResult() {
        if (userPokemon.getCurrentHP() > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose...");
        }
    }

}