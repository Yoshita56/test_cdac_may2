/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.dao.CommitteRemarksDtlDAO;
import mms.dao.CondemnationDetailDAO;
import mms.transactions.vo.CondemnationRegisterTransVO;


/**
 * @author Anurudra Goel
 * 
 */
public class CondemnRegisterTransDAO {
	
	/**
	 * This function is used to fetch details for member detail combo
	 * @param _CondemnationRegisterTransVO
	 */
	
	public static void getMemberDtl(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {
		
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "CondemnRegisterTransDAO");
				strproc_name = "{call pkg_mms_view.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "commiteeTypeId",_CondemnationRegisterTransVO.getStrCommitteType());
				dao.setProcInValue(nprocIndex, "catCode", _CondemnationRegisterTransVO.getStrItemCategoryNo());
				dao.setProcInValue(nprocIndex, "hosp_code", _CondemnationRegisterTransVO.getStrHospCode());
				
				/*Start*/
				dao.setProcInValue(nprocIndex, "modval", "1");
				dao.setProcInValue(nprocIndex, "commNo", "");
				/*End*/
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_CondemnationRegisterTransVO.setCommitteMemberWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getMemberDtl() --> "
					+ e.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	}
	
	/**
	 * This function is used to fetch request details on main screen
	 * @param _CondemnationRegisterTransVO
	 */
	
