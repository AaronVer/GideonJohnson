package ProjectZero.main;

import ProjectZero.util.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ProjectZero.main.OpeningClass.conn;


public class DBeaver {

    // This class will have two methods. One to upload a character onto the database, the other to retrieve a character
    // from the database. Fittingly named "UploadChar" and "DownloadChar".

    // In essence, this class will be characterDAO.

    static void UploadCharacter(Character C) throws SQLException {

        String ConvertedDestructionArray = "";
        String ConvertedRestorationArray = "";
        String ConvertedAmplificationArray = "";
        String RecievedName;
        int loopcount = 1;

        RecievedName = C.getName();


        //Convert the arrays into long strings
        ConvertedDestructionArray = ConvertedDestructionArray.concat(C.KnownDestructionSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownDestructionSpells[loopcount].equals("")) {
                ConvertedDestructionArray = ConvertedDestructionArray.concat(C.KnownDestructionSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
            // Potential problem: This will cause the string to end with a coma. I don't think this will
            // actually be a problem later on because of the input function, but it might be.

        }

        ConvertedRestorationArray = ConvertedRestorationArray.concat(C.KnownRestorationSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownRestorationSpells[loopcount].equals("")) {
                ConvertedRestorationArray = ConvertedRestorationArray.concat(C.KnownRestorationSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
        }

        ConvertedAmplificationArray = ConvertedAmplificationArray.concat(C.KnownAmplificationSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownAmplificationSpells[loopcount].equals("")) {
                ConvertedAmplificationArray = ConvertedAmplificationArray.concat(C.KnownAmplificationSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
        }

        // if the above procedures worked correctly, then the arrays should all be converted into strings to use.

        PreparedStatement statement = conn.prepareStatement(
                "Insert into savedcharacters (character_name, character_level, constitution, dexterity, strength, wisdom, fortitude, resilience, atr_precision, reflex, known_destruction_spells, known_restoration_spells, known_amplification_spells)" +
                        "Values" +
                        "(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        int parameterIndex = 0;
        //With the parameter index to cycle between the rows, set each of the row's content to a property
        // of the imported object.
        statement.setString(++parameterIndex, C.getName());
        statement.setInt(++parameterIndex, C.getLevel());
        statement.setInt(++parameterIndex, C.getConstitution());
        statement.setInt(++parameterIndex, C.getDexterity());
        statement.setInt(++parameterIndex, C.getStrength());
        statement.setInt(++parameterIndex, C.getWisdom());
        statement.setInt(++parameterIndex, C.getFortitude());
        statement.setInt(++parameterIndex, C.getResilience());
        statement.setInt(++parameterIndex, C.getPrecision());
        statement.setInt(++parameterIndex, C.getReflex());
        statement.setString(++parameterIndex, ConvertedDestructionArray);
        statement.setString(++parameterIndex, ConvertedRestorationArray);
        statement.setString(++parameterIndex, ConvertedAmplificationArray);
        //Once I added the line below, the errors began again.
        statement.executeUpdate();
        // That should be all information uploaded now

        System.out.println("Character has been successfully uploaded onto the SQL database.");
    }

    // Download character function
    static Character DownloadCharacter(String name) throws SQLException {
        Character Target = null;
        PreparedStatement statement = conn.prepareStatement("Select * from savedcharacters Where character_name = ?");
        int parameterIndex = 0;
        String DestructionString = "";
        String RestorationString = "";
        String AmplificationString = "";
        String[] SplitDestructionArray;
        String[] SplitRestorationArray;
        String[] SplitAmplificationArray;
        int LoopCount = 0;
        statement.setString(++parameterIndex, name);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            // This is peace-meal creating a new character object. It starts with the standard syntax for
            // the constructor, but instead of straight-forward values inside of the parenthese, it is using
            // the results of the getString and getInt statements.
            Target = new Character(name, rs.getInt("character_level"), rs.getInt("constitution"),
                    rs.getInt("dexterity"), rs.getInt("strength"), rs.getInt("fortitude"),
                    rs.getInt("wisdom"), rs.getInt("resilience"),
                    rs.getInt("atr_precision"), rs.getInt("reflex"));
            DestructionString = rs.getString("known_destruction_spells");
            RestorationString = rs.getString("known_restoration_spells");
            AmplificationString = rs.getString("known_amplification_spells");
        }
        // Okay, now here's the issue. The new object was succesfully made, but the know spell arrays
        // are still "" in all slots. So the last thing I need to do is modify the arrays.

        //Target.KnownDestructionSpells[0] = "Fireball";

        // I am going to attempt to use a Split command to split the single string into many (seperating on commas)
        // and assign it to the array.
        SplitDestructionArray = DestructionString.split(",", 10);
        SplitRestorationArray = RestorationString.split(",", 10);
        SplitAmplificationArray = AmplificationString.split(",", 10);

        while (LoopCount < SplitDestructionArray.length) {
            Target.KnownDestructionSpells[LoopCount] = SplitDestructionArray[LoopCount];
            LoopCount++;
        }
        LoopCount = 0;
        while (LoopCount < SplitRestorationArray.length) {
            Target.KnownRestorationSpells[LoopCount] = SplitRestorationArray[LoopCount];
            LoopCount++;
        }
        LoopCount = 0;
        while (LoopCount < SplitAmplificationArray.length) {
            Target.KnownAmplificationSpells[LoopCount] = SplitAmplificationArray[LoopCount];
            LoopCount++;
        }
        System.out.println("First slot amplification spells: " + Target.KnownAmplificationSpells[0]);
        rs.close();
        return Target;
    }

    static void UpdateCharacter(Character C) throws SQLException {

        String ConvertedDestructionArray = "";
        String ConvertedRestorationArray = "";
        String ConvertedAmplificationArray = "";
        String RecievedName;
        int loopcount = 1;

        RecievedName = C.getName();

        System.out.println("Name that was recieved from object and command: " + RecievedName);
        System.out.println("Level that was recieved from object and command: " + C.getLevel());

        //Convert the arrays into long strings
        ConvertedDestructionArray = ConvertedDestructionArray.concat(C.KnownDestructionSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownDestructionSpells[loopcount].equals("")) {
                ConvertedDestructionArray = ConvertedDestructionArray.concat(C.KnownDestructionSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
            // Potential problem: This will cause the string to end with a coma. I don't think this will
            // actually be a problem later on because of the input function, but it might be.

        }

        ConvertedRestorationArray = ConvertedRestorationArray.concat(C.KnownRestorationSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownRestorationSpells[loopcount].equals("")) {
                ConvertedRestorationArray = ConvertedRestorationArray.concat(C.KnownRestorationSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
        }

        ConvertedAmplificationArray = ConvertedAmplificationArray.concat(C.KnownAmplificationSpells[0]).concat(", ");

        while (true) {
            if (!C.KnownAmplificationSpells[loopcount].equals("")) {
                ConvertedAmplificationArray = ConvertedAmplificationArray.concat(C.KnownAmplificationSpells[loopcount]).concat(", ");
                loopcount++;
            } else {
                break;
            }
        }

        // if the above procedures worked correctly, then the arrays should all be converted into strings to use.

        //(character_name, character_level, constitution, dexterity, strength, wisdom, fortitude, resilience, atr_precision,
        // //reflex, known_destruction_spells, known_restoration_spells, known_amplification_spells)"
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE saved_characters SET character_level = ?, constitution = ?, dexterity = ?, strength = ?, wisdom = ?, fortitude = ?, resilience = ?, atr_precision = ?, reflex = ?, known_destruction_spells = ?, known_restoration_spells = ?, known_amplification_spells = ?" +
                        "WHERE character_name = " + C.getName());
        int parameterIndex = 0;
        //With the parameter index to cycle between the rows, set each of the row's content to a property
        // of the imported object.
        statement.setInt(++parameterIndex, C.getLevel());
        statement.setInt(++parameterIndex, C.getConstitution());
        statement.setInt(++parameterIndex, C.getDexterity());
        statement.setInt(++parameterIndex, C.getStrength());
        statement.setInt(++parameterIndex, C.getWisdom());
        statement.setInt(++parameterIndex, C.getFortitude());
        statement.setInt(++parameterIndex, C.getResilience());
        statement.setInt(++parameterIndex, C.getPrecision());
        statement.setInt(++parameterIndex, C.getReflex());
        statement.setString(++parameterIndex, ConvertedDestructionArray);
        statement.setString(++parameterIndex, ConvertedRestorationArray);
        statement.setString(++parameterIndex, ConvertedAmplificationArray);
        //statement.setString(++parameterIndex, C.getName());
        //Once I added the line below, the errors began again.
        statement.executeUpdate();
        // That should be all information uploaded now

        System.out.println("Character has been successfully updated.");
    }

    static void DeleteCharacter(String Name) throws SQLException {
        int parameterIndex = 0;
        PreparedStatement statement = conn.prepareStatement("DELETE FROM savedcharacters Where character_name= ?");
        statement.setString(++parameterIndex, Name);
        statement.executeUpdate();
    }

    static String[] RetrieveValidNames(String[] ValidNames) throws SQLException {
         // This function will retrieve a list of valid names of characters that
        // exist on the database.
        ResultSet ResultNames;
        String OutputName;
        int tableLength = 0;
        int loopCount = 0;
        PreparedStatement statement = conn.prepareStatement("Select COUNT(*) FROM savedcharacters");
        //PreparedStatement statement = conn.prepareStatement("Select character_name from savedcharacters");
        ResultNames = statement.executeQuery();

        //Apparently the command "RS.Next()" is used to cycle between rows.
        // So set up a while loop to fetch the name from the current row, stick it in an array, then move onto the next row.
        ResultNames.next();
        tableLength = ResultNames.getInt("");
        //ValidNames = new String[tableLength];
        statement = conn.prepareStatement("Select character_name from savedcharacters");
        ResultNames = statement.executeQuery();

        while (loopCount < tableLength){
            ResultNames.next();
            OutputName = ResultNames.getString("character_name");
            ValidNames[loopCount] = OutputName;
            loopCount++;
        }
        //OutputNames = ResultNames.getString("character_name");
        return (ValidNames);
    }
}