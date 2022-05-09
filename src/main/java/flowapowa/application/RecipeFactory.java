package flowapowa.application;

public class RecipeFactory {
    public Recipe makeFrom(String rawRecipe) {
        String[] lines = rawRecipe.split(";");


        Recipe recipe = new Recipe();

        for (String line :
                lines) {
            String[] parts = line.split(":");
            recipe.add(parts[0], Integer.parseInt(parts[1]));
        }

        return recipe;
    }
}
