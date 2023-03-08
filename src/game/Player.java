package game;

import city.cs.engine.Walker;
import city.cs.engine.World;

public class Player extends Walker {
    private Character character;
    private Keybindings keybindings;

    /** Initialise a player. */
    public Player(World world, Character character) {
        super(world, character.getShape());
        this.character = character;
        addImage(character.getImage());
    }

    public Character getCharacter() {
        return character;
    }

    public Keybindings getKeybindings() {
        return keybindings;
    }

    public void setKeybindings(Keybindings keybindings) {
        this.keybindings = keybindings;
    }
}