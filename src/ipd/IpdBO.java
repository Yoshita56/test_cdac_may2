package ipd;

import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.WebRowSet;

public class IpdBO {

	WebRowSet ws = null;
	
	@SuppressWarnings("static-access")
	public void getHeaderDetailsWS(IpdVO voObj) {

		DAOIpd dao = new DAOIpd(null, null);
		{
			dao.getClientDtlProc(voObj);
		}

	}

	public void getClientDetails(IpdVO voObj) {
		DAOIpd.getClientDtlProc(voObj);
	}

	public void getOnLineReqDiscount(IpdVO voObj) {

		DAOIpd.getOnLineReqDiscount(voObj);
	}

	public void getChargeTariffDetails(IpdVO voObj) {
		DAOIpd.setTariffChargeDtl(voObj);

	}

	public void getOnLineReqDiscount(IpdVO voObj, String mode) {
		DAOIpd.getOnLineReqDiscount(voObj, mode);
	}

	public void getPatientListingDtl(IpdVO voObj) 
	{

		//StrValue1---1 ,2,3 Leave & 4 Adviced Patient List Used in Patient Admission 
		//& 5 Admitted Patient List Used in Final Discharge Process 
		//& 6 Mother List Used in New Born Baby Admission Process 
		//& 8 Admitted But Not Accepted Patient List Used in Admission Modification & Admission Cancellation Process
		//& 9 MMS Current Admitted Patient,Account Not Settled,Not Dead
		
		if (voObj.getStrValue1().equals("1") || voObj.getStrValue1().equals("2") || voObj.getStrValue1().equals("3")) 
		{
			//Leave
			DAOIpd.setPatientListingDtl_from_Leave(voObj);
		} 
		else if (voObj.getStrValue1().equals("4")) 
		{
			//Adviced Patient
			DAOIpd.setPatientListingDtl_from_Advice(voObj);
		} 
		else if (voObj.getStrValue1().equals("5")) 
		{//Discharge Process Search Popup
			DAOIpd.setPatientListingDtl_from_PatAdmission(voObj);
		} 
		else if (voObj.getStrValue1().equals("6")) 
		{
			//Mother Details
			DAOIpd.setMotherPatientListingDtl_from_PatAdmission(voObj);
		} 
		else if (voObj.getStrValue1().equals("8")) {//Admission Modification & cancellation
			DAOIpd.setPatientListingDtl_for_AdmissionCancel(voObj);
		}
		else if (voObj.getStrValue1().equals("9")) 
		{//MMS Module Issue To LP Search Popup
			DAOIpd.setPatientListingDtl_from_PatAdmission_MMS(voObj);
		} 
		else if (voObj.getStrValue1().equals("10")) 
		{
			DAOIpd.setPatientListingDtl_admittedSingleWindow(voObj);  //Single Window Transfer/Admitted List
		} 
	}

	public void getOccupationDetails(IpdVO voObj) {

		//DAOIpd.setDesignationList(voObj);
		DAOIpd.setOrganizationTypeList(voObj);
		DAOIpd.setRelationList(voObj);
		DAOIpd.setStateList(voObj);
		DAOIpd.setOccupationDtls(voObj);
	}

	public void getPatientDetails(IpdVO voObj) {

		DAOIpd.setPatientDtl(voObj);
	}

	public void getAdmissionDetails(IpdVO voObj) {

		DAOIpd.setAdmissionDtl(voObj);
	}

