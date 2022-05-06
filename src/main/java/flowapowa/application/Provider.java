package flowapowa.application;

public interface Provider {
    void add(String product, Double unitaryPrice);

    double getPrice(String rose);
}
