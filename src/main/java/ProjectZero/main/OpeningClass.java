package ProjectZero.main;

// I believe this line was created when I shifted which package folder this class was in. I don't
// think it does anything but I'll just leave it here.
import ProjectZero.main.Character;
import com.revature.util.ConnectionUtil;

//Importing the connection class to here.

// I am importing the SQL classes into this so that they are able to raise SQL exceptions
// (even though I have the DBeaver class to perform the real SQL procedues)
import javax.naming.Name;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import java.util.Scanner;

public class OpeningClass<O extends Character> {

    public static Connection conn = ConnectionUtil.getConnection();

    // This will be the class in this project that will actually get run. All other
    // classes will instead serve to get imported and activated by this one.

    // Overall, this program will server to emulate the leveling up process
    // for the video game I plan to make, Days of Redemption. Characters will be
    // saved on databases online and retained through several runs. Once the
    // level up simulation is done, the updates will be saved.

    // This run should be done in the following steps:
    // Step 1: Asking user whether to create a new character or open an old one
    // Step 2: Import character or create new character object, then display current data
    // Step 3: Have user choose which attributes to increase
    // Step 4: Have user choose a new spell for the character to learn
    // Step 5: Ask if they want to level up again. If yes, return to step 3. If no, continue.
    // Step 6: Export and save character data into Azure database.

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        String UserChoice;
        Boolean EntryValid = false;
        Boolean NameExists = false;
        String EnteredName = "asjgi";
        String[] ValidNames= new String[100];
        int loopCount = 0;

        System.out.println("Start of program.");

        while (EntryValid == false) {
            System.out.println("Would you like to open a previous character, or create a new one?");
            System.out.println("Enter either 'continue' or 'new' to continue");
            UserChoice = input.next();

            if (UserChoice.equals("new")){
                System.out.println("Activate character creation method");
                EntryValid = true;

                System.out.println("Enter the characters name: ");
                EnteredName = input.next();

                // start of character creation method (using object creation) here.
                Character ActiveChar = new Character(EnteredName,1, 4, 3, 3, 3, 3, 3, 3, 3);
                ActiveChar.UpdateStats(ActiveChar);
                //With character created and statline initialized, begin the level up process.
                ActiveChar.LevelUpLoop(ActiveChar);
                // With the level up loop finished, upload the character to the database
                try{
                DBeaver.UploadCharacter(ActiveChar);
                }catch(SQLException e){
                    e.printStackTrace();
                }

            }
            if (UserChoice.equals("continue")){
                // IMPORTANT NOTE there is no condition to verify that the entered name does exist
                // and to handle the situation gracefully if one doesn't.
                System.out.println("Activate character import method");
                try{
                    ValidNames = DBeaver.RetrieveValidNames(ValidNames);
                }catch(SQLException e){
                    e.printStackTrace();
                }
                System.out.print("Characters which currently exist: ");

                while(true){
                    if (ValidNames[loopCount] == null){
                        break;
                    }
                    System.out.print(ValidNames[loopCount] + " ");
                    loopCount++;
                }
                loopCount = 0;
                System.out.println("");
                System.out.println("Enter the name of the character you are wanting to continue: ");
                while (NameExists == false) {
                    EnteredName = input.next();
                    // With the input recieved and valid names displayed, test to confirm that the character entered is valid
                    while(true){
                        if (EnteredName.equals(ValidNames[loopCount])){
                            NameExists = true;
                            break;
                        }
                        if (ValidNames[loopCount] == null){
                            loopCount = 0;
                            System.out.println("No character with that name exists. Enter a valid name: ");
                            break;
                        }
                        loopCount++;
                    }
                }
                //Create dummy ActiveChar to be turned into the downloaded character
                Character ActiveChar = new Character(EnteredName,1, 4, 3, 3, 3, 3, 3, 3, 3);
                try{
                ActiveChar = DBeaver.DownloadCharacter(EnteredName);
                }catch(SQLException e){
                    e.printStackTrace();
                }
                ActiveChar.UpdateStats(ActiveChar);
                System.out.println("Character succesfully imported. Now starting the level up process");


                //Update the charcter's spell queues to not include spells already known
                ActiveChar.UpdateSpellQueue(ActiveChar);
                //With the spell list updated, the leveling up can begin.
                ActiveChar.LevelUpLoop(ActiveChar);
                //Delete old version of the character to make room for the new one
                try{
                    DBeaver.DeleteCharacter(EnteredName);
                }catch(SQLException e){
                    e.printStackTrace();
                }
                try{
                    DBeaver.UploadCharacter(ActiveChar);
                }catch(SQLException e){
                    e.printStackTrace();
                }

                EntryValid = true;
            }
        }
        System.out.println("Thank you for using this program.");
    }



}

