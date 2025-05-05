package vo.usermgmt;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class HolidayMasterVO extends ValueObject
{
	private String varHolidayId;
	private String varHolidayYear;
	private String varHolidayDate;
	private String varHolidayName;
	private String varHolidayShortName;
	private String varHolidayTypeId;
	private String varHolidayRemarks;
	private String varEntryDate;
	private String varIsValid;
	private String varSeatId;
	private String varHospitalCode;
	
	
	public String getVarHolidayId() {
		return varHolidayId;
	}
	public void setVarHolidayId(String varHolidayId) {
		this.varHolidayId = varHolidayId;
	}
	public String getVarHolidayDate() {
		return varHolidayDate;
	}
	public void setVarHolidayDate(String varHolidayDate) {
		this.varHolidayDate = varHolidayDate;
	}
	public String getVarEntryDate() {
		return varEntryDate;
	}
	public void setVarEntryDate(String varEntryDate) {
		this.varEntryDate = varEntryDate;
	}
	public String getVarIsValid() {
		return varIsValid;
	}
	public void setVarIsValid(String varIsValid) {
		this.varIsValid = varIsValid;
	}
	public String getVarSeatId() {
		return varSeatId;
	}
	public void setVarSeatId(String varSeatId) {
		this.varSeatId = varSeatId;
	}
	public String getVarHospitalCode() {
		return varHospitalCode;
	}
	public void setVarHospitalCode(String varHospitalCode) {
		this.varHospitalCode = varHospitalCode;
	}
	public String getVarHolidayYear() {
		return varHolidayYear;
	}
	public void setVarHolidayYear(String varHolidayYear) {
		this.varHolidayYear = varHolidayYear;
	}
	public String getVarHolidayName() {
		return varHolidayName;
	}
	public void setVarHolidayName(String varHolidayName) {
		this.varHolidayName = varHolidayName;
	}
	public String getVarHolidayShortName() {
		return varHolidayShortName;
	}
	public void setVarHolidayShortName(String varHolidayShortName) {
		this.varHolidayShortName = varHolidayShortName;
	}
	public String getVarHolidayTypeId() {
		return varHolidayTypeId;
	}
	public void setVarHolidayTypeId(String varHolidayTypeId) {
		this.varHolidayTypeId = varHolidayTypeId;
	}
	public String getVarHolidayRemarks() {
		return varHolidayRemarks;
	}
	public void setVarHolidayRemarks(String varHolidayRemarks) {
		this.varHolidayRemarks = varHolidayRemarks;
	}
	

	

}
