package flowapowa.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

class Receipt {
    private final List<ReceiptLine> parts = new ArrayList<>();

    public Receipt() {
    }

    public void addPart(String element, int quantity, double price, float amount) {
        Part part = new Part(
                element,
                quantity,
                price,
                amount
        );

        parts.add(part);
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        for (ReceiptLine part :
                parts) {
            receipt.append(part.toString());
        }

        return receipt.toString();
    }

    public void addTotal(String total, float amount) {
        parts.add(new Total(
                total,
                amount
        ));
    }

    public void addSeparator() {
        parts.add(new Separator());
    }

    public void add(Bouquet.Product product) {
        product.addToReceipt(this);
    }

    private static class Part implements ReceiptLine {
        protected final String element;
        private final double price;
        private final int quantity;
        protected final float amount;

        public Part(String element, int quantity, double price, float amount) {
            this.element = element;
            this.price = price;
            this.quantity = quantity;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT,"%-8s %5d %6.2f %7.2f\n", element(), quantity, price, amount());
        }

        private String element() {
            String first = element.substring(0, 1);
            String last = element.substring(1);

            return first.toUpperCase() + last.toLowerCase();
        }

        private Double amount() {
            return quantity * price;
        }
    }

    private static final class Total implements ReceiptLine {
        private final String element;
        private final float amount;

        private Total(String element, float amount) {
            this.element = element;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%-20s %8.2f\n", element, amount);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Total) obj;
            return Objects.equals(this.element, that.element) &&
                    Float.floatToIntBits(this.amount) == Float.floatToIntBits(that.amount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, amount);
        }

    }

    private static class Separator implements ReceiptLine {
        @Override
        public String toString() {
            return "-----------------------------\n";
        }
    }
}
