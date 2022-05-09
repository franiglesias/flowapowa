package flowapowa.application;

public interface PriceProvider {
    void add(String product, Double unitaryPrice);

    double getPrice(String rose);
}
