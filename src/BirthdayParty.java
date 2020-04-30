import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BirthdayParty {
    LocalDate date;
    int beginingHour;
    String contractNumber;
    List<String> birthdayGadgets;
    int childrenNumber;
    Integer parentsMark;
    Room room;
    Pack pack;

    Coordinator coordinator;
    List<Animation> animations; //od 0 do 2
    List<CulinaryWorkshops> culinaryWorkshops; //od 0 do 1
    BirthdayPerson birthdayPerson; // implementation of an association, cardinality "1"
    Client client;

    private Map<String, Client> clientsQualif = new TreeMap<>();
    private static List<BirthdayParty> birthdayPartyExtent = new ArrayList<>(); // 1. Ekstensja

    public BirthdayParty(LocalDate date, String contractNumber, Integer parentsMark){
        this.date = date;
        this.contractNumber = contractNumber;
        this.parentsMark = parentsMark;
        addBirthdayParty(this);
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
        this.client = client;
        this.setBirthdayPerson(birthdayPerson);
    }

    private static void addBirthdayParty(BirthdayParty birthdayParty){
        birthdayPartyExtent.add(birthdayParty);
    }

    private static void removeBirthdayParty(BirthdayParty birthdayParty){
        birthdayPartyExtent.remove(birthdayParty);
    }

    public void assignCoordinator(Coordinator coordinator){
        this.coordinator = coordinator;
    }

    public void setParentsMark(int mark){
        this.parentsMark = mark;
    }

    public Integer getParentsMark(){
            return this.parentsMark;
    }

    public void setBirthdayPerson(BirthdayPerson birthdayPerson) {
        if(this.birthdayPerson == null){
            this.birthdayPerson = birthdayPerson;
            birthdayPerson.addBirthdayParty(this);
        }
    }

    public void addClientQualif(Client newClient) {
        // Check if we already have the info
        if(!clientsQualif.containsKey(newClient.clientNumber)) {
            clientsQualif.put(newClient.clientNumber, newClient);

            // Add the reverse connection
            newClient.addBirthdayParty(this);
        }
    }

    public Client findClientQualif(String clientNumber) {
        // Check if we have the info
        if(!clientsQualif.containsKey(clientNumber)) {
            return null;
        }
        return clientsQualif.get(clientNumber);
    }
}
