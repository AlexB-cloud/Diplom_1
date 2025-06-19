package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerNonParameterizedTest {
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIng1;
    @Mock
    private Ingredient mockIng2;

    @Test
    public void seBunsTest(){
        Burger burger= new Burger();
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun,burger.bun);
    }

    @Test
    public void addIngredientTest(){
        Mockito.when(mockIng1.getName()).thenReturn("Кисло-сладкий");
        Mockito.when(mockIng1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIng1.getPrice()).thenReturn(45f);

        Burger burger= new Burger();
        burger.addIngredient(mockIng1);

        Assert.assertEquals(1,burger.ingredients.size());
        Assert.assertEquals("Кисло-сладкий",burger.ingredients.get(0).getName());
        Assert.assertEquals(IngredientType.SAUCE,burger.ingredients.get(0).getType());
        Assert.assertEquals(45,burger.ingredients.get(0).getPrice(),0.001f);
    }

    @Test
    public void removeIngredientTest(){
        Burger burger= new Burger();
        burger.ingredients.add(mockIng1);

        Assert.assertEquals(1,burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals(0,burger.ingredients.size());

    }
    @Test
    public void moveIngredientTest(){
        Burger burger= new Burger();
        burger.ingredients.add(mockIng1);
        burger.ingredients.add(mockIng2);

        Assert.assertEquals(mockIng1,burger.ingredients.get(0));
        Assert.assertEquals(mockIng2,burger.ingredients.get(1));
        burger.moveIngredient(1,0);
        Assert.assertEquals(mockIng1,burger.ingredients.get(1));
        Assert.assertEquals(mockIng2,burger.ingredients.get(0));
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(mockIng1.getName()).thenReturn("Кисло-сладкий");
        Mockito.when(mockIng1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIng1.getPrice()).thenReturn(45f);
        Mockito.when(mockIng2.getName()).thenReturn("Котлета");
        Mockito.when(mockIng2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIng2.getPrice()).thenReturn(100f);
        Mockito.when(mockBun.getName()).thenReturn("С кунжутом");
        Mockito.when(mockBun.getPrice()).thenReturn(50f);

        Burger burger= new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIng1);
        burger.addIngredient(mockIng2);
        String expectedReceipt = "(==== С кунжутом ====)" + System.lineSeparator() +
                "= sauce Кисло-сладкий =" + System.lineSeparator() +
                "= filling Котлета =" + System.lineSeparator() +
                "(==== С кунжутом ====)"+ System.lineSeparator()+ System.lineSeparator()+"Price: 245,000000"+ System.lineSeparator();

        Assert.assertEquals(expectedReceipt, burger.getReceipt());

    }
}
