package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame {
    ArrayList<Player> players = new ArrayList<>();

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    Player currentPlayer;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public boolean isPlayable() {
        return (players.size() >= 2);
    }

    public boolean add(String playerName) {
        boolean playerAdded = players.add(new Player(playerName));

        if (playerAdded) {
            System.out.println(playerName + " was added");
            System.out.println("They are player number " + players.size());
            currentPlayer = players.get(0);
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
                currentPlayer.setPosition((currentPlayer.getPosition() + roll) % 12);

                System.out.println(currentPlayer
                        + "'s new location is "
                        + currentPlayer.getPosition());
                System.out.println("The category is " + currentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
                currentPlayer.setInPenaltyBox(true);
            }
        } else {
            currentPlayer.setPosition((currentPlayer.getPosition() + roll) % 12);

            System.out.println(currentPlayer
                    + "'s new location is "
                    + currentPlayer.getPosition());
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }

    }

    private static boolean canEscapeFromJail(int roll) {
        return roll % 2 != 0;
    }

    private void askQuestion() {
        if (currentCategory().equals("Pop"))
            System.out.println(popQuestions.removeFirst());
        if (currentCategory().equals("Science"))
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory().equals("Sports"))
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory().equals("Rock"))
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (currentPlayer.getPosition() == 0) return "Pop";
        if (currentPlayer.getPosition() == 4) return "Pop";
        if (currentPlayer.getPosition() == 8) return "Pop";
        if (currentPlayer.getPosition() == 1) return "Science";
        if (currentPlayer.getPosition() == 5) return "Science";
        if (currentPlayer.getPosition() == 9) return "Science";
        if (currentPlayer.getPosition() == 2) return "Sports";
        if (currentPlayer.getPosition() == 6) return "Sports";
        if (currentPlayer.getPosition() == 10) return "Sports";
        return "Rock";
    }

    public boolean handleCorrectAnswer() {
        System.out.println("Correct Answer !");
        currentPlayer.addPurse();
        System.out.println(currentPlayer.getName()
                + " now has "
                + currentPlayer.getPurses()
                + " Gold Coins.");

        boolean win = didPlayerWin();
        selectNextPlayer();
        return win;
    }

    public boolean wrongAnswer() {
        System.out.println("Incorrect Answer");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);
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
}
