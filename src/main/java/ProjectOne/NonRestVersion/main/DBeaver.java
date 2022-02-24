package ProjectOne.NonRestVersion.main;

import ProjectOne.NonRestVersion.util.ConnectionUtil;
//import ProjectZero.util.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ProjectOne.NonRestVersion.main.JavaOpener.conn;

public class DBeaver {

    static void UploadEQPCharacter(EQPcharacter C)throws SQLException{

        // The only problem here is that it is an unhandled exception, but that will be handled later in the
        // JavaOpener class
        PreparedStatement statement = conn.prepareStatement(
                "Insert into EQPcharacters (character_name, character_level, weapon)" +
                        "Values" +
                        "(?,?,?)");
        int parameterIndex = 0;
        //I will have to look up have to use a Getter method created via annotation.
        statement.setString(++parameterIndex, C.getName());
        statement.setInt(++parameterIndex, C.getLevel());
        statement.setString(++parameterIndex, C.getWeapon());
        statement.executeUpdate();

        System.out.println("Character uploaded to database");
    }

    static void UploadWeapon (Weapon W) throws SQLException{
        PreparedStatement statement = conn.prepareStatement(
                "Insert into UniqueWeapons (Weapon_name, level_requirment, Base_type, Damage, Attack_speed, Parry_chance)" +
                        "Values" +
                        "(?,?,?,?,?,?)");
        int parameterIndex = 0;
        statement.setString(++parameterIndex, W.getWeapon_Name());
        statement.setInt(++parameterIndex, W.getLevel_Requirement());
        statement.setString(++parameterIndex, W.getBase_Type());
        statement.setInt(++parameterIndex, W.getDamage());
        // With these final two, there could possibly be a data type mismatch from Double turning into DEC.
        statement.setDouble(++parameterIndex, W.getAttack_Speed());
        statement.setDouble(++parameterIndex, W.getParry_Chance());
        statement.executeUpdate();
    }

    static void EquipWeapon (String C, String W) throws SQLException{
        PreparedStatement statement = conn.prepareStatement("UPDATE EQPcharacters SET weapon = ? WHERE character_name = ?"
        );
        int parameterIndex = 0;
        statement.setString(++parameterIndex, W);
        statement.setString(++parameterIndex, C);
        statement.executeUpdate();
        System.out.println("Character Updated");
    }


    static String[] RetrieveValidCharacterNames(String[] ValidCharacterNames) throws SQLException {
         // This function will retrieve a list of valid names of characters that
        // exist on the database.
        ResultSet ResultNames;
        String OutputName;
        int tableLength = 0;
        int loopCount = 0;
        PreparedStatement statement = conn.prepareStatement("Select COUNT(*) FROM EQPcharacters");
        ResultNames = statement.executeQuery();
        ResultNames.next();
        tableLength = ResultNames.getInt("");
        //ValidNames = new String[tableLength];
        statement = conn.prepareStatement("Select character_name from EQPcharacters");
        ResultNames = statement.executeQuery();

        while (loopCount < tableLength){
            ResultNames.next();
            OutputName = ResultNames.getString("character_name");
            ValidCharacterNames[loopCount] = OutputName;
            loopCount++;
        }
        //OutputNames = ResultNames.getString("character_name");
        return (ValidCharacterNames);
    }




    static String[] RetrieveValidWeaponNames(String[] ValidWeaponNames) throws SQLException {
        ResultSet ResultNames;
        String OutputName;
        int tableLength = 0;
        int loopCount = 0;
        PreparedStatement statement = conn.prepareStatement("Select COUNT(*) FROM UniqueWeapons");
        ResultNames = statement.executeQuery();
        ResultNames.next();
        tableLength = ResultNames.getInt("");
        statement = conn.prepareStatement("Select Weapon_name from UniqueWeapons");
        ResultNames = statement.executeQuery();

        while (loopCount < tableLength){
            ResultNames.next();
            OutputName = ResultNames.getString("Weapon_name");
            ValidWeaponNames[loopCount] = OutputName;
            loopCount++;
        }
        return (ValidWeaponNames);
    }




    static String[] RetrieveEquippedWeapons(String[] EquippedWeapons) throws SQLException {
        ResultSet ResultNames;
        String OutputName;
        int tableLength = 0;
        int loopCount = 0;
        PreparedStatement statement = conn.prepareStatement("Select COUNT(*) FROM EQPcharacters");
        ResultNames = statement.executeQuery();
        ResultNames.next();
        tableLength = ResultNames.getInt("");
        statement = conn.prepareStatement("Select weapon from EQPcharacters");
        ResultNames = statement.executeQuery();

        while (loopCount < tableLength){
            ResultNames.next();
            OutputName = ResultNames.getString("weapon");
            EquippedWeapons[loopCount] = OutputName;
            loopCount++;
        }
        return (EquippedWeapons);
    }


}
