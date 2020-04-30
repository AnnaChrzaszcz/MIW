import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable{

    String clientNumber;
    Boolean isVip;
    double wysokoscRabatu;
    List<BirthdayParty> birthdayParties;

    private static List<Client> clientExtent = new ArrayList<>(); // 1. Ekstensja


    public Client(String clientNumber, Boolean isVip){
        this.clientNumber = clientNumber;
        this.isVip = isVip;
        wysokoscRabatu = (this.numberOfBirthdays() >= 3) ? 0.2 : (this.numberOfBirthdays() == 2) ? 0.1 : 0.0;
        this.birthdayParties = new ArrayList<>();
        addClient(this); //dodanie do ekstensji
    }

    public int numberOfBirthdays(){
        return 0; //pozniej ilosc odbytych urodzin
    }

    private static void addClient(Client client) { //8. metoda klasowa
        clientExtent.add(client);
    }

    public static void removeClient(Client client) {
        clientExtent.remove(client);
        System.out.println("I remove client: " + client.clientNumber);
    }

    public static Integer clientExtentSize(){
        return clientExtent.size();
    }

    public static Integer howManyVips(){ //metoda klasowa
        return clientExtent.stream().filter(cl -> cl.isVip).toArray().length;
    }

    public static void showExtent() {

        System.out.println("Extent of the class: " + Client.class.getName());

        for (Client client : clientExtent) {
            System.out.println(client);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(clientExtent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        clientExtent = (ArrayList<Client>) stream.readObject();
    }

    public String toString(){
        return "clients number: " + this.clientNumber + (this.isVip ? " (client VIP)" : " ");
    }

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        if(!birthdayParties.contains(birthdayParty)){
            this.birthdayParties.add(birthdayParty);
            birthdayParty.addClientQualif(this);
        }
    }
}
