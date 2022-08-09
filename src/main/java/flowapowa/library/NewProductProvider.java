package flowapowa.library;

import java.util.HashMap;
import java.util.Map;

public class NewProductProvider implements ProductProvider{
    Map<String, VendorProduct> products = new HashMap<>();

    @Override
    public void add(String product, Double unitaryPrice) {
        VendorProduct vendorProduct = new VendorProduct(product, unitaryPrice);
        store(vendorProduct);
    }

    @Override
    public double getPrice(String product) {
        VendorProduct vendorProduct = getProductByName(product);
        return vendorProduct.unitPrice();
    }

    public void store(VendorProduct product) {
        products.put(product.name(), product);
    }

    public VendorProduct getProductByName(String productName) {
        return products.get(productName);
    }
}
