public class BasketItem {

    private String productName;
    private Offer offer;
    private Integer productPrice;

    public static BasketItem APPLE = new BasketItem("Apple", Offer.NONE, 35);
    public static BasketItem BANANA = new BasketItem("Banana", Offer.NONE, 20);
    public static BasketItem MELON = new BasketItem("Melon", Offer.BUY_ONE_GET_ONE_FREE, 50);
    public static BasketItem LIME = new BasketItem("Lime", Offer.BUY_TWO_GET_ONE_FREE, 15);

    public BasketItem(String productName, Offer offer, Integer unitPrice) {
        this.productName = productName;
        this.offer = offer;
        this.productPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }


    public boolean applyOffer(Offer offer) {
        return this.offer == offer;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

}

