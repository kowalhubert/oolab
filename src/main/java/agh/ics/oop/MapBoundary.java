package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class xComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d pos1, Vector2d pos2) {
        if (pos1.x != pos2.x) {
            return pos1.x - pos2.x;
        }
        return pos1.y - pos2.y;
    }
}

class yComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d pos1, Vector2d pos2) {
        if (pos1.y != pos2.y) {
            return pos1.y - pos2.y;
        }
        return pos1.x - pos2.x;
    }
}

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<Vector2d> elementsX = new TreeSet<>(new xComparator());
    SortedSet<Vector2d> elementsY = new TreeSet<>(new yComparator());

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removePosition(oldPosition);
        addPosition(newPosition);
    }

    public void removePosition(Vector2d position){
        elementsX.remove(position);
        elementsY.remove(position);
    }

    public void addPosition(Vector2d position){
        elementsX.add(position);
        elementsY.add(position);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(elementsX.last().x, elementsY.last().y);
    }

    public Vector2d getLowerleft(){
        return new Vector2d(elementsX.first().x, elementsY.first().y);
    }
}