package game.main;

import game.board.Board;
import game.character.Character;
import game.character.Group;
import game.render.RenderStrategy;
import game.render.TextRenderStrategy;
import game.scene.House;
import game.scene.HouseFactory;
import game.scene.SceneType;

public class Main {
    public static void main(String[] args) {
        // initializare scena
        SceneType type = SceneType.EUROPEAN;
        Board board = new Board(20, 20);
        RenderStrategy renderer = new TextRenderStrategy();

        // case
        String material = HouseFactory.getMaterial(type);
        board.addObject(new House("House1", 5, 5, 3, 3, material));
        board.addObject(new House("House2", 10, 10, 3, 3, material));

        // personaje
        Character human = new Character("Human1", "Human", 25, 0, 0, 1, 1);
        Character elf = new Character("Elf1", "Elf", 120, 2, 0, 1, 1);
        board.addObject(human);
        board.addObject(elf);

        // grup
        Group group = new Group("Heroes");
        group.addMember(human);
        group.addMember(elf);

        // afisare scena
        renderer.render(board);

        // miscari
        human.moveTo(5, 5, board); // peste casa - nu merge
        elf.moveTo(8, 9, board);   // merge
        group.moveGroup(1, 1, board); // muta tot grupul

        // afisare  final
        renderer.render(board);
    }
}
