package agh.ics.oop;

public enum MapDirection {
    SOUTH,
    WEST,
    NORTH,
    EAST;
    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }
    public MapDirection next(){
        return switch(this){
            case SOUTH -> MapDirection.WEST;
            case WEST -> MapDirection.NORTH;
            case NORTH -> MapDirection.EAST;
            case EAST -> MapDirection.SOUTH;
        };
    }
    public MapDirection previous(){
        return switch(this){
            case SOUTH -> MapDirection.EAST;
            case WEST -> MapDirection.SOUTH;
            case NORTH -> MapDirection.WEST;
            case EAST -> MapDirection.NORTH;
        };
    }
    public Vector2d toUnitVector(){
        return switch(this){
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
        };
    }
}