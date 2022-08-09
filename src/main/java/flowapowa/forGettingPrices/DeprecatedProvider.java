package flowapowa.forGettingPrices;

import flowapowa.library.ProductProvider;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class DeprecatedProvider implements ProductProvider {
    private final Map<String, Double> products;

    public DeprecatedProvider() {
        products = new HashMap<>();
    }

    public void add(String product, Double unitaryPrice) {
        products.put(product, unitaryPrice);
    }

    public double getPrice(String product) {
        return products.get(product);
    }
}
