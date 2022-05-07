package flowapowa.forPrintingReceipts;

import flowapowa.application.Bouquet;
import flowapowa.application.ReceiptPrinter;

public class ConsoleReceiptPrinter implements ReceiptPrinter {
    @Override
    public void print(Bouquet bouquet) {
        throw new UnsupportedOperationException("Implement ConsoleReceiptPrinter.print");
    }

    @Override
    public String output() {
        throw new UnsupportedOperationException("Implement ConsoleReceiptPrinter.output");
    }
}
