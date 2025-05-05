/**
 * Author Anurudra Goel
 */
package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.CommitteRemarksDtlDAO;
import mms.dao.SampleRecieveItemDAO;
import mms.transactions.vo.SampleRegisterTransVO;

public class SampleRegisterTransDAO {
	
	/**
	 * This function is used to fetch details for supplier combo
	 * @param vo
	 */
	public static void getSupplierDtl(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "SampleRegisterTransDAO");
				strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
				dao.setProcInValue(nprocIndex, "modeval", "1",1);
				dao.setProcInValue(nprocIndex, "branditem_id", "",2);
				dao.setProcInValue(nprocIndex, "contractType", "",3);
				dao.setProcInValue(nprocIndex, "catCode",_SampleRegisterTransVO.getStrItemCategory(),4);
				dao.setProcInValue(nprocIndex, "hosp_code",_SampleRegisterTransVO.getStrHospitalCode(),5);
				dao.setProcOutValue(nprocIndex, "err", 1,6);
				dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
			 	wb = dao.getWebRowSet(nprocIndex, "resultset");
			 	if (strerr.equals("")) {
					_SampleRegisterTransVO.setStrSupplierWS(wb);
	             
				 } else {
					throw new Exception(strerr);
				}
		} catch (Exception e) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getSupplierDtl() --> "
					+ e.getMessage());
			_SampleRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * This function is used to fetch details for member detail combo
	 * @param _SampleRegisterTransVO
	 */
	
	public static void getMemberDtl(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "SampleRegisterTransDAO");
				strproc_name = "{call pkg_mms_view.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
			    dao.setProcInValue(nprocIndex, "modval","1",1);   
				dao.setProcInValue(nprocIndex, "commiteeTypeId",_SampleRegisterTransVO.getStrCommitteeType(),2);
				dao.setProcInValue(nprocIndex, "commNo","",3);
				dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),4);
				dao.setProcInValue(nprocIndex, "catCode", _SampleRegisterTransVO.getStrItemCatNo(),5);
				dao.setProcOutValue(nprocIndex, "err", 1,6);
				dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_SampleRegisterTransVO.setCommitteMemberWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getMemberDtl() --> "
					+ e.getMessage());
			_SampleRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	}
	/**
	 * This function is used to set initial parameters for return mode.
	 * @param _SampleRegisterTransVO
	 */
public static void initReturnAdd(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
				dao = new HisDAO("mms", "SampleRegisterTransDAO");
				strproc_name = "{call pkg_mms_view.proc_sample_register_dtl(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),1);
				dao.setProcInValue(nprocIndex, "itemBrandId", _SampleRegisterTransVO.getStrItemBrandId(),2);
				dao.setProcInValue(nprocIndex, "batchSlNo" , _SampleRegisterTransVO.getStrBatchSlno(),3);
				dao.setProcInValue(nprocIndex, "itemId", _SampleRegisterTransVO.getStrItemId(),4);
				dao.setProcInValue(nprocIndex, "sample_recno", _SampleRegisterTransVO.getStrItemReciveNo(),5);
				dao.setProcOutValue(nprocIndex, "err", 1,6);
				dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				if (strerr.equals("")) {
					if(wb.next())
					{
						_SampleRegisterTransVO.setStrItemName(wb.getString(1));
						_SampleRegisterTransVO.setStrItemBrandName(wb.getString(2));
						_SampleRegisterTransVO.setStrRecQty(wb.getString(3));
						_SampleRegisterTransVO.setStrRecQtyUnitId(wb.getString(4));
						_SampleRegisterTransVO.setStrSupplierName(wb.getString(5));
						_SampleRegisterTransVO.setStrItemCategDtl(wb.getString(6));
						_SampleRegisterTransVO.setStrUnitVal(wb.getString(7));
						_SampleRegisterTransVO.setStrUnitBaseVals(wb.getString(8));
					}
				} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.initReturnAdd() --> "
					+ e.getMessage());
			_SampleRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 *This function is used to set initial parameter for unit combo 
	 * @param _SampleRegisterTransVO
	 */
