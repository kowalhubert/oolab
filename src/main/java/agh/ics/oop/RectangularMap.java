package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final List<Animal> animalsList = new ArrayList<>();
    private final Vector2d right_border;
    private final Vector2d left_border;
    final MapVisualiser mapVisualizer;

    public RectangularMap(int width, int height){
        this.left_border = new Vector2d(0, 0);
        this.right_border = new Vector2d(width - 1, height - 1);
        this.mapVisualizer = new MapVisualiser(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(right_border) && position.follows(left_border) && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animalsList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animalsList){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        return this.mapVisualizer.draw(left_border, right_border);
    }
}


