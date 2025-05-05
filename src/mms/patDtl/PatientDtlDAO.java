package mms.patDtl;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.IssueTransVO;

import javax.sql.rowset.WebRowSet;

public class PatientDtlDAO {

	public static void setPatientDtl(GlobalVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.PROC_HRGT_PATIENT_DTL(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		String strCrNum = voObj.getStrValue1();
		//System.out.println("strCrNum"+strCrNum);
		try 
		{
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) 
			{
				daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcOutValue(nProcIndex, "err", 1,3);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PatientDtlDAO.setPatientDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void setAdmissionDtl(GlobalVO voObj) 
	{
		//Currently Admitted Patient-Not Discharged,Admission Not Cancelled(14), Admission Not Reported False(13)
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";

		String strCrNum = voObj.getStrValue1();
		String strHosptialCode = voObj.getStrValue2();
		
		try 
		{
			daoObj = new HisDAO("HisGlobal","PatientDtlDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && strHosptialCode != null) 
			{
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcInValue(nProcIndex, "seatid", "",3);
				daoObj.setProcInValue(nProcIndex, "modifytime", "",4);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHosptialCode,5);				
				daoObj.setProcInValue(nProcIndex, "patlisttype", "",6);
				daoObj.setProcInValue(nProcIndex, "searchstr", "",7);
				daoObj.setProcInValue(nProcIndex, "searchtype", "",8);
				daoObj.setProcInValue(nProcIndex, "torows", "",9);
				daoObj.setProcInValue(nProcIndex, "frmrows", "",10);
				daoObj.setProcInValue(nProcIndex, "onlinedis", "",11);
				daoObj.setProcInValue(nProcIndex, "deptUnitCode", "",12);
				daoObj.setProcInValue(nProcIndex, "wardCode", "",13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PatientDtlDAO.setAdmissionDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void setAdmissionDtlReturn(GlobalVO voObj) 
	{
		//Currently Admitted Patient-Not Discharged,Admission Not Cancelled(14), Admission Not Reported False(13)
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";

		String strCrNum = voObj.getStrValue1();
		String strHosptialCode = voObj.getStrValue2();
		
		try 
		{
			daoObj = new HisDAO("HisGlobal","PatientDtlDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && strHosptialCode != null) 
			{
				daoObj.setProcInValue(nProcIndex, "modeval", "12",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcInValue(nProcIndex, "seatid", "",3);
				daoObj.setProcInValue(nProcIndex, "modifytime", "",4);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHosptialCode,5);				
				daoObj.setProcInValue(nProcIndex, "patlisttype", "",6);
				daoObj.setProcInValue(nProcIndex, "searchstr", "",7);
				daoObj.setProcInValue(nProcIndex, "searchtype", "",8);
				daoObj.setProcInValue(nProcIndex, "torows", "",9);
				daoObj.setProcInValue(nProcIndex, "frmrows", "",10);
				daoObj.setProcInValue(nProcIndex, "onlinedis", "",11);
				daoObj.setProcInValue(nProcIndex, "deptUnitCode", "",12);
				daoObj.setProcInValue(nProcIndex, "wardCode", "",13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PatientDtlDAO.setAdmissionDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
//added by shefali on 26-Aug-2014 for patient treatment detail in issu eto patient
	public static void setPatientTreatmentDtl(GlobalVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum    = voObj.getStrValue1();
		String strHospcode = voObj.getStrValue2();
		try {
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {
				
				daoObj.setProcInValue(nProcIndex, "modeval", 	"1",1);
				daoObj.setProcInValue(nProcIndex, "puk", 		strCrNum,2);			
				daoObj.setProcInValue(nProcIndex, "hosp_code",	strHospcode,3);
				daoObj.setProcInValue(nProcIndex, "store_id",	"0",4);
				daoObj.setProcOutValue(nProcIndex, "err", 		1,5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
            	if (strErr.equals("")) {
					voObj.setGblWs2(ws);
				} 
            	else 
            	{
					throw new Exception(strErr);
				}
				
			 } 

			} catch (Exception e) 
			{
			 System.out.println("Error Msg is-->"+e.getMessage());
			 voObj.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> "+ e.getMessage());
			 voObj.setStrMsgType("1");

			} 
			finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				}
			}

	}
	
	public static void setPatientTreatmentDtl_OPD(GlobalVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum    = voObj.getStrValue1();
		String strHospcode = voObj.getStrValue2();
		try {
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {
				
				daoObj.setProcInValue(nProcIndex, "modeval", 	"4",1);
				daoObj.setProcInValue(nProcIndex, "puk", 		strCrNum,2);			
				daoObj.setProcInValue(nProcIndex, "hosp_code",	strHospcode,3);
				daoObj.setProcInValue(nProcIndex, "store_id",	"0",4);
				daoObj.setProcOutValue(nProcIndex, "err", 		1,5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
            	if (strErr.equals("")) {
					voObj.setGblWs2(ws);
				} 
            	else 
            	{
					throw new Exception(strErr);
				}
				
			 } 

			} catch (Exception e) 
			{
			 System.out.println("Error Msg is-->"+e.getMessage());
			 voObj.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> "+ e.getMessage());
			 voObj.setStrMsgType("1");

			} 
			finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				}
			}

	}
	public static void setPatientDtlWithoutCatExpiryCheck(GlobalVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.PROC_HRGT_PATIENT_DTL(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		String strCrNum = voObj.getStrValue1();

		try 
		{
			daoObj = new HisDAO("HisGlobal","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) 
			{
				daoObj.setProcInValue(nProcIndex, "modeVal", "2",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcOutValue(nProcIndex, "err", 1,3);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PatientDtlDAO.setPatientDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	//added by shalini to view patient admission dtl even if patient is not admitted
	public static void setAdmissionDtlView(GlobalVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = voObj.getStrValue1();
		String strHosptialCode = voObj.getStrValue2();
		
		try {
			daoObj = new HisDAO("Global Patient Details ","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && strHosptialCode != null) 
			{

				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHosptialCode,5);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "11",1);
				daoObj.setProcInValue(nProcIndex, "seatid", "",3);
				daoObj.setProcInValue(nProcIndex, "modifytime", "",4);
				daoObj.setProcInValue(nProcIndex, "patlisttype", "",6);
				daoObj.setProcInValue(nProcIndex, "searchstr", "",7);
				daoObj.setProcInValue(nProcIndex, "searchtype", "",8);
				daoObj.setProcInValue(nProcIndex, "torows", "",9);
				daoObj.setProcInValue(nProcIndex, "frmrows", "",10);
				daoObj.setProcInValue(nProcIndex, "onlinedis", "",11);
				daoObj.setProcInValue(nProcIndex, "deptUnitCode", "",12);
				daoObj.setProcInValue(nProcIndex, "wardCode", "",13);
				daoObj.setProcOutValue(nProcIndex, "err", 1,14);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) {

					voObj.setGblWs1(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("PatientDtlDAO.setAdmissionDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getAccountDtl(GlobalVO voObj) 
	{
		String proc_name1 = "";
		proc_name1 = "{call PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		
		String strCrNum = voObj.getStrValue1();
		String strHosptialCode = voObj.getStrValue2();
		try 
		{
			dao = new HisDAO("Global Patient Details ","PatientDtlDAO");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "accNo", "", 1);
			dao.setProcInValue(procIndex1, "modeVal", "13", 5);
			dao.setProcInValue(procIndex1, "puk",strCrNum, 2);
			dao.setProcInValue(procIndex1, "chargeTypeId", "", 3);
			dao.setProcInValue(procIndex1, "activeAccount", "", 4);
			dao.setProcInValue(procIndex1, "hosp_code",strHosptialCode, 6);
			dao.setProcOutValue(procIndex1, "ERR", 1, 7);
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 8);
			dao.executeProcedureByPosition(procIndex1);
			strerr = dao.getString(procIndex1, "ERR");

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");


			if (strerr.equals("")) 
			{
				voObj.setGblWs2(ws);
			} 
			else 
			{
				throw new Exception(strerr);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("PatientDtlDAO.getAccountDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	
}
