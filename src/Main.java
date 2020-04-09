import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
        System.out.println( Client.clientExtentSize());
        System.out.println("----------------------");

        //9. przesloniecie
        System.out.println(client2);
        System.out.println("----------------------");

        //10. przeciazenie
        Animator animator1 = new Animator();
        Animator animator2 = new Animator(animations);

    }
}
