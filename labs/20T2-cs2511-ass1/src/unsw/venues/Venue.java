package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Venue {
    private String name;
    private List<Room> rooms;

    public Venue(String name, String room, String size) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
        this.rooms.add(new Room(room, size));

    }

    /**
     * 
     * @return name of the venue
     */
    public String getName() {
        return name;
    }

    /**
     * add new room to the venue
     * 
     * @param name of the room
     * @param size of the room
     */
    public void addRoom(String name, String size) {
        rooms.add(new Room(name, size));
    }

    /**
     * get all of the room in this venue object
     * 
     * @return list of all the rooms
     */
    public List<Room> getRoom() {
        return this.rooms;
    }

    /**
     * get all of the bookings made for this venue
     * 
     * @return list of bookings for this venue
     */
    public List<Booking> getBooking() {
        List<Booking> allBooking = VenueHireSystem.bookings;
        List<Booking> currectVenueBookings = allBooking.stream().filter(booking -> booking.getVenueName().equals(name))
                .collect(Collectors.toList());

        return currectVenueBookings;
    }

    /**
     * get a list of occupied room for the specifed time
     * 
     * @param start start date of the search
     * @param end   date of the search
     * @return list of occupied rooms
     */
    private List<Room> getOccupiedRooms(LocalDate start, LocalDate end) {
        List<Booking> bookings = getBooking();
        List<Room> occupiedRooms = new ArrayList<Room>();
        // check for overlapping
        for (Booking x : bookings) {
            // check overalaps (true is overlapping)
            if ((x.getStart().isBefore(end) || x.getStart().isEqual(end))
                    && (x.getEnd().isAfter(start) || x.getEnd().isEqual(start))) {
                occupiedRooms.addAll(x.getRooms());
            }
        }
        return occupiedRooms;
    }

    /**
     * search for all of the available room for the period
     * 
     * @param start date of the search
     * @param end   date of the search
     * @return list of all available rooms
     */
    // get all available room for the specified dates
    public List<Room> getAvailableRoom(LocalDate start, LocalDate end) {
        List<Room> avaiRooms = new ArrayList<Room>(rooms); // every room in this venue
        avaiRooms.removeAll(getOccupiedRooms(start, end)); // remove occupied rooms
        return avaiRooms;
    }

    /**
     * search for small available room
     * 
     * @param start date of the serach
     * @param end   date of the search
     * @return list of small room available
     */
    public List<Room> smallAvai(LocalDate start, LocalDate end) {
        List<Room> avaiRooms = getAvailableRoom(start, end);
        List<Room> smallRooms = avaiRooms.stream().filter(small -> small.getSize().equals("small"))
                .collect(Collectors.toList());
        return smallRooms;
    }

    /**
     * serach for medium room available
     * 
     * @param start date of the search
     * @param end   date of the search
     * @return list of large room available
     */
    public List<Room> medAvai(LocalDate start, LocalDate end) {
        List<Room> avaiRooms = getAvailableRoom(start, end);
        List<Room> mediumRooms = avaiRooms.stream().filter(medium -> medium.getSize().equals("medium"))
                .collect(Collectors.toList());
        return mediumRooms;
    }

    /**
     * search for large room available
     * 
     * @param start date of the search
     * @param end   date of the search
     * @return list of large room available
     */
    public List<Room> largeAvai(LocalDate start, LocalDate end) {
        List<Room> avaiRooms = getAvailableRoom(start, end);
        List<Room> largeRooms = avaiRooms.stream().filter(large -> large.getSize().equals("large"))
                .collect(Collectors.toList());
        return largeRooms;
    }

    @Override
    public String toString() {
        return getName();
    }

}
