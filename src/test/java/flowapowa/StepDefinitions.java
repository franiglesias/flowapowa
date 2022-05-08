package flowapowa;

import flowapowa.application.*;
import flowapowa.forGettingPrices.DeprecatedProvider;
import flowapowa.forPrintingReceipts.ConsoleReceiptPrinter;
import flowapowa.forUsingApplication.FlowaPowaApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Provider provider;
    private Integer crafting;
    private String recipe;

    public StepDefinitions() {
        this.provider = new DeprecatedProvider();
    }

    @Given("{string} costs {double}")
    public void costs(String product, Double unitaryPrice) {
        provider = new DeprecatedProvider();
        provider.add(product, unitaryPrice);
    }

    @Given("crafting adds {int}%")
    public void crafting_adds(Integer percent) {
        crafting = percent;
    }

    @When("I request a bouquet with {int} {string}")
    public void i_request_a_bouquet_with(Integer quantity, String product) {
        recipe = String.format("%s:%s;\n", product, quantity);
    }

    @Then("the receipt looks like")
    public void the_receipt_looks_like(String expectedReceipt) {
        BuildBouquet buildBouquet = new BuildBouquet(
                new RecipeFactory(),
                new BouquetBuilder()
        );
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();
        FlowaPowaApp.inject(buildBouquet, receiptPrinter);
        FlowaPowaApp.main(new String[]{recipe, String.valueOf(crafting)});
        assertEquals(expectedReceipt, receiptPrinter.output());
    }

}
