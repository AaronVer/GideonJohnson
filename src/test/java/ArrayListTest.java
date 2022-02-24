import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ArrayListTest {
    // Write some automated testing methods in junit, such as @test,
    // some form of assertion (assertTrue, assertEquals), as well as continueing
    // to work on your ArrayList implementations (make them generic if you like, it might help
    // you on your projects).


   // public static void main(String[] args){
        //nothing
    int TryArray[];
    int i = 5;
    int comparison;

    // Line copied from curriculum website \/
    static Logger log = Logger.getLogger(ArrayListTest.class);
    //}
    @BeforeEach
    public void Setup(){
        TryArray = new int[10];

        TryArray[0] = 10;
        TryArray[1] = 9;
        TryArray[2] = 8;
        TryArray[3] = 7;
        TryArray[4] = 6;
        TryArray[5] = 5;
        TryArray[6] = 4;
        TryArray[7] = 3;
        TryArray[8] = 2;
        TryArray[9] = 1;

        comparison = 5;
    }

    @Test
    public void ReturnArray(){
        int output;
        int starter = 5;
        //int i = 0;
        //output
        starter = 10 - i;
        //System.out.println(TryArray[5]);
        //assertEquals(starter,TryArray[i]);
        assertEquals(4, TryArray[6]);
        log.info("Test");
    }


}
