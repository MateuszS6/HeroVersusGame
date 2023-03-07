package game;

import city.cs.engine.Walker;
import city.cs.engine.World;

public class Player extends Walker {
    private Character character;

    /** Initialise a player. */
    public Player(World world, Character character) {
        super(world, character.getShape());
        this.character = character;
        addImage(this.character.getImage());
    }

    public Character getCharacter() {
        return character;
    }
}