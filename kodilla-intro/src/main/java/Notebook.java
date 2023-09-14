public class Notebook {
    int weight;
    int price;
    int year;
    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public void checkPrice() {
        if (this.price < 600) {
            System.out.println("This notebook is cheap");
        } else if (this.price <= 1000) {
            System.out.println("The price is good");
        } else {
            System.out.println("This notebook is quite expensive");
        }
    }
    public void checkWeight() {
        if (this.weight < 1250) {
            System.out.println("This notebook is lightweight");
        } else if (this.weight <= 2500) {
            System.out.println("This notebook has regular weight");
        } else {
            System.out.println("This notebook is quite heavy");
        }
    }
    public void checkValue() {
        if (this.year < 2018) {
            if (this.price > 600) {
                System.out.println("This notebook is not a good value. It's too old and expensive.");
            } else {
                System.out.println("This notebook is a good value. It's old, but price is fair");
            }
        } else if (this.year <= 2021) {
            if (this.price > 1000) {
                System.out.println("This notebook is not a good value. It's too expensive.");
            } else {
                System.out.println("This notebook is a good value. It's still new and price is fair");
            }
        } else {
            if (this.price > 1500) {
                System.out.println("This notebook is not a good value. It's too expensive.");
            } else {
                System.out.println("This notebook is a good value. It's brand new and affordable.");
            }
        }
    }
}
