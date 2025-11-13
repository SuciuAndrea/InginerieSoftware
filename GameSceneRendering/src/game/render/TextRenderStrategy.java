package game.render;

import game.board.Board;
import game.board.GameObject;

public class TextRenderStrategy implements RenderStrategy {
    @Override
    public void render(Board board) {
        System.out.println("\n Scene Render ");
        for (GameObject o : board.getObjects()) {
            System.out.println(o.getDescription());
        }
        System.out.println("====================\n");
    }
}
