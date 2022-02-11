package zoo;

// So if this starts the same thing that Driver does, then it should do the same things Driver does.

public class TryTesting{

    // Here's my plan. I'm going to attempt to use annotations and similar commands.
    // What I'll do is that I'll import the Zoo package and classes, and then copy sections from
    // other files to here, and test them. That way I will have an idea on what the results should be.

    public static void main(String[] args) {

        // It would appear that try statements need their own methods. Since I have no
        // clue what to be bringing into these methods
        labratory();
    }
    //@Test
    public static void labratory(){
        Animal a1 = new Animal("Lopster");
        Animal a2 = new Animal("Skunk");
        Animal a3 = new Animal("Wolf");

        //Assert.assertEquals(7, (a1.compareTo(a2)));
    }

}
