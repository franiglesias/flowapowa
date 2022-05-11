package flowapowa.vendor;

import java.util.HashMap;
import java.util.Map;

public class NewProductProvider {
    Map<String, VendorProduct> products = new HashMap<>();
    public void store(VendorProduct product) {
        products.put(product.name(), product);
    }

    public VendorProduct getProductByName(String productName) {
        return products.get(productName);
    }
}
