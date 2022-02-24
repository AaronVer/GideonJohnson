package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


//Going to bite two bullets with this class. I'm going to set up annotations to finally
// practice testing with those, and lambdas are going to be what I do testing on.

public class LambdasTest {

    List<String> PieTypes= new ArrayList();
    static String PieArray[];

    public static void main(String[] args){
        //I don't this the main function is actually all that important for this
        List<String> PieTypes = new ArrayList();
        PieArray = new String[4];
        PieTypes.add("Cherry");
        PieTypes.add("Blueberry");
        PieTypes.add("Apple");
        PieTypes.add("Pumpkin");
        PieArray[0] = "Cherry";
        PieArray[1] = "Blueberry";
        PieArray[2] = "Apple";
        PieArray[3] = "Pumpkin";

        experimental(PieTypes);

    }
    @BeforeEach
    public void Setup(){
        //Setup the variables to be used in the Lambda functions
        List<String> PieTypes = new ArrayList();
        PieArray = new String[4];
        PieTypes.add("Cherry");
        PieTypes.add("Blueberry");
        PieTypes.add("Apple");
        PieTypes.add("Pumpkin");
        PieArray[0] = "Cherry";
        PieArray[1] = "Blueberry";
        PieArray[2] = "Apple";
        PieArray[3] = "Pumpkin";
    }

    /*
    I'm having trouble creating a class where a Test function can be activated both randomly (with a BeforeAll method
setting up the data).  I have to make the method be Static in order for it to be called by the Main function, but by making it
static, it then has trouble reaching the non-static variables (including the ones established in BeforeEach method).

    Because of this, I don't think Test annotations can easily be integrated into a class as your building it.
I believe they would work best to be able to "skip" to the point in your program where you can test what is resulting in problems.

    Let me give an example. Let's say I made my character creation program more advanced, so much so that it took
10 minutes to create a character. Then after creating a character it perform a methods to upload them to the database, and
it is that "Upload" function that has bugs I need to test. In this circumstance, it would be incredibly tedious for me to go
through the 10 minutes to make a new character and reach the Upload method again. But with the use of Annotations, I can set
things up so a BeforeEach method instantly creates the character, and then I can debug the Upload method much faster using that, as
I can now start the program on that part.

So that is what I believe the purpose of them is.

     */

    @Test
    static void experimental(List<String> PieTypes){
        //List<String> PieTypes;
        //Assert
        String combinedFlavors = "";
        System.out.println("OutputTest");
        PieTypes.forEach(str -> System.out.println(str));
        //PieArray.forEach(str -> System.out.print(str));
        //Noteworthy discovery, forEach does NOT work for arrays, but does for lists.
        //PieTypes.forEach(str ->
        //                (combinedFlavors = combinedFlavors.concat(str))
        //        );

        //Lambdas only like Final or effectivly final variables. So this above process doesn't work.
    }


}
