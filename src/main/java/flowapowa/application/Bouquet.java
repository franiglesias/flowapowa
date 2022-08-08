package flowapowa.application;

import flowapowa.forGettingPrices.Provider;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    private final Receipt receipt = new Receipt();
    private final List<Product> products = new ArrayList<>();
    private Integer crafting;

    public Bouquet() {
    }

    public Bouquet(Integer crafting) {
        this.crafting = crafting;
    }

    public void add(Element element, Provider priceProvider) {
        double price = priceProvider.getPrice(element.value());

        Product product = new Product(element.value(), element.quantity(), price);

        products.add(product);
    }

    public void add(String productName, Integer quantity, Provider priceProvider) {
        double price = priceProvider.getPrice(productName);

        Product product = new Product(productName, quantity, price);

        products.add(product);
    }

    public String receipt() {
        for (Product product :
                products) {
            receipt.add(product);
        }
        receipt.addTotal("Crafting", crafting());
        receipt.addSeparator();
        receipt.addTotal("Total", total());

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

}
