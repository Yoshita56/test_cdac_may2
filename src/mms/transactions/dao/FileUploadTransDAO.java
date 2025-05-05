/**********************************************************
 Project:	   DWH_BIHAR	
 File:         ProjectedDemandRequestTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.FileUploadTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectedDemandRequestTransDAO.
 */
public class FileUploadTransDAO {

	/**
	 * for getting option value of combo on add page (Indent Period Combo).
	 * 
	 * @param vo the vo
	 */
	public static void financialYearCombo(FileUploadTransVO vo) {
		int nProcIndex = 0;
		HisDAO daoObj = null;
		String strErr = "";
		WebRowSet wb = null;
		HisUtil hisutil = null;
		String str = "";
		try {
			String strProcName = "{call PKG_MMS_VIEW.proc_annual_demand_finyear_dtl(?,?,?,?,?)}";

			hisutil = new HisUtil("MMS Transactions", "ProjectedDemandRequestTransDAO");
			daoObj = new HisDAO("MMS Transactions", "ProjectedDemandRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "hospCode", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			}
			if (wb != null && wb.size() != 0) {
				str = hisutil.getOptionValue(wb, "0", "0^Select Value", true);
				vo.setStrIndentPeriodValueCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodValueCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ProjectedDemandRequestTransDAO.IndentPeriodValueCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}

		}
	}

	/**
	 * Gets the existing req dtl.
	 * 
	 * @param voObj the vo obj
	 * @return the existing req dtl
	 */
	public static void getExistingReqDtl(FileUploadTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_RPT.rptm_itembrand_list(?,?,?,?,?, ?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions", "ProjectedDemandRequestTransDAO");
			////daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "catCode", "10");
			daoObj.setProcInValue(nProcIndex, "groupid", "0");
			daoObj.setProcInValue(nProcIndex, "subgrpid", voObj.getStrAlphabet()); // passing Alphabet
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "drug_class", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setIndentItemWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ProjectedDemandRequestTransDAO.getExistingReqDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getNotificationDtl(FileUploadTransVO vo) {

		String strproc_name = "{call pkg_mms_view.proc_notification_dtl(?,?,?,?,?,  ?)}";
			HisDAO dao = null;
			int nProcIndex = 0;

			String strErr = "";
			WebRowSet wsResult = null;

			try {
				dao = new HisDAO("MMS", "transactions.PODeskGenerateTransDAO.setItemCatValues()");

				nProcIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nProcIndex, "p_mode", vo.getStrMode());
				dao.setProcInValue(nProcIndex, "hospCode", vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "finYear", vo.getStrIndentPeriodValue());
				dao.setProcInValue(nProcIndex, "notificationId", (vo.getStrNotificationNo()==null || vo.getStrNotificationNo().equals(""))?"0":vo.getStrNotificationNo());
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);

				strErr = dao.getString(nProcIndex, "err");

				wsResult = dao.getWebRowSet(nProcIndex, "resultset");

				if (strErr == null || strErr.equals("")) {
					vo.setWrsData(wsResult);
				} else {
					throw new Exception(strErr);
				}
			} catch (Exception _Err) {
				vo.setStrMsgString("PODeskGenerateTransDAO.getNotificationDtl() --> " + _Err.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
				wsResult = null;
			}
	}

	/**
	 * Gets the drug classification value.
	 * 
	 * @param vo the vo
	 */
	public static void getDrugClassificationValue(FileUploadTransVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.classification");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			vo.setDrugClassWs(web);
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("ProjectedDemandRequestTransDAO.getDrugClassificationValue() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}
	
	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getDrugList(FileUploadTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_RPT.rptm_itembrand_list(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			
			daoObj = new HisDAO("MMS Transactions", "ProjectedDemandRequestTransDAO");
			//daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "6");
			daoObj.setProcInValue(nProcIndex, "catCode", "10");
			daoObj.setProcInValue(nProcIndex, "groupid", "0");
			daoObj.setProcInValue(nProcIndex, "subgrpid", voObj.getStrAlphabet()); // passing Alphabet
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "drug_class", voObj.getStrDrugClass());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDrugWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("ProjectedDemandRequestTransDAO.getDrugList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * Gets the programme details.
	 * 
	 * @param _poDeskGenerateTransVO the _po desk generate trans vo
	 * @return the programme details
	 */
	public static void getProgrammeDetails(FileUploadTransVO vo) {
		String strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}"; // Total 11 Variables
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {

			dao = new HisDAO("MMS", "transactions.ProjectedDemandRequestTransDAO.getProgrammeDetails()");
			nProcIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "storeid", (vo.getStrStoreId()==null || vo.getStrStoreId().equals(""))?"0":vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());			
			dao.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr.equals("")) {
				strErr = null;
			}
			if (strErr == null) {
				strErr = "";
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setWbsProgrammeDtl(wsResult);
			} else {

				throw new Exception(strErr);
			}

		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("ProjectedDemandRequestTransDAO.getProgrammeDetails() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void save(FileUploadTransVO voObj) {


		HisDAO dao = null;
		String proc_name  = "";
		String proc_name1 = "";
	    int nprocIndex=0,nprocIndex1=0;	
	    int funcIndex = 0;
	    String strNotificationNo = "";	 
		try 
		{
				// value does not set
				dao = new HisDAO("mms", "AcknowledgeTransDAO");			
				
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_notification_no(?,?)}");
				// Set Value			
				dao.setFuncInValue(funcIndex, 2, voObj.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, voObj.getStrReqType().split("\\^")[0]);
				dao.setFuncOutValue(funcIndex, 1);
				// Execute Function
				dao.executeFunction(funcIndex);
				strNotificationNo = dao.getFuncString(funcIndex);
				voObj.setStrNotificationNo(strNotificationNo);		
				
				if(voObj.getStrWhetherProgConstraintValue().equals("1"))
				{
				
					proc_name = "{call PKG_MMS_DML2.dml_notification_prg_dtl(?,?,?,?,?,   ?,?,?)}"; // 8  
					nprocIndex = dao.setProcedure(proc_name);
					
					System.out.println( "Length-0-------"+ 		voObj.getStrRightProgIds().length); 
					for (int i = 0, stopI = voObj.getStrRightProgIds().length; i < stopI; i++) 
					{				
						
							/*System.out.println( "modval"+ 			"1"); 
							System.out.println( "hosp_code"+     voObj.getStrHospitalCode());    
							System.out.println( "notificationNo"+voObj.getStrNotificationNo()); 
							System.out.println( "finYear"+  	 voObj.getStrIndentPeriodValue()); 
							System.out.println( "demandTypeId"+ voObj.getStrReqType().split("\\^")[0]); 
							System.out.println( "prgId"+ 		voObj.getStrRightProgIds()[i]); 
							System.out.println( "seatid"+ 		voObj.getStrSeatId());*/
						
							
							dao.setProcInValue(nprocIndex,  "modval", 			"1"); 
							dao.setProcInValue(nprocIndex,  "hosp_code",     voObj.getStrHospitalCode());    
							dao.setProcInValue(nprocIndex,  "notificationNo",voObj.getStrNotificationNo()); 
							dao.setProcInValue(nprocIndex,  "finYear",  	 voObj.getStrIndentPeriodValue()); 
							dao.setProcInValue(nprocIndex,  "demandTypeId", voObj.getStrReqType().split("\\^")[0]); 
							dao.setProcInValue(nprocIndex,  "prgId", 		voObj.getStrRightProgIds()[i]); 
							dao.setProcInValue(nprocIndex,  "seatid", 		voObj.getStrSeatId());
							dao.setProcOutValue(nprocIndex, "err",          1); 	
							dao.execute(nprocIndex, 1);
					}	
				}
			
			// Insert item
				if(voObj.getStrWhetherItemConstraintValue().equals("1"))
				{
				
					proc_name = "{call PKG_MMS_DML2.dml_notification_item_dtl(?,?,?,?,?,   ?,?,?)}"; // 8  
					nprocIndex = dao.setProcedure(proc_name);
					
					
					for (int i = 0, stopI = voObj.getStrRightItemIds().length; i < stopI; i++) 
					{				
							/*System.out.println( "modval"+ 			"1"); 
							System.out.println( "hosp_code"+     voObj.getStrHospitalCode());    
							System.out.println( "notificationNo"+voObj.getStrNotificationNo()); 
							System.out.println( "finYear"+  	 voObj.getStrIndentPeriodValue()); 
							System.out.println( "demandTypeId"+ voObj.getStrReqType().split("\\^")[0]); 
							System.out.println( "itemId"+ 		voObj.getStrRightItemIds()[i]); 
							System.out.println( "seatid"+ 		voObj.getStrSeatId());*/
						
							
							dao.setProcInValue(nprocIndex,  "modval", 			"1"); 
							dao.setProcInValue(nprocIndex,  "hosp_code",     voObj.getStrHospitalCode());    
							dao.setProcInValue(nprocIndex,  "notificationNo",voObj.getStrNotificationNo()); 
							dao.setProcInValue(nprocIndex,  "finYear",  	 voObj.getStrIndentPeriodValue()); 
							dao.setProcInValue(nprocIndex,  "demandTypeId", voObj.getStrReqType().split("\\^")[0]); 
							dao.setProcInValue(nprocIndex,  "itemId", 		voObj.getStrRightItemIds()[i]); 
							dao.setProcInValue(nprocIndex,  "seatid", 		voObj.getStrSeatId());
							dao.setProcOutValue(nprocIndex, "err",          1); 	
							dao.execute(nprocIndex, 1);
					}	
				}
				
				proc_name1 = "{call PKG_MMS_DML2.dml_notification_dtl (?,?,?,?,?,  ?,?,?,?,?,  ?,?,?)}";
				nprocIndex1 = dao.setProcedure(proc_name1);
				
				/*
				System.out.println( "modval"+ 			"1"); 
				System.out.println( "hosp_code"+     voObj.getStrHospitalCode());    
				System.out.println( "notificationNo"+voObj.getStrNotificationNo()); 
				System.out.println( "finYear"+  	 voObj.getStrIndentPeriodValue()); 
				System.out.println( "demandTypeId"+ voObj.getStrReqType().split("\\^")[0]); 
				System.out.println( "dateConsFlag"+ 		voObj.getStrWhetherDateConstraintValue());
				System.out.println( "submissionDate"+ 		voObj.getStrLastDate());
				System.out.println( "prgConsFlag"+ 		voObj.getStrWhetherProgConstraintValue());
				System.out.println( "itemConsFlag"+ 		voObj.getStrWhetherItemConstraintValue());
				System.out.println( "seatid"+ 		voObj.getStrSeatId());
				System.out.println( "remarks"+ 		voObj.getStrRemarks());
				*/
			
		      	dao.setProcInValue(nprocIndex1,  "modval", 				"1"); 
				dao.setProcInValue(nprocIndex1,  "hosp_code",    	 	voObj.getStrHospitalCode());    
				dao.setProcInValue(nprocIndex1,  "notificationNo",		voObj.getStrNotificationNo()); 
				dao.setProcInValue(nprocIndex1,  "finYear",  	 		voObj.getStrIndentPeriodValue()); 
				dao.setProcInValue(nprocIndex1,  "demandTypeId", 		voObj.getStrReqType().split("\\^")[0]); 
				dao.setProcInValue(nprocIndex1,  "dateConsFlag", 		voObj.getStrWhetherDateConstraintValue());
				dao.setProcInValue(nprocIndex1,  "submissionDate", 		voObj.getStrLastDate());
				dao.setProcInValue(nprocIndex1,  "prgConsFlag", 		voObj.getStrWhetherProgConstraintValue());
				dao.setProcInValue(nprocIndex1,  "itemConsFlag", 		voObj.getStrWhetherItemConstraintValue());
				dao.setProcInValue(nprocIndex1,  "seatid", 				voObj.getStrSeatId());
				dao.setProcInValue(nprocIndex1,  "remarks", 			voObj.getStrRemarks());
				dao.setProcInValue(nprocIndex1,  "qtrFlg", 				voObj.getStrDeamandQuater());
				dao.setProcOutValue(nprocIndex1, "err",          		1); 	
				dao.execute(nprocIndex1, 1);

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("AcknowledgeTransDAO.insertRecord() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
		
	}

	public static void saveDelete(FileUploadTransVO voObj) {


		HisDAO dao = null;
		String proc_name1 = "";
	    int nprocIndex1=0;	
		try 
		{
			// value does not set
			dao = new HisDAO("mms", "AcknowledgeTransDAO");			
			
			
			proc_name1 = "{call PKG_MMS_DML2.dml_notification_dtl (?,?,?,?,?,  ?,?,?,?,?,  ?,?,?)}";
			nprocIndex1 = dao.setProcedure(proc_name1);
			
			/*
			System.out.println( "modval"+ 			"3"); 
			System.out.println( "hosp_code"+     voObj.getStrHospitalCode());    
			System.out.println( "notificationNo"+voObj.getStrNotificationNo()); 
			System.out.println( "finYear"+  	 voObj.getStrIndentPeriodValue());
			System.out.println( "demandTypeId"+ "0"); 
			System.out.println( "dateConsFlag"+ 		"0");
			System.out.println( "submissionDate"+ 		"0");
			System.out.println( "prgConsFlag"+ 		"0");
			System.out.println( "itemConsFlag"+ 		"0");
			System.out.println( "seatid"+ 		voObj.getStrSeatId());
			System.out.println( "remarks"+ 		voObj.getStrRemarks());*/
			
		
	      	dao.setProcInValue(nprocIndex1,  "modval", 			"3"); 
			dao.setProcInValue(nprocIndex1,  "hosp_code",     voObj.getStrHospitalCode());    
			dao.setProcInValue(nprocIndex1,  "notificationNo",voObj.getStrNotificationNo()); 
			dao.setProcInValue(nprocIndex1,  "finYear",  	 voObj.getStrIndentPeriodValue()); 
			dao.setProcInValue(nprocIndex1,  "demandTypeId", "0"); 
			dao.setProcInValue(nprocIndex1,  "dateConsFlag", 		"0");
			dao.setProcInValue(nprocIndex1,  "submissionDate", 		"0");
			dao.setProcInValue(nprocIndex1,  "prgConsFlag", 		"0");
			dao.setProcInValue(nprocIndex1,  "itemConsFlag", 		"0");
			dao.setProcInValue(nprocIndex1,  "seatid", 		voObj.getStrSeatId());
			dao.setProcInValue(nprocIndex1,  "remarks", 		voObj.getStrRemarks());
			dao.setProcInValue(nprocIndex1,  "qtrFlg", 			"0");
			dao.setProcOutValue(nprocIndex1, "err",          1); 	
			dao.execute(nprocIndex1, 1);

			dao.fire();

	} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("AcknowledgeTransDAO.insertRecord() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
		
	}

	public static void saveExtend(FileUploadTransVO voObj) {

		HisDAO dao = null;
		String proc_name1 = "";
	    int nprocIndex1=0;	
		try 
		{
				// value does not set
				dao = new HisDAO("mms", "AcknowledgeTransDAO");			
				
				
				proc_name1 = "{call PKG_MMS_DML2.dml_notification_dtl (?,?,?,?,?,  ?,?,?,?,?,  ?,?,?)}";
				nprocIndex1 = dao.setProcedure(proc_name1);
				
				
				/*System.out.println( "modval"+ 			"2"); 
				System.out.println( "hosp_code"+     voObj.getStrHospitalCode());    
				System.out.println( "notificationNo"+voObj.getStrNotificationNo()); 
				System.out.println( "finYear"+  	 voObj.getStrIndentPeriodValue());
				System.out.println( "demandTypeId"+ "0"); 
				System.out.println( "dateConsFlag"+ 		"0");
				System.out.println( "submissionDate"+ 		voObj.getStrExtendLastDate());
				System.out.println( "prgConsFlag"+ 		"0");
				System.out.println( "itemConsFlag"+ 		"0");
				System.out.println( "seatid"+ 		voObj.getStrSeatId());
				System.out.println( "remarks"+ 		voObj.getStrRemarks());*/
				
			
		      	dao.setProcInValue(nprocIndex1,  "modval", 			"2"); 
				dao.setProcInValue(nprocIndex1,  "hosp_code",     voObj.getStrHospitalCode());    
				dao.setProcInValue(nprocIndex1,  "notificationNo",voObj.getStrNotificationNo()); 
				dao.setProcInValue(nprocIndex1,  "finYear",  	 voObj.getStrIndentPeriodValue()); 
				dao.setProcInValue(nprocIndex1,  "demandTypeId", "0"); 
				dao.setProcInValue(nprocIndex1,  "dateConsFlag", 		"0");
				dao.setProcInValue(nprocIndex1,  "submissionDate", 		voObj.getStrExtendLastDate());
				dao.setProcInValue(nprocIndex1,  "prgConsFlag", 		"0");
				dao.setProcInValue(nprocIndex1,  "itemConsFlag", 		"0");
				dao.setProcInValue(nprocIndex1,  "seatid", 		voObj.getStrSeatId());
				dao.setProcInValue(nprocIndex1,  "remarks", 		voObj.getStrRemarks());
				dao.setProcInValue(nprocIndex1,  "qtrFlg", 			"0");
				dao.setProcOutValue(nprocIndex1, "err",          1); 	
				dao.execute(nprocIndex1, 1);

				dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("AcknowledgeTransDAO.insertRecord() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
		
	}
	public static void getNames(FileUploadTransVO voObj,String ids) {

		String retVal =null;
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;

		// 89900001^140^101^15027^12^19^99901083^2019 - 2020
		
		/*get_names_from_id(hosp_code,shs_store_id,prg_id,fs_id,dist_id,quarter_id,dwh_type_id, store_id,finyear)*/

		/*System.out.println(" ids.split[0]-------"+ ids.split("\\^")[0]);
		System.out.println(" ids.split[1]-------"+ ids.split("\\^")[1]);
		System.out.println(" ids.split[2]-------"+ ids.split("\\^")[2]);
		System.out.println(" ids.split[3]-------"+ ids.split("\\^")[3]);
		System.out.println(" ids.split[4]-------"+ ids.split("\\^")[4]);
		System.out.println(" ids.split[5]-------"+ ids.split("\\^")[5]);
		System.out.println(" ids.split[6]-------"+ ids.split("\\^")[6]);
		System.out.println(" ids.split[7]-------"+ ids.split("\\^")[7]);
		*/
		try 
		{
			
				//voObj.setStrFinacialYear(ids.split("\\^")[6]);
				dao = new HisDAO("mms", "FileUploadTransDAO");							
				strFuncName = "{? = call MMS_MST.get_names_from_id(?,?,?, ?,?,?, ?,?,?)}"; // 9
				nFuncIndex = dao.setFunction(strFuncName);
				dao.setFuncInValue(nFuncIndex, 2, "998");
				dao.setFuncInValue(nFuncIndex, 3, ids.split("\\^")[0]);
				dao.setFuncInValue(nFuncIndex, 4, ids.split("\\^")[1]);
				dao.setFuncInValue(nFuncIndex, 5, ids.split("\\^")[2]);
				dao.setFuncInValue(nFuncIndex, 6, ids.split("\\^")[3]);
				dao.setFuncInValue(nFuncIndex, 7, ids.split("\\^")[4]);
				dao.setFuncInValue(nFuncIndex, 8, ids.split("\\^")[5]);
				dao.setFuncInValue(nFuncIndex, 9, ids.split("\\^")[6]);
				dao.setFuncInValue(nFuncIndex, 10, ids.split("\\^")[7]);
				dao.setFuncOutValue(nFuncIndex, 1);
				
				dao.executeFunction(nFuncIndex);
				
				retVal = dao.getFuncString(nFuncIndex);
				if (retVal != null) {
					voObj.setStrGetNames(retVal);
				
					
				} else {
					retVal = "-----";
					voObj.setStrGetNames(retVal);
				}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("FileUploadTransDAO.getNames() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
		
	}
	
	public static void saveBudgetIntoDB(FileUploadTransVO voObj) {

		HisDAO dao = null;
		String proc_name1 = "";
	    int nprocIndex1=0;
	    String ids="",centralBudget="",localBudget="";
	    String finalStr="";
		String strErr = "";
	    String shs_store_id="",prg_id="",fs_id="",dist_id="",quarter_id="",fin_year="",dwh_type_id="",store_id="";
		try 
		{
				dao = new HisDAO("mms", "FileUploadTransDAO");			
				proc_name1 = "{call pkg_mms_dml2.dml_budget_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?)}"; //27		
				nprocIndex1 = dao.setProcedure(proc_name1);				
				//89900001^140^101^15027^13^11^99900554^2019 - 2020@Athmalgola_Phc@150.0@200.0
				
				
				//String arr[] = finalStr.split("\\#");
				for(int i=0;i<voObj.getStrHtmlCodeHidden().length;i++)
				{	
				  if(!voObj.getStrHtmlCodeHidden()[i].equals(""))
				  {	  
					ids 		  = voObj.getStrHtmlCodeHidden()[i].split("\\@")[0];
					//localBudget	  = arr[i].split("\\@")[2];
					//centralBudget = voObj.getStrHtmlCodeHidden()[i].split("\\@")[2];
					shs_store_id =ids.split("\\^")[0];
					prg_id		 =ids.split("\\^")[1];
					fs_id		 =ids.split("\\^")[2];
					dist_id		 =ids.split("\\^")[3];
					quarter_id	 =ids.split("\\^")[4];
					dwh_type_id	 =ids.split("\\^")[5];
					store_id	 =ids.split("\\^")[6];
					fin_year	 =ids.split("\\^")[7];
				
					if(dwh_type_id.equals("12") || dwh_type_id == "12" )
					{
						localBudget	  = voObj.getStrDcsBudget();
						centralBudget = "0";
					}
					else
					{
						localBudget	  = "0";
						centralBudget = voObj.getStrHtmlCodeHidden()[i].split("\\@")[2];
					}
					
				/*System.out.println( "shs_store_id---->"+ shs_store_id);    
				System.out.println( "prg_id------>"	+ prg_id); 
				System.out.println( "fs_id------>"	+ fs_id);
				System.out.println( "dist_id------>"+ dist_id); 
				System.out.println( "quarter_id------>"+ quarter_id);
				System.out.println( "fin_year------>"  + fin_year);
				System.out.println( "dwh_type_id------>"+ dwh_type_id);
				System.out.println( "store_id------>"+ store_id);
				System.out.println( "centralBudget------>"+ centralBudget);*/

				  
				dao.setProcInValue(nprocIndex1, "modval", 				 "8");
				dao.setProcInValue(nprocIndex1, "hosp_code",			 "998");
				dao.setProcInValue(nprocIndex1, "finYear",				 fin_year);
				dao.setProcInValue(nprocIndex1, "prgId",				 prg_id);
				dao.setProcInValue(nprocIndex1, "fsId", 				 fs_id);
				dao.setProcInValue(nprocIndex1, "allocBy_StrTypeId", 	 "21");			
				dao.setProcInValue(nprocIndex1, "allocBy_StrId", 		 shs_store_id);			
				dao.setProcInValue(nprocIndex1, "allocTo_StrTypeId", 	 dwh_type_id);
				dao.setProcInValue(nprocIndex1, "allocTo_StrId", 		 store_id);			
				dao.setProcInValue(nprocIndex1, "lpBudgetType", 		 "1");	
				dao.setProcInValue(nprocIndex1, "lpBudget", 			 localBudget);
				dao.setProcInValue(nprocIndex1, "budgetClass",			 "10");
				dao.setProcInValue(nprocIndex1, "centralBudgetType",	 "1");
				dao.setProcInValue(nprocIndex1, "centralBudget",		 centralBudget );
				dao.setProcInValue(nprocIndex1, "realizedBudget",		 centralBudget);
				dao.setProcInValue(nprocIndex1, "realizedBudgetType",	 "1");
				dao.setProcInValue(nprocIndex1, "IssueBudget",			 "0" );
				dao.setProcInValue(nprocIndex1, "IssueBudgetType",		 "1");
				dao.setProcInValue(nprocIndex1, "remarks",				 "Budget Uploaded via Excel");
				dao.setProcInValue(nprocIndex1, "seatid", 				 voObj.getStrSeatId());
				dao.setProcInValue(nprocIndex1, "modifyFlag",			 "0");	
				dao.setProcInValue(nprocIndex1, "realizedBudget1",		 "0"); 	
				dao.setProcInValue(nprocIndex1, "struserId", 			 "0");	
				dao.setProcInValue(nprocIndex1, "allocDate",			 "0");
				dao.setProcInValue(nprocIndex1, "indentperiod", 		 quarter_id);
				dao.setProcInValue(nprocIndex1, "districtId", 			 dist_id);
				dao.setProcOutValue(nprocIndex1, "err", 				 1);
				dao.execute(nprocIndex1,1);
				dao.fire();
				}
			} // Check Null Value

		} catch (Exception e) {
			e.printStackTrace();			
			voObj.setStrMsgString("FileUploadTransDAO.saveBudgetIntoDB() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} 
		
	
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
		
	}
	
	public static void getBudgetDetails(FileUploadTransVO vo) 
	{
		
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW2.proc_get_budget_in_detail(?,?,?,?,?,?,?,?,?,?)}"; // TODO Passing funding Source Parameter
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try 
		{
			
			dao = new HisDAO("mms","FileUploadTransDAO");
			procIndex1 = dao.setProcedure(proc_name1);						
			// set value
            dao.setProcInValue(procIndex1,  "modeval", 	 		"3");			
			dao.setProcInValue(procIndex1,  "finyear", 	 		vo.getStrFinancialYearCombo());			
			dao.setProcInValue(procIndex1, "hosp_code", 		"998");
			dao.setProcInValue(procIndex1,  "seatid",    		vo.getStrSeatId());		
			dao.setProcInValue(procIndex1, "allocto_strid", 	vo.getStrDistrictCmb());	 //used to pass district id	 
			dao.setProcInValue(procIndex1,  "prgid",         	vo.getStrProgrammeCmb());
			dao.setProcInValue(procIndex1,  "fsid", 			vo.getStrFundSourceCmb());
			dao.setProcInValue(procIndex1,  "quarterId",        vo.getStrQuarterPeriod());
			dao.setProcOutValue(procIndex1, "err", 				1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 		2); // 2 for object
			// execute procedure					
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				
				if(ws.next())
				{
					vo.setStrAllocatedRealizedBudget(ws.getString(1));
					vo.setStrAvailableRealizedBudget(ws.getString(3));
					vo.setStrAvailableLocalBudget(ws.getString(5));
					vo.setStrAvailableCentralBudget(ws.getString(4));
					ws.beforeFirst();
				}
				vo.setStrBudgetDtl(ws);
				
			} else {
				throw new Exception(err);
			}

			
		} 
		catch (Exception e) 
		{			
			vo.setStrMsgString("FileUploadTransDAO.getBudgetDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
}