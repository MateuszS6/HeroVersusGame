package game;

import city.cs.engine.Walker;
import city.cs.engine.World;

public class Player extends Walker {
    /** Initialise a player. */
    public Player(World world, Character character) {
        super(world, character.getShape());
        addImage(character.getImage());
    }
}