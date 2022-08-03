package generic;

import java.util.ArrayList;
import java.util.Random;

enum Direction { EAST, SOUTH, WEST, NORTH }
enum Direction2 {
    EAST(1, "Right"), SOUTH(5, "Down"), WEST(-1, "Left"), NORTH(0, "Up");
    private final int value;
    private final String point;

    Direction2(int value, String point) {
        this.value = value;
        this.point = point;
    }

    public int getValue() {
        return value;
    }

    public String getPoint() {
        return point;
    }
}

public class GenericConversionExample {
    public static void main(String[] args) {
        Random random = new Random();
        String[] direction = { "EAST", "SOUTH", "WEST", "NORTH"};
        ArrayList<Direction> directions = new ArrayList<>();

        // 효율적
        Direction d1 = Direction.EAST;

        // 비효율적
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        for (int i = 0; i < 20; i++) {

            Direction d = Direction.valueOf(direction[random.nextInt(4)]);

//            switch (d) {
//                case EAST:
//                    System.out.println("EAST"); break;
//                case SOUTH:
//                    System.out.println("SOUTH"); break;
//                case WEST:
//                    System.out.println("WEST"); break;
//                case NORTH:
//                    System.out.println("NOTRH"); break;
//            }

            directions.add(d);
        }

        System.out.println(directions);


    }
}
