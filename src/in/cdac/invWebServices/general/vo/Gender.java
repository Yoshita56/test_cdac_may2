package in.cdac.invWebServices.general.vo;

public class Gender {

	private String genderId;
	private String genderName;
	
	public Gender(String genderId, String genderName) {
		super();
		this.genderId = genderId;
		this.genderName = genderName;
	}
	
	public String getGenderId() {
		return genderId;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	@Override
	public String toString(){
		return this.genderName;
	}
}
