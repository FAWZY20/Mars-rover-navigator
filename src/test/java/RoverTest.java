import org.example.Plateau;
import org.example.Position;
import org.example.Rover;
import org.example.RoverControler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


public class RoverTest {

     RoverControler roverControler;
     Plateau plateau;
     Position position;
     Rover rover;

    @Before
    public void initAll() {
        roverControler = new RoverControler();
        plateau = new Plateau(6, 6);
        position = new Position(1,2,'N');
        rover = new Rover(position, "LMLMLMLMM");
    }

    @Test
    public void moveRoverValid(){
        roverControler.updatePosition(rover);
    }

    @Test
    public void moveRoverError(){
         rover.setInstructions("LMLMLMLMMT");
         Assert.assertThrows(IllegalArgumentException.class, () ->{
             roverControler.updatePosition(rover);
         });
    }

    @Test
    public void moveRoverTableInput(){
        rover.setInstructions("LMLMLMLMM");
        roverControler.updatePosition(rover);
        plateau.setValueIndex(rover.getPosition().getX(), rover.getPosition().getY());
    }

    @Test
    public void moveRoverTableOutput(){
        rover.setInstructions("LMLMLMLMMMMMMMM");
        roverControler.updatePosition(rover);
        Assert.assertThrows(RuntimeException.class, () ->{
            plateau.setValueIndex(rover.getPosition().getX(), rover.getPosition().getY());
        });
    }

}
