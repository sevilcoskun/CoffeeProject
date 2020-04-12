package com.sevilcoskun.coffeeproject;

import org.junit.*;

import static com.sevilcoskun.coffeeproject.CoffeeType.Espresso;
import static com.sevilcoskun.coffeeproject.CoffeeType.Macchiato;

public class CafeTest {

    private static final int NO_MILK = 0;
    private static final int NO_BEANS = 0;
    private static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();

    /*
     * Before and After notations
     * BeforeClass and AfterClass --> Static
     * Before and After --> doesnt necessary to be static because every time an object is created
     * */
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class Notation");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Notation");
    }

    @Before
    public void before(){
        System.out.println("Before Notation");
    }

    @After
    public void after(){
        System.out.println("After Notation");
    }

    // TC1 - can brew some espresso
    @Test
    public void canBrewEspresso(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        Coffee coffee = cafe.brew(Espresso);

        Assert.assertEquals(Espresso, coffee.getType());
        Assert.assertEquals(NO_MILK, coffee.getMilk());
        Assert.assertEquals(ESPRESSO_BEANS, coffee.getBeans());
    }

    // TC2 - can brew some macchiato
    @Test
    public void canBrewMacchiato(){
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(Macchiato.getRequiredBeans());
        cafe.restockMilk(Macchiato.getRequiredMilk());

        //when
        Coffee coffee = cafe.brew(CoffeeType.Macchiato);

        //Then
        Assert.assertEquals("Wrong coffee type",CoffeeType.Macchiato, coffee.getType());
        Assert.assertEquals(Macchiato.getRequiredMilk(), coffee.getMilk());
        Assert.assertEquals(Macchiato.getRequiredBeans(), coffee.getBeans());
    }

    // TC3 - Check Espresso beans number after consumption
    @Test
    public void brewingEspressoConsumesBeans(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);

        cafe.brew(Espresso, 1);
        Assert.assertEquals("Wrong number of coffee beans", NO_BEANS, cafe.getBeansInStock());
    }

    // TC4 - Check restock milk
    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk(){
        Cafe cafe = new Cafe();
        cafe.restockMilk(NO_MILK);
    }

    // TC5 - Check restock beans
    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(NO_BEANS);
    }


}
