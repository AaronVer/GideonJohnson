package ProjectOne.NonRestVersion.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Connecting object to database
@Entity
@Table(name = "EQPcharacters")
@Data
// Giving the class object a whole slew of methods
@AllArgsConstructor
@NoArgsConstructor
public class EQPcharacter {
    // I believe Id is for the primary key, it might be limited
    // to Ints, we will have to see
    @Id
    private String Name;
    @Column
    private int Level;
    @Column
    private String weapon;


    //Constructor. This removes the need for the AllArgsConstuctor.
    //public EQPcharacter(String Name, int Level, String Weapon){

    //}

    public String ObtainName() { return Name; }
}
