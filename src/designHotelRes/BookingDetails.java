package designHotelRes;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class BookingDetails {
    public static SimpleDateFormat reservationDateFormat = new SimpleDateFormat(
	    "yyyy-MM-dd'T'HH:mm:ss");
    public static TimeZone reservationTimeZone = TimeZone.getTimeZone("UTC");

    private Date startDateTime;
    private Date endDateTime;
    private int roomNumber;
    private boolean isConfirmed;
    private String bookingId; // parts of startDate, endDate, roomNumber,
			      // guest initials
    private List<String> guestList;

    public Date getStartTime() {
	return startDateTime;
    }

}

class BookingComparator implements Comparator<BookingDetails> {

    @Override
    public int compare(BookingDetails o1, BookingDetails o2) {
	return o1.getStartTime().compareTo(o2.getStartTime());
    }

}
