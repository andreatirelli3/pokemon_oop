import java.util.Arrays;
import java.util.List;

/*
 * Classe che rappresenta il pokedex
 */
public class Pokedex {
    // Singleton instance, rende la classe un singleton, ovvero una classe che può avere solo un'istanza in memoria
    private static Pokedex instance = null;

    // Lista dei pokemon
    private List<Pokemon> pokemonList;

    /*
     * Costruttore di default della classe
     */
    public Pokedex() {
        this.pokemonList = loadPokedex();
    }

    /*
     * Metodo che carica il pokedex
     */
    private List<Pokemon> loadPokedex() {
        Pokemon pikachu = new Pokemon("Pikachu", Type.ELECTRIC, 35, 
            Arrays.asList(new Move("Thunder Shock", Type.ELECTRIC, 40), 
                        new Move("Quick Attack", Type.NORMAL, 30)));

        Pokemon charmander = new Pokemon("Charmander", Type.FIRE, 39, 
            Arrays.asList(new Move("Ember", Type.FIRE, 40), 
                        new Move("Scratch", Type.NORMAL, 40)));

        Pokemon bulbasaur = new Pokemon("Bulbasaur", Type.GRASS, 45, 
            Arrays.asList(new Move("Vine Whip", Type.GRASS, 45), 
                        new Move("Tackle", Type.NORMAL, 50)));
                        
        Pokemon squirtle = new Pokemon("Squirtle", Type.WATER, 44, 
            Arrays.asList(new Move("Bubble", Type.WATER, 40), 
                        new Move("Tackle", Type.NORMAL, 50)));

        Pokemon raichu = new Pokemon("Raichu", Type.ELECTRIC, 60, 
            Arrays.asList(new Move("Thunderbolt", Type.ELECTRIC, 90), 
                        new Move("Quick Attack", Type.NORMAL, 30)));

        Pokemon charmeleon = new Pokemon("Charmeleon", Type.FIRE, 58, 
            Arrays.asList(new Move("Flame Burst", Type.FIRE, 70), 
                        new Move("Scratch", Type.NORMAL, 40)));

        Pokemon ivysaur = new Pokemon("Ivysaur", Type.GRASS, 60, 
            Arrays.asList(new Move("Solar Beam", Type.GRASS, 120), 
                        new Move("Tackle", Type.NORMAL, 50)));

        Pokemon wartortle = new Pokemon("Wartortle", Type.WATER, 59, 
            Arrays.asList(new Move("Hydro Pump", Type.WATER, 110), 
                        new Move("Tackle", Type.NORMAL, 50)));

        Pokemon sandshrew = new Pokemon("Sandshrew", Type.NORMAL, 50, 
            Arrays.asList(new Move("Dig", Type.NORMAL, 80), 
                        new Move("Scratch", Type.NORMAL, 40)));

        return Arrays.asList(pikachu, charmander, bulbasaur, squirtle, raichu, charmeleon, ivysaur, wartortle, sandshrew);      
    }

    /*
     * Restituisce la lista dei pokemon
     */
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    /*
     * Restituisce l'istanza del pokedex
     */
    public static Pokedex getInstance() {
        if (instance == null) {
            instance = new Pokedex();
        }
        return instance;
    }

    /*
     * Restituisce il pokemon con il nome specificato
     */
    public Pokemon getPokemonByName(String name) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }

    /*
     * Stampa il pokedex
     */
    public void printPokedex() {
        for (Pokemon pokemon : pokemonList) {
            pokemon.printPokemon();
        }
    }
}