public static void getUnitCombo(SampleRegisterTransVO _SampleRegisterTransVO) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		
		dao = new HisDAO("mms", "SampleRegisterTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		
	    dao.setProcInValue(nprocIndex, "modeval","1",1);
	    dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),2);
		dao.setProcInValue(nprocIndex, "module_id", "",3);
		dao.setProcInValue(nprocIndex, "unit_id	", _SampleRegisterTransVO.getStrUnitId(),4);
		dao.setProcOutValue(nprocIndex, "err", 1,5);
		dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
		dao.executeProcedureByPosition(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		
		if (strerr.equals("")) {
			_SampleRegisterTransVO.setUnitWS(wb);
		 } else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		e.printStackTrace();
		
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getUnitCombo() --> "
				+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			wb=null;
		}
	}
}
public static void getIssueBy(SampleRegisterTransVO _SampleRegisterTransVO) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		
		dao.setProcInValue(nprocIndex, "modeval", "1",1);
		dao.setProcInValue(nprocIndex, "deptunitCode","0",2);
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),3);
		dao.setProcInValue(nprocIndex, "seatId", "",4);
		dao.setProcOutValue(nprocIndex, "err", 1,5);
		dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
		dao.executeProcedureByPosition(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
	
		
		
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		
		
		if (strerr.equals("")) {
		       
			_SampleRegisterTransVO.setConsultantWs(wb);
		
		
		} else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getIssueBy() --> "
				+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}

/**
 * This function is fetch details from database for group combo
 * @param vo
 */

