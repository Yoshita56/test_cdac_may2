package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.PhyStockVerificationTransBO;
import mms.transactions.controller.fb.PhyStockVerificationTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.DiscrepancyReportHLP;
import mms.transactions.controller.hlp.PhyStockVerificationTransHLP;

import mms.transactions.vo.PhyStockVerificationTransVO;

public class PhyStockVerificationTransDATA {

	/**
	 * This method is used to set all the values which are required to populate
	 * the Group List.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */

	public static void getGroupCmb(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strGroupList = "";
		String[] strTemp = null;
		String strStoreTypeId = "";

		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			String strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);

			String strStoreComboValues = request.getParameterValues("combo")[0];
			strTemp = strStoreComboValues.replace("^", "#").split("#");
			strStoreTypeId = strTemp[1];

			voObj.setStrStoreTypeId(strStoreTypeId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrGrpMode("1");
			
			bo.getGroupCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transaction", "Physical Stock Verification");

			if (voObj.getStrGroupWs().size() != 0) {
				strGroupList = util.getOptionValue(voObj.getStrGroupWs(), "0",
						"0^Select Value", true);
			}
			formBean.setStrGroupList(strGroupList);

			// String str1 =
			// PhyStockVerificationTransHLP.getItemDetails(voObj.getStrItemDtlWs());
			//			
			// response.setHeader("Cache-Control", "no-cache");
			// response.getWriter().print(str1);

		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getGroupCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getGroupCmb()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	/**
	 * This method is used to set all the values which are required to populate
	 * the Brand List.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */

	public static void getBrandCmb(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strBrandList = "";

		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrItemValId(request.getParameter("itemId"));

			bo.getBrandCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transaction", "Physical Stock Verification");

			if (voObj.getStrBrandWs().size() != 0) {
				strBrandList = util.getOptionValue(voObj.getStrBrandWs(), "0",
						"0^Select Value", true);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strBrandList);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getBrandCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getBrandCmb()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	/**
	 * This method is used to set all the values which are required to populate
	 * the Unit List.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */

	public static void getUnitCmb(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strUnitList = "";

		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrUnitValId(request.getParameter("unitId"));

			bo.getUnitCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transaction", "Physical Stock Verification");

			if (voObj.getStrUnitWs().size() != 0) {
				strUnitList = util.getOptionValue(voObj.getStrUnitWs(), "0",
						"0^Select Value", true);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strUnitList);

		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getUnitCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getUnitCmb()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static void getItemDtl(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			String strGroupId = request.getParameter("groupId");
			String strStoreId = request.getParameter("storeId");
			String strFromRow = request.getParameter("fromRow");
			String strBlockSet = request.getParameter("blockSet");
			String strRowPerPage = MmsConfigUtil.PHY_STOCK_ITEM_PER_PAGE;

			int nToRow = Integer.parseInt(strFromRow)
					+ Integer.parseInt(strRowPerPage) * 10;

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrGroupId(strGroupId);
			voObj.setStrStoreId(strStoreId);
			voObj.setStrFromRow(strFromRow);
			voObj.setStrToRow(String.valueOf(nToRow));

			bo.getItemDtl(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			String str1 = PhyStockVerificationTransHLP.getItemDetails(voObj
					.getStrItemDtlWs(), strFromRow, strBlockSet, strRowPerPage);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(str1);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getItemDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getItemDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static void getNewItemDtl(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String strChkVal = null;

		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			String strStoreId = request.getParameter("storeId");
			String strItemId = request.getParameter("itemId");
			String strGroupId = request.getParameter("grpId");

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrStoreId(strStoreId);
			voObj.setStrItemId(strItemId);
			voObj.setStrGroupId(strGroupId);

			strChkVal = request.getParameter("index");

			bo.getNewItemDtl(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			String str1 = PhyStockVerificationTransHLP.getPreviousDTL(voObj
					.getStrNewItemDtlWs(), strChkVal);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(str1);

		} catch (Exception e) {

			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getNewItemDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getNewItemDtl()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static boolean insertRecord(PhyStockVerificationTransFB formBean,
			HttpServletRequest request) {

		boolean fRes = true;

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO vo = null;
		String strmsgText="";
		String strPeriodId="";
		MmsConfigUtil mms=null; 
		try {

			bo = new PhyStockVerificationTransBO();
			vo = new PhyStockVerificationTransVO();
			mms=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			//mms.get
		
			vo = (PhyStockVerificationTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhyStockVerificationTransVO", formBean);
			vo.setStrSeatId(request.getSession().getAttribute(
					"SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			strPeriodId=mms.getStrPeriodId(vo.getStrStoreId(), vo.getStrItemCategoryId(), vo.getStrHospitalCode());
			vo.setStrPeriodId(strPeriodId);
			bo.insert(vo);

		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.insertRecord --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"PhyStockVerificationTransDATA->insertRecord()", strmsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		} finally {

		}

		return fRes;

	}

	public static void getPhysicalStockVerified(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strCount = "";
		
		
		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrItemCategoryId(request.getParameter("strItemCategoryId"));
			voObj.setStrStoreId(request.getParameter("strStoreId").replace("^", "#").split("#")[0]);
					
			bo.getPhysicalStockVerified(voObj);

			strCount = voObj.getStrPhysicalCount();
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCount);

		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getPhysicalStockVerified --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getPhysicalStockVerified()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	
	public static void getVerifyInitValues(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
	//	MmsConfigUtil mcu = null;
		String strGroupList = "";
		String[] strTemp = null;
		String[] strTemp1 = null;
		String[] strTemp2 = null;
	//	AttachFileGlobal fs=null;
	//	String filePath="";
	//	FormFile fileDtl=null;
	//	String strFileName="";
	//	HisUtil hisutil=null;
		try {
				bo = new PhyStockVerificationTransBO();
				voObj = new PhyStockVerificationTransVO();
				
	//			hisutil = new HisUtil("mms", "PhyStockVerificationTransDATA");
	//			mcu=new MmsConfigUtil();
	//			fs=new AttachFileGlobal();
				 strTemp = request.getParameter("comboValue").replace("^", "#").split("#");
				 
			  
			
				formBean.setStrStoreName(strTemp[0]);
				formBean.setStrCategoryName(strTemp[1]);
				
				String strStoreComboValues = formBean.getCombo()[0];
				strTemp1 = strStoreComboValues.replace("^", "#").split("#");
				formBean.setStrStoreId(strTemp1[0]);
				formBean.setStrItemCategoryId(formBean.getCombo()[1]);
				
				if(formBean.getChk()!= null){
					
								
					strTemp2 = formBean.getChk()[0].replace("@", "#").split("#");
					
					formBean.setStrPhysicalStockNo(strTemp2[1]);
					
					formBean.setStrPrevCountedFlag("1");
					
				}else{
					
					formBean.setStrPrevCountedFlag("0");
					
				}
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCategoryId(formBean.getStrItemCategoryId());
			voObj.setStrPhysicalStockNo(formBean.getStrPhysicalStockNo());
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrGrpMode("3");
			
			bo.getPhysicalVerifyInit(voObj);
			
			formBean.setStrFinancialStartDate(voObj.getStrFinancialStartDate());
			formBean.setStrLastVerifiedDate(voObj.getStrLastVerifiedDate());
			
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transaction", "Physical Stock Verification");

			strGroupList = "";
			if (voObj.getStrGroupWs() != null || voObj.getStrGroupWs().size() > 0) {
				strGroupList = util.getOptionValue(voObj.getStrGroupWs(), "0",
						"0^Select Value", true);
			}else{
				strGroupList="<option value='0'>Select Value</option>";
			}
			formBean.setStrGroupList(strGroupList);

		
			strGroupList = "";
			if (voObj.getWsItemSearchGroupList() != null || voObj.getWsItemSearchGroupList().size() > 0) {
				strGroupList = util.getOptionValue(voObj.getWsItemSearchGroupList(), "0",
						"0^Select Value", true);
			}else{
				
					strGroupList="<option value='0'>Select Value</option>";
				
			}
			formBean.setStrGroupIdForItemSearchValues(strGroupList);
			

			

		} catch (Exception e) {
			
			e.printStackTrace();
			
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getVerifyInitValues --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getVerifyInitValues()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	
	public static void getCountedItemsList(PhyStockVerificationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strDtls = "";
		
		
		try {
			bo = new PhyStockVerificationTransBO();
			voObj = new PhyStockVerificationTransVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrGroupId(request.getParameter("strGroupId"));
			voObj.setStrStoreId(request.getParameter("strStoreId"));
			voObj.setStrPhysicalStockNo(request.getParameter("strPhyStockNo"));		
			
			bo.getCountedItemsList(voObj);

		 
			strDtls = PhyStockVerificationTransHLP.getCountedItemDetails(voObj.getWsCountedItemsList(), "10");
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDtls);

		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getPhysicalStockVerified --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getPhysicalStockVerified()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static void getReviewPage(PhyStockVerificationTransFB _PhyStockVerificationTransFB,
			HttpServletRequest request){
			String strmsgText="";
			String strGroupList="";
			String strCommitteeType="";
			PhyStockVerificationTransBO bo = null;
			PhyStockVerificationTransVO vo = null;
			String strBillAproval="";
			String[]temp=null;
			HisUtil util=null;
			String strDisReport="";
			String strGroupComboDisp="";
			try{
				 
				 
				 bo=new PhyStockVerificationTransBO();
				 vo=new PhyStockVerificationTransVO();
				 util = new HisUtil("MMS Transaction", "Physical Stock Verification");
				 
				 
				 temp=request.getParameter("chk").replace('@', '#').split("#");
				 
				 vo.setStrStoreId(temp[0]);
				 vo.setStrStockNo(temp[1]);
				 vo.setStrItemCategNo(request.getParameterValues("combo")[1]);
				 _PhyStockVerificationTransFB.setStrStartDate(temp[2]);
				 _PhyStockVerificationTransFB.setStrPeriod(temp[3]);
				 temp=request.getParameter("comboValue").replace('@', '#').split("#");
				 
				 vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				 bo.getReviewDtl(vo);
				 
				 strBillAproval=ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), "0", vo.getStrItemCategNo(), "69", vo.getStrStockNo());
				 strDisReport=DiscrepancyReportHLP.getDiscrepancyReport(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrStockNo());
				 strGroupComboDisp=DiscrepancyReportHLP.getGroupCombo(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrStockNo());
				  if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}


				if (vo.getCommitteTypeWS().size() != 0) {
						strCommitteeType = util.getOptionValue(vo.getCommitteTypeWS(), "0",
								"0^Select Value", true);
		
					}else{
						strCommitteeType="<option value='0'>Select Value</option>";
					}
				 _PhyStockVerificationTransFB.setStrStockNo(vo.getStrStockNo());
				 _PhyStockVerificationTransFB.setStrStoreId(vo.getStrStoreId());
				 _PhyStockVerificationTransFB.setStrStoreName(temp[0]);
				 _PhyStockVerificationTransFB.setStrItemCategoryName(temp[1]);
				 _PhyStockVerificationTransFB.setStrGroupList(strGroupList);
				 _PhyStockVerificationTransFB.setStrDisReport(strDisReport);
				 _PhyStockVerificationTransFB.setStrCommitteeType(strCommitteeType);
				 _PhyStockVerificationTransFB.setStrBillAproval(strBillAproval);
				 _PhyStockVerificationTransFB.setStrGroupComboDisp(strGroupComboDisp);
				 _PhyStockVerificationTransFB.setCombo(request.getParameterValues("combo"));
				 _PhyStockVerificationTransFB.setStrItemCategNo(vo.getStrItemCategNo());
				
			}catch(Exception e){
					
				strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getReviewPage --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"PhyStockVerificationTransDATA->getReviewPage()",
						strmsgText);
				_PhyStockVerificationTransFB.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
	
				eObj = null;
			}
		
	}
	
	public static void getViewPage(PhyStockVerificationTransFB _PhyStockVerificationTransFB,
			HttpServletRequest request){
			String strmsgText="";
			String strGroupList="";
			PhyStockVerificationTransVO vo = null;
			String[]temp=null;
			String strGroupComboDisp="";
			String strDisReport="";
			String strBillAproval="";
			try{
				 
				 
				 vo=new PhyStockVerificationTransVO();
						 
				 temp=request.getParameter("chk").replace('@', '#').split("#");
				 
				 vo.setStrStoreId(temp[0]);
				 vo.setStrStockNo(temp[1]);
				 vo.setStrItemCategNo(request.getParameterValues("combo")[1]);
				 _PhyStockVerificationTransFB.setStrStartDate(temp[2]);
				 _PhyStockVerificationTransFB.setStrPeriod(temp[3]);
				 temp=request.getParameter("comboValue").replace('@', '#').split("#");
				 
				 vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				 
				 strBillAproval=ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), "0", vo.getStrItemCategNo(), "69", vo.getStrStockNo());
				 		
				 strDisReport=DiscrepancyReportHLP.getDiscrepancyReport(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrStockNo());
				 
				 strGroupComboDisp=DiscrepancyReportHLP.getGroupCombo(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrStockNo());
				
				 if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
				 }

				 _PhyStockVerificationTransFB.setStrStockNo(vo.getStrStockNo());
				 _PhyStockVerificationTransFB.setStrStoreId(vo.getStrStoreId());
				 _PhyStockVerificationTransFB.setStrStoreName(temp[0]);
				 _PhyStockVerificationTransFB.setStrItemCategoryName(temp[1]);
				 _PhyStockVerificationTransFB.setStrGroupList(strGroupList);
				 _PhyStockVerificationTransFB.setStrDisReport(strDisReport);
				 _PhyStockVerificationTransFB.setStrBillAproval(strBillAproval);
				 _PhyStockVerificationTransFB.setStrGroupComboDisp(strGroupComboDisp);
				 _PhyStockVerificationTransFB.setCombo(request.getParameterValues("combo"));
				
			}catch(Exception e){
					e.printStackTrace();
				strmsgText = "mms.transactions.PhyStockVerificationTransDATA.getReviewPage --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"PhyStockVerificationTransDATA->getReviewPage()",
						strmsgText);
				_PhyStockVerificationTransFB.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
	
				eObj = null;
			}
		
	}
	public static void getMemberDtl(PhyStockVerificationTransFB _PhyStockVerificationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 String strmsgText = "";
		 PhyStockVerificationTransBO bo = null;
		 PhyStockVerificationTransVO vo = null;
		String result="";
		try
		{
			
			vo=new PhyStockVerificationTransVO();
			bo=new PhyStockVerificationTransBO();
			vo.setStrCommiteeTypeId(request.getParameter("committeType"));
			vo.setStrItemCategoryId(request.getParameter("catgCode"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo.getMemberDetails(vo);
			_PhyStockVerificationTransFB.setCommitteMemberWS(vo.getCommitteMemberWS());
			result=PhyStockVerificationTransHLP.createMemberDetails(_PhyStockVerificationTransFB);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			response.getWriter().print(result);
			
		}
		catch(Exception e)
		{
			strmsgText = "PhyStockVerificationTransDATA.getMemberDtl() --> "
				+ e.getMessage();
			HisException eObj = new HisException("IPD", "PhyStockVerificationTransDATA->getMemberDtl()", strmsgText);
		    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
		    try
		    {
		    	response.getWriter().print(response1);
		    	eObj=null;
		    }
		    catch(Exception e1)
		    {
		    	
		    }

		}
	}
	public static boolean updateReview(PhyStockVerificationTransFB formBean,
			HttpServletRequest request) {

		boolean fRes = true;

		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO vo = null;
		String strmsgText="";
		AttachFileGlobal fs=null;
//		String filePath="";
		FormFile fileDtl=null;
		String strFileName="";
		HisUtil hisutil=null;
		MmsConfigUtil mcu=null;
		String []strTemp1=null;
		try {

			bo = new PhyStockVerificationTransBO();
			vo = new PhyStockVerificationTransVO();
			hisutil = new HisUtil("mms", "PhyStockVerificationTransDATA");
			mcu=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fs=new AttachFileGlobal();
		//	//System.out.println("Welcome here");
		//	 filePath=mcu.getStrCommitteeFilePath();
			 
			vo = (PhyStockVerificationTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PhyStockVerificationTransVO", formBean);
			vo.setStrSeatId(request.getSession().getAttribute(
					"SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			fileDtl=formBean.getStrLocation();
			strTemp1=fileDtl.getFileName().replace('.', '#').split("#");
			vo.setStrFileExt(strTemp1[strTemp1.length-1]);
			strFileName=formBean.getStrStoreId()+"_"+formBean.getStrStockNo()+"_"+formBean.getStrHospitalCode()+
						"_"+hisutil.getASDate("dd-MMM-yyyy")+"."+vo.getStrFileExt();
			vo.setStrFileName(strFileName);
			vo.setStrPeriodId(mcu.getStrPeriodId(vo.getStrStoreId(), vo.getStrItemCategNo(), vo.getStrHospitalCode()));
			bo.updateReview(vo);
			fs.saveFile(fileDtl.getFileData(), vo.getStrFileName());
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			
				strmsgText = "mms.transactions.PhyStockVerificationTransDATA.updateReview --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationTransDATA->getReviewPage()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {

		}

		return fRes;

	}
	
	public static boolean cancelRecord(PhyStockVerificationTransFB formBean,
			HttpServletRequest request) {

		boolean fRes = true;
		String strmsgText="";
		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO vo = null;
		String []temp=null;
		try {
			temp=request.getParameter("chk").replace('@', '#').split("#");
			 
			
			bo = new PhyStockVerificationTransBO();
			vo = new PhyStockVerificationTransVO();
			 vo.setStrStoreId(temp[0]);
			 vo.setStrStockNo(temp[1]);
			 vo.setStrItemCategNo(request.getParameterValues("combo")[1]);
			vo.setStrSeatId(request.getSession().getAttribute(
			"SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute(
			"HOSPITAL_CODE").toString());
			vo.setStrRemarks(request.getParameter("comboValue"));
			
			bo.cancelRecord(vo);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.cancelRecord --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"PhyStockVerificationTransDATA->cancelRecord()",
				strmsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		} finally {

		}

		return fRes;

	}
	public static boolean updateStock(PhyStockVerificationTransFB formBean,
			HttpServletRequest request) {

		boolean fRes = true;
		String strmsgText="";
		PhyStockVerificationTransBO bo = null;
		PhyStockVerificationTransVO vo = null;
		String []temp=null;
		try {
			temp=request.getParameter("chk").replace('@', '#').split("#");
			 
			
			bo = new PhyStockVerificationTransBO();
			vo = new PhyStockVerificationTransVO();
			 vo.setStrStoreId(temp[0]);
			 vo.setStrStockNo(temp[1]);
			 vo.setStrItemCategNo(request.getParameterValues("combo")[1]);
			vo.setStrSeatId(request.getSession().getAttribute(
			"SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute(
			"HOSPITAL_CODE").toString());
			vo.setStrRemarks(request.getParameter("comboValue"));
			bo.updateStock(vo);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			strmsgText = "mms.transactions.PhyStockVerificationTransDATA.updateStock --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"PhyStockVerificationTransDATA->updateStock()",
				strmsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");
		} finally {

		}

		return fRes;

	}
}
