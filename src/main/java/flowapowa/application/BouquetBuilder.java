package flowapowa.application;

import flowapowa.library.ProductProvider;
import flowapowa.library.ProductProviderFactory;

public class BouquetBuilder {
    private final ProductProvider priceProvider;

    public BouquetBuilder(ProductProvider priceProvider) {
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
