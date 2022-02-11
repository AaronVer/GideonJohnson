// package cookies;

public class Cookie {


    int numOfChocolateChips;
    double grams;
    private String type;
    boolean edible;

    public Cookie(int numOfChocolateChips){
        this.numOfChocolateChips = numOfChocolateChips;
        this.type = "chocolate";
    }

    public Cookie(String type){
        this.type = type;
        this.numOfChocolateChips = 0;
    }
    public Cookie(String type, double grams){
        this.type = type;
        this.grams = grams;
        this.numOfChocolateChips = 0;
    }
}
