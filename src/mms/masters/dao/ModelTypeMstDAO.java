package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.ItemTypeDAO;
import mms.masters.vo.ItemTypeMstVO;
import mms.masters.vo.ModelTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelTypeMstDAO.
 */
public class ModelTypeMstDAO {
	
  /*
	public static void insertQuery(ModelTypeMstVO vo) {

		HisDAO dao = null;
		ItemTypeDAO itemTypeDAO = null;

		try {
			dao = new HisDAO("mms", "ModelTypeMstDAO");
			itemTypeDAO = new ItemTypeDAO();

			itemTypeDAO.setStrItemCatNo(vo.getStrItemCatNo());
			itemTypeDAO.setStrItemTypeName(vo.getStrItemTypeName());
			itemTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			itemTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemTypeDAO.setStrIsValid(vo.getStrIsValid());
			itemTypeDAO.setStrRemarks(vo.getStrRemarks());
			itemTypeDAO.setStrSeatId(vo.getStrSeatId());
			itemTypeDAO.setStrShortName(vo.getStrShortName());

			itemTypeDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> ModelTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			itemTypeDAO = null;
		}

	}
	*/

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicate(ModelTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ModelTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> ModelTypeMstDAO.chkDuplicate()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before insert update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(ModelTypeMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ModelTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.4");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatNo());

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
			vo.setStrMsgString("--> IndentTypeMstDAO.initialUpdateQuery()-->"
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
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void updateQuery(ModelTypeMstVO vo) {
		HisDAO dao = null;
		ItemTypeDAO itemTypeDAO = null;

		try {
			dao = new HisDAO("mms", "ModelTypeMstDAO");

			itemTypeDAO = new ItemTypeDAO();

			itemTypeDAO.setStrItemCatNo(vo.getStrItemCatNo());
			itemTypeDAO.setStrItemTypeName(vo.getStrItemTypeName());
			itemTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			itemTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemTypeDAO.setStrIsValid(vo.getStrIsValid());
			itemTypeDAO.setStrRemarks(vo.getStrRemarks());
			itemTypeDAO.setStrSeatId(vo.getStrSeatId());
			itemTypeDAO.setStrShortName(vo.getStrShortName());
			itemTypeDAO.setStrItemTypeId(vo.getStrItemTypeId());
			itemTypeDAO.setStrSlNo(vo.getStrSlNo());

			itemTypeDAO.update(dao);
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			itemTypeDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(ModelTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ModelTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemCatNo(web.getString(1));
				vo.setStrItemTypeName(web.getString(2));
				vo.setStrShortName(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrRemarks(web.getString(5));
				vo.setStrIsValid(web.getString(6));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> ModelTypeMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	public static void getStoreGroupCmb(ModelTypeMstVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_store_group_list(?,?,?,?,? ,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMJ","ModelTypeMstDAO");
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "2",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			
			dao.setProcInValue(nprocIndex, "item_category", vo.getStrItemCatNo(),3);
			dao.setProcInValue(nprocIndex, "strphystockno", "0",4);
			dao.setProcInValue(nprocIndex, "strstoreid", "0",5);
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);													
			dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
			dao.executeProcedureByPosition(nprocIndex);
			
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsGroupNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ModelTypeMstDAO.getStoreGroupCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	} 
	
	public static void getItemNameCombo(ModelTypeMstVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMJ","ModelTypeMstDAO");
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "catcode", vo.getStrItemCatNo(),2);
			
			dao.setProcInValue(nprocIndex, "item_id", "0",3);
			dao.setProcInValue(nprocIndex, "grpid", vo.getStrGroupNameId(),4);
			dao.setProcInValue(nprocIndex, "subgrpid", "0",5);
			
			dao.setProcInValue(nprocIndex, "setflag", "0",6);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
			
			dao.setProcOutValue(nprocIndex, "err", 1,8);													
			dao.setProcOutValue(nprocIndex, "resultset", 2,9); 
			dao.executeProcedureByPosition(nprocIndex);
			
			
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsItemNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ModelTypeMstDAO.getItemNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	} 

	public static void insertRecord_OLD(ModelTypeMstVO vo) 
	{

		String strproc_name = "",strErr="";
		HisDAO dao = null;
		int nProcIndex = 0;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_DML.dml_item_model_mst(?,?,?,?,?,?,?,?)}"; // 8 variables  
		
			nProcIndex = dao.setProcedure(strproc_name);						
			dao.setProcInValue(nProcIndex, "modval", 			"1" ,1); 
			dao.setProcInValue(nProcIndex, "hospital_code", 	vo.getStrHospitalCode(),2); 
			dao.setProcInValue(nProcIndex, "model_name", 		vo.getStrModelName(),3); 
			dao.setProcInValue(nProcIndex, "seatid",		 	vo.getStrSeatId(),4);
			dao.setProcInValue(nProcIndex, "item_cat_no", 		vo.getStrItemCatNo(),5); 
			dao.setProcInValue(nProcIndex, "itembrand_id", 		vo.getStrItemTypeName(),6); 
			dao.setProcInValue(nProcIndex, "group_id", 			vo.getStrGroupNameId(),7); 				
			dao.setProcOutValue(nProcIndex, "err", 				1,8);				
			dao.executeProcedureByPosition(nProcIndex);		
			
			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			
						
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ReceiveFromThirdPartyTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void insertRecord_Proc(ModelTypeMstVO vo) 
	{

		String    strProcName = "";
		int        nProcIndex = 0;
		HisDAO         daoObj = null;
	  try 
		{
			     daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_DML.dml_item_model_mst(?,?,?,?,?   ,?,?,?)}"; // 8 Variable

			nProcIndex = daoObj.setProcedure(strProcName);				
			
			System.out.println("----------------- INSERT DUMMY--------------------");
			
			daoObj.setProcInValue(nProcIndex, "modval", 		"1",1); //1
			daoObj.setProcInValue(nProcIndex, "hospital_code", 	vo.getStrHospitalCode(),2);//2
			daoObj.setProcInValue(nProcIndex, "model_name", 	vo.getStrModelName(),3); //3
			daoObj.setProcInValue(nProcIndex, "seatid", 		vo.getStrSeatId(),4);  //4
			daoObj.setProcInValue(nProcIndex, "item_cat_no", 	vo.getStrItemCatNo(),5); //5
			daoObj.setProcInValue(nProcIndex, "itembrand_id", 	vo.getStrItemTypeName(),6);    //6
			daoObj.setProcInValue(nProcIndex, "group_id", 		vo.getStrGroupNameId(),7); //7       
			
			daoObj.setProcOutValue(nProcIndex, "err", 			1,8);	
			daoObj.execute(nProcIndex, 1);				

			daoObj.fire();

			
								
		} 
	  catch (Exception e) 
	  {
		  		e.printStackTrace();
		    	vo.setStrMsgString(e.getMessage());
				vo.setStrMsgType("1");
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
	
	
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 * @throws Exception 
	 */
	public static void insertRecord(ModelTypeMstVO vo) 
	{

		        HisDAO dao = null;
				
			    dao = new HisDAO("mms", "ItemTypeMstDAO");
				try 
				{

				
					insert(dao,vo);

					synchronized (dao) {
						dao.fire();

					}
					
					 dao.fire();
					
				} catch (Exception e) 
				{
                     e.printStackTrace();
					
				} 
	}
	
	/** The str err. */
	private static String strErr = "";

	/** The n row inserted. */
	private static int nRowInserted = 0;
	
	public static void insert(HisDAO dao,ModelTypeMstVO vo) throws Exception 
	{
		strErr = "";

		try 
		{			
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = "INSERT INTO hstt_item_model_mst (hstnum_model_id, gnum_hospital_code, hststr_model_name,gstr_remarks, gdt_entry_date,  gnum_seatid, gnum_isvalid, sstnum_item_cat_no, hstnum_item_id,hstnum_itembrand_id,hstnum_group_id) VALUES(MMS_MST.get_model_id(100::numeric,?::numeric),?,TRIM(?),TRIM(?),SYSDATE,?,1,?,0,?,?)";
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrModelName());
			dao.setQryValue(nQueryIndex, 4, "Model Enter");
			dao.setQryValue(nQueryIndex, 5, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 6, vo.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 7, vo.getStrItemTypeName());
			dao.setQryValue(nQueryIndex, 8, vo.getStrGroupNameId());		

			dao.execute(nQueryIndex, 0);
			nRowInserted++;
		} catch (Exception e) {

			strErr = e.getMessage();
			throw new Exception(".insert() --> " + strErr);
		} 
		finally 
		{
			
		}

	}
	
	
	
	

}