public static void getStoreGroupList(SampleRegisterTransVO _SampleRegisterTransVO) {
	

	String err = "";
	String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

	int procIndex1 = 0;
	HisDAO dao = null;
	WebRowSet ws = null;

	try {

			dao = new HisDAO("mms", "SampleRegisterTransDAO");
	
			procIndex1 = dao.setProcedure(proc_name1);
			
					
			dao.setProcInValue(procIndex1, "modeval", "2",1);
			// set value
			dao.setProcInValue(procIndex1, "item_category", _SampleRegisterTransVO.getStrItemCategory(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", _SampleRegisterTransVO
							.getStrHospitalCode(),3);
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
	
			dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
			// value
	
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object
	
			// execute procedure
	
			dao.executeProcedureByPosition(procIndex1);
	
			// get value
			err = dao.getString(procIndex1, "ERR");
	
			if (err == null)
				err = "";
	
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
	
			_SampleRegisterTransVO.setGroupWs(ws);

	} catch (Exception e) {
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getStoreGroupList() --> "
				+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");

	} finally {

		if (dao != null) {
			dao.free();
			dao = null;
		}

	}
}
/**
 * This function used to insert data during recieve mode
 * @param voObj
 */
public static void insert(SampleRegisterTransVO _SampleRegisterTransVO) {

	HisDAO daoObj = null;
	
	SampleRecieveItemDAO sampleRecieveItemDao;
	int i = 0;
	int length = 0;
	int funcIndex = 0;
	String strReqNo = null;
	
	String rateUnitId = null;
	
	String strItemId = null;
	String strItemBrandId  = null;
	
	//String strItemCatNo = null;
	String strConsumableFlag = null;
	String strSubGrpId = null;
	String[] temp = null;
	String[] temp1 = null;
	String [] strTemp=null;

	try {
		
			daoObj = new HisDAO("mms", "SampleRegisterTransDAO");
			
			sampleRecieveItemDao=new SampleRecieveItemDAO();
			length = _SampleRegisterTransVO.getItemParamValue().length;		
			 daoObj = new HisDAO("mms", "SampleRegisterTransDAO");
			 
			  funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_sample_recno(?,?,?)}");
			// Set Value
			
			daoObj.setFuncInValue(funcIndex, 2, _SampleRegisterTransVO.getStrItemCategory());
			daoObj.setFuncInValue(funcIndex, 3, _SampleRegisterTransVO.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 4, _SampleRegisterTransVO.getStrStoreId());
			
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			strReqNo = daoObj.getFuncString(funcIndex); // getting the req no.
			
			
		
			
			for(i=0;i<length;i++){
				if(_SampleRegisterTransVO.getStrUnitName()[i]!="0"){
					
					 temp1 = _SampleRegisterTransVO.getStrUnitName()[i].replace('^', '#').split("#");
					 rateUnitId = temp1[0];
					}else{
					rateUnitId = "0";
				}
				temp  = _SampleRegisterTransVO.getItemParamValue()[i].split("#");
				
				
				  strTemp=temp[2].replace('^', '#').split("#");
				  strItemId = strTemp[0];
				  strItemBrandId  = strTemp[1];
				  //strItemCatNo =  _SampleRegisterTransVO.getStrItemCategory();
				  strConsumableFlag = strTemp[4];
				  strSubGrpId = strTemp[3];
				 
			 
				 sampleRecieveItemDao.setStrBatchSlNo(_SampleRegisterTransVO.getStrBatchSlNo()[i]);
				 sampleRecieveItemDao.setStrExpiryDate( _SampleRegisterTransVO.getStrExpDate()[i]);
				 sampleRecieveItemDao.setStrGroupId(_SampleRegisterTransVO.getStrGroupName());
				 sampleRecieveItemDao.setStrHospitalCode(_SampleRegisterTransVO.getStrHospitalCode());
				 sampleRecieveItemDao.setStrConsumableFlag(strConsumableFlag);
				 sampleRecieveItemDao.setStrItemId(strItemId);
				 sampleRecieveItemDao.setStrItemBrandId(strItemBrandId);
				 sampleRecieveItemDao.setStrRecieveQty(_SampleRegisterTransVO.getStrQty()[i]);
				 sampleRecieveItemDao.setStrRecqtyUnitId(rateUnitId);
				 sampleRecieveItemDao.setStrSubgroupId(strSubGrpId);
				 sampleRecieveItemDao.setStrSampleRecno(strReqNo);
				 sampleRecieveItemDao.setStrRemarks(_SampleRegisterTransVO.getStrRemarks());
				 sampleRecieveItemDao.setStrStoreId(_SampleRegisterTransVO.getStrStoreId());
				 sampleRecieveItemDao.insert(daoObj);
				
		    }
			 synchronized (daoObj) {
					daoObj.fire();
					_SampleRegisterTransVO.setIsFlag(true);	
				 }
			
	  
	} catch (Exception e) {
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.insert() --> "
						+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	 }
}
/**
 * This function is used to update data during return mode
 * @param voObj
 */
public static void insertReturn(SampleRegisterTransVO _SampleRegisterTransVO) {

	HisDAO daoObj = null;
	//SampleRecieveDtlDAO sampleRecieveDtlDao=null;
	SampleRecieveItemDAO sampleRecieveItemDao=null;
	try {
			daoObj = new HisDAO("mms", "SampleRegisterTransDAO");
			sampleRecieveItemDao=new SampleRecieveItemDAO();
			sampleRecieveItemDao.setStrSampleRecno(_SampleRegisterTransVO.getStrSampleRecieveNo());
			sampleRecieveItemDao.setStrItemBrandId(_SampleRegisterTransVO.getStrItemBrandId());
			sampleRecieveItemDao.setStrItemId(_SampleRegisterTransVO.getStrItemId());
			sampleRecieveItemDao.setStrBatchSlNo(_SampleRegisterTransVO.getStrBatchSlno());
			sampleRecieveItemDao.setStrRemarks(_SampleRegisterTransVO.getStrRemarks());
			sampleRecieveItemDao.setStrHospitalCode(_SampleRegisterTransVO.getStrHospitalCode());
			sampleRecieveItemDao.setStrPassNo(_SampleRegisterTransVO.getStrGatePassNo());
			sampleRecieveItemDao.setStrReturnTo(_SampleRegisterTransVO.getStrReturnTo());
			sampleRecieveItemDao.setStrStoreId(_SampleRegisterTransVO.getStrStoreId());
			sampleRecieveItemDao.update(daoObj);
			synchronized (daoObj) {
				 daoObj.fire();
				 _SampleRegisterTransVO.setIsFlag(true);
			}
		} catch (Exception e) {
		
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.insertReturn() --> "
						+ e.getMessage());
			_SampleRegisterTransVO.setStrMsgType("1");
	 } finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	 }
}

