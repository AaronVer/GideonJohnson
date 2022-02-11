package zoo;

//I might have to import the CookieRemade class here

//An interface is a guarantee of behavior that can be shared between classes
//for instance: comparable guarantees that two objects of the same class can be compared to each other
// (eg sorted alphabetically)
// why do this? Because we don't know what exact types we will be recieving, so we need to compare them.


// Interfaces are a "contract" of behavior
//IE, everything that implements comparable has a contract to be a comparable object
public class Animal implements Comparable<Animal>{
    String species;
    int temp = 0;
    public Animal(String s){
        species = s;
    }

    // I want to compare two animals so that we can have them sorted:
    // how is this done?

    // override is an annotation. In some cases its informative for the developer,
    // in other cases it actually changes the code
    //  it changes code because in Java there's something called reflection-
    //  meaning wthat we can make programs that change our java code at runetime
    // rather than compilation.
    public int compareTo(Animal a) {
        return a.species.compareTo(this.species);
    }

    public String toString(){
        return species;
    }

}
