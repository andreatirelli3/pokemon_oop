import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * BattleController class
 * Classe che gestisce la battaglia tra due squadre di pokemon
 *  - Utente
 *  - Computer (IA)
 */
public class BattleController {
    // Squadra dell'utente
    private List<Pokemon> userSquad;

    // Squadra del computer
    private List<Pokemon> computerSquad;

    // Pokedex
    private Pokedex pokedex;

    /*
     * Costruttore di default della classe
     */
    public BattleController() {
        // Inizializza il pokedex
        this.pokedex = new Pokedex();

        // Inizializza le squadre
        selectUserPokemonSquad();

        // Inizializza la squadra del computer
        selectComputerPokemonSquad();  
    }

    /*
     * Metodo che permette all'utenete di selezionare la squadra di pokemon dal pokédex
     */
    private void selectUserPokemonSquad() {
        // Inizializza la struttura della squadra dell'utente
        userSquad = new ArrayList<Pokemon>();
        
        System.out.println("Please select your 3 Pokemon from the Pokedex:");

        // Stampa i pokemon nel pokedex
        pokedex.printPokedex();
    
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Pokemon name: ");
            String name = scanner.nextLine();

            // Ottiene il pokemon dal pokedex
            Pokemon selectedPokemon = pokedex.getPokemonByName(name);

            // Verifica che il pokemon sia presente nel pokedex
            if (selectedPokemon != null) {
                // Aggiungi il pokemon alla squadra dell'utente
                userSquad.add(selectedPokemon);
            } else {
                // Se il pokemon non è presente nel pokedex, stampa un messaggio di errore e decrementa il contatore
                System.out.println("Invalid Pokemon name! Try again.");
                i--;
            }
        }
    }
    
    /*
     * Metodo che permette di selezionare casualmente la squadra del computer (IA)
     */
    private void selectComputerPokemonSquad() {
        // Inizializza la struttura della squadra del computer
        computerSquad = new ArrayList<Pokemon>();

        System.out.println("Computer is selecting its Pokemon squad...");
        Random random = new Random();
        
        // Seleziona casualmente 3 pokemon dal pokedex
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(pokedex.getPokemonList().size());
            Pokemon selectedPokemon = pokedex.getPokemonList().get(index);
            
            // Verifica che il pokemon non sia già presente nella squadra del computer
            if (!computerSquad.contains(selectedPokemon)) {
                computerSquad.add(selectedPokemon);
            } else {
                // Se il pokemon è già presente nella squadra del computer, decrementa il contatore
                i--;
            }
        }
    }


    /*
     * Metodo di inizio della battaglia
     */
    public void startBattle() {
        System.out.println("The battle starts now!");
        // Indice del pokemon corrente della squadra dell'utente
        int userSquadIndex = 0;

        // Indice del pokemon corrente della squadra del computer
        int computerSquadIndex = 0;
        
        // Verifica che nessuna delle due squadre sia esaurita
        while (!userSquadExhausted(userSquadIndex) && !computerSquadExhausted(computerSquadIndex)) {
            // Ottiene il pokemon corrente della squadra dell'utente
            Pokemon userPokemon = userSquad.get(userSquadIndex);
            // Ottiene il pokemon corrente della squadra del computer
            Pokemon computerPokemon = computerSquad.get(computerSquadIndex);
            
            System.out.println("Your turn, select a move for " + userPokemon.getName() + ":");
            // Stampa i mosse del pokemon corrente per l'utenete
            userPokemon.printMoves();
            
            Scanner scanner = new Scanner(System.in);
            // Ottiene l'indice della mossa selezionata dall'utente
            int moveIndex = scanner.nextInt();
            // Ottiene la mossa selezionata dall'utente
            Move selectedMove = userPokemon.getMoves().get(moveIndex);
            
            // Applica la mossa selezionata al pokemon corrente della squadra del computer
            computerPokemon.takeDamage(selectedMove.getDamage());
            System.out.println(computerPokemon.getName() + " took " + selectedMove.getDamage() + " damage.");
            
            // Verifica che il pokemon corrente della squadra del computer non sia esausto
            if (computerPokemon.isExhausted()) {
                System.out.println(computerPokemon.getName() + " has fainted.");
                // Passa al prossimo pokemon della squadra del computer
                computerSquadIndex++;
            } else {
                // Se il pokemon corrente della squadra del computer non è esausto, il computer sceglie una mossa casuale
                userPokemon.takeDamage(computerPokemon.getSelectedMove().getDamage());
                System.out.println(userPokemon.getName() + " took " + computerPokemon.getSelectedMove().getDamage() + " damage.");
                
                // Verifica che il pokemon corrente della squadra dell'utente non sia esausto
                if (userPokemon.isExhausted()) {
                    System.out.println(userPokemon.getName() + " has fainted.");
                    // Passa al prossimo pokemon della squadra dell'utente
                    userSquadIndex++;
                }
            }
        }
        
        // Verifica che la squadra del user sia esaurita
        if (userSquadExhausted(userSquadIndex)) {
            System.out.println("Computer wins!");
        } else {
            // Se la squadra del computer è esaurita, l'utente ha vinto
            System.out.println("You win!");
        }
    }
    
    /*
     * Metodo che verifica se la squadra dell'utente è esaurita
     */
    private boolean userSquadExhausted(int userSquadIndex) {
        return userSquad.size() == userSquadIndex;
    }
    
    /*
     * Metodo che verifica se la squadra del computer è esaurita
     */
    private boolean computerSquadExhausted(int computerSquadIndex) {
        return computerSquad.size() == computerSquadIndex;
    }

}