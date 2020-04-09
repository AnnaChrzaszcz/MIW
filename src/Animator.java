import java.util.ArrayList;
import java.util.List;

public class Animator extends Employee {

    String description;
    List<Animation> animations;

    public Animator(){

    }

    public Animator(List<Animation> animations){
        this.animations = animations;
    }

    public Animator(int idEmployee, String name, String surname, String contractNumber, int availability, int salaray, Integer bonus, State state, String description) {
        super(idEmployee, name, surname, contractNumber, availability, bonus, state);
        this.description = description;
        this.animations = new ArrayList<>();
    }

    public int getBonusSize(){
        return this.numberOfAnimations()>5 ? 100 : 0; //7. atrybut pochodny
    }

    public int numberOfAnimations(){
        return animations.size();
    }
}
