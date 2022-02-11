package cookies;

public class Driver {


    //This will be the class from which I will use constructors to create cookie objects
    // using the CookiesRemade class.
    public static void main(String[] args){

        System.out.println("The Driver class' method has been activated.");
        int numOfChocolateChips = 20;
        String type;

        // activate the cookie creator from the other class
        CookiesRemade c1 = new CookiesRemade(numOfChocolateChips);
        CookiesRemade c2 = c1;
        System.out.println(c1);
        System.out.println(c1.type);
        System.out.println("Program has concluded");


    }
}
