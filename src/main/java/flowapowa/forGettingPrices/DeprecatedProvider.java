package flowapowa.forGettingPrices;

import flowapowa.application.Provider;

public class DeprecatedProvider implements Provider {
    @Override
    public void add(String product, Double unitaryPrice) {
        throw new UnsupportedOperationException("Implement DeprecatedProvider.add");
    }
}
