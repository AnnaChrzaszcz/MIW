public abstract class Employee {

    int idEmployee;
    String name;
    String surname;
    String contractNumber;
    State state; //przypomniec sobie
    int availability;
    public static int salary = 17; //per hour, atrybut klasowy
    Integer bonus; //opcjonalny

    public Employee(){

    }

    public Employee(int idEmployee, String name,String surname, String contractNumber, int availability, Integer bonus, State state)
    {
       this.idEmployee = idEmployee;
       this.name = name;
       this.surname = surname;
       this.contractNumber = contractNumber;
        //this.state; //przypomniec sobie
       this.availability = availability;
        this.state = state;
        if(bonus != null){
            this.bonus = bonus;
        }
    }

    @Override
    public String toString() { //przesłonięcie
        return this.name + ' ' + this.surname;
    }
}
