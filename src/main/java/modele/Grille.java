package modele;

import java.util.ArrayList;
import java.util.List;

public class Grille {

	// Une grille contient un ensemble de cases.
	private List<Case> cases;
	private int lignes;
	private int colonnes;
	
	public int getTaille() {
		return cases.size();
	}

	/*
	 * @return : La case de coordonnées x et y.
	 */
	public Case getCase(int x, int y) {
		if (x < 0 || x > lignes || y < 0 || y > colonnes) {
			throw new IndexOutOfBoundsException("Coordonnées hors de la grille : (" + x + ", " + y + ")");
		}
		return cases.get(x * (colonnes + 1) + y);
	}

	public Grille(int lignes, int colonnes) {
		initGrille(lignes, colonnes);
	}

	/*
	 * Initialisation de la grille ...
	 */
	private void initGrille(int lignes, int colonnes) {
		if (lignes < 0 || colonnes < 0) {
			throw new IllegalArgumentException("Les dimensions de la grille doivent être positives ou nulles.");
		}
		this.lignes = lignes;
		this.colonnes = colonnes;
		cases = new ArrayList<>();
		for (int x = 0; x <= lignes; x++) {
			for (int y = 0; y <= colonnes; y++) {
				Case element = new Case(x, y);
				cases.add(element);
			}
		}
	}
}
