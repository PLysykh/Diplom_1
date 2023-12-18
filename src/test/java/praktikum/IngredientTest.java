package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {SAUCE, "Salsa sauce", 4.0f},
                {SAUCE, "Tartar sauce", 5.004F},
                {FILLING, "Crabs", 5.718f},
                {FILLING, "Vegetables", 0.9F}
        };
    }

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float resultPrice = ingredient.getPrice();
        assertEquals(price, resultPrice, 0.0);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String resultName = ingredient.getName();
        assertEquals(name, resultName);
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType resultType = ingredient.getType();
        assertEquals(type, resultType);
    }
}