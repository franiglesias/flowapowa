package flowapowa.application;

import flowapowa.forGettingPrices.DeprecatedProvider;

public class BouquetBuilder {
    private final DeprecatedProvider priceProvider;

    public BouquetBuilder(DeprecatedProvider priceProvider) {
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
