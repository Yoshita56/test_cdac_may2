package in.cdac.mhealth.opdRoster.vo;

public class RosterInfo {

	private String department;
	private String unit;
	private String room;
	private String consultant;
	private String days;
	private String opdTime;
	private String rosterType;
	private String opdName;
	private String location;
	
	private String type;
	private String fromTime;
	private String toTime;
	private String docName;
	private String workingDays;
	
	
	public RosterInfo(String department, String unit, String type, String fromTime, String toTime, String room,String consultant,String days,String opdTime, String rosterType, String opdName,String location) {
		super();
		this.department = (department==null)?"":department;
		this.unit = (unit==null)?"":unit;
		this.room = (room==null)?"":room;
		this.consultant = (consultant==null)?"":consultant;
		this.days = (days==null)?"":days;
		this.opdTime = (opdTime==null)?"":opdTime;
		this.type = (type==null)?"":type;
		this.fromTime = (fromTime==null)?"":fromTime;
		this.toTime = (toTime==null)?"":toTime;
		this.opdName = (opdName==null)?"":opdName;
		this.rosterType = (toTime==null)?"":rosterType;
		this.location = (location==null)?"":location;
		
		
	}
	
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getOpdTime() {
		return opdTime;
	}

	public void setOpdTime(String opdTime) {
		this.opdTime = opdTime;
	}
	
	public RosterInfo(){
		
	}
	
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = (department==null)?"":department;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = (unit==null)?"":unit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = (type==null)?"":type;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = (fromTime==null)?"":fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = (toTime==null)?"":toTime;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = (docName == null)?"":docName;
	}
	public String getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public String getRosterType() {
		return rosterType;
	}

	public void setRosterType(String rosterType) {
		this.rosterType = rosterType;
	}

	public String getOpdName() {
		return opdName;
	}

	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
