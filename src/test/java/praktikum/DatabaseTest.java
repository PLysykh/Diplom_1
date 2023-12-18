package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    @Mock
    private Database database;

    // TESTS FOR availableBuns() METHOD
    @Test
    public void availableBunsTest() {
        List<Bun> expectedBuns = Arrays.asList(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300));
        Mockito.when(database.availableBuns()).thenReturn(expectedBuns);
        List<Bun> actualBuns = database.availableBuns();

        assertEquals(expectedBuns, actualBuns);
    }

    @Test
    public void availableBunsQuantityTest() {
        Database database = new Database();
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void availableBunsTimesTest(){
        database.availableBuns();
        database.availableBuns();
        Mockito.verify(database, times(2)).availableBuns();
    }

    @Test
    public void availableBunsArrayCalledTest(){
        database.availableBuns();
        Mockito.verify(database).availableBuns();
    }

    // TESTS FOR availableIngredients() METHOD
    @Test
    public void availableIngredientsTest() {
        List<Ingredient> expectedIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300));
        Mockito.when(database.availableIngredients()).thenReturn(expectedIngredients);
        List<Ingredient> actualIngredients = database.availableIngredients();

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void availableIngredientsQuantityTest() {
        Database database = new Database();
        assertEquals(6, database.availableIngredients().size());
    }

    @Test
    public void availableIngredientsTimesTest(){
        database.availableIngredients();
        database.availableIngredients();
        Mockito.verify(database, times(2)).availableIngredients();
    }

    @Test
    public void availableIngredientsArrayCalledTest(){
        database.availableIngredients();
        Mockito.verify(database).availableIngredients();
    }
}