import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room {

    String name;
    String description;
    int seatsNumber;
    private static List<Room> roomExtent = new ArrayList<>();
    List<Part> parts = new ArrayList<>();

    public Room(String name, String description, int seatsNumber){
        this.name = name;
        this.description = description;
        this.seatsNumber = seatsNumber;
        addRoom(this);
    }

    private static void addRoom(Room room) {
        roomExtent.add(room);
    }

    public static void removeRoom(Room room) {
        roomExtent.remove(room);
        System.out.println("I remove room: " + room.name);
    }


    public List<Part> getParts() {
        return parts;
    }

    public Part createPart(String partName) {
        Part part = new Part(partName);
        parts.add(part);
        return part;
    }

    // The inner class (the part).
    public class Part {
        private String partName;
        // Because of Java inner class properties, we do not need a reference pointing at the whole.

        public Part(String partName) {
            this.partName = partName;
        }

        @Override
        public String toString() {
            return "Part: " + partName;
        }
    }
}
