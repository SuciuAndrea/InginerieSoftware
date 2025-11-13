package game.character;

import game.board.Board;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Character> members = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addMember(Character c) {
        members.add(c);
    }

    public void moveGroup(int dx, int dy, Board board) {
        System.out.println("Moving group " + name);
        for (Character c : members) {
            c.moveTo(c.x + dx, c.y + dy, board);
        }
    }

    public List<Character> getMembers() {
        return members;
    }
}
