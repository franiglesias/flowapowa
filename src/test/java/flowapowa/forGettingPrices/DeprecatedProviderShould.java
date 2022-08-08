package flowapowa.forGettingPrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeprecatedProviderShould {
    @Test
    void AllowAddingPricesOfProducts() {
        Provider provider = new DeprecatedProvider();

        provider.add("rose", 1.50);

        assertEquals(1.50, provider.getPrice("rose"));
    }
}