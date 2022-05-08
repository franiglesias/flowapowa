package flowapowa.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeFactoryShould {
    @Test
    void createARecipeWithOneElement() {
        String raw = "flower:5;";

        RecipeFactory factory = new RecipeFactory();

        Recipe expected = new Recipe();
        expected.add("flower", 5);

        Recipe recipe = factory.makeFrom(raw);
        assertEquals(expected, recipe);
    }
}