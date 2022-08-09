package flowapowa.library;

public interface ProductProvider {
    void add(String product, Double unitaryPrice);
    double getPrice(String product);
}
