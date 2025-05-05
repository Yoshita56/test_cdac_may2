package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.CommitteRemarksDtlDAO;
import mms.dao.SampleRecieveItemOnlineDAO;
import mms.transactions.vo.SampleRegisterPurTransVO;


public class SampleRegisterPurTransDAO {
	/**
	 * This function is used to fetch details for supplier combo
	 * @param vo
	 */
	public static void getSupplierCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
				strproc_name = "{call pkg_purchase_view.proc_Supplier_list(?,?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
				dao.setProcInValue(nprocIndex, "modeval", "7");
				dao.setProcInValue(nprocIndex, "screenId",_SampleRegisterPurTransVO.getStrProposalNo());
				dao.setProcInValue(nprocIndex, "tenquoNo",_SampleRegisterPurTransVO.getStrTenderNo());
				dao.setProcInValue(nprocIndex, "hosp_code",_SampleRegisterPurTransVO.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "catCode","");
				dao.setProcInValue(nprocIndex, "is_Foreign","");
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
			 	wb = dao.getWebRowSet(nprocIndex, "resultset");
			 	if (strerr.equals("")) {
					_SampleRegisterPurTransVO.setStrSupplierWS(wb);
	             
				 } else {
					throw new Exception(strerr);
				}
		} catch (Exception e) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getSupplierCombo() --> "
					+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
		
	public static void getItemCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
			
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
					dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
					strproc_name = "{call pkg_purchase_view.proc_item_list(?,?,?,?,?,?)}";
					nprocIndex = dao.setProcedure(strproc_name);
					dao.setProcInValue(nprocIndex, "modeval", "2");  
					dao.setProcInValue(nprocIndex, "supp_Id",_SampleRegisterPurTransVO.getStrSupplierId());
					dao.setProcInValue(nprocIndex, "screen_Id",_SampleRegisterPurTransVO.getStrProposalNo());
					dao.setProcInValue(nprocIndex, "hosp_code",_SampleRegisterPurTransVO.getStrHospitalCode());
					dao.setProcOutValue(nprocIndex, "err", 1);
					dao.setProcOutValue(nprocIndex, "resultset", 2); 
					dao.executeProcedure(nprocIndex);
					strerr = dao.getString(nprocIndex, "err");
					if (strerr == null)
						strerr = "";
				 	wb = dao.getWebRowSet(nprocIndex, "resultset");
				 	if (strerr.equals("")) {
						_SampleRegisterPurTransVO.setItemWs(wb);
		             
					 } else {
						throw new Exception(strerr);
					}
			} catch (Exception e) {
				_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getItemCombo() --> "
						+ e.getMessage());
				_SampleRegisterPurTransVO.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
		}
	
	
	public static void getUnitCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_gblt_unit_mst(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "unit_id	", _SampleRegisterPurTransVO.getStrItemUnitId());
			dao.setProcInValue(nprocIndex, "module_id", "");
			dao.setProcInValue(nprocIndex, "modeval	", "1");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2); 
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strerr.equals("")) {
				_SampleRegisterPurTransVO.setUnitWS(wb);
			 } else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getUnitCombo() --> "
					+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	}
	
	/**
	 * This function is used to fetch details for member detail combo
	 * @param _SampleRegisterPurTransVO
	 */
	
	public static void getMemberDtl(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
				strproc_name = "{call pkg_mms_view.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
			    dao.setProcInValue(nprocIndex, "modval","1");
				dao.setProcInValue(nprocIndex, "commiteeTypeId",_SampleRegisterPurTransVO.getStrCommitteeType());
				dao.setProcInValue(nprocIndex, "commNo","");
				dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "catCode", _SampleRegisterPurTransVO.getStrItemCatNo());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_SampleRegisterPurTransVO.setCommitteMemberWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getMemberDtl() --> "
					+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
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
	 * @param _SampleRegisterPurTransVO
	 */
