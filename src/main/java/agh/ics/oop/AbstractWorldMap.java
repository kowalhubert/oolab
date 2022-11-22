package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private final MapVisualiser mapVisualizer;
    private final Map<Vector2d, Animal> animals;
    protected abstract Vector2d getLeftBorder();
    protected abstract Vector2d getRightBorder();

    public AbstractWorldMap(){
        this.mapVisualizer = new MapVisualiser(this);
        this.animals = new HashMap<>();
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        else {
            throw new IllegalArgumentException(animal.getPosition() + " is occupied");
        }
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(getLeftBorder(), getRightBorder());
    }
}