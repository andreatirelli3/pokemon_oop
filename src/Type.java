import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public enum Type {
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    NORMAL;
  
    private static final Map<Type, List<Type>> weaknesses = new HashMap<>();
  
    static {
      weaknesses.put(FIRE, Arrays.asList(WATER, GRASS));
      weaknesses.put(WATER, Arrays.asList(GRASS, ELECTRIC));
      weaknesses.put(GRASS, Arrays.asList(FIRE, ELECTRIC));
      weaknesses.put(ELECTRIC, Arrays.asList(WATER, GRASS));
      weaknesses.put(NORMAL, Collections.emptyList());
    }
  
    public List<Type> getWeaknesses() {
      return weaknesses.get(this);
    }
  }