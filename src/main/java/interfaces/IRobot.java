package interfaces;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;
import modele.Case;
import modele.Grille;

/* Interface permettant de piloter et de gérer les classes des types robots*/
public interface IRobot {

    void deplacement(EDeplacement deplacement) throws DeplacementException;

    EDirection getSens();

    Case getCaseFinale();

    void setSens(EDirection sens);

    void setCaseFinale(Case caseFinale);

    Grille getPelouse();
}