	/** **bed status popUp*** */
	public void setBedDetails(IpdVO vo) {
		try {
			DAOIpd.getBedValues(vo);
			DAOIpd.countBed_in_ward(vo);
		} catch (Exception e) {
			vo.setStrErrMsgString("IpdBO.setBedDetails---->" + e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	/** **bed status popUp*** */
	//  for Patient Admission
	public void setBedDetailPatAdmission(IpdVO vo) {
		try {
			DAOIpd.beddetailPatAdmission(vo);
			DAOIpd.countBed_in_wardPatAdmission(vo);
		} catch (Exception e) {
			vo.setStrErrMsgString("IpdBO.setBedDetails---->" + e.getMessage());
			vo.setStrMsgType("1");
		}

	}

	public void setBedProperties(IpdVO vo) {
		try {
			DAOIpd.getBedPropertiesValues(vo);
			Map<String, String> mapBedProperties = new HashMap<String, String>();
			/*
			 * String strPrevBed = ""; String strCombProp = ""; if
			 * (vo.getBedPropertiesWS() != null) { int nSize =
			 * vo.getBedPropertiesWS().size();
			 * System.out.println("SIZ----"+nSize); int nTmp = 0; int nTmpPerBed =
			 * 1; while (vo.getBedPropertiesWS().next()) { nTmp++; if
			 * (vo.getBedPropertiesWS().getString(1).equals(strPrevBed)) {
			 * strCombProp += "^" + vo.getBedPropertiesWS().getString(2);
			 * nTmpPerBed++; strPrevBed = vo.getBedPropertiesWS().getString(1);
			 * if (nTmp == nSize){ System.out.println("SAV ED1
			 * "+strPrevBed+"--------"+strCombProp);
			 * mapBedProperties.put(strPrevBed, strCombProp); } } else {
			 * nTmpPerBed = 1; System.out.println("SAV ED 2
			 * "+strPrevBed+"--------"+strCombProp); if(nTmp != 1)
			 * mapBedProperties.put(strPrevBed, strCombProp); strPrevBed =
			 * vo.getBedPropertiesWS().getString(1); strCombProp =
			 * vo.getBedPropertiesWS().getString(2); if (nTmp == nSize){
			 * System.out.println("SAV ED 3
			 * "+strPrevBed+"--------"+strCombProp);
			 * mapBedProperties.put(strPrevBed, strCombProp); } } } }
			 */
			if (vo.getBedPropertiesWS() != null)
				while (vo.getBedPropertiesWS().next()) {
					if (!vo.getBedPropertiesWS().getString(2).equals("0"))
						mapBedProperties.put(vo.getBedPropertiesWS().getString(
								1), vo.getBedPropertiesWS().getString(2));
				}			vo.setMapBedProperties(mapBedProperties);
		} catch (Exception e) {
			//e.printStackTrace();
			vo.setStrErrMsgString("IpdBO.setBedDetails---->" + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	public void wardStatistics(IpdVO vo) 
	{
		try 
		{
			DAOIpd.wardStatistics(vo);
			Map<String, String> mapBedProperties = new HashMap<String, String>();
			if (vo.getBedPropertiesWS() != null)
				while (vo.getBedPropertiesWS().next()) 
				{
					if (!vo.getBedPropertiesWS().getString(2).equals("0"))
						mapBedProperties.put(vo.getBedPropertiesWS().getString(1), vo.getBedPropertiesWS().getString(2));
				}			vo.setMapBedProperties(mapBedProperties);
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			vo.setStrErrMsgString("IpdBO.setBedDetails---->" + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/** **bed status popUp*** */
	public void bedstatusdasboard(IpdVO vo) 
	{
		try 
		{
			DAOIpd.getWardValues(vo);
			DAOIpd.getRoomValues(vo);
			DAOIpd.getWardBedValues(vo);
		//	DAOIpd.getBedProperties(vo);
		//	DAOIpd.getbedPropMapping(vo);
		} 
		catch (Exception e) 
		{
			vo.setStrErrMsgString("IpdBO.bedstatusdasboard---->" + e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	public void jobtracking(IpdVO voObj) 
	{
		DAOIpd.jobtracking(voObj);		 
	}
	
	public void processtracking(IpdVO voObj) 
	{
		DAOIpd.processtracking(voObj);		 
	}
	public void processgauge(IpdVO voObj) 
	{
		DAOIpd.processgauge(voObj);		 
	}
	public void processgraph(IpdVO voObj) 
	{
		DAOIpd.processgraph(voObj);		 
	}
	public void activitylog(IpdVO voObj) 
	{
		DAOIpd.activitylog(voObj);		 
	}
	public void userwisenooftransperformed(IpdVO voObj) 
	{
		DAOIpd.userwisenooftransperformed(voObj);		 
	}
	public void getactivitylog(IpdVO voObj) 
	{
		DAOIpd.getactivitylog(voObj);		 
	}
	public void getactivityTranslog(IpdVO voObj) 
	{
		DAOIpd.getactivityTranslog(voObj);		 
	}
	public void getactivityMnuelog(IpdVO voObj) 
	{
		DAOIpd.getactivityMenulog(voObj);		 
	}
	public void getmenuwiesdata(IpdVO voObj) 
	{
		DAOIpd.getMenuwisedata(voObj);		 
	}
	public void activitytranslog(IpdVO voObj) 
	{
		DAOIpd.activitytranslog(voObj);		 
	}
	public void userWiseFreqClickMenu(IpdVO voObj) 
	{
		DAOIpd.userWiseFreqClickMenu(voObj);		 
	}
	public void crTrackingDetails(IpdVO voObj) 
	{
		DAOIpd.crTrackingDetails(voObj);		 
	}
	public void processtrackinglisting(IpdVO voObj) 
	{
		DAOIpd.processtrackinglisting(voObj);		 
	}

}