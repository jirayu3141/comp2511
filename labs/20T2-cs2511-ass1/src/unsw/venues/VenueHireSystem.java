/**
 *
 */
package unsw.venues;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Venue Hire System for COMP2511.
 *
 * A basic prototype to serve as the "back-end" of a venue hire system. Input
 * and output is in JSON format.
 *
 * @author Jirayu Sirivorawong
 *
 */

import java.util.List;
import java.util.ArrayList;

public class VenueHireSystem {

    private List<Venue> venues;
    protected static List<Booking> bookings;

    public VenueHireSystem() {
        this.venues = new ArrayList<Venue>();
        VenueHireSystem.bookings = new ArrayList<Booking>();
    }

    private void processCommand(JSONObject json) {
        switch (json.getString("command")) {

            case "room":
                String venue = json.getString("venue");
                String room = json.getString("room");
                String size = json.getString("size");
                addRoom(venue, room, size);
                break;

            case "request":
                String id = json.getString("id");
                LocalDate start = LocalDate.parse(json.getString("start"));
                LocalDate end = LocalDate.parse(json.getString("end"));
                int small = json.getInt("small");
                int medium = json.getInt("medium");
                int large = json.getInt("large");

                JSONObject result = request(id, start, end, small, medium, large);

                System.out.println(result.toString(2));
                break;

            case "change":
                String id2 = json.getString("id");
                LocalDate start2 = LocalDate.parse(json.getString("start"));
                LocalDate end2 = LocalDate.parse(json.getString("end"));
                int small2 = json.getInt("small");
                int medium2 = json.getInt("medium");
                int large2 = json.getInt("large");

                JSONObject changeResult = change(id2, start2, end2, small2, medium2, large2);
                System.out.println(changeResult.toString(2));
                break;

            case "cancel":
                String id3 = json.getString("id");
                cancel(id3);
                break;

            case "list":
                String venue4 = json.getString("venue");
                JSONArray listResult = list(venue4);
                System.out.println(listResult.toString(2));
                break;

        }

    }

    /**
     * Create new room for the specified venue
     * 
     * @param venue : venue to create room
     * @param room  : name of room
     * @param size  : size of room
     */
    private void addRoom(String venue, String room, String size) {
        // if venue doesn't currently exist, create venue
        if (!venues.stream().anyMatch(n -> n.getName().equals(venue))) {
            venues.add(new Venue(venue, room, size)); // create venue for the first time
        } else {
            // create new room
            Venue v = findVenue(venue);
            v.addRoom(room, size);
        }
    }

    /**
     * request new booking
     * 
     * @param id     : referece name of the booking
     * @param start  : start date for the booking
     * @param end    : end date for the booking
     * @param small  : number of small room required
     * @param medium : number of medium room required
     * @param large  : number of large room required
     * @return JSON object of the request's result
     */
    public JSONObject request(String id, LocalDate start, LocalDate end, int small, int medium, int large) {
        JSONObject result = new JSONObject();
        // check if the booking is qualified
        Booking newBooking = new Booking(id, start, end, small, medium, large);
        // loop the venue to check for available rooms
        for (Venue x : venues) {
            // List<Room> avaiRooms = x.getAvailableRoom(start, end); //get available room
            // for the booking dates
            // assign rooms if enough
            if (x.smallAvai(start, end).size() >= small && x.medAvai(start, end).size() >= medium
                    && x.largeAvai(start, end).size() >= large) {
                newBooking.setVenue(x);
                newBooking.assignRoom(x.smallAvai(start, end), small); // assign # number of small room
                newBooking.assignRoom(x.medAvai(start, end), medium);
                newBooking.assignRoom(x.largeAvai(start, end), large);
                // sort it in the order of input
                newBooking.getRooms().sort(Comparator.comparingInt(x.getRoom()::indexOf));
                // save result
                result.put("status", "success");
                result.put("venue", x.getName());
                JSONArray rooms = new JSONArray();
                for (Room y : newBooking.getRooms()) {
                    rooms.put(y.getName());
                }
                result.put("rooms", rooms);
                bookings.add(newBooking);
                break;
            }
        }
        // no available room - fails :(
        if (newBooking.getRooms().isEmpty()) {
            result.put("status", "rejected");
        }

        return result;
    }

    /**
     * process change request for the booking
     * 
     * @param id     referece id of the booking
     * @param start  date
     * @param end    date
     * @param small  number of small room required
     * @param medium number of medium room required
     * @param large  number of large room required
     * @return JSONObject of the change result
     */
    private JSONObject change(String id, LocalDate start, LocalDate end, int small, int medium, int large) {
        JSONObject changeResult = new JSONObject();
        // make a copy of the currect booking in case the change fails
        Booking copyOfBooking = getBookingById(id);
        // invalid id
        if (copyOfBooking == null) {
            return changeResult.put("status", "rejected");
        }
        // cancel first, and assign new one. If fails, re-assign orignal booking
        cancel(id);
        changeResult = request(id, start, end, small, medium, large);

        if (changeResult.getString("status").equals("rejected")) {
            bookings.add(copyOfBooking);
        }
        return changeResult;
    }

    /**
     * process cancel request for the booking
     * 
     * @param id of the booking
     */
    private void cancel(String id) {
        // find the id then remove from booking list
        for (Booking x : bookings) {
            if (x.getId().equals(id)) {
                bookings.remove(x);
                break;
            }
        }
    }

    /**
     * list out the list of bookings for each room in a speicified venue
     * 
     * @param venue venue of to get listing from
     * @return JSONOjbect of the list
     */
    private JSONArray list(String venue) {
        JSONArray result = new JSONArray();
        Venue currVenue = findVenue(venue);
        if (currVenue == null) {
            return result;
        }

        // loop through the rooms in that venue, create list of room to be put into json
        for (Room x : currVenue.getRoom()) {
            JSONObject roomResult = new JSONObject();
            List<Booking> roomBooking = x.getBookings(); // get sorted booking
            JSONArray reservationArray = new JSONArray();
            // put bookings for that room into result
            for (Booking y : roomBooking) {
                JSONObject eachReservation = new JSONObject();
                eachReservation.put("id", y.getId());
                eachReservation.put("start", y.getStart());
                eachReservation.put("end", y.getEnd());
                reservationArray.put(eachReservation);
            }
            roomResult.put("room", x);
            roomResult.put("reservations", reservationArray);
            result.put(roomResult);
        }
        return result;
    }

    /**
     * search for venue object
     * 
     * @param name of the venue
     * @return venue object of the searched name
     */
    private Venue findVenue(String name) {
        for (Venue n : venues) {
            if (n.getName().equals(name)) {
                return n;
            }
        }
        return null;
    }

    /**
     * search for booking by id
     * 
     * @param id of the booking
     * @return booking object
     */
    private Booking getBookingById(String id) {
        for (Booking x : bookings) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        VenueHireSystem system = new VenueHireSystem();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().equals("")) {
                JSONObject command = new JSONObject(line);
                system.processCommand(command);
            }
        }
        sc.close();
    }
}
