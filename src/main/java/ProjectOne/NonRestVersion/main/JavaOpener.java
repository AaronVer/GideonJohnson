package ProjectOne.NonRestVersion.main;

import java.util.Scanner;

import ProjectOne.NonRestVersion.main.DBeaver;
import com.revature.util.ConnectionUtil;
import javax.naming.Name;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import java.util.Scanner;

import static ProjectOne.NonRestVersion.main.DBeaver.EquipWeapon;

// String[] KnownDestructionSpells = {"", "", "", "", "", "", "", "", ""};

// This class is what will be used to run the program in Java, and will be dropped as I convert this
// program into using REST.
public class JavaOpener {

    //static String[] ValidWeaponNames = {"Bronze_Sword", "Iron_Sword", "Steel_Sword"};
    public static Connection conn = ConnectionUtil.getConnection();


    public static void main(String[] args) {
        String[] ValidBaseTypes = {"Bronze_Sword", "Iron_Sword", "Steel_Sword"};
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String EnteredOption;
        String EnteredName = "";
        String EnteredBase = "";
        String Blank = "";
        int LoopCount = 0;
        int iZero = 0;
        double dZero = 0.0;
        Boolean ValidEntry = false;
        int EnteredLevel;

        int UsedEquipmentCount = 0;
        int EquipmentCount = 0;
        boolean EquipmentMatched = false;
        int TargetUnusedSlot = 0;

        String[] ValidCharacterNames = new String[50];
        String[] ValidWeaponNames = new String[100];
        String[] EquippedWeapons = new String[100];
        String[] UnusedWeapons = new String[100];

        //Starting off, I'm going to retrieve the names of all the characters and weapons right away
        System.out.println("Retrieve character names");
        try{
            ValidCharacterNames = DBeaver.RetrieveValidCharacterNames(ValidCharacterNames);
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Retrieve weapon names");
        try{
            ValidWeaponNames = DBeaver.RetrieveValidWeaponNames(ValidWeaponNames);
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Retrieve equipped names");
        try{
            EquippedWeapons = DBeaver.RetrieveEquippedWeapons(EquippedWeapons);
        }catch(SQLException e){
            e.printStackTrace();
        }

        // Now I need to figure out a process which compares every slot in ValidWeaponNames and EquippedWeapons
        // and whenever there is one that ISN'T a match, it writes it down in Unused weapons.

        // Do that process here.
        //
        while (EquipmentCount < ValidWeaponNames.length){
            while (UsedEquipmentCount < EquippedWeapons.length){
                if (ValidWeaponNames[EquipmentCount] == EquippedWeapons[UsedEquipmentCount]){
                    EquipmentMatched = true;
                }
                UsedEquipmentCount++;
            }
            // If it has reached this point with "EquipmentMatched" still being false, then that means
            // that the current EquipmentCount was not on the EquippedWeapons array. So add it to the
            //UnusedWeapons
            if (EquipmentMatched == false){
                UnusedWeapons[TargetUnusedSlot] = ValidWeaponNames[EquipmentCount];
                TargetUnusedSlot++;
            }
            EquipmentCount++;
            UsedEquipmentCount = 0;
        }



        while(true){
            System.out.println("Enter what you want to do: ");
            EnteredOption = input.next();

            if(EnteredOption.equals("MakeNewCharacter")){
                // Activate new character function

                // I can actually do this without the need for a new method
                System.out.println("Enter the name for the character: ");
                EnteredName = input.next();
                System.out.println("Enter the level of the character: ");
                EnteredLevel = input.nextInt();
                EQPcharacter ActiveChar = new EQPcharacter(EnteredName, EnteredLevel, Blank);
                System.out.println("Object created");
                // Now I'll upload the character

                 try{
                                DBeaver.UploadEQPCharacter(ActiveChar);
                                }catch(SQLException e){
                                    e.printStackTrace();
                                }
                break;
            }
            if(EnteredOption.equals("MakeNewWeapon")){
                // Activate new weapon function
                //Get valid weapon
                while (!ValidEntry){
                    System.out.println("Enter the base type for the weapon. Valid enteries are Bronze_Sword, Iron_Sword, Steel_Sword");
                    EnteredBase = input.next();
                    while(LoopCount < ValidBaseTypes.length){
                        if(EnteredBase.equals(ValidBaseTypes[LoopCount])){
                            ValidEntry = true;
                        }
                        LoopCount++;
                    }
                    if(!ValidEntry){
                        System.out.println("Invalid name chosen");
                    }
                }
                // Input has been confirmed. Create weapon object.
                System.out.println("Enter custom name for weapon:");
                EnteredName = input.next();
                Weapon ActiveWeapon = new Weapon(EnteredName, iZero, EnteredBase,iZero,dZero,dZero);
                //Run method to update stats appropriatly.
                ActiveWeapon.InitializeStats(ActiveWeapon);
                //Now I can upload it.
                 try{
                                DBeaver.UploadWeapon(ActiveWeapon);
                               }catch(SQLException e){
                                    e.printStackTrace();
                                }
                break;
            }
            if(EnteredOption.equals("EquipCharacter")){
                // Activate equip character function

                // This function will be a bit trickier as I will need to maintain
                // a one-to-many integrety to ensure no weapon is equipped by more than one character.
                // To do this, I must run three functions to retrieve database information. The first
                // to place all the character names into an array, second to retrieve all the weapon names,
                // and a third to retrieve all the weapon names that are currently held by a character.
                // Then, an array can be made with all the weapons that are on the weapon list, but not on the
                // wielded weapon list.
                System.out.print("Choose a weapon: ");
                System.out.println("");
                LoopCount = 0;
                while(LoopCount < UnusedWeapons.length){
                    if(UnusedWeapons[LoopCount] != null){
                        System.out.print(UnusedWeapons[LoopCount] + " ");
                    } else {
                        break;
                    }
                    LoopCount++;
                }
                EnteredName = input.next();

                LoopCount = 0;
                System.out.print("Choose a character: ");
                System.out.println("");

                while(LoopCount < ValidCharacterNames.length){
                    if(ValidCharacterNames[LoopCount] != null){
                        System.out.print(ValidCharacterNames[LoopCount] + " ");
                    } else {
                        break;
                    }
                    LoopCount++;
                }
                EnteredBase = input.next();

                try {
                    EquipWeapon(EnteredName, EnteredBase);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            }


        }
    }

}
