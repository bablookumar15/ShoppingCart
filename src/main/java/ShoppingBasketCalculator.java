import rx.Observable;

import java.util.List;

public class ShoppingBasketCalculator {

    private Observable<BasketItem> basketItemsObservable;

    private Observable<Integer> totalBasketItemsPriceObservable;

    public ShoppingBasketCalculator(List<BasketItem> items) {
        basketItemsObservable = Observable.from(items);
        totalBasketItemsPriceObservable = Observable.merge(noOffer(), buyTwoGetOneFreeOffer(), buyOneGetOneFreeOffer()).scan(0, this::sum);
    }

    private Observable<Integer> buyTwoGetOneFreeOffer() {
        return basketItemsObservable.filter((item) -> item.applyOffer(Offer.BUY_TWO_GET_ONE_FREE)).buffer(3)
                .map((eachOffer) -> {
                    Integer each = eachOffer.get(0).getProductPrice();
                    int count = eachOffer.size();
                    return count == 3 ? each * 2 : count * each;
                });
    }

    private Observable<Integer> buyOneGetOneFreeOffer() {
        return basketItemsObservable.filter((item) -> item.applyOffer(Offer.BUY_ONE_GET_ONE_FREE)).buffer(2)
                .map((eachOffer) -> eachOffer.get(0).getProductPrice());
    }

    private Observable<Integer> noOffer() {
        return basketItemsObservable.filter((item) -> item.applyOffer(Offer.NONE)).map(BasketItem::getProductPrice);
    }

    public Observable<Integer> totalPrice() {
        return totalBasketItemsPriceObservable;
    }

    private Integer sum(Integer currentPrice, Integer priceOfNextItem) {
        return currentPrice + priceOfNextItem;
    }
    }


