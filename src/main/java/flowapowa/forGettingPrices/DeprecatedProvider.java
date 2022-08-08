package flowapowa.forGettingPrices;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class DeprecatedProvider implements Provider {
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
