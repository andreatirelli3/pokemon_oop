public class Attack {
    private int id;
    private String name;
    private int dmg;

    public Attack(int id, String name, int dmg) {
        this.id = id;
        this.name = name;
        this.dmg = dmg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public String toString() {
        return "Attack [dmg=" + dmg + ", id=" + id + ", name=" + name + "]";
    }
}
