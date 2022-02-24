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
@Table(name = "Weapons")
@Data
// Giving the class object a whole slew of methods
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    @Id
    String Weapon_Name;
    @Column
    int Level_Requirement;
    @Column
    String Base_Type;
    @Column
    int Damage;
    @Column
    double Attack_Speed;
    @Column
    double Parry_Chance;

    public Weapon InitializeStats (Weapon O){

        // In the future, this should be done by checking the stats of the base items from
        // an online database. But for now, I'm doing by hard coding these values.
        if(this.Base_Type.equals("Bronze_Sword")){
            this.Level_Requirement = 1;
            this.Damage = 5;
            this.Attack_Speed = 1.5;
            this.Parry_Chance = 7.0;
        }
        if(this.Base_Type.equals("Iron_Sword")){
            this.Level_Requirement = 5;
            this.Damage = 15;
            this.Attack_Speed = 1.2;
            this.Parry_Chance = 7.0;
        }
        if(this.Base_Type.equals("Steel_Sword")){
            this.Level_Requirement = 12;
            this.Damage = 24;
            this.Attack_Speed = 1.2;
            this.Parry_Chance = 8.0;
        }

        return(O);
    }
}
