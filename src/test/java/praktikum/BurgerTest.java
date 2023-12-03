package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger = new Burger();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient, ingredient_2, ingredient_3, ingredient_4;

    @Test
    public void setBunsTest(){
        bun = new Bun("delicious", 12f);
        burger.setBuns(bun);
        String resultName = burger.bun.getName();

        assertEquals(bun.getName(), resultName);
    }

    @Test
    public void addIngredientsTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        int numberOfIngredients = burger.ingredients.size(); // all-in-all 3 were added

        assertEquals(3, numberOfIngredients);
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int numberOfIngredients = burger.ingredients.size(); // all-in-all 3 were added
        assertEquals(3, numberOfIngredients);

        burger.removeIngredient(2);
        burger.removeIngredient(1);
        int numberOfIngredientsAfterDeletion = burger.ingredients.size(); // should be 1 'cause 2 ingredients were removed

        assertEquals(1, numberOfIngredientsAfterDeletion);
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);

        burger.moveIngredient(0, 1);

        Ingredient firstElement = burger.ingredients.get(0);
        Ingredient secondElement = burger.ingredients.get(1);

        assertEquals(ingredient, secondElement);
        assertEquals(ingredient_2, firstElement);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);

        Mockito.when(bun.getPrice()).thenReturn(5.0000F);
        Mockito.when(ingredient.getPrice()).thenReturn(12.0002F);
        Mockito.when(ingredient_2.getPrice()).thenReturn(19.003F);

        float priceResulted = 12.0002F+19.003F+5.0000F*2;

        assertEquals(burger.getPrice(), priceResulted, 0.0);
    }

    @Test
    public void getReceitTest(){

        burger.setBuns(bun);
        burger.addIngredient(ingredient_3);
        burger.addIngredient(ingredient_4);

        Mockito.when(bun.getName()).thenReturn("Assassin");
        Mockito.when(ingredient_3.getName()).thenReturn("Tartar");
        Mockito.when(ingredient_4.getName()).thenReturn("Crabs");

        Mockito.when(bun.getPrice()).thenReturn(1.618f);
        Mockito.when(ingredient_3.getPrice()).thenReturn(4.0f);
        Mockito.when(ingredient_4.getPrice()).thenReturn(5.718f);

        Mockito.when(ingredient_3.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient_4.getType()).thenReturn(IngredientType.FILLING);

        String resultedReceipt = "(==== Assassin ====)\r\n" + "= sauce Tartar =\r\n" + "= filling Crabs =\r\n" + "(==== Assassin ====)\r\n" + "\r\n" + "Price: 12,954000\r\n";

        assertEquals(resultedReceipt, burger.getReceipt());
    }
}