/**
 * This function is used to update data during verify mode
 * @param voObj
 */
public static void updateVerify(SampleRegisterTransVO _SampleRegisterTransVO) {

	HisDAO daoObj = null;
	SampleRecieveItemDAO sampleRecieveItemDao=null;
	CommitteRemarksDtlDAO committeRemarks=null;
	String strTemp[]=null;
	String strQuery="";
	String maxSlno="0";
	int length=0;
	int nQueryIndex=0;
	WebRowSet web=null;
	

	try {
		
			
			daoObj = new HisDAO("mms", "SampleRegisterTransDAO");
			sampleRecieveItemDao=new SampleRecieveItemDAO();
			committeRemarks=new CommitteRemarksDtlDAO();
			if(_SampleRegisterTransVO.getStrMemberRecommendation()!=null)
				length=_SampleRegisterTransVO.getStrMemberRecommendation().length;
			
			if(length>0 )
			{
				strTemp=_SampleRegisterTransVO.getStrCommitteeMemberHidden()[0].replace('@', '#').split("#");
				strQuery =  "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"+
						"	where HSTNUM_COMMITTEE_NO=?"+"and GNUM_HOSPITAL_CODE=?";
				
				nQueryIndex = daoObj.setQuery(strQuery);
				daoObj.setQryValue(nQueryIndex, 1, strTemp[1]);
				daoObj.setQryValue(nQueryIndex, 2, _SampleRegisterTransVO.getStrHospitalCode());
				web = daoObj.executeQry(nQueryIndex);
				if(web.next())
				{
					maxSlno=web.getString(1);
				}
				for(int i=0;i<length;i++)
				{
					strTemp=_SampleRegisterTransVO.getStrCommitteeMemberHidden()[i].replace('@', '#').split("#");
					committeRemarks.setStrEmpCode(strTemp[0]);
					committeRemarks.setStrCommitteNo(strTemp[1]);
					committeRemarks.setStrMemberName(strTemp[2]);
					committeRemarks.setStrHospCode(_SampleRegisterTransVO.getStrHospitalCode());
					committeRemarks.setRemarks(_SampleRegisterTransVO.getStrMemberRecommendation()[i]);
					committeRemarks.setStrCommitteTypeId(_SampleRegisterTransVO.getStrCommitteeType());
					committeRemarks.setStrCommRemarksSlNo(maxSlno);
					committeRemarks.insert(daoObj);
				}
				
			}
			
			sampleRecieveItemDao.setStrSampleRecno(_SampleRegisterTransVO.getStrSampleRecieveNo());
			sampleRecieveItemDao.setStrItemBrandId(_SampleRegisterTransVO.getStrItemBrandId());
			sampleRecieveItemDao.setStrItemId(_SampleRegisterTransVO.getStrItemId());
			sampleRecieveItemDao.setStrBatchSlNo(_SampleRegisterTransVO.getStrBatchSlno());
			sampleRecieveItemDao.setStrRemarks(_SampleRegisterTransVO.getStrRemarks());
			sampleRecieveItemDao.setStrHospitalCode(_SampleRegisterTransVO.getStrHospitalCode());
			sampleRecieveItemDao.setStrApprovalStatus(_SampleRegisterTransVO.getStrApprovalStatus());
			sampleRecieveItemDao.setStrCommitteType(_SampleRegisterTransVO.getStrCommitteeType());
			sampleRecieveItemDao.setStrCommRmksSlNo(maxSlno);
			sampleRecieveItemDao.setStrCommitteNo(strTemp[1]);
			sampleRecieveItemDao.setStrStoreId(_SampleRegisterTransVO.getStrStoreId());
			sampleRecieveItemDao.setStrFileNameComm(_SampleRegisterTransVO.getStrFileName());
			sampleRecieveItemDao.setStrFileNo(_SampleRegisterTransVO.getStrFileNo());
			sampleRecieveItemDao.setStrPageNo(_SampleRegisterTransVO.getStrPageNo());
			sampleRecieveItemDao.setConsumeQty(_SampleRegisterTransVO.getConsumeQty());
			sampleRecieveItemDao.setStrConsumeQtyUnit(_SampleRegisterTransVO.getStrConsumeQtyUnit());
			sampleRecieveItemDao.updateVerify(daoObj);
			
			 synchronized (daoObj) {
				 
				daoObj.fire();
				_SampleRegisterTransVO.setIsFlag(true);
				
				
			}

	} catch (Exception e) {
		
		e.printStackTrace();
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.updateVerify() --> "
						+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	 }
 }
