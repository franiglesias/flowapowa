package flowapowa.forPrintingReceipts;

import flowapowa.application.Bouquet;
import flowapowa.application.ReceiptPrinter;

public class ConsoleReceiptPrinter implements ReceiptPrinter {
    String output;
    @Override
    public void print(Bouquet bouquet) {
        output = bouquet.receipt();
    }

    @Override
    public String output() {
        return output;
    }
}
