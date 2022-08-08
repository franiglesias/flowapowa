package flowapowa.forGettingPrices;

public interface Provider {
    void add(String product, Double unitaryPrice);
    double getPrice(String product);
}