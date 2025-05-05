/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.CommitteRemarksDtlDAO;
import mms.dao.QualityCheckControlDAO;
import mms.transactions.vo.QualityCheckControlTransVO;

/**
 * Developer : Tanvi Sappal
 * Date : 04/Jun/2009
 * Version : 1.0
 *
 */
public class QualityCheckControlTransDAO {
	
	/**
	 * for getting option value of Store Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void storeName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";//4+3=7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","1");
			daoObj.setProcInValue(nProcIndex, "storeid","0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0");
		    /* End Adding Default value*/
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStoreNameComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDrugNameCmb(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_list(?,?,?,?,?,?,?)}"; //7 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemCatg", "0");
			daoObj.setProcInValue(nProcIndex, "reSendFlg", vo.getStrReSendFlg());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setWsDrugNameCombo(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.getDrugNameCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	

	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getLabNameCmb(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Lab_list(?,?,?,?,?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			hisutil    = new HisUtil("mms", "QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			String str;
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, "","0^SelectValue", true);
					vo.setStrLabNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrLabNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getLabNameCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryNo(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}"; //5+1=6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.setProcInValue(nProcIndex, "reqType", "0"); // Default set for reqType
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.itemCategoryNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Group Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void groupName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}"; //5+2=7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCategoryNo());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "");
			daoObj.setProcInValue(nProcIndex, "strStoreId", "");
			/* End Adding Default value*/
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setGroupComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.groupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of SubGroup Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void subGroupName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_subgroup_list(?,?,?,?,?)}"; //5
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "GROUP_ID", vo.getStrGroupId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setSubGroupCmboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.subGroupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Generic Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void genItemName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_list(?,?,?,?,?,?,?)}"; //7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgroup_id", vo.getStrSubGroupId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setGenericItemNameComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.genItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_storeitem_brand_list(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "group_id", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "sub_group_id", vo.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrGenericItemId());
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemBrandNameComboWS(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.itemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDrugBatchCmb(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_Batch_list(?,?,?,?,?,?,?)}"; //7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			
			daoObj=new HisDAO("Gifted Item Details","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemBrandId", vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "reSendFlg", vo.getStrReSendFlg());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
					
				  vo.setBatchNoSerialNoComboWS(ws);
				 
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getDrugBatchCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void batchNo(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchno_list(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
//			//System.out.println("cat_no"+vo.getStrItemCategoryNo());
//			//System.out.println("gen Item id:::"+vo.getStrGenericItemId());
//			//System.out.println("Item Brand Id:::"+vo.getStrItemBrandId());
//			//System.out.println("Store ID:::"+vo.getStrStoreId());
//		//	//System.out.println(""+);
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenericItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatusCode());
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setBatchNoSerialNoComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.batchNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void serialNo(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchno_list(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenericItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatusCode());
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemSlNoWS(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.serialNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
		/**
	 * This function is used to fetch details for committee type combo.
	 * @param vo
	 */
	public static void setCommitteeTypeDtl(QualityCheckControlTransVO vo)
	{
		String strproc_name = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}"; //6
		
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "QualityCheckControlTransDAO");
			
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modeval","1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "reqType", "66");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2); 
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				vo.setCommitteTypeWS(wb);
			 } else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			vo.setStrMsgString("QualityCheckControlTransDAO.setCommitteeTypeDtl() --> "
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
	 * This function is used to fetch details for member detail combo
	 * @param vo
	 */
	
	public static void getMemberDtl(QualityCheckControlTransVO vo) {
		
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
				////System.out.println("categNo"+vo.getStrItemCategoryNo());
				dao = new HisDAO("mms", "QualityCheckControlTransDAO");
				strproc_name = "{call Pkg_Mms_View.mms_commitee_member_dtl(?,?,?,?,?,?,?)}";//5+2=7
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "commiteeTypeId",vo.getStrCommitteeTypeId());
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				
				/* Start Adding Default value*/
				dao.setProcInValue(nprocIndex, "modval","1");
				dao.setProcInValue(nprocIndex, "commNo","");
				/* End Adding Default value*/
				
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					vo.setCommitteMemberWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.getMemberDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	}
	
	public static void unitName(QualityCheckControlTransVO  vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("QualityCheckControlTrans", "SampleSentTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?, ?, ?, ?)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "1");			
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strUnitRate = daoObj.getFuncString(nFuncIndex);
			
			vo.setStrUnitRateID(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", strUnitRate);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "module_id", "");//Aritra
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setUnitNameWS(ws);

			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To insert the value into the Database
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void insertNew(QualityCheckControlTransVO vo)
	{
		
		HisDAO daoObj=null;
		
		
		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";
		String strProcName4 = "";
		int funcIndex = 0 ;
		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		int nProcIndex4 = 0;
		String strTempLabSendNo = "";
		boolean flag = false;
		
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_LabSend_no(?,?,?,?,?,?)}");
  		    /* Set Value */
       		daoObj.setFuncInValue(funcIndex,2,"1");
//       		//System.out.println("Lab No==>"+vo.getStrLabId().split("\\^")[0]);
//       		//System.out.println("Store ID==>"+vo.getStrStoreId());
//       		//System.out.println("HospCode==>"+vo.getStrHospitalCode());
       		daoObj.setFuncInValue(funcIndex,3,vo.getStrLabId().split("\\^")[0]);
       		daoObj.setFuncInValue(funcIndex,4,"73");
       		daoObj.setFuncInValue(funcIndex,5,vo.getStrStoreId());
       		daoObj.setFuncInValue(funcIndex,6,"10");
       		daoObj.setFuncInValue(funcIndex,7,vo.getStrHospitalCode());
       		daoObj.setFuncOutValue(funcIndex,1);
  		    /* Execute Function */
       		daoObj.executeFunction(funcIndex);
       		  					 			
  			strTempLabSendNo = daoObj.getFuncString(funcIndex);  
  			//System.out.println("Lab Send No==>"+strTempLabSendNo);  	
  			
  			vo.setStrLabSendNo(strTempLabSendNo);
			/*
			 1.Batch No
			 2. 0
			 3.Inhand Qty With Unit
			 4.PO NO
			 5.PO Date
			 6.Mfd Date
			 7. MfgSupplier Id
			 8.In Hand Qty
			 9.Inhand Qty Unit
			 10.Supplier Name
			 11.Manuf Date
			 12.Exp Date
			 13.Item Id
			 14.Item Brand Id 
			 15.Stock Status
			 16.Rate
			 17.Rate Unit Id
			 18.Supplier ID
			 19.Group ID
			 20.Sub Grp ID
			 21.Sale Price
			 22.Sale Price Unit
			 23.Receive Date
			 24.Currency Id
			 25.Current Value
			 26.Specification
			 27.Bill Date
			 28.Bill No
			 
			 * */
  			
  			//009^0^38499 No.^259^24-Jun-2011^/^0^38499^6301^M/S Rajasthan Drugs And Pharmaceutical Ltd Jaipur^01-Jul-2011^30-Jun-2013^10000069^10100069^10^0^6301^1010024^101001^0^^6301^28-Aug-2011^100^1^Tab. 400mg^00088^23-Aug-2011
  			
  			strProcName3 = "{call PKG_MMS_DML.proc_HSTT_QC_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 44 Varibale's
			    
	        nProcIndex3 = daoObj.setProcedure(strProcName3);			
	              
			daoObj.setProcInValue(nProcIndex3, "p_mode", "3");                                    	     //1
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_ID", vo.getStrBatchDtl().split("\\^")[12]);          	     //2
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID",vo.getStrStoreId());  	     //3
			
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_SEND_NO", strTempLabSendNo);            	         //4
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",vo.getStrBatchDtl().split("\\^")[13]);            	     //5
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_SL_NO",vo.getStrBatchDtl().split("\\^")[0]);        	     //6
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_LAB_SEND_DATE",vo.getStrLabSendDate());              //7
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_ITEM_SL_NO","0");    		 //8
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_REPORT_DATE",vo.getStrCurrentDate());      	 	 //9   
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STOCK_STATUS_CODE",vo.getStrBatchDtl().split("\\^")[14]);         		 //10
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_NO",vo.getStrLabId().split("\\^")[0]);    	  	 //11
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",	vo.getStrHospitalCode());         		 //12
			daoObj.setProcInValue(nProcIndex3, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCategoryNo());  	 		//13
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY",vo.getStrBatchDtl().split("\\^")[7]);      	 //14
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY_UNITID",vo.getStrBatchDtl().split("\\^")[8]); 	 //15
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY",vo.getStrConsumedQty());       				   //16
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY_UNITID",vo.getStrConsumedQtyUnitId().split("\\^")[0]);    				 //17
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PO_NO", vo.getStrBatchDtl().split("\\^")[3]);     //18
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE",vo.getStrBatchDtl().split("\\^")[15]);   //19
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_PO_DATE",vo.getStrBatchDtl().split("\\^")[4]); //20
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",vo.getStrBatchDtl().split("\\^")[16]); 			//21
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_MFG_DATE",vo.getStrBatchDtl().split("\\^")[10]);			 //22
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",vo.getStrBatchDtl().split("\\^")[17]); 				//23
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_MANUFACTURER_ID",vo.getStrBatchDtl().split("\\^")[6]); 				//24
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE",vo.getStrBatchDtl().split("\\^")[11]); //25
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FINAL_RESULT",vo.getStrFinalResult()); //26  
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_STATUS",vo.getStrItemStatus()); 			//27  Check It
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_SAMPLE_CODE_NO",vo.getStrSampleCodeNumber());			 //28
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_CTR_NO",vo.getStrCTRNumber()); 				//29
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_START_DATE",vo.getStrFinancialStartYear()); 				//30
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_END_DATE",vo.getStrFinancialEndYear()); //31
			daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE",vo.getStrCurrentDate()); 				//32
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_ONLINE_PROCESS","0"); //33
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId()); //34
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_LAB_INCHARGE_NAME",vo.getStrLabInchargeName()); 				//35  
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID","1"); //36
			daoObj.setProcInValue(nProcIndex3, "p_GSTR_SEND_REAMRKS",""); //37
			daoObj.setProcInValue(nProcIndex3, "p_GSTR_RECEIVE_REAMRKS",vo.getStrRemarks()); 				//38
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NO",vo.getStrFileNo()); //39   
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PAGE_NO",vo.getStrPageNo()); 				//40    
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_RESEND",vo.getStrResendFlag()); //41
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NAME",vo.getStrFileName()); //42   
			daoObj.setProcInValue(nProcIndex3, "p_description",vo.getStrDescription()); //43				
			daoObj.setProcOutValue(nProcIndex3, "err", 1);                         //44
			daoObj.execute(nProcIndex3, 1);
			
			
			
			synchronized (daoObj) 
			{
				daoObj.fire();
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.insertNew() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}	
	
	
	/**
	 * To insert the value into the Database
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public  synchronized static void insertWithNewProcedure(QualityCheckControlTransVO vo)
	{
		
		HisDAO daoObj=null;
		
		
		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";
		String strProcName4 = "";
		int funcIndex = 0 ;
		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		int nProcIndex4 = 0;
		String strTempLabSendNo = "";
		HisUtil hisutil=null;
		boolean flag = false;
		String strCurrentDate;
		
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_LabSend_no(?,?,?,?,?,?)}");
			hisutil=new HisUtil("mms", "QualityCheckControlTransDATA");
  		    /* Set Value */
       		daoObj.setFuncInValue(funcIndex,2,"1");
//       		//System.out.println("Lab No==>"+vo.getStrLabId().split("\\^")[0]);
//       		//System.out.println("Store ID==>"+vo.getStrStoreId());
//       		//System.out.println("HospCode==>"+vo.getStrHospitalCode());
       		daoObj.setFuncInValue(funcIndex,3,vo.getStrLabId().split("\\^")[0]);
       		daoObj.setFuncInValue(funcIndex,4,"73");
       		daoObj.setFuncInValue(funcIndex,5,vo.getStrStoreId());
       		daoObj.setFuncInValue(funcIndex,6,"10");
       		daoObj.setFuncInValue(funcIndex,7,vo.getStrHospitalCode());
       		daoObj.setFuncOutValue(funcIndex,1);
  		    /* Execute Function */
       		daoObj.executeFunction(funcIndex);
       		strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
       		  					 			
  			strTempLabSendNo = daoObj.getFuncString(funcIndex);  
  			////System.out.println("Lab Send No==>"+strTempLabSendNo);  	
  			
  			vo.setStrLabSendNo(strTempLabSendNo);
			/*
			 1.Batch No
			 2. 0
			 3.Inhand Qty With Unit
			 4.PO NO
			 5.PO Date
			 6.Mfd Date
			 7. MfgSupplier Id
			 8.In Hand Qty
			 9.Inhand Qty Unit
			 10.Supplier Name
			 11.Manuf Date
			 12.Exp Date
			 13.Item Id
			 14.Item Brand Id 
			 15.Stock Status
			 16.Rate
			 17.Rate Unit Id
			 18.Supplier ID
			 19.Group ID
			 20.Sub Grp ID
			 21.Sale Price
			 22.Sale Price Unit
			 23.Receive Date
			 24.Currency Id
			 25.Current Value
			 26.Specification
			 27.Bill Date
			 28.Bill No			 
			 * */  			
  			//009^0^38499 No.^259^24-Jun-2011^/^0^38499^6301^M/S Rajasthan Drugs And Pharmaceutical Ltd Jaipur^01-Jul-2011^30-Jun-2013^10000069^10100069^10^0^6301^1010024^101001^0^^6301^28-Aug-2011^100^1^Tab. 400mg^00088^23-Aug-2011
  			strProcName3 = "{call PKG_MMS_DML.dml_quality_check_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 48 Varibale's
			nProcIndex3 = daoObj.setProcedure(strProcName3);			
	      	daoObj.setProcInValue(nProcIndex3, "p_mode", "1");                                    	     //1
	        daoObj.setProcInValue(nProcIndex3, "p_reqtypeid",vo.getStrRequestType());          	     //2
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_ID", vo.getStrBatchDtl().split("\\^")[12]);          	     //3
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID",vo.getStrStoreId());  	     //4
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_SEND_NO", strTempLabSendNo);            	         //5
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",vo.getStrBatchDtl().split("\\^")[13]);            	     //6
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_SL_NO",vo.getStrBatchDtl().split("\\^")[0]);        	     //7
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_LAB_SEND_DATE",vo.getStrCurrentDate());              //8
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_ITEM_SL_NO","0");    		 //9
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_REPORT_DATE",vo.getStrReportDate());      	 	 //10   
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STOCK_STATUS_CODE",vo.getStrBatchDtl().split("\\^")[14]);         		 //11
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_LAB_NO",vo.getStrLabId().split("\\^")[0]);    	  	 //12
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",	vo.getStrHospitalCode());         		 //13
			daoObj.setProcInValue(nProcIndex3, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCategoryNo());  	 		//14
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY",vo.getStrBatchDtl().split("\\^")[7]);      	 //15
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_INHAND_QTY_UNITID",vo.getStrBatchDtl().split("\\^")[8]); 	 //16
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY",vo.getStrConsumedQty());       				   //17
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_CONSUMED_QTY_UNITID",vo.getStrConsumedQtyUnitId().split("\\^")[0]);//18    				 //17
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PO_NO", (vo.getStrBatchDtl().split("\\^")[3]==null ||vo.getStrBatchDtl().split("\\^")[3].equals("") || vo.getStrBatchDtl().split("\\^")[3].equals("---"))?"0":vo.getStrBatchDtl().split("\\^")[3]);     //19
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE",vo.getStrBatchDtl().split("\\^")[15]);   //20
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_PO_DATE",(vo.getStrBatchDtl().split("\\^")[4]==null ||vo.getStrBatchDtl().split("\\^")[4].equals("") || vo.getStrBatchDtl().split("\\^")[4].equals("---"))?strCurrentDate:vo.getStrBatchDtl().split("\\^")[4]); //21
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",vo.getStrBatchDtl().split("\\^")[16]); 			//22
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_MFG_DATE",vo.getStrBatchDtl().split("\\^")[10]);			 //23
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",vo.getStrBatchDtl().split("\\^")[17]); 			//24
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_MANUFACTURER_ID",vo.getStrBatchDtl().split("\\^")[6]); 				//25
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE",vo.getStrBatchDtl().split("\\^")[11]); //26
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FINAL_RESULT",vo.getStrFinalResult()); //27  
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEM_STATUS",vo.getStrItemStatus()); 			//28  Check It
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_SAMPLE_CODE_NO",vo.getStrSampleCodeNumber());			 //29
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_CTR_NO",vo.getStrCTRNumber()); 				//30
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_START_DATE",vo.getStrFinancialStartYear()); 				//31
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_FINANCIAL_END_DATE",vo.getStrFinancialEndYear()); //32
			daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE",vo.getStrCurrentDate()); 				//33
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_ONLINE_PROCESS","0"); //34
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId()); //35
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_LAB_INCHARGE_NAME",vo.getStrLabInchargeName()); 				//36  
			daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID","1"); //37
			daoObj.setProcInValue(nProcIndex3, "p_GSTR_SEND_REAMRKS",""); //38
			daoObj.setProcInValue(nProcIndex3, "p_GSTR_RECEIVE_REAMRKS",vo.getStrRemarks()); 				//39
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NO",vo.getStrFileNo()); //40   
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PAGE_NO",vo.getStrPageNo()); 				//41    
			daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_IS_RESEND",vo.getStrResendFlag()); //42
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_FILE_NAME",vo.getStrFileName()); //43   
			daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_REPORT_NO",vo.getStrReportNumber()); //44  
			daoObj.setProcInValue(nProcIndex3, "p_HSTDT_RPT_RECEIVED_DATE",vo.getStrReceiveDate()); //45			
			daoObj.setProcInValue(nProcIndex3, "p_description3",vo.getStrDescription()); //46
			daoObj.setProcInValue(nProcIndex3, "p_description1",vo.getStrDescription()); //47	
			daoObj.setProcOutValue(nProcIndex3, "err", 1);                         //48
			daoObj.execute(nProcIndex3, 1);
		
			//synchronized (daoObj) 
			//{
				daoObj.fire();
				
			//}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.insertWithNewProcedure() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}	
	
	
	public static void updateCurrStock(QualityCheckControlTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		try 
		{
			dao = new HisDAO("mms", "QualityCheckControlTransDAO");
			strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?,?,?,?,?,?,?)}"; // 11 variables
				
//			//System.out.println("Store ID==>"+vo.getStrStoreId());
//			//System.out.println("Item Id==>"+vo.getStrBatchDtl().split("\\^")[12]);
//			//System.out.println("Item Brand==>"+vo.getStrBatchDtl().split("\\^")[13]);
//			//System.out.println("Hosp Code==>"+vo.getStrHospitalCode());
//			//System.out.println("Batch No==>"+ vo.getStrBatchDtl().split("\\^")[0]);
//			//System.out.println("Stock Status==>"+vo.getStrBatchDtl().split("\\^")[14]);
			
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex,  "modval", "2");                 //1
			dao.setProcInValue(nprocIndex,  "strid", vo.getStrStoreId());   //2
			dao.setProcInValue(nprocIndex,  "itemid", vo.getStrBatchDtl().split("\\^")[12]);   //3
			dao.setProcInValue(nprocIndex,  "itembrandid", vo.getStrBatchDtl().split("\\^")[13]);//4
			dao.setProcInValue(nprocIndex,  "batchno", vo.getStrBatchDtl().split("\\^")[0]);        //5
			dao.setProcInValue(nprocIndex,  "hosp_code", vo.getStrHospitalCode()); //6
			dao.setProcInValue(nprocIndex,  "item_cat_no", "10");//7
			dao.setProcInValue(nprocIndex,  "stockstatuscode", vo.getStrBatchDtl().split("\\^")[14]);        //8
			dao.setProcInValue(nprocIndex,  "rackNumber", "");//9
			dao.setProcInValue(nprocIndex,  "old_itemserialno", "0");//10
			dao.setProcOutValue(nprocIndex, "err", 1);//11
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * To insert the value into the Database
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void insert(QualityCheckControlTransVO vo)
	{
		
		HisDAO dao=null;
		String strProcName = "";
		int nProcIndex = 0;
		String strProcName2 = "";
		//int nProcIndex2 = 0;
		//String strSerialNo = "";
		QualityCheckControlDAO qualityCheckDAO = null;
		String strCommitteeNo="";
		String maxSlno = "0";
		CommitteRemarksDtlDAO committeeRemarksDtlDao = null;
		
		
		try
		{
			dao=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			qualityCheckDAO = new QualityCheckControlDAO();
			committeeRemarksDtlDao = new CommitteRemarksDtlDAO();
			
		/*	strFuncName = "{? = call generate_quality_slno(?,?,?,?,?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
		
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrGenericItemId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrBatchNo());
			dao.setFuncInValue(nFuncIndex, 6, vo.getStrItemSerailNo());
			dao.setFuncInValue(nFuncIndex, 7, vo.getStrStockStatusCode());
			dao.setFuncInValue(nFuncIndex, 8, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strSerialNo = dao.getFuncString(nFuncIndex);*/
			
			
			if(vo.getStrConsumedQty() == null || vo.getStrConsumedQty().trim().length() == 0 ){
				
				vo.setStrConsumedQty("0");
				vo.setStrConsumedQtyUnitId("0");
				
			}
			
			
			qualityCheckDAO.setStrStoreId(vo.getStrStoreId());
			qualityCheckDAO.setStrGenericItemId(vo.getStrGenericItemId());
			qualityCheckDAO.setStrItemBrandId(vo.getStrItemBrandId());
			////System.out.println("dao vo.getStrBatchNo()-"+vo.getStrBatchNo());
			qualityCheckDAO.setStrBatchNo(vo.getStrBatchNo());
			qualityCheckDAO.setStrItemSerailNo(vo.getStrItemSerailNo());
			qualityCheckDAO.setStrStockStatusCode(vo.getStrStockStatusCode());
			qualityCheckDAO.setStrHospitalCode(vo.getStrHospitalCode());
			qualityCheckDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());
			qualityCheckDAO.setStrGroupId(vo.getStrGroupId());
			qualityCheckDAO.setStrSubGroupId(vo.getStrSubGroupId());
			qualityCheckDAO.setStrInhandQty(vo.getStrInhandQty());
			qualityCheckDAO.setStrInhandQtyUnitId(vo.getStrInhandQtyUnitId());
			
			//if(vo.getStrIsConsumableFlag().equals("1")){
				qualityCheckDAO.setStrConsumedQty(vo.getStrConsumedQty());
				qualityCheckDAO.setStrConsumedQtyUnitId(vo.getStrConsumedQtyUnitId());
			//}
			
			qualityCheckDAO.setStrPONo(vo.getStrPONo());
			qualityCheckDAO.setStrPODate(vo.getStrPODate());
			qualityCheckDAO.setStrSupplierId(vo.getStrSupplierId());
			
			qualityCheckDAO.setStrFinalResult(vo.getStrFinalResult());
			qualityCheckDAO.setStrItemStatus(vo.getStrItemStatus());
			qualityCheckDAO.setStrFileQualityName("");
			qualityCheckDAO.setStrFileNo(vo.getStrFileNo());
			qualityCheckDAO.setStrPageNo(vo.getStrPageNo());
						
		
			int length=vo.getStrMemberRecommendation().length;
            if(length>0 )
            {
            	String[] strTemp=vo.getStrCommitteeMemberHidden()[0].replace('@', '#').split("#");
            	strCommitteeNo=strTemp[1];
            	
                String strQuery =  "select nvl(max(HSTNUM_COMM_RMKS_SLNO),0)+1 from HSTT_COMMITTEE_REMARKS_DTL"+
                	"     where HSTNUM_COMMITTEE_NO=?"+"and GNUM_HOSPITAL_CODE=?";
                int nQueryIndex = dao.setQuery(strQuery);
                dao.setQryValue(nQueryIndex, 1, strTemp[1]);
                dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
                WebRowSet web = dao.executeQry(nQueryIndex);
                if(web.next())
                {
                     maxSlno=web.getString(1);
                }
               for(int i=0;i<length;i++)
               {
                  strTemp = vo.getStrCommitteeMemberHidden()[i].replace('@', '#').split("#");                              	
                  committeeRemarksDtlDao.setStrCommitteNo(strTemp[1]);
                  committeeRemarksDtlDao.setRemarks(vo.getStrMemberRecommendation()[i]);
                  committeeRemarksDtlDao.setStrCommitteTypeId(vo.getStrCommitteeTypeId());
                  committeeRemarksDtlDao.setStrCommRemarksSlNo(maxSlno);
                  committeeRemarksDtlDao.setStrEmpCode(strTemp[0]);
                  committeeRemarksDtlDao.setStrHospCode(vo.getStrHospitalCode());
                  committeeRemarksDtlDao.setStrMemberName(strTemp[2]);
                  committeeRemarksDtlDao.setStrChairPersonFlag(strTemp[3]);
                  //committeeRemarksDtlDao.insert(dao);
               }
             }
			if(vo.getStrItemStatus().equals("2")){
			if(vo.getStrDistributionFlag().equals("1") && vo.getStrConsumedQty().equals("0")){
				strProcName = "{call pkg_mms_view.Proc_Select_StopDistribution(?,?,?,?,?,?,?,?,?,?)}"; //10
				nProcIndex = dao.setProcedure(strProcName);
				
				if(vo.getStrItemCategoryNo().equals("1")){
					dao.setProcInValue(nProcIndex, "modval", "1");
									
					dao.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
					dao.setProcInValue(nProcIndex, "item_id", vo.getStrGenericItemId());
					dao.setProcInValue(nProcIndex, "itembrand_id ", vo.getStrItemBrandId());
					dao.setProcInValue(nProcIndex, "batch_sl_no", vo.getStrBatchNo());
					dao.setProcInValue(nProcIndex, "item_sl_no", "0");
					dao.setProcInValue(nProcIndex, "hospital_code", vo.getStrHospitalCode());
					dao.setProcInValue(nProcIndex, "stock_status_code", vo.getStrStockStatusCode());
					dao.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());	
				}else{
					dao.setProcInValue(nProcIndex, "modval", "1");
					dao.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
					dao.setProcInValue(nProcIndex, "item_id", vo.getStrGenericItemId());
					dao.setProcInValue(nProcIndex, "itembrand_id ", vo.getStrItemBrandId());
					/*//System.out.println("vo.getStrBatchNo()-"+vo.getStrBatchNo());
					//System.out.println("vo.getStrItemSerailNo()-"+vo.getStrItemSerailNo());*/
					dao.setProcInValue(nProcIndex, "batch_sl_no", vo.getStrBatchNo());
					dao.setProcInValue(nProcIndex, "item_sl_no", vo.getStrItemSerailNo());
					dao.setProcInValue(nProcIndex, "hospital_code", vo.getStrHospitalCode());
					dao.setProcInValue(nProcIndex, "stock_status_code", vo.getStrStockStatusCode());
					dao.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
				}
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.execute(nProcIndex, 1);
				
				}
			}
			if(strCommitteeNo==null||strCommitteeNo.equals(""))
			{
				strCommitteeNo="0";
			}
			qualityCheckDAO.setStrDistributionFlag(vo.getStrDistributionFlag());
			qualityCheckDAO.setStrFinStartDate(vo.getStrFinStartDate());
			qualityCheckDAO.setStrFinEndDate(vo.getStrFinEndDate());
			qualityCheckDAO.setStrSeatId(vo.getStrSeatId());
			qualityCheckDAO.setStrIsValid(vo.getStrIsValid());
			qualityCheckDAO.setStrCommitteeNo(strCommitteeNo);
			qualityCheckDAO.setStrCommitteeTypeId(vo.getStrCommitteeTypeId());
			qualityCheckDAO.setStrCommRemarksSlNo(maxSlno);
			qualityCheckDAO.setStrRemarks(vo.getStrRemarks());
			qualityCheckDAO.insert(dao);
			////System.out.println("vo.getStrConsumedQty()"+vo.getStrConsumedQty());
			if(vo.getStrConsumedQty()!=null && vo.getStrConsumedQty().trim().length() > 0){
				
				if(Integer.parseInt(vo.getStrConsumedQty()) > 0){ 
				
				strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //18+36=54
				nProcIndex = dao.setProcedure(strProcName2);
			
				dao.setProcInValue(nProcIndex, "modval", "3");
				dao.setProcInValue(nProcIndex, "old_strid", vo.getStrStoreId());
				dao.setProcInValue(nProcIndex, "old_itemid", vo.getStrGenericItemId());
				dao.setProcInValue(nProcIndex, "old_itembrandid", vo.getStrItemBrandId());
				dao.setProcInValue(nProcIndex, "old_batchno", vo.getStrBatchNo());
				dao.setProcInValue(nProcIndex, "old_stockstatuscode",vo.getStrStockStatusCode());
				
				dao.setProcInValue(nProcIndex, "description", "Consumed from Store:"+vo.getStrStoreName());
				
				dao.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
				dao.setProcInValue(nProcIndex, "itemid", vo.getStrGenericItemId());
				dao.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "itemcatno",vo.getStrItemCategoryNo());
				dao.setProcInValue(nProcIndex, "inhandqty", vo.getStrConsumedQty());
				dao.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrConsumedQtyUnitId());
				dao.setProcInValue(nProcIndex, "reservedFlag", vo.getStrReservedFlag());
				dao.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
				
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "retSerialNo", 1);
				
				/* Start Adding Default value*/
				dao.setProcInValue(nProcIndex, "batchno","0");
				dao.setProcInValue(nProcIndex, "groupid","");
				dao.setProcInValue(nProcIndex, "subgroupid","0");
				dao.setProcInValue(nProcIndex, "expirydate","");
				dao.setProcInValue(nProcIndex, "manufdate","");
				dao.setProcInValue(nProcIndex, "stockstatuscode","1");
				dao.setProcInValue(nProcIndex, "inventoryflag","");
				dao.setProcInValue(nProcIndex, "suppid","");    
				dao.setProcInValue(nProcIndex, "rate","0");
				dao.setProcInValue(nProcIndex, "rateunitid","");
				dao.setProcInValue(nProcIndex, "saleprice","0");
				dao.setProcInValue(nProcIndex, "salepriceunitid","");
				dao.setProcInValue(nProcIndex, "pono","");
				dao.setProcInValue(nProcIndex, "podate","");
				dao.setProcInValue(nProcIndex, "suppliedby","");
				dao.setProcInValue(nProcIndex, "recieveddate","");
				dao.setProcInValue(nProcIndex, "currencycode","");
				dao.setProcInValue(nProcIndex, "freeitemflag","0");
			    dao.setProcInValue(nProcIndex, "currencyvalue","0");
			    dao.setProcInValue(nProcIndex, "old_itemserialno","0");
			      dao.setProcInValue(nProcIndex, "itemparamflag","0");
			      dao.setProcInValue(nProcIndex, "partflag","0");
			      dao.setProcInValue(nProcIndex, "warrentyflag","0");
			      dao.setProcInValue(nProcIndex, "tostrid","");
			      dao.setProcInValue(nProcIndex, "transno","0");
			      dao.setProcInValue(nProcIndex, "transdate","");
			dao.setProcInValue(nProcIndex, "reqtypeid","0");  
			dao.setProcInValue(nProcIndex, "blockqtyflag","0"); 
			      dao.setProcInValue(nProcIndex, "blockedqty","0");
			      dao.setProcInValue(nProcIndex, "blockedqtyunitid","0");
			      dao.setProcInValue(nProcIndex, "releaseqty","0"); 
			      dao.setProcInValue(nProcIndex, "releaseqtyunitid","0"); 
			      dao.setProcInValue(nProcIndex, "invoiceNo","");
			      dao.setProcInValue(nProcIndex, "invoiceDate","");
			      dao.setProcInValue(nProcIndex, "item_serialNoFlag","1");
			      dao.setProcInValue(nProcIndex, "item_specification","");
			      /* End Adding Default value*/
				
				dao.execute(nProcIndex, 1);
				}
			}
			
			synchronized (dao) {
				dao.fire();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}	

	/**
	 * for getting option value of Item Category Name on View page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategory(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";//5+1=6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.setProcInValue(nProcIndex, "reqType", "0");	//default set for reqType
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Store Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getStoreName(QualityCheckControlTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","1");
			daoObj.setProcInValue(nProcIndex, "storeid","0"); 
			daoObj.setProcInValue(nProcIndex, "storetype_id","0");
		   /* End Adding Default value*/
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStoreNameWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("QualityCheckControlTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	
	
	/**
	 * for Existing value of Item Category on View page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void goView(QualityCheckControlTransVO vo)
	{
		//String strProcName = "{call pkg_mms_view.proc_quality_check_view_dtls(?,?,?,?,?,?,?,?)}"; //8
		  String strProcName = "{call pkg_mms_view.Proc_SampleSent_Detail(?,?,?,?,?,?,?,?,?)}"; //9
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","QualityCheckControlTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "2");
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_strId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_catgNo", "10");
			daoObj.setProcInValue(nProcIndex, "p_frmdate", vo.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "p_todate", vo.getStrToDate());
			daoObj.setProcInValue(nProcIndex, "p_labNo", "0");
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
//			daoObj.setProcInValue(nProcIndex, "modeval",    "1");
//			daoObj.setProcInValue(nProcIndex, "itemcat",    vo.getStrItemCategoryNo());
//			daoObj.setProcInValue(nProcIndex, "start_date", vo.getStrFinStartDate());
//			daoObj.setProcInValue(nProcIndex, "end_date",   vo.getStrFinEndDate());
//			daoObj.setProcInValue(nProcIndex, "hosp_code",  vo.getStrHospitalCode());
//			daoObj.setProcInValue(nProcIndex, "store_id",   vo.getStrStoreId());
//			daoObj.setProcOutValue(nProcIndex, "err",1); 
//			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) 
			{
				vo.setQualityViewWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("QualityCheckControlTransDAO.goView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

}
