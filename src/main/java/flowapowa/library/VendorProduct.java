package flowapowa.library;

public class VendorProduct {
    private final String name;
    private final double unitPrice;

    public VendorProduct(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String name() {
        return name;
    }

    public double unitPrice() {
        return unitPrice;
    }
}

