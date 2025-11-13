package game.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width, height;
    private List<GameObject> objects = new ArrayList<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public boolean canMove(GameObject obj, int newX, int newY) {
        GameObject temp = new GameObject("temp", newX, newY, obj.width, obj.height) {
            @Override
            public String getDescription() {
                return "temp";
            }
        };
        for (GameObject o : objects) {
            if (o == obj) continue;
            if (temp.overlaps(o)) return false;
        }
        return newX >= 0 && newY >= 0 && newX + obj.width <= width && newY + obj.height <= height;
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}
