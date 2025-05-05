package vo.usermgmt;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: UserMasterVO
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class UserMasterVO extends ValueObject
{
	private String varUserId;
	private String varChangePasswordDate;
	private String varEffectDate;
	private String varEntryDate;
	private String varExpiryDate;
	private String varLastModifyDate;
	private String varDesignation;
	private String varLock;
	private String varIsValid;
	private String varLastModifySeatId;
	private String varMobileNumber;
	private String varQuestionId;
	private String varSeatId;
	private String varSwapcardNumber;
	private String varUserSeatId;
	private String varUserType;
	private String varUserTypeId;
	private String varUserLevel;
	private String varEmailId;
	private String varHintAnswer;
	private String varOldPassword;
	private String varPassword;
	private String varStatusCode;
	private String varUserName;
	private String varUsrName;
	private String varDistrictId;
	private String varEmpNo;
	private String varHospitalCode;
	private String varMenuId;
	

	
	private HospitalMasterVO voHospital;
	private List<UserLoginLogVO> lstUserLog;

	private UserLoginLogVO voLastUserLog;
	private List<UserLoginLogVO> lstUnloggedUserLoginDtl;

	private String varLoggedIn;
	private String varLoginMessage;
	private String varIPAddress;
	private String varDefaultMenuURL;
	private String varDistrictName;
	
	
	private String varCurrentYear;
	private String varCurrentMonth;
	private String varCurrentDate;
	private String varCurrentHour;
	private String varCurrentMinute;
	private String varCurrentSecond;
	
	private String checkBackDateDayEndFlag;
	private String varDefaultMenuName;
	private String varDefaultMenuModule;

	private String smsWebServiceURL;
	private String smsUserName;
	private String smsPassword;
	private String smsSecureKey;
	private String smsSenderId;
	private String sslVer;
	private String smsServiceFlag;//1-Up,0-Down
	
	private String smtpMailServerURL;
	private String smtpHost;
	private String smtpPort;
	private String mailUserId;
	private String mailPassword;
	private String mailServiceFlag;//1-Up,0-Down

	public String getVarUserId()
	{
		return varUserId;
	}

	public void setVarUserId(String varUserId)
	{
		this.varUserId = varUserId;
	}

	public String getVarChangePasswordDate()
	{
		return varChangePasswordDate;
	}

	public void setVarChangePasswordDate(String varChangePasswordDate)
	{
		this.varChangePasswordDate = varChangePasswordDate;
	}

	public String getVarEffectDate()
	{
		return varEffectDate;
	}

	public void setVarEffectDate(String varEffectDate)
	{
		this.varEffectDate = varEffectDate;
	}

	public String getVarEntryDate()
	{
		return varEntryDate;
	}

	public void setVarEntryDate(String varEntryDate)
	{
		this.varEntryDate = varEntryDate;
	}

	public String getVarExpiryDate()
	{
		return varExpiryDate;
	}

	public void setVarExpiryDate(String varExpiryDate)
	{
		this.varExpiryDate = varExpiryDate;
	}

	public String getVarLastModifyDate()
	{
		return varLastModifyDate;
	}

	public void setVarLastModifyDate(String varLastModifyDate)
	{
		this.varLastModifyDate = varLastModifyDate;
	}

	public String getVarDesignation()
	{
		return varDesignation;
	}

	public void setVarDesignation(String varDesignation)
	{
		this.varDesignation = varDesignation;
	}

	public String getVarLock()
	{
		return varLock;
	}

	public void setVarLock(String varLock)
	{
		this.varLock = varLock;
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

	public String getVarMobileNumber()
	{
		return varMobileNumber;
	}

	public void setVarMobileNumber(String varMobileNumber)
	{
		this.varMobileNumber = varMobileNumber;
	}

	public String getVarQuestionId()
	{
		return varQuestionId;
	}

	public void setVarQuestionId(String varQuestionId)
	{
		this.varQuestionId = varQuestionId;
	}

	public String getVarSeatId()
	{
		return varSeatId;
	}

	public void setVarSeatId(String varSeatId)
	{
		this.varSeatId = varSeatId;
	}

	public String getVarSwapcardNumber()
	{
		return varSwapcardNumber;
	}

	public void setVarSwapcardNumber(String varSwapcardNumber)
	{
		this.varSwapcardNumber = varSwapcardNumber;
	}

	public String getVarUserSeatId()
	{
		return varUserSeatId;
	}

	public void setVarUserSeatId(String varUserSeatId)
	{
		this.varUserSeatId = varUserSeatId;
	}

	public String getVarUserType()
	{
		return varUserType;
	}

	public void setVarUserType(String varUserType)
	{
		this.varUserType = varUserType;
	}

	public String getVarUserTypeId()
	{
		return varUserTypeId;
	}

	public void setVarUserTypeId(String varUserTypeId)
	{
		this.varUserTypeId = varUserTypeId;
	}

	public String getVarUserLevel()
	{
		return varUserLevel;
	}

	public void setVarUserLevel(String varUserLevel)
	{
		this.varUserLevel = varUserLevel;
	}

	public String getVarEmailId()
	{
		return varEmailId;
	}

	public void setVarEmailId(String varEmailId)
	{
		this.varEmailId = varEmailId;
	}

	public String getVarHintAnswer()
	{
		return varHintAnswer;
	}

	public void setVarHintAnswer(String varHintAnswer)
	{
		this.varHintAnswer = varHintAnswer;
	}

	public String getVarOldPassword()
	{
		return varOldPassword;
	}

	public void setVarOldPassword(String varOldPassword)
	{
		this.varOldPassword = varOldPassword;
	}

	public String getVarPassword()
	{
		return varPassword;
	}

	public void setVarPassword(String varPassword)
	{
		this.varPassword = varPassword;
	}

	public String getVarStatusCode()
	{
		return varStatusCode;
	}

	public void setVarStatusCode(String varStatusCode)
	{
		this.varStatusCode = varStatusCode;
	}

	public String getVarUserName()
	{
		return varUserName;
	}

	public void setVarUserName(String varUserName)
	{
		this.varUserName = varUserName;
	}

	public String getVarUsrName()
	{
		return varUsrName;
	}

	public void setVarUsrName(String varUsrName)
	{
		this.varUsrName = varUsrName;
	}

	public String getVarDistrictId()
	{
		return varDistrictId;
	}

	public void setVarDistrictId(String varDistrictId)
	{
		this.varDistrictId = varDistrictId;
	}

	public String getVarEmpNo()
	{
		return varEmpNo;
	}

	public void setVarEmpNo(String varEmpNo)
	{
		this.varEmpNo = varEmpNo;
	}

	public HospitalMasterVO getVoHospital()
	{
		return voHospital;
	}

	public void setVoHospital(HospitalMasterVO voHospital)
	{
		this.voHospital = voHospital;
	}

	public List<UserLoginLogVO> getLstUserLog()
	{
		return lstUserLog;
	}

	public void setLstUserLog(List<UserLoginLogVO> lstUserLog)
	{
		this.lstUserLog = lstUserLog;
	}

	public UserLoginLogVO getVoLastUserLog()
	{
		return voLastUserLog;
	}

	public void setVoLastUserLog(UserLoginLogVO voLastUserLog)
	{
		this.voLastUserLog = voLastUserLog;
	}

	public List<UserLoginLogVO> getLstUnloggedUserLoginDtl()
	{
		return lstUnloggedUserLoginDtl;
	}

	public void setLstUnloggedUserLoginDtl(List<UserLoginLogVO> lstUnloggedUserLoginDtl)
	{
		this.lstUnloggedUserLoginDtl = lstUnloggedUserLoginDtl;
	}

	public String getVarHospitalCode()
	{
		return varHospitalCode;
	}

	public void setVarHospitalCode(String varHospitalCode)
	{
		this.varHospitalCode = varHospitalCode;
	}

	public String getVarLoggedIn()
	{
		return varLoggedIn;
	}

	public void setVarLoggedIn(String varLoggedIn)
	{
		this.varLoggedIn = varLoggedIn;
	}

	public String getVarLoginMessage()
	{
		return varLoginMessage;
	}

	public void setVarLoginMessage(String varLoginMessage)
	{
		this.varLoginMessage = varLoginMessage;
	}

	public String getVarMenuId()
	{
		return varMenuId;
	}

	public void setVarMenuId(String varMenuId)
	{
		this.varMenuId = varMenuId;
	}

	public String getVarDefaultMenuURL()
	{
		return varDefaultMenuURL;
	}

	public void setVarDefaultMenuURL(String varDefaultMenuURL)
	{
		this.varDefaultMenuURL = varDefaultMenuURL;
	}

	public String getVarCurrentYear()
	{
		return varCurrentYear;
	}

	public void setVarCurrentYear(String varCurrentYear)
	{
		this.varCurrentYear = varCurrentYear;
	}

	public String getVarCurrentMonth()
	{
		return varCurrentMonth;
	}

	public void setVarCurrentMonth(String varCurrentMonth)
	{
		this.varCurrentMonth = varCurrentMonth;
	}

	public String getVarCurrentDate()
	{
		return varCurrentDate;
	}

	public void setVarCurrentDate(String varCurrentDate)
	{
		this.varCurrentDate = varCurrentDate;
	}

	public String getVarCurrentHour()
	{
		return varCurrentHour;
	}

	public void setVarCurrentHour(String varCurrentHour)
	{
		this.varCurrentHour = varCurrentHour;
	}

	public String getVarCurrentMinute()
	{
		return varCurrentMinute;
	}

	public void setVarCurrentMinute(String varCurrentMinute)
	{
		this.varCurrentMinute = varCurrentMinute;
	}

	public String getVarCurrentSecond()
	{
		return varCurrentSecond;
	}

	public void setVarCurrentSecond(String varCurrentSecond)
	{
		this.varCurrentSecond = varCurrentSecond;
	}

	public String getVarIPAddress()
	{
		return varIPAddress;
	}

	public void setVarIPAddress(String varIPAddress)
	{
		this.varIPAddress = varIPAddress;
	}

	public String getVarDistrictName()
	{
		return varDistrictName;
	}

	public void setVarDistrictName(String varDistrictName)
	{
		this.varDistrictName = varDistrictName;
	}

	public String getCheckBackDateDayEndFlag() {
		return checkBackDateDayEndFlag;
	}

	public void setCheckBackDateDayEndFlag(String checkBackDateDayEndFlag) {
		this.checkBackDateDayEndFlag = checkBackDateDayEndFlag;
	}

	public String getVarDefaultMenuModule() {
		return varDefaultMenuModule;
	}

	public void setVarDefaultMenuModule(String varDefaultMenuModule) {
		this.varDefaultMenuModule = varDefaultMenuModule;
	}

	public String getVarDefaultMenuName() {
		return varDefaultMenuName;
	}

	public void setVarDefaultMenuName(String varDefaultMenuName) {
		this.varDefaultMenuName = varDefaultMenuName;
	}

	public String getSmsWebServiceURL() {
		return smsWebServiceURL;
	}

	public void setSmsWebServiceURL(String smsWebServiceURL) {
		this.smsWebServiceURL = smsWebServiceURL;
	}

	public String getSmsUserName() {
		return smsUserName;
	}

	public void setSmsUserName(String smsUserName) {
		this.smsUserName = smsUserName;
	}

	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public String getSmsSecureKey() {
		return smsSecureKey;
	}

	public void setSmsSecureKey(String smsSecureKey) {
		this.smsSecureKey = smsSecureKey;
	}

	public String getSmsSenderId() {
		return smsSenderId;
	}

	public void setSmsSenderId(String smsSenderId) {
		this.smsSenderId = smsSenderId;
	}

	public String getSslVer() {
		return sslVer;
	}

	public void setSslVer(String sslVer) {
		this.sslVer = sslVer;
	}

	public String getSmsServiceFlag() {
		return smsServiceFlag;
	}

	public void setSmsServiceFlag(String smsServiceFlag) {
		this.smsServiceFlag = smsServiceFlag;
	}

	public String getSmtpMailServerURL() {
		return smtpMailServerURL;
	}

	public void setSmtpMailServerURL(String smtpMailServerURL) {
		this.smtpMailServerURL = smtpMailServerURL;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getMailUserId() {
		return mailUserId;
	}

	public void setMailUserId(String mailUserId) {
		this.mailUserId = mailUserId;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getMailServiceFlag() {
		return mailServiceFlag;
	}

	public void setMailServiceFlag(String mailServiceFlag) {
		this.mailServiceFlag = mailServiceFlag;
	}
	
}
