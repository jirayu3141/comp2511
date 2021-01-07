package unsw.venues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Booking {
    String id;
    LocalDate start;
    LocalDate end;
    int small;
    int medium;
    int large;
    Venue venue;
    List<Room> rooms;


    public Booking(String id, LocalDate start, LocalDate end, int small, int medium, int large) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.rooms = new ArrayList<Room>();
    }

    /**
     * getter method for the id
     * @return id of the booking
     */
    public String getId() {
        return id;
    }

    /**
     * gettter method for the start date of the booking
     * @return start date of the booking
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * getter method for end date of the booking
     * @return end date of the booking
     */
    public LocalDate getEnd() {
        return end;
    }


    /**
     * getter method for getting the number of small room for this booking
     * @return number of small rooms
     */
    public int getSmall() {
        return small;
    }

    /**
     * getter method for getting the number of medium room for this booking
     * @return number of mediun rooms
     */
    public int getMed() {
        return medium;
    }

    /**
     * getter method for getting the number of large room for this booking
     * @return number of large rooms
     */
    public int getLarge() {
        return large;
    }

    /**
     * getter method for getting the venue of the booking
     * @return venue of the booking
     */
	public Venue getVenue() {
        return venue;
    }

    /**
     * getter method for the rooms that was assigned to this booking
     * @return list of rooms assigned
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * getter method for getting the venue name
     * @return name of the venue
     */
    public String getVenueName() {
        return venue.getName();
    }

    /**
     * setter method for setting the venue of this booking
     * @param venue venue to be set to be associated with this booking
     */
	public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * assign room to the booking
     * @param rooms 
     * @param no number of rooms
     */
    // assign n small room
	public void assignRoom(List<Room> rooms, int no) {
        for (int i = 0; i < no; i++) {
            this.rooms.add(rooms.get(i));
        }
    }



}
