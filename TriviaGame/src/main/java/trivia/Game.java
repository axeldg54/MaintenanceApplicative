package trivia;

import java.util.ArrayList;

public class Game implements IGame {

    private final CategoryEnum[] categoriesEnum = CategoryEnum.values();
    private ArrayList<Player> players = new ArrayList<>();
    Player currentPlayer;

    public boolean isPlayable() {
        return (players.size() >= 2);
    }

    public boolean add(String playerName) {
        boolean playerAdded = players.add(new Player(playerName));

        if (playerAdded) {
            System.out.println(playerName + " was added");
            System.out.println("They are player number " + players.size());
            currentPlayer = players.getFirst();
            return true;
        } else {
            System.out.println("Player was not added");
            return false;
        }
    }

    public void roll(int roll) {
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            if (canEscapeFromJail(roll)) {
                currentPlayer.setInPenaltyBox(false);
                System.out.println(currentPlayer + " is getting out of the penalty box");
                forwardPlayer(roll);
                System.out.println(currentPlayer + "'s new location is " + currentPlayer.getPosition());
                System.out.println("The category is " + currentCategory().getName());
                askQuestion();
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
            }
        } else {
            forwardPlayer(roll);
            System.out.println(currentPlayer + "'s new location is " + currentPlayer.getPosition());
            System.out.println("The category is " + currentCategory().getName());
            askQuestion();
        }
    }

    private static boolean canEscapeFromJail(int roll) {
        return roll % 2 != 0;
    }

    private void askQuestion() {
        System.out.println(currentCategory().removeFirstQuestion());
    }

    private CategoryEnum currentCategory() {
        return categoriesEnum[(currentPlayer.getPosition() - 1) % categoriesEnum.length];
    }

    public boolean handleCorrectAnswer() {
        if (!currentPlayer.isInPenaltyBox()) {
            System.out.println("Answer was correct!!!!");
            currentPlayer.addPurse();
            System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurses() + " Gold Coins.");
        }
        boolean win = didPlayerWin();
        selectNextPlayer();
        return !win;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        currentPlayer.setInPenaltyBox(true);
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        selectNextPlayer();
        return true;
    }

    private boolean didPlayerWin() {
        return currentPlayer.getPurses() >= 6;
    }

    public void setRandomCurrentPlayer() {
        currentPlayer = players.get((int) (Math.random() * players.size()));
    }

    public void selectNextPlayer() {
        currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }

    private void forwardPlayer(int roll) {
        currentPlayer.setPosition(currentPlayer.getPosition() + roll);
        if (currentPlayer.getPosition() > 12) currentPlayer.setPosition(currentPlayer.getPosition() - 12);
    }
}
