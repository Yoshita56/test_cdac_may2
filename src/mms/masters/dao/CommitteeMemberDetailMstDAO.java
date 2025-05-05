/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 20/Jan/2009
 *  
 */
package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.CommitteeMemberDetailDAO;

import mms.masters.vo.CommitteeMemberDetailMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstDAO.
 */
public class CommitteeMemberDetailMstDAO {

	/**
	 * Gets the cat values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the cat values
	 */
	public static void getCatValues(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.commMemberMst.ItemCat.0");

			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			//dao.setQryValue(nQueryIndex, 2, vo.getStrCatCodesFromSession());
			web = dao.executeQry(nQueryIndex);

		
			
			vo.setItemCategoryWS(web);

		} catch (Exception e) {

			vo
					.setStrMsgString("CommitteeMemberDetailMstDAO.getCatValues() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;

		}
	}

	/**
	 * Gets the req type.
	 * 
	 * @param vo the vo
	 * 
	 * @return the req type
	 */
	public static void getReqType(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.commMemberMst.ReqType.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			// dao.setQryValue(nQueryIndex, 2, vo.getStrCatNo());
			web = dao.executeQry(nQueryIndex);

			vo.setReqTypeWS(web);

		} catch (Exception e) {

			vo.setStrMsgString("CommitteeMemberDetailMstDAO.getReqType() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;

		}
	}
	/**
	 * Gets the req type.
	 * 
	 * @param vo the vo
	 * 
	 * @return the req type
	 */
	public static void getEmpUserIdCombo(CommitteeMemberDetailMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;

		try 
		{
			dao = new HisDAO("MMS", "CommitteeMemberDetailMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,"select.commMemberMst.Userid.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrEmpNumber());
			web = dao.executeQry(nQueryIndex);

			vo.setStrUserIdWs(web);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CommitteeMemberDetailMstDAO.getReqType() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			dao = null;
			web = null;

		}
	}
	

