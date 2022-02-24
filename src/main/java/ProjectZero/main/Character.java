package ProjectZero.main;

import java.util.Scanner;
//import org.apache.log4j.Logger;



public class Character<O> {
    // This class will be used to create character objects.

    // This project requires us to create our own data structure. After thinking it over, it
    // would not make sense to do that with the attributes and stats, for they are simply values
    // we update and not something we'd add or removes enteries from. However, it would make
    // sense to create a data structure for the spells, for that is a list which is being
    // continiously updated with new spells being added to it.

    //The available spells are the arrays that need to be done away with. They aren't needed (I can just display
    // slots 0, 1, and 2 of the buffer) and they are blatantly creating bugs. Comment these three lines, then clear
    // all errors caused by doing so.
    //String[] AvailableDestructionSpells = {"", "", ""};
    //String[] AvailableRestorationSpells = {"", "", ""};
    //String[] AvailableAmplificationSpells = {"", "", ""};
    //String[] AvailableAmplificationSpells = new String[3];
    //static Logger log = Logger.getLogger(Character.class);

    String[] KnownDestructionSpells = {"", "", "", "", "", "", "", "", ""};
    String[] KnownRestorationSpells = {"", "", "", "", "", "", "", "", ""};
    String[] KnownAmplificationSpells = {"", "", "", "", "", "", "", "", ""};

    String[] DestructionSpellBuffer = {"Alumentum", "Stone_Blast", "Scald", "Gale", "Fire_Ball", "Arcane_Bolt", "Exsanguinate", "Ignite"};
    String[] RestorationSpellBuffer = {"Mend", "Staunch", "Cleanse", "Invigorate", "Rejuvinate", "Group_Mend", "Group_Staunch", "Group_Cleanse"};
    String[] AmplificationSpellBuffer = {"Enhance_Constitution", "Enhance_Strength", "Enhance_Wisdom", "Enhance_Dexterity", "Enhance_Fortitude", "Enhance_Resilience", "Enhance_Precision", "Enhance_Reflex"};

    //Queue DestructionSpellBuffer;
    //Queue RestorationSpellBuffer;
    //Queue AmplificationSpellBuffer;

    // Attributes and stats will be contained in a map data structure, where
    // the attributes thesmelves are the values and the stats they boost

    String Name;
    private int level;
    private int Constitution;
    private int Dexterity;
    private int Strength;
    private int Fortitude;
    private int Wisdom;
    private int Resilience;
    private int Precision;
    private int Reflex;

    double Health;
    double Mana;
    double TurnSpeed;
    double AttackSpeed;
    double PhysicalAttack;
    double Regen;
    double PhysicalDefense;
    double BleedRes;
    double MagicAttack;
    double Parry;
    double MagicDefense;
    double StatusRes;
    double Accuracy;
    double CritChance;
    double Evasion;
    double CritRes;

    //Constructor
    public Character(String Name, int level, int Constitution, int Dexterity, int Strength, int Fortitude, int Wisdom, int Resilience, int Precision, int Reflex){
    this.Name = Name;
    this.Constitution = Constitution;
    this.Dexterity = Dexterity;
    this.Strength = Strength;
    this.Fortitude = Fortitude;

    this.Wisdom = Wisdom;
    this.Resilience = Resilience;
    this.Precision = Precision;
    this.Reflex = Reflex;
    this.level = level;
        /*
        // Initialize the spells that are available to choose
        AvailableDestructionSpells[0] = DestructionSpellBuffer[0];
        AvailableDestructionSpells[1] = DestructionSpellBuffer[1];
        AvailableDestructionSpells[2] = DestructionSpellBuffer[2];
        AvailableRestorationSpells[0] = RestorationSpellBuffer[0];
        AvailableRestorationSpells[1] = RestorationSpellBuffer[1];
        AvailableRestorationSpells[2] = RestorationSpellBuffer[2];
        AvailableAmplificationSpells[0] = AmplificationSpellBuffer[0];
        AvailableAmplificationSpells[1] = AmplificationSpellBuffer[1];
        AvailableAmplificationSpells[2] = AmplificationSpellBuffer[2];
        //Erase the spells from the buffer that were already taken.
        DestructionSpellBuffer[0] = ""; DestructionSpellBuffer[1] = ""; DestructionSpellBuffer[2] = "";
        RestorationSpellBuffer[0] = ""; RestorationSpellBuffer[1] = ""; RestorationSpellBuffer[2] = "";
        AmplificationSpellBuffer[0] = ""; AmplificationSpellBuffer[1] = ""; AmplificationSpellBuffer[2] = "";
        // Activate shift functions on the buffer.
        DestructionSpellBuffer = ShiftArray(DestructionSpellBuffer);
        RestorationSpellBuffer = ShiftArray(RestorationSpellBuffer);
        AmplificationSpellBuffer = ShiftArray(AmplificationSpellBuffer);
        */


    }

