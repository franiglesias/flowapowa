package flowapowa.forUsingApplication;

import flowapowa.application.Bouquet;
import flowapowa.application.BuildBouquet;
import flowapowa.application.ReceiptPrinter;
import flowapowa.forGettingPrices.DeprecatedProvider;

public class FlowaPowaApp {

    private static BuildBouquet buildBouquet;
    private static ReceiptPrinter receiptPrinter;

    public static int main(String[] args) {
        String recipe = args[0];
        Integer crafting = Integer.valueOf(args[1]);

        Bouquet bouquet = buildBouquet.withRecipe(recipe, crafting);

        receiptPrinter.print(bouquet);

        return 0;
    }

    public static void inject(BuildBouquet buildBouquet, ReceiptPrinter receiptPrinter) {
        FlowaPowaApp.buildBouquet = buildBouquet;
        FlowaPowaApp.receiptPrinter = receiptPrinter;
    }

    public String makeBouquet(String recipe, Integer crafting) {
        Bouquet bouquet = buildBouquet.withRecipe(recipe, crafting);

        return bouquet.receipt();
    }
}
