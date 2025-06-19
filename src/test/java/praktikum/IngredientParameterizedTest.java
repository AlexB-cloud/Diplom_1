package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    public IngredientParameterizedTest(IngredientType expectedType,String expectedName,float expectedPrice){
        this.expectedType=expectedType;
        this.expectedName=expectedName;
        this.expectedPrice=expectedPrice;
    }
    @Parameterized.Parameters()
    public static Object[][] data(){
        return new Object[][]{
                {IngredientType.SAUCE,"Кисло-сладкий соус",50},
                {IngredientType.FILLING,"Сыр",75},
                {IngredientType.FILLING,"Котлета",200}
        };
    }
    @Test
    public void IngredientGetNameTest(){
        Ingredient ing = new Ingredient(expectedType,expectedName,expectedPrice);
        Assert.assertEquals(expectedName, ing.getName());
    }
    @Test
    public void IngredientGetTypeTest(){
        Ingredient ing = new Ingredient(expectedType,expectedName,expectedPrice);
        Assert.assertEquals(expectedType, ing.getType());
    }
    @Test
    public void IngredientGetPriceTest(){
        Ingredient ing = new Ingredient(expectedType,expectedName,expectedPrice);
        Assert.assertEquals(expectedPrice, ing.getPrice(),0.001f);
    }
}

