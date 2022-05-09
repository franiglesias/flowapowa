package flowapowa.application;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    private final Receipt receipt = new Receipt();
    private Integer crafting;
    private final List<Product> products = new ArrayList<>();

    public Bouquet() {
    }

    public Bouquet(Integer crafting) {
        this.crafting = crafting;
    }

    public void add(Recipe.Element element, Provider priceProvider) {
        double price = priceProvider.getPrice(element.element());

        Product product = new Product(element.element(), element.quantity(), price);

        products.add(product);
    }

    public String receipt() {
        for (Product product :
                products) {
            receipt.add(product);
        }
        receipt.add("Crafting", crafting());
        receipt.add();
        receipt.add("Total", total());

        return receipt.toString();
    }

    private float crafting() {
        return partial() * crafting / 100;
    }

    private float total() {
        return partial() + crafting();
    }

    private float partial() {
        float amount = 0;
        for (Product product :
                products) {
            amount += product.amount();
        }

        return amount;
    }

    private static class Receipt {
        private final List<Part> parts = new ArrayList<>();

        public Receipt() {
        }

        public void add(String element, int quantity, double price, float amount) {
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
            for (Part part :
                    parts) {
                receipt.append(part.toString());
            }

            return receipt.toString();
        }

        public void add(String total, float amount) {
            Part part = new Total(
                    total,
                    amount
            );

            parts.add(part);
        }

        public void add() {
            parts.add(new Separator());
        }

        public void add(Product product) {
            product.toReceipt(this);
        }

        private static class Part {
            protected final String element;
            protected final double price;
            private final int quantity;
            protected final float amount;

            public Part(String element, int quantity, double price, float amount) {
                this.element = element;
                this.price = price;
                this.quantity = quantity;
                this.amount = amount;
            }

            public Part() {
                this.element = "";
                this.price = 0;
                this.quantity = 0;
                this.amount = 0;
            }

            @Override
            public String toString() {
                return String.format("%-8s %5d %6.2f %7.2f\n", element(), quantity, price, amount());
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

        private static class Total extends Part {


            public Total(String element, float amount) {
                super(element, 1, 0, amount);
            }

            @Override
            public String toString() {
                return String.format("%-20s %8.2f\n", element, amount);
            }
        }

        private static class Separator extends Part {
            @Override
            public String toString() {
                return "-----------------------------\n";
            }
        }
    }

    private static class Product {
        private final String element;
        private final int quantity;
        private final double price;

        public Product(String element, int quantity, double price) {

            this.element = element;
            this.quantity = quantity;
            this.price = price;
        }

        public float amount() {
            return (float) (quantity * price);
        }

        public void toReceipt(Receipt receipt) {
            receipt.add(element, quantity, price, amount());
        }
    }
}
