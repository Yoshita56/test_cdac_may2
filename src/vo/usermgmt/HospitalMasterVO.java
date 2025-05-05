package vo.usermgmt;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class HospitalMasterVO extends ValueObject
{
	private String varHospitalCode;
	private String varEntryDate;
	private String varLastModifyDate;
	private String varIsActive;
	private String varHL7Code;
	private String varHospitalCategory;
	private String varHospitalType;
	private String varIsAssociated;
	private String varIsValid;
	private String varLastModifySeatId;
	private String varPinCode;
	private String varSeatId;
	private String varStateCode;
	private String varUserLicenceAllowed;
	private String varBedCapacity;
	private String varBusRouteNo;
	private String varCity;
	private String varContactPerson;
	private String varEmail;
	private String varFax;
	private String varHospitalShortName;
	private String varHospitalAddress1;
	private String varHospitalAddress2;
	private String varHospitalName;
	private String varLunchBreak;
	private String varPANNo;
	private String varPassword;
	private String varPhone;
	private String varRemarks;
	private String varSaturdayTimings;
	private String varTANNo;
	private String varUserName;
	private String varWeekdaysTimings;
	private String varOrganizationType;
	private String varDistrictId;
	private String varLanguageCode;
	private String varLanguageName;
	private String varLocalLangCode;
	private String varLocalLangName;

	private List<UserMasterVO> lstUserMasterVO;

	private String varHospitalTypeName;
	private String varUserId;
	private String varUserSeatId;
	private String varDistrictName;
	private String varStateName;
	private String licenseCode;
	private String licenseExp;
	private String webSite;
	private String lattitude;
	private String longitude;
	public String getVarHospitalCode()
	{
		return varHospitalCode;
	}

	public void setVarHospitalCode(String varHospitalCode)
	{
		this.varHospitalCode = varHospitalCode;
	}

	public String getVarEntryDate()
	{
		return varEntryDate;
	}

	public void setVarEntryDate(String varEntryDate)
	{
		this.varEntryDate = varEntryDate;
	}

	public String getVarLastModifyDate()
	{
		return varLastModifyDate;
	}

	public void setVarLastModifyDate(String varLastModifyDate)
	{
		this.varLastModifyDate = varLastModifyDate;
	}

	public String getVarIsActive()
	{
		return varIsActive;
	}

	public void setVarIsActive(String varIsActive)
	{
		this.varIsActive = varIsActive;
	}

	public String getVarHL7Code()
	{
		return varHL7Code;
	}

	public void setVarHL7Code(String varHL7Code)
	{
		this.varHL7Code = varHL7Code;
	}

	public String getVarHospitalCategory()
	{
		return varHospitalCategory;
	}

	public void setVarHospitalCategory(String varHospitalCategory)
	{
		this.varHospitalCategory = varHospitalCategory;
	}

	public String getVarHospitalType()
	{
		return varHospitalType;
	}

	public void setVarHospitalType(String varHospitalType)
	{
		this.varHospitalType = varHospitalType;
	}

	public String getVarIsAssociated()
	{
		return varIsAssociated;
	}

	public void setVarIsAssociated(String varIsAssociated)
	{
		this.varIsAssociated = varIsAssociated;
	}

	public String getVarIsValid()
	{
		return varIsValid;
	}

	public void setVarIsValid(String varIsValid)
	{
		this.varIsValid = varIsValid;
	}

	public String getVarLastModifySeatId()
	{
		return varLastModifySeatId;
	}

	public void setVarLastModifySeatId(String varLastModifySeatId)
	{
		this.varLastModifySeatId = varLastModifySeatId;
	}

	public String getVarPinCode()
	{
		return varPinCode;
	}

	public void setVarPinCode(String varPinCode)
	{
		this.varPinCode = varPinCode;
	}

	public String getVarSeatId()
	{
		return varSeatId;
	}

	public void setVarSeatId(String varSeatId)
	{
		this.varSeatId = varSeatId;
	}

	public String getVarStateCode()
	{
		return varStateCode;
	}

	public void setVarStateCode(String varStateCode)
	{
		this.varStateCode = varStateCode;
	}

	public String getVarUserLicenceAllowed()
	{
		return varUserLicenceAllowed;
	}

	public void setVarUserLicenceAllowed(String varUserLicenceAllowed)
	{
		this.varUserLicenceAllowed = varUserLicenceAllowed;
	}

	public String getVarBedCapacity()
	{
		return varBedCapacity;
	}

	public void setVarBedCapacity(String varBedCapacity)
	{
		this.varBedCapacity = varBedCapacity;
	}

	public String getVarBusRouteNo()
	{
		return varBusRouteNo;
	}

	public void setVarBusRouteNo(String varBusRouteNo)
	{
		this.varBusRouteNo = varBusRouteNo;
	}

	public String getVarCity()
	{
		return varCity;
	}

	public void setVarCity(String varCity)
	{
		this.varCity = varCity;
	}

	public String getVarContactPerson()
	{
		return varContactPerson;
	}

	public void setVarContactPerson(String varContactPerson)
	{
		this.varContactPerson = varContactPerson;
	}

	public String getVarEmail()
	{
		return varEmail;
	}

	public void setVarEmail(String varEmail)
	{
		this.varEmail = varEmail;
	}

	public String getVarFax()
	{
		return varFax;
	}

	public void setVarFax(String varFax)
	{
		this.varFax = varFax;
	}

	public String getVarHospitalShortName()
	{
		return varHospitalShortName;
	}

	public void setVarHospitalShortName(String varHospitalShortName)
	{
		this.varHospitalShortName = varHospitalShortName;
	}

	public String getVarHospitalAddress1()
	{
		return varHospitalAddress1;
	}

	public void setVarHospitalAddress1(String varHospitalAddress1)
	{
		this.varHospitalAddress1 = varHospitalAddress1;
	}

	public String getVarHospitalAddress2()
	{
		return varHospitalAddress2;
	}

	public void setVarHospitalAddress2(String varHospitalAddress2)
	{
		this.varHospitalAddress2 = varHospitalAddress2;
	}

	public String getVarHospitalName()
	{
		return varHospitalName;
	}

	public void setVarHospitalName(String varHospitalName)
	{
		this.varHospitalName = varHospitalName;
	}

	public String getVarLunchBreak()
	{
		return varLunchBreak;
	}

	public void setVarLunchBreak(String varLunchBreak)
	{
		this.varLunchBreak = varLunchBreak;
	}

	public String getVarPANNo()
	{
		return varPANNo;
	}

	public void setVarPANNo(String varPANNo)
	{
		this.varPANNo = varPANNo;
	}

	public String getVarPassword()
	{
		return varPassword;
	}

	public void setVarPassword(String varPassword)
	{
		this.varPassword = varPassword;
	}

	public String getVarPhone()
	{
		return varPhone;
	}

	public void setVarPhone(String varPhone)
	{
		this.varPhone = varPhone;
	}

	public String getVarRemarks()
	{
		return varRemarks;
	}

	public void setVarRemarks(String varRemarks)
	{
		this.varRemarks = varRemarks;
	}

	public String getVarSaturdayTimings()
	{
		return varSaturdayTimings;
	}

	public void setVarSaturdayTimings(String varSaturdayTimings)
	{
		this.varSaturdayTimings = varSaturdayTimings;
	}

	public String getVarTANNo()
	{
		return varTANNo;
	}

	public void setVarTANNo(String varTANNo)
	{
		this.varTANNo = varTANNo;
	}

	public String getVarUserName()
	{
		return varUserName;
	}

	public void setVarUserName(String varUserName)
	{
		this.varUserName = varUserName;
	}

	public String getVarWeekdaysTimings()
	{
		return varWeekdaysTimings;
	}

	public void setVarWeekdaysTimings(String varWeekdaysTimings)
	{
		this.varWeekdaysTimings = varWeekdaysTimings;
	}

	public String getVarOrganizationType()
	{
		return varOrganizationType;
	}

	public void setVarOrganizationType(String varOrganizationType)
	{
		this.varOrganizationType = varOrganizationType;
	}

	public String getVarDistrictId()
	{
		return varDistrictId;
	}

	public void setVarDistrictId(String varDistrictId)
	{
		this.varDistrictId = varDistrictId;
	}

	public List<UserMasterVO> getLstUserMasterVO()
	{
		return lstUserMasterVO;
	}

	public void setLstUserMasterVO(List<UserMasterVO> lstUserMasterVO)
	{
		this.lstUserMasterVO = lstUserMasterVO;
	}

	public String getVarHospitalTypeName()
	{
		return varHospitalTypeName;
	}

	public void setVarHospitalTypeName(String varHospitalTypeName)
	{
		this.varHospitalTypeName = varHospitalTypeName;
	}

	public String getVarUserId()
	{
		return varUserId;
	}

	public void setVarUserId(String varUserId)
	{
		this.varUserId = varUserId;
	}

	public String getVarUserSeatId()
	{
		return varUserSeatId;
	}

	public void setVarUserSeatId(String varUserSeatId)
	{
		this.varUserSeatId = varUserSeatId;
	}

	public String getVarLanguageCode()
	{
		return varLanguageCode;
	}

	public void setVarLanguageCode(String varLanguageCode)
	{
		this.varLanguageCode = varLanguageCode;
	}

	public String getVarLocalLangCode()
	{
		return varLocalLangCode;
	}

	public void setVarLocalLangCode(String varLocalLangCode)
	{
		this.varLocalLangCode = varLocalLangCode;
	}

	public String getVarDistrictName()
	{
		return varDistrictName;
	}

	public void setVarDistrictName(String varDistrictName)
	{
		this.varDistrictName = varDistrictName;
	}

	public String getVarStateName()
	{
		return varStateName;
	}

	public void setVarStateName(String varStateName)
	{
		this.varStateName = varStateName;
	}

	public String getVarLanguageName() {
		return varLanguageName;
	}

	public void setVarLanguageName(String varLanguageName) {
		this.varLanguageName = varLanguageName;
	}

	public String getVarLocalLangName() {
		return varLocalLangName;
	}

	public void setVarLocalLangName(String varLocalLangName) {
		this.varLocalLangName = varLocalLangName;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getLicenseExp() {
		return licenseExp;
	}

	public void setLicenseExp(String licenseExp) {
		this.licenseExp = licenseExp;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
