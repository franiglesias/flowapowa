package flowapowa.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewProductProviderShould {
    @Test
    void retrieveProductsByName() {
        VendorProduct product = new VendorProduct("rose", 1.50);

        NewProductProvider provider = new NewProductProvider();

        provider.store(product);

        assertEquals(product, provider.getProductByName("rose"));
    }

    @Test
    void should_retrieve_price() {
        NewProductProvider provider = new NewProductProvider();
        provider.add("rose", 1.50);

        assertEquals(1.50, provider.getPrice("rose"));
    }
}