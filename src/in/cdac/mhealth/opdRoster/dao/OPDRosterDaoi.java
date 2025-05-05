package in.cdac.mhealth.opdRoster.dao;

import in.cdac.mhealth.opdRoster.vo.Department;
import in.cdac.mhealth.opdRoster.vo.Room;
import in.cdac.mhealth.opdRoster.vo.RosterInfo;
import in.cdac.mhealth.opdRoster.vo.ShiftType;
import in.cdac.mhealth.opdRoster.vo.Unit;

import java.sql.Date;
import java.util.List;

public interface OPDRosterDaoi {

	public List<ShiftType> getSiftType(int hospitalCode, Date dt);
	
	public List<Department> getDepartment(int hospitalCode, Date dt, int shift);
	
	public List<Unit> getUnit(int hospitalCode, Date dt, int shift, int dept);
	
	public List<Room> getRoom(int hospitalCode, Date dt, int shift, int dept, int unit);

	public List<RosterInfo> getRoster(Date date, int type, int dept, int unit, int room, int hospitalCode);
	
	public List<RosterInfo> getRosterDeptWise(int dept, int hospitalCode);
	
	public List<RosterInfo> getDoctorAvailability(Date date, String docName, int hospitalCode);
	
}
