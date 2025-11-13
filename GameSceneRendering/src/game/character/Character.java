package game.character;

import game.board.Board;
import game.board.GameObject;

public class Character extends GameObject {
    private String type;
    private int age;

    public Character(String name, String type, int age, int x, int y, int width, int height) {
        super(name, x, y, width, height);
        this.type = type;
        this.age = age;
    }

    public boolean moveTo(int newX, int newY, Board board) {
        if (board.canMove(this, newX, newY)) {
            this.x = newX;
            this.y = newY;
            System.out.println(name + " moved to (" + x + "," + y + ")");
            return true;
        } else {
            System.out.println(name + " cannot move to (" + newX + "," + newY + ") - position occupied!");
            return false;
        }
    }

    @Override
    public String getDescription() {
        return name + " (" + type + ", age=" + age + ", pos=" + x + "," + y + ")";
    }
}