/**
 * This function is used to update data during condemnation mode
 * @param voObj
 */

public static void condemnUpdate(SampleRegisterTransVO _SampleRegisterTransVO) {
	

	HisDAO daoObj = null;
	SampleRecieveItemDAO sampleRecieveItemDao=null;
	try {
		
		
			daoObj = new HisDAO("mms", "SampleRegisterTransDAO");
			sampleRecieveItemDao=new SampleRecieveItemDAO();
			sampleRecieveItemDao.setStrSampleRecno(_SampleRegisterTransVO.getStrSampleRecieveNo());
			sampleRecieveItemDao.setStrItemBrandId(_SampleRegisterTransVO.getStrItemBrandId());
			sampleRecieveItemDao.setStrItemId(_SampleRegisterTransVO.getStrItemId());
			sampleRecieveItemDao.setStrBatchSlNo(_SampleRegisterTransVO.getStrBatchSlno());
			sampleRecieveItemDao.setStrRemarks(_SampleRegisterTransVO.getStrRemarks());
			sampleRecieveItemDao.setStrHospitalCode(_SampleRegisterTransVO.getStrHospitalCode());
			sampleRecieveItemDao.setStrStoreId(_SampleRegisterTransVO.getStrStoreId());
			sampleRecieveItemDao.condemnUpdate(daoObj);
			
			synchronized (daoObj) {
				daoObj.fire();
				_SampleRegisterTransVO.setIsFlag(true);
			}
	} catch (Exception e) {
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.condemnUpdate() --> "
						+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	 }
}

/**
 * This function is used to set initial parameters for Item category combo
 * @param vo
 */
public static void getItemCategoryCombo(SampleRegisterTransVO _SampleRegisterTransVO) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nprocIndex, "modeval","1",1);
		dao.setProcInValue(nprocIndex, "store_id", _SampleRegisterTransVO.getStrStoreId(),2);
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),3);
		dao.setProcInValue(nprocIndex, "reqType", "",4);
		dao.setProcOutValue(nprocIndex, "err", 1,5);
		dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
		dao.executeProcedureByPosition(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		if (strerr.equals("")) {
			_SampleRegisterTransVO.setItemCategoryWS(wb);
		 } else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.getItemCategoryCombo() --> "
				+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}
/**
 * This function is used to fetch details for committee type combo.
 * @param _SampleRegisterTransVO
 */
public static void setCommitteeTypeDtl(SampleRegisterTransVO _SampleRegisterTransVO)
{
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nprocIndex, "modeval","1",1);
		dao.setProcInValue(nprocIndex, "catCode", _SampleRegisterTransVO.getStrItemCatNo(),2);
		dao.setProcInValue(nprocIndex, "reqType", "53",3);
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterTransVO.getStrHospitalCode(),4);
		dao.setProcOutValue(nprocIndex, "err", 1,5);
		dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
		dao.executeProcedureByPosition(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		if (strerr.equals("")) {
			_SampleRegisterTransVO.setCommitteTypeWS(wb);
		 } else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		e.printStackTrace();
		
		_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransDAO.setCommitteeTypeDtl() --> "
				+ e.getMessage());
		_SampleRegisterTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}

}
	