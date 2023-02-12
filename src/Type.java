import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Enumerazione dei tipi di pokemon
 */
public enum Type {
    // Tipi di pokemon
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    NORMAL;

    // Mappa dei tipi di pokemon e delle loro debolezze
    private static final Map<Type, List<Type>> weaknesses = new HashMap<>();

    // Inizializzazione della mappa
    static {
      weaknesses.put(FIRE, Arrays.asList(WATER, GRASS));
      weaknesses.put(WATER, Arrays.asList(GRASS, ELECTRIC));
      weaknesses.put(GRASS, Arrays.asList(FIRE, ELECTRIC));
      weaknesses.put(ELECTRIC, Arrays.asList(WATER, GRASS));
      weaknesses.put(NORMAL, Collections.emptyList());
    }
    
    // Restituisce la lista delle debolezze del tipo di pokemon
    public List<Type> getWeaknesses() {
      return weaknesses.get(this);
    }
  }