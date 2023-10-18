import org.junit.Test;
import rx.observables.BlockingObservable;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingBasketCalculatorTest {

    @Test
    public void canCalculateThePriceOfItemsNotOnOffer_0() {
        BasketItem basketItem = BasketItem.APPLE;
        List<BasketItem> basket = Arrays.asList(basketItem,basketItem,basketItem);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basket);
        Integer priceOfBasket = basketItem.getProductPrice() * basket.size();
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(priceOfBasket));
    }
    @Test
    public void canCalculateThePriceOfItemsNotOnOffer_1() {
        BasketItem basketItem = BasketItem.BANANA;
        List<BasketItem> basket = Arrays.asList(basketItem,basketItem,basketItem);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basket);
        Integer priceOfBasket = basketItem.getProductPrice() * basket.size();
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(priceOfBasket));
    }
    @Test
    public void canCalculateThePriceOfItemsNotOnOffer_2() {
        List<BasketItem> basketOfBananasAndApples = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA, BasketItem.BANANA,BasketItem.APPLE,BasketItem.APPLE);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketOfBananasAndApples);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(130));
    }

    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyOneGetOneFree_0() {
        List<BasketItem> basketOfMelons = Arrays.asList(BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,BasketItem.MELON,BasketItem.MELON,BasketItem.MELON);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketOfMelons);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(150));
    }

    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyOneGetOneFree_1() {
        List<BasketItem> basketOfMelons = Arrays.asList(BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,BasketItem.MELON,BasketItem.MELON,BasketItem.MELON,BasketItem.MELON);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketOfMelons);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(200));
    }

    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyThreeForThePriceOfTwo_0() {
        List<BasketItem> basketOfLimes = Arrays.asList(BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketOfLimes);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(105));
    }
    @Test
    public void canCalculateThePriceOfItemsOnOfferBuyThreeForThePriceOfTwo_1() {
        List<BasketItem> basketOfLimes = Arrays.asList(BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME,BasketItem.LIME,BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketOfLimes);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(60));
    }

    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_0() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA, BasketItem.BANANA,BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE, BasketItem.APPLE,BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(350));
    }
    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_1() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE, BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(290));
    }
    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_2() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE, BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME,BasketItem.LIME, BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(305));
    }
    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_3() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON, BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME, BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(255));
    }

    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_4() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA, BasketItem.BANANA,BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE, BasketItem.APPLE,BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME,BasketItem.LIME,BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(330));
    }
    @Test
    public void canCalculateThePriceOfAMixedBasketOfItems_5() {
        List<BasketItem> basketItems = Arrays.asList(BasketItem.BANANA, BasketItem.BANANA, BasketItem.BANANA,BasketItem.BANANA,
                BasketItem.APPLE, BasketItem.APPLE, BasketItem.APPLE,BasketItem.APPLE,
                BasketItem.MELON, BasketItem.MELON,BasketItem.MELON,
                BasketItem.LIME, BasketItem.LIME, BasketItem.LIME,BasketItem.LIME,BasketItem.LIME);
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(380));
    }
    @Test
    public void canCalculateThePriceOfAnEmptyBasket() {
        List<BasketItem> basketItems = Arrays.asList();
        ShoppingBasketCalculator calc = new ShoppingBasketCalculator(basketItems);
        assertThat(BlockingObservable.from(calc.totalPrice()).last(), is(0));
    }

}