    public Character UpdateStats(Character object) {
        this.Health = this.Constitution * 3;
        this.Mana = this.Constitution * 3;
        this.TurnSpeed = this.Dexterity;
        this.AttackSpeed = this.Dexterity;
        this.PhysicalAttack = this.Strength;
        this.Regen = this.Strength;
        this.MagicAttack = this.Wisdom;
        this.Parry = this.Wisdom / 5;
        this.MagicDefense = this.Resilience;
        this.StatusRes = this.Resilience;
        this.PhysicalDefense = this.Fortitude;
        this.BleedRes = this.Fortitude / 10;
        this.Accuracy = this.Precision;
        this.CritChance = this.Precision;
        this.Evasion = this.Reflex;
        this.CritRes = this.Reflex;

        //log.info("Stats updated");


        return (object);
    }

    public String[] NewShift(String[] ProcessedArray){
        // Second attempt at creating a shift function
        int pointer = 0;
        int next = 1;
        int MaxLoopLength = ProcessedArray.length -1;
        int TotalIterations = 0;
        boolean SwapHasOccured = true;
        String Holding;
        // This is getting trapped in a circumstance where Swap has occured is false, but it cannot
        // enter the look again to make it True.
        while (SwapHasOccured){
            TotalIterations++;
            //System.out.println("Currnt iteration count: " + TotalIterations);
            //log.info("Shift loop has gone through "+TotalIterations+" iterations");
            SwapHasOccured = false;
            while (pointer < (MaxLoopLength)) {
                SwapHasOccured = false;
                // This will go through every entry of the array to search for empty
                // slots. If a slot was empty, it will swap places with the next, unless
                // the next slot is also empty.
                if (ProcessedArray[pointer] == ""){
                    // check next slot
                    if (ProcessedArray[next] != ""){
                        Holding = ProcessedArray[pointer];
                        ProcessedArray[pointer] = ProcessedArray[next];
                        ProcessedArray[next] = Holding;
                        SwapHasOccured = true;
                    }
                    // Because the next slot was also empty, no action is commenced.
                    // This is to allow a series of blank slots at the end of the array.
                }
                //Increment array
                pointer++;
                next++;

            }
            pointer = 0;
            next = 0;
        }

        return(ProcessedArray);
    }

    public String[] ShiftArray(String[] ProcessedArray){
        int pointer = 0;
        int TotalIterations = 1;
        int next = 1;
        int MaxLoopLenth = ProcessedArray.length;
        boolean CheckedSecondAndThird = false;
        MaxLoopLenth = MaxLoopLenth - 1;
        while (CheckedSecondAndThird == false) {
            //System.out.println("Outmost loop activated " + TotalIterations);
            //TotalIterations++;    I have confirmed that the outmost loop is not where it gets stuck.
            while (ProcessedArray[0] == "") {
                //System.out.println("Second loop activated" + TotalIterations);
                TotalIterations++; //A very critical problem lies within this loop here.
                //ProcessedArray[0] == "" ||ProcessedArray[1] == ""||ProcessedArray[2] == ""
                // it has +1 so it will never try to process the final slot. As that slot already got cleared
                // and doing so would throw an error because of "next" reaching for 1 further.
                while (pointer < (MaxLoopLenth)) {
                    if (ProcessedArray[next] != "") {
                        ProcessedArray[pointer] = ProcessedArray[next];
                        ProcessedArray[next] = "";
                    }
                    //System.out.println("Third loop activated" + TotalIterations);
                    pointer++;
                    next++;
                    //System.out.println(pointer);
                }
                pointer = 0;
                next = 1;
                //}
                //System.out.println("Slot 0:" + ProcessedArray[0] + " Slot 1" + ProcessedArray[1] + " Slot 3: " + ProcessedArray[2] + "Slot 4" + ProcessedArray[4]);
                // This proceduce is to ensure that slots 1 and 2 won't be empty as well if 0 is filled. But
                // also does so without preventing an infinite loop if the array is empty.
                if (ProcessedArray[3] != "") {
                    if (ProcessedArray[2] == "") {
                        ProcessedArray[2] = ProcessedArray[1];
                        ProcessedArray[1] = "";
                        //System.out.println("Slot 0:" + ProcessedArray[0] + " Slot 1" + ProcessedArray[1] + " Slot 3: " + ProcessedArray[2]);
                    }
                    if (ProcessedArray[1] == "") {
                        ProcessedArray[1] = ProcessedArray[0];
                        ProcessedArray[0] = ""; //Must be in this logic.
                        //System.out.println("Slot 0:" + ProcessedArray[0] + " Slot 1" + ProcessedArray[1] + " Slot 3: " + ProcessedArray[2]);
                    } else {
                        CheckedSecondAndThird = true;
                    }
                } else {
                    CheckedSecondAndThird = true;
                }
            }
            //CheckedSecondAndThird = true;
        }
        return(ProcessedArray);
    }

