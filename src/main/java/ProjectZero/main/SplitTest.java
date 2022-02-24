package ProjectZero.main;

public class SplitTest {

    public static void main (String[] args){
        String ToBreak = "Fireball,Ignite,Immolate";
        String[] SpellArray = {"blank", "blank", "blank", "blank", "blank", "blank"};
        String[] SplitArray;
        int LoopCount = 0;

        SplitArray = ToBreak.split(",");

        while (LoopCount < SplitArray.length)
        {
            SpellArray[LoopCount] = SplitArray[LoopCount];
            LoopCount++;
        }
        System.out.println(SpellArray[0]);
        System.out.println(SpellArray[1]);
        System.out.println(SpellArray[2]);
        System.out.print(SpellArray[3]);
    }
}