	/**
	 * Gets the comm type.
	 * 
	 * @param vo the vo
	 * 
	 * @return the comm type
	 */
	public static void getCommType(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.commMemberMst.CommType.0");

			nQueryIndex = dao.setQuery(strQuery);

			//dao.setQryValue(nQueryIndex, 1, vo.getStrReqTypeId());
			dao.setQryValue(nQueryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			//dao.setQryValue(nQueryIndex, 3, vo.getStrCatNo());
			web = dao.executeQry(nQueryIndex);

			vo.setCommTypeWS(web);

		} catch (Exception e) {

			vo.setStrMsgString("CommitteeMemberDetailMstDAO.getCommType() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;

		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void AddRecordQuery(CommitteeMemberDetailMstVO vo) 
	{
		CommitteeMemberDetailDAO committeeMemberDAO = null;
		HisDAO dao = null;
		String[] strResponseTmp = null;
		String strRec[] = null;
		String strRecTmp[] = null;
		String committeeSlno = null;
		String EmpName = "";
		int d, k;
		String committeId = null;
		String finalSlNo = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try 
		{
			committeeMemberDAO = new CommitteeMemberDetailDAO();
			dao = new HisDAO("MMS", "CommitteeMemberDetailDAO");
			
			strResponseTmp = vo.getStrPrevVal().replace("@@", "#").split("#");
			
			for (int i = 0 , stopI = strResponseTmp.length; i < stopI; i++) 
			{
				strRecTmp = strResponseTmp[i].replace('^', '#').split("#");
				committeeMemberDAO.setStrLastModifiedSeatId(vo.getStrSeatId());
				committeeMemberDAO.setStrSeatId(vo.getStrSeatId());
				committeeMemberDAO.setStrHstCommettieNo(strRecTmp[3]);
				committeeMemberDAO.setStrHospitalCode(vo.getStrHospitalCode());
				committeeMemberDAO.setStrCategCode(vo.getStrCatNo());
				committeeMemberDAO.update1(dao);
				committeeMemberDAO.update2(dao);
			
			}

			committeId = callingCommttieNo(vo);
			vo.setStrCommitNo(committeId);
			
			strquery = mms.qryHandler_mms.getQuery(1,"select.commetteMemberDtl.duplicay.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrCommitNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			
			while (wb.next()) 
			{
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0)
			{
				committeeMemberDAO.setStrHstCommettieNo(committeId);
				committeeMemberDAO.setStrHospitalCode(vo.getStrHospitalCode());
				committeeMemberDAO.setStrCommettieTypeId(vo.getStrCommetieTypeId());
				committeeMemberDAO.setStrSeatId(vo.getStrSeatId());
				committeeMemberDAO.setStrEntryDate(vo.getStrCtDate());
				committeeMemberDAO.setStrIsValid("1");
				committeeMemberDAO.setStrCategCode(vo.getStrCatNo());
				
				committeeMemberDAO.insert(dao);
                
				for (int i = 0 , stopI = vo.getStrChkBox().length; i < stopI; i++) 
				{
					strRec = vo.getStrChkBox()[i].replace("$$", "#").split("#");
					
					if (strRec[0].equals("1")) 
					{
						committeeSlno = callingFunctionCommttieSlNo(vo);
						d = Integer.parseInt(committeeSlno);
						k = d + i;
						
						if (!strRec[5].equals("0")) 
						{
							EmpName = getEmpName(vo, strRec[5]);
						} 
						else 
						{
							EmpName = strRec[1];
						}

						finalSlNo = String.valueOf(k);
						committeeMemberDAO.setStrCommettieTypeId(vo.getStrCommetieTypeId());
						committeeMemberDAO.setStrHstCommettieNo(committeId);
						committeeMemberDAO.setStrHospitalCode(vo.getStrHospitalCode());
						committeeMemberDAO.setStrHstCommettieSlNo(finalSlNo);
						committeeMemberDAO.setStrHstrMemberName(EmpName);
						committeeMemberDAO.setStrHstrPhone(strRec[2]);
						committeeMemberDAO.setStrHstrEmail(strRec[3]);
						committeeMemberDAO.setStrHgstrEmpCode(strRec[5]);						
						committeeMemberDAO.setStrIsValid("1");						
						committeeMemberDAO.setStrChairPersonFlg(strRec[6]);						
						committeeMemberDAO.setStrGnumUserId(strRec[7]);
						
                        committeeMemberDAO.insert1(dao);
					}
				}
			} 
			else 
			{
				committeeMemberDAO.setStrLastModifiedSeatId(vo.getStrSeatId());
				committeeMemberDAO.setStrHstCommettieNo(strRecTmp[3]);
				committeeMemberDAO.setStrHospitalCode(vo.getStrHospitalCode());
				committeeMemberDAO.setStrCategCode(vo.getStrCatNo());
				committeeMemberDAO.update2(dao); 
				committeeMemberDAO.update1(dao);
			}
			synchronized (dao) 
			{
				dao.fire();
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("--> CommitteeMemberDetailMstDAO.AddRecordQuery()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
			wb = null;
		}
	}

	/* ---------------Calling of Function for CommttieNo--------------------- */
	/**
	 * Gets the emp name.
	 * 
	 * @param VO the vO
	 * @param EmpNo the emp no
	 * 
	 * @return the emp name
	 */
	public static String getEmpName(CommitteeMemberDetailMstVO VO, String EmpNo) 
	{
		HisDAO dao = null;
		String retVal = null;
		int funcIndex = 0;
		
		try 
		{
			dao = new HisDAO("MMS", "CommitteeMemberDetailMstDAO");
			funcIndex = dao.setFunction("{? = call AHIS_FUNCTION.fun_emp_name(?,?)}");
			
			dao.setFuncInValue(funcIndex, 2, EmpNo);
			dao.setFuncInValue(funcIndex, 3, VO.getStrHospitalCode());
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
		} 
		catch (Exception e) 
		{
			VO.setStrMsgString("CommitteeMemberDetailMstDAO.getEmpName() --> "+ e.getMessage());
			VO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}
		return retVal;
	}

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(CommitteeMemberDetailMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		WebRowSet wb = null;
		String strquery = "";
		String strquery1 = "";
		String str1 = null;
		HisUtil hisutil = null;

		try 
		{
			hisutil = new HisUtil("MMS", "CommitteeMemberDetailMstDAO");
			dao = new HisDAO("MMS", "CommitteeMemberDetailMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,"select.commetteMemberDtl.combo.1");
			strquery1 = mms.qryHandler_mms.getQuery(1,"select.commetteMemberDtl.combo.3");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);
			
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 1, "1");
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);

			str1 = hisutil.getOptionValue(wb, "0", "0^Select Value", true);

			if (str1 != null) 
			{
				vo.setStrCommitteTypeCombo(str1);
			} 
			else 
			{
				str1 = "<option value='0'>DATA N/A</option>";
				vo.setStrCommitteTypeCombo(str1);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CommitteeMemberDetailMstDAO.initialAddQuery()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
			wb = null;
		}
	}

	/**
	 * Gets the commettiee dtl.
	 * 
	 * @param vo the vo
	 * 
	 * @return the commettiee dtl
	 */
	public static void getCommettieeDtl(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		WebRowSet wb = null, wb1 = null;
		String strquery = "";
		String strquery1 = "";
		String str2 = null;

		try {

			dao = new HisDAO("mms", "CommitteMemberMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.combo.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrCommetieTypeId());

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.hlp.3");
			nqryIndex1 = dao.setQuery(strquery1);

			dao.setQryValue(nqryIndex1, 1, vo.getStrCommetieTypeId());
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 3, vo.getStrCatNo());
			wb = dao.executeQry(nqryIndex);
			wb1 = dao.executeQry(nqryIndex1);

			vo.setStrMemberDtlWs(wb1);

			if (wb != null) {
				if (wb.next()) {
					str2=wb.getString(2);
				} else {
					str2 = "---";
				}
				vo.setStrCommitteDtl(str2);
			} else {
				str2 = "---";
				vo.setStrCommitteDtl(str2);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getCommettieeDtl()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialModifyQuery(CommitteeMemberDetailMstVO vo) {

		HisDAO dao = null;
		int nqryIndex, nqryIndex1, nqryIndex2, nqryIndex3;
		WebRowSet wb = null,  wb3 = null;
		String strquery = "";
		String strquery1 = "";
		String strquery2 = "";
		String strquery3 = "";
		String strtemp[] = null;
		String chk1 = null;

		try {
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			chk1 = vo.getStrChk1();
			chk1 = chk1.replace('@', '$');
			strtemp = chk1.replace('$', '#').split("#");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.0"); // 3 Values
			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.1"); // 10 Values
			strquery3 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.modify.2");
			strquery2 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.data.11");

			nqryIndex = dao.setQuery(strquery);
			nqryIndex1 = dao.setQuery(strquery1);
			nqryIndex2 = dao.setQuery(strquery2);
			nqryIndex3 = dao.setQuery(strquery3);

			dao.setQryValue(nqryIndex, 1, strtemp[0]);

			dao.setQryValue(nqryIndex1, 1, strtemp[0]);
			dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex1, 3, "1");

			dao.setQryValue(nqryIndex2, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex2, 2, "1");

			dao.setQryValue(nqryIndex3, 1, strtemp[0]);
			dao.setQryValue(nqryIndex3, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex3, 3, "1");

			wb = dao.executeQry(nqryIndex);

		//	wb1 = dao.executeQry(nqryIndex1);

		//	wb2 = dao.executeQry(nqryIndex2);

			wb3 = dao.executeQry(nqryIndex3);

			while (wb.next()) {
				vo.setStrGroupName(wb.getString(3));
			}
			while (wb3.next()) {

				vo.setStrRemarks(wb3.getString(1));
				vo.setStrEffectiveFrom(wb3.getString(2));
			}

		} catch (Exception e) {
			// e.printStackTrace();

			vo
					.setStrMsgString("--> CommitteeMemberDetailMstDAO.initialModifyQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
			wb = null;
		//	wb1 = null;
		//	wb2 = null;
			wb3 = null;
		}

	}

	/*
	 * ---------------Calling of Function for
	 * CommttieSerialNo---------------------
	 */
	/**
	 * Calling function commttie sl no.
	 * 
	 * @param VO the vO
	 * 
	 * @return the string
	 */
	public static String callingFunctionCommttieSlNo(
			CommitteeMemberDetailMstVO VO) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_committee_slno(?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, VO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, VO.getStrCommitNo());
			dao.setFuncOutValue(funcIndex, 3);
			// Execute Function
			dao.executeFuncForNumeric(funcIndex);
			// Get Value From Function
			retVal = dao.getFuncNumeric(funcIndex);

		} catch (Exception e) {
			VO
					.setStrMsgString("CommitteeMemberDetailMstDAO.callingFunctionCommttieSlNo() --> "
							+ e.getMessage());
			VO.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return retVal;
	}

	/* ---------------Calling of Function for CommttieNo--------------------- */
	/**
	 * Calling commttie no.
	 * 
	 * @param VO the vO
	 * 
	 * @return the string
	 */
	public static String callingCommttieNo(CommitteeMemberDetailMstVO VO) {
		HisDAO dao = null;
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		// Split the Value

		try {
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_committee_no(?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, VO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, VO.getStrCommetieTypeId());
			dao.setFuncOutValue(funcIndex, 3);
			// Execute Function
			dao.executeFuncForNumeric(funcIndex);
			retVal = dao.getFuncNumeric(funcIndex).toString();

		} catch (Exception e) {
			VO
					.setStrMsgString("CommitteeMemberDetailMstDAO.callingCommttieNo() --> "
							+ e.getMessage());
			VO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return retVal;
	}

	/**
	 * Gets the emp detail for selected emp no.
	 * 
	 * @param vo the vo
	 * 
	 * @return the emp detail for selected emp no
	 */
	public static void getEmpDetailForSelectedEmpNo(
			CommitteeMemberDetailMstVO vo) {
		// WebRowSet ws = null;
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, "1");
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrChk1());
			wb = dao.executeQry(nqryIndex);
			if (wb.size() != 0) {
				vo.setStrEmpInfDataWs(wb);
			} else {
				vo.setStrEmpInfDataWs(null);

			}

		} catch (Exception e) {
			vo
					.setStrMsgString("CommitteeMemberDetailMstDAO.getContituteBy() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * Gets the contitute by.
	 * 
	 * @param vo the vo
	 * 
	 * @return the contitute by
	 */
	public static void getContituteBy(CommitteeMemberDetailMstVO vo) {
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.PROC_CONSULTANT_NAME(?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		String str2 = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("master", "CommitteeMemberDetailMstDAO");
			dao = new HisDAO("mms",
					"transactions.CommitteeMemberDetailMstDAO.getContituteBy()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "modeval", "4",1); // New Value
			dao.setProcInValue(nprocIndex, "deptunitcode", "0",2); // New Value
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3); // New Value
			//System.out.println("seatId: "+ vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "seatId",vo.getStrSeatId(),4);
			dao.setProcOutValue(nprocIndex, "err", 1,5); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "resultset", 2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");

			str2 = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);

			if (str2 != null) {
				vo.setStrEmpNumber(str2);
			} else {
				str2 = "<option value='0'>DATA N/A</option>";
				vo.setStrEmpNumber(str2);
			}

		} catch (Exception e) {
			vo.setStrMsgString("CommitteeMemberDetailMstDAO.getContituteBy() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * Gets the uNITVA l2.
	 * 
	 * @param vo the vo
	 * 
	 * @return the uNITVA l2
	 */
	public static void getUNITVAL2(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		WebRowSet wb = null, wb1 = null;
		String strquery = "";
		String strquery1 = "";

		try {
			dao = new HisDAO("mms", "DrugSaftyAlertMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.1");
			nqryIndex = dao.setQuery(strquery);

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.11");
			nqryIndex1 = dao.setQuery(strquery1);

			dao.setQryValue(nqryIndex, 1, "1");
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrCommetieTypeId());

			wb = dao.executeQry(nqryIndex);

			int length = wb.size();
			String[] Level = new String[length];
			String[] UserId = new String[length];

			String[] ConstituteById = new String[length];

			if (wb.size() != 0) {

				vo.setStrMode("1");
				for (int j = 0; wb.next(); j++) {

					vo.setStrCommitNo(wb.getString(1));

					vo.setStrConstituteDate(wb.getString(2));
					ConstituteById[j] = wb.getString(3);
					vo.setStrEffectiveFrom(wb.getString(4));
					String[] Data = wb.getString(5).split("\\^"); // Combination
																	// of User
																	// Level &
																	// User ID
					Level[j] = Data[0];
					UserId[j] = Data[1];

					// Calling User Details
				}
				dao.setQryValue(nqryIndex1, 1, "1");
				dao.setQryValue(nqryIndex1, 2, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex1, 3, vo.getStrCommitNo());

				wb1 = dao.executeQry(nqryIndex1);
				vo.setStrEmpCommtNoSlNoDataWs(wb1);
				vo.setStrConstituteByIdData(ConstituteById);
				vo.setStrEmpUserId(UserId);
				vo.setStrEmpLevel(Level);
				getCommMemberDtl(vo);

			} else {
				vo.setStrMode("0");

			}

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getSubGroupCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			wb = null;
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the comm member dtl2.
	 * 
	 * @param vo the vo
	 * 
	 * @return the comm member dtl2
	 */
	public static void getCommMemberDtl2(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		int nqryIndex, nqryIndex1, nqryIndex2;
		// int length = vo.getStrConstituteByIdData().length;
		WebRowSet wb1 = null;
		WebRowSet wb2 = null;
		WebRowSet wb3 = null;
		// WebRowSet wb = null;
		String strquery = "";
		String strquery1 = "";
		String strquery2 = "";
		HisUtil hisutil = null;

		try {
			hisutil = new HisUtil("master", "CommitteeMemberDetailMstDAO");

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.2");
			nqryIndex = dao.setQuery(strquery);

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.4");
			nqryIndex1 = dao.setQuery(strquery1);

			strquery2 = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.combo.3");
			nqryIndex2 = dao.setQuery(strquery2);

			dao.setQryValue(nqryIndex, 1, vo.getStrChk1());
			dao.setQryValue(nqryIndex1, 1, vo.getStrChk1());

			wb1 = dao.executeQry(nqryIndex);
			wb2 = dao.executeQry(nqryIndex1);
			wb3 = dao.executeQry(nqryIndex2);

			vo.setStrUpdateEmpInfHLPWs(wb1);
			vo.setStrUpdateEmpNameHLPWs(wb2);
			String strEmpAddrHLP = null;
			String strEmpNameHLP = null;
			String strEmpPhoneHLP = null;
			String strEmpEmailHLP = null;

			String str2 = hisutil.getOptionValue(wb3, "-1", "0^Select Value",
					true);

			if (str2 != null) {
				vo.setStrUserIdCombo(str2);
			} else {
				str2 = "<option value='0'>DATA N/A</option>";
				vo.setStrUserIdCombo(str2);
			}

			if (wb1.size() > 0) {
				for (int j = 0; wb1.next(); j++) {
					strEmpAddrHLP = wb1.getString(1) + "" + wb1.getString(2)
							+ wb1.getString(3) + "" + wb1.getString(4);
					strEmpPhoneHLP = wb1.getString(5);
					strEmpEmailHLP = wb1.getString(6);
				}
			} else {
				strEmpAddrHLP = "N/A";
				strEmpPhoneHLP = "N/A";
				strEmpEmailHLP = "N/A";

			}
			if (wb2.size() > 0) {
				for (int j = 0; wb2.next(); j++) {
					String[] Data = wb2.getString(1).split("\\^");
					strEmpNameHLP = Data[0] + "" + Data[1] + "" + Data[2];
				}
			} else {
				strEmpNameHLP = "N/A";

			}

			vo.setStrEmpNameHLP(strEmpNameHLP);
			vo.setStrEmpAddrHLP(strEmpAddrHLP);
			vo.setStrEmpPhoneHLP(strEmpPhoneHLP);
			vo.setStrEmpEmailHLP(strEmpEmailHLP);
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getSubGroupCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the comm member dtl.
	 * 
	 * @param vo the vo
	 * 
	 * @return the comm member dtl
	 */
	public static void getCommMemberDtl(CommitteeMemberDetailMstVO vo) {
		HisDAO dao = null;
		int nqryIndex, nqryIndex1;
		int length = vo.getStrConstituteByIdData().length;
		WebRowSet[] wb1 = new WebRowSet[length];
		WebRowSet[] wb2 = new WebRowSet[length];
		// WebRowSet wb = null;
		String strquery = "";
		String strquery1 = "";

		try {

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.2");
			nqryIndex = dao.setQuery(strquery);

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.commetteMemberDtl.data.4");
			nqryIndex1 = dao.setQuery(strquery1);

			for (int i = 0 , stopI = vo.getStrConstituteByIdData().length; i <stopI ; i++) {

				dao.setQryValue(nqryIndex, 1, vo.getStrConstituteByIdData()[i]);
				dao
						.setQryValue(nqryIndex1, 1, vo
								.getStrConstituteByIdData()[i]);
				wb1[i] = dao.executeQry(nqryIndex);
				wb2[i] = dao.executeQry(nqryIndex1);
			}

			vo.setStrUpdateEmpInfWs(wb1);
			vo.setStrUpdateEmpNameWs(wb2);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getSubGroupCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the drug combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the drug combo
	 */
	public static void getDrugCombo(CommitteeMemberDetailMstVO vo) {

		HisDAO dao = null;
		int nqryIndex1;
		WebRowSet wb1 = null;

		String strquery1 = "";
		String str2 = null;
		HisUtil hisutil = null;

		try {
			hisutil = new HisUtil("master", "CommitteeMemberDetailMstDAO");
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.combo.1");

			nqryIndex1 = dao.setQuery(strquery1);

			// dao.setQryValue(nqryIndex1, 1, vo.getStrSubGrpId());

			wb1 = dao.executeQry(nqryIndex1);

			str2 = hisutil.getOptionValue(wb1, "-1", "0^Select Value", true);

			if (str2 != null) {
				// vo.setStrDrugNameCombo(str2);
			} else {
				str2 = "<option value='0'>DATA N/A</option>";
				// vo.setStrDrugNameCombo(str2);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> DrugSaftyAlertMstDAO.getDrugCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	// public static void chkDuplicate(CommitteeMemberDetailMstVO vo) {
	// HisDAO dao = null;
	// int nqryIndex;
	// int ncount = 0;
	// WebRowSet wb = null;
	// String strquery = "";
	//
	// try {
	// dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");
	// strquery = mms.qryHandler_mms
	// .getQuery(1, "select.StoreGroup.2");
	// nqryIndex = dao.setQuery(strquery);
	//
	// dao.setQryValue(nqryIndex, 1, vo.getStrGroupName());
	// dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
	// dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
	//
	// wb = dao.executeQry(nqryIndex);
	//
	// while (wb.next()) {
	// ncount = Integer.parseInt(wb.getString(1));
	// }
	//
	// if (ncount == 0) {
	// vo.setBExistStatus(true);
	// } else {
	// vo.setBExistStatus(false);
	// }
	// } catch (Exception e) {
	// vo.setStrMsgString("--> DrugSaftyAlertMstDAO.chkDuplicate()-->"
	// + e.getMessage());
	// vo.setStrMsgType("1");
	// } finally {
	// if (dao != null)
	// dao.free();
	// dao = null;
	// }
	// }
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 */
	public static void modifyQuery(CommitteeMemberDetailMstVO vo) {

		HisDAO dao = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		String strquery = "";

		try {

			strtemp = vo.getStrChk1().replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, strtemp[1]);

			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrStoreTypeId(web.getString(1));
				vo.setStrGroupName(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));

			}

		} catch (Exception e) {
			vo
					.setStrMsgString("--> CommitteeMemberDetailMstDAO.modifyQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(CommitteeMemberDetailMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.4");

			nqryIndex = dao.setQuery(strquery);

			strtemp = vo.getStrChk1().replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupName());
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 3, strtemp[1]);
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeId());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));

			}

			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("--> CommitteeMemberDetailMstDAO.initialUpdateQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

}
