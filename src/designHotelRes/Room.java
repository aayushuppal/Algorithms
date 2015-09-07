package designHotelRes;

import java.util.Set;
import java.util.TreeSet;

public class Room {
    private int roomNumber;
    private int activeBookingHours;
    private Set<BookingDetails> bookingSet;

    public Room(int roomNumber) {
	this.roomNumber = roomNumber;
	this.activeBookingHours = 0;
	this.bookingSet = new TreeSet<BookingDetails>(new BookingComparator());
    }
}
