package in.cdac.mhealth.opdRoster.vo;

import java.util.List;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private String hodName;
	private String locationName;
	private String departmentType;
	private List<DepartmentMember> members;
	
	public Department() {
	}
	
	public Department(int deptId, String deptName){
		this.departmentId = deptId;
		this.departmentName = deptName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = (hodName == null)?"-":hodName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = (locationName == null)?"-":locationName;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = (departmentType == null)?"-":departmentType;
	}

	public List<DepartmentMember> getMembers() {
		return members;
	}

	public void setMembers(List<DepartmentMember> members) {
		this.members = members;
	}
}
