package ipd;
import java.util.ResourceBundle;
public class IpdTransConfig {
	static String ipdTransConfig="ipd.ipd_conf";
	static String ipdTransInfoConfig="ipd.adt_mandatory_info";
	static ResourceBundle rsConfig=null;
	public static String getMandatoryFatherNameAddmision(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("ADDMISSION_FATHERNAME_MANDATORY");
	}
	public static String getMandatoryNursCheckListAcceptance(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("ACCEPTANCE_NURSCHECKLIST_MANDATORY");
	}
	public static String getMandatoryRemarksBelonging(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("BELONGING_REMARKS_MANDATORY");
	}
	public static String getMandatoryAdviceAtLeaveRecord(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("LEAVERECORD_ADVICEATLEAVE_MANDATORY");
	}
	public static String getMandatoryAdviceAtLeaveOffline(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("OFFLINELEAVE_ADVICEATLEAVE_MANDATORY");
	}
	public static String getMandatoryRemarksOthersLeaveJoin(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("LEAVEJOIN_REMARKSOTHERS_MANDATORY");
	}
	public static String getComboTransferToDischarge(){
		rsConfig=ResourceBundle.getBundle(ipdTransInfoConfig);
		return rsConfig.getString("DISCHARGE_TRANSFERTO_COMBO");
	}
	public static String getBedTypeCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("bedtype");
	}
	public static String getRoomType()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("roomtype");
	}
	public static String getTreatmentCategory()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("treatmentcategory");
	}
	public static String getAdmittedCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("admittedSatus");
	}
	public static String getDiedCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("diedSatus");
	}
	public static String getTransoutFlg()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("transoutFlg");
	}
	public static String getBedStatusVacantCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("bedStatusVacant");
	}
	public static String getOpdCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("opdcode");
	}
	public static String getFemaleCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("female");
	}
	public static String getOwnDeptCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("ownDeptcode");
	}
	public static String getOwnUnitCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("ownUnitcode");
	}
	public static String getOwnWardCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("ownWardcode");
	}
	public static String getStaffCategCode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("staffcode");
	}
	public static String getAdmissionAdviceMode()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("admissionAdviceMode");
	}
	
	public static String isMsApprovalOffiline()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("msapproval");
	}
	public static String getDischargeParameter()
	{
		rsConfig=ResourceBundle.getBundle(ipdTransConfig);
		return rsConfig.getString("dischargeSetting");
	}
}
