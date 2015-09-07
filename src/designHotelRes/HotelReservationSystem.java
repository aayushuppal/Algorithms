package designHotelRes;

public class HotelReservationSystem {

    private RoomDirectory roomDirectory;
    private UserManager userManager;

    public HotelReservationSystem() {
	this.roomDirectory = new RoomDirectory();
	this.userManager = new UserManager();
    }

    public RoomDirectory getRoomDirectory() {
	return roomDirectory;
    }

    public UserManager getUserManager() {
	return userManager;
    }

}
