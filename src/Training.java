import java.util.List;

public class Training {
    String name;
    int prize;
    String description;
    List<WorkerTraining> workerTrainings;

    public Training(String name, int prize, String description){
        this.name = name;
        this.prize = prize;
        this.description = description;
    }

    public void addWorkerTraining(WorkerTraining workerTraining) {
        if(!this.workerTrainings.contains(workerTraining)){
            this.workerTrainings.add(workerTraining);
            workerTraining.setTraining(this);
        }

    }
}
