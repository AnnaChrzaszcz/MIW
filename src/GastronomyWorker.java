public class GastronomyWorker extends Employee {

    Position position;

    public GastronomyWorker(int idEmployee, String name, String surname, String contractNumber, int availability, int salaray, Integer bonus, State state, Position position){
        super(idEmployee, name, surname, contractNumber, availability, bonus, state);
        this.position = position;
    }
}
