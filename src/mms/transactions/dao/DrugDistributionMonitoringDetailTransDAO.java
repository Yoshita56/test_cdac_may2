package mms.transactions.dao;

import hisglobal.backutil.HisUtil;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang.StringUtils;



import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.transactions.vo.DrugDistributionMonitoringDetailTransVO;
import mms.transactions.vo.DrugDistributionMonitoringDetailTransVO;

public class DrugDistributionMonitoringDetailTransDAO {
	

		/**
		 * 
		 * @param vo - Value Object 
		 */
		public static void getDepartmentValues(DrugDistributionMonitoringDetailTransVO voObj) {
			
			HisDAO dao = null;
			
			int nProcIndex1;
			String strErr = "";
			String strProcName = "";
			
			
			try {
				dao = new HisDAO("transport", "DrugDistributionMonitoringDetailTransDAO");
			
				strProcName =  "{call PKG_MMS_VIEW.proc_department(?,?,?,?,?)}"; 
				
				nProcIndex1 = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex1, "modeval", "2",1);
				dao.setProcInValue(nProcIndex1, "seatId", voObj.getStrSeatId(),3);
				dao.setProcInValue(nProcIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
				dao.setProcOutValue(nProcIndex1, "err", 1,4);
				dao.setProcOutValue(nProcIndex1, "resultset", 2,5);
				

				dao.executeProcedureByPosition(nProcIndex1);

				strErr = dao.getString(nProcIndex1, "err");

				if (strErr.equals("")) {
					WebRowSet ws = dao.getWebRowSet(nProcIndex1, "resultset");
					voObj.setDepartmentWS(ws);
			
								
				} else {
					
					throw new Exception(strErr);
				}
				
			} catch (Exception e) {
		
				voObj.setStrMsgString("--> DrugDistributionMonitoringDetailTransDAO.getDepartmentValues()-->"
						+ e.getMessage());
				voObj.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
					}
				}
			}


	
		/**
		 * 
		 * @param voObj
		 */
		public static void getUnitDetails(DrugDistributionMonitoringDetailTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Unit_Combo(?,?,?,?,?,?)}";
			//String strProcName = "{call Pkg_Mms_View.proc_unit_visited(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {

				daoObj = new HisDAO("MMS Transactions","DrugDistributionMonitoringDetailTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);
				/*//System.out.println("inside DrugDistMonDtlDAO -> getUnitDetails()");
				//System.out.println("dept_code :"+ voObj.getStrDeptCode()==null || voObj.getStrDeptCode().equals("")  ? "0" : voObj.getStrDeptCode());
				//System.out.println("hosp_code :"+ voObj.getStrHospitalCode());
				//System.out.println("crNo :"+      voObj.getStrCrNumber());
				//System.out.println("seatId :"+    voObj.getStrSeatId());
				
				
				daoObj.setProcInValue(nProcIndex, "modeval", "5");
				daoObj.setProcInValue(nProcIndex, "dept_code", (voObj.getStrDeptCode()==null || voObj.getStrDeptCode().equals("") ) ? "0" : voObj.getStrDeptCode());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "crNo",      voObj.getStrCrNumber()==null || voObj.getStrCrNumber().equals("")?"0":voObj.getStrCrNumber());
				daoObj.setProcInValue(nProcIndex, "seatId",    voObj.getStrSeatId());
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);*/
				
				
				daoObj.setProcInValue(nProcIndex, "p_mode", voObj.getStrMode(),1);
				daoObj.setProcInValue(nProcIndex, "p_dept_code", (voObj.getStrDeptCode()==null || voObj.getStrDeptCode().equals("") ) ? "0" : voObj.getStrDeptCode(),2);
				daoObj.setProcInValue(nProcIndex, "p_hosp_code", voObj.getStrHospitalCode(),3);
				
				daoObj.setProcInValue(nProcIndex, "p_seatId", voObj.getStrSeatId(),4);
				daoObj.setProcOutValue(nProcIndex, "err", 1,5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

				daoObj.executeProcedureByPosition(nProcIndex);
		
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
					voObj.setStrUnitWs(ws);
								
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
//				e.printStackTrace();
				voObj.setStrMsgString("DrugDistributionMonitoringDetailTransDAO.getUnitDetails() --> "	+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}		
		
	
		/**
		 * To Get Data
		 * 
		 * @param budgetAllocationDetailProcessTransVO_p
		 */
		public static void getData(DrugDistributionMonitoringDetailTransVO voObj) 
		{
			String err = "";
			String proc_name1 = "{call pkg_mms_view.proc_drugDistMonitoringDtl(?,?,?,?,?,  ?,?,?,?,?,  ?,?)}";

			int procIndex1 = 0;
			HisDAO dao = null;
			WebRowSet ws = null;

			try {

					dao = new HisDAO("MMS Transactions","DrugDistributionMonitoringDetailTransDAO");
			
					hisglobal.utility.HisUtil.replaceNullValueWithEmptyString(voObj);
					
					procIndex1 = dao.setProcedure(proc_name1);    
			              
					/*//System.out.println( "p_mode"+ voObj.getStrMode());
					//System.out.println( "p_crNo"+ voObj.getStrCrNumber());
					//System.out.println( "p_patientName"+ voObj.getStrPatientName());
					
					//System.out.println( "p_dept_code"+ voObj.getStrDeptCode());
					//System.out.println( "p_hosp_code"+ voObj.getStrHospitalCode());
					
					//System.out.println( "p_seatId"+ voObj.getStrSeatId());
					//System.out.println( "p_issueNo"+ voObj.getStrIssueNo());
					
					//System.out.println( "p_unitId"+ voObj.getStrUnitCode());
					//System.out.println( "p_frmDate"+ voObj.getStrFromDate());
					//System.out.println( "p_todate"+ voObj.getStrToDate());	*/
					
					
					
					
					dao.setProcInValue(procIndex1, "p_mode", voObj.getStrMode(),1);
					// set value
					dao.setProcInValue(procIndex1, "p_crNo", voObj.getStrCrNumber(),2);
					dao.setProcInValue(procIndex1, "p_patientName", voObj.getStrPatientName(),3);
					
					dao.setProcInValue(procIndex1, "p_dept_code", voObj.getStrDeptCode(),4);
					dao.setProcInValue(procIndex1, "p_hosp_code", voObj.getStrHospitalCode(),5);
					
					dao.setProcInValue(procIndex1, "p_seatId", voObj.getStrSeatId(),6);
					dao.setProcInValue(procIndex1, "p_issueNo", voObj.getStrIssueNo(),8);
					
					dao.setProcInValue(procIndex1, "p_unitId", voObj.getStrUnitCode(),7);
					dao.setProcInValue(procIndex1, "p_frmDate", voObj.getStrFromDate(),9);
					dao.setProcInValue(procIndex1, "p_todate", voObj.getStrToDate(),10);					
					
					
					/* Setting Default Value End */
					
					dao.setProcOutValue(procIndex1, "err", 1,11); // 1 for string return
					// value
					dao.setProcOutValue(procIndex1, "resultset", 2,12); // 2 for object
			
					// execute procedure
			
					dao.executeProcedureByPosition(procIndex1);
			
					// get value
					err = dao.getString(procIndex1, "err");
			
					if (err == null)
						err = "";
			
					ws = dao.getWebRowSet(procIndex1, "resultset");
			
					voObj.setWrsData(ws);

			} catch (Exception e) {
				//e.printStackTrace();
				voObj.setStrMsgString("DrugDistributionMonitoringDetailTransDAO.getData() --> "	+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}
			
		}	
		
		
	public static void getScanFlag(DrugDistributionMonitoringDetailTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		int nFuncIndex = 0;
	
		String strErr = "";
		String strFuncName = "";
		String strDocAvl;

		try {

//			daoObj = new HisDAO("MMS Transactions","DrugDistributionMonitoringDetailTransDAO");
//			
//			strFuncName = "{? = call pkg_scanning_view.is_patient_document_present(?,?,?,?,?,?,?,?,?)}";
//			nFuncIndex = daoObj.setFunction(strFuncName);
//			
//			/*//System.out.println("voObj.getStrCrNum()"+voObj.getStrCrNum());
//			//System.out.println("voObj.getStrEpisodeCode()"+voObj.getStrEpisodeCode());*/
//			
//			daoObj.setFuncInValue(nFuncIndex, 2, "3");
//			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
//			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrCrNum());
//			daoObj.setFuncInValue(nFuncIndex, 5, voObj.getStrEpisodeCode()==null || voObj.getStrEpisodeCode().equals("")?"0":voObj.getStrEpisodeCode());
//			daoObj.setFuncInValue(nFuncIndex, 6, "");
//			daoObj.setFuncInValue(nFuncIndex, 7, "");
//			daoObj.setFuncInValue(nFuncIndex, 8, "");
//			daoObj.setFuncInValue(nFuncIndex, 9, "");
//			daoObj.setFuncInValue(nFuncIndex,10, "");
//			daoObj.setFuncOutValue(nFuncIndex, 1);
//			daoObj.executeFunction(nFuncIndex);
//			strDocAvl = daoObj.getFuncString(nFuncIndex);
						
			voObj.setStrDocFlg("0");//hardcoded and upper part commented a scanning is not in use.
					
			

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("DrugDistributionMonitoringDetailTransDAO.getIssueDetail() --> "	+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}



	public static void getEpisodeVisitCmb(DrugDistributionMonitoringDetailTransVO voObj) {

		String strProcName = "{call Pkg_Mms_View.proc_episode_visit_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("DrugDistributionMonitoringDetailTransDAO","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			/*//System.out.println("DrugDistributionMonitoringDetailTransDAO ::getEpisodeVisitCmb()");
			//System.out.println("p_hosp_code :"+ voObj.getStrHospitalCode());
			//System.out.println("p_crNo :"+ voObj.getStrCrNum());
			//System.out.println("p_deptUnitId :"+ voObj.getStrDeptUnitCode());*/
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_crNo", voObj.getStrCrNum());
			daoObj.setProcInValue(nProcIndex, "p_deptUnitId", voObj.getStrDeptUnitCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				voObj.setWrsEpisodeVisit(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			voObj.setStrMsgString("DrugDistributionMonitoringDetailTransDAO.getEpisodeVisitCmb() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		}
	}
}	
	