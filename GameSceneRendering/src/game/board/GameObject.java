package game.board;

public abstract class GameObject {
    protected String name;
    public int x;
    public int y;
    protected int width;
    protected int height;

    public GameObject(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(GameObject other) {
        return x < other.x + other.width &&
                x + width > other.x &&
                y < other.y + other.height &&
                y + height > other.y;
    }

    public abstract String getDescription();
}