    public String[] ArrayAddition(String[] ProcessedArray, String NewEntry){
        String SlotContents;
        int search = 0;
        SlotContents = ProcessedArray[0];
        // Search array for empty slot
            while(search < ProcessedArray.length){
                SlotContents = ProcessedArray[search];
                if (SlotContents.equals("")){
                    ProcessedArray[search] = NewEntry;
                    //This return statement negates the need for a break statement
                    return(ProcessedArray);
                }
                search++;
            }
            //System.out.println("There are no empty slots left in the array. No modification is being made.");
            //log.info("There are no empty slots left in the array. No modification is being made.");
        return(ProcessedArray);
    }

    public O LevelUpLoop(O object){
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
    // Begin While(true) loop
        int AttirbutePoints = 5;
        String EnteredValue;
        String EnteredSpell;
        String FinalChoice;
        boolean ContinueLeveling = true;
        while(ContinueLeveling) {

            //DestructionSpellBuffer = ShiftArray(DestructionSpellBuffer);
            //RestorationSpellBuffer = ShiftArray(RestorationSpellBuffer);
            //AmplificationSpellBuffer = ShiftArray(AmplificationSpellBuffer);
            // Swapping to the NewShift versions
            DestructionSpellBuffer = NewShift(DestructionSpellBuffer);
            RestorationSpellBuffer = NewShift(RestorationSpellBuffer);
            AmplificationSpellBuffer = NewShift(AmplificationSpellBuffer);

            // Print character stats
            System.out.println("Attribute*********First Stat***********Second Stat");
            System.out.println("----------------------------------------------------------");
            System.out.println("Constitution: " + this.Constitution + "*  Health:" + this.Health + "          Mana:" + this.Mana);
            System.out.println("Dexterity:    " + this.Dexterity +    "*  Turn Speed:" + this.TurnSpeed + "       Attack Speed:" + this.AttackSpeed);
            System.out.println("Strength:     " + this.Strength + "*  Physical Attack:" + this.PhysicalAttack + "  Regen:" + this.Regen);
            System.out.println("Wisdom:       " + this.Wisdom + "*  Magic Attack:" + this.MagicAttack + "     Parry:" + this.Parry);
            System.out.println("Fortitude:    " + this.Fortitude + "*  Physical Attack:" + this.PhysicalAttack + "  Bleed Res:" + this.BleedRes);
            System.out.println("Resilience:   " + this.Resilience + "*  Magic Defense:" + this.MagicDefense + "    Status Res:" + this.StatusRes);
            System.out.println("Precision:    " + this.Precision + "*  Accuracy:" + this.Accuracy + "         Crit Chance:" + this.CritChance);
            System.out.println("Reflex:       " + this.Reflex + "*  Evasion:" + this.Evasion    + "          Crit Res:" + this.CritRes);
            System.out.println("----------------------------------------------------------");
            // Ask user which attributes to increase
            AttirbutePoints = 5;
            System.out.println("You have " + AttirbutePoints + " points left to spend. Enter the names of the attibutes you want to increase, seperated by spaces.");

            while(AttirbutePoints > 0){

                System.out.println("Enter the attribute to increase (first letter capitalized). You have " + AttirbutePoints+ " remaining points.");
                EnteredValue = input.next();
                switch (EnteredValue) {
                    case "Constitution":
                        this.Constitution = this.Constitution + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Constitution increased to " + this.Constitution);
                        break;
                    case "Dexterity":
                        this.Dexterity = this.Dexterity + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Dexterity increased to " + this.Dexterity);
                        break;
                    case "Strength":
                        this.Strength = this.Strength + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Strength increased to " + this.Strength);
                        break;
                    case "Wisdom":
                        this.Wisdom = this.Wisdom + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Wisdom increased to " + this.Wisdom);
                        break;
                    case "Fortitude":
                        this.Fortitude = this.Fortitude + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Fortitude increased to " + this.Fortitude);
                        break;
                    case "Resilience":
                        this.Resilience = this.Resilience + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                         System.out.println("Resilience increased to " + this.Resilience);
                        break;
                    case "Reflex":
                        this.Reflex = this.Reflex + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Reflex increased to " + this.Reflex);
                        break;
                    case "Precision":
                        this.Precision = this.Precision + 1;
                        AttirbutePoints = AttirbutePoints - 1;
                        System.out.println("Precision increased to " + this.Precision);
                        break;
                    default:
                        System.out.println("Invalid Entry");
                        break;

                    }
                }
                //If this point in the program has been reached, that must mean that the remaining attributes
                // is zero. Therefore, begin the spell selection process.

                System.out.println("All attribute points have been distributed.");
                this.UpdateStats(this);
                while(true){

                    //Check if there are any spells left to pick. If there aren't, break away.
                    if (DestructionSpellBuffer[0].equals("")){
                        if (RestorationSpellBuffer[0].equals("")){
                            if (AmplificationSpellBuffer[0].equals("")){
                                System.out.println("There are no spells left for this character to learn.");
                                break;
                            }
                        }
                    }

                    System.out.println("Pick one new spell to learn:");
                    System.out.println("Destruction Spells:" + DestructionSpellBuffer[0] + "  " + DestructionSpellBuffer[1] + "  " + DestructionSpellBuffer[2]);
                    System.out.println("Restoration Spells:" + RestorationSpellBuffer[0] + "  " + RestorationSpellBuffer[1] + "  " + RestorationSpellBuffer[2]);
                    System.out.println("Amplification Spells:" + AmplificationSpellBuffer[0] + "  " + AmplificationSpellBuffer[1] + "  " + AmplificationSpellBuffer[2]);
                    EnteredSpell = input.next();

                    //Unfortunately, case statements don't allow variables for the conditions. So I'll have to use
                    // if/else statements.

                    //I think the statements here might be out of order. It is taking from th Buffer when
                    // certain buffer slots are still empty.
                    if (EnteredSpell.equals(DestructionSpellBuffer[0])){
                        ArrayAddition(KnownDestructionSpells, DestructionSpellBuffer[0]);
                        DestructionSpellBuffer[0] = "";
                        //ShiftArray(DestructionSpellBuffer);
                        NewShift(DestructionSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(DestructionSpellBuffer[1])){
                        ArrayAddition(KnownDestructionSpells, DestructionSpellBuffer[1]);
                        DestructionSpellBuffer[1] = "";
                        //ShiftArray(DestructionSpellBuffer);
                        NewShift(DestructionSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(DestructionSpellBuffer[2])){
                        ArrayAddition(KnownDestructionSpells, DestructionSpellBuffer[2]);
                        DestructionSpellBuffer[2] = "";
                        //ShiftArray(DestructionSpellBuffer);
                        NewShift(DestructionSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(RestorationSpellBuffer[0])){
                        ArrayAddition(KnownRestorationSpells, RestorationSpellBuffer[0]);
                        RestorationSpellBuffer[0] = "";
                        //ShiftArray(RestorationSpellBuffer);
                        NewShift(RestorationSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(RestorationSpellBuffer[1])){
                        ArrayAddition(KnownRestorationSpells, RestorationSpellBuffer[1]);
                        RestorationSpellBuffer[1] = "";
                        //ShiftArray(RestorationSpellBuffer);
                        NewShift(RestorationSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(RestorationSpellBuffer[2])){
                        ArrayAddition(KnownRestorationSpells, RestorationSpellBuffer[2]);
                        RestorationSpellBuffer[2] = "";
                        //ShiftArray(RestorationSpellBuffer);
                        NewShift(RestorationSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(AmplificationSpellBuffer[0])){
                        ArrayAddition(KnownAmplificationSpells, AmplificationSpellBuffer[0]);
                        AmplificationSpellBuffer[0] = "";
                        //ShiftArray(AmplificationSpellBuffer);
                        NewShift(AmplificationSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(AmplificationSpellBuffer[1])){
                        ArrayAddition(KnownAmplificationSpells, AmplificationSpellBuffer[1]);
                        AmplificationSpellBuffer[1] = "";
                        //ShiftArray(AmplificationSpellBuffer);
                        NewShift(AmplificationSpellBuffer);
                        break;
                    }
                    if (EnteredSpell.equals(AmplificationSpellBuffer[2])){
                        ArrayAddition(KnownAmplificationSpells, AmplificationSpellBuffer[2]);
                        AmplificationSpellBuffer[2] = "";
                        //ShiftArray(AmplificationSpellBuffer);
                        NewShift(AmplificationSpellBuffer);
                        break;
                    }
                    System.out.println("Invalid spell name. Make sure to get capitalization correct.");
            }
                // With new attributes and spells picked, the user is asked if they want to level up again [cont]
                // repeat this entire function if they do, use a Break statement if they don't.
                this.level = this.level + 1;
                System.out.println("You have succesfully gone through the level up process. Would you like to gain another level?");
                System.out.println("Type 'Yes' (with correct capitalization) to gain another. Type anything else if you want to finish.");
                FinalChoice= input.next();
                if (! FinalChoice.equals("Yes")){
                    ContinueLeveling = false;
            }
            }
        return(object);
        }
    public O UpdateSpellQueue(O object){
        // This method removes all spells that are already known from the spell queues. It is to be
        // used when a character gets downloaded from the database.

        int loopCounter = 0;
        int subLoopCounter = 0;

        while (loopCounter < DestructionSpellBuffer.length){
            while (subLoopCounter < KnownDestructionSpells.length){
                // With this setup, it will scroll through the entire list of
                // know desctruction spells for every slot in the Destruction spell buffer,
                // allowing them all to be compared.
                if (DestructionSpellBuffer[loopCounter].equals(KnownDestructionSpells[subLoopCounter])){
                    DestructionSpellBuffer[loopCounter] = "";
                }
                subLoopCounter++;
            }
            loopCounter++;
            subLoopCounter = 0;
        }
        loopCounter = 0;
        NewShift(DestructionSpellBuffer);
        while (loopCounter < RestorationSpellBuffer.length){
            while (subLoopCounter < KnownRestorationSpells.length){
                // With this setup, it will scroll through the entire list of
                // know desctruction spells for every slot in the Destruction spell buffer,
                // allowing them all to be compared.
                if (RestorationSpellBuffer[loopCounter].equals(KnownRestorationSpells[subLoopCounter])){
                    RestorationSpellBuffer[loopCounter] = "";
                }
                subLoopCounter++;
            }
            loopCounter++;
            subLoopCounter = 0;
        }
        loopCounter = 0;
        //ShiftArray(RestorationSpellBuffer);
        NewShift(RestorationSpellBuffer);
        while (loopCounter < AmplificationSpellBuffer.length){
            while (subLoopCounter < KnownAmplificationSpells.length){
                if (AmplificationSpellBuffer[loopCounter].equals(KnownAmplificationSpells[subLoopCounter])){

                    AmplificationSpellBuffer[loopCounter] = "";
                    //I just figured out what's going on. It has already moved Enhance_Wisdom to the available spells,
                    //and therefore cannot find Enhance_Wisdom in the spell buffer anymore to delete.
                    // Therefore, I need to change the order of operations so the AvailableSpells arrays are not
                    // filled until the LevelUpLoop method begins.

                    // New problem. ShiftArray only works if it's the first slot that's blank and fails to
                    // properly shift if it's a different slot which is.

                }
                subLoopCounter++;
            }
            loopCounter++;
            subLoopCounter = 0;
        }
        NewShift(AmplificationSpellBuffer);

        return (object);
    }

        // adding in Get functions that are apparently needed for proper uploading
    public String getName() { return Name; }

    public int getLevel() {return level;}

    public int getStrength() {return Strength;}

    public int getWisdom() {return Wisdom;}

    public int getFortitude() {return Fortitude;}

    public int getResilience() {return Resilience;}

    public int getConstitution() {return Constitution;}

    public int getDexterity() {return Dexterity;}

    public int getPrecision() {return Precision;}

    public int getReflex() {return Reflex;}

}





