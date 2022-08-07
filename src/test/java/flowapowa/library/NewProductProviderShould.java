package flowapowa.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewProductProviderShould {
    @Test
    void retrieveProductsByName() {
        VendorProduct product = new VendorProduct("rose", 1.50);

        NewProductProvider provider = new NewProductProvider();

        provider.store(product);

        assertEquals(product, provider.getProductByName("rose"));
    }
}