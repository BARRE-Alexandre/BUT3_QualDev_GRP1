package modele;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import interfaces.IRobot;
import service.RobotStrategy;

/***
 * Attention n'est pas SOLID (SRP).
 * A créer une classe manager.
 * @author stephane.joyeux
 *
 */
public class Tondeuse implements IRobot {

	// Une tondeuse se déplace sur une pelouse.
	private Grille pelouse;

	// Départ de la tondeuse :
	private Case caseDepart;

	// Arrivée :
	private Case caseFinale;

	// Sens de la tondeuse :
	private EDirection sens;

	private final RobotStrategy strategy;

	public Case getCaseFinale() {
		return caseFinale;
	}

	public Case getCaseDepart() {
		return caseDepart;
	}

	public EDirection getSens() {
		return sens;
	}

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.pelouse = new Grille(lignes, colonnes);
		this.caseDepart = this.pelouse.getCase(posX, posY);
		this.caseFinale = this.pelouse.getCase(posX, posY);
		if (sens == null) {
			throw new IllegalArgumentException("La direction initiale ne peut pas être nulle.");
		}
		this.sens = sens;
		this.strategy = new RobotStrategy(this);
	}

	@Override
	public void deplacement(EDeplacement deplacement) throws DeplacementException {
		if (deplacement == null) {
			throw new IllegalArgumentException("Le déplacement ne peut pas être nul.");
		}
		switch (deplacement) {
		case A:
			strategy.deplacerEnAvant();
			break;
		case D:
			strategy.deplacerADroite();
			break;
		case G:
			strategy.deplacerAGauche();
			break;
		default:
			throw new IllegalArgumentException("Déplacement non pris en charge : " + deplacement);
		}
	}

	@Override
	public void setSens(EDirection sens) {
		if (sens == null) {
			throw new IllegalArgumentException("La direction ne peut pas être nulle.");
		}
		this.sens = sens;
	}

	@Override
	public void setCaseFinale(Case caseFinale) {
		if (caseFinale == null) {
			throw new IllegalArgumentException("La position finale ne peut pas être nulle.");
		}
		this.caseFinale = caseFinale;
	}

	@Override
	public Grille getPelouse() {
		return pelouse;
	}

	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().getX() + ", Y = " + this.getCaseFinale().getY()
				+ " et je suis orientée : " + this.sens;
	}
}
