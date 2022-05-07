package flowapowa.forUsingApplication;

import flowapowa.application.Bouquet;
import flowapowa.application.BuildBouquet;
import flowapowa.application.ReceiptPrinter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlowaPowaAppShould {
    @Mock
    BuildBouquet buildBouquet;
    @Mock
    ReceiptPrinter receiptPrinter;

    @Test
    void MakeASimpleBouquetWitUniqueFlowerNoCraftingCosts() {
        FlowaPowaApp.inject(buildBouquet, receiptPrinter);

        Bouquet bouquet = new Bouquet();

        when(buildBouquet.withRecipe("rose:12;", 0)).thenReturn(bouquet);

        assertEquals(0, (Integer) FlowaPowaApp.main(new String[]{"rose:12;", "0"}));

        verify(receiptPrinter, times(1)).print(bouquet);
    }
}