package flowapowa.application;

import flowapowa.forGettingPrices.DeprecatedProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BouquetShould {
    @Mock
    private DeprecatedProvider priceProvider;

    @Test
    void produceAReceipt() {
        when(priceProvider.getPrice("flower")).thenReturn(1.50);

        Bouquet bouquet = new Bouquet(35);
        bouquet.add("flower", 12, priceProvider);

        String expected = """
                Flower      12   1.50   18.00
                Crafting                 6.30
                -----------------------------
                Total                   24.30
                """;

        assertEquals(expected, bouquet.receipt());
    }
}