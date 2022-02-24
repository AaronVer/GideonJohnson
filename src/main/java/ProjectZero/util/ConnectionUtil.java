package ProjectZero.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn;
    private ConnectionUtil(){
    }

    public static Connection getConnection() {
        try {
            //Change this to be for my computer
            FileInputStream propertiesInput = new FileInputStream("C:\\Users\\Gideon\\Documents\\Revature\\sql.properties.txt");

            Properties props = new Properties();
            props.load(propertiesInput);

            String url = (String) props.get("url");
            String username = (String) props.get("username");
            String password = (String) props.get("password");

            // I think I should double-check this from GitHub, as there doesn't seem to be a way for this to not
            // be null.
            if (conn == null) {
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

}