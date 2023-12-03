package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private static String name;
    private static float price;

    @Mock
    Bun bun = new Bun(name, price);

    @Test
    public void getNameTest() {
        String resultName = bun.getName();
        assertEquals(name, resultName);
    }

    @Test
    public void getEmptyNameTest(){
        name = "";
        String resultName = bun.getName();
        assertEquals(null, resultName);
    }

    @Test
    public void getNullNameTest(){
        name = null;
        String resultName = bun.getName();
        assertEquals(null, resultName);
    }

    @Test
    public void getNameVerifyConstructionTest(){
        bun.getName();
        bun.getName();
        Mockito.verify(bun, times(2)).getName();
    }

    @Test
    public void getPriceTest() {
        float resultPrice = bun.getPrice();
        assertEquals(price, resultPrice, 0);
    }
}