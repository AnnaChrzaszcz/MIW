import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){ //pierwszy mini projekt

        Client client1 = new Client("c1", true);
        Client client2 = new Client("c2", true);
        Client client3 = new Client("c3", false);


        //1. ekstensja
        Client.showExtent();
        System.out.println("----------------------");

        //2. trwalosc ekstensji
        final String extentFile = "d:\\mas-extent.ser";

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Client.writeExtent(out);
            out.close();

            // Read the extent from the given stream
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(extentFile));
            Client.readExtent(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Client.showExtent();
        System.out.println("----------------------");

        //3.. atr. zlozony
        BirthdayParty birthdayParty1 = new BirthdayParty(LocalDate.now(), "cst123", 5);
        BirthdayParty birthdayParty2 = new BirthdayParty(LocalDate.of(2020,12,18), "cst10", 3);
        System.out.println("atrybut złożony: " + birthdayParty1.date);
        System.out.println("----------------------");

        //4. atr.opcjonalny - poprawic
        BirthdayParty birthdayParty3 = new BirthdayParty(LocalDate.now(), "cs90", null);
        if(birthdayParty3.getParentsMark() != null){
            System.out.println(birthdayParty3.parentsMark);
        }
       else{
            System.out.println("brak oceny");
        }

        //5. atr. powtarzalny
        List<String> gadgets = new ArrayList<>();
        gadgets.add("gadget1");
        gadgets.add("gadget2");
        BirthdayParty birthdayParty4 = new BirthdayParty( "cst34", gadgets );

        //6. atr. klasowy
        System.out.println("minimal age of all birthday persons: " + BirthdayPerson.minAge);
        System.out.println("----------------------");

        //7. atr. pochodny
        List<Animation> animations = new ArrayList<>();
        animations.add(new Animation());
        animations.add(new Animation());

        Animator animator = new Animator(animations);
        System.out.println(animator.getBonusSize());
        System.out.println("----------------------");


        //8. metoda klasowa - już poprawione
        System.out.println( Client.howManyVips() + " - number of VIPs");
        System.out.println("----------------------");

        //9. przesloniecie
        System.out.println(client2);
        System.out.println("----------------------");

        //10. przeciazenie
        Animator animator1 = new Animator();
        Animator animator2 = new Animator(animations);

        System.out.println();
        System.out.println("------------ MINI PROJEKT 2 ---------------");
        System.out.println();

        //M02 - asocjacje
        //1. zwykła
        // BirthdayPerson 1-*  BirthdayParty
        System.out.println("------------asocjacja zwykła---------------");
        BirthdayParty birthdayParty5 = new BirthdayParty( "cst34", gadgets );
        BirthdayPerson birthdayPerson = new BirthdayPerson("Jas", "Kowalski",  null, true);
        birthdayPerson.addBirthdayParty(birthdayParty5);

        //2. Z atrybutem
        //GastronomyWorker * - * Training (WorkerTraining)
        System.out.println("------------asocjacja z atrybutem---------------");

        Training training1 = new Training("kurs kawy", 20, "po tym kursie bedziecie krolami kawy" );
        Training training2 = new Training("kurs robienia pizzy", 50, "super kurs pizzy" );

        GastronomyWorker g = new GastronomyWorker(6, "Jan", "Kowal", "ccc1", 10, 17, null, null, null);

        WorkerTraining workerTraining1 = new WorkerTraining(LocalDate.now(), 5, g, training1);
        WorkerTraining workerTraining2 = new WorkerTraining(LocalDate.now(), 5, g, training2);

        //3. Kwalifikowana
        //BirthdayParty - Client (clientNumber)
        System.out.println("------------asocjacja kwalifikowana---------------");

        Client client9 = new Client("c3", false);
        BirthdayParty birthdayParty9 = new BirthdayParty(LocalDate.now(), "cst15", 5);
        birthdayParty9.addClientQualif(client9);

        System.out.println(birthdayParty9.findClientQualif("c3"));

        //4. Kompozycja 1-*
        //Room z wewnetrzna klasa Part
        System.out.println("------------kompozycja---------------");

        Room room = new Room("las", "salka wyglada jak las", 15);
        room.createPart("czesc1");
        room.createPart("czesc2");

        room.getParts().forEach(p -> System.out.println(p));

    }
}
