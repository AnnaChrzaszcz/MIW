import java.time.LocalDate;
import java.util.List;

public class BirthdayParty {
    LocalDate date;             //3. atrybut złożony
    int beginingHour;
    String contractNumber;
    List<String> birthdayGadgets; //5. atrybut powtarzalny
    int childrenNumber;
    Integer parentsMark;        //4. atrybut opcjonalny
    Room room;                  //3. atrybut złożony
    Pack pack;                  //3. atrybut złożony

    Coordinator coordinator;
    List<Animation> animations; //od 0 do 2
    List<CulinaryWorkshops> culinaryWorkshops; //od 0 do 1
    BirthdayPerson birthdayPerson;
    Client client;

    public BirthdayParty(LocalDate date, String contractNumber, Integer parentsMark){
        this.date = date;
        this.contractNumber = contractNumber;
        this.parentsMark = parentsMark;
    }

    public BirthdayParty(String contractNumber, List<String> birthdayGadgets){
        this.contractNumber = contractNumber;
        this.birthdayGadgets = birthdayGadgets;
    }

    public BirthdayParty(LocalDate date, int beginingHour, String contractNumber, List<String> birthdayGadgets, int childrenNumber, Room room, Pack pack, Coordinator coordinator, List<Animation> animations, List<CulinaryWorkshops> culinaryWorkshops, BirthdayPerson birthdayPerson, Client client){
        this.date = date;
        this.beginingHour = beginingHour;
        this.contractNumber = contractNumber;
        this.birthdayGadgets = birthdayGadgets;
        this.childrenNumber = childrenNumber;
        this.room = room;
        this.pack = pack;
        this.coordinator = coordinator;
        this.animations = animations;
        this.culinaryWorkshops = culinaryWorkshops;
        this.birthdayPerson = birthdayPerson;
        this.client = client;
    }

    public void assignCoordinator(Coordinator coordinator){
        this.coordinator = coordinator;
    }

    public void setParentsMark(int mark){
        this.parentsMark = mark;
    }

    public Integer getParentsMark(){
        if(this.parentsMark != null){
            return this.parentsMark;
        }
        else return null;
    }

}
