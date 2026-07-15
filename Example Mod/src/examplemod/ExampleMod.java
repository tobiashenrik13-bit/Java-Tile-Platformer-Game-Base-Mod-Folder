package examplemod;

import crafting.Recipe;
import modapi.Mod;
import modapi.ModContext;
import tile.Tile;
import tile.Tiles;

import java.awt.*;
import java.util.Map;

public class ExampleMod implements Mod {

    @Override
    public String getId() {
        return "examplemod";
    }

    @Override
    public void onLoad(ModContext context) {
        // Load the texture from THIS mod's own jar (not the game's classpath).
        Image texture = context.loadTexture("assets/endstone.png");

        // registerTile both creates the Tile AND adds it to the game's tile
        // registry (Tiles.BY_ID), namespaced as "examplemod:endstone" so it
        // can be saved/loaded and can't collide with other mods.
        Tile endstone = context.registerTile("endstone", texture, "Endstone");

        // Without a recipe (or a structure to spawn it in the world), there'd
        // be no way for the player to ever actually get this tile - so give
        // it one: 4 Stone -> 1 Endstone.
        context.registerRecipe(Recipe.shapeless(endstone, 1, Map.of(Tiles.STONE_BRICKS, 4)));
    }
}
