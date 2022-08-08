package flowapowa.forGettingPrices;

import java.util.HashMap;
import java.util.Map;

public class NonDeprecatedProvider implements Provider {
    private final Map<String, Double> products;

    public NonDeprecatedProvider() {
        products = new HashMap<>();
    }

    public void add(String product, Double unitaryPrice) {
        products.put(product, unitaryPrice);
    }

    public double getPrice(String product) {
        return products.get(product);
    }
}
