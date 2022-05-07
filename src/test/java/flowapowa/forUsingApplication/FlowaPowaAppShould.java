package flowapowa.forUsingApplication;

import flowapowa.application.Bouquet;
import flowapowa.application.BuildBouquet;
import flowapowa.application.ReceiptPrinter;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
    }

    @Test
    void MakeASimpleBouquetWitUniqueFlowerNoCraftingCosts() {
        Bouquet bouquet = new Bouquet();
        when(buildBouquet.withRecipe("rose:12;", 0)).thenReturn(bouquet);

        String[] args = new String[]{"rose:12;", "0"};

        FlowaPowaApp.inject(buildBouquet, receiptPrinter);
        Integer exitCode = FlowaPowaApp.main(args);
        assertEquals(0, exitCode);
        verify(receiptPrinter, times(1)).print(bouquet);
    }
}