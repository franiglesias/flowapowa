package flowapowa.forGettingPrices;

import flowapowa.application.Provider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeprecatedProviderShould {
    @Test
    void AllowAddingPricesOfProducts() {
        Provider provider = new DeprecatedProvider();

        provider.add("rose", 1.50);

        assertEquals( 1.50, provider.getPrice("rose"));
    }
}