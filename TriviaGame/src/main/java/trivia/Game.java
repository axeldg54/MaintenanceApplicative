package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class Game implements IGame {
    
//    enum Categories {
//
//        POP("Pop"),
//        SCIENCE("Science"),
//        SPORTS("Sports"),
//        ROCK("Rock");
//
//        private final String nomCategorie;
//
//        Categories(final String string) {
//            nomCategorie = string;
//        }
//
//        public String toString() {
//            return nomCategorie;
//        }
//    }
    
    private final String POP = "Pop";
    private final String ROCK = "Rock";
    private final String SCIENCE = "Science";
    private final String SPORTS = "Sports";
    String[] nomCategories = new String[] {POP, ROCK, SCIENCE, SPORTS};
    
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Categorie> categories = new ArrayList<>();
    

    Player currentPlayer;

    public Game() {
        for (String category : nomCategories) {
            this.categories.add(new Categorie(category, "./src/main/java/trivia/FichiersQuestions/" + category + ".txt"));
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
            if (roll % 2 != 0) {
                currentPlayer.setInPenaltyBox(false);
                System.out.println(currentPlayer + " is getting out of the penalty box");
                forwardPlayer(roll);
                System.out.println(currentPlayer
                        + "'s new location is "
                        + currentPlayer.getPosition());
                System.out.println("The category is " + currentCategory());
                askQuestion();
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
            }
        } else {
            forwardPlayer(roll);
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
        Categorie categorie = getCategorie(currentCategory());
	    if (categorie != null) {
		    System.out.println(categorie.removeFirstQuestion());
	    } else {
            System.out.println("error, question : " + currentCategory() + " not found");
        }
    }
    
    public Categorie getCategorie(String nomCategorie) {
        for (Categorie categorieCourante : categories) {
            if(categorieCourante.getNomCategorie().equals(nomCategorie))
                return categorieCourante;
        }
        return null;
    }


    private String currentCategory() {
        if (currentPlayer.getPosition() == 1) return "Pop";
        if (currentPlayer.getPosition() == 5) return "Pop";
        if (currentPlayer.getPosition() == 9) return "Pop";
        if (currentPlayer.getPosition() == 2) return "Science";
        if (currentPlayer.getPosition() == 6) return "Science";
        if (currentPlayer.getPosition() == 10) return "Science";
        if (currentPlayer.getPosition() == 3) return "Sports";
        if (currentPlayer.getPosition() == 7) return "Sports";
        if (currentPlayer.getPosition() == 11) return "Sports";
        return "Rock";
    }

    public boolean handleCorrectAnswer() {
        if (!currentPlayer.isInPenaltyBox()) {
            System.out.println("Answer was correct!!!!");
            currentPlayer.addPurse();
            System.out.println(currentPlayer.getName()
                    + " now has "
                    + currentPlayer.getPurses()
                    + " Gold Coins.");
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
