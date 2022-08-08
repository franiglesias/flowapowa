package flowapowa.application;

import flowapowa.forGettingPrices.Provider;

public class BouquetBuilder {
    private final Provider priceProvider;

    public BouquetBuilder(Provider priceProvider) {
        this.priceProvider = priceProvider;
    }

    public Bouquet withRecipe(Recipe recipe, Integer crafting) {
        Bouquet bouquet = new Bouquet(crafting);

        for (Recipe.Element element :
                recipe) {
            bouquet.add(element, priceProvider);
        }

        return bouquet;
    }
}
