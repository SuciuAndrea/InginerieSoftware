package game.scene;

import game.board.GameObject;

public class House extends GameObject {
    private String material;

    public House(String name, int x, int y, int width, int height, String material) {
        super(name, x, y, width, height);
        this.material = material;
    }

    @Override
    public String getDescription() {
        return name + " (House, material=" + material + ", pos=" + x + "," + y + ")";
    }
}
