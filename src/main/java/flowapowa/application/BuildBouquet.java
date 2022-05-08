package flowapowa.application;

public class BuildBouquet {
    private RecipeFactory recipeFactory;
    private BouquetBuilder bouquetBuilder;


    public BuildBouquet(RecipeFactory recipeFactory, BouquetBuilder bouquetBuilder) {
        this.recipeFactory = recipeFactory;
        this.bouquetBuilder = bouquetBuilder;
    }

    public Bouquet withRecipe(String rawRecipe, Integer crafting) {
        Recipe recipe = recipeFactory.makeFrom(rawRecipe);

        Bouquet bouquet = bouquetBuilder.withRecipe(recipe, crafting);

        return bouquet;
    }
}
