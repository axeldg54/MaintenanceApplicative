package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

enum CategoryEnum {
    POP("Pop", "./src/main/java/trivia/FichiersQuestions/Pop.txt"),
    SCIENCE("Science", "./src/main/java/trivia/FichiersQuestions/Science.txt"),
    SPORTS("Sports", "./src/main/java/trivia/FichiersQuestions/Sports.txt"),
    ROCK("Rock", "./src/main/java/trivia/FichiersQuestions/Rock.txt");

    private final String name;
    private final String filePath;
    private final ArrayList<String> questions = new ArrayList<>();

    CategoryEnum(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
        fetchQuestions();
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    private void fetchQuestions() {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                questions.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public String removeFirstQuestion() {
        if (!questions.isEmpty()) {
            return questions.removeFirst();
        }
        return "No more questions available.";
    }
}