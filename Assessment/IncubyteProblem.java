package IncuByteProblem.Assessment;
import java.util.ArrayList;
import java.util.List;

// Step 1: Define the spacecraft's initial state (position and direction).
class Spacecraft {
    int x, y, z;
    char direction;

    public Spacecraft(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }
}

// Step 2: Implement move functions
class SpacecraftManage {
    public static void moveForward(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N')
            spacecraft.y++;
        else if (spacecraft.direction == 'S')
            spacecraft.y--;
        else if (spacecraft.direction == 'E')
            spacecraft.x++;
        else if (spacecraft.direction == 'W')
            spacecraft.x--;
        else if (spacecraft.direction == 'U')
            spacecraft.z++;
        else if (spacecraft.direction == 'D')
            spacecraft.z--;
    }

    public static void moveBackward(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N')
            spacecraft.y--;
        else if (spacecraft.direction == 'S')
            spacecraft.y++;
        else if (spacecraft.direction == 'E')
            spacecraft.x--;
        else if (spacecraft.direction == 'W')
            spacecraft.x++;
        else if (spacecraft.direction == 'U')
            spacecraft.z--;
        else if (spacecraft.direction == 'D')
            spacecraft.z++;
    }

    // Step 3: Implement turn functions(Move anticlockwise)
    public static void leftTurn(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N')
            spacecraft.direction = 'W';
        else if (spacecraft.direction == 'W')
            spacecraft.direction = 'S';
        else if (spacecraft.direction == 'S')
            spacecraft.direction = 'E';
        else if (spacecraft.direction == 'E')
            spacecraft.direction = 'N';
        else if (spacecraft.direction == 'U')
            spacecraft.direction = 'W';
        else if (spacecraft.direction == 'D')
            spacecraft.direction = 'E';
            
    }

    public static void rightTurn(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N')
            spacecraft.direction = 'E';
        else if (spacecraft.direction == 'E')
            spacecraft.direction = 'S';
        else if (spacecraft.direction == 'S')
            spacecraft.direction = 'W';
        else if (spacecraft.direction == 'W')
            spacecraft.direction = 'N';
        else if (spacecraft.direction == 'U')
            spacecraft.direction = 'E';
        else if (spacecraft.direction == 'D')
            spacecraft.direction = 'W';
    }

    // Step 4: Implement angle change functions
    public static void turnUpward(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N' || spacecraft.direction == 'S' ||
            spacecraft.direction == 'E' || spacecraft.direction == 'W')
            spacecraft.direction = 'U';
    }

    public static void turnDownward(Spacecraft spacecraft) {
        if (spacecraft.direction == 'N' || spacecraft.direction == 'S' ||
            spacecraft.direction == 'E' || spacecraft.direction == 'W')
            spacecraft.direction = 'D';
    }

    // Step 5: Process commands
    public static void processCommands(Spacecraft spacecraft, List<Character> commands) {
        for (char command : commands) {
            if (command == 'f')
                moveForward(spacecraft);
            else if (command == 'b')
                moveBackward(spacecraft);
            else if (command == 'l')
                leftTurn(spacecraft);
            else if (command == 'r')
                rightTurn(spacecraft);
            else if (command == 'u')
                turnUpward(spacecraft);
            else if (command == 'd')
                turnDownward(spacecraft);
        }
    }
}

public class IncubyteProblem {
    public static void main(String[] args) {
        int intial_x = 0, intial_y = 0, intial_z = 0;
        char initial_direction = 'N';
        List<Character> commands = new ArrayList<>();
        commands.add('f');
        commands.add('r');
        commands.add('u');
        commands.add('b');
        commands.add('l');


        Spacecraft chandrayaan_3 = new Spacecraft(intial_x, intial_y, intial_z, initial_direction);
        SpacecraftManage.processCommands(chandrayaan_3, commands);

        System.out.println("Final Position: (" + chandrayaan_3.x + ", "
                + chandrayaan_3.y + ", " + chandrayaan_3.z + ")");
        System.out.println("Final Direction: " + chandrayaan_3.direction);
    }
}