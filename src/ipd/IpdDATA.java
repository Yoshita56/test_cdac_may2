package ipd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.persistence.HisResultSet;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisMethods;

public class IpdDATA {

	public static void initTariffChargeDetails(HttpServletRequest request, HttpServletResponse response,IpdFB formBean){
		
		try{
		
		IpdVO voObj = new IpdVO();
		voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
		IpdBO bo = new IpdBO();
				
		formBean.setChargeTypeId(request.getParameter("chargeTypeId"));
		formBean.setCategoryCode(request.getParameter("categoryCode"));
		formBean.setWardCode(request.getParameter("wardCode"));
		formBean.setGroupId(request.getParameter("groupId"));
		formBean.setSearchText(request.getParameter("searchText"));
		formBean.setPkgflag(request.getParameter("pkgFlag"));
			
     // set the hospital code form session, now just setting the hardcodded value. 
	
		voObj.setStrValue1(formBean.getChargeTypeId());
		voObj.setStrValue2(formBean.getCategoryCode());
		voObj.setStrValue3(formBean.getWardCode());
		voObj.setStrValue4(formBean.getGroupId());
		voObj.setStrValue5(formBean.getSearchText());
		voObj.setStrValue6(formBean.getHospitalCode());
		voObj.setStrValue7(formBean.getPkgflag());
		
		bo.getChargeTariffDetails(voObj);
		
		if(voObj.getStrMsgType().equals("0")){
		formBean.setStrResultWs(voObj.getGblWs1());
		
		String val = HLPipd.getTariffChargeView(formBean.getStrResultWs());
		
		response.setHeader("Cache-Control", "no-cache");
		
		
		response.getWriter().print(val);
		
		}else{
			
			throw new Exception(voObj.getStrMsgString());
			
		}
		
		}catch(Exception e){
			
			new HisException("Global Ipd File","hisglobal.IpdDATA.initTariffChargeDetails()-->",e.getMessage());
			
		}
	}
	public static void getPatientListingDtls(HttpServletRequest request,
			HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{

			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			if(strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}
			
			if(strPatListType.equals("4"))
			{//Admission Advice
				
				IpdConfigUtil ipdUtil = new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				voObj.setStrValue9(ipdUtil.getStrAdmissionAdviceValidityFrom());
				voObj.setStrValue10(ipdUtil.getStrAdmissionAdviceValidityTo());
				
			}
			
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			
			voObj.setStrValue8(formBean.getHospitalCode());
			
			StringBuffer query = new StringBuffer(1500);
			query.append(" SELECT distinct(substr(gnum_column_value,0,3)) as deptCode");
			query.append(" FROM GBLT_ROLE_SEAT_TABLE_DTL P,GBLT_METATABLE_COLUMN_MST Q WHERE P.GNUM_METATABLE_ID = Q.GNUM_METATABLE_ID ");                         
			query.append(" AND Q.GSTR_TABLE_NAME = 'HGBT_UNIT_MST' AND Q.GSTR_COLUMN_NAME = 'HGNUM_DEPTUNITCODE' ");                         
			query.append(" AND P.GNUM_SEATID = PKG_USERMGMT.FUN_GETSEATID('"+voObj.getStrSeatId()+"',"+voObj.getHospitalCode()+") ");                         
			query.append(" AND P.GNUM_HOSPITAL_CODE ="+voObj.getHospitalCode()+"LIMIT 1 ");		
			System.out.println("query.toString() "+query.toString());
			HisMethods hisMethods=new HisMethods();
			HisResultSet hrs=hisMethods.getRecord(query.toString());
			String deptCode="0";
			String wardCode="0";
			int i=0;
			while(hrs.next())
			{
				if(i==0)
				{
						deptCode=hrs.getString(1);
						i++;
				}
				else
				{
					deptCode+=","+hrs.getString(1);
					i++;
				}
				
			}
			
			StringBuffer query1 = new StringBuffer(1500);
			query1.append("SELECT GNUM_COLUMN_VALUE as wardCode FROM GBLT_ROLE_SEAT_TABLE_DTL P,GBLT_METATABLE_COLUMN_MST Q "); 						
			query1.append(" WHERE P.GNUM_METATABLE_ID = Q.GNUM_METATABLE_ID AND Q.GSTR_TABLE_NAME = 'HIPT_WARD_MST' "); 						
			query1.append(" AND Q.GSTR_COLUMN_NAME = 'HIPNUM_WARD_CODE' AND P.GNUM_SEATID = PKG_USERMGMT.FUN_GETSEATID('"+voObj.getStrSeatId()+"',"+voObj.getHospitalCode()+") "); 						
			query1.append("  AND P.GNUM_HOSPITAL_CODE = "+voObj.getHospitalCode()+" LIMIT 1");
			System.out.println("query1.toString() "+query1.toString());
			hrs=hisMethods.getRecord(query1.toString());
			i=0;
			while(hrs.next())
			{
				if(i==0)
				{
						wardCode=hrs.getString(1);
						i++;
				}
				else
				{
					wardCode+=","+hrs.getString(1);
					i++;
				}
			}
			
			voObj.setStrDeptUnitCode(deptCode);
			voObj.setStrWardCode(wardCode);
			
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(voObj.getStrValue1().equals("6")){
					val = HLPipd.getMotherPatientListingView(voObj);
				}else{
					val = HLPipd.getPatientListingView(voObj);
				}
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(val);

			} else {

				throw new Exception(voObj.getStrMsgString());

			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e
							.getMessage());

		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	
	
	
	public static void getPatientListingDtlsModification(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			//System.out.println("---------------------------------------^^^^^^----------------------^^^^^----------------");
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			//strPatListType---1 ,2,3 Leave & 4 Adviced Patient List Used in Patient Admission 
			//& 5 Admitted Patient List Used in Final Discharge Process 
			//& 6 Mother List Used in New Born Baby Admission Process 
			//& 8 Admitted But Not Accepted Patient List Used in Admission Modification & Admission Cancellation Process
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");//CR No/Patient Name
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			/*System.out.println("patListType"+strPatListType);
			System.out.println("strSearchString"+strSearchString);
			System.out.println("strSearchType"+strSearchType);
			System.out.println("strFromRow"+strFromRow);
			System.out.println("strRowPerPage"+strRowPerPage);
			System.out.println("strCtBlockSet"+strCtBlockSet);*/
			
			if(strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}
			
			if(strPatListType.equals("4"))
			{//Admission Adviced Patient
				
				IpdConfigUtil ipdUtil = new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				voObj.setStrValue9(ipdUtil.getStrAdmissionAdviceValidityFrom());
				voObj.setStrValue10(ipdUtil.getStrAdmissionAdviceValidityTo());				
			}
			
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			
			voObj.setStrValue8(formBean.getHospitalCode());
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.getPatientListingViewModification(voObj);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}		
		} 
		catch (Exception e) 
		{
			new HisException("ADT","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void getPatientListingDtlsModification_BS(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			//strPatListType---1 ,2,3 Leave & 4 Adviced Patient List Used in Patient Admission 
			//& 5 Admitted Patient List Used in Final Discharge Process 
			//& 6 Mother List Used in New Born Baby Admission Process 
			//& 8 Admitted But Not Accepted Patient List Used in Admission Modification & Admission Cancellation Process
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");//CR No/Patient Name
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			/*System.out.println("patListType"+strPatListType);
			System.out.println("strSearchString"+strSearchString);
			System.out.println("strSearchType"+strSearchType);
			System.out.println("strFromRow"+strFromRow);
			System.out.println("strRowPerPage"+strRowPerPage);
			System.out.println("strCtBlockSet"+strCtBlockSet);*/
			
			if(strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}
			
			if(strPatListType.equals("4"))
			{//Admission Adviced Patient
				
				IpdConfigUtil ipdUtil = new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				voObj.setStrValue9(ipdUtil.getStrAdmissionAdviceValidityFrom());
				voObj.setStrValue10(ipdUtil.getStrAdmissionAdviceValidityTo());				
			}
			
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			
			voObj.setStrValue8(formBean.getHospitalCode());
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				
				if(voObj.getStrValue1().equals("10"))
					val = HLPipd.getPatientListingView_admitted_BS(voObj); //Single Window Transfer/Admitted List
				else				
					val = HLPipd.getPatientListingViewModification_BS(voObj);
				
				//val=val+" <script>$(#Datatable).DataTable();</script>";
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}		
		} 
		catch (Exception e) 
		{
			new HisException("ADT","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}

	/******bedStaus popUp******/
		public static void beddetail(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) {
		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try {
		voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
		String tmp=request.getParameter("modPopUp");
		String imagepath= request.getParameter("imagepath");
		if(imagepath!=null)
			voObj.setStrImagePath("/AHIMS");
		else
			voObj.setStrImagePath("../..");
			//voObj.setStrImagePath("/AHIMS");
		String temp[]=tmp.replace('^','#').split("#");
		voObj.setStrWardCode(temp[0]);
		voObj.setStrRoomCode(temp[1]);
		voObj.setStrBedTypeCode(temp[2]);
		voObj.setStrDeptUnitCode(temp[3]);
		try
		{
			voObj.setStrCRNo(temp[4]);
		}
		catch(Exception e)
		{
			voObj.setStrCRNo("");
		}
		BO.setBedDetails(voObj);
		
		/***setting logic for default window size***/
		
		if(request.getParameter("hmode").equals("BEDDETAILS")){
			voObj.setStrBedChartMode("process_Admsn");
		}
		else
			voObj.setStrBedChartMode("process_Other");
		
		/*******************end**********************/
		
		String strbed=HLPipd.getBedDetails(voObj);
		formBean.setStrWinResize(voObj.getStrWinResize());
		if(request.getParameter("hmode").equals("BEDDETAILS")){
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strbed+"^"+voObj.getStrVacantBed());
		}
		
		formBean.setStrBedProperty(strbed);		
			formBean.setStrMsgType(voObj.getStrMsgType());
				if(formBean.getStrMsgType().equals("1")) {
					formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) {
			String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "IpdDATA->beddetail()", strmsgText);
			   formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		}
		finally {
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}
		public static void beddetail1(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) {
			
			IpdVO voObj=new IpdVO();
			IpdBO BO=new IpdBO();
			try {
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			String tmp=request.getParameter("modPopUp");
			String imagepath= request.getParameter("imagepath");
			if(imagepath!=null)
				voObj.setStrImagePath("/AHIMS");
			else
				voObj.setStrImagePath("../..");
				//voObj.setStrImagePath("/AHIMS");
			String temp[]=tmp.replace('^','#').split("#");
			voObj.setStrWardCode(temp[0]);
			voObj.setStrRoomCode(temp[1]);
			voObj.setStrBedTypeCode(temp[2]);
			voObj.setStrDeptUnitCode(temp[3]);
			try
			{
				voObj.setStrCRNo(temp[4]);
			}
			catch(Exception e)
			{
				voObj.setStrCRNo("");
			}
			BO.setBedDetails(voObj);
			
			/***setting logic for default window size***/
			
			if(request.getParameter("hmode").equals("BEDDETAILS")){
				voObj.setStrBedChartMode("process_Admsn");
			}
			else
				voObj.setStrBedChartMode("process_Other");
			
			/*******************end**********************/
			
			String strbed=HLPipd.getBedDetails1(voObj);
			formBean.setStrWinResize(voObj.getStrWinResize());
			if(request.getParameter("hmode").equals("BEDDETAILS")){
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strbed+"^"+voObj.getStrVacantBed());
			}
			
			formBean.setStrBedProperty(strbed);		
				formBean.setStrMsgType(voObj.getStrMsgType());
					if(formBean.getStrMsgType().equals("1")) {
						formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
					throw new Exception(formBean.getStrErrMsgString());
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				String strmsgText = e.getMessage();
				   HisException eObj = new HisException("IPD", "IpdDATA->beddetail()", strmsgText);
				   formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				     eObj = null;
			}
			finally {
				if(voObj != null) voObj = null;
				if(formBean != null) formBean = null;
			}
		}
	
public static void beddetailIPD(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) {
		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try {
		voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
		//String tmp=request.getParameter("modPopUp");
		String imagepath= request.getParameter("imagepath");
		if(imagepath!=null)
			voObj.setStrImagePath("/AHIMS");
		else
			voObj.setStrImagePath("../..");
			//voObj.setStrImagePath("/AHIMS");
		/*String temp[]=tmp.replace('^','#').split("#");
		voObj.setStrWardCode(temp[0]);
		voObj.setStrRoomCode(temp[1]);
		voObj.setStrBedTypeCode(temp[2]);
		voObj.setStrDeptUnitCode(temp[3]);
		try
		{
			voObj.setStrCRNo(temp[4]);
		}
		catch(Exception e)
		{
			voObj.setStrCRNo("");
		}*/
		voObj.setStrWardCode(request.getParameter("wardCode"));
		voObj.setStrRoomCode(request.getParameter("roomCode"));
		voObj.setStrBedTypeCode("0");
		voObj.setStrDeptUnitCode(request.getParameter("departmentUnitCode"));
		/*try
		{
			voObj.setStrCRNo(request.getParameter("patCrNo"));
		}
		catch(Exception e)
		{
			voObj.setStrCRNo("");
		}*/
		BO.setBedDetails(voObj);
		
		/***setting logic for default window size***/
		
		if(request.getParameter("hmode").equals("BEDDETAILS")){
			voObj.setStrBedChartMode("process_Admsn");
		}
		else
			voObj.setStrBedChartMode("process_Other");
		
		/*******************end**********************/
		
		String strbed=HLPipd.getBedDetails(voObj);
		formBean.setStrWinResize(voObj.getStrWinResize());
		if(request.getParameter("hmode").equals("BEDDETAILS")){
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strbed+"^"+voObj.getStrVacantBed());
		}
		
		formBean.setStrBedProperty(strbed);		
			formBean.setStrMsgType(voObj.getStrMsgType());
				if(formBean.getStrMsgType().equals("1")) {
					formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) {
			String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "IpdDATA->beddetailIPD()", strmsgText);
			   formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		}
		finally {
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}

	/*****bed Ststus popUp ends******/
	// for patient Admission
public static void beddetailPatAdmission(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) 
{		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try 
		{
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			String tmp=request.getParameter("modPopUp");
			String imagepath= request.getParameter("imagepath");
			if(imagepath!=null)
				voObj.setStrImagePath("/AHIMS");
			else
				voObj.setStrImagePath("../..");
			String temp[]=tmp.replace('^','#').split("#");
			voObj.setStrWardCode(temp[0]);
			voObj.setStrRoomCode(temp[1]);
			voObj.setStrBedTypeCode(temp[2]);
			//voObj.setStrDeptUnitCode(temp[3]);
			try
			{
				voObj.setStrCRNo(temp[4]);
			}
			catch(Exception e)
			{
				voObj.setStrCRNo("");
			}
			voObj.setStrDeptUnitCode(temp[5]);
			BO.setBedDetailPatAdmission(voObj);
			
			/***setting logic for default window size***/
			
			if(request.getParameter("hmode").equals("BEDDETAILSPATADMISSION"))
			{
				voObj.setStrBedChartMode("process_Admsn");
			}
			else
				voObj.setStrBedChartMode("process_Other");
			
			/*******************end**********************/
			
			String strbed=HLPipd.getBedDetails(voObj);
			formBean.setStrWinResize(voObj.getStrWinResize());
			if(request.getParameter("hmode").equals("BEDDETAILSPATADMISSION"))
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strbed+"^"+voObj.getStrVacantBed());
			}
			
			formBean.setStrBedProperty(strbed);		
			formBean.setStrMsgType(voObj.getStrMsgType());
			if(formBean.getStrMsgType().equals("1")) 
			{
				formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e)
		{
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD", "IpdDATA->beddetail()", strmsgText);
			formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally 
		{
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}


public static void bedProperties(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) {
		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try {
		voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
		String tmp=request.getParameter("modPopUp");
		String imagepath= request.getParameter("imagepath");
		if(imagepath!=null)
			voObj.setStrImagePath("/AHIMS");
		else
			voObj.setStrImagePath("../..");
		String temp[]=tmp.replace('^','#').split("#");
		voObj.setStrWardCode(temp[0]);
		voObj.setStrRoomCode(temp[1]);
		voObj.setStrBedTypeCode(temp[2]);
		voObj.setStrDeptUnitCode(temp[3]);
		BO.setBedProperties(voObj);
		
		/***setting logic for default window size***/
		
		if(request.getParameter("hmode").equals("BEDDETAILS"))
		{
			voObj.setStrBedChartMode("process_Admsn");
		}
		else
			voObj.setStrBedChartMode("process_Other");
		
		/*******************end**********************/
		
		String strbed=HLPipd.setBedProperties(voObj);
		formBean.setStrWinResize(voObj.getStrWinResize());
		if(request.getParameter("hmode").equals("BEDPROPERTIES"))
		{
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strbed);
		}
		
		formBean.setStrBedProperty(strbed);		
			formBean.setStrMsgType(voObj.getStrMsgType());
				if(formBean.getStrMsgType().equals("1")) {
					formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) {
			String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "IpdDATA->bedProperties()", strmsgText);
			   formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		}
		finally {
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}
	public static void wardStatistics(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try 
		{
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			String tmp=request.getParameter("modPopUp");
			String temp[]=tmp.replace('^','#').split("#");
			
			String temp1[]=request.getParameter("modComboNames").replace('^','#').split("#");
			
			voObj.setStrDeptCode(temp[0]);
			voObj.setStrDeptUnitCode(temp[1]);
			voObj.setStrWardCode(temp[2]);
			voObj.setStrRoomCode(temp[3]);
			
			BO.wardStatistics(voObj);
			
			String[] wardStat=null;
			wardStat=voObj.getWardStatistics().replace("^","#").split("#");
			
			formBean.setStrTotalPresentPat(wardStat[0]);
			formBean.setStrTotalAdmittedPat(wardStat[1]);
			formBean.setStrTotalNewPat(wardStat[2]);
			formBean.setStrTotalNonAcceptedPat(wardStat[3]);
			formBean.setStrTotalTransitPat(wardStat[4]);
			formBean.setStrTotalTransferInPat(wardStat[5]);
			formBean.setStrTotalTransferOutPat(wardStat[6]);
			formBean.setStrTotalDischargePat(wardStat[7]);
			formBean.setStrTotalDeathPat(wardStat[8]);
			formBean.setStrTotalBedAval(wardStat[9]);
			
			formBean.setStrDeptName(temp1[0]);
			formBean.setStrDeptUnitName(temp1[1]);
			formBean.setStrWardName(temp1[2]);
			formBean.setStrRoomName(temp1[3]);
			
			formBean.setStrWinResize(voObj.getStrWinResize());
			formBean.setStrMsgType(voObj.getStrMsgType());
			
			if(formBean.getStrMsgType().equals("1")) 
			{
			formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
			throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) 
		{
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("ADT", "IpdDATA->bedProperties()", strmsgText);
			formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally 
		{
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}
	/******bedStaus dashbaord******/
	public static void bedstatusdasboard(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try 
		{
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			/*String tmp=request.getParameter("modPopUp");
			String temp[]=tmp.replace('^','#').split("#");
			voObj.setStrWardCode(temp[0]);
			voObj.setStrRoomCode(temp[1]);
			voObj.setStrBedTypeCode(temp[2]);
			voObj.setStrDeptUnitCode(temp[3]);
			try
			{
				voObj.setStrCRNo(temp[4]);
			}
			catch(Exception e)
			{
				voObj.setStrCRNo("");
			}*/
			BO.bedstatusdasboard(voObj);
			
			String strbed=HLPipd.bedstatusdasboard(voObj);
			
			formBean.setTotalBedDiv(HLPipd.bedstatusdasboardToal(voObj));
			
			
			//System.out.println("strbed"+strbed);
			formBean.setBedStatusDash(strbed);
			formBean.setStrMsgType(voObj.getStrMsgType());
			if(formBean.getStrMsgType().equals("1")) 
			{
				formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) 
		{
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD", "IpdDATA->bedstatusdasboard()", strmsgText);
			formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			 eObj = null;
		}
		finally 
		{
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}
	public static void beddetail2(IpdFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{		
		IpdVO voObj=new IpdVO();
		IpdBO BO=new IpdBO();
		try 
		{
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			String tmp=request.getParameter("modPopUp");
			String imagepath= request.getParameter("imagepath");
			if(imagepath!=null)
				voObj.setStrImagePath("/AHIMS");
			else
				voObj.setStrImagePath("../..");
				//voObj.setStrImagePath("/AHIMS");
			String temp[]=tmp.replace(',','#').split("#");
			voObj.setStrWardCode(temp[0]);
			voObj.setStrRoomCode(temp[1]);
			voObj.setStrBedTypeCode(temp[2]);
			voObj.setStrDeptUnitCode(temp[3]);
			try
			{
				voObj.setStrCRNo(temp[4]);
			}
			catch(Exception e)
			{
				voObj.setStrCRNo("");
			}
			BO.setBedDetails(voObj);
			
			/***setting logic for default window size***/
			
			if(request.getParameter("hmode").equals("BEDDETAILS"))
			{
				voObj.setStrBedChartMode("process_Admsn");
			}
			else
				voObj.setStrBedChartMode("process_Other");
			
			/*******************end**********************/
			
			String strbed=HLPipd.getBedDetails1(voObj);
			formBean.setStrWinResize(voObj.getStrWinResize());
			if(request.getParameter("hmode").equals("BEDDETAILS") || request.getParameter("hmode").equals("BEDSTATUSPATADM"))
			{
				response.setHeader("Cache-Control", "no-cache");
	//			response.getWriter().print(strbed+"^"+voObj.getStrVacantBed());
			}
			
			formBean.setStrBedProperty(strbed);		
			formBean.setStrMsgType(voObj.getStrMsgType());
			if(formBean.getStrMsgType().equals("1")) 
			{
				formBean.setStrErrMsgString(voObj.getStrErrMsgString());//error
				throw new Exception(formBean.getStrErrMsgString());
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD", "IpdDATA->beddetail()", strmsgText);
			formBean.setStrErrMsgString("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally 
		{
			if(voObj != null) voObj = null;
			if(formBean != null) formBean = null;
		}
	}
	
	public static void getPatientListingDtls_BS(HttpServletRequest request,
			HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{

			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			
			
			String strPatListType = request.getParameter("patListType");
			String strSearchString = request.getParameter("searchString");
			String strSearchType = request.getParameter("searchType");
			String strFromRow = request.getParameter("fromRow");
			String strRowPerPage = request.getParameter("rowPerPage");
			String strCtBlockSet = request.getParameter("ctBlockSet");
			if(strSearchString.contains("^"))
			{
				strSearchString = strSearchString.replace('^', '%');
			}
			
			if(strPatListType.equals("4"))
			{//Admission Advice
				
				IpdConfigUtil ipdUtil = new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				voObj.setStrValue9(ipdUtil.getStrAdmissionAdviceValidityFrom());
				voObj.setStrValue10(ipdUtil.getStrAdmissionAdviceValidityTo());
				
			}
			
			voObj.setStrValue1(strPatListType);
			voObj.setStrValue2(strSearchString);
			voObj.setStrValue3(strSearchType);
			voObj.setStrValue4(strFromRow);
			int nToRow = Integer.parseInt(strFromRow) + Integer.parseInt(strRowPerPage) * 10;
			voObj.setStrValue5(String.valueOf(nToRow));
			voObj.setStrValue6(strRowPerPage);
			voObj.setStrValue7(strCtBlockSet);
			
			voObj.setStrValue8(formBean.getHospitalCode());
			
			StringBuffer query = new StringBuffer(1500);
			query.append(" SELECT distinct(substr(gnum_column_value,0,3)) as deptCode");
			query.append(" FROM GBLT_ROLE_SEAT_TABLE_DTL P,GBLT_METATABLE_COLUMN_MST Q WHERE P.GNUM_METATABLE_ID = Q.GNUM_METATABLE_ID ");                         
			query.append(" AND Q.GSTR_TABLE_NAME = 'HGBT_UNIT_MST' AND Q.GSTR_COLUMN_NAME = 'HGNUM_DEPTUNITCODE' ");                         
			query.append(" AND P.GNUM_SEATID = PKG_USERMGMT.FUN_GETSEATID('"+voObj.getStrSeatId()+"',"+voObj.getHospitalCode()+") ");                         
			query.append(" AND P.GNUM_HOSPITAL_CODE ="+voObj.getHospitalCode()+" ");		
			
			//HisMethods hisMethods=new HisMethods();
			HisDAO dao=new HisDAO("ADT", "IpdDATA");
			WebRowSet hrs= dao.getQryResult(query.toString());
			//HisResultSet hrs=hisMethods.getRecord(query.toString());
			String deptCode="0";
			String wardCode="0";
			int i=0;
			while(hrs.next())
			{
				if(i==0)
				{
						deptCode=hrs.getString(1);
						i++;
				}
				else
				{
					deptCode+=","+hrs.getString(1);
					i++;
				}
				
			}
			
			StringBuffer query1 = new StringBuffer(1500);
			query1.append("SELECT GNUM_COLUMN_VALUE as wardCode FROM GBLT_ROLE_SEAT_TABLE_DTL P,GBLT_METATABLE_COLUMN_MST Q "); 						
			query1.append(" WHERE P.GNUM_METATABLE_ID = Q.GNUM_METATABLE_ID AND Q.GSTR_TABLE_NAME = 'HIPT_WARD_MST' "); 						
			query1.append(" AND Q.GSTR_COLUMN_NAME = 'HIPNUM_WARD_CODE' AND P.GNUM_SEATID = PKG_USERMGMT.FUN_GETSEATID('"+voObj.getStrSeatId()+"',"+voObj.getHospitalCode()+") "); 						
			query1.append("  AND P.GNUM_HOSPITAL_CODE = "+voObj.getHospitalCode()+" ");
			
			//hrs=hisMethods.getRecord(query1.toString());
			 hrs= dao.getQryResult(query1.toString());
			i=0;
			while(hrs.next())
			{
				if(i==0)
				{
						wardCode=hrs.getString(1);
						i++;
				}
				else
				{
					wardCode+=","+hrs.getString(1);
					i++;
				}
			}
			
			voObj.setStrDeptUnitCode(deptCode);
			voObj.setStrWardCode(wardCode);
			
			
			bo.getPatientListingDtl(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				if(voObj.getStrValue1().equals("6"))
					val = HLPipd.getMotherPatientListingView(voObj);
				else if(voObj.getStrValue1().equals("10"))
					val = HLPipd.getPatientListingView_admitted_BS(voObj);
				else{
					val = HLPipd.getPatientListingView_BS(voObj);
				}
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(val);

			} else {

				throw new Exception(voObj.getStrMsgString());

			}
			
			
		} catch (Exception e) {

			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e
							.getMessage());

		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void jobtracking(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			bo.jobtracking(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				//formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.jobtracking_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Enquiry","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void processtracking(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDatept"));
			formBean.setStrToDate(request.getParameter("strToDatept"));
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			bo.processtracking(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.processtracking_hlp(voObj);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Enquiry","hisglobal.IpdDATA.processtracking()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	
	public static String crTrackingDetails(String crNo, String hospCode) 
	{
		IpdVO voObj = null;
		IpdBO bo = null;
		String val = "";
		
		try 
		{
			voObj = new IpdVO();
			//voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			voObj.setStrHospCode(hospCode);
			voObj.setStrCRNo(crNo);
			
			
			bo = new IpdBO();
			bo.crTrackingDetails(voObj);
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				val = HLPipd.crTrackingDetails_hlp(voObj);				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("ADT","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			return val;
		}
	}
		
	public static void userWiseFreqClickMenu(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrHospCode(formBean.getHospitalCode());
			bo.userWiseFreqClickMenu(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.userWiseFreqClickMenu_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	public static void Activitylog(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		System.out.println("GET ACTIVITY LOG-TRANS");
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			formBean.setStrUsrId(request.getParameter("strUsrId"));
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrValue3(formBean.getStrUsrId());
			bo.activitylog(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.activitylog_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void GetActivitylog(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		System.out.println("USERWISE FREQMENU-MENULOG");
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			formBean.setStrUsrId(request.getParameter("strUsrId"));
			formBean.setStrProcessName(request.getParameter("strProcessName"));
			formBean.setStrMenuName(request.getParameter("strMenuName"));
			
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrValue3(formBean.getStrUsrId());
			voObj.setStrValue4(formBean.getStrProcessName());
			voObj.setStrValue5(formBean.getStrMenuName());
			bo.getactivitylog(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.getactivitylog_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void GetActivityTranslog(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		System.out.println("USERWISE FREQMENU-TRANSLOG");
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			formBean.setStrUsrId(request.getParameter("strUsrId"));
			formBean.setStrProcessName(request.getParameter("strProcessName"));
			formBean.setStrMenuName(request.getParameter("strMenuName"));
			
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrValue3(formBean.getStrUsrId());
			voObj.setStrValue4(formBean.getStrProcessName());
			voObj.setStrValue5(formBean.getStrMenuName());
			bo.getactivityTranslog(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.getactivitytranslog_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void GetActivityMenulog(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		System.out.println("USERWISE FREQMENU-MENULOG");
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			formBean.setStrUsrId(request.getParameter("strUsrId"));
			formBean.setStrProcessName(request.getParameter("strProcessName"));
			formBean.setStrMenuName(request.getParameter("strMenuName"));
			
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrValue3(formBean.getStrUsrId());
			voObj.setStrValue4(formBean.getStrProcessName());
			voObj.setStrValue5(formBean.getStrMenuName());
			bo.getactivityMnuelog(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.getactivitymenulog_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void Activitytranslog(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{
		System.out.println("GET ACTIVITY LOG-MENU LOG");
		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			formBean.setStrUsrId(request.getParameter("strUsrId"));
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			voObj.setStrValue3(formBean.getStrUsrId());
			bo.activitytranslog(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.activitytranslog_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	public static void processtrackinglisting(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			bo.processtrackinglisting(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.processtrackinglisting_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	public static void userwisetransdata(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			formBean.setStrFromDate(request.getParameter("strFromDate"));
			formBean.setStrToDate(request.getParameter("strToDate"));
			
			voObj.setStrValue1(formBean.getStrFromDate());
			voObj.setStrValue2(formBean.getStrToDate());
			bo.userwisenooftransperformed(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.userwisenooftransperformed_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}
	
	
	public static void GetMenuWiseData(HttpServletRequest request,HttpServletResponse response, IpdFB formBean) 
	{

		IpdVO voObj = null;
		IpdBO bo = null;

		try 
		{
			voObj = new IpdVO();
			voObj = (IpdVO)TransferObjectFactory.populateData("ipd.IpdVO",formBean);
			bo = new IpdBO();
			
			formBean.setStrUsrId(request.getParameter("strModuleName"));
			
			voObj.setStrValue1(formBean.getStrUsrId());
			
			bo.getmenuwiesdata(voObj);
			
			if (voObj.getStrMsgType().equals("0")) {
				formBean.setStrResultWs(voObj.getGblWs1());
				String val = "";
				val = HLPipd.getmenuwisedata_hlp(voObj);
				formBean.setStrWinResize(voObj.getStrWinResize());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);
				
			} 
			else 
			{
				throw new Exception(voObj.getStrMsgString());
			}			
			
		} 
		catch (Exception e) 
		{
			new HisException("Global Ipd File","hisglobal.IpdDATA.getPatientListingDtls()-->", e.getMessage());
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}
	}

}
