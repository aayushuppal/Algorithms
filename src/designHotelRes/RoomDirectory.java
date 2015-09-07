package designHotelRes;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class RoomDirectory {
    private Hashtable<Integer, Room> rooms;
    private static Set<String> roomIds = getRoomList();

    public Room addRoom(int roomNumber, String roomDetails, UserType userType) {
	if (userType == UserType.ADMIN) {
	    if (!rooms.contains(roomNumber)) {
		Room newRoom = new Room(roomNumber, roomDetails);
		rooms.put(roomNumber, newRoom);
		return newRoom;
	    }
	    return null;
	}
	System.out.println("insufficient priveleges");
	return null;
    }

    private static HashSet<String> getRoomList() {
	Set<String> roomIds = new HashSet<String>();
	for (int i = 1; i < 5; i++) {
	    for (int j = 0; j < 10; j++) {

	    }
	}
	return new HashSet<String>();
    }
}