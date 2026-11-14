package service;

import enumerations.EDeplacement;
import exceptions.DeplacementException;
import interfaces.IRobot;

public class RobotManager {

    private IRobot robot;

    public RobotManager(IRobot robot) {
        this.robot = robot;
    }

    public void deplacement(EDeplacement deplacement) throws DeplacementException {
        robot.deplacement(deplacement);
    }
}
