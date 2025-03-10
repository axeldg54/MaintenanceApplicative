package trivia.Categories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private final String nomCategorie;
	private final ArrayList<String> questions;
	public ArrayList<Integer> positions;

	public Categorie(String nomCaregorie, String fichierQuestions, ArrayList<Integer> positions) {
		this.nomCategorie = nomCaregorie;
		this.questions = new ArrayList<>();
		this.positions = positions;
		fetchQuestions(fichierQuestions);
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public String getNomCategorie() {
		return nomCategorie;
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
		return questions.removeFirst();
	}

	public List<Integer> getPositions() {
		return positions;
	}

}
