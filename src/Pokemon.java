public class Pokemon {
    private int id;
    private String name;
    private Type type;
    private int hp;
    private boolean isParalyzed;

    public Pokemon(int id, String name, Type type, int hp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.isParalyzed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public boolean isParalyzed() {
        return isParalyzed;
    }

    public void setParalyzed(boolean isParalyzed) {
        this.isParalyzed = isParalyzed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Pokemon [hp=" + hp + ", id=" + id + ", isParalyzed=" + isParalyzed + ", name=" + name + ", type=" + type
                + "]";
    }
}
