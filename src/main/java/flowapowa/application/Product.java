package flowapowa.application;

class Product {
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

    public void addToReceipt(Receipt receipt) {
        receipt.addPart(element, quantity, price, amount());
    }
}
