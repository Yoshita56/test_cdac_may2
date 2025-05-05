package dossier.transaction.dao;

import dossier.masters.qryHandler_dossier;

import java.util.List;
import java.util.ArrayList;

import mms.transactions.vo.RequestForLPPatientVO;
import mms.MmsConfigUtil;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import dossier.transaction.vo.LPIssueDeskTransVO;

public class LPIssueDeskTransDAO
{
    public static void getLPRequestDetail(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_dossier_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        String BillingValue = "";
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
            final int funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");
            dao.setFuncInValue(funcIndex, 2, _LPIssueDeskTransVO.getStrHospitalCode());
            dao.setFuncInValue(funcIndex, 3, "2");
            dao.setFuncInValue(funcIndex, 4, _LPIssueDeskTransVO.getStrCrNo());
            dao.setFuncOutValue(funcIndex, 1);
            dao.executeFunction(funcIndex);
            BillingValue = dao.getFuncString(funcIndex);
            
            System.out.println("BillingValue" + BillingValue);
            
            _LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", 			"1", 1);
            dao.setProcInValue(procIndex1, "lPRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 2);  //   hnum_dossier_req_id
            dao.setProcInValue(procIndex1, "strRasingStoreId", 	_LPIssueDeskTransVO.getStrRaisingStoreId(), 3);
            dao.setProcInValue(procIndex1, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 4);
            dao.setProcInValue(procIndex1, "strRequestNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 5);
            dao.setProcOutValue(procIndex1, "err", 1, 6);
            dao.setProcOutValue(procIndex1, "resultset", 2, 7);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            System.out.println("setRequestItemDtlWS" + ws.size());
            _LPIssueDeskTransVO.setRequestItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getLPRequestDetail_new(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        String BillingValue = "";
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getLPRequestDetail_new(LPIssueDeskTransVO vo)");
            final int funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");
            dao.setFuncInValue(funcIndex, 2, _LPIssueDeskTransVO.getStrHospitalCode());
            dao.setFuncInValue(funcIndex, 3, "2");
            dao.setFuncInValue(funcIndex, 4, _LPIssueDeskTransVO.getStrCrNo());
            dao.setFuncOutValue(funcIndex, 1);
            dao.executeFunction(funcIndex);
            BillingValue = dao.getFuncString(funcIndex);
            //System.out.println("BillingValue" + BillingValue);
            
            _LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);
            
            
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", 				"2", 1);
            dao.setProcInValue(procIndex1, "lPRequestNo",		 	_LPIssueDeskTransVO.getStrBSReqNo(), 2);
            dao.setProcInValue(procIndex1, "strRasingStoreId", 		_LPIssueDeskTransVO.getStrStoreId(), 3);
            dao.setProcInValue(procIndex1, "hosp_code", 			_LPIssueDeskTransVO.getStrHospitalCode(), 4);
            dao.setProcInValue(procIndex1, "strRequestNo", 			_LPIssueDeskTransVO.getStrLpRequestNo(), 5);    // hnum_dossier_req_id
            dao.setProcOutValue(procIndex1, "err", 					1, 6);
            dao.setProcOutValue(procIndex1, "resultset", 			2, 7);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            _LPIssueDeskTransVO.setRequestItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    
    public static void getIssueItemDetailForReturn(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_dossier_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
            //System.out.println(String.valueOf(_LPIssueDeskTransVO.getStrIssueNo()) + " " + _LPIssueDeskTransVO.getStrIssueStoreId() + " " + _LPIssueDeskTransVO.getStrHospitalCode());
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", "6", 1);
            dao.setProcInValue(procIndex1, "issue_No", String.valueOf(_LPIssueDeskTransVO.getStrIssueNo()) + "@" + _LPIssueDeskTransVO.getStrReturnReqNo(), 4);
            dao.setProcInValue(procIndex1, "store_id", _LPIssueDeskTransVO.getStrIssueStoreId(), 2);
            dao.setProcInValue(procIndex1, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 3);
            dao.setProcOutValue(procIndex1, "err", 1, 5);
            dao.setProcOutValue(procIndex1, "resultset", 2, 6);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            _LPIssueDeskTransVO.setIssuedItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssuedItemDtl(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_dossier_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
        
            //System.out.println(String.valueOf(_LPIssueDeskTransVO.getStrIssueNo()) + " " + _LPIssueDeskTransVO.getStrIssueStoreId() + " " + _LPIssueDeskTransVO.getStrHospitalCode());
            
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", "5", 1);
            dao.setProcInValue(procIndex1, "issue_No", String.valueOf(_LPIssueDeskTransVO.getStrIssueNo()) + "@" + _LPIssueDeskTransVO.getStrReturnReqNo(), 4);
            dao.setProcInValue(procIndex1, "store_id", _LPIssueDeskTransVO.getStrIssueStoreId(), 2);
            dao.setProcInValue(procIndex1, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 3);
            dao.setProcOutValue(procIndex1, "err", 1, 5);
            dao.setProcOutValue(procIndex1, "resultset", 2, 6);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            _LPIssueDeskTransVO.setIssuedItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    
    
    public static void getIssuedItemDtlview(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        try 
        {
        	
        	
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
            System.out.println(String.valueOf(_LPIssueDeskTransVO.getStrIssueNo()) + " " + _LPIssueDeskTransVO.getStrIssueStoreId() + " " + _LPIssueDeskTransVO.getStrHospitalCode());
            procIndex1 = dao.setProcedure(proc_name1);
            if (!_LPIssueDeskTransVO.getStrRequestTypeId().equals("32")) 
            {
            	System.out.println("<<<--------------LPIssueDeskTransDAO . getIssuedItemDtlview--pkg_mms_view.Proc_patemp_issue_item_dtl [ Mode - 3 ] ---------->>>");
                dao.setProcInValue(procIndex1, "modval", "3", 1);
            }
            else 
            {
            	System.out.println("<<<--------------LPIssueDeskTransDAO . getIssuedItemDtlview--pkg_mms_view.Proc_patemp_issue_item_dtl [ Mode - 4 ] ---------->>>");
                dao.setProcInValue(procIndex1, "modval", "4", 1);
            }
            dao.setProcInValue(procIndex1, "issue_No", _LPIssueDeskTransVO.getStrIssueNo(), 4);
            dao.setProcInValue(procIndex1, "store_id", _LPIssueDeskTransVO.getStrIssueStoreId(), 2);
            dao.setProcInValue(procIndex1, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 3);
            dao.setProcOutValue(procIndex1, "err", 1, 5);
            dao.setProcOutValue(procIndex1, "resultset", 2, 6);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            _LPIssueDeskTransVO.setIssuedItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getReturnUnitCombo(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        final String strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
        HisDAO dao = null;
        WebRowSet ws = null;
        int nProcIndex = 0;
        String strErr = "";
        try {
            dao = new HisDAO("mms", "ReturnFromTransDAO");
            nProcIndex = dao.setProcedure(strProcName);
            dao.setProcInValue(nProcIndex, "modeval", "1", 4);
            dao.setProcInValue(nProcIndex, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 1);
            dao.setProcInValue(nProcIndex, "unit_id", _LPIssueDeskTransVO.getStrBalanceQtUnitId(), 2);
            dao.setProcInValue(nProcIndex, "module_id", "", 3);
            dao.setProcOutValue(nProcIndex, "err", 1, 5);
            dao.setProcOutValue(nProcIndex, "resultset", 2, 6);
            dao.executeProcedureByPosition(nProcIndex);
            strErr = dao.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            ws = dao.getWebRowSet(nProcIndex, "resultset");
            if (!strErr.equals("")) {
                throw new Exception(strErr);
            }
            _LPIssueDeskTransVO.setUnitComboWs(ws);
        }
        catch (Exception e) {
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getReturnUnitCombo() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssueItemDtl(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");
            procIndex1 = dao.setProcedure(proc_name1);
            if (_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1")) {
                dao.setProcInValue(procIndex1, "modval", "1", 1);
            }
            else {
                dao.setProcInValue(procIndex1, "modval", "2", 1);
            }
            dao.setProcInValue(procIndex1, "strId", 		_LPIssueDeskTransVO.getStrStoreId(), 2);
            dao.setProcInValue(procIndex1, "lPRequestNo", 	_LPIssueDeskTransVO.getStrLpRequestNo(), 3);      // hnum_dossier_req_id
            dao.setProcInValue(procIndex1, "hosp_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 4);
            dao.setProcInValue(procIndex1, "poNo", 			_LPIssueDeskTransVO.getStrPoNo(), 5);
            dao.setProcInValue(procIndex1, "poStoreId", 	_LPIssueDeskTransVO.getStrPoStoreId(), 6);
            dao.setProcOutValue(procIndex1, "err", 1, 7);
            dao.setProcOutValue(procIndex1, "resultset", 2, 8);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
            //System.out.println("ws.size()" + ws.size());
            _LPIssueDeskTransVO.setIssueItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssueItemDtl_new(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String err = "";
        final String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", "1", 1);
            dao.setProcInValue(procIndex1, "strId", _LPIssueDeskTransVO.getStrStoreId(), 2);
            dao.setProcInValue(procIndex1, "lPRequestNo", _LPIssueDeskTransVO.getStrBSReqNo(), 3);
            dao.setProcInValue(procIndex1, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 4);
            dao.setProcInValue(procIndex1, "poNo", _LPIssueDeskTransVO.getStrPoNo(), 5);
            dao.setProcInValue(procIndex1, "poStoreId", _LPIssueDeskTransVO.getStrPoStoreId(), 6);
            dao.setProcOutValue(procIndex1, "err", 1, 7);
            dao.setProcOutValue(procIndex1, "resultset", 2, 8);
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
            if (err == null) {
                err = "";
            }
            if (!err.equals("")) {
                throw new Exception(err);
            }
            ws = dao.getWebRowSet(procIndex1, "resultset");
           // System.out.println("ws.size()--" + ws.size());
            _LPIssueDeskTransVO.setIssueItemDtlWS(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> " + e.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void insertData(final LPIssueDeskTransVO _LPIssueDeskTransVO) 
    {
    	
    	
        String proc_name1 = "{call pkg_dossier_dml.Dml_hstt_patemp_issue_item_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
        
        HisDAO dao = null;
        int procIndex1 = 0;
        int procIndex2 = 0;
        int procIndex3 = 0;
        int length = 0;
        String[] temp = null;
        String strItemBrandId = "";
        String strItemId = "";
        String strRate = "";
        String strRateUnitId = "";
        String strGroupId = "";
        String strSubGroupId = "";
        String strBatchSlNo = "";
        final String strExpiryDate = "";
        String strIssueQty = "";
        String strStoreId = "";
        String strIssueNo = "";
        String hosp_code = "";
        String strItemSlNo = "";
        String strStockStatus = "";
        final String strManuFactDate = "";
        String strConsumableFlag = "1";
        String strRemarks = "";
        final String strItemCost = "";
        String strIssueUnitId = "0";
        String strBillTariff = "";
        String strBillBatch = "";
        String strBillRate = "";
        String stritemcat = "";
        String strBillQty = "";
        final String[] values = null;
        String bsReqNo = "0";
        int pIndex = 0;
        String p_name = "";
        String p_name2 = "";
        int nProcIndex = 0;
        WebRowSet ws = null;
        String strErr = "";
        String cat = "";
        double totcost = 0.0;
        try 
        {
            final MmsConfigUtil mcu = new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
            length = _LPIssueDeskTransVO.getStrItemParamValue().length;
            
            
            System.out.println("------------- LPIssueDeskTransDAO.insertData -----------------");
            
            
            final int funcIndex = dao.setFunction("{? = call MMS_MST.generate_dossier_issueno(?,?,?,?)}");
            

			/*
			 * 97 - Dossier Req No
			 * 99 - Dossier Return
			 * 98 - Dossier Issue
			 * */
            
            dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,"98");
			dao.setFuncInValue(funcIndex, 5,"10");
			
            dao.setFuncOutValue(funcIndex, 1);
            dao.executeFunction(funcIndex);
            strIssueNo = dao.getFuncString(funcIndex);
            
            System.out.println("strIssueNo -----------------"+strIssueNo);
            
            temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@', '#').split("#");
            strIssueUnitId = temp[3];
            strRateUnitId = temp[3];
            strIssueQty = temp[2];
            if (length != 0) 
            {
                for (int i = 0; i < length; ++i) 
                {
                    temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
                    strItemBrandId = temp[1];
                    strItemId = temp[0];
                    strRate = temp[6];
                    cat = strItemBrandId.substring(0, 2);
                    strGroupId = "";
                    strSubGroupId = "";
                    strBatchSlNo = temp[5];
                    strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
                    strStoreId = _LPIssueDeskTransVO.getStrStoreId();
                    hosp_code = _LPIssueDeskTransVO.getStrHospitalCode();
                    strItemSlNo = "0";
                    strStockStatus = "10";
                    strConsumableFlag = "1";
                    strRemarks = _LPIssueDeskTransVO.getStrRemarks();
                    strIssueUnitId = temp[3];
                    stritemcat = temp[7];
                    if (Double.parseDouble(_LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0]) > 0.0) 
                    {
                    	String strProcName5 = "{call pkg_mms_view.proc_stock_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
                    	
                    	System.out.println("strStoreId-----------------"+strStoreId);
                    	System.out.println("strItemBrandId.substring(0, 2)-----------------"+strItemBrandId.substring(0, 2));
                    	System.out.println("strItemId-----------------"+strItemId);
                    	System.out.println("strItemBrandId-------------"+strItemBrandId);
                    	System.out.println("HospitalCode----------------"+_LPIssueDeskTransVO.getStrHospitalCode());
                    	
                    	
                    	
                        nProcIndex = dao.setProcedure(strProcName5);
                        dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
                        dao.setProcInValue(nProcIndex, "store_id", 			strStoreId, 2);
                        dao.setProcInValue(nProcIndex, "catcode", 			strItemBrandId.substring(0, 2), 3);
                        dao.setProcInValue(nProcIndex, "item_id", 			strItemId, 4);
                        dao.setProcInValue(nProcIndex, "itembrand_id", 		strItemBrandId, 5);
                        dao.setProcInValue(nProcIndex, "batch_no", 			"0", 6);
                        dao.setProcInValue(nProcIndex, "stock_status", 		"10", 7);
                        dao.setProcInValue(nProcIndex, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 8);
                        dao.setProcInValue(nProcIndex, "itemslno", 			"0", 9);
                        dao.setProcInValue(nProcIndex, "reservedstockflag", "0", 10);
                        dao.setProcInValue(nProcIndex, "blockedqtyflag", 	"0", 11);
                        dao.setProcOutValue(nProcIndex, "err", 				1, 12);
                        dao.setProcOutValue(nProcIndex, "resultset", 		2, 13);
                        dao.executeProcedureByPosition(nProcIndex);
                        strErr = dao.getString(nProcIndex, "err");
                        if (strErr == null) {
                            strErr = "";
                        }
                        ws = dao.getWebRowSet(nProcIndex, "resultset");
                        System.out.println("STOCK_DTL_SIZE-------" + ws.size());
                        float addQty = 0.0f;
                        float issueqty = Float.parseFloat(strIssueQty);
                        if (ws.size() > 0 && ws != null) 
                        {
                            while (ws.next() && issueqty > 0.0) 
                            {
                                System.out.println("IN_HAND_QTY-["+strItemBrandId+"]-------" + ws.getString(20));
                                if (issueqty > Float.parseFloat(ws.getString(20))) 
                                {
                                    addQty = Float.parseFloat(ws.getString(20));
                                }
                                else 
                                {
                                    addQty = issueqty;
                                    System.out.println("strIssueQty" + issueqty);
                                }
                                issueqty -= addQty;
                                if (strBillTariff != null && strBillTariff != "") 
                                {
                                    strBillTariff = String.valueOf(strBillTariff) + "^" + strItemBrandId;
                                }
                                else {
                                    strBillTariff = strItemBrandId;
                                }
                                if (strBillRate != null && strBillRate != "") 
                                {
                                    strBillRate = String.valueOf(strBillRate) + "^" + ws.getString(38);
                                }
                                else {
                                    strBillRate = ws.getString(38);
                                }
                                if (strBillQty != null && strBillQty != "") 
                                {
                                    strBillQty = String.valueOf(strBillQty) + "^" + String.valueOf(addQty);
                                }
                                else {
                                    strBillQty = String.valueOf(addQty);
                                }
                                if (strBillBatch != null && strBillBatch != "") 
                                {
                                    strBillBatch = String.valueOf(strBillBatch) + "^" + ws.getString(15);
                                }
                                else 
                                {
                                    strBillBatch = ws.getString(15);
                                }
                                System.out.println("strBillTariff----------" + strBillTariff);
                                System.out.println("strBillRate------------" + strBillRate);
                                System.out.println("strBillQty-------------" + strBillQty);
                                System.out.println("strBillBatch-----------" + strBillBatch);
                                totcost += Double.parseDouble(strRate) * addQty;
                                
                               
                                
                                procIndex1 = dao.setProcedure(proc_name1);
                                if (_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1")) 
                                {
                                	System.out.println("------------pkg_dossier_dml.Dml_hstt_patemp_issue_item_dtl [ Mode - 1] - INSERT INTO sstt_patemp_issue_item_dtl -----------------");
                                    dao.setProcInValue(procIndex1, "modval", "1", 1);
                                }
                                else 
                                {
                                	System.out.println("------------pkg_dossier_dml.Dml_hstt_patemp_issue_item_dtl [ Mode - 3] - INSERT INTO sstt_patemp_issue_item_dtl -----------------");
                                    dao.setProcInValue(procIndex1, "modval", "3", 1);
                                }
                                dao.setProcInValue(procIndex1, "strItemBrandId", 	strItemBrandId, 2);
                                dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3);
                                dao.setProcInValue(procIndex1, "strRate", 			strRate, 4);
                                dao.setProcInValue(procIndex1, "strRateUnitId", 	strRateUnitId, 5);
                                dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6);
                                dao.setProcInValue(procIndex1, "strSubGroupId", 	strSubGroupId, 7);
                                dao.setProcInValue(procIndex1, "strBatchSlNo", 		ws.getString(15), 8);
                                dao.setProcInValue(procIndex1, "strExpiryDate", 	strExpiryDate.trim(), 9);
                                dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty), 10);
                                dao.setProcInValue(procIndex1, "strIssueUnitId", 	strIssueUnitId, 11);
                                dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12);
                                dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13);
                                dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14);
                                dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo, 15);
                                dao.setProcInValue(procIndex1, "strStockStatus", 	strStockStatus, 16);
                                dao.setProcInValue(procIndex1, "strManuFactDate", 	strManuFactDate.trim(), 17);
                                dao.setProcInValue(procIndex1, "strConsumableFlag", strConsumableFlag, 18);
                                dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19);
                                dao.setProcInValue(procIndex1, "strItemCost", 		Double.toString(Double.parseDouble(strRate) * addQty), 20);
                                dao.setProcInValue(procIndex1, "strRequestNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 21);
                                dao.setProcInValue(procIndex1, "strRasingStoreId", 	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
                                dao.setProcInValue(procIndex1, "strItemCatNo", 		stritemcat, 23);
                                dao.setProcInValue(procIndex1, "strSeatid", 		_LPIssueDeskTransVO.getStrSeatId(), 24);
                                dao.setProcInValue(procIndex1, "strDescription", 	_LPIssueDeskTransVO.getStrDescription(), 25);
                                dao.setProcInValue(procIndex1, "crno", 				_LPIssueDeskTransVO.getStrCrNo(), 26);
                                dao.setProcOutValue(procIndex1, "err", 				1, 27);
                                dao.execute(procIndex1, 1);
                            }
                        }
                    }
                }
            }
            if (_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1") && mcu.getStrBillingIntegration().equals("1") && !strBillTariff.equals("") && strBillTariff != null) {
            	
            	System.out.println("------------bill_interface.dml_online_billreq_drugs - INSERT INTO sstt_patemp_issue_item_dtl -----------------");
            	System.out.println("gnum_dept_code" + _LPIssueDeskTransVO.getStrDeptCode());
                System.out.println("gnum_treatment_cat" + _LPIssueDeskTransVO.getStrTreatmentCat());
                System.out.println("hrgnum_episode_code" + _LPIssueDeskTransVO.getStrEpisodeCode());
                System.out.println("hrgnum_puk" + _LPIssueDeskTransVO.getStrCrNo());
                System.out.println("strIssueNo=============<>>>>>>>" + strIssueNo + "#2#" + ((_LPIssueDeskTransVO.getStrDossierShortName() == null) ? "0" : _LPIssueDeskTransVO.getStrDossierShortName()));
                System.out.println("gnum_seatid" + _LPIssueDeskTransVO.getStrSeatId());
                System.out.println("hosp_code" + _LPIssueDeskTransVO.getStrHospitalCode());
                System.out.println("ward_code" + _LPIssueDeskTransVO.getStrWardCode());
                System.out.println("admno" + _LPIssueDeskTransVO.getStrAdmissionNo());
                System.out.println("visitno" + _LPIssueDeskTransVO.getStrVisitNo());
                System.out.println("strBillRate------" + strBillRate);
                
                
                
                final String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
                final int procIndex4 = dao.setProcedure(proc_name2);
                dao.setProcInValue(procIndex4, "modval", "1", 1);
                dao.setProcInValue(procIndex4, "gnum_dept_code", _LPIssueDeskTransVO.getStrDeptCode(), 2);
                
                dao.setProcInValue(procIndex4, "sblnum_chargetype_id", "2", 3);
                dao.setProcInValue(procIndex4, "sblnum_service_id", "5", 4);                
                dao.setProcInValue(procIndex4, "gstr_req_no", String.valueOf(strIssueNo) + "#2#" + ((_LPIssueDeskTransVO.getStrDossierShortName() == null) ? "0" : _LPIssueDeskTransVO.getStrDossierShortName()), 5);
                dao.setProcInValue(procIndex4, "gnum_treatment_cat", _LPIssueDeskTransVO.getStrTreatmentCat(), 6);               
                dao.setProcInValue(procIndex4, "hrgnum_episode_code", _LPIssueDeskTransVO.getStrEpisodeCode(), 7);               
                dao.setProcInValue(procIndex4, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(), 8);                
                dao.setProcInValue(procIndex4, "hblnum_pat_lfaccount_no", "0", 9);
                dao.setProcInValue(procIndex4, "gstr_tariff", strBillTariff, 10);
                dao.setProcInValue(procIndex4, "gstr_tariff_batch", strBillBatch, 11);
                dao.setProcInValue(procIndex4, "gstr_tariff_rates", strBillRate, 12);
                dao.setProcInValue(procIndex4, "gstr_reqqty", strBillQty, 13);
                dao.setProcInValue(procIndex4, "hblstr_patient_name", "", 14);
                dao.setProcInValue(procIndex4, "hblstr_pat_address", "", 15);
                dao.setProcInValue(procIndex4, "hblstr_contact_no", "", 16);
                dao.setProcInValue(procIndex4, "age", "1", 17);
                dao.setProcInValue(procIndex4, "ageunit", "1", 18);
                dao.setProcInValue(procIndex4, "gender", "1", 19);
                dao.setProcInValue(procIndex4, "refdoctor", "1", 20);
                dao.setProcInValue(procIndex4, "refdoccontactno", "1", 21);
                dao.setProcInValue(procIndex4, "gnum_seatid", _LPIssueDeskTransVO.getStrSeatId(), 22);
               
                dao.setProcInValue(procIndex4, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 23);
               
                dao.setProcInValue(procIndex4, "ward_code", _LPIssueDeskTransVO.getStrWardCode(), 24);
               
                dao.setProcInValue(procIndex4, "admno", _LPIssueDeskTransVO.getStrAdmissionNo(), 25);
                
                dao.setProcInValue(procIndex4, "visitno", _LPIssueDeskTransVO.getStrVisitNo(), 26);
               
                dao.setProcOutValue(procIndex4, "err", 1, 27);
               
                dao.execute(procIndex4, 1);
            }
            if (_LPIssueDeskTransVO.getStrBSReqNo().equals("0")) 
            {
                if (_LPIssueDeskTransVO.getStrBSIndent().equals("1")) 
                {
                    final int itmln = _LPIssueDeskTransVO.getStrBSQuantity().length;
                    final RequestForLPPatientVO vo = new RequestForLPPatientVO();
                    vo.setStrStoreId(_LPIssueDeskTransVO.getStrStoreId());
                    vo.setStrHospitalCode(_LPIssueDeskTransVO.getStrHospitalCode());
                    vo.setStrReqType("86");
                    vo.setStrToStoreCombo(_LPIssueDeskTransVO.getStrStoreId());
                    vo.setStrItemCategoryNo(_LPIssueDeskTransVO.getStrItemCategNo());
                    vo.setStrUrgentFlg(_LPIssueDeskTransVO.getStrUrgentFlg());
                    vo.setStrFinancialEndYear(_LPIssueDeskTransVO.getStrFinEndDate());
                    vo.setStrFinancialStartYear(_LPIssueDeskTransVO.getStrFinStartDate());
                    vo.setStrRemarks(_LPIssueDeskTransVO.getStrRemarks());
                    vo.setStrSeatId(_LPIssueDeskTransVO.getStrSeatId());
                    vo.setStrGrantType("0");
                    vo.setStrCrNo(_LPIssueDeskTransVO.getStrCrNo());
                    vo.setStrEmpNo("0");
                    vo.setStrAdmnNo(_LPIssueDeskTransVO.getStrAdmissionNo());
                    vo.setStrApproxAmt("0");
                    final List<String> tArr = new ArrayList<String>();
                    final List<String> reqQty = new ArrayList<String>();
                    final List<String> reqUnit = new ArrayList<String>();
                    for (int j = 0; j < itmln; ++j) {
                        temp = _LPIssueDeskTransVO.getStrItemParamValue()[j].replace('@', '#').split("#");
                        if (!_LPIssueDeskTransVO.getStrBSQuantity()[j].equals("0")) {
                            tArr.add("0#0#" + temp[0] + "^" + temp[1] + "^0^0^0^0^0^" + temp[4] + "^" + temp[3] + "^" + temp[6] + "^" + temp[3] + "^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0");
                            reqQty.add(_LPIssueDeskTransVO.getStrBSQuantity()[j]);
                            reqUnit.add(temp[3]);
                        }
                    }
                    final String[] arr = tArr.toArray(new String[tArr.size()]);
                    final String[] arr2 = reqQty.toArray(new String[reqQty.size()]);
                    final String[] arr3 = reqUnit.toArray(new String[reqUnit.size()]);
                    vo.setItemParamValue(arr);
                    vo.setStrReqQty(arr2);
                    vo.setStrUnitName(arr3);
                    if (vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals("")) {
                        bsReqNo = vo.getStrBSReqNo();
                    }
                    else {
                        bsReqNo = "0";
                    }
                    _LPIssueDeskTransVO.setStrBSReqNo(bsReqNo);
                    System.out.println("------------pkg_mms_dml.Dml_update_sstt_indent_dtl - UPDATE sstt_indent_dtl -----------------");
                    
                    p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
                    pIndex = dao.setProcedure(p_name);
                    dao.setProcInValue(pIndex, "modval", "1", 1);
                    dao.setProcInValue(pIndex, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 2);
                    dao.setProcInValue(pIndex, "reqNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 3);
                    dao.setProcInValue(pIndex, "bsNo", bsReqNo, 4);
                    dao.setProcInValue(pIndex, "raising_store", _LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
                    dao.setProcOutValue(pIndex, "err", 1, 6);
                    dao.executeProcedureByPosition(pIndex);
                }
                else 
                {
                	System.out.println("------------pkg_mms_dml.Dml_update_sstt_indent_dtl - UPDATE sstt_indent_dtl -----------------");
                	 
                    p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
                    pIndex = dao.setProcedure(p_name);
                    dao.setProcInValue(pIndex, "modval", 		"1", 1);
                    dao.setProcInValue(pIndex, "hosp_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 2);
                    dao.setProcInValue(pIndex, "reqNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 3);     //  hnum_dossier_req_id
                    dao.setProcInValue(pIndex, "bsNo", 			"0", 4);
                    dao.setProcInValue(pIndex, "raising_store", _LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
                    dao.setProcOutValue(pIndex, "err", 1, 6);
                    dao.execute(pIndex, 1);
                }
            }
            if (length != 0) 
            {
                for (int i = 0; i < length; ++i) 
                {
                    strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
                    if (!strIssueQty.equals("0.00") && !strIssueQty.equals("0")) 
                    {
                        i = length;
                        proc_name1 = "";
                        System.out.println("------------pkg_dossier_dml.Dml_hstt_patemp_issue_dtl [ Mode - 1] - INSERT INTO sstt_patemp_issue_dtl -----------------");
                        
                        proc_name1 = "{call pkg_dossier_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
                        procIndex2 = dao.setProcedure(proc_name1);
                        dao.setProcInValue(procIndex2, "modval", 			"1", 1);
                        dao.setProcInValue(procIndex2, "strIssueNo", 		strIssueNo, 2);
                        dao.setProcInValue(procIndex2, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 3);
                        dao.setProcInValue(procIndex2, "strStoreId", 		_LPIssueDeskTransVO.getStrStoreId(), 4);
                        dao.setProcInValue(procIndex2, "strFinalCost", 		Double.toString(totcost), 6);
                        dao.setProcInValue(procIndex2, "strRequestNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 7);
                        dao.setProcInValue(procIndex2, "strRequestDate", 	_LPIssueDeskTransVO.getStrFinStartDate(), 8);
                        dao.setProcInValue(procIndex2, "strCrNo", 			_LPIssueDeskTransVO.getStrCrNo(), 9);
                        dao.setProcInValue(procIndex2, "strReqTypeId", 		_LPIssueDeskTransVO.getStrRequestTypeId(), 10);
                        dao.setProcInValue(procIndex2, "strAdmNo", 			_LPIssueDeskTransVO.getStrAdmissionNo(), 11);
                        dao.setProcInValue(procIndex2, "strEmpNo", 			_LPIssueDeskTransVO.getStrEmpNo(), 12);
                        dao.setProcInValue(procIndex2, "strItemCatNo", 		cat, 13);
                        dao.setProcInValue(procIndex2, "strFinStartDate", 	_LPIssueDeskTransVO.getStrFinStartDate(), 14);
                        dao.setProcInValue(procIndex2, "strFinEndDate", 	_LPIssueDeskTransVO.getStrFinEndDate(), 15);
                        dao.setProcInValue(procIndex2, "strSeatId", 		_LPIssueDeskTransVO.getStrSeatId(), 16);
                        dao.setProcInValue(procIndex2, "strRaisingStoreId", _LPIssueDeskTransVO.getStrRaisingStoreId(), 17);
                        dao.setProcInValue(procIndex2, "strIssueQty", 		strIssueQty, 18);
                        dao.setProcInValue(procIndex2, "strIssueUnitId", 	strIssueUnitId, 19);
                        dao.setProcInValue(procIndex2, "strRemarks", 		strRemarks, 5);
                        dao.setProcInValue(procIndex2, "strDeptCode", 		_LPIssueDeskTransVO.getStrDeptCode(), 20);
                        dao.setProcInValue(procIndex2, "strDeptUnitCode", 	_LPIssueDeskTransVO.getStrDeptUnitCode(), 21);
                        dao.setProcInValue(procIndex2, "strWardCode", 		_LPIssueDeskTransVO.getStrWardCode(), 22);
                        dao.setProcInValue(procIndex2, "strEpisodeCode", 	_LPIssueDeskTransVO.getStrEpisodeCode(), 23);
                        dao.setProcInValue(procIndex2, "strVisitNo", 		_LPIssueDeskTransVO.getStrVisitNo(), 24);
                        dao.setProcInValue(procIndex2, "strVisitType", 		_LPIssueDeskTransVO.getStrVisitType(), 25);
                        dao.setProcInValue(procIndex2, "strRecieveBy", 		_LPIssueDeskTransVO.getStrReceivedby(), 26);
                        dao.setProcInValue(procIndex2, "strOrderBy", 		"", 27);
                        dao.setProcInValue(procIndex2, "strOrderDate", 		"", 28);
                        dao.setProcInValue(procIndex2, "days", 				"", 29);
                        dao.setProcInValue(procIndex2, "strPoNo", 			_LPIssueDeskTransVO.getStrPoNo(), 30);
                        dao.setProcInValue(procIndex2, "strPoStoreId", 		_LPIssueDeskTransVO.getStrPoStoreId(), 31);                  
                        dao.setProcInValue(procIndex2, "strBsReqNo", 		bsReqNo, 32);
                        dao.setProcOutValue(procIndex2, "err", 				1, 33);
                        dao.execute(procIndex2, 1);
                        proc_name1 = "";
                        System.out.println("------------pkg_mms_dml.Dml_issue_dtls [ Mode - 2] - INSERT INTO sstt_issue_dtl , DELETE sstt_lp_recieve_dtl -----------------");
                        proc_name1 = "{call pkg_mms_dml.Dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
                        procIndex3 = dao.setProcedure(proc_name1);
                        dao.setProcInValue(procIndex3, "modeval", 			"2", 1);
                        dao.setProcInValue(procIndex3, "issuing_store_id", 	_LPIssueDeskTransVO.getStrStoreId(), 2);
                        dao.setProcInValue(procIndex3, "issueNo", 			strIssueNo, 3);
                        dao.setProcInValue(procIndex3, "hospital_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 4);
                        dao.setProcInValue(procIndex3, "category_No", 		strItemBrandId.substring(0, 2), 5);
                        dao.setProcInValue(procIndex3, "indent_No", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 6);
                        dao.setProcInValue(procIndex3, "reqType_id",		_LPIssueDeskTransVO.getStrRequestTypeId(), 7);
                        dao.setProcInValue(procIndex3, "indent_Date", 		_LPIssueDeskTransVO.getStrRequestDate(), 8);
                        dao.setProcInValue(procIndex3, "raising_store_id", 	_LPIssueDeskTransVO.getStrRaisingStoreId(), 9);
                        dao.setProcInValue(procIndex3, "net_cost", 			Double.toString(totcost), 11);
                        dao.setProcInValue(procIndex3, "strCrNo", 			_LPIssueDeskTransVO.getStrCrNo(), 16);
                        dao.setProcInValue(procIndex3, "strAmNo", 			_LPIssueDeskTransVO.getStrAdmissionNo(), 17);
                        dao.setProcInValue(procIndex3, "strEmpNo", 			_LPIssueDeskTransVO.getStrEmpNo(), 18);
                        dao.setProcInValue(procIndex3, "fin_start_date", 	_LPIssueDeskTransVO.getStrFinStartDate(), 12);
                        dao.setProcInValue(procIndex3, "fin_end_date", 		_LPIssueDeskTransVO.getStrFinEndDate(), 13);
                        dao.setProcInValue(procIndex3, "seatId", 			_LPIssueDeskTransVO.getStrSeatId(), 15);
                        dao.setProcInValue(procIndex3, "remarks", 			strRemarks, 14);
                        dao.setProcInValue(procIndex3, "receivedBy", 		_LPIssueDeskTransVO.getStrReceivedby(), 10);
                        dao.setProcInValue(procIndex3, "strPoNo", 			_LPIssueDeskTransVO.getStrPoNo(), 19);
                        dao.setProcInValue(procIndex3, "strPoStoreId", 		_LPIssueDeskTransVO.getStrPoStoreId(), 20);
                        dao.setProcInValue(procIndex3, "strBsReqNo", 		bsReqNo, 21);
                        dao.setProcOutValue(procIndex3, "err", 				1, 22);
                        dao.execute(procIndex3, 1);
                    }
                }
            }
            System.out.println("------------pkg_dossier_dml.dml_update_dossier_req_dtl [ Mode - 1] -  UPDATE hgdt_dossier_req_dtl , hnum_dossier_status = 2 -----------------");
            p_name2 = "{call pkg_dossier_dml.dml_update_dossier_req_dtl(?,?,?,?,? ,?)}";
            final int pIndex2 = dao.setProcedure(p_name2);
            dao.setProcInValue(pIndex2, "modval", "1", 1);
            dao.setProcInValue(pIndex2, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 2);
            dao.setProcInValue(pIndex2, "reqNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 3);
            dao.setProcInValue(pIndex2, "bsNo", _LPIssueDeskTransVO.getStrAdmissionNo(), 4);
            dao.setProcInValue(pIndex2, "raising_store", _LPIssueDeskTransVO.getStrStoreId(), 5);
            dao.setProcOutValue(pIndex2, "err", 1, 6);
            dao.execute(pIndex2, 1);
            synchronized (dao) {
                dao.fire();
            }
            // monitorexit(dao)
            _LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
            _LPIssueDeskTransVO.setStrBSReqNo(strIssueNo);
        }
        catch (Exception _err) {
            _err.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> " + _err.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
        }
    }
    
    public static void insertRetData(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        String proc_name1 = "{call pkg_mms_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        HisDAO dao = null;
        int procIndex1 = 0;
        int length = 0;
        String[] temp = null;
        String strItemBrandId = "";
        String strItemId = "";
        String strRate = "";
        String strRateUnitId = "";
        String strGroupId = "";
        String strSubGroupId = "";
        String strBatchSlNo = "";
        String strExpiryDate = "";
        String strReturnNo = "";
        String strItemSlNo = "";
        String strStockStatus = "";
        String strManuFactDate = "";
        String[] temp2 = null;
        String strIssueUnitId = "0";
        String strBillTariff = "";
        String strBillBatch = "";
        String strBillRate = "";
        String strBillQty = "";
        final String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
        
       
        try 
        {
        	System.out.println("------------- LPIssueDeskTransDAO.insertRetData -----------------");
        	
        	
            final MmsConfigUtil mcu = new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());
            dao = new HisDAO("mms", "LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
            
            /*
			 * 97 - Dossier Req No
			 * 99 - Dossier Return Issue No
			 * 98 - Dossier Issue
			 * */
            
            final int funcIndex = dao.setFunction("{? = call MMS_MST.generate_dossier_issueno(?,?,?,?)}");
            

			/*
			 * 97 - Dossier Req No
			 * 99 - Dossier Return Issue No
			 * 98 - Dossier Issue
			 * */
            
            dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,"99");
			dao.setFuncInValue(funcIndex, 5,"10");		
            dao.setFuncOutValue(funcIndex, 1);
            dao.executeFunction(funcIndex);
            strReturnNo = dao.getFuncString(funcIndex);
            _LPIssueDeskTransVO.setStrReturnNo(strReturnNo);
            
            System.out.println("------------- strReturnNo -----------------"+strReturnNo);
            System.out.println("vo.getStrDossierReturnReqNo()----- Dossier  Return Request No---------"+_LPIssueDeskTransVO.getStrDossierReturnReqNo());
            
            
            System.out.println("------------pkg_dossier_Dml.dml_patemp_return_dtl [ Mode - 1] -  INSERT INTO hstt_patemp_return_dtl , update hgdt_dossier_return_dtl set hnum_dossier_status=4 , UPDATE sstt_patemp_issue_dtl Is_valid = 0 -----------------");
            proc_name1 = "";
            proc_name1 = "{call pkg_dossier_Dml.dml_patemp_return_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modval", 			"1", 1);
            dao.setProcInValue(procIndex1, "store_id", 			_LPIssueDeskTransVO.getStrStoreId(), 2);
            dao.setProcInValue(procIndex1, "return_no", 		strReturnNo, 3);
            dao.setProcInValue(procIndex1, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 4);
            dao.setProcInValue(procIndex1, "issue_no", 			_LPIssueDeskTransVO.getStrIssueNo(), 5);
            dao.setProcInValue(procIndex1, "return_date", 		"", 6);
            dao.setProcInValue(procIndex1, "reqtype_id",		_LPIssueDeskTransVO.getStrRequestTypeId(), 7);
            dao.setProcInValue(procIndex1, "pukno", 			_LPIssueDeskTransVO.getStrCrNo(), 8);
            dao.setProcInValue(procIndex1, "adm_no", 			_LPIssueDeskTransVO.getStrAdmissionNo(), 9);
            dao.setProcInValue(procIndex1, "issue_date", 		_LPIssueDeskTransVO.getStrIssueDate(), 10);
            dao.setProcInValue(procIndex1, "emp_no", 			_LPIssueDeskTransVO.getStrEmpNo(), 11);
            dao.setProcInValue(procIndex1, "item_cat_no", 		_LPIssueDeskTransVO.getStrItemCategNo(), 12);
            dao.setProcInValue(procIndex1, "return_netcost", 	  	_LPIssueDeskTransVO.getStrFinalCost(), 13);
            dao.setProcInValue(procIndex1, "financial_start_date", 	_LPIssueDeskTransVO.getStrFinStartDate(), 14);
            dao.setProcInValue(procIndex1, "financial_end_date", 	_LPIssueDeskTransVO.getStrFinEndDate(), 15);
            dao.setProcInValue(procIndex1, "recommended_by", 		_LPIssueDeskTransVO.getStrRecommendBy(), 16);
            dao.setProcInValue(procIndex1, "recommended_date", 		"", 17);
            dao.setProcInValue(procIndex1, "remarks", 				_LPIssueDeskTransVO.getStrRemarks(), 18);
            dao.setProcInValue(procIndex1, "entry_date", 			"", 19);
            dao.setProcInValue(procIndex1, "seatid",				 _LPIssueDeskTransVO.getStrSeatId(), 20);
            dao.setProcInValue(procIndex1, "isvalid", 				_LPIssueDeskTransVO.getStrDossierReturnReqNo(), 21);
            dao.setProcOutValue(procIndex1, "err", 1, 22);
            dao.execute(procIndex1, 1);
            proc_name1 = "";
            System.out.println("------------pkg_dossier_dml.dml_patemp_return_item_dtl [ Mode - 2] -  INSERT INTO hstt_patemp_return_item_dtl , update sstt_patemp_issue_item_dtl set hstnum_return_qty , hstnum_total_return_cost , pkg_mms_dml.dml_stock_update [ Mode - 1] -----------------");
            proc_name1 = "{call pkg_dossier_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@', '#').split("#");
            strIssueUnitId = temp[1];
            length = _LPIssueDeskTransVO.getStrItemParamValue().length;
            if (length != 0) {
                for (int i = 0; i < length; ++i) {
                    temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
                    strIssueUnitId = temp[1];
                    strItemBrandId = temp[3];
                    strItemId = temp[4];
                    strBatchSlNo = temp[5];
                    strItemSlNo = temp[6];
                    strStockStatus = temp[7];
                    strGroupId = temp[8];
                    strSubGroupId = temp[9];
                    strRate = temp[10];
                    temp2 = temp[11].replace('^', '#').split("#");
                    strRateUnitId = temp2[0];
                    strManuFactDate = temp[12];
                    strExpiryDate = temp[13];
                    final float getBalanaceQty = Float.parseFloat(_LPIssueDeskTransVO.getStrBalanceQty()[i]) - Float.parseFloat(_LPIssueDeskTransVO.getStrReturnQty()[i]);
                    temp = _LPIssueDeskTransVO.getStrUnit()[i].replace('^', '#').split("#");
                    if (_LPIssueDeskTransVO.getStrReturnQty()[i] != null && Float.parseFloat(_LPIssueDeskTransVO.getStrReturnQty()[i]) > 0.0 && Integer.parseInt(_LPIssueDeskTransVO.getStrReturnQty()[i]) > 0) 
                    {
                        if (strBillTariff != null && strBillTariff != "") 
                        {
                            strBillTariff = String.valueOf(strBillTariff) + "^" + strItemBrandId;
                        }
                        else 
                        {
                            strBillTariff = strItemBrandId;
                        }
                        if (strBillRate != null && strBillRate != "") 
                        {
                            strBillRate = String.valueOf(strBillRate) + "^" + strRate;
                        }
                        else 
                        {
                            strBillRate = strRate;
                        }
                        if (_LPIssueDeskTransVO.getStrPatientType().equals("1")) 
                        {
                            if (strBillQty != null && strBillQty != "") 
                            {
                                strBillQty = String.valueOf(strBillQty) + "^" + "-" + _LPIssueDeskTransVO.getStrReturnQty()[i];
                            }
                            else 
                            {
                                strBillQty = "-" + _LPIssueDeskTransVO.getStrReturnQty()[i];
                            }
                        }
                        else if (strBillQty != null && strBillQty != "") 
                        {
                            strBillQty = String.valueOf(strBillQty) + "^" + _LPIssueDeskTransVO.getStrReturnQty()[i];
                        }
                        else 
                        {
                            strBillQty = _LPIssueDeskTransVO.getStrReturnQty()[i];
                        }
                        if (strBillBatch != null && strBillBatch != "") 
                        {
                            strBillBatch = String.valueOf(strBillBatch) + "^" + strBatchSlNo;
                        }
                        else 
                        {
                            strBillBatch = strBatchSlNo;
                        }
                        System.out.println("strBillTariff:::::" + strBillTariff);
                        System.out.println("strBillRate:::::" + strBillRate);
                        System.out.println("strBillQty:::::" + strBillQty);
                        System.out.println("strBillBatch:::::" + strBillBatch);
                    }
                    procIndex1 = dao.setProcedure(proc_name1);
                    dao.setProcInValue(procIndex1, "modval", 			"2", 1);
                    dao.setProcInValue(procIndex1, "store_id", 			_LPIssueDeskTransVO.getStrStoreId(), 2);
                    dao.setProcInValue(procIndex1, "return_no", 		strReturnNo, 3);
                    dao.setProcInValue(procIndex1, "item_id", 			strItemId, 4);
                    dao.setProcInValue(procIndex1, "itembrand_id", 		strItemBrandId, 5);
                    dao.setProcInValue(procIndex1, "batch_sl_no", 		strBatchSlNo, 6);
                    dao.setProcInValue(procIndex1, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 7);
                    dao.setProcInValue(procIndex1, "return_date", 		"", 8);
                    dao.setProcInValue(procIndex1, "item_sl_no", 		strItemSlNo.trim(), 9);
                    dao.setProcInValue(procIndex1, "group_id", 			strGroupId, 10);
                    dao.setProcInValue(procIndex1, "inhand_qty", 		"0", 11);
                    dao.setProcInValue(procIndex1, "subgroup_id", 		strSubGroupId, 12);
                    dao.setProcInValue(procIndex1, "balance_qty", 		Float.toString(getBalanaceQty), 13);
                    dao.setProcInValue(procIndex1, "inhand_qty_unitid", "", 14);
                    dao.setProcInValue(procIndex1, "balanceqty_unitid", strIssueUnitId, 15);
                    dao.setProcInValue(procIndex1, "return_qty", 		_LPIssueDeskTransVO.getStrReturnQty()[i], 16);
                    dao.setProcInValue(procIndex1, "retqty_unitid", 	temp[0], 17);
                    dao.setProcInValue(procIndex1, "rate", 				strRate, 18);
                    dao.setProcInValue(procIndex1, "rate_unitid", 		strRateUnitId, 19);
                    dao.setProcInValue(procIndex1, "remarks", 			_LPIssueDeskTransVO.getStrRemarks(), 20);
                    dao.setProcInValue(procIndex1, "isvalid", 			"1", 21);
                    dao.setProcInValue(procIndex1, "cost", 				_LPIssueDeskTransVO.getItemCost()[i], 22);
                    dao.setProcInValue(procIndex1, "stock_status_code", strStockStatus, 23);
                    dao.setProcInValue(procIndex1, "issueNo", 			_LPIssueDeskTransVO.getStrIssueNo(), 24);
                    dao.setProcInValue(procIndex1, "strItemCategNo", 	strItemBrandId.substring(0, 2), 25);
                    dao.setProcInValue(procIndex1, "strDescription", 	_LPIssueDeskTransVO.getStrCrNo(), 26);
                    dao.setProcInValue(procIndex1, "strSeatid", 		_LPIssueDeskTransVO.getStrSeatId(), 27);
                    dao.setProcInValue(procIndex1, "expiryDate", 		strExpiryDate.trim(), 28);
                    dao.setProcInValue(procIndex1, "strManufactDate", 	strManuFactDate, 29);
                    dao.setProcInValue(procIndex1, "strPoNo", 			_LPIssueDeskTransVO.getStrPoNo(), 30);
                    dao.setProcOutValue(procIndex1, "err", 				1, 		31);
                    dao.execute(procIndex1, 1);
                }
            }
            if (mcu.getStrBillingIntegration().equals("1")) 
            {
                if (_LPIssueDeskTransVO.getStrPatientType().equals("1")) 
                {
                	 System.out.println("------------bill_interface.dml_online_billreq_drugs [ Mode - 1] -----------------");
                	 
                    final int procIndex2 = dao.setProcedure(proc_name2);
                    dao.setProcInValue(procIndex2, "modval", "1", 1);
                    dao.setProcInValue(procIndex2, "gnum_dept_code", _LPIssueDeskTransVO.getStrDeptCode(), 2);
                    dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
                    dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
                    dao.setProcInValue(procIndex2, "gstr_req_no", String.valueOf(strReturnNo) + "#2#" + _LPIssueDeskTransVO.getStrDossierShortName(), 5);
                    dao.setProcInValue(procIndex2, "gnum_treatment_cat", _LPIssueDeskTransVO.getStrTreatmentCat(), 6);
                    dao.setProcInValue(procIndex2, "hrgnum_episode_code", _LPIssueDeskTransVO.getStrEpisodeCode(), 7);
                    dao.setProcInValue(procIndex2, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(), 8);
                    dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
                    dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
                    dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);
                    dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);
                    dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
                    dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
                    dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
                    dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
                    dao.setProcInValue(procIndex2, "age", "1", 17);
                    dao.setProcInValue(procIndex2, "ageunit", "1", 18);
                    dao.setProcInValue(procIndex2, "gender", "1", 19);
                    dao.setProcInValue(procIndex2, "refdoctor", "1", 20);
                    dao.setProcInValue(procIndex2, "refdoccontactno", "1", 21);
                    dao.setProcInValue(procIndex2, "gnum_seatid", _LPIssueDeskTransVO.getStrSeatId(), 22);
                    dao.setProcInValue(procIndex2, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 23);
                    dao.setProcInValue(procIndex2, "ward_code", _LPIssueDeskTransVO.getStrWardCode(), 24);
                    dao.setProcInValue(procIndex2, "admno", _LPIssueDeskTransVO.getStrAdmissionNo(), 25);
                    dao.setProcInValue(procIndex2, "visitno", _LPIssueDeskTransVO.getStrVisitNo(), 26);
                    dao.setProcOutValue(procIndex2, "err", 1, 27);
                    dao.execute(procIndex2, 1);
                }
                else 
                {
                	 System.out.println("------------bill_interface.dml_online_billreq_refund [ Mode - 1] ------ REFUMD CASE -----------");
                	 
                    final String strProcName3 = "{call bill_interface.dml_online_billreq_refund(?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
                    final int nProcIndex3 = dao.setProcedure(strProcName3);
                    dao.setProcInValue(nProcIndex3, "modval", "1", 1);
                    dao.setProcInValue(nProcIndex3, "sblnum_chargetype_id", "1", 2);
                    dao.setProcInValue(nProcIndex3, "sblnum_service_id", "5", 3);
                    dao.setProcInValue(nProcIndex3, "gstr_req_no", _LPIssueDeskTransVO.getStrGstrReqNo(), 4);
                    dao.setProcInValue(nProcIndex3, "gnum_treatment_cat", "11", 5);
                    dao.setProcInValue(nProcIndex3, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(), 6);
                    dao.setProcInValue(nProcIndex3, "gstr_tariff", strBillTariff, 7);
                    dao.setProcInValue(nProcIndex3, "gstr_reqqty", strBillQty, 8);
                    dao.setProcInValue(nProcIndex3, "gnum_seatid", _LPIssueDeskTransVO.getStrSeatId(), 9);
                    dao.setProcInValue(nProcIndex3, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 10);
                    dao.setProcInValue(nProcIndex3, "admno", "0", 11);
                    dao.setProcInValue(nProcIndex3, "remarks", "Return From CR No :: " + _LPIssueDeskTransVO.getStrCrNo(), 12);
                    dao.setProcOutValue(nProcIndex3, "err", 1, 13);
                    dao.execute(nProcIndex3, 1);
                }
            }
            synchronized (dao) {
                dao.fire();
            }
        }
        catch (Exception _err) {
            _err.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> " + _err.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
        }
    }
    
    public static void getApprovedByCombo(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        final String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
        int nProcIndex = 0;
        String strErr = "";
        WebRowSet ws = null;
        HisDAO daoObj = null;
        try {
            daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
            nProcIndex = daoObj.setProcedure(strProcName);
            daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
            daoObj.setProcInValue(nProcIndex, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 3);
            daoObj.setProcInValue(nProcIndex, "seatId", _LPIssueDeskTransVO.getStrSeatId(), 4);
            daoObj.setProcInValue(nProcIndex, "deptunitcode", "0", 2);
            daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
            daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);
            daoObj.executeProcedureByPosition(nProcIndex);
            strErr = daoObj.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            ws = daoObj.getWebRowSet(nProcIndex, "resultset");
            if (strErr.equals("")) {
                _LPIssueDeskTransVO.setApprovedBy(ws);
            }
        }
        catch (Exception _err) {
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getApprovedByCombo() --> " + _err.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
        }
    }
    
    public static void getDeptName(final LPIssueDeskTransVO _LPIssueDeskTransVO) {
        HisDAO dao = null;
        int funcIndex = 0;
        String strDeptName = "";
        try {
            dao = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
            funcIndex = dao.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
            dao.setFuncInValue(funcIndex, 2, "3");
            dao.setFuncInValue(funcIndex, 3, _LPIssueDeskTransVO.getStrHospitalCode());
            dao.setFuncInValue(funcIndex, 4, _LPIssueDeskTransVO.getStrRaisingStoreId());
            dao.setFuncOutValue(funcIndex, 1);
            dao.executeFunction(funcIndex);
            strDeptName = dao.getFuncString(funcIndex);
            if (strDeptName != null && !strDeptName.equals("null")) {
                _LPIssueDeskTransVO.setStrDeptName(strDeptName);
            }
            else {
                _LPIssueDeskTransVO.setStrDeptName("-");
            }
        }
        catch (Exception _err) {
            _err.printStackTrace();
            _LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.getDeptName() --> " + _err.getMessage());
            _LPIssueDeskTransVO.setStrMsgType("1");
        }
    }
    
    public static void getPatientAccountDetails(final LPIssueDeskTransVO vo) {
        final String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
        int nProcIndex = 0;
        String strErr = "";
        WebRowSet ws = null;
        HisDAO daoObj = null;
        try {
            daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
            nProcIndex = daoObj.setProcedure(strProcName);
            daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
            daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
            daoObj.setProcInValue(nProcIndex, "cr_no", vo.getStrCrNo(), 3);
            daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
            daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);
            daoObj.executeProcedureByPosition(nProcIndex);
            strErr = daoObj.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            ws = daoObj.getWebRowSet(nProcIndex, "resultset");
            if (strErr.equals("")) {
                vo.setPatAccountDtl(ws);
            }
        }
        catch (Exception _err) {
            vo.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> " + _err.getMessage());
            vo.setStrMsgType("1");
        }
    }
    
    public static void getPatientDiagDetails(final LPIssueDeskTransVO vo) {
        WebRowSet wb = null;
        HisDAO daoObj = null;
        int nProcIndex = 0;
        String strErr = "";
        try {
            final String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";
            daoObj = new HisDAO("MMS Transactions", "LPIssueDeskTransDAO");
            nProcIndex = daoObj.setProcedure(strProcName);
            daoObj.setProcInValue(nProcIndex, "modval", "1", 1);
            daoObj.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 2);
            daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);
            daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
            daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);
            daoObj.executeProcedureByPosition(nProcIndex);
            strErr = daoObj.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            if (!strErr.equals("")) {
                throw new Exception(strErr);
            }
            wb = daoObj.getWebRowSet(nProcIndex, "resultset");
            vo.setDiagEmpWs(wb);
        }
        catch (Exception e) {
            vo.setStrMsgString("--> LPIssueDeskTransDAO.getPatientDiagDetails()-->" + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (daoObj != null) {
                daoObj.free();
            }
            daoObj = null;
        }
        if (daoObj != null) {
            daoObj.free();
        }
        daoObj = null;
    }
    
    public static void getSingleBatchItemDtl(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        WebRowSet ws = null;
        String strProcName = "";
        int nProcIndex = 0;
        String strErr = "";
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO");
            strProcName = "{call Pkg_Mms_View.proc_itemStock_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
            nProcIndex = dao.setProcedure(strProcName);
            dao.setProcInValue(nProcIndex, "modeval", "6");
            dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
            dao.setProcInValue(nProcIndex, "item_id", vo.getStrSingleItemDtl().split("\\^")[0]);
            dao.setProcInValue(nProcIndex, "itembrand_id", vo.getStrSingleItemDtl().split("\\^")[1]);
            dao.setProcInValue(nProcIndex, "store_id", vo.getStrSingleItemDtl().split("\\^")[3]);
            dao.setProcInValue(nProcIndex, "batch_no", vo.getStrSingleItemDtl().split("\\^")[2]);
            dao.setProcInValue(nProcIndex, "item_sl_no", "0");
            dao.setProcInValue(nProcIndex, "sl_no", "0");
            dao.setProcInValue(nProcIndex, "reserved_flag", "0");
            dao.setProcOutValue(nProcIndex, "err", 1);
            dao.setProcOutValue(nProcIndex, "resultset", 2);
            dao.executeProcedure(nProcIndex);
            strErr = dao.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            ws = dao.getWebRowSet(nProcIndex, "resultset");
            if (!strErr.equals("")) {
                throw new Exception(strErr);
            }
            vo.setStrSingleBatchDtlWs(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("LPIssueDeskTransDAO.getSingleBatchItemDtl() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getBrandDetails(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        WebRowSet ws = null;
        String strProcName = "";
        int nProcIndex = 0;
        String strErr = "";
        try {
            dao = new HisDAO("mms", "LPIssueDeskTransDAO");
            strProcName = "{call Pkg_Mms_View.proc_brand_list(?,?,?,?,? ,?)}";
            nProcIndex = dao.setProcedure(strProcName);
            dao.setProcInValue(nProcIndex, "modeval", "1");
            dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
            dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
            dao.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());
            dao.setProcOutValue(nProcIndex, "err", 1);
            dao.setProcOutValue(nProcIndex, "resultset", 2);
            dao.executeProcedure(nProcIndex);
            strErr = dao.getString(nProcIndex, "err");
            if (strErr == null) {
                strErr = "";
            }
            ws = dao.getWebRowSet(nProcIndex, "resultset");
            if (!strErr.equals("")) {
                throw new Exception(strErr);
            }
            vo.setBrandDtlWs(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("LPIssueDeskTransDAO.getSingleBatchItemDtl() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssueDtlsList(LPIssueDeskTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			
			// set value
			System.out.println("vo.getStrStoreId()--------"+vo.getStrStoreId());
			System.out.println("issueNo-------------------"+ vo.getStrIssueNo());
			System.out.println("hosp_code-----------------"+ vo.getStrHospitalCode());
			
			
			if(vo.getStrMode().equals("4"))
			{
				System.out.println("--------- pkg_dossier_view.Proc_Emp_Issue_Detail--- Mode 4 -----------");
				dao.setProcInValue(procIndex1, "modeval", "4",1);
			}	
			else
			{
				System.out.println("--------- pkg_dossier_view.Proc_Emp_Issue_Detail--- Mode 3 -----------");
				dao.setProcInValue(procIndex1, "modeval", "3",1);
			}	
			
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(),3);
			
			if(vo.getStrIssueNo()==null || vo.getStrIssueNo()=="")
				dao.setProcInValue(procIndex1, "issueNo", "0",2);
			else
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
    
    public static void getIssueDtlsListTwo(final LPIssueDeskTransVO vo) 
    {
        HisDAO dao = null;
        WebRowSet ws = null;
        int procIndex1 = 0;
        final String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}";
        try {
            dao = new HisDAO("mms", "global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");
            procIndex1 = dao.setProcedure(proc_name1);
            
            System.out.println("--------- DAO.getIssueDtlsListTwo() . pkg_dossier_view.Proc_Emp_Issue_Detail---if Mode 4 than 4 Else 3-----------");
            System.out.println("vo.getStrStoreId()----" + vo.getStrStoreId());
            System.out.println("issueNo-----" + vo.getStrIssueNo());
            System.out.println("hosp_code----" + vo.getStrHospitalCode());
            System.out.println("Return No----" + vo.getStrReturnNo());
            
            
            if (vo.getStrMode().equals("4")) 
            {
                dao.setProcInValue(procIndex1, "modeval", "4", 1);
            }
            else 
            {
                dao.setProcInValue(procIndex1, "modeval", "3", 1);
            }
            dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(), 3);
            
            if (vo.getStrMode().equals("4")) 
            {
	            if (vo.getStrReturnNo() == null || vo.getStrReturnNo() == "") 
	            {
	                dao.setProcInValue(procIndex1, "issueNo", "0", 2);
	            }
	            else 
	            {
	            	
	               // dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(), 2);
	            	 dao.setProcInValue(procIndex1, "issueNo", vo.getStrReturnNo(), 2);
	            }
            }
            else
            {
            	if (vo.getStrIssueNo() == null || vo.getStrIssueNo() == "") 
	            {
	                dao.setProcInValue(procIndex1, "issueNo", "0", 2);
	            }
	            else 
	            { 	
	             
	            	 dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(), 2);
	            }
            	
            }
            dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 4);
            dao.setProcOutValue(procIndex1, "ERR", 1, 5);
            dao.setProcOutValue(procIndex1, "RESULTSET", 2, 6);
            dao.executeProcedureByPosition(procIndex1);
            String err = dao.getString(procIndex1, "ERR");
            if (err == null) {
                err = "";
            }
            ws = dao.getWebRowSet(procIndex1, "RESULTSET");
            vo.setWsIssueDetails(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssueDtlsListExtra(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        WebRowSet ws = null;
        int procIndex1 = 0;
        final String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}";
        try {
            dao = new HisDAO("mms", "global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");
            procIndex1 = dao.setProcedure(proc_name1);
            
            
            System.out.println("--------- DAO . pkg_dossier_view.Proc_Emp_Issue_Detail---[Mode - 5 ]-----------");
            
            System.out.println("vo.getStrStoreId()----" + vo.getStrStoreId());
            System.out.println("issueNo-----" + vo.getStrIssueNo());
            System.out.println("hosp_code----" + vo.getStrHospitalCode());
            System.out.println("Return No----" + vo.getStrReturnNo());
            
            
            dao.setProcInValue(procIndex1, "modeval", "5", 1);
            dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(), 3);
            if (vo.getStrIssueNo() == null || vo.getStrIssueNo() == "") 
            {
                dao.setProcInValue(procIndex1, "issueNo", "0", 2);
            }
            else 
            {
                dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(), 2);
            }
            dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 4);
            dao.setProcOutValue(procIndex1, "ERR", 1, 5);
            dao.setProcOutValue(procIndex1, "RESULTSET", 2, 6);
            dao.executeProcedureByPosition(procIndex1);
            String err = dao.getString(procIndex1, "ERR");
            if (err == null) {
                err = "";
            }
            ws = dao.getWebRowSet(procIndex1, "RESULTSET");
            vo.setWsExtraIssueDetails(ws);
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getDossierDtls(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        WebRowSet ws = null;
        int procIndex1 = 0;
        final String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}";
        try {
            dao = new HisDAO("mms", "global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");
            procIndex1 = dao.setProcedure(proc_name1);
            
            
            System.out.println("--------- DAO . pkg_dossier_view.Proc_Emp_Issue_Detail---[Mode - 7 ]-----------");
            
            System.out.println("vo.getStrStoreId()----" + vo.getStrStoreId());
            System.out.println("issueNo-----" + vo.getStrIssueNo());
            System.out.println("hosp_code----" + vo.getStrHospitalCode());
            System.out.println("Return No----" + vo.getStrReturnNo());
            
            /*
            1.Issue No
            2.Issue Date
            3.Req No
            4.Req Date
            5.Patient Name
            6.Issuing Store Name
            7.DeptName_Unit Name
           */
            
            dao.setProcInValue(procIndex1, "modeval", 		"7", 1);
            dao.setProcInValue(procIndex1, "strId", 		vo.getStrStoreId(), 3);            
            dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrIssueNo(), 2);            
            dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(), 4);
            dao.setProcOutValue(procIndex1, "ERR", 			1, 5);
            dao.setProcOutValue(procIndex1, "RESULTSET",	2, 6);
            dao.executeProcedureByPosition(procIndex1);
            String err = dao.getString(procIndex1, "ERR");
            if (err == null) {
                err = "";
            }
            ws = dao.getWebRowSet(procIndex1, "RESULTSET");
            vo.setBrandDtlWs(ws);
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    
    public static void getIssueNoDtls(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        String strQuery = "";
        int nQueryIndex = 0;
        WebRowSet web = null;
        try {
            dao = new HisDAO("dossier", "LPIssueDeskTransDAO");
            strQuery = qryHandler_dossier.getQuery(1, "select.IssueNo.0");
            nQueryIndex = dao.setQuery(strQuery);
            dao.setQryValue(nQueryIndex, 1, vo.getStrLpRequestNo());
            dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
            web = dao.executeQry(nQueryIndex);
            if (web.next()) {
                vo.setStrIssueNo(web.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("DossierMstDAO.getIssueNoDtls() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
            web = null;
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
        web = null;
    }
    
    public static void getReturnNoDtls(final LPIssueDeskTransVO vo) {
        HisDAO dao = null;
        String strQuery = "";
        int nQueryIndex = 0;
        WebRowSet web = null;
        try {
            dao = new HisDAO("dossier", "LPIssueDeskTransDAO");
            strQuery = qryHandler_dossier.getQuery(1, "select.ReturnNo.0");
            nQueryIndex = dao.setQuery(strQuery);
            dao.setQryValue(nQueryIndex, 1, vo.getStrIssueNo());
            dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
            web = dao.executeQry(nQueryIndex);
            if (web.next()) {
                vo.setStrReturnNo(web.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            vo.setStrMsgString("DossierMstDAO.getReturnNoDtls() --> " + e.getMessage());
            vo.setStrMsgType("1");
            return;
        }
        finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
            web = null;
        }
        if (dao != null) {
            dao.free();
            dao = null;
        }
        web = null;
    }
    
    public static void getIssueItemDtl_view(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			if(_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1"))
			{	
				System.out.println("pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl- [ Mode -3 ]--");
			   dao.setProcInValue(procIndex1, "modval", "3", 1);  // New Mode
			} 
			else
			{	
				System.out.println("pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl- [ Mode -2 ]--");
			   dao.setProcInValue(procIndex1, "modval", "2", 1);
			}
			dao.setProcInValue(procIndex1, "strId", 	 _LPIssueDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",_LPIssueDeskTransVO.getStrLpRequestNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",  _LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo", 		 _LPIssueDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",  _LPIssueDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				System.out.println("IssueItemDtlWS--ws.size()---" + ws.size());
				_LPIssueDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
}
 