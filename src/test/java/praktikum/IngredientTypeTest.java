package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTypeTest {
    protected IngredientType[] values;
    @Before
    public void setUp(){
        this.values= IngredientType.values();
    }
    @Test
    public void enumValuesLengthTest() {
        Assert.assertEquals(2,values.length);
    }

    @Test
    public void enumValuesAreCorrect(){
        Assert.assertEquals(values[0],IngredientType.SAUCE);
        Assert.assertEquals(values[1],IngredientType.FILLING);
    }
}
