package tripAdvisor;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hellsapphire on 10/13/2015.
 */

public class MetropolisHotelLookup {
    // TODO reflect on why HashMap
    // TODO use logger
    private static Map<String, Hotel> hotelMap = new HashMap<>();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        // TODO input from scanner
        String hotelfileName = "metropolis_hotels.csv";
        String bookingfileName = "metropolis_bookings.csv";

        loadHotelInfo(hotelfileName);
        loadBookingData(bookingfileName);
        System.out.println("files loaded");

        MetropolisHotelLookup mhl = new MetropolisHotelLookup();
        mhl.queryDates("2015-08-01", "2015-08-05");
    }

    // TODO more specific exception handling and reflect why handled here
    private static void loadHotelInfo(String fileName) {
        try {
            File dir = new File(fileName);
            FileInputStream fileIn = new FileInputStream(dir);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));

            // TODO print this line to logger
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");
                System.out.println("adding hotel " + arr[0] + " " + arr[1]);
                Hotel htl = new Hotel(arr[0], Integer.parseInt(arr[1]));
                hotelMap.put(arr[0], htl);
            }

        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }

    private static void loadBookingData(String fileName) {
        try {
            File dir = new File(fileName);
            FileInputStream fileIn = new FileInputStream(dir);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));

            // TODO print this line to logger
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(", ");
                Hotel htl = hotelMap.get(arr[0]);
                Date startDate = DATE_FORMAT.parse(arr[1]);
                Date endDate = DATE_FORMAT.parse(arr[2]);
                htl.addBooking(startDate, endDate);
                hotelMap.put(arr[0], htl);
            }

        } catch (IOException e) {
            System.out.println("IO exception");
        } catch (ParseException p) {
            System.out.println("parse exception");
        }
    }

    public void queryDates(String checkin, String checkout) {
        try {
            Date startDate = DATE_FORMAT.parse(checkin);
            Date endDate = DATE_FORMAT.parse(checkout);
            for (String hotelName : hotelMap.keySet()) {
                Hotel hotel = hotelMap.get(hotelName);
                if (hotel.queryDates(startDate, endDate)) {
                    System.out.println(hotelName);
                }
            }
        } catch (ParseException p) {
            System.out.println("parse exception");
        }

    }

    // TODO reflect on design choice for default static inner class
    static class Hotel {
        private String hotelName;
        private int roomCount;
        // TODO reflect on why HashTable
        private Hashtable<Date, Integer> bookDateToRoomCount;

        Hotel(String hotelName, int roomCount) {
            this.hotelName = hotelName;
            this.roomCount = roomCount;
            this.bookDateToRoomCount = new Hashtable<>();
        }

        public void addBooking(Date startDate, Date endDate) {
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);

            Calendar end = Calendar.getInstance();
            end.setTime(endDate);

            for (Date i = start.getTime(); i.compareTo(end.getTime()) < 0;
                 start.add(Calendar.DATE, 1), i = start.getTime()) {

                // TODO throw cannot book exception
                if (bookDateToRoomCount.containsKey(i) && bookDateToRoomCount.get(i) > 0) {
                    bookDateToRoomCount.put(i, bookDateToRoomCount.get(i) - 1);
                } else {
                    bookDateToRoomCount.put(i, roomCount - 1);
                }
            }
        }

        public boolean queryDates(Date startDate, Date endDate) {
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);

            Calendar end = Calendar.getInstance();
            end.setTime(endDate);

            for (Date i = start.getTime(); i.compareTo(end.getTime()) < 0;
                 start.add(Calendar.DATE, 1), i = start.getTime()) {
                if (bookDateToRoomCount.containsKey(i) && bookDateToRoomCount.get(i) == 0) {
                    return false;
                }
            }

            return true;
        }
    }

}