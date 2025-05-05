/**
 * Developer : Deepak
 * Version : 1.0
 * Date : 31/Jan/2009
 */
package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.AuthorityHierDtlVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlDAO.
 */
public class AuthorityHierDtlDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void GetData(AuthorityHierDtlVO vo) {
		HisDAO dao = null;

		WebRowSet wb = null;
		// WebRowSet wb1 = null;
		String str1 = null; 
		HisUtil hisutil = null;
		try {

			hisutil = new HisUtil("master", "AuthorityHierDtlDAO");

			wb = Frm_STORENAMECOMBO(vo);
			// wb1 = To_STORENAMECOMBO(vo);

			if (wb != null) {
				str1 = hisutil.getOptionValue(wb, "-1", "0^Select Value", true);
				vo.setStrStoreName(str1);
			} else {
				str1 = "<option value='0'>DATA Not Available</option>";
				vo.setStrStoreName(str1);
			}
			/*
			 * wb1 = To_STORENAMECOMBO(vo); if(wb1!=null) { str1 =
			 * hisutil.getOptionValue(wb1, "-1","0^Select Value", true);
			 * vo.setStrToStoreName(str1); } else { str1 = "<option
			 * value='0'>DATA N/A</option>"; vo.setStrToStoreName(str1); }
			 */

		} catch (Exception e) {
			vo.setStrMsgString("--> AuthorityHierDtlDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * From_STORENAMECOMBO(vo) -- > This Method is Used to get WebRowSet for To
	 * Store Name Combo from Table.
	 * 
	 * @param vo the vo
	 * 
	 * @return the web row set
	 */
	public static WebRowSet Frm_STORENAMECOMBO(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;
	//	boolean ret = false;

		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.storename.cmb.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);

			if (web.size() == 0) {
			//	ret = false;
				throw new Exception("WebRowSet Blank!!");
			}  
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.Frm_STORENAMECOMBO() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return web;
	}

	/**
	 * for getting option value of Item Category Name on page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void itemCategory(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;
		//boolean ret = false;

		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemcatno.cmb.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrFrmStoreId());
			web = dao.executeQry(nQueryIndex);

			vo.setStrItemCategoryComboWS(web);
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}

	/**
	 * for getting option value of REQ TYPE Name on page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void reqType(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.indentreq.typ.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrFrmStoreId());
			dao.setQryValue(nQueryIndex, 4, vo.getStrItemCatCmb());
			web = dao.executeQry(nQueryIndex);

			vo.setStrrReqTypeComboWS(web);
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.reqType() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting Hier Details on page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void heirdetails(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;
		String tmp[] = null;
		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			tmp = vo.getStrTemp().replace('^', '#').split("#");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.authority.chk.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, tmp[1]);
			dao.setQryValue(nQueryIndex, 3, tmp[0]);
			web = dao.executeQry(nQueryIndex);
			vo.setStrHierDtlWS(web);
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.heirdetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting Previous Hier Details on page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void prevHeirdetails(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.authority.chk.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrFrmStoreId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrItemCatCmb());
			dao.setQryValue(nQueryIndex, 4, vo.getStrReqTypeCmb());
			web = dao.executeQry(nQueryIndex);
			vo.setStrHierDtlWS(web);
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.prevHeirdetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting max Auth Number.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void maxAuthNo(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.authority.max.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			if (web.size() > 0) {
				web.next();
				vo.setStrMaxAuthNo(web.getString(1));
			} else
				throw new Exception("WebRowSet Blank!!");
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.maxAuthNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * INSERT INTO AUTH_DTL
	 */
	/**
	 * INSER t_ aut h_ dtl.
	 * 
	 * @param vo the vo
	 */
	public static void INSERT_AUTH_DTL(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		String strTmp[] = null;
		HisDAO dao = null;
		int countLevelTyp = 0;
		try {
			dao = new HisDAO("mms", "AuthorityHierDtlDAO");

			if (Integer.parseInt(vo.getStrUpdateAuthNo()) > 0)
				updatePrevRec(vo, dao); // for updating prev records::Setting
										// GNUM_ISVALID=0 for corresponding to
										// AuthNo

			// Insert Starts
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.authority.dtl.1");
			nQueryIndex = dao.setQuery(strQuery);
			/*
			 * System.out.println("---------Values into Auth_Dtl Table-------");
			 * System.out.println("1->"+vo.getStrMaxAuthNo());
			 * System.out.println("2->"+vo.getStrHospitalCode());
			 * System.out.println("3->"+vo.getStrFrmStoreId());
			 * System.out.println("4->"+vo.getStrItemCatCmb());
			 * System.out.println("5->"+vo.getStrReqTypeCmb());
			 */
			strTmp = vo.getStrLevelTypeMaxval().replace('^', '#').split("#");
			/*
			 * System.out.println("6->"+strTmp[0]);
			 * System.out.println("7->"+strTmp[1]);
			 * System.out.println("8->"+strTmp[2]);
			 * System.out.println("9->"+strTmp[3]);
			 * System.out.println("10->"+vo.getStrRemarks());
			 * System.out.println("11->"+vo.getStrCtDate());
			 * System.out.println("12->"+vo.getStrSeatId());
			 */

			dao.setQryValue(nQueryIndex, 1, vo.getStrMaxAuthNo());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrFrmStoreId());
			dao.setQryValue(nQueryIndex, 4, vo.getStrItemCatCmb());
			dao.setQryValue(nQueryIndex, 5, vo.getStrReqTypeCmb());
			dao.setQryValue(nQueryIndex, 6, strTmp[0]);
			dao.setQryValue(nQueryIndex, 7, strTmp[1]);
			dao.setQryValue(nQueryIndex, 8, strTmp[2]);
			dao.setQryValue(nQueryIndex, 9, strTmp[3]);
			dao.setQryValue(nQueryIndex, 10, vo.getStrRemarks());
			dao.setQryValue(nQueryIndex, 11, vo.getStrCtDate());
			dao.setQryValue(nQueryIndex, 12, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 13, "1");
			dao.execute(nQueryIndex, 0);// for batch
			// dao.executeQry(nQueryIndex, 0);//without batch
			/** Next Insertion into Auth Hier Details Starts * */

			countLevelTyp = countLevelTyp + 1; // Level Raising End
			if (vo.getChk_1() != null) {
				// System.out.println("chk@1.length->"+vo.getChk_1().length);
				for (int i = 0 , stopI = vo.getChk_1().length; i <stopI ; i++) {
					vo.setStrTempApprovalId(vo.getChk_1()[i]);
					vo.setStrTempLevel(vo.getChk_1text()[i]);
					vo.setStrTempLevelType(String.valueOf(countLevelTyp));
					INSERT_AUTH_HIER_DTL(vo, dao);
				}
			}

			countLevelTyp = countLevelTyp + 1; // Level Admin1
			if (vo.getChk_2() != null) {
				// System.out.println("chk@2.length->"+vo.getChk_2().length);
				for (int i = 0 , stopI = vo.getChk_2().length; i < stopI; i++) {
					vo.setStrTempApprovalId(vo.getChk_2()[i]);
					vo.setStrTempLevel(vo.getChk_2text()[i]);
					vo.setStrTempLevelType(String.valueOf(countLevelTyp));
					INSERT_AUTH_HIER_DTL(vo, dao);
				}
			}

			countLevelTyp = countLevelTyp + 1; // Level Receiving End
			if (vo.getChk_3() != null) {
				// System.out.println("chk@3.length->"+vo.getChk_3().length);
				for (int i = 0 , stopI = vo.getChk_3().length; i < stopI; i++) {
					vo.setStrTempApprovalId(vo.getChk_3()[i]);
					vo.setStrTempLevel(vo.getChk_3text()[i]);
					vo.setStrTempLevelType(String.valueOf(countLevelTyp));
					INSERT_AUTH_HIER_DTL(vo, dao);
				}
			}

			countLevelTyp = countLevelTyp + 1; // Level Admin2
			if (vo.getChk_4() != null) {
				// System.out.println("chk@4.length->"+vo.getChk_4().length);
				for (int i = 0 , stopI = vo.getChk_4().length; i <stopI ; i++) {
					vo.setStrTempApprovalId(vo.getChk_4()[i]);
					vo.setStrTempLevel(vo.getChk_4text()[i]);
					vo.setStrTempLevelType(String.valueOf(countLevelTyp));
					INSERT_AUTH_HIER_DTL(vo, dao);
				}
			}

			synchronized (dao) {
				dao.fire(); // Here we Execute in Batch
			}
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.INSERT_AUTH_DTL() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * INSERT INTO AUTH_HIER_DTL
	 */
	/**
	 * INSER t_ aut h_ hie r_ dtl.
	 * 
	 * @param vo the vo
	 * @param dao the dao
	 */
	public static void INSERT_AUTH_HIER_DTL(AuthorityHierDtlVO vo, HisDAO dao) {
		int nQueryIndex = 0;
		String strQuery = "";
		// HisDAO dao=null;

		try {
			// dao = new HisDAO("mms","ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.authority.dtl.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrMaxAuthNo());
			dao.setQryValue(nQueryIndex, 2, vo.getStrTempApprovalId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrTempLevelType());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, vo.getStrTempLevel());
			dao.setQryValue(nQueryIndex, 6, "1");
			dao.execute(nQueryIndex, 0);// for batch
		} catch (Exception e) {
			vo
					.setStrMsgString("AuthorityHierDtlDAO.INSERT_AUTH_HIER_DTL() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for Updating Previous records.
	 * 
	 * @param vo the vo
	 * @param dao the dao
	 * 
	 * @throws Exception 	 */
	public static void updatePrevRec(AuthorityHierDtlVO vo, HisDAO dao) {
		int nQueryIndex = 0;
		String strQuery = "";
		// WebRowSet web = null;
		// HisDAO dao=null;

		try {
			// dao = new HisDAO("mms","ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "update.authority.dtl.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrUpdateAuthNo());
			dao.execute(nQueryIndex, 0);// for batch

			strQuery = mms.qryHandler_mms.getQuery(1, "update.authority.dtl.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrUpdateAuthNo());
			dao.execute(nQueryIndex, 0);// for batch
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.updatePrevRec() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getRemarks(AuthorityHierDtlVO vo) {
	
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "AuthorityHierDtlDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.remarks.text");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrFrmStoreId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatCmb());
			dao.setQryValue(nQueryIndex, 3, vo.getStrReqTypeCmb());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
			
			web = dao.executeQry(nQueryIndex);
			String remarks="";
			if(web.next()) {
				remarks=web.getString("gstr_remarks");
			}
			web.close();
			web=null;
			vo.setStrRemarks(remarks);
			
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.getRemarks() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
	}

	public static void setApprovalFlag(AuthorityHierDtlVO vo) {
		int nQueryIndex = 0;
		String strQuery = "";
		WebRowSet web = null;
		HisDAO dao = null;

		try {
			dao = new HisDAO("mms", "AuthorityHierDtlDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.authority.dtl.approvalFlag");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrReqTypeCmb());
			
			
			web = dao.executeQry(nQueryIndex);
			
			if(web.next()) {
				vo.setStrApprovalFlag(web.getString(1));
			}
			
			web.close();
			web=null;
			
			
		} catch (Exception e) {
			vo.setStrMsgString("AuthorityHierDtlDAO.setApprovalFlag() --> "
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
