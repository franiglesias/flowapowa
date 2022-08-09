package flowapowa.library;

import flowapowa.forGettingPrices.DeprecatedProvider;

public class ProductProviderFactory {
    private boolean featureEnabled = true;

    public ProductProvider getProductProvider() {
        if (featureEnabled) {
            return new NewProductProvider();
        }

        return new DeprecatedProvider();
    }
}
