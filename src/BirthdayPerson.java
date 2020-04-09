import java.time.LocalDate;
import java.time.Period;

public class BirthdayPerson {

    String name;
    String surname;
    LocalDate birthDate;
    Boolean gender;
    static int minAge = 4;              // 6. atrybut klasowy

    public BirthdayPerson(){

    }

    public BirthdayPerson(String name, String surname, LocalDate birthDate, Boolean gender){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getAge(){ // 7. atrybut pochodny
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
