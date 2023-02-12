import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleController {
    private List<Pokemon> pokedex;
    private List<Pokemon> userSquad;
    private List<Pokemon> computerSquad;

    Scanner input = new Scanner(System.in);
    

    public BattleController(List<Pokemon> pokedex) {
        this.pokedex = pokedex;
        this.userSquad = createUserSquad();
        this.computerSquad = createComputerSquad();
    }

    private List<Pokemon> createUserSquad() {
        List<Pokemon> userSquad = new ArrayList<>();
        System.out.println("Select 3 pokemon for your squad:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Choose pokemon " + (i + 1) + ":");
            for (int j = 0; j < pokedex.size(); j++) {
                System.out.println((j + 1) + ": " + pokedex.get(j).getName());
            }
            int pokemonIndex = input.nextInt() - 1;
            userSquad.add(pokedex.get(pokemonIndex));
        }
        return userSquad;
    }

    private List<Pokemon> createComputerSquad() {
        List<Pokemon> computerSquad = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int pokemonIndex = random.nextInt(pokedex.size());
            computerSquad.add(pokedex.get(pokemonIndex));
        }
        return computerSquad;
    }

    public void start() {
        // Scanner input = new Scanner(System.in);

        Pokemon userPokemon = userSquad.get(0);
        Pokemon computerPokemon = computerSquad.get(0);
    
        while (userPokemon.getCurrentHP() > 0 && computerPokemon.getCurrentHP() > 0) {
            displayPokemonStatus(userPokemon, false);
            displayPokemonStatus(computerPokemon, true);
            int moveIndex = selectMove(userPokemon);
            useMove(userPokemon, moveIndex, userPokemon, computerPokemon);
            if (computerPokemon.getCurrentHP() > 0) {
                useMove(computerPokemon, 0, userPokemon, computerPokemon);
            }
            System.out.println();
        }

        displayResult(userPokemon);
    }

    private void displayPokemonStatus(Pokemon pokemon, boolean is_cpu) {
        if (is_cpu) {
            System.out.println("Opponent's Pokemon: " + pokemon.getName());
            System.out.println("HP: " + pokemon.getCurrentHP() + "/" + pokemon.getMaxHP());
        } else {
            System.out.println("Your Pokemon: " + pokemon.getName());
            System.out.println("HP: " + pokemon.getCurrentHP() + "/" + pokemon.getMaxHP());
        }
        
        System.out.println();
    }

    private int selectMove(Pokemon userPokemon) {
        System.out.println("Choose a move:");
        for (int i = 0; i < userPokemon.getMoves().size(); i++) {
            Move move = userPokemon.getMoves().get(i);
            System.out.println((i + 1) + ": " + move.getName());
        }
        return input.nextInt() - 1;
    }

    private void useMove(Pokemon pokemon, int moveIndex, Pokemon userPokemon, Pokemon computerPokemon) {
        Move selectedMove = pokemon.getMoves().get(moveIndex);
        pokemon.useMove(selectedMove, (pokemon == userPokemon) ? computerPokemon : userPokemon);
        System.out.println();
        System.out.println(pokemon.getName() + " used " + selectedMove.getName() + "!");
    }

    private void displayResult(Pokemon userPokemon) {
        if (userPokemon.getCurrentHP() > 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose...");
        }
    }

}
