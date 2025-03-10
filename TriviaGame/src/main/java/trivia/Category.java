package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Category {
	
	private final String name;
	private final ArrayList<String> questions;

	public Category(String nomCaregorie, String fichierQuestions) {
		this.name = nomCaregorie;
		this.questions = new ArrayList<>();
		fetchQuestions(fichierQuestions);
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public String getName() {
		return name;
	}
	
	private void fetchQuestions(String cheminFichier){
		try (FileReader fileReader = new FileReader(cheminFichier);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				this.addQuestion(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	private void addQuestion(String question) {
		questions.add(question);
	}
	
	public String removeFirstQuestion() {
		if(!questions.isEmpty()){
			return questions.removeFirst();
		}
		return null;
	}
}
