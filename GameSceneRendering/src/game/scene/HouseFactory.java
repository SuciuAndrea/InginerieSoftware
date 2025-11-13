package game.scene;

public class HouseFactory {
    public static String getMaterial(SceneType type) {
        return switch (type) {
            case ASIAN -> "bamboo";
            case AFRICAN -> "clay";
            default -> "concrete";
        };
    }
}
