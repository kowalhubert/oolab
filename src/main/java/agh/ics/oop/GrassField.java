package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrassField extends AbstractWorldMap{

    private final int grassNum;
    private final int bound;
    private final List<Vector2d> possiblePlaces = new ArrayList<>();

    public GrassField(int grassNum){
        this.grassNum = grassNum;
        this.bound = (int) Math.sqrt(grassNum * 10);
        this.leftBorder = new Vector2d(0, 0);
        this.rightBorder = new Vector2d(bound, bound);
        putGrassOnField(grassNum);
        updateBorders();
    }

    public void putGrassOnField(int grassNum) {
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                possiblePlaces.add(new Vector2d(i, j));
            }
        }
        Collections.shuffle(possiblePlaces);
        for(int i = 0; i < grassNum; i++){
            Grass grass = new Grass(possiblePlaces.get(i));
            grassList.add(grass);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) || this.objectAt(position) instanceof Grass;
    }
}
