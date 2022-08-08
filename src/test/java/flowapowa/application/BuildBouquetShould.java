package flowapowa.application;

import flowapowa.forGettingPrices.Provider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuildBouquetShould {
    BouquetBuilder bouquetBuilder;
    @Mock
    private Provider priceProvider;

    @Test
    void buildABouquetFromARecipe() {
        Bouquet expected = new Bouquet(0);
        when(priceProvider.getPrice("rose")).thenReturn(1.5);
        expected.add(new Element("rose", 12), priceProvider);

        bouquetBuilder = new BouquetBuilder(priceProvider);
        BuildBouquet buildBouquet = new BuildBouquet(bouquetBuilder);

        Bouquet bouquet = buildBouquet.withRecipe("rose:12;", 0);

        assertEquals(expected.receipt(), bouquet.receipt());
    }
}