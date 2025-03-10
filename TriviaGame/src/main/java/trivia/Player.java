package trivia;

public class Player {
    private String name;
    private int purses;
    private boolean inPenaltyBox;
    private int position;
    private boolean isGettingOutOfPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.purses = 0;
        this.inPenaltyBox = false;
        this.position = 0;
    }

    public void addPurse() {
        purses += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", purses=" + purses +
                ", inPenaltyBox=" + inPenaltyBox +
                '}';
    }
}
