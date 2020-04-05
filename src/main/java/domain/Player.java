package domain;

public class Player {
    final private String name;
    private Move move;

    public Player(String name) {
        this.name = name;
    }

    public void pick(Move move) {
        this.move = move;
    }

    public Result battle(Player other, Rules rules) {
        return rules.decide(this.move, other.move);
    }
    
    public String getName() {
        return name;
    }
}
