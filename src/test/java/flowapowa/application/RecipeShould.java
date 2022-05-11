package flowapowa.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeShould {
    @Test
    void addElement() {
        Recipe.Element expected = new Recipe.Element("flower", 12);

        Recipe recipe = new Recipe();
        recipe.add("flower", 12);
        for (Recipe.Element element :
                recipe) {
            assertEquals(expected, element);
        }
    }

    @Test
    void buildFromRawRecipe() {

        Recipe expected = new Recipe();
        expected.add("flower", 5);

        Recipe recipe = new Recipe("flower:5;");
        assertEquals(expected, recipe);
    }
}