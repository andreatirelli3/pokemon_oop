import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleController {
    private List<Pokemon> userSquad;
    private List<Pokemon> computerSquad;
    private Pokedex pokedex;

    public BattleController() {
        this.pokedex = new Pokedex();
        selectUserPokemonSquad();
        selectComputerPokemonSquad();  
        // this.pokedex = Pokedex.getInstance();
    }

    private void selectUserPokemonSquad() {
        userSquad = new ArrayList<Pokemon>();
        
        System.out.println("Please select your 3 Pokemon from the Pokedex:");
        pokedex.printPokedex();
    
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Pokemon name: ");
            String name = scanner.nextLine();
            Pokemon selectedPokemon = pokedex.getPokemonByName(name);
    
            if (selectedPokemon != null) {
                // add the selected pokemon to user's squad
                userSquad.add(selectedPokemon);
            } else {
                System.out.println("Invalid Pokemon name! Try again.");
                i--;
            }
        }
    }
    
    private void selectComputerPokemonSquad() {
        computerSquad = new ArrayList<Pokemon>();

        System.out.println("Computer is selecting its Pokemon squad...");
        Random random = new Random();
    
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(pokedex.getPokemonList().size());
            Pokemon selectedPokemon = pokedex.getPokemonList().get(index);
    
            if (!computerSquad.contains(selectedPokemon)) {
                computerSquad.add(selectedPokemon);
            } else {
                i--;
            }
        }
    }

    public void startBattle() {
        System.out.println("The battle starts now!");
        int userSquadIndex = 0;
        int computerSquadIndex = 0;
        
        while (!userSquadExhausted(userSquadIndex) && !computerSquadExhausted(computerSquadIndex)) {
            Pokemon userPokemon = userSquad.get(userSquadIndex);
            Pokemon computerPokemon = computerSquad.get(computerSquadIndex);
            
            System.out.println("Your turn, select a move for " + userPokemon.getName() + ":");
            userPokemon.printMoves();
            
            Scanner scanner = new Scanner(System.in);
            int moveIndex = scanner.nextInt();
            Move selectedMove = userPokemon.getMoves().get(moveIndex);
            
            computerPokemon.takeDamage(selectedMove.getDamage());
            System.out.println(computerPokemon.getName() + " took " + selectedMove.getDamage() + " damage.");
            
            if (computerPokemon.isExhausted()) {
                System.out.println(computerPokemon.getName() + " has fainted.");
                computerSquadIndex++;
            } else {
                userPokemon.takeDamage(computerPokemon.getSelectedMove().getDamage());
                System.out.println(userPokemon.getName() + " took " + computerPokemon.getSelectedMove().getDamage() + " damage.");
                
                if (userPokemon.isExhausted()) {
                    System.out.println(userPokemon.getName() + " has fainted.");
                    userSquadIndex++;
                }
            }
        }
        
        if (userSquadExhausted(userSquadIndex)) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You win!");
        }
    }
    
    private boolean userSquadExhausted(int userSquadIndex) {
        return userSquad.size() == userSquadIndex;
    }
    
    private boolean computerSquadExhausted(int computerSquadIndex) {
        return computerSquad.size() == computerSquadIndex;
    }

}