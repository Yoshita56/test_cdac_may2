package dossier.global.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import dossier.global.vo.MmsVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsDAO.
 */
public class MmsDAO {

	/**
	 * Gets the item parameters.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item parameters
	 */
	public static void getItemParameters(MmsVO vo) {

		String strMode = "1";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}"; //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode,1);
			dao.setProcInValue(procIndex1, "itemCatNo", vo
					.getStrItemCategoryNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),5);

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "parentprmid", "0",3);
			dao.setProcInValue(procIndex1, "itemid", "0",4);
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrItemParamWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the item parameters dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item parameters dtls
	 */
	public static void getItemParametersDtls(MmsVO vo) {

		String strMode = "2";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}"; //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode);
			dao.setProcInValue(procIndex1, "parentPrmId", vo
					.getStrParentParameterId());
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "itemcatno", "0");
			dao.setProcInValue(procIndex1, "itemid", "0");
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemParamDtlsWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the item existing parameters dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item existing parameters dtls
	 */
	public static void getItemExistingParametersDtls(MmsVO vo) {

		String strMode = "3";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}"; //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode);
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemId());
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "itemcatno", "0");
			dao.setProcInValue(procIndex1, "parentprmid", "0");
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemParamDtlsWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the existing item parameters dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the existing item parameters dtls
	 */
	public static void getExistingItemParametersDtls(MmsVO vo) {

		String strMode = "4";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}"; //6+1=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode);
			dao.setProcInValue(procIndex1, "parentPrmId", vo
					.getStrParentParameterId());
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemId());
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "itemcatno", "0");
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemParamDtlsWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the display item parameters.
	 * 
	 * @param vo the vo
	 * 
	 * @return the display item parameters
	 */
	public static void getDisplayItemParameters(MmsVO vo) {

		String strMode = "5";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}";  //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode);
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemId());
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			
			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "itemcatno", "0");
			dao.setProcInValue(procIndex1, "parentprmid", "0");
			/* End Adding Default value*/

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemParamWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the display item parameters dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the display item parameters dtls
	 */
	public static void getDisplayItemParametersDtls(MmsVO vo) {

		String strMode = "6";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_item_parameter_mst(?,?,?,?,?,?,?)}";//6+1=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode);
			dao.setProcInValue(procIndex1, "parentPrmId", vo
					.getStrParentParameterId());
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemId());
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "itemcatno", "0");
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemParamDtlsWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemParameters() --> "
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
	 * Gets the sub group list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the sub group list
	 */
	public static void getSubGroupList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_subgroup_list(?,?,?,?,?)}";//4+1=5

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getSubGroupList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "group_id", vo.getStrGroupId(),2);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(procIndex1, "err", 1,4); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,5); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrSubGroupWs(ws);

		} catch (Exception e) {

			//e.printStackTrace();
			
			vo.setStrMsgString("MmsDAO.getSubGroupList() --> "
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
	 * Gets the  New Item Flag
	 * 
	 * @param voObj the vo obj
	 * 
	 * @return the item dtls
	 */
	public static void getNewItemFlag (MmsVO voObj) {

		HisDAO daoObj = null;
		String strFuncName = "";
		String strNewItemFlag = "";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strFuncName = "{? = call MMS_MST.getNewItemFlag(?::numeric,?::numeric,?::numeric,?::numeric)}"; //4
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrRequestType());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, voObj.getStrFromStoreId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strNewItemFlag = daoObj.getFuncNumeric(nFuncIndex).toString();

			voObj.setStrNewItemFlag(strNewItemFlag);

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("MmsDAO.getNewItemFlag --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	
	
	/**
	 * Gets the item list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item list
	 */
	public static void getItemList(MmsVO vo) {

		String err = "";

		String strModeVal = vo.getStrModeVal();

		String proc_name1 = "{call pkg_mms_view.proc_item_detail(?,?,?,?,?,?,?,?,?,?)}"; //10

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strModeVal);
			dao.setProcInValue(procIndex1, "itemCat", vo.getStrItemCategoryNo());
			dao.setProcInValue(procIndex1, "grpId", vo.getStrGroupId());
			dao.setProcInValue(procIndex1, "subGrpId", vo.getStrSubGroupId());
			dao.setProcInValue(procIndex1, "reqType", vo.getStrRequestType());
			dao.setProcInValue(procIndex1, "frmStrId", vo.getStrFromStoreId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "userInfo", vo.getStrUserInfo());
			//System.out.println("Generic Name strModeVal::=>"+strModeVal+"::itemCat::::=>"+vo.getStrItemCategoryNo()+"::grpId::::=>"+vo.getStrGroupId()+"subGrpId::=>"+vo.getStrSubGroupId()+"reqType::=>"+vo.getStrRequestType()+"frmStrId::=>"+vo.getStrFromStoreId()+"userInfo::=>"+vo.getStrUserInfo());	
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrItemListWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the item brand list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item brand list
	 */
	public static void getItemBrandList(MmsVO vo) {

		String err = "";
		String proc_name1 ="";

		String strModeVal = vo.getStrModeVal();
		//System.out.println("UserInfo::::==>"+vo.getStrUserInfo());
        if(vo.getStrUserInfo().split("\\^")[0].equals("5"))
        {	
		     proc_name1 = "{call pkg_mms_view.Proc_QC_Itembrand_Detail(?,?,?,?,?,?,?,?,?,?,?)}"; //9
        }
        else
        {
        	 proc_name1 = "{call pkg_dossier_view.Proc_Itembrand_Detail(?,?,?,?,?,?,?,?,?,?,?)}"; //9	
        }	

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemBrandList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			
		 //   System.out.println("proc_name1==>"+proc_name1);
		//	System.out.println("modeval "+strModeVal);
		//	System.out.println("hosp_code "+ vo.getStrHospitalCode());
		//	System.out.println("itemCat "+ vo.getStrItemCategoryNo());
		//	System.out.println("frmStrId " +vo.getStrFromStoreId());
		//	System.out.println("genericItemId "+ vo.getStrItemId());
		//	System.out.println("reqType "+ vo.getStrRequestType());
							
			//System.out.println("In Get Item Brand Name MmsDAO.getItemBrandList()==>Mode:::"+strModeVal+":::User Info:::"+vo.getStrUserInfo()+"::::Item ID::::"+vo.getStrItemId()+"::reqType::"+vo.getStrRequestType()+"::frmStrId::"+vo.getStrFromStoreId());
			//System.out.println("proc_name1==>"+proc_name1);
			
			

			// set value
			if(vo.getStrUserInfo().split("\\^")[0].equals("5"))
	        {			
			    //System.out.println("I m in if");
				dao.setProcInValue(procIndex1, "modeval", "5",1);
	        }
			else
			{
				dao.setProcInValue(procIndex1, "modeval", strModeVal,1);
			}
			String strreqType="";
			if(vo.getStrRequestType().equalsIgnoreCase("34"))
			{
				strreqType="32";
			}else{
				strreqType=vo.getStrRequestType();
			}
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "itemCat", vo.getStrItemCategoryNo(),3);
			dao.setProcInValue(procIndex1, "frmStrId", vo.getStrFromStoreId(),4);	
			dao.setProcInValue(procIndex1, "genericItemId", vo.getStrItemId(),5);
			dao.setProcInValue(procIndex1, "reqType", strreqType,6);
			
			if(vo.getStrUserInfo().split("\\^")[0].equals("5"))
	        {
			    //System.out.println("In the if");
				dao.setProcInValue(procIndex1, "userInfo",vo.getStrUserInfo().split("\\^")[1],7);
	        }
			else
			{
				dao.setProcInValue(procIndex1, "userInfo",vo.getStrUserInfo(),7);
			}	
			
		//	System.out.println("userinfo "+vo.getStrUserInfo());	
			dao.setProcInValue(procIndex1, "grpId", vo.getStrGroupId(),8);
			dao.setProcInValue(procIndex1, "subGrpId", vo.getStrSubGroupId(),9);			
			
		//	System.out.println("grpId "+ vo.getStrGroupId());
		//	System.out.println("subGrpId "+ vo.getStrSubGroupId());	
		
			dao.setProcOutValue(procIndex1, "err", 1,10); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,11); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrBrandItemListWs(ws);

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getItemBrandList() --> "
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
	 * Gets the unit list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit list
	 */
	public static void getUnitList(MmsVO vo) {

		String err = "";

		String strModeVal = "1";

		if(vo.getStrUnitMode().equals("1")) strModeVal = "3";
		if(!vo.getStrItemCategoryNo().equals("10")) strModeVal = "5";
		
		String proc_name1 = "{call pkg_mms_view.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";  //5+1=6

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getUnitList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			//System.out.println("Mode Value:::"+strModeVal);
			//System.out.println("Unit:::"+vo.getStrUnitId());
			if(vo.getStrUnitId().length() == 4)
				dao.setProcInValue(procIndex1, "modeval", "5",4);
			else
				dao.setProcInValue(procIndex1, "modeval", "1",4);
			dao.setProcInValue(procIndex1, "unit_id", vo.getStrUnitId(),2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),1);

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "module_id", "63",3);
			/* End Adding Default value*/
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrUnitListWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getUnitList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public static void insert(MmsVO vo) {

		HisDAO dao = new HisDAO("Mms", "Insert");

		int nLen = vo.getStrParamCheck().length;

		try {

			for (int i = 0; i < nLen; i++) {

				String[] chkVal = vo.getStrParamCheck()[i].replace("^", "#")
						.split("#");

				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();

				itemParamDao.setStrHospitalCode(vo.getStrHospitalCode());
				itemParamDao.setStrParentParamId(chkVal[0]);
				itemParamDao.setStrParamId(chkVal[1]);
				itemParamDao.setStrItemId(vo.getStrItemId());
				itemParamDao.setStrParamValue(vo.getStrParamValue()[i]);
				itemParamDao.setStrSeatId(vo.getStrSeatId());

				itemParamDao.insertItemParameterDtls(dao);

			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("MmsDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public static void update(MmsVO vo) {

		HisDAO dao = new HisDAO("Mms", "Insert");

		try {
			int nParamCount = 0;

			int nLen1 = vo.getStrParamDtls().length;

			for (int i = 0; i < nLen1; i++) {

				String[] chkVal = vo.getStrParamDtls()[i].replace("^", "#")
						.split("#");

				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();

				itemParamDao.setStrHospitalCode(vo.getStrHospitalCode());
				itemParamDao.setStrParamId(chkVal[0]);
				itemParamDao.setStrParamSlNo(chkVal[1]);
				itemParamDao.setStrItemId(vo.getStrItemId());

				itemParamDao.setStrSeatId(vo.getStrSeatId());

				if (vo.getStrParamStatus()[i].equals("1")) {
					itemParamDao
							.setStrParamValue(vo.getStrParamValue()[nParamCount]);

					// System.out.println("param Value:
					// "+vo.getStrParamValue()[nParamCount]);

					itemParamDao.updateItemParameterDtls(dao);

					nParamCount = nParamCount + 1;
				} else if (vo.getStrParamStatus()[i].equals("2")) {
					itemParamDao.deleteItemParameterDtls(dao);
				}

			}

			int nLen = vo.getStrParamCheck().length;

			for (int i = 0; i < nLen; i++) {

				String[] chkVal = vo.getStrParamCheck()[i].replace("^", "#")
						.split("#");

				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();

				itemParamDao.setStrHospitalCode(vo.getStrHospitalCode());
				itemParamDao.setStrParentParamId(chkVal[0]);
				itemParamDao.setStrParamId(chkVal[1]);
				itemParamDao.setStrItemId(vo.getStrItemId());
				itemParamDao.setStrParamValue(vo.getStrParamValue()[nParamCount
						+ i]);
				itemParamDao.setStrSeatId(vo.getStrSeatId());

				// System.out.println("param Value:
				// "+vo.getStrParamValue()[nParamCount + i]);

				itemParamDao.insertItemParameterDtls(dao);

			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("MmsDAO.update() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the item mandatory details.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item mandatory details
	 */
	public static void getItemMandatoryDetails(MmsVO vo) {

		String strMode = "1";
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_item_mandatory_dtls(?,?,?,?,?)}"; //5

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getItemMandatoryDetails(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", strMode,1);

			dao.setProcInValue(procIndex1, "item_id", vo.getStrItemId(),2);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(procIndex1, "err", 1,4); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,5); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.next()) {

				vo.setStrItemMandatoryDtls(ws.getString(1));

			} else {
				vo.setStrItemMandatoryDtls("0^0^0");
			}

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemMandatoryDetails() --> "
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
	 * Sets the mms listing dtl.
	 * 
	 * @param voObj the new mms listing dtl
	 */
	public static void setMmsListingDtl(MmsVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strPatListType = voObj.getStrValue1();
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8(); // This Use for Hospital
		// Code

		String strModeType = "4";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";//9+3=12

		if (strPatListType.trim().equals("10")) {

			strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";//10+2=12

		}

		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_type", strModeType);

			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			/* Start Adding Default value*/
			
			daoObj.setProcInValue(nProcIndex, "crno", ""); 
			daoObj.setProcInValue(nProcIndex, "chargetypeid", "1");
			daoObj.setProcInValue(nProcIndex, "deptcode","0");
			/* End Adding Default value*/
			
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setGblWs1(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAObilling.setPatientListingDtl_from_InBound() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the item dtls.
	 * 
	 * @param voObj the vo obj
	 * 
	 * @return the item dtls
	 */
	public static void getItemDtls(MmsVO voObj) {

		HisDAO daoObj = null;
		String strFuncName = "";
		String strItemName = "";
		int nFuncIndex = 0;

		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");

			strFuncName = "{? = call MMS_MST.get_item_dtl(?,?,?)}"; //4
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strItemName = daoObj.getFuncString(nFuncIndex);

			voObj.setStrItemName(strItemName);

		} catch (Exception e) {
            e.printStackTrace();
			voObj.setStrMsgString("MmsDAO.getItemDtls --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * Gets the stock item dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock item dtls list
	 */
	public static void getStockItemDtlsList(MmsVO vo) 
	{
        // This Procedure Return 44 Value(Ist Generic Item Name + Last : Rack No(44))
		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //10+3=13

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		String strMode = "1" ;
		
		if(vo.getStrModeVal().equals("3"))
		{
			
				strMode = "3" ;
			
		}
		
		
		try 
		{

			dao = new HisDAO("mms","global.MmsDAO.getStockItemDtlsList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
//			System.out.println("Mode::IN MMS DAO::"+strMode);
//			System.out.println("Store ID:::::::"+vo.getStrFromStoreId());
//			System.out.println("Item ID::MMS DAO::"+vo.getStrGenricItemId());
//			System.out.println("Item BrandId::MMS DAO::"+vo.getStrItemId());
//			System.out.println("STOCK STATUS::MMS DAO::"+vo.getStrStockStatus());
//			System.out.println("RESER_STOCK FLAG::MMS DAO::"+vo.getStrReservedFlag());
			
			
			dao.setProcInValue(procIndex1, "modval", strMode);
			dao.setProcInValue(procIndex1, "store_id", vo.getStrFromStoreId());
			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(procIndex1, "item_id", vo.getStrGenricItemId());
			dao.setProcInValue(procIndex1, "itembrand_id", vo.getStrItemId());
			dao.setProcInValue(procIndex1, "stock_status", "10");
			dao.setProcInValue(procIndex1, "reservedStockFlag", vo.getStrReservedFlag());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			/* Start Adding Default value*/
			 dao.setProcInValue(procIndex1, "batch_no", "0");
			 dao.setProcInValue(procIndex1, "itemSlNo", "0");  
		     dao.setProcInValue(procIndex1, "blockedQtyFlag", "1"); 
		     /* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			
			if(vo.getStrModeVal().equals("3") && ws != null && ws.size() > 0)
			{
			
				if(ws.next())
				{
					
					vo.setStrRateUnit(ws.getString(41));
					vo.setStrRateInBaseValue(ws.getString(42));
					
				}
				
				ws.beforeFirst();
						
		     }
		
						
			vo.setWsStockDetails(ws);

		} 
		catch (Exception e) 
		{

			e.printStackTrace();
			
			vo.setStrMsgString("MmsDAO.getStockItemDtlsList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

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
	 * Gets the issue dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls list
	 * This Function is Used To Get Ajax Voucher Details
	 */
	public static void getIssueDtlsList(MmsVO vo) {

		String err;
		String strSlNoflg;
		HisDAO     dao = null;
		WebRowSet   ws = null;
		int procIndex1 = 0;
		int nFuncIndex = 0;
		 /* Function Added By Amit on Date 24/09/2010  */
		 /* Function Used to get Flag whether SlNo Coloum will be shown or not in Report*/
		String strFuncName = "{? = call MMS_MST.get_reqperfix(?::numeric,?::numeric,?::numeric)}";
		String proc_name1 = "{call pkg_mms_view.proc_issue_detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println("----------------DOSSIER . MMSDAO . getIssueDtlsList -- pkg_mms_view.proc_issue_detail ["+vo.getStrModeVal()+"]----------------------");
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Issue No
			  2.Issue Date
			  3.Issue To 
			  4.Issue By
			  5.Generic Name
			  6.Brand Name
			  7.Batch No
			  8.Expiry date
			  9.Issue rate
			  10.Issue Qty
			  11.Store Id
			  12.Item Id
			  13.Item Brand ID
			  14.Batch No
			  15.Expiry Date
			  16.Issue Rate
			  17.Issue Rate Unit Id
			  18.Issue Rate Base Unit Id
			  19.Issue Qty
			  20.Issue Qty Unit Id
			  21.Issue Qty Base Value
			  22.Item Sl No
			  23.Item SL No
			  24,Category Code
			  25.Issue Qty
			  26.Remarks
			  27.Final remarks
			  28.Received By
			  29.Cost
			  30.Total Avl Budget
			  31.Indent No
			  32.Indent Date
			  33.Purchase Rate With Unit e.g 101 No. 
			  34.Cost With Purchase Rate
			  35.Budget Used
			 */			
			/*
			  Total 33 Value Return In Case of ModeVal 4 (Which Call in Case of On-Line Acknowledge Voucher)
			  1.Issue No
			  2.Issue Date
			  3.Issue To 
			  4.Issue By
			  5.Generic Name
			  6.Brand Name
			  7.Batch No
			  8.Expiry date
			  9.Issue rate
			  10.Issue Qty
			  11.Store Id
			  12.Item Id
			  13.Item Brand ID
			  14.Batch No
			  15.Expiry Date
			  16.Issue Rate
			  17.Issue Rate Unit Id
			  18.Issue Rate Base Unit Id
			  19.Issue Qty
			  20.Issue Qty Unit Id
			  21.Issue Qty Base Value
			  22.Item Sl No
			  23.Item SL No
			  24,Category Code
			  25.Issue Qty
			  26.Remarks
			  27.Received By
			  28.Issued by 
			  29.Final Remarks
			  30.Cost
			  31.Total Avlaible Budget
			  32.Purchase Rate With Unit e.g 45 10*10 No.
			  33.Cost With Purchase Rate
			 
			 */
			dao = new HisDAO("mms","global.MmsDAO.getStockItemDtlsList(MmsVO vo)");
			
			
			nFuncIndex = dao.setFunction(strFuncName);
			
		    System.out.println("Modeval----------"+vo.getStrModeVal());
			System.out.println("Issue No---------"+vo.getStrIssueNo());
			System.out.println("Store ID---------"+vo.getStrFromStoreId());
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", vo.getStrModeVal(),1);
			dao.setProcInValue(procIndex1, "strId", vo.getStrFromStoreId(),3);
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo().split("\\^")[0],2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"err", 1,5); // 1 for string return
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
            //System.out.println("MMs DAO size:::"+ws.size());
			if (ws != null && ws.size() > 0) {

				if (ws.next()) 
				{

					vo.setStrIssueDate(ws.getString(2));
					vo.setStrIssueTo(ws.getString(3));  // Issue To @ Issue By
					//System.out.println("ws.getString(3)-------------------------"+ws.getString(3));
					vo.setStrStoreName(ws.getString(4));
					vo.setStrItemCategoryNo(ws.getString(24));
				    if(vo.getStrModeVal().equals("5"))
				    {
				    	vo.setStrReturnReqNo(ws.getString(26));				    	
				    }						
					dao.setFuncInValue(nFuncIndex, 2, "4");
					dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
					dao.setFuncInValue(nFuncIndex, 4, ws.getString(24));
					dao.setFuncOutValue(nFuncIndex, 1);
					dao.executeFunction(nFuncIndex);
					strSlNoflg = dao.getFuncString(nFuncIndex);
					vo.setStrSlNoflg(strSlNoflg);
					
				}
  
				ws.beforeFirst();

			}

			vo.setWsIssueDetails(ws);

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getIssueDtlsList() --> "
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
	 * Gets the free item dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the free item dtls list
	 */
	public static void getFreeItemDtlsList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_freeitem_dtl(?,?,?,?,?,?,?)}"; //7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getFreeItemDtlsList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "batchslno", vo.getStrBatchSlNo());
			dao.setProcInValue(procIndex1, "itemid", vo.getStrGenricItemId());
			dao.setProcInValue(procIndex1, "itembrandid", vo.getStrItemId());

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setWsItemOtherDtls(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getFreeItemDtlsList() --> "
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
	 * Gets the part item dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the part item dtls list
	 */
	public static void getPartItemDtlsList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_partitem_dtl(?,?,?,?,?,?,?)}"; //7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getPartItemDtlsList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "batchslno", vo.getStrBatchSlNo());
			dao.setProcInValue(procIndex1, "itemid", vo.getStrGenricItemId());
			dao.setProcInValue(procIndex1, "itembrandid", vo.getStrItemId());

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setWsItemOtherDtls(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getPartItemDtlsList() --> "
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
	 * Gets the item warranty dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item warranty dtls list
	 */
	public static void getItemWarrantyDtlsList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_itemwarranty_dtl(?,?,?,?,?,?,?)}"; //7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getItemWarrantyDtlsList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "batchslno", vo.getStrBatchSlNo());
			dao.setProcInValue(procIndex1, "itemid", vo.getStrGenricItemId());
			dao.setProcInValue(procIndex1, "itembrandid", vo.getStrItemId());

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setWsItemOtherDtls(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemWarrantyDtlsList() --> "
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
	 * Gets the item category list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item category list
	 */
	public static void getItemCategoryList(MmsVO vo) {

		String err = "";

		String proc_name1 = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //4+2=6

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getItemCategoryList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "3",1);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			
			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "store_id", "0",2);
			dao.setProcInValue(procIndex1, "reqType", "0",4);
			/* End Adding Default value*/

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsItemCategoryList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getItemCategoryList() --> "
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
	 * Gets the item category list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item category list
	 */
	public static void getComponentTypeList(MmsVO vo) {

		String err = "";

		String proc_name1 = "{call pkg_mms_view.proc_ItemComponent_Type(?,?,?,?)}"; //4

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getComponentTypeList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsComponentTypeList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getComponentTypeList() --> "
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
	 * Gets the group list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the group list
	 */
	public static void getGroupList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}"; //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getGroupList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "2",1);
			dao.setProcInValue(procIndex1, "item_category", vo
					.getStrItemCategoryNo(),3);
			dao
					.setProcInValue(procIndex1, "100", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsGroupList(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the free or part generic item list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the free or part generic item list
	 */
	public static void getFreeOrPartGenericItemList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_item_list(?,?,?,?,?,?,?)}";//7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getFreeOrPartGenericItemList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao
					.setProcInValue(procIndex1, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao.setProcInValue(procIndex1, "grpId", vo.getStrGroupId(),3);
			dao
					.setProcInValue(procIndex1, "subgroup_id", vo
							.getStrSubGroupId(),4);
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),5);

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsGenricItemList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getFreeOrPartGenericItemList() --> "
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
	 * Gets the free or part item list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the free or part item list
	 */
	public static void getFreeOrPartItemList(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}"; //8+1=9

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"global.MmsDAO.getFreeOrPartItemList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao.setProcInValue(procIndex1, "item_id", vo.getStrItemId(),3);
			dao
					.setProcInValue(procIndex1, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao.setProcInValue(procIndex1, "grpId", vo.getStrGroupId(),4);
			dao.setProcInValue(procIndex1, "subGrpId", vo.getStrSubGroupId(),5);
			dao.setProcInValue(procIndex1, "setflag", "0",6);
			
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),7);

			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object
			
			/* Start Adding Default value*/
			
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsItemList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getFreeOrPartItemList() --> "
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
	 * Gets the unit name combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit name combo
	 */
	public static void getUnitNameCombo(MmsVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("Mms Global", "MmsDAO");
			strFuncName = "{? = call Mms_Mst.get_inventory_unitId(?::numeric, ?::numeric, ?::numeric, ?::numeric )}"; //5
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; //5+1=6

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			
			
			vo.setStrUnitId(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitId(),2);
			daoObj.setProcInValue(nProcIndex, "module_id", "63",3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			
			/* Start Adding Default value*/
			
			/* End Adding Default value*/
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsUnitList(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the item other dtls init modify view.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item other dtls init modify view
	 */
	public static void getItemOtherDtlsInitModifyView(MmsVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("Mms Global", "MmsDAO");

			if (vo.getStrModeVal().equals("1")) {

				strProcName = "{call Pkg_Mms_View.proc_freeitem_dtl(?,?,?,?,?,?,?)}"; //7

			} else {

				strProcName = "{call Pkg_Mms_View.proc_partitem_dtl(?,?,?,?,?,?,?)}"; //7
			}

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),2);
			daoObj
					.setProcInValue(nProcIndex, "itemid", vo
							.getStrGenricItemId(),3);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId(),4);
			daoObj
					.setProcInValue(nProcIndex, "batchslno", vo
							.getStrBatchSlNo(),5);

			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsItemOtherDtls(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
			vo
					.setStrMsgString("DrugInventoryTrans.getItemOtherDtlsInitModifyView() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the manufacturer list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the manufacturer list
	 */
	public static void getManufacturerList(MmsVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("Mms Global", "MmsDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}"; //5+2=7
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			
			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			/* End Adding Default value*/
			
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// System.out.println("DAO -->" + wb.size());
				vo.setWsManufacturerList(wb);

			} else {

				throw new Exception(strerr);
			}
		} catch (Exception e) {

		//	e.printStackTrace();

			vo
					.setStrMsgString("ItemInventoryTransDAO.getManufacturerList() --> "
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
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemTypeCombo(MmsVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_itemtype_list(?,?,?,?,?)}"; //5
		int nProcIndex = 0;
		String strErr = "";
			 
		WebRowSet ws = null;
		HisDAO dao = null;



		try {
		 
			dao = new HisDAO("Mms Global", "MmsDAO");
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);

			dao.setProcInValue(nProcIndex, "itemcatcode", vo.getStrItemCategoryNo(),2);

			dao.setProcInValue(nProcIndex, "hosp_code", vo
							.getStrHospitalCode(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,4); 
			dao.setProcOutValue(nProcIndex, "resultset", 2,5); 
			// execute procedure

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nProcIndex, "resultset");

			 if(strErr.equals("")){
				 
				 vo.setStrItemTypeWs(ws);
				 
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("MmsDAO.getItemTypeCombo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	public static void insertNewItemDtls(MmsVO vo){
		
		
		HisDAO daoObj = null;

		String strFuncName = "";
		String strProcName = "";
		String strItemBrandId = "";
		
		int nFuncIndex = 0;
		int nProcIndex = 0;
		
		try{
		
		daoObj = new HisDAO("MMS", "ChallanProcessTransDAO");

		
		if(vo.getStrItemCategoryNo().equals("10")){
			
			strFuncName = "{? = call Mms_Mst.get_drugbrand_id(?::numeric, ?::numeric)}"; //3
			
		}else{
			strFuncName = "{? = call Mms_Mst.get_branditem_id(?::numeric, ?::numeric)}"; //3
		}
		
		

		nFuncIndex = daoObj.setFunction(strFuncName);

		daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
		daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrItemCategoryNo());
		daoObj.setFuncOutValue(nFuncIndex, 1);
		daoObj.executeFuncForNumeric(nFuncIndex);
		strItemBrandId = daoObj.getFuncNumeric(nFuncIndex).toString();
		
		
		strProcName = "{call PKG_MMS_DML.dml_addNewItems_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//23

		  
				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrFromStoreId(),2);
				daoObj.setProcInValue(nProcIndex, "grp_id", vo.getStrGroupId(),3);
				daoObj.setProcInValue(nProcIndex, "subgrp_id", vo.getStrSubGroupId(),4);
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),5);	
				daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrGenricItemId(),6);
				daoObj.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId,7);
				daoObj.setProcInValue(nProcIndex, "item_cat_code", vo.getStrItemCategoryNo(),8);
				daoObj.setProcInValue(nProcIndex, "item_name", vo.getStrNewItemName(),9);
				daoObj.setProcInValue(nProcIndex, "item_short_name", vo.getStrNewItemShortName(),10);
				daoObj.setProcInValue(nProcIndex, "manuf_id", vo.getStrNewItemManufacturer(),11);
				daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitId(),12);
				daoObj.setProcInValue(nProcIndex, "spec_desc", vo.getStrNewItemSpecification(),13);
				daoObj.setProcInValue(nProcIndex, "item_make", vo.getStrNewItemMake(),14);
				daoObj.setProcInValue(nProcIndex, "setsatchet",vo.getStrNewItemIsSetSachet(),15);
				daoObj.setProcInValue(nProcIndex, "quantifiable", vo.getStrNewItemIsQuantifiable(),16);
				daoObj.setProcInValue(nProcIndex, "item_type", vo.getStrNewItemType(),17);
				daoObj.setProcInValue(nProcIndex, "is_storeItem", vo.getStrIsStoreItem(),18);
				daoObj.setProcInValue(nProcIndex, "reorder_level", vo.getStrNewItemReorderLevel(),19);
				daoObj.setProcInValue(nProcIndex, "max_level", vo.getStrNewItemMaxLevel(),20);
				daoObj.setProcInValue(nProcIndex, "level_unit", vo.getStrNewItemLevelUnit(),21);
				daoObj.setProcInValue(nProcIndex, "seat_id", "1",22);
				daoObj.setProcOutValue(nProcIndex, "err", 1,23);
			 
				daoObj.executeProcedure(nProcIndex);

				
				String err = daoObj.getString(nProcIndex, "err");

				if(err == null) err = "";
				
				if(!err.equals("")){
					
					throw new Exception(err);
					
				}
				
				
		
		} catch (Exception e) {
			
		//	e.printStackTrace();
			
			vo
					.setStrMsgString("MmsDAO.insertNewItemDtls() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
		
	}
	public static void getGroupList1(MmsVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}"; //5+2=7

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getGroupList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "2",1);
			dao.setProcInValue(procIndex1, "item_category", vo
					.getStrItemCategoryNo(),3);
			dao
					.setProcInValue(procIndex1, "100", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			/* Start Adding Default value*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/* End Adding Default value*/
			
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsGroupList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("MmsDAO.getGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	

}