public static void initReturnAdd(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		String[] temp = null; 
		try {
			
				dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
				strproc_name = "{call pkg_mms_view.proc_sample_register_dtl(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//--NVL(Mms_Mst.get_itembrand_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID,HSTNUM_ITEM_ID),'' '' )AS item_brand_name,
				dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
				//dao.setProcInValue(nprocIndex, "itemBrandId", _SampleRegisterPurTransVO.getStrItemBrandId());
				//dao.setProcInValue(nprocIndex, "batchSlNo" , _SampleRegisterPurTransVO.getStrBatchSlno());
				//dao.setProcInValue(nprocIndex, "itemId", _SampleRegisterPurTransVO.getStrItemId());
				dao.setProcInValue(nprocIndex, "sample_recno", _SampleRegisterPurTransVO.getStrItemReciveNo());
				dao.setProcInValue(nprocIndex, "tenderNo", _SampleRegisterPurTransVO.getStrTenderNo());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				if (strerr.equals("")) {
					if(wb.next())
					{
						/*//System.out.println("wb.getString(1)-->"+wb.getString(1));
						//System.out.println("wb.getString(2)-->"+wb.getString(2));
						//System.out.println("wb.getString(3)-->"+wb.getString(3));
						//System.out.println("wb.getString(4)-->"+wb.getString(4));
						//System.out.println("wb.getString(5)-->"+wb.getString(5));
						//System.out.println("wb.getString(6)-->"+wb.getString(6));
						//System.out.println("wb.getString(7)-->"+wb.getString(7));
						*/
						
						_SampleRegisterPurTransVO.setStrItemName(wb.getString(1));
						_SampleRegisterPurTransVO.setStrItemBrandName(wb.getString(2));
						_SampleRegisterPurTransVO.setStrBatchSlno(wb.getString(3));
						_SampleRegisterPurTransVO.setStrRecQty(wb.getString(4));
						_SampleRegisterPurTransVO.setStrRecQtyUnitId(wb.getString(6));
						_SampleRegisterPurTransVO.setStrSupplierName(wb.getString(9));
						_SampleRegisterPurTransVO.setStrRecQtyUnit(wb.getString(10));
						//_SampleRegisterPurTransVO.setStrItemCategDtl(wb.getString(6));
						
						temp = wb.getString(7).replace("^", "#").split("#");
						
						_SampleRegisterPurTransVO.setStrQuotationNo(temp[0]);
						_SampleRegisterPurTransVO.setStrTenderNo(temp[1]);
						_SampleRegisterPurTransVO.setStrSupplierId(temp[2]);
					}
				} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.initReturnAdd() --> "
					+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 *This function is used to set initial parameter for unit combo 
	 * @param _SampleRegisterPurTransVO
	 */

public static void getIssueBy(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		
		dao.setProcInValue(nprocIndex, "modeval", "1");
		dao.setProcInValue(nprocIndex, "deptunitCode","0");
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
		dao.setProcInValue(nprocIndex, "seatId", "");
		dao.setProcOutValue(nprocIndex, "err", 1);
		dao.setProcOutValue(nprocIndex, "resultset", 2); 
		dao.executeProcedure(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
	
		
		
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		
		
		if (strerr.equals("")) {
		       
			_SampleRegisterPurTransVO.setConsultantWs(wb);
		
		
		} else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getIssueBy() --> "
				+ e.getMessage());
		_SampleRegisterPurTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}
	
	public static void getProposalList(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		
		String err = "";
		String proc_name1 = "{call pkg_purchase_view.proc_dScreening_dtl(?,?,?,?,?,?,?,?,?)}";
	
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
	
		try {
	
				dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
		
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "modeval", "7");
				// set value
				dao.setProcInValue(procIndex1, "itemCat_No", _SampleRegisterPurTransVO.getStrItemCategory());
				dao.setProcInValue(procIndex1, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
				
				dao.setProcInValue(procIndex1, "screenId", "");
				dao.setProcInValue(procIndex1, "strId", "");
				dao.setProcInValue(procIndex1, "login_seatId", "");
				dao.setProcInValue(procIndex1, "contractTypeId", "");
		
				dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return value
				dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
		
				// execute procedure
		
				dao.executeProcedure(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				_SampleRegisterPurTransVO.setProposalNoWs(ws);
	
		} catch (Exception e) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getProposalList() --> "
					+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
	
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
public static void insert(SampleRegisterPurTransVO vo) {

	HisDAO dao = null;
	String strProcName = "";
	int nProcIndex = 0;
	
	int funcIndex = 0;
	int funcIndex1 = 0;
	String strSampleRecNo = null;
	String strItemProperty = null;
	
	try {
		
		dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
			 
			funcIndex = dao.setFunction("{? = call MMS_MST.generate_sample_recno(?,?,?)}");
			// Set Value
			
			dao.setFuncInValue(funcIndex, 2, vo.getStrItemCategory());
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strSampleRecNo = dao.getFuncString(funcIndex); // getting the sample rec no.
			
			
			funcIndex1 = dao.setFunction("{? = call MMS_MST.GET_ITEM_PROPERTY(?,?,?,?,?)}");
			// Set Value
			//modeval NUMBER,item_id NUMBER,hosp_code NUMBER,strId NUMBER DEFAULT 0,brandId NUMBER DEFAULT 0
			
			dao.setFuncInValue(funcIndex1, 2, "1");
			dao.setFuncInValue(funcIndex1, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex1, 4, vo.getStrItemId().replace("^", "#").split("#")[0]);
			dao.setFuncInValue(funcIndex1, 5, "0");
			dao.setFuncInValue(funcIndex1, 6, "0");
			
			dao.setFuncOutValue(funcIndex1, 1);
			dao.executeFunction(funcIndex1);
			strItemProperty = dao.getFuncString(funcIndex1); // getting the sample rec no.
			
			// CALLING OF PROCEDURE TO INSERT THE DATA
			strProcName = "{call PKG_MMS_DML.Dml_Sample_Recieve_online_Dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //31
			nProcIndex = dao.setProcedure(strProcName);
			
			dao.setProcInValue(nProcIndex, "modeval", "1"); 													//1
			dao.setProcInValue(nProcIndex, "sampleRecNo", strSampleRecNo);										//2
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());								//3
			dao.setProcInValue(nProcIndex, "itemCatNo", vo.getStrItemCategory());								//4
			dao.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());										//5
			dao.setProcInValue(nProcIndex, "tenderNo", vo.getStrTenderNo());									//6
			dao.setProcInValue(nProcIndex, "quotationNo", vo.getStrQuotationNo());								//7
			dao.setProcInValue(nProcIndex, "supplierId", vo.getStrSupplierId());								//8
			dao.setProcInValue(nProcIndex, "sampleStatus", vo.getStrSampleStatus());							//9
			dao.setProcInValue(nProcIndex, "remarks", vo.getStrRemarks());										//10
			dao.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());										//11
			dao.setProcInValue(nProcIndex, "isValid", vo.getStrIsValid());										//12
			dao.setProcInValue(nProcIndex, "screenId", vo.getStrProposalNo());									//13
			dao.setProcInValue(nProcIndex, "itemId", vo.getStrItemId().replace("^", "#").split("#")[0]);		//14
			dao.setProcInValue(nProcIndex, "itembrandId", vo.getStrItemId().replace("^", "#").split("#")[1]);	//15
			dao.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchSlno());									//16
			dao.setProcInValue(nProcIndex, "groupId", strItemProperty.replace("^", "#").split("#")[0]);			//17
			dao.setProcInValue(nProcIndex, "subgroupId", strItemProperty.replace("^", "#").split("#")[1]);		//18
			dao.setProcInValue(nProcIndex, "expiryDate", vo.getStrExpiryDate());								//19
			dao.setProcInValue(nProcIndex, "consumableFlag", strItemProperty.replace("^", "#").split("#")[2]);	//20
			dao.setProcInValue(nProcIndex, "recQty", vo.getStrRecQty());										//21
			dao.setProcInValue(nProcIndex, "recQtyUnitId", vo.getStrRecQtyUnitId().replace("^", "#").split("#")[0]); //22
			dao.setProcInValue(nProcIndex, "issueQty", vo.getStrIssuedQty());									//23
			dao.setProcInValue(nProcIndex, "returnQty", vo.getStrReturnQty());									//24
			dao.setProcInValue(nProcIndex, "condemnQty", vo.getStrCondemnQty());								//25
			dao.setProcInValue(nProcIndex, "sampleItemStatus", vo.getStrSampleItemStatus());					//26
			dao.setProcInValue(nProcIndex, "approvalStatus", vo.getStrApprovalStatus());						//27
			dao.setProcInValue(nProcIndex, "commRmksSlNo", vo.getStrComRmksSlNo());								//28
			dao.setProcInValue(nProcIndex, "demandYear", vo.getStrItemId().replace("^", "#").split("#")[3]);	//29
			dao.setProcInValue(nProcIndex, "itemSlNo", vo.getStrItemId().replace("^", "#").split("#")[2]);		//30
			dao.setProcOutValue(nProcIndex, "err", 1); 															//31

			dao.execute(nProcIndex, 1);
			
			 synchronized (dao) {
					dao.fire();
					vo.setIsFlag(true);	
				 }
			
	  
	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("SampleRegisterPurTransDAO.insert() --> "
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
 * This function is used to update data during return mode
 * @param voObj
 */
public static void insertReturn(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {

	HisDAO daoObj = null;
	//SampleRecieveDtlDAO sampleRecieveDtlDao=null;
	SampleRecieveItemOnlineDAO sampleRecieveItemOnlineDao=null;
	try {
			daoObj = new HisDAO("mms", "SampleRegisterPurTransDAO");
			sampleRecieveItemOnlineDao=new SampleRecieveItemOnlineDAO();
			sampleRecieveItemOnlineDao.setStrSampleRecno(_SampleRegisterPurTransVO.getStrSampleRecieveNo());
			sampleRecieveItemOnlineDao.setStrItemBrandId(_SampleRegisterPurTransVO.getStrItemBrandId());
			sampleRecieveItemOnlineDao.setStrItemId(_SampleRegisterPurTransVO.getStrItemId());
			sampleRecieveItemOnlineDao.setStrBatchSlNo(_SampleRegisterPurTransVO.getStrBatchSlno());
			sampleRecieveItemOnlineDao.setStrRemarks(_SampleRegisterPurTransVO.getStrRemarks());
			sampleRecieveItemOnlineDao.setStrHospitalCode(_SampleRegisterPurTransVO.getStrHospitalCode());
			sampleRecieveItemOnlineDao.setStrPassNo(_SampleRegisterPurTransVO.getStrGatePassNo());
			sampleRecieveItemOnlineDao.setStrReturnTo(_SampleRegisterPurTransVO.getStrReturnTo());
			sampleRecieveItemOnlineDao.setStrStoreId(_SampleRegisterPurTransVO.getStrStoreId());
			sampleRecieveItemOnlineDao.update(daoObj);
			synchronized (daoObj) {
				 daoObj.fire();
				 _SampleRegisterPurTransVO.setIsFlag(true);
			}
		} catch (Exception e) {
		
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.insertReturn() --> "
						+ e.getMessage());
			_SampleRegisterPurTransVO.setStrMsgType("1");
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
public static void updateVerify(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {

	HisDAO daoObj = null;
	SampleRecieveItemOnlineDAO sampleRecieveItemOnlineDao=null;
	CommitteRemarksDtlDAO committeRemarks=null;
	String strTemp[]=null;
	String strQuery="";
	String maxSlno="0";
	int length=0;
	int nQueryIndex=0;
	WebRowSet web=null;
	try {
		
			daoObj = new HisDAO("mms", "SampleRegisterPurTransDAO");
			sampleRecieveItemOnlineDao=new SampleRecieveItemOnlineDAO();
			committeRemarks=new CommitteRemarksDtlDAO();
			if(_SampleRegisterPurTransVO.getStrMemberRecommendation()!=null)
				length=_SampleRegisterPurTransVO.getStrMemberRecommendation().length;
			
			if(length>0 )
			{
				strTemp=_SampleRegisterPurTransVO.getStrCommitteeMemberHidden()[0].replace('@', '#').split("#");
				strQuery =  "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"+
						"	where HSTNUM_COMMITTEE_NO=?"+"and GNUM_HOSPITAL_CODE=?";
				
				nQueryIndex = daoObj.setQuery(strQuery);
				daoObj.setQryValue(nQueryIndex, 1, strTemp[1]);
				daoObj.setQryValue(nQueryIndex, 2, _SampleRegisterPurTransVO.getStrHospitalCode());
				web = daoObj.executeQry(nQueryIndex);
				if(web.next())
				{
					maxSlno=web.getString(1);
				}
				for(int i=0;i<length;i++)
				{
					strTemp=_SampleRegisterPurTransVO.getStrCommitteeMemberHidden()[i].replace('@', '#').split("#");
					committeRemarks.setStrEmpCode(strTemp[0]);
					committeRemarks.setStrCommitteNo(strTemp[1]);
					committeRemarks.setStrMemberName(strTemp[2]);
					committeRemarks.setStrHospCode(_SampleRegisterPurTransVO.getStrHospitalCode());
					committeRemarks.setRemarks(_SampleRegisterPurTransVO.getStrMemberRecommendation()[i]);
					committeRemarks.setStrCommitteTypeId(_SampleRegisterPurTransVO.getStrCommitteeType());
					committeRemarks.setStrCommRemarksSlNo(maxSlno);
					committeRemarks.insert(daoObj);
				}
				
			}
			
			sampleRecieveItemOnlineDao.setStrSampleRecno(_SampleRegisterPurTransVO.getStrSampleRecieveNo());
			sampleRecieveItemOnlineDao.setStrItemBrandId(_SampleRegisterPurTransVO.getStrItemBrandId());
			sampleRecieveItemOnlineDao.setStrItemId(_SampleRegisterPurTransVO.getStrItemId());
			sampleRecieveItemOnlineDao.setStrBatchSlNo(_SampleRegisterPurTransVO.getStrBatchSlno());
			sampleRecieveItemOnlineDao.setStrRemarks(_SampleRegisterPurTransVO.getStrRemarks());
			sampleRecieveItemOnlineDao.setStrHospitalCode(_SampleRegisterPurTransVO.getStrHospitalCode());
			sampleRecieveItemOnlineDao.setStrApprovalStatus(_SampleRegisterPurTransVO.getStrApprovalStatus());
			sampleRecieveItemOnlineDao.setStrCommitteType(_SampleRegisterPurTransVO.getStrCommitteeType());
			sampleRecieveItemOnlineDao.setStrCommRmksSlNo(maxSlno);
			sampleRecieveItemOnlineDao.setStrCommitteNo(strTemp[1]);
			sampleRecieveItemOnlineDao.setStrStoreId(_SampleRegisterPurTransVO.getStrStoreId());
			sampleRecieveItemOnlineDao.setStrFileNameComm(_SampleRegisterPurTransVO.getStrFileName());
			sampleRecieveItemOnlineDao.setStrFileNo(_SampleRegisterPurTransVO.getStrFileNo());
			sampleRecieveItemOnlineDao.setStrPageNo(_SampleRegisterPurTransVO.getStrPageNo());
			sampleRecieveItemOnlineDao.updateVerify(daoObj);
			
			synchronized (daoObj)
			{
				daoObj.fire();
				_SampleRegisterPurTransVO.setIsFlag(true);
			}

	} catch (Exception e) {
		
		e.printStackTrace();
		_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.updateVerify() --> "
						+ e.getMessage());
		_SampleRegisterPurTransVO.setStrMsgType("1");

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

public static void condemnUpdate(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
	

	HisDAO daoObj = null;
	SampleRecieveItemOnlineDAO sampleRecieveItemOnlineDao=null;
	try {
		
		
			daoObj = new HisDAO("purchase", "SampleRegisterPurTransDAO");
			sampleRecieveItemOnlineDao=new SampleRecieveItemOnlineDAO();
			sampleRecieveItemOnlineDao.setStrSampleRecno(_SampleRegisterPurTransVO.getStrSampleRecieveNo());
			sampleRecieveItemOnlineDao.setStrItemBrandId(_SampleRegisterPurTransVO.getStrItemBrandId());
			sampleRecieveItemOnlineDao.setStrItemId(_SampleRegisterPurTransVO.getStrItemId());
			sampleRecieveItemOnlineDao.setStrBatchSlNo(_SampleRegisterPurTransVO.getStrBatchSlno());
			sampleRecieveItemOnlineDao.setStrRemarks(_SampleRegisterPurTransVO.getStrRemarks());
			sampleRecieveItemOnlineDao.setStrHospitalCode(_SampleRegisterPurTransVO.getStrHospitalCode());
			sampleRecieveItemOnlineDao.setStrStoreId(_SampleRegisterPurTransVO.getStrStoreId());
			
			
			sampleRecieveItemOnlineDao.condemnUpdate(daoObj);
			
			synchronized (daoObj) {
				daoObj.fire();
				_SampleRegisterPurTransVO.setIsFlag(true);
			}
	} catch (Exception e) {
		_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.condemnUpdate() --> "
						+ e.getMessage());
		_SampleRegisterPurTransVO.setStrMsgType("1");

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
public static void getItemCategoryCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nprocIndex, "modeval","1");
		dao.setProcInValue(nprocIndex, "store_id", _SampleRegisterPurTransVO.getStrStoreId());
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
		dao.setProcInValue(nprocIndex, "reqType", "");
		dao.setProcOutValue(nprocIndex, "err", 1);
		dao.setProcOutValue(nprocIndex, "resultset", 2); 
		dao.executeProcedure(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		if (strerr.equals("")) {
			_SampleRegisterPurTransVO.setItemCategoryWS(wb);
		 } else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.getItemCategoryCombo() --> "
				+ e.getMessage());
		_SampleRegisterPurTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}
/**
 * This function is used to fetch details for committee type combo.
 * @param _SampleRegisterPurTransVO
 */
public static void setCommitteeTypeDtl(SampleRegisterPurTransVO _SampleRegisterPurTransVO)
{
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
		dao = new HisDAO("mms", "SampleRegisterPurTransDAO");
		strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
		nprocIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nprocIndex, "modeval","1");
		dao.setProcInValue(nprocIndex, "catCode", _SampleRegisterPurTransVO.getStrItemCatNo());
		dao.setProcInValue(nprocIndex, "reqType", "53");
		dao.setProcInValue(nprocIndex, "hosp_code", _SampleRegisterPurTransVO.getStrHospitalCode());
		dao.setProcOutValue(nprocIndex, "err", 1);
		dao.setProcOutValue(nprocIndex, "resultset", 2); 
		dao.executeProcedure(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		if (strerr == null)
			strerr = "";
		wb = dao.getWebRowSet(nprocIndex, "resultset");
		if (strerr.equals("")) {
			_SampleRegisterPurTransVO.setCommitteTypeWS(wb);
		 } else {
			throw new Exception(strerr);
		}
	} catch (Exception e) {
		e.printStackTrace();
		
		_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransDAO.setCommitteeTypeDtl() --> "
				+ e.getMessage());
		_SampleRegisterPurTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}

}
