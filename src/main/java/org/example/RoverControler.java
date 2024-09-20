package org.example;

import java.util.List;

public class RoverControler {

    public void updatePosition(Rover rover) {
        Position position = rover.getPosition();
        List<String> orientations = List.of(rover.getInstructions().split(""));
        for (String instruction : orientations) {
            if (instruction.equals("L") || instruction.equals("R")) {
                changeInclinaison(position,instruction);
            } else if (instruction.equals("M")) {
                moveRover(position);
            }else {
                throw new IllegalArgumentException("instruction non existante :" + instruction);
            }
        }
        rover.setPosition(position);
    }

    public void moveRover(Position position){
        switch (position.getOrientation()) {
            case 'N':
                position.setY(position.getY() + 1);
                break;
            case 'S':
                position.setY(position.getY() - 1);
                break;
            case 'E':
                position.setX(position.getX() + 1);
                break;
            case 'W':
                position.setX(position.getX() - 1);
                break;
            default:
                throw new RuntimeException("Impossible d'effectuer une rotation la valeur du point cardinaux n'est pas bon");
        }
    }

    public void changeInclinaison(Position position, String instruction) {

        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation(instruction.equals("L") ? 'W' : 'E');
                break;
            case 'S':
                position.setOrientation(instruction.equals("L") ? 'E' : 'W');
                break;
            case 'E':
                position.setOrientation(instruction.equals("L") ? 'N' : 'S');
                break;
            case 'W':
                position.setOrientation(instruction.equals("L") ? 'S' : 'N');
                break;
            default:
                throw new RuntimeException("Impossible d'effectuer une rotation la valeur du point cardinaux n'est pas bon");
        }
    }

}
