import java.util.List;

public class Type {
    private int id;
    private String name;
    private List<Attack> attacks;
    

    public Type(int id, String name, List<Attack> attacks) {
        this.id = id;
        this.name = name;
        this.attacks = attacks;
    }
}
