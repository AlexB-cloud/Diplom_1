package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIng1;
    @Mock
    private Ingredient mockIng2;

    private final float bunPrice;
    private final float Ing1Price;
    private final float Ing2Price;
    private final float expectedTotalPrice;

    public BurgerParameterizedTest(float bunPrice, float Ing1Price, float Ing2Price, float expectedTotalPrice){
        this.bunPrice=bunPrice;
        this.Ing1Price=Ing1Price;
        this.Ing2Price=Ing2Price;
        this.expectedTotalPrice=expectedTotalPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {50f,40f,30f,170f},
                {100f,25.5f,25.5f,251f},
                {30.5f,50f,40f,151f}
        };
    }

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void burgerGetPriceWithDifferentParametersTest(){
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIng1.getPrice()).thenReturn(Ing1Price);
        Mockito.when(mockIng2.getPrice()).thenReturn(Ing2Price);

        Burger burger = new Burger();
        burger.addIngredient(mockIng1);
        burger.addIngredient(mockIng2);
        burger.setBuns(mockBun);

        Assert.assertEquals(expectedTotalPrice,burger.getPrice(),0.001f);


    }
}