	public static void getRequestDetails(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {

		String strProcName = "";
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				strProcName = "{call PKG_MMS_VIEW.proc_agenda_indent_dtl(?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "hosp_code ", _CondemnationRegisterTransVO.getStrHospCode());;
				dao.setProcInValue(nProcIndex, "store_id",   _CondemnationRegisterTransVO.getStrStoreId());
				dao.setProcInValue(nProcIndex, "agenda_no",  _CondemnationRegisterTransVO.getStrAgendaNo());
				/*Start*/
				dao.setProcInValue(nProcIndex, "modeval", "1");
				/*End*/
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);
				strErr = dao.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				wb = dao.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					_CondemnationRegisterTransVO.setRequestDtlWS(wb);
	
				} else {
					throw new Exception(strErr);
				}
		} catch (Exception _Err) {
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getRequestDetails() --> "
							+ _Err.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 * This function is used to fetch item details on main screen on the basis of agenda number.
	 * @param _CondemnationRegisterTransVO
	 */
	public static void getItemDetails(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {

		String strProcName = "";
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				strProcName = "{call PKG_MMS_VIEW.proc_agenda_item_dtl(?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "hosp_code", _CondemnationRegisterTransVO.getStrHospCode());
				dao.setProcInValue(nProcIndex, "store_id", _CondemnationRegisterTransVO.getStrStoreId());
				dao.setProcInValue(nProcIndex, "agenda_no", _CondemnationRegisterTransVO.getStrAgendaNo());
				/*Start*/
				dao.setProcInValue(nProcIndex, "modeval", "1");
				/*End*/
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);
				strErr = dao.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				wb = dao.getWebRowSet(nProcIndex, "resultset");
				
				if (strErr.equals("")) {
					_CondemnationRegisterTransVO.setItemDtlWS(wb);
	
				} else {
					throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getItemDetails() --> "
							+ _Err.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * This function is usedn to fetch details in committee type combo from database
	 * @param _CondemnationRegisterTransVO
	 */
	public static void getCommitteTypeDtl(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {

		String strProcName = "";
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				strProcName = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "hosp_code ", _CondemnationRegisterTransVO.getStrHospCode());
				dao.setProcInValue(nProcIndex, "catCode ", 	_CondemnationRegisterTransVO.getStrItemCategoryNo());
			    dao.setProcInValue(nProcIndex, "reqType ", "59");
			    /*Start*/
				dao.setProcInValue(nProcIndex, "modeval", "1");
				/*End*/
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);
				strErr = dao.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				wb = dao.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					_CondemnationRegisterTransVO.setCommitteTypeWS(wb);
	
				} else {
					throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getCommitteTypeDtl() --> "
							+ _Err.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
/**
 * This function is used to insert data into database
 * @param _CondemnationRegisterTransVO
 */
	public static void insert(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {
		
		HisDAO dao = null;
		CondemnationDetailDAO condemnDao=null;
		String condemnNO="";
		int funcIndex=0;
		int nQueryIndex=0;
		int length=0;
		String strTemp[]=null;
		String strTemp1[]=null;
		String strItemId="";
		String strItemBrandId="";
		String strSanctionQty="";
		String strSanctionUnitId="";
		String strQuery="",maxSlno="";
		String strFileName="";
		WebRowSet web=null;
		CommitteRemarksDtlDAO committeRemarks=null;
		try
		{
				condemnDao=new CondemnationDetailDAO();
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				
				/**
				 * This function is used to generate New Condemn No
				 */
				
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_condemnNo(?,?,?)}");
				dao.setFuncInValue(funcIndex, 2, _CondemnationRegisterTransVO.getStrHospCode());
				dao.setFuncInValue(funcIndex, 3, _CondemnationRegisterTransVO.getStrItemCategoryNo());
				dao.setFuncInValue(funcIndex, 4,_CondemnationRegisterTransVO.getStrStoreId() );
				dao.setFuncOutValue(funcIndex, 1);
				dao.executeFunction(funcIndex);
				condemnNO=dao.getFuncString(funcIndex);
				
				
				strFileName=_CondemnationRegisterTransVO.getStrStoreId()+"_"+condemnNO+"_"+
							_CondemnationRegisterTransVO.getStrHospCode()+"_"+
							_CondemnationRegisterTransVO.getStrCtDate()+"."+_CondemnationRegisterTransVO.getStrFileExt();
				
				committeRemarks=new CommitteRemarksDtlDAO();
				
				
				/**
				 * This loop is used to insert remarks of member of particular committee
				 */
				
				if(_CondemnationRegisterTransVO.getStrMemberRecommendation()!=null)
					length=_CondemnationRegisterTransVO.getStrMemberRecommendation().length;
				if(length>0 )
				{
					strTemp=_CondemnationRegisterTransVO.getStrCommitteeMemberHidden()[0].replace('@', '#').split("#");
					strQuery =  "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"+
							"	where HSTNUM_COMMITTEE_NO=?"+"and GNUM_HOSPITAL_CODE=?";
					
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, strTemp[1]);
					dao.setQryValue(nQueryIndex, 2, _CondemnationRegisterTransVO.getStrHospCode());
					web = dao.executeQry(nQueryIndex);
					
					
					if(web.next())
					{
						maxSlno=web.getString(1);
					}
					for(int i=0;i<length;i++)
					{
						strTemp=_CondemnationRegisterTransVO.getStrCommitteeMemberHidden()[i].replace('@', '#').split("#");
						committeRemarks.setStrEmpCode(strTemp[0]);
						committeRemarks.setStrCommitteNo(strTemp[1]);
						committeRemarks.setStrMemberName(strTemp[2]);
						committeRemarks.setStrHospCode(_CondemnationRegisterTransVO.getStrHospCode());
						committeRemarks.setRemarks(_CondemnationRegisterTransVO.getStrMemberRecommendation()[i]);
						committeRemarks.setStrCommitteTypeId(_CondemnationRegisterTransVO.getStrCommitteType());
						committeRemarks.setStrCommRemarksSlNo(maxSlno);
						committeRemarks.insert(dao);
					}
					
				}
				/**
				 * This loop is used to insert data into condemnation dtl table. 
				 */
				condemnDao.setStrAgendaDate(_CondemnationRegisterTransVO.getStrAgendaDate());
				condemnDao.setStrAgendaNo(_CondemnationRegisterTransVO.getStrAgendaNo());
				condemnDao.setStrBankName(_CondemnationRegisterTransVO.getStrBankName());
				condemnDao.setStrBuyerId(_CondemnationRegisterTransVO.getStrBuyerName());
				condemnDao.setStrCommitteeNo(strTemp[1]);
				condemnDao.setStrCommitteeTypeId(_CondemnationRegisterTransVO.getStrCommitteType());
				condemnDao.setStrCondemnNo(condemnNO);
				condemnDao.setStrQuotationNo(_CondemnationRegisterTransVO.getStrQuotationNo());
				condemnDao.setStrCondemnType(_CondemnationRegisterTransVO.getStrCondemnationType());
				condemnDao.setStrFinancialStartDate(_CondemnationRegisterTransVO.getStrFinStartDate());
				condemnDao.setStrFinancialEndDate(_CondemnationRegisterTransVO.getStrFinStartEndDate());
				condemnDao.setStrHospitalCode(_CondemnationRegisterTransVO.getStrHospCode());
				condemnDao.setStrInstrumentAmt(_CondemnationRegisterTransVO.getStrAmountRecieved());
				condemnDao.setStrInstrumentDate(_CondemnationRegisterTransVO.getStrInstrumentDate());
				condemnDao.setStrInstrumentNo(_CondemnationRegisterTransVO.getStrInstrumentNo());
				condemnDao.setStrInstrumentType(_CondemnationRegisterTransVO.getStrPaymentMode());
				condemnDao.setStrItemCatNo(_CondemnationRegisterTransVO.getStrItemCategoryNo());
				condemnDao.setStrItemNetcost(_CondemnationRegisterTransVO.getStrItemNetCost());
				condemnDao.setStrQuotationDate(_CondemnationRegisterTransVO.getStrQuotationDate());
				condemnDao.setStrRemarks(_CondemnationRegisterTransVO.getStrRemarks());
				condemnDao.setStrSeatId(_CondemnationRegisterTransVO.getStrSeatId());
				condemnDao.setStrStoreId(_CondemnationRegisterTransVO.getStrStoreId());
				condemnDao.setStrTenderDate(_CondemnationRegisterTransVO.getStrTenderDate());
				condemnDao.setStrTenderNo(_CondemnationRegisterTransVO.getStrTenderNo());
				condemnDao.setStrMaxMemberRmksSlno(maxSlno);
				condemnDao.setStrItemId(strItemId);
				condemnDao.setStrItemBrandId(strItemBrandId);
				condemnDao.setStrSanctionQty(strSanctionQty);
				condemnDao.setStrSanctionUnitId(strSanctionUnitId);
				condemnDao.setStrWeight(_CondemnationRegisterTransVO.getStrWt());
				condemnDao.setStrFileNo(_CondemnationRegisterTransVO.getStrFileNo());
				condemnDao.setStrPageNo(_CondemnationRegisterTransVO.getStrPageNo());
				condemnDao.setStrFileName(strFileName);
				condemnDao.insertItemParameterDtls(dao);
				
				_CondemnationRegisterTransVO.setStrFileName(strFileName);
				for(int i=0 , stopI = _CondemnationRegisterTransVO.getStrItemDtlHidden().length;i<stopI;i++)
				{
					strTemp1=_CondemnationRegisterTransVO.getStrItemDtlHidden()[i].replace('@', '#').split("#");
					strItemId=strTemp1[0];
					strItemBrandId=strTemp1[1];
					strSanctionQty=strTemp1[2];
					strSanctionUnitId=strTemp1[3];
					
					
					condemnDao.setStrAgendaNo(_CondemnationRegisterTransVO.getStrAgendaNo());
					condemnDao.setStrCondemnNo(condemnNO);
					condemnDao.setStrItemId(strItemId);
					condemnDao.setStrItemBrandId(strItemBrandId);
					condemnDao.setStrSanctionQty(strSanctionQty);
					condemnDao.setStrSanctionUnitId(strSanctionUnitId);
					condemnDao.setStrSeatId(_CondemnationRegisterTransVO.getStrSeatId());
					condemnDao.setStrHospitalCode(_CondemnationRegisterTransVO.getStrHospCode());
					condemnDao.setStrCommitteeNo(strTemp[1]);
					condemnDao.setStrItemCatNo(_CondemnationRegisterTransVO.getStrItemCategoryNo());
					condemnDao.setStrStoreId(_CondemnationRegisterTransVO.getStrStoreId());
					condemnDao.update(dao);
				}
				
				synchronized (dao) {
					dao.fire();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.insert() --> "
					+ e.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		}
	
	}
	/**
	 * This function is used to fetch details of buyer list.
	 * @param _CondemnationRegisterTransVO
	 */
	
	public static void getBuyerList(CondemnationRegisterTransVO _CondemnationRegisterTransVO) {

		String strProcName = "";
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "modeval", "4");
				dao.setProcInValue(nProcIndex, "hosp_code", _CondemnationRegisterTransVO.getStrHospCode());
				dao.setProcInValue(nProcIndex, "catCode", _CondemnationRegisterTransVO.getStrItemCategoryNo());
				
				/*Start*/
				dao.setProcInValue(nProcIndex, "branditem_id", "0");
				dao.setProcInValue(nProcIndex, "contractType", "0");
				/*End*/
				
			   	dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);
				strErr = dao.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				wb = dao.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					_CondemnationRegisterTransVO.setBuyerDtlWS(wb);
					
				} else {
					throw new Exception(strErr);
				}
		} catch (Exception _Err) {
		
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getBuyerList() --> "
							+ _Err.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * return Condemnation type name
	 * @param _CondemnationRegisterTransVO
	 */
	public static void getCondemnTypeDtl(CondemnationRegisterTransVO _CondemnationRegisterTransVO){
		
		
		HisDAO dao = null;
		int funcIndex = 0;
		
		
		String condemnType="";
		try {
				dao = new HisDAO("MMS", "CondemnRegisterTransDAO");
				////System.out.println("hospCode"+_CondemnationRegisterTransVO.getStrHospCode());
				////System.out.println("condemnty"+_CondemnationRegisterTransVO.getStrCondemnationType());
				funcIndex = dao.setFunction("{? = call MMS_MST.get_Condemn_type_dtl(?,?)}");
				dao.setFuncInValue(funcIndex, 2, _CondemnationRegisterTransVO.getStrHospCode());
				dao.setFuncInValue(funcIndex, 3, _CondemnationRegisterTransVO.getStrCondemnationType());
				dao.setFuncOutValue(funcIndex, 1);
				dao.executeFunction(funcIndex);
					condemnType=dao.getFuncString(funcIndex);
					////System.out.println("condemnType:::"+condemnType);
				_CondemnationRegisterTransVO.setStrCondemnTypeName(condemnType);
				
		} catch (Exception _Err) {
			_Err.printStackTrace();
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnRegisterTransDAO.getCondemnTypeDtl() --> "
							+ _Err.getMessage());
			_CondemnationRegisterTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}


}
