package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.GroupItemAltMstVO;

/**
 * The Class ComponentMstDAO.
 * 
 * @author amit kumar ateria
 */

public class GroupItemAltMstDAO 
{
	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */
	public static void comboQuery(GroupItemAltMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		try 
		{
			dao = new HisDAO("mms", "GroupItemAltMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.1").replace("?", Config.SUPER_USER_HOSPITAL_CODE);
			/*strquery = strquery.concat(mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.2"));
			strquery=strquery.replace("#", vo.getStrHospitalCode());
			strquery=strquery.replace("?", vo.getStrSeatId());*/
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemCategoryCmbWs(wb);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GroupItemAltMstDAO.comboQuery()"+ e.getMessage());vo.setStrMsgType("1");
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
	
	/**
	 * for getting option value of existing items combo on add page.
	 * 
	 * @param vo the vo
	 */

	public static void getExGroup(GroupItemAltMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		try 
		{
			dao = new HisDAO("mms", "GroupItemAltMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.3").replace("?", vo.getStrHospitalCode());
			strquery = strquery.concat(mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.4"));
			strquery=strquery.replace("?", vo.getStrItemCat());
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setExGroupCmbWs(wb);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("--> GroupItemAltMstDAO.comboQuery()-->"+ e.getMessage());vo.setStrMsgType("1");
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
	/**
	 * for getting option value of replaced sub group combo on add page.
	 * 
	 * @param vo the vo
	 */

	public static void getRpSubGroup(GroupItemAltMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "GroupItemAltMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.5");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrRpGroupId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setRpSubGroupCmbWs(wb);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GroupItemAltMstDAO.getRpSubGroup()-->"+ e.getMessage());vo.setStrMsgType("1");
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
	/**
	 * for getting option value of existing item combo on add page.
	 * 
	 * @param vo the vo
	 */

	public static void getExItems(GroupItemAltMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "GroupItemAltMstDAO");
			if(vo.getStrExGroupId().substring(0,2).equals("10"))
				strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.6");
			else
				strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.8");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrExGroupId());			
			wb = dao.executeQry(nqryIndex);
			vo.setLeftItemListWS(wb);
			if(vo.getStrExGroupId().substring(0,2).equals("10"))
				strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.7");
			else
				strquery = mms.qryHandler_mms.getQuery(1,"select.groupitemaltmst.9");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrExGroupId());			
			wb = dao.executeQry(nqryIndex);
			vo.setLeftNewItemListWS(wb);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("GroupItemAltMstDAO.getExItems()-->"+ e.getMessage());vo.setStrMsgType("1");
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
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public static void insertQuery(GroupItemAltMstVO vo)
	{
		HisDAO daoObj = null;
		int nprocIndex=0;
		int nprocIndex1=0;
		String strErr="";
		String concatItemId="";;
		try 
		{
			daoObj = new HisDAO("mms","GroupItemAltMstDAO");
			String proc_name = "{call PKG_MMS_DML.dml_group_change_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
			if(vo.getStrRightItemIds()!=null)
			{
				for(int i = 0;i<vo.getStrRightItemIds().length; i++)
				{
					if(i==0)
						concatItemId=vo.getStrRightItemIds()[i];
					else
					concatItemId+=","+vo.getStrRightItemIds()[i];
				}
			}
			if(vo.getStrRightNewItemIds()!=null)
			{
				for(int i = 0;i<vo.getStrRightNewItemIds().length; i++)
				{
					concatItemId+=","+vo.getStrRightNewItemIds()[i];
				}
			}
			if(vo.getStrRightItemIds()!=null)
			{
				for(int i = 0;i<vo.getStrRightItemIds().length; i++)
				{			
					nprocIndex = daoObj.setProcedure(proc_name);
					daoObj.setProcInValue(nprocIndex, "modval", "1",1);
					daoObj.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
					daoObj.setProcInValue(nprocIndex, "itemCatNo", vo.getStrItemCat(),3);
					daoObj.setProcInValue(nprocIndex, "oldGroupId", vo.getStrExGroupId(),4);
					daoObj.setProcInValue(nprocIndex, "newGroupId", vo.getStrRpGroupId(),5);
					daoObj.setProcInValue(nprocIndex, "newSubGrpId", vo.getStrRpSubGroupId(),6);
					daoObj.setProcInValue(nprocIndex, "itemId", vo.getStrRightItemIds()[i],7);
					daoObj.setProcInValue(nprocIndex, "remarks", vo.getStrRemarks(),8);
					daoObj.setProcInValue(nprocIndex, "seatId", vo.getStrSeatId(),9);
					daoObj.setProcInValue(nprocIndex, "conItemId", concatItemId,10);
					daoObj.setProcOutValue(nprocIndex, "err", 1,11);	
					daoObj.execute(nprocIndex, 1);
				}
			}
			if(vo.getStrRightNewItemIds()!=null)
			{
				for(int i = 0;i<vo.getStrRightNewItemIds().length; i++)
				{			
					nprocIndex1 = daoObj.setProcedure(proc_name);
					daoObj.setProcInValue(nprocIndex1, "modval", "1",1);
					daoObj.setProcInValue(nprocIndex1, "hosp_code", vo.getStrHospitalCode(),2);
					daoObj.setProcInValue(nprocIndex1, "itemCatNo", vo.getStrItemCat(),3);
					daoObj.setProcInValue(nprocIndex1, "oldGroupId", vo.getStrExGroupId(),4);
					daoObj.setProcInValue(nprocIndex1, "newGroupId", vo.getStrRpGroupId(),5);
					daoObj.setProcInValue(nprocIndex1, "newSubGrpId", vo.getStrRpSubGroupId(),6);
					daoObj.setProcInValue(nprocIndex1, "itemId", vo.getStrRightNewItemIds()[i],7);
					daoObj.setProcInValue(nprocIndex1, "remarks", vo.getStrRemarks(),8);
					daoObj.setProcInValue(nprocIndex1, "seatId", vo.getStrSeatId(),9);
					daoObj.setProcInValue(nprocIndex1, "conItemId", concatItemId,10);
					daoObj.setProcOutValue(nprocIndex1, "err", 1,11);	
					daoObj.execute(nprocIndex1, 1);
				}
			}
			synchronized (daoObj)
			{
				daoObj.fire();
			}
			
			strErr = daoObj.getString(nprocIndex, "err");
			if(strErr == null)
				strErr = daoObj.getString(nprocIndex1, "err");
			if(strErr == null)
				strErr = "";			
			if(strErr.equals(""))
			{
				vo.setStrMsgType("0");
			}
			else
			{
				throw new Exception();
			}
		} 
		catch (Exception e) 
		{
			strErr = e.getMessage();
			vo.setStrMsgString("GroupItemAltMstDAO.insertQuery()"+ e.getMessage());
			vo.setStrMsgType("1");
			try 
			{
				throw new Exception("GroupItemAltMstDAO.insertQuery()" + strErr);				
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
				vo.setStrMsgString("GroupItemAltMstDAO.insertQuery()"+ e.getMessage());
				vo.setStrMsgType("1");
			}
		} 
		finally 
		{
		}
	}
}