package mms.masters.controller.data;

import java.text.DateFormatSymbols;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.StoreMstBO;
import mms.masters.controller.fb.StoreMstFB;
import mms.masters.vo.StoreMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreMstDATA.
 */
public class StoreMstDATA {

	/**
	 * to display the Store Type Name on next page according to the selected.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreMstFB formBean,HttpServletRequest request) 
	{
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		
		
		String cmb = "";
		String cmb1 = "";
		String cmb2 = "";
		String cmb3 = "";
		String cmb4 = "";
		String strMappedHospCmb= "";
		//String[] temp = null;
		//String strStoreTypeName = "";
		try {
			
			
			//String comboValue = request.getParameter("comboValue");
			//temp = comboValue.replace("^", "#").split("#");

			//strStoreTypeName = temp[0];

			//formBean.setStrStoreTypeName(strStoreTypeName);
			
			
			bo = new StoreMstBO();
			vo = new StoreMstVO();
			hisutil = new HisUtil("mms", "StoreMstDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String strStoreTypeId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreTypeId(strStoreTypeId);
			vo.setStrStateCode(mmscofigutil.getStrStateCode());

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);
			
			

			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrDepartmentComboWs() != null) 
			{
				cmb = hisutil.getOptionValue(vo.getStrDepartmentComboWs(),"", "", true);
			}
			vo.setStrDepartmentCombo(cmb);

			if (vo.getStrInchargeCmbWs() != null) 
			{
				cmb1 = hisutil.getOptionValue(vo.getStrInchargeCmbWs(),	"", "", true);
			}
			vo.setStrInchargeCmb(cmb1);

			/*if (vo.getStrDistrictCmbWs() != null) 
			{
				cmb2 = hisutil.getOptionValue(vo.getStrDistrictCmbWs(),"0^Select Value", "Select Value", true);
			}*/
			
			if (vo.getStrDrugWarehouseTypeCmb() != null) 
			{
				cmb3 = hisutil.getOptionValue(vo.getStrDrugWarehouseTypeCmb(),"0^Select Value", "Select Value", true);
			}
			
									
			if (vo.getStrHospitalTypeCmbWs() != null && vo.getStrHospitalTypeCmbWs().size() != 0) 
			{
				cmb4 = hisutil.getOptionValue(vo.getStrHospitalTypeCmbWs(),"", "", true);
			}
			else 
			{

				cmb4 = "<option value='0'>SelectValue</option>";
			}
			
			formBean.setStrHospitalTypeCombo(cmb4);
			//formBean.setStrDistrictCmb(cmb2);
			formBean.setStrDrugWarehouseTypeCmb(cmb3);
			//formBean.setStrStateShortCode(vo.getStrStateShortCode());
			formBean.setStrStateShortCode(MmsConfigUtil.STATE_SHORT_CODE);
			
			//formBean.setStrMappedHospCmb(strMappedHospCmb);
			
