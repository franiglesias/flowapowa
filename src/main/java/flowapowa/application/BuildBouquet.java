package flowapowa.application;

public class BuildBouquet {
    private final BouquetBuilder bouquetBuilder;

    public BuildBouquet(BouquetBuilder bouquetBuilder) {
        this.bouquetBuilder = bouquetBuilder;
    }

    public Bouquet withRecipe(String rawRecipe, Integer crafting) {
        Recipe recipe = new Recipe(rawRecipe);

        return bouquetBuilder.withRecipe(recipe, crafting);
    }
}
