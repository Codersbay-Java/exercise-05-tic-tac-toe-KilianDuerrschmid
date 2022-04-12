package application;

public class Player {
    String name;
    char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}
