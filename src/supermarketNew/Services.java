package supermarketNew;

public enum Services {
    Tea (25),
    Coffee (20),
    Juice(15),
    HotDog(45),
    Cigarettes(0);

    private int price;

  Services(int price) {
        this.price = price;
    }

    public int getAddPrice() {
        return price;
    }
}