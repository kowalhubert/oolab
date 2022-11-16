package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animalsList;
    protected List<Grass> grassList;
    protected Vector2d leftBorder;
    protected Vector2d rightBorder;
    protected MapVisualiser mapVisualizer;
    abstract public boolean canMoveTo(Vector2d position);

    public AbstractWorldMap(){
        this.mapVisualizer = new MapVisualiser(this);
        this.grassList = new ArrayList<Grass>();
        this.animalsList = new ArrayList<>();
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalsList.add(animal);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animalsList) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        for (Grass grass: grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    public void updateBorders(){
        for (Animal animal : animalsList){
            this.leftBorder = leftBorder.lowerLeft(animal.getPosition());
            this.rightBorder = rightBorder.upperRight(animal.getPosition());
        }
        for (Grass grass : grassList){
            this.leftBorder = leftBorder.lowerLeft(grass.getPosition());
            this.rightBorder = rightBorder.upperRight(grass.getPosition());
        }
    }

    @Override
    public String toString(){
        updateBorders();
        return this.mapVisualizer.draw(leftBorder, rightBorder);
    }
}
