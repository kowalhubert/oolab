package agh.ics.oop;

public class World {
    public static void main(String[] args) {
//        System.out.println("start");
//        run(change(args));
//        System.out.println("stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
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