			formBean.setStrDepartmentCombo(vo.getStrDepartmentCombo());
			formBean.setStrLeftRequestTypeList(vo.getStrInchargeCmb());
			//formBean.setStrBuildingCmb(vo.getStrBuildingCmb());
			formBean.setStrItemBounded("0"); // By default store will not be bounded with item.
			formBean.setStrIsNewItemFlag("1"); // By default new item feature will be enabled.
			formBean.setStrSection("1");
			formBean.setStrPurchasingMode("1");
			formBean.setStrHospitalCode(hosCode);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "Store Master.StoreMstDATA.initialAdd(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StoreMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(StoreMstFB formBean,
			HttpServletRequest request) {
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		String strmsgText = "";
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strFinancialStartDateMonthName;
		String strFinancialEndDateMonthName;
		
		DateFormatSymbols dateFormatSymbols=null;
		try 
		{
			bo = new StoreMstBO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			//String strStoreTypeId = formBean.getCombo()[0];
			
			
			/*
			 * Modified by Aritra(20/12/2010)
			 * Change Req from Ajay Gupta.(Store Type not required)
			 */
			String strStoreTypeId = "0";
			if(formBean.getStrDrugWarehouseTypeId().split("\\^")[0]!=null)
				strStoreTypeId=formBean.getStrDrugWarehouseTypeId().split("\\^")[0]; //Adil
			//System.out.println(formBean.getStrDrugWarehouseTypeId());
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
			
			
			formBean.setStrConfigStoreCatg(mmscofigutil.getStrStoreConfigCatg());
			
			/*
			 * Added by Aritra. (03.Feb.2011)
			 * Reason: Financial Date Issue.
			 */
			dateFormatSymbols=new DateFormatSymbols();
			strFinancialStartDateMonthName=dateFormatSymbols.getShortMonths()[Integer.parseInt(formBean.getStrStartDateMonth())-1];
			strFinancialEndDateMonthName=dateFormatSymbols.getShortMonths()[Integer.parseInt(formBean.getStrEndDateMonth())-1];
			
		//	strFinancialStartDate="01-"+strFinancialStartDateMonthName+"-"+formBean.getStrStartDateYear();
		//	strFinancialEndDate="28-"+strFinancialEndDateMonthName+"-"+formBean.getStrEndDateYear();
			
			strFinancialStartDate="01-"+strFinancialStartDateMonthName+"-"+"2014";
			strFinancialEndDate="28-"+strFinancialEndDateMonthName+"-"+"2015";
			
			formBean.setStrFinStartDate(strFinancialStartDate);
			formBean.setStrFinEndDate(strFinancialEndDate);
			
			/* -0- */
						
			
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreTypeId(strStoreTypeId);
			formBean.setStrIsValid("1");
						
			
			
			vo = (StoreMstVO) TransferObjectFactory.populateData("mms.masters.vo.StoreMstVO", formBean);
			
		//	vo.setStrCode(formBean.getStrStateShortCode() + "-" + formBean.getStrCode());
			
			/*
			 * Added by Aritra. (07.Feb.2011)
			 * Reason: Time Bound Issue.
			 */
			if(formBean.isfTimeBoundFlag()) {
				vo.setStrTimeBoundFlag("1");
			}else {
				vo.setStrTimeBoundFlag("0");
				vo.setStrFromTime("");
				vo.setStrToTime("");
			}
			
			/* -0- */

			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();

			strmsgText = "Store Master.StoreMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(StoreMstFB formBean,HttpServletRequest request) 
	{
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		//String temp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String cmb = null,strMappedHospCmb=null;
		String cmb1 = "";
		String cmb3 = "";
		String cmb4 = "";
		String cmb5 = "";
		//String strStoreTypeName = "";
	
		try 
		{
			bo = new StoreMstBO();
			vo = new StoreMstVO();
			hisutil = new HisUtil("mms", "StoreMstDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			//String comboValue = request.getParameter("comboValue");
			//temp = comboValue.replace("^", "#").split("#");

			//strStoreTypeName = temp[0];
			//MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrStoreId(strtemp[1]);
			//vo.setStrStateCode(mmscofigutil.getStrStateCode());
			vo.setStrStateCode("0");
            vo.setStrMode("1");
			String seatid = request.getSession().getAttribute("SEATID").toString();
			//String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrSeatId(seatid);
			
            vo.setStrViewFlg("1");
			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			//added by shalini for dept and ward combo
			
			String cmbd = hisutil.getOptionValue(vo.getStrDepartmentComboWs(),vo.getStrDeptCode(), "0^Select Value", true);
			vo.setStrDepartmentCombo(cmbd);
			formBean.setStrDepartmentCombo(cmbd);
			bo.getWardCombo(vo);
			
			String cmbw = hisutil.getOptionValue(vo.getStrWardComboWs(), vo.getStrWardCode(), "0^Select Value", true);

			vo.setStrWardCombo(cmbw);
			formBean.setStrWardCombo(cmbw);
			
			if (vo.getStrInchargeCmbWs() != null) 
			{
				cmb1 = hisutil.getOptionValue(vo.getStrInchargeCmbWs(),"", "", true);				
			}
			vo.setStrLeftRequestTypeList(cmb1);

			//String cmb1 = hisutil.getOptionValue(vo.getStrInchargeCmbWs(), "", "", true);
		//	vo.setStrLeftRequestTypeList(cmb1);
			
			String cmb2 = hisutil.getOptionValue(vo.getStrRigthCmbWs(), "", "", true);//strRigthDeptCmbWs
			vo.setStrRightRequestTypeList(cmb2);
            
			
//			strRigthDeptCmbWs
			String deptcmb = hisutil.getOptionValue(vo.getStrRigthDeptCmbWs(), "", "", true);
			vo.setStrRightRequestTypeList(deptcmb);
			
			
			
			formBean.setStrConfigStoreCatg("10");
            
			if (vo.getStrDistrictCmbWs() != null) 
			{
				cmb = hisutil.getOptionValue(vo.getStrDistrictCmbWs(),vo.getStrDistrictId(), "0^Select Value", true);				
			}
			formBean.setStrDistrictCmb(cmb);
			
			if (vo.getStrDrugWarehouseTypeCmb() != null) 
			{
				cmb3 = hisutil.getOptionValue(vo.getStrDrugWarehouseTypeCmb(),vo.getStrStoreTypeId(), "0^Select Value", true);
			}
			formBean.setStrDrugWarehouseTypeCmb(cmb3);
			//System.out.println("vo.getStrMappedHospCmbWS().size()----"+vo.getStrMappedHospCmbWS().size());
			
					
			
			
			
			if (vo.getStrMappedHospCmbWS() != null && vo.getStrMappedHospCmbWS().size()>0)				
			{				
				strMappedHospCmb = hisutil.getOptionValue(vo.getStrMappedHospCmbWS(),vo.getStrMapHospId(), "0^Select Value", true);
			}		
			
			//System.out.println("strMappedHospCmb----"+strMappedHospCmb);
			
			formBean.setStrMappedHospCmb(strMappedHospCmb);
			
			
						
			if (vo.getStrDistrictDWHTypeCmb() != null) 
			{
				 cmb5 = hisutil.getOptionValue(vo.getStrDistrictDWHTypeCmb(),vo.getStrDistrictDrugWarehouseTypeId(), "0^Select Value", true);				
			}
			
			//System.out.println("vo.getStrHospitalTypeCmbWs().size()----"+vo.getStrHospitalTypeCmbWs().size());
			
			//System.out.println("vo.getStrMapHospId()--DATA--"+vo.getStrMapHospId());
			
			
			
			
			TransferObjectFactory.populateData(formBean, vo);
			formBean.setStrDistrictDrugWarehouseTypeCmb(cmb5);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrNoOfBeds(vo.getStrNoOfBeds());
			formBean.setStrFinEndDate(vo.getStrFinEndDate());
			formBean.setStrFinStartDate(vo.getStrFinStartDate());
			formBean.setStrEndDateMonth(vo.getStrEndDateMonth());
			formBean.setStrEndDateYear(vo.getStrEndDateYear());
			formBean.setStrStartDateMonth(vo.getStrStartDateMonth());
			formBean.setStrStartDateYear(vo.getStrStartDateYear());
			formBean.setStrRightRequestTypeList(cmb2);
			formBean.setStrLeftRequestTypeList(cmb1);//strRightDeptReqTypeList
			formBean.setStrRightDeptReqTypeList(deptcmb);
			formBean.setStrDeptCode(vo.getStrDeptCode());
			formBean.setStrWardCode(vo.getStrWardCode());
			formBean.setStrDrugWarehouseTypeId(vo.getStrStoreTypeId());
			//formBean.setStrStoreTypeName(strStoreTypeName);
			formBean.setStrDistrictCmb(cmb);
			formBean.setStrLocation(vo.getStrLocation());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrDLNo(vo.getStrDLNo());
			formBean.setStrEmdType(vo.getStrEmdType());
			formBean.setStremdtypehidden(vo.getStrEmdType());
			if(vo.getStrCode()!=null && vo.getStrCode().contains("-"))
			{
				formBean.setStrStateShortCode(vo.getStrCode().split("\\-")[0]);
				formBean.setStrCode(vo.getStrCode().split("\\-")[1]);
			}
			else
			{
				formBean.setStrStateShortCode(MmsConfigUtil.STATE_SHORT_CODE);
				formBean.setStrCode(vo.getStrCode()!=null?vo.getStrCode():"0");
			}
			
			if("1".equals(vo.getStrTimeBoundFlag())) 
			{
				formBean.setfTimeBoundFlag(true);
			} 
			else 
			{
				formBean.setfTimeBoundFlag(false);
			}
			formBean.setStrSection(vo.getStrSection());
			formBean.setStrFromTime(vo.getStrFromTime());
			formBean.setStrToTime(vo.getStrToTime());
			/*if(vo.getStrSection().equals("1"))
			{
				formBean.setStrSection("Store");
			}
			if(vo.getStrSection().equals("2"))
			{
				formBean.setStrSection("Purchase");
			}*/
			formBean.setStrChk1(chk);
			
			if (vo.getStrHospitalTypeCmbWs() != null && vo.getStrHospitalTypeCmbWs().size() != 0) 
			{
				cmb4 = hisutil.getOptionValue(vo.getStrHospitalTypeCmbWs(),vo.getStrMapHospId(),"0^Select Value", true);
			}
			else 
			{

				cmb4 = "<option value='0'>SelectValue</option>";
			}
			
			//System.out.println("cmb4----"+cmb4);
			
			formBean.setStrHospitalTypeCombo(cmb4);

		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			strmsgText = "Store Master.StoreMstDATA.modifyRecord(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StoreMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(StoreMstFB formBean,
			HttpServletRequest request) {
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strFinancialStartDateMonthName;
		String strFinancialEndDateMonthName;
		
		DateFormatSymbols dateFormatSymbols=null;
		
		try {
			bo = new StoreMstBO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			//String strStoreTypeId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(strtemp[0]);
			formBean.setStrStoreId(strtemp[1]);

			formBean.setStrSeatId(seatid);
			
			
			
			/*
			 * Added by Aritra. (03.Feb.2011)
			 * Reason: Financial Date Issue.
			 */
			dateFormatSymbols=new DateFormatSymbols();
			strFinancialStartDateMonthName=dateFormatSymbols.getShortMonths()[Integer.parseInt(formBean.getStrStartDateMonth())-1];
			strFinancialEndDateMonthName=dateFormatSymbols.getShortMonths()[Integer.parseInt(formBean.getStrEndDateMonth())-1];
			
			strFinancialStartDate="01-"+strFinancialStartDateMonthName+"-"+formBean.getStrStartDateYear();
			strFinancialEndDate="28-"+strFinancialEndDateMonthName+"-"+formBean.getStrEndDateYear();
			
			formBean.setStrFinStartDate(strFinancialStartDate);
			formBean.setStrFinEndDate(strFinancialEndDate);
			
            //MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
			formBean.setStrConfigStoreCatg("10");
			
			/* -0- */
			
			vo = (StoreMstVO) TransferObjectFactory.populateData("mms.masters.vo.StoreMstVO", formBean);
			
			vo.setStrCode(formBean.getStrStateShortCode() + "-" + formBean.getStrCode());
			String strStoreTypeId = "0";
			if(formBean.getStrDrugWarehouseTypeId().split("\\^")[0]!=null)
				strStoreTypeId=formBean.getStrDrugWarehouseTypeId().split("\\^")[0];
			vo.setStrStoreTypeId(strStoreTypeId);// Adil
			/*
			 * Added by Aritra. (07.Feb.2011)
			 * Reason: Time Bound Issue.
			 */
			if(formBean.isfTimeBoundFlag()) {
				vo.setStrTimeBoundFlag("1");
			}else {
				vo.setStrTimeBoundFlag("0");
				vo.setStrFromTime("");
				vo.setStrToTime("");
			}
			
			/* -0- */

			
			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {

			strmsgText = "Store Master.StoreMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
		return retValue;
	}

	/**
	 * To get values of Block Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getBlockCombo(StoreMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = request.getSession().getAttribute(
				"HOSPITAL_CODE").toString();
		String strSeatId = request.getSession().getAttribute("SEATID")
				.toString();
		String strBuildingId = (String) request.getParameter("buildingName");

		try {

			bo = new StoreMstBO();
			vo = new StoreMstVO();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrBuildingCode(strBuildingId);

			bo.getBlockCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreMstDATA");
			String cmb = hisutil.getOptionValue(vo.getStrBlockCmbWs(), vo
					.getStrBlockId(), "0^Select Value", true);

			vo.setStrBlockCmb(cmb);
			formBean.setStrBlockCmb(vo.getStrBlockCmb());
			String comboValues = formBean.getStrBlockCmb();

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(comboValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "StoreMaster.StoreMstDATA.getBlockCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->getBlockCombo()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	/**
	 * To get values of Floor Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getFloorCombo(StoreMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = request.getSession().getAttribute(
				"HOSPITAL_CODE").toString();
		String strSeatId = request.getSession().getAttribute("SEATID")
				.toString();
		String blockId = (String) request.getParameter("blockName");
		String buildingId = (String) request.getParameter("buildingName");

		try {

			bo = new StoreMstBO();
			vo = new StoreMstVO();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrBuildingCode(buildingId);
			vo.setStrBlockId(blockId);

			bo.getFloorCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreMstDATA");
			String cmb = hisutil.getOptionValue(vo.getStrFloorCmbWs(), vo
					.getStrFloorId(), "0^Select Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "StoreMaster.StoreMstDATA.getFloorCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->getFloorCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	
	/**
	 * To get values of Ward Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getDistrictDWHCmb(StoreMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request.getSession().getAttribute("SEATID").toString();
		String strDwhTypeCode = (String) request.getParameter("dwhTypeId");

		try 
		{

			bo = new StoreMstBO();
			vo = new StoreMstVO();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrDrugWarehouseTypeId(strDwhTypeCode);

			bo.getDistrictDWHCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreMstDATA");
		
			String cmb = hisutil.getOptionValue(vo.getStrDistrictDWHTypeCmb(),"0", "0^Select Value", true);
			
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "StoreMaster.StoreMstDATA.getDistructDWHCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->getDistructDWHCmb()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
	
	/**
	 * To get values of Ward Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getWardCombo(StoreMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = request.getSession().getAttribute(
				"HOSPITAL_CODE").toString();
		String strSeatId = request.getSession().getAttribute("SEATID")
				.toString();
		String strDeptCode = (String) request.getParameter("deptId");

		try {

			bo = new StoreMstBO();
			vo = new StoreMstVO();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrDeptCode(strDeptCode);

			bo.getWardCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreMstDATA");
			// // //System.out.println("vo.getStrWardComboWs(
			// size"+vo.getStrWardComboWs().size());
			String cmb = hisutil.getOptionValue(vo.getStrWardComboWs(), vo
					.getStrWardCode(), "0^Select Value", true);
			// // //System.out.println("cmb"+cmb);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "StoreMaster.StoreMstDATA.getWardCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreMstDATA->getWardCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
	public static void viewRecord(StoreMstFB formBean,HttpServletRequest request) 
	{
		StoreMstBO bo = null;
		StoreMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		//String temp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String cmb = null,cmb3=null,cmb5=null ,strMappedHospCmb=null,cmb1=null;
		//String strStoreTypeName = "";
	
		try 
		{
			bo = new StoreMstBO();
			vo = new StoreMstVO();
			hisutil = new HisUtil("mms", "StoreMstDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			//String comboValue = request.getParameter("comboValue");
			//temp = comboValue.replace("^", "#").split("#");

			//strStoreTypeName = temp[0];
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrStoreId(strtemp[1]);
			vo.setStrStateCode(mmscofigutil.getStrStateCode());
            vo.setStrMode("1");
			String seatid = request.getSession().getAttribute("SEATID").toString();
			//String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrSeatId(seatid);
			
            vo.setStrViewFlg("1");
			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			//added by shalini for dept and ward combo
			
			/*String cmbd = hisutil.getOptionValue(vo.getStrDepartmentComboWs(),vo.getStrDeptCode(), "0^Select Value", true);
			vo.setStrDepartmentCombo(cmbd);
			formBean.setStrDepartmentCombo(cmbd);
			bo.getWardCombo(vo);
			
			String cmbw = hisutil.getOptionValue(vo.getStrWardComboWs(), vo.getStrWardCode(), "0^Select Value", true);

			vo.setStrWardCombo(cmbw);
			formBean.setStrWardCombo(cmbw);*/
			
			/*if (vo.getStrInchargeCmbWs() != null) 
			{
				cmb1 = hisutil.getOptionValue(vo.getStrInchargeCmbWs(),"", "", true);				
			}
			vo.setStrLeftRequestTypeList(cmb1);

			//String cmb1 = hisutil.getOptionValue(vo.getStrInchargeCmbWs(), "", "", true);
		//	vo.setStrLeftRequestTypeList(cmb1);
			
			String cmb2 = hisutil.getOptionValue(vo.getStrRigthCmbWs(), "", "", true);
			vo.setStrRightRequestTypeList(cmb2);
            
			formBean.setStrConfigStoreCatg(mmscofigutil.getStrStoreConfigCatg());
            
			if (vo.getStrDistrictCmbWs() != null) 
			{
				cmb = hisutil.getOptionValue(vo.getStrDistrictCmbWs(),vo.getStrDistrictId(), "0^Select Value", true);				
			}
			formBean.setStrDistrictCmb(cmb);
			
			
			
			if (vo.getStrMappedHospCmbWS() != null && vo.getStrMappedHospCmbWS().size()>0)				
			{				
				strMappedHospCmb = hisutil.getOptionValue(vo.getStrMappedHospCmbWS(),vo.getStrMapHospId(), "0^Select Value", true);
			}			
			formBean.setStrMappedHospCmb(strMappedHospCmb);
			
						
			if (vo.getStrDistrictDWHTypeCmb() != null) 
			{
				 cmb5 = hisutil.getOptionValue(vo.getStrDistrictDWHTypeCmb(),vo.getStrDistrictDrugWarehouseTypeId(), "0^Select Value", true);				
			}*/
			
			String cmb2 = hisutil.getOptionValue(vo.getStrRigthCmbWs(), "0", "", true);
			vo.setStrRightRequestTypeList(cmb2);
			TransferObjectFactory.populateData(formBean, vo);
			//formBean.setStrDrugWarehouseTypeCmb(vo.getStrStoreTypeId());
			//formBean.setStrDistrictDrugWarehouseTypeCmb(cmb5);
			formBean.setStrStoreName(vo.getStrStoreName());
			if (vo.getStrDrugWarehouseTypeCmb() != null) 
			{
				cmb3 = hisutil.getOptionValue(vo.getStrDrugWarehouseTypeCmb(),vo.getStrStoreTypeId(), "0^Select Value", true);
			}
			formBean.setStrDrugWarehouseTypeCmb(vo.getStrStoreTypeId());
			//formBean.setStrNoOfBeds(vo.getStrNoOfBeds());
			//formBean.setStrFinEndDate(vo.getStrFinEndDate());
			//formBean.setStrFinStartDate(vo.getStrFinStartDate());
			/*formBean.setStrEndDateMonth(vo.getStrEndDateMonth());
			formBean.setStrEndDateYear(vo.getStrEndDateYear());
			formBean.setStrStartDateMonth(vo.getStrStartDateMonth());
			formBean.setStrStartDateYear(vo.getStrStartDateYear());
			formBean.setStrRightRequestTypeList(cmb2);
			formBean.setStrLeftRequestTypeList(cmb1);*/
			formBean.setStrDeptCode(vo.getStrDeptCode());
			formBean.setStrWardCode(vo.getStrWardCode());
			formBean.setStrRightRequestTypeList(cmb2);
			//formBean.setStrDrugWarehouseTypeId(vo.getStrStoreTypeId());
			//formBean.setStrStoreTypeName(strStoreTypeName);
			//formBean.setStrDistrictCmb(cmb);
			formBean.setStrLocation(vo.getStrLocation());
			if(vo.getStrCode()!=null && vo.getStrCode().contains("-"))
			{
				formBean.setStrStateShortCode(vo.getStrCode().split("\\-")[0]);
				formBean.setStrCode(vo.getStrCode().split("\\-")[1]);
			}
			else
			{
				formBean.setStrStateShortCode(MmsConfigUtil.STATE_SHORT_CODE);
				formBean.setStrCode(vo.getStrCode()!=null?vo.getStrCode():"0");
			}
			
			if("1".equals(vo.getStrTimeBoundFlag())) 
			{
				formBean.setfTimeBoundFlag(true);
			} 
			else 
			{
				formBean.setfTimeBoundFlag(false);
			}
			//formBean.setStrSection(vo.getStrSection());
			formBean.setStrFromTime(vo.getStrFromTime());
			formBean.setStrToTime(vo.getStrToTime());
			if(vo.getStrSection().equals("1"))
			{
				formBean.setStrSection("Store");
			}
			if(vo.getStrSection().equals("2"))
			{
				formBean.setStrSection("Purchase");
			}
			formBean.setStrChk1(chk);
            formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			strmsgText = "Store Master.StoreMstDATA.modifyRecord(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StoreMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

}
