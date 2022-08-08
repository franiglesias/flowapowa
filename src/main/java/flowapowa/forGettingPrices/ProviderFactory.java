package flowapowa.forGettingPrices;

public class ProviderFactory {
    public static Provider getProvider(Boolean isDeprecatedEnabled) {
        if (isDeprecatedEnabled) {
            return new DeprecatedProvider();
        } else {
            return new NonDeprecatedProvider();
        }
    }
}
