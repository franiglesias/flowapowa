package flowapowa;

import flowapowa.application.BouquetBuilder;
import flowapowa.application.BuildBouquet;
import flowapowa.application.ReceiptPrinter;
import flowapowa.forGettingPrices.DeprecatedProvider;
import flowapowa.forPrintingReceipts.ConsoleReceiptPrinter;
import flowapowa.forUsingApplication.FlowaPowaApp;
import flowapowa.library.ProductProvider;
import flowapowa.library.ProductProviderFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private final ProductProvider provider;
    private Integer crafting;
    private String recipe;

    public StepDefinitions() {
        final ProductProviderFactory productProviderFactory = new ProductProviderFactory();
        this.provider = productProviderFactory.getProductProvider();
    }

    @Given("{string} costs {double}")
    public void costs(String product, Double unitaryPrice) {
        provider.add(product, unitaryPrice);
    }

    @Given("crafting adds {int}%")
    public void crafting_adds(Integer percent) {
        crafting = percent;
    }

    @When("I request a bouquet with {int} {string}")
    public void i_request_a_bouquet_with(Integer quantity, String product) {
        recipe = new RawRecipe(quantity, product).toString();
    }

    @Then("the receipt looks like")
    public void the_receipt_looks_like(String expectedReceipt) {
        BuildBouquet buildBouquet = new BuildBouquet(
                new BouquetBuilder(provider)
        );
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();

        FlowaPowaApp.inject(buildBouquet, receiptPrinter);
        FlowaPowaApp.main(new String[]{recipe, String.valueOf(crafting)});

        assertEquals(expectedReceipt, receiptPrinter.output());
    }

    @When("I request a bouquet with {int} {string} and {int} {string}")
    public void iRequestABouquetWithAnd(int qty1, String product1, int qty2, String product2) {
        recipe = new RawRecipe(qty1, product1) + new RawRecipe(qty2, product2).toString();
    }

    public record RawRecipe(Integer quantity, String product) {

        public String toString() {
            return String.format(Locale.ROOT, "%s:%s;", product, quantity);
        }
    }
}
