package in.cdac.mhealth.opdRoster.vo;

public class Room {

	private int roomCode;
	private String roomName;
	
	public Room(int roomCode, String roomName) {
		super();
		this.roomCode = roomCode;
		this.roomName = roomName;
	}
	
	public int getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString(){
		return this.roomName;
	}
}
