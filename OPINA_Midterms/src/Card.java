public class Card {
    private int ID;
    private String name;

    public Card(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + ID + ", " + name + ")";
    }
}

