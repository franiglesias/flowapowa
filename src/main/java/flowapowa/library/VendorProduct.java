package flowapowa.library;

public class VendorProduct{
    private String name;
    private double unitPrice;

    public VendorProduct(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String name() {
        return name;
    }
}

