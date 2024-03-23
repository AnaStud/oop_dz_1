package Heroes;

import java.util.ArrayList;

public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calculateDistance(int otherX, int otherY) {
        return Math.sqrt(Math.pow(this.x - otherX, 2) + Math.pow(this.y - otherY, 2));
    }

    public void stepX(boolean direction, ArrayList<BaseHero> friends) {
        int newX = direction ? ++this.x : --this.x;
        if (isNoOccupied(newX, this.y, friends)) {
            this.x = newX;
        }
    }

    public void stepY(boolean direction, ArrayList<BaseHero> friends) {
        int newY = direction ? ++this.y : --this.y;
        if (isNoOccupied(this.x, newY, friends)) {
            this.y = newY;
        }
    }

    public boolean isNoOccupied(int newX, int newY, ArrayList<BaseHero> friends) {
        for (BaseHero friend : friends) {
            if (friend.coordinates.x == newX && friend.coordinates.y == newY) {
                return false;
            }
        }
        return true;
    }
}
