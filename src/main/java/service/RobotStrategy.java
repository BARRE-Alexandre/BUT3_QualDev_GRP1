package service;

import enumerations.EDirection;
import exceptions.DeplacementException;
import interfaces.IRobot;

public class RobotStrategy {

    private final IRobot robot;

    public RobotStrategy(IRobot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("Le robot ne peut pas être nul.");
        }
        this.robot = robot;
    }

    public void deplacerADroite() {
        switch (robot.getSens()) {
            case NORTH:
                robot.setSens(EDirection.EAST);
                break;
            case EAST:
                robot.setSens(EDirection.SOUTH);
                break;
            case WEST:
                robot.setSens(EDirection.NORTH);
                break;
            case SOUTH:
                robot.setSens(EDirection.WEST);
                break;
            default:
                break;
        }
    }

    public void deplacerAGauche() {
        switch (robot.getSens()) {
            case NORTH:
                robot.setSens(EDirection.WEST);
                break;
            case EAST:
                robot.setSens(EDirection.NORTH);
                break;
            case WEST:
                robot.setSens(EDirection.SOUTH);
                break;
            case SOUTH:
                robot.setSens(EDirection.EAST);
                break;
            default:
                break;
        }
    }

    public void deplacerEnAvant() throws DeplacementException {
        int x = robot.getCaseFinale().getX();
        int y = robot.getCaseFinale().getY();
        switch (robot.getSens()) {
            case NORTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            case SOUTH:
                y++;
                break;
            default:
                break;
        }
        try {
            robot.setCaseFinale(robot.getPelouse().getCase(x, y));
        } catch (IndexOutOfBoundsException e) {
            throw new DeplacementException("Déplacement impossible : la tondeuse sortirait de la grille.");
        }
    }
}
