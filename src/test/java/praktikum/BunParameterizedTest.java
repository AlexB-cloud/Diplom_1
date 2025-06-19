package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String expectedName;
    private final float expectedPrice;
    public BunParameterizedTest(String expectedName, float expectedPrice){
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters()
    public static Object[][] data(){
        return new Object[][]{
                {"С кунжутом",100},
                {"Без кунжута",50}
        };
    }
    @Test
    public void BunGetNameTest(){
        Bun testBun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedName,testBun.getName());
    }
    @Test
    public void BunGetPriceTest(){
        Bun testBun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedPrice,testBun.getPrice(),0.001f);
    }
}
