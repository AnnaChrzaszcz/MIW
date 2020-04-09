import java.util.ArrayList;
import java.util.List;

public class Coordinator extends Employee {

    List<BirthdayParty> birthdayParties;

    public Coordinator(int idEmployee, String name, String surname, String contractNumber, int availability, Integer bonus, State state) {
        super(idEmployee, name, surname, contractNumber, availability, bonus, state);
        this.birthdayParties = new ArrayList<>();
    }

}
