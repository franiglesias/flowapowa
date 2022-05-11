package flowapowa.forUsingApplication;

import flowapowa.application.Bouquet;
import flowapowa.application.BouquetBuilder;
import flowapowa.application.BuildBouquet;
import flowapowa.application.ReceiptPrinter;
import flowapowa.forGettingPrices.DeprecatedProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlowaPowaAppShould {
    BuildBouquet buildBouquet;
    @Mock
    ReceiptPrinter receiptPrinter;

    @Mock
    DeprecatedProvider priceProvider;

    @Test
    void MakeASimpleBouquetWitUniqueFlowerNoCraftingCosts() {
        buildBouquet = new BuildBouquet(new BouquetBuilder(priceProvider));
        FlowaPowaApp.inject(buildBouquet, receiptPrinter);

        assertEquals(0, (Integer) FlowaPowaApp.main(new String[]{"rose:12;", "0"}));

        verify(receiptPrinter, times(1)).print(any(Bouquet.class));
    }
}