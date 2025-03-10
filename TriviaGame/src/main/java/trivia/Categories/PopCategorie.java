package trivia.Categories;

import java.util.ArrayList;

public class PopCategorie extends Categorie {
    public PopCategorie(String nomCaregorie, String fichierQuestions, ArrayList<Integer> positions) {
        super(nomCaregorie, fichierQuestions, positions);

        super.positions = new ArrayList<>();
        positions.add(1);
        positions.add(5);
        positions.add(9);
    }
}
