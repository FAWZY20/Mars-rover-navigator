package org.example;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RoverControler roverControler = new RoverControler();

        try (  Scanner reader = new Scanner(new FileInputStream("input.txt")) ) {
            Plateau plateau = new Plateau(reader.nextInt(), reader.nextInt());
            reader.nextLine();
            while (reader.hasNextLine()) {
                Position position = new Position(reader.nextInt(), reader.nextInt(), reader.next().charAt(0));
                reader.nextLine();

                if (reader.hasNextLine()) {
                    String instructions = reader.nextLine();
                    Rover rover = new Rover(position, instructions);
                    try {
                        roverControler.updatePosition(rover);
                        plateau.setValueIndex(rover.getPosition().getX(), rover.getPosition().getY());
                        System.out.println(rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getPosition().getOrientation());
                    }catch (RuntimeException e) {
                            System.err.println("Position non mise à jour en raison d'une erreur.");
                    }
                }
            }
        } catch (Exception e){
            throw new RuntimeException("Un probleme de lecture du fichier Detecter", e);
        }
    }

}