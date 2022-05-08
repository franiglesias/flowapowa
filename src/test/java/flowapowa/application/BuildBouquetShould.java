package flowapowa.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuildBouquetShould {
    @Mock
    RecipeFactory recipeFactory;
    @Mock
    BouquetBuilder bouquetBuilder;

    @Test

    void buildABouquetFromARecipe() {
        Recipe recipe = new Recipe();
        Bouquet expected = new Bouquet("rose", 1.5, 12);

        when(recipeFactory.makeFrom("rose:12;")).thenReturn(recipe);
        when(bouquetBuilder.withRecipe(recipe, 0)).thenReturn(expected);

        BuildBouquet buildBouquet = new BuildBouquet(
                recipeFactory,
                bouquetBuilder
        );

        Bouquet bouquet = buildBouquet.withRecipe("rose:12;", 0);

        assertEquals(expected, bouquet);
    }
}