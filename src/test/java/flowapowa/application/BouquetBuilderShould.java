package flowapowa.application;

import flowapowa.forGettingPrices.Provider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BouquetBuilderShould {

    @Mock
    private Provider priceProvider;

    @Test
    void createABouquetUsingARecipe() {
        Recipe recipe = new Recipe("rose:12;");

        when(priceProvider.getPrice("rose")).thenReturn(1.50);

        BouquetBuilder builder = new BouquetBuilder(priceProvider);
        Bouquet bouquet = builder.withRecipe(recipe, 35);

        String expected = """
                Rose        12   1.50   18.00
                Crafting                 6.30
                -----------------------------
                Total                   24.30
                """;

        assertEquals(expected, bouquet.receipt());
    }

}