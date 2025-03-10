package trivia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Categorie {
	
	private String nomCategorie;
	private ArrayList<String> questions;
	
	public Categorie(String nomCaregorie, String fichierQuestions) {
		this.nomCategorie = nomCaregorie;
		this.questions = new ArrayList<String>();
		recupererQuestions(fichierQuestions);
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public String getNomCategorie() {
		return nomCategorie;
	}
	
	private void recupererQuestions(String cheminFichier){
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
