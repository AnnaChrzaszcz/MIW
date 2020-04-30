import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BirthdayPerson {

    String name;
    String surname;
    LocalDate birthDate;
    Boolean gender;
    static int minAge = 4;
    List<BirthdayParty> birthdayParties; // cardinality "*"
    private static List<BirthdayPerson> birthdayPersonExtent = new ArrayList<>(); // 1. Ekstensja


    public BirthdayPerson(){
        this.birthdayParties = new ArrayList<BirthdayParty>();
    }

    public BirthdayPerson(String name, String surname, LocalDate birthDate, Boolean gender){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.birthdayParties = new ArrayList<BirthdayParty>();
        addBirhdayPerson(this);
    }

    private void addBirhdayPerson(BirthdayPerson birthdayPerson) {
        birthdayPersonExtent.add(birthdayPerson);
    }

    public static void removeBirhdayPerson(BirthdayPerson birthdayPerson) {
        birthdayPersonExtent.remove(birthdayPerson);
    }

    public void addBirthdayParty(BirthdayParty party){
        if(!this.birthdayParties.contains(party)){
            this.birthdayParties.add(party);
            party.setBirthdayPerson(this);
        }
    }

    public int getAge(){ // 7. atrybut pochodny
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
