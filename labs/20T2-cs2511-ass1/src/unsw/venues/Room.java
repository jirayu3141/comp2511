package unsw.venues;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Room {
    private String name;
    private String size;

    public Room(String name, String size) {
        this.name = name;
        this.size = size;
    }

    /**
     * getter method for the name of the room
     * 
     * @return name of room
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for size of the room
     * 
     * @return size of the room
     */
    public String getSize() {
        return size;
    }

    /**
     * get all of the booking for this room
     * 
     * @return sorted reuslt of bookings for this room
     */
    public List<Booking> getBookings() {
        List<Booking> roomBookings = VenueHireSystem.bookings.stream().filter(n -> n.getRooms().contains(this))
                .collect(Collectors.toList());

        Collections.sort(roomBookings, (x, y) -> x.start.compareTo(y.start));
        return roomBookings;
    }

    @Override
    public String toString() {
        return getName();
    }
}
