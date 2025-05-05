/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.DmlHsttIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.AgendaDeskAddTransVO;
import mms.transactions.vo.IndentTransADDVO;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskAddTransDAO {
	/**
	 * To get the store combo values
	 * 
	 */
	public static void setToStoreValues(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_hstt_tostore_mst(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.AgendaDeskAddTransDAO.setGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "storeid",
					_AgendaDeskAddTransVO.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "reqtype", "61,88",4);
			dao.setProcInValue(nProcIndex, "catCode",
					_AgendaDeskAddTransVO.getStrItemCat(),5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_AgendaDeskAddTransVO.setStrToStoreValues(util.getOptionValue(
						wsResult, _AgendaDeskAddTransVO.getStrStoreId(), "", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.setToStoreValues() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setGrantTypeValues(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_grant_list(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.AgendaDeskAddTransDAO.setGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_AgendaDeskAddTransVO.setStrGrantTypeValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.setGrantTypeValues() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setRateUnitValues(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.AgendaDeskAddTransDAO.setRateUnitValues()");
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.setRateUnitValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			if(!_AgendaDeskAddTransVO.getStrItemId().equals("10"))
				dao.setProcInValue(nProcIndex, "modeval", "5",4);
			else
				dao.setProcInValue(nProcIndex, "modeval", "1",4);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id",
					_AgendaDeskAddTransVO.getStrInventoryUnitId(),2);
			dao.setProcInValue(nProcIndex, "module_id", "",3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_AgendaDeskAddTransVO.setStrRateUnitValues(util.getOptionValue(
						wsResult, "", "", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.setRateUnitValues() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setIndentDetails(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Indent_Dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			if(!_AgendaDeskAddTransVO.getStrAgendaType().equals("1"))	//added by shalini to get data based on agenda type	1 is for patient wise & 2 is for annual purchase 
				dao.setProcInValue(nProcIndex, "modeval", "2",1);
			else
				dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "store_id",
					_AgendaDeskAddTransVO.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "itemcat_no",
					_AgendaDeskAddTransVO.getStrItemCat(),5);
			dao.setProcInValue(nProcIndex, "indent_no", "",3);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_AgendaDeskAddTransVO.setWbIndentDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.setIndentDetails() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getIndentPopupDetails(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Indent_Item_Dtls(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.getIndentPopupDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "indentno",
					_AgendaDeskAddTransVO.getStrIndentNo(),3);
			dao.setProcInValue(nProcIndex, "frmstoreid",
					_AgendaDeskAddTransVO.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_AgendaDeskAddTransVO.setWbIndentDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.getIndentPopupDetails() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getIndentItemDetails(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Indent_Item_Dtls(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.getIndentItemDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code",	_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "indentno",_AgendaDeskAddTransVO.getStrIndentNo(),3);
			//System.out.println("Indent No==>"+_AgendaDeskAddTransVO.getStrIndentNo());
			dao.setProcInValue(nProcIndex, "frmstoreid",_AgendaDeskAddTransVO.getStrStoreIds(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			if (strErr == null || strErr.equals("")) {
				_AgendaDeskAddTransVO.setWbIndentItemDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.getIndentItemDetails() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static String getAgendaNo(AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strProcName = "{? = call mms_mst.generate_agendaNo (?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strAgendaNo = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.getAgendaNo()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2,
					_AgendaDeskAddTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,
					_AgendaDeskAddTransVO.getStrStoreId());
			if(_AgendaDeskAddTransVO.getStrAgendaType().equals("1"))
				dao.setFuncInValue(funcIndex, 4, "88");//88 is for B&S compilation
			else
				dao.setFuncInValue(funcIndex, 4, "61");
			dao.setFuncInValue(funcIndex, 5,
					_AgendaDeskAddTransVO.getStrItemCat());
			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strAgendaNo = dao.getFuncString(funcIndex);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.getAgendaNo() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strAgendaNo;
	}

	/**
	 * This Method Added By Amit on Date 06/08/2009 for getting option value of
	 * combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void IndentPeriodCombo(AgendaDeskAddTransVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "AgendaDeskAddTransDAO");
			dao = new HisDAO("mms",
					"AgendaDeskAddTransDAO.GetDeptCombo(AgendaDeskAddTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "ERR", 1,3); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,4); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);

				vo.setStrAgendaPeriod(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrAgendaPeriod(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("AgendaDeskAddTransDAO.IndentPeriodCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static void getItemPopupData(
			AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strProcName = "{? = call mms_mst.Get_item_property (?,?,?,?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strItemPopupData = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.getItemPopupData()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, "5");
			dao.setFuncInValue(funcIndex, 3,
					_AgendaDeskAddTransVO.getStrItemId());
			dao.setFuncInValue(funcIndex, 4,
					_AgendaDeskAddTransVO.getStrHospitalCode());

			dao.setFuncInValue(funcIndex, 5, "0");
			dao.setFuncInValue(funcIndex, 6, "0");

			dao.setFuncOutValue(funcIndex, 1);

			dao.executeFunction(funcIndex);
			strItemPopupData = dao.getFuncString(funcIndex);

			_AgendaDeskAddTransVO.setStrItemPopupData(strItemPopupData);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.getItemPopupData() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void insert(AgendaDeskAddTransVO _AgendaDeskAddTransVO) {
		String strProcName = "{call pkg_mms_dml.dml_hstt_agenda_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName1 = "{call pkg_mms_dml.Dml_hstt_Agenda_Item_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		 String strProcName2 = "{call PKG_MMS_DML.DML_INDENT_DTL(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
		 String strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Indent_Item_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		String strVMode = "0";
		String indentNo="0000";
		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		int nProc3Index = 0;
		String strErr = "";
		String strAgendaNo = "";
		MmsConfigUtil mmsConfigUtil = null;
		try {
			mmsConfigUtil = new MmsConfigUtil(_AgendaDeskAddTransVO.getStrHospitalCode());
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskAddTransDAO.insert()");

			strAgendaNo = getAgendaNo(_AgendaDeskAddTransVO);

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "2",1);
			dao.setProcInValue(nProcIndex, "strId",
					_AgendaDeskAddTransVO.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "agendaNo", strAgendaNo,4);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskAddTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "itemCategNo",
					_AgendaDeskAddTransVO.getStrItemCat(),5);
			dao.setProcInValue(nProcIndex, "toStrId",
					_AgendaDeskAddTransVO.getStrToStore(),15);
			dao.setProcInValue(nProcIndex, "agenda_period",
					_AgendaDeskAddTransVO.getStrAgendaPeriod(),16);
			dao.setProcInValue(nProcIndex, "fin_start_date", mmsConfigUtil
					.getStrFinancialStartDate(
							_AgendaDeskAddTransVO.getStrStoreId(),
							_AgendaDeskAddTransVO.getStrHospitalCode()),7);
			dao.setProcInValue(nProcIndex, "fin_end_date", mmsConfigUtil
					.getStrFinancialEndDate(
							_AgendaDeskAddTransVO.getStrStoreId(),
							_AgendaDeskAddTransVO.getStrHospitalCode()),8);
			dao.setProcInValue(nProcIndex, "strRemarks",
					_AgendaDeskAddTransVO.getStrRemarks(),9);
			dao.setProcInValue(nProcIndex, "seatId",
					_AgendaDeskAddTransVO.getStrSeatId(),10);
			if(_AgendaDeskAddTransVO.getStrAgendaType().equals("1"))//for B&S compilation
				dao.setProcInValue(nProcIndex, "reqType", "88",6);
			else
				dao.setProcInValue(nProcIndex, "reqType", "61",6);
			dao.setProcInValue(nProcIndex, "grant_type_id",
					_AgendaDeskAddTransVO.getStrGrantTypeId(),17);
			dao.setProcInValue(nProcIndex, "agenda_period_value",
					_AgendaDeskAddTransVO.getStrAgendaPeriodValue(),18);

			dao.setProcInValue(nProcIndex, "agenda_date", "",11);
			dao.setProcInValue(nProcIndex, "agenda_status", "",12);
			dao.setProcInValue(nProcIndex, "isvalid", "1",13);
			dao.setProcInValue(nProcIndex, "strCondemnationType", "1",14);
			

			//strErr = dao.getString(nProcIndex, "err");
			//if (strErr != null && !strErr.equals(""))
			//	throw new Exception(strErr);

		//	strVMode = dao.getString(nProcIndex, "agenda_approval_status");
			//dao.free();
			

			for (int nTmpI = 0; nTmpI < _AgendaDeskAddTransVO.getStrCheckBox().length; nTmpI++) {
				for (int nTmpJ = 0; nTmpJ < _AgendaDeskAddTransVO
						.getStrCheckBoxItem().length; nTmpJ++) {
					nProc1Index = dao.setProcedure(strProcName1);
					dao.setProcInValue(nProc1Index, "modval", "3",1);
					dao.setProcInValue(nProc1Index, "indent_no",
							_AgendaDeskAddTransVO.getStrDReqestNo()[nTmpI],36);
					dao.setProcInValue(nProc1Index, "raising_store",
							_AgendaDeskAddTransVO.getStrDRaisingStore()[nTmpI],37);
					dao.setProcInValue(nProc1Index, "indent_date",
							_AgendaDeskAddTransVO.getStrDReqestDate()[nTmpI],38);
					dao.setProcInValue(nProc1Index, "indent_period",
							_AgendaDeskAddTransVO.getStrDReqestPeriod()[nTmpI],39);

					dao.setProcInValue(nProc1Index, "strId",
							_AgendaDeskAddTransVO.getStrStoreId(),3);
					dao.setProcInValue(nProc1Index, "agendaNo", strAgendaNo,4);
					dao.setProcInValue(nProc1Index, "itemId",
							_AgendaDeskAddTransVO.getStrDitemId()[nTmpJ],6);
					dao.setProcInValue(nProc1Index, "itemBrandId",
							_AgendaDeskAddTransVO.getStrDitemBrandId()[nTmpJ],7);
					dao.setProcInValue(nProc1Index, "hosp_code",
							_AgendaDeskAddTransVO.getStrHospitalCode(),2);
					dao.setProcInValue(nProc1Index, "strGroupId",
							_AgendaDeskAddTransVO.getStrDGroupId()[nTmpJ],8);
					dao.setProcInValue(nProc1Index, "strSubGroupId",
							_AgendaDeskAddTransVO.getStrDSubGroupId()[nTmpJ],9);
					dao.setProcInValue(nProc1Index, "strCompiledQty",
							_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],12);
					dao.setProcInValue(
							nProc1Index,
							"strCompiledQtyUnit",
							_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],13);
					dao.setProcInValue(nProc1Index, "strLstPurRate",
							_AgendaDeskAddTransVO.getStrDLstPurRate()[nTmpJ],15);
					if (strVMode.equals("0")) {
						dao.setProcInValue(
								nProc1Index,
								"strSancQty",
								_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],17);
						dao.setProcInValue(
								nProc1Index,
								"strSancQtyUnit",
								_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],18);
					} else {
						dao.setProcInValue(nProc1Index, "strSancQty", "0",17);
						dao.setProcInValue(nProc1Index, "strSancQtyUnit", "0",18);
					}
					dao.setProcInValue(
							nProc1Index,
							"strLstPurRateUnit",
							_AgendaDeskAddTransVO.getStrDLstPurRateUnit()[nTmpJ],16);
					dao.setProcInValue(nProc1Index, "strRemarks",
							_AgendaDeskAddTransVO.getStrRemarks(),14);
					dao.setProcInValue(nProc1Index, "strLstPoNo",
							_AgendaDeskAddTransVO.getStrDLstPoNo()[nTmpJ],19);
					dao.setProcInValue(nProc1Index, "strApproxRate",
							_AgendaDeskAddTransVO.getStrDApproxRate()[nTmpJ],25);
					dao.setProcInValue(
							nProc1Index,
							"strApproxRateUnit",
							_AgendaDeskAddTransVO.getStrDApproxRateUnit()[nTmpJ]
									.replace("^", "#").split("#")[0],27);
					dao.setProcInValue(nProc1Index, "strLstPoDate",
							_AgendaDeskAddTransVO.getStrDLstPoDate()[nTmpJ],22);
					dao.setProcInValue(nProc1Index, "strLstSupplier",
							_AgendaDeskAddTransVO.getStrDLstSupplierId()[nTmpJ],20);
					dao.setProcInValue(nProc1Index, "strLstRecQty",
							_AgendaDeskAddTransVO.getStrDLstRecQty()[nTmpJ],23);
					if (_AgendaDeskAddTransVO.getStrDLstRecDate()[nTmpJ]
							.equals("/"))
						dao.setProcInValue(nProc1Index, "strLstRecDate", "",26);
					else
						dao.setProcInValue(
								nProc1Index,
								"strLstRecDate",
								_AgendaDeskAddTransVO.getStrDLstRecDate()[nTmpJ],26);
					dao.setProcInValue(nProc1Index, "strLstRecQtyUnit",
							_AgendaDeskAddTransVO.getStrDLstRecQtyUnit()[nTmpJ],24);
					dao.setProcInValue(nProc1Index, "reqFlag", "" + nTmpI,40);
					dao.setProcInValue(nProc1Index, "itemFlag", "" + nTmpJ,41);
					dao.setProcInValue(
							nProc1Index,
							"lstItemFlag",
							""
									+ (nTmpJ == _AgendaDeskAddTransVO
											.getStrCheckBoxItem().length - 1 ? 1
											: 0),42);

					/**************** Set Default value start *****************/

					dao.setProcInValue(nProc1Index, "reqNo", "",5);
					dao.setProcInValue(nProc1Index, "strQty", "",10);
					dao.setProcInValue(nProc1Index, "strUnitId", "",11);
					dao.setProcInValue(nProc1Index, "strLstRate", "",21);
					dao.setProcInValue(nProc1Index, "strLstRateUnitId", "",28);
					dao.setProcInValue(nProc1Index, "strCategNo", "0",29);
					dao.setProcInValue(nProc1Index, "strSeatId", "",30);
					dao.setProcInValue(nProc1Index, "strPoDate", "",31);
					dao.setProcInValue(nProc1Index, "strInhandQty", "",32);
					dao.setProcInValue(nProc1Index, "strInhandUnitId", "",33);
					dao.setProcInValue(nProc1Index, "strLastRecQty", "",34);
					dao.setProcInValue(nProc1Index, "strLastRecQtyUnitId", "",35);

					/***************** Set default value end *****************/

					dao.setProcOutValue(nProc1Index, "err", 1,43);
					dao.execute(nProc1Index,1);
				}
			}
			
			nProc2Index = dao.setProcedure(strProcName2);
			dao.setProcInValue(nProc2Index,"modval","1",1);                           //1
		   	dao.setProcInValue(nProc2Index,"strId",_AgendaDeskAddTransVO.getStrStoreId(),2);                   //2
	       	dao.setProcInValue(nProc2Index,"hosp_code",_AgendaDeskAddTransVO.getStrHospitalCode().trim(),3);           //3
			dao.setProcInValue(nProc2Index,"reqTypeId ","17",4);          //4 
			dao.setProcInValue(nProc2Index,"toStrId",_AgendaDeskAddTransVO.getStrToStore(),5);               //5
			dao.setProcInValue(nProc2Index,"itemcatNo",_AgendaDeskAddTransVO.getStrItemCat().trim(),6);           //6
			dao.setProcInValue(nProc2Index,"itemTypeId","",7);         //7  
			dao.setProcInValue(nProc2Index,"urgentFlag","0",8);
			//8
			dao.setProcInValue(nProc2Index,"indentPeriod","-",9);     //9
			dao.setProcInValue(nProc2Index,"finStartDate",mmsConfigUtil
					.getStrFinancialStartDate(
							_AgendaDeskAddTransVO.getStrStoreId(),
							_AgendaDeskAddTransVO.getStrHospitalCode()),10);     //10       
			dao.setProcInValue(nProc2Index,"finEndDate",mmsConfigUtil
					.getStrFinancialEndDate(
							_AgendaDeskAddTransVO.getStrStoreId(),
							_AgendaDeskAddTransVO.getStrHospitalCode()),11);         //11
			dao.setProcInValue(nProc2Index,"remarks","Indent For Issue from agenda desk".trim(),12);   
			//12
			dao.setProcInValue(nProc2Index,"seatId",_AgendaDeskAddTransVO.getStrSeatId(),13);                 //13
			dao.setProcInValue(nProc2Index,"grantTypeId","",14);       //14
			dao.setProcInValue(nProc2Index,"puk ","",15);                      //15 
			dao.setProcInValue(nProc2Index,"empNo","",16);                   //16
			dao.setProcInValue(nProc2Index,"admNo","",17);  
			//17
			dao.setProcInValue(nProc2Index,"episodeCode","",18);       //18  
			dao.setProcInValue(nProc2Index,"consultantId","",19);     //19
			dao.setProcInValue(nProc2Index,"memoNo","",20);           //20
			dao.setProcInValue(nProc2Index,"totCost", "",21);  
			//21  
			dao.setProcInValue(nProc2Index,"indentPeriodValue", "-",22); //22
			
			dao.setProcInValue(nProc2Index,"cancelSeatId", "",23);
			dao.setProcInValue(nProc2Index,"cancelDate", "",24);
			dao.setProcInValue(nProc2Index,"cancelReason", "",25);
			
			dao.setProcInValue(nProc2Index,"certificateNo", "0",26);
			dao.setProcInValue(nProc2Index,"certificateDate", "",27);
			dao.setProcInValue(nProc2Index,"rateContSuppId", "0",28);
			dao.setProcInValue(nProc2Index,"bsReqNo", "0",29);
			dao.setProcInValue(nProc2Index, "diagCode", "0",30);
			dao.setProcInValue(nProc2Index, "empCode", "0",31);
	    	//output value                        
			dao.setProcOutValue(nProc2Index,"approvalFlg",1,32);                       //23
			dao.setProcOutValue(nProc2Index,"indentNo",1,33);                          //24
			dao.setProcOutValue(nProc2Index,"err",1,34);                               //25
			
			//not keeping in batch bcz of indent no.
			dao.executeProcedureByPosition(nProc2Index);
			
			indentNo = dao.getString(nProc2Index, "indentNo");
			String approvalFlg = dao.getString(nProc2Index, "approvalFlg");
			
			dao.setProcInValue(nProcIndex, "strreqno",indentNo,19);
			dao.setProcOutValue(nProcIndex, "agenda_approval_status", 1,20);

			dao.setProcOutValue(nProcIndex, "err", 1,21);

			dao.execute(nProcIndex,1);
			//_AgendaDeskAddTransVO.setStrIndentNo(indentNo);
			
			//for (int nTmpI = 0; nTmpI < _AgendaDeskAddTransVO.getStrCheckBox().length; nTmpI++) {
				for (int nTmpJ = 0; nTmpJ < _AgendaDeskAddTransVO
						.getStrCheckBoxItem().length; nTmpJ++) {
					nProc3Index = dao.setProcedure(strProcName3);
					dao.setProcInValue(nProc3Index,"modval","1",1);                           				//1
				   	dao.setProcInValue(nProc3Index,"strIndentNo",indentNo.trim(),2);                	//2
//				   	System.out.println("strStoreId.trim()==>"+strStoreId.trim());
//					System.out.println("itemId.trim()==>"+strItemId.trim());
//					System.out.println("strItemBrandId.trim()==>"+strItemBrandId.trim());		
			       	dao.setProcInValue(nProc3Index,"strId",_AgendaDeskAddTransVO.getStrStoreId(),3);           				//3
					dao.setProcInValue(nProc3Index,"hosp_code ",_AgendaDeskAddTransVO.getStrHospitalCode().trim(),4);          			//4 
					dao.setProcInValue(nProc3Index,"groupId",_AgendaDeskAddTransVO.getStrDGroupId()[nTmpJ],5);        					//5
					dao.setProcInValue(nProc3Index,"subGroupId",_AgendaDeskAddTransVO.getStrDSubGroupId()[nTmpJ],6);           		//6
					dao.setProcInValue(nProc3Index,"itemId",_AgendaDeskAddTransVO.getStrDitemId()[nTmpJ],7);         					//7  
					dao.setProcInValue(nProc3Index,"itemBrandId",_AgendaDeskAddTransVO.getStrDitemBrandId()[nTmpJ],8); 				//8
					dao.setProcInValue(nProc3Index,"rate",_AgendaDeskAddTransVO.getStrDApproxRate()[nTmpJ],9); 								//9
					dao.setProcInValue(nProc3Index,"rateUnitId",_AgendaDeskAddTransVO.getStrDApproxRateUnit()[nTmpJ].replace("^", "#").split("#")[0],10); 					//10																//10       
					dao.setProcInValue(nProc3Index,"indentQty",_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],11);          			//11
					//System.out.println("Indent Qty-->>"+strIndentQty.trim());
					dao.setProcInValue(nProc3Index,"indentQtyUnitId",_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],12);      	//12
			       	//System.out.println("Indent Qty Unit Id-->>"+strIndentQtyUnitId.trim());
					//dao.setProcInValue(nProc3Index,"sancQty",_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],13);       					//13
					//dao.setProcInValue(nProc3Index,"sancQtyUnitId ",strSancQtyUnitId.trim(),14);			//14 
					if (!approvalFlg.equals("0")) {
						dao.setProcInValue(
								nProc3Index,
								"strSancQty",
								_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],13);
						dao.setProcInValue(
								nProc3Index,
								"strSancQtyUnit",
								_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],14);
					} else {
						dao.setProcInValue(nProc3Index, "strSancQty", "0",13);
						dao.setProcInValue(nProc3Index, "strSancQtyUnit", "0",14);
					}
					dao.setProcInValue(nProc3Index,"issueQty","",15);     					//15
					dao.setProcInValue(nProc3Index,"issueQtyUnitId","",16);			//16
					dao.setProcInValue(nProc3Index,"inHandQty","",17);        				//17  
					dao.setProcInValue(nProc3Index,"inHandQtyUnitId","",18);			//18
					dao.setProcInValue(nProc3Index,"consumableFlag","",19);     		//19
					dao.setProcInValue(nProc3Index,"reOrderLevel", "",20);				//20
					dao.setProcInValue(nProc3Index,"reOrderLevelUnitId","",21);   //21
					dao.setProcInValue(nProc3Index,"lstIndentQty","",22);				//22 
					dao.setProcInValue(nProc3Index,"lstIndentUnitId","",23);		//23
					dao.setProcInValue(nProc3Index,"lstIssueQty","",24);					//24
					dao.setProcInValue(nProc3Index,"lstIssueUnitId","",25);			//25
					dao.setProcInValue(nProc3Index,"remarks","Indent From Agenda Desk",26);        		    		//26
						    	
					//output value                        
					dao.setProcOutValue(nProc3Index,"err",1,27);                               				//27
					
					//keep in batch
					dao.execute(nProc3Index,1);
					
					
					/*dao.setProcInValue(nProc3Index, "modval", "1",1);
					dao.setProcInValue(nProc3Index, "indent_no",
							_AgendaDeskAddTransVO.getStrIndentNo(),36);
					dao.setProcInValue(nProc3Index, "raising_store",
							_AgendaDeskAddTransVO.getStrStoreId(),37);
					dao.setProcInValue(nProc3Index, "indent_date",
							_AgendaDeskAddTransVO.getStrAgendaDate(),38);
					dao.setProcInValue(nProc3Index, "indent_period","",39);

					dao.setProcInValue(nProc3Index, "strId",_AgendaDeskAddTransVO.getStrStoreId(),3);
					dao.setProcInValue(nProc3Index, "agendaNo", strAgendaNo,4);
					dao.setProcInValue(nProc3Index, "itemId",
							_AgendaDeskAddTransVO.getStrDitemId()[nTmpJ],6);
					dao.setProcInValue(nProc3Index, "itemBrandId",
							_AgendaDeskAddTransVO.getStrDitemBrandId()[nTmpJ],7);
					dao.setProcInValue(nProc3Index, "hosp_code",
							_AgendaDeskAddTransVO.getStrHospitalCode(),2);
					dao.setProcInValue(nProc3Index, "strGroupId",
							_AgendaDeskAddTransVO.getStrDGroupId()[nTmpJ],8);
					dao.setProcInValue(nProc3Index, "strSubGroupId",
							_AgendaDeskAddTransVO.getStrDSubGroupId()[nTmpJ],9);
					dao.setProcInValue(nProc3Index, "strCompiledQty",
							_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],12);
					dao.setProcInValue(
							nProc3Index,
							"strCompiledQtyUnit",
							_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],13);
					dao.setProcInValue(nProc3Index, "strLstPurRate",
							_AgendaDeskAddTransVO.getStrDLstPurRate()[nTmpJ],15);
					if (strVMode.equals("0")) {
						dao.setProcInValue(
								nProc3Index,
								"strSancQty",
								_AgendaDeskAddTransVO.getStrDCompiledQty()[nTmpJ],17);
						dao.setProcInValue(
								nProc3Index,
								"strSancQtyUnit",
								_AgendaDeskAddTransVO.getStrDCompiledQtyUnit()[nTmpJ],18);
					} else {
						dao.setProcInValue(nProc3Index, "strSancQty", "0",17);
						dao.setProcInValue(nProc3Index, "strSancQtyUnit", "0",18);
					}
					dao.setProcInValue(
							nProc3Index,
							"strLstPurRateUnit",
							_AgendaDeskAddTransVO.getStrDLstPurRateUnit()[nTmpJ],16);
					dao.setProcInValue(nProc3Index, "strRemarks",
							_AgendaDeskAddTransVO.getStrRemarks(),14);
					dao.setProcInValue(nProc3Index, "strLstPoNo",
							_AgendaDeskAddTransVO.getStrDLstPoNo()[nTmpJ],19);
					dao.setProcInValue(nProc3Index, "strApproxRate",
							_AgendaDeskAddTransVO.getStrDApproxRate()[nTmpJ],25);
					dao.setProcInValue(
							nProc3Index,
							"strApproxRateUnit",
							_AgendaDeskAddTransVO.getStrDApproxRateUnit()[nTmpJ]
									.replace("^", "#").split("#")[0],27);
					dao.setProcInValue(nProc3Index, "strLstPoDate",
							_AgendaDeskAddTransVO.getStrDLstPoDate()[nTmpJ],22);
					dao.setProcInValue(nProc3Index, "strLstSupplier",
							_AgendaDeskAddTransVO.getStrDLstSupplierId()[nTmpJ],20);
					dao.setProcInValue(nProc3Index, "strLstRecQty",
							_AgendaDeskAddTransVO.getStrDLstRecQty()[nTmpJ],23);
					if (_AgendaDeskAddTransVO.getStrDLstRecDate()[nTmpJ]
							.equals("/"))
						dao.setProcInValue(nProc3Index, "strLstRecDate", "",26);
					else
						dao.setProcInValue(
								nProc3Index,
								"strLstRecDate",
								_AgendaDeskAddTransVO.getStrDLstRecDate()[nTmpJ],26);
					dao.setProcInValue(nProc3Index, "strLstRecQtyUnit",
							_AgendaDeskAddTransVO.getStrDLstRecQtyUnit()[nTmpJ],24);
					dao.setProcInValue(nProc3Index, "reqFlag", "" + nTmpI,40);
					dao.setProcInValue(nProc3Index, "itemFlag", "" + nTmpJ,41);
					dao.setProcInValue(
							nProc3Index,
							"lstItemFlag",
							""
									+ (nTmpJ == _AgendaDeskAddTransVO
											.getStrCheckBoxItem().length - 1 ? 1
											: 0),42);

					/**************** Set Default value start *****************/

					/**dao.setProcInValue(nProc3Index, "reqNo", "",5);
					dao.setProcInValue(nProc3Index, "strQty", "",10);
					dao.setProcInValue(nProc3Index, "strUnitId", "",11);
					dao.setProcInValue(nProc3Index, "strLstRate", "",21);
					dao.setProcInValue(nProc3Index, "strLstRateUnitId", "",28);
					dao.setProcInValue(nProc3Index, "strCategNo", "0",29);
					dao.setProcInValue(nProc3Index, "strSeatId", "",30);
					dao.setProcInValue(nProc3Index, "strPoDate", "",31);
					dao.setProcInValue(nProc3Index, "strInhandQty", "",32);
					dao.setProcInValue(nProc3Index, "strInhandUnitId", "",33);
					dao.setProcInValue(nProc3Index, "strLastRecQty", "",34);
					dao.setProcInValue(nProc3Index, "strLastRecQtyUnitId", "",35);

					/***************** Set default value end *****************/

				/*	dao.setProcOutValue(nProc3Index, "err", 1,43);
					dao.execute(nProc3Index,1);*/
				}
			//}
			
			
			synchronized (dao) {
				dao.fire();
			}

			strErr = dao.getString(nProc1Index, "err");
			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			_AgendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransDAO.insert() --> "
							+ _Err.getMessage());
			_AgendaDeskAddTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/*public static void INSERTINTABLE(AgendaDeskAddTransVO vo, String indentNo,
			String approvalFlg) {
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		DmlHsttIndentItemDtlDAO tableDao = null;
		String[] reqQtyUnit = null;

		// String[] sancQtyUnit=null;

		String strReqQty = "";
		String strReqUnit = "";
		String strSancQty = "";
		String strSancQtyUnit = "";

		try {
			// Createing Object for Table Specific DAO
			tableDao = new DmlHsttIndentItemDtlDAO();
			// HisUtil util = new HisUtil("","");
			// String strCtDate = util.getASDate("dd-MMM-yyyy");

			dao = new HisDAO("MMS", "transactions.IndentTransADDDAO.INSERT()");
			int length = vo.getItemParamValue().length;

			for (int i = 0; i < length; i++) {

				temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
				/*
				 * System.out.println("Display Value-->>>>"+temp[0]);
				 * System.out.println("Conversion  Value-->>>>"+temp[1]);
				 * System.out.println("User  Value-->>>>"+temp[2]);
				 */
				//strTemp = temp[2].replace('^', '#').split("#");
				/*
				 * System.out.println("ItemID-1->>"+strTemp[0]);
				 * System.out.println("ItemBrandID-2->>"+strTemp[1]);
				 * System.out.println("GrpID-3->>"+strTemp[2]);
				 * System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				 * System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				 * System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				 * System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				 * System.out.println("In Hand Qty-8->>"+strTemp[7]);
				 * System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				 * System.out.println("Last Rate-10->>"+strTemp[9]);
				 * System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
				 * 
				 * 
				 * System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				 * System.out.println("Last PO No-13->>"+strTemp[12]);
				 * System.out.println("Last PO Date-14->>"+strTemp[13]);
				 * System.out
				 * .println("Last Supplied By [Id]-15->>"+strTemp[14]);
				 * System.out.println("Batch No-16->>"+strTemp[15]);
				 * System.out.println("Expiry Date-17->>"+strTemp[16]);
				 * System.out.println("Manufacture Date-18->>"+strTemp[17]);
				 * System.out.println("Item Serial No-19->>"+strTemp[18]);
				 * System
				 * .out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				 * System
				 * .out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp
				 * [20]);
				 * 
				 * System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				 * System
				 * .out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				 * System.out.println("Last Received Qty-24->>"+strTemp[23]);
				 * System
				 * .out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				 * System
				 * .out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				 * System
				 * .out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp
				 * [26]); System.out.println("Prefix-28->>"+strTemp[27]);
				 * System.out.println("Cost Parameter-29->>"+strTemp[28]);
				 * System.out.println(
				 * "Cost Unit [on individual item or on total cost]-30->>"
				 * +strTemp[29]);
				 * System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
				 * 
				 * System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]
				 * ); System.out.println("Stock Status-33->>"+strTemp[32]);
				 * 
				 * System.out.println("indent No-in LP DEPT .->>>"+indentNo);
				 * System
				 * .out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreId
				 * ());
				 */
			/*	strReqQty = vo.getStrReqQty()[i];

				strReqUnit = vo.getStrUnitName()[i];
				reqQtyUnit = strReqUnit.split("\\^");

				if (approvalFlg.equals("0")) {
					strSancQty = strReqQty;
					strSancQtyUnit = reqQtyUnit[0];
				} else {
					strSancQty = "0";
					strSancQtyUnit = "0";
				}

				tableDao.setStrIndentNo(indentNo);
				tableDao.setStrStoreId(vo.getStrStoreId());
				tableDao.setStrHospCode(vo.getStrHospitalCode());
				tableDao.setStrGroupId(strTemp[2]);
				tableDao.setStrSubGroupId(strTemp[3]);
				tableDao.setStrItemId(strTemp[0]);
				tableDao.setStrItemBrandId(strTemp[1]);
				tableDao.setStrRate(strTemp[9]);
				tableDao.setStrRateUnitId(strTemp[10]);
				tableDao.setStrIndentQty(strReqQty);
				tableDao.setStrIndentQtyUnitId(reqQtyUnit[0]);
				tableDao.setStrSancQty(strSancQty);
				tableDao.setStrSancQtyUnitId(strSancQtyUnit);
				tableDao.setStrIssueQty("0");
				tableDao.setStrIssueqtyUnitId("0");
				tableDao.setStrinHandQty(strTemp[7]);
				tableDao.setStrInHandQtyUnitId(strTemp[8]);
				tableDao.setStrConsumableFlag("1");
				tableDao.setStrReOrderLevel(strTemp[5]);
				tableDao.setStrReOrderLevelUnitId(strTemp[6]);
				tableDao.setStrLastIndentQty(strTemp[21]);
				tableDao.setStrLastIndentQtyUnitId(strTemp[22]);
				tableDao.setStrLastIssueQty("0");
				tableDao.setStrLastIssueQtyUnitId("0");
				tableDao.setStrRemarks(vo.getStrRemarks());

				tableDao.insert(dao);   // Dml_Hstt_Indent_Item_Dtl  Mode 1

			}
			synchronized (dao) {
				dao.fire(); // Here we Execute in Batch
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}*/
}
