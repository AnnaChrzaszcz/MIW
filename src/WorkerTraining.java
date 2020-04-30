import java.time.LocalDate;

public class WorkerTraining {
    LocalDate date;
    Integer mark;
    GastronomyWorker worker;
    Training training;

    public WorkerTraining(LocalDate date, Integer mark, GastronomyWorker worker, Training training){
        this.date = date;
        this.mark = mark;
        this.setWorker(worker);
        this.training = training;
    }

    public void setWorker(GastronomyWorker gastronomyWorker){
        if(this.worker == null){
            this.worker = gastronomyWorker;
            gastronomyWorker.addWorkerTraining(this);
        }
    }

    public void setTraining(Training training){
        if(this.training == null){
            this.training = training;
            training.addWorkerTraining(this);
        }
    }
}
