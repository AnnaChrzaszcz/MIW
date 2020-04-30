import java.util.ArrayList;
import java.util.List;

public class GastronomyWorker extends Employee { // odpowiedni konstruktor dla klasy pośredniczącej, który dla podanych obiektów "zewnętrznych" stworzy wszystkie wymagane połaczenia (referencje pokazujące na zewnątrz oraz kolekcje pokazujące na środek).

    Position position;
    List<WorkerTraining> workerTrainings;

    public GastronomyWorker(int idEmployee, String name, String surname, String contractNumber, int availability, int salaray, Integer bonus, State state, Position position){
        super(idEmployee, name, surname, contractNumber, availability, bonus, state);
        this.position = position;
        this.workerTrainings = new ArrayList<>();
    }

    public void addWorkerTraining(WorkerTraining workerTraining){
        if(!this.workerTrainings.contains(workerTraining)){
            this.workerTrainings.add(workerTraining);
            workerTraining.setWorker(this);
        }

    }
}
