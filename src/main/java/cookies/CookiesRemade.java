package cookies;

public class CookiesRemade {


    int numOfChocolateChips;
    double grams;
    String type;
    boolean edible;

    public CookiesRemade(int numOfChocolateChips){
        this.numOfChocolateChips = numOfChocolateChips;
        this.type = "chocolate";
    }

    public CookiesRemade(String type){
        this.type = type;
        this.numOfChocolateChips = 0;
    }
    public CookiesRemade(String type, double grams){
        this.type = type;
        this.grams = grams;
        this.numOfChocolateChips = 0;
    }
}
