package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
    static void run(Direction[] arr){
        for (Direction s : arr) {
            String message  = switch (s) {
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzek idzie do tyłu";
                case RIGHT -> "zwierzak skręca w prawo";
                case LEFT -> "zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }
    static Direction[] change(String[] arr){
        Direction[] directions = new Direction[arr.length];
        for (int i=0; i<arr.length; i++){
            switch(arr[i]){
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }
        }
        return directions;
    }
}





