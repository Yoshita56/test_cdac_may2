package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.SupplierMstBO;
import mms.masters.controller.fb.SupplierMstFB;
import mms.masters.vo.SupplierMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstDATA.
 */
public class SupplierMstDATA {

	/**
	 * This function is used to set initial parameters required to display on
	 * main page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initParamAddPage(HttpServletRequest request,
			SupplierMstFB formBean) 
	{
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;
		HisUtil util = null;
		String temp1 = "";
		String strHospCode = "";
		String strCurrentDate = "";
		String strItemCatNo = "";
		String strSupplierTypeVals="";
		String strCountryNameCombo = "",strStateNameCombo="";
		// String strSupplierGradeValues = "";
		try {

			util = new HisUtil("mms", "SupplierMstDATA");

			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);

			vo = new SupplierMstVO();
			bo = new SupplierMstBO();
			if (formBean.getStrItemCatNo() == null
					|| formBean.getStrItemCatNo().equals(""))
				strItemCatNo = formBean.getCombo()[0];
			else
				strItemCatNo = formBean.getStrItemCatNo();
			// String temp[] = request.getParameterValues("combo");
			/*
			 * String strItemCatNo = formBean.getCombo()[0];
			 * //System.out.println("strItemCatNo"+strItemCatNo); if (strItemCatNo ==
			 * null) { strItemCatNo = formBean.getStrItemCatNo();
			 *  }
			 */
			formBean.setStrItemCatNo(strItemCatNo);
           
			strHospCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strHospCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			formBean.setStrHospCode(strHospCode);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrCountryCode("IND");

			bo.setinitParam(vo);			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				if (vo.getSupplierGradeWS() != null
						&& vo.getSupplierGradeWS().size() > 0) {
					temp1 = util.getOptionValue(vo.getSupplierGradeWS(), "0",
							"0^Select Value", false);
				} else {
					temp1 = "<option value='0'>Select Value</option>";
				}
				
				formBean.setStrSupplierGradeValues(temp1);
				if (vo.getWsSupplierType() != null
						&& vo.getWsSupplierType().size() > 0) {
					strSupplierTypeVals = util.getOptionValue(vo.getWsSupplierType(), "0",
							"0^Select Value", false);
				} else {
					strSupplierTypeVals = "<option value='0'>Select Value</option>";
				}

				formBean.setStrSupplierTypeVals(strSupplierTypeVals);

				if (vo.getCommiteeNameWS() != null
						&& vo.getCommiteeNameWS().size() > 0) {
					temp1 = util.getOptionValue(vo.getCommiteeNameWS(), "0",
							"0^Select Value", false);
				} else {
					temp1 = "<option value='0'>Select Value</option>";
				}

				formBean.setStrCommiteeNameValues(temp1);

				
				
				
				if (vo.getCountryNameWS() != null
						&& vo.getCountryNameWS().size() > 0) 
				{
					strCountryNameCombo = util.getOptionValue(vo.getCountryNameWS(), "IND",
							"0^Select Value", false);
				} 
				else 
				{
					strCountryNameCombo = "<option value='0'>Select Value</option>";
				}
				formBean.setStrCountryNameCombo(strCountryNameCombo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				} 
				else 
				{

					if (vo.getStateNameWS() != null
							&& vo.getStateNameWS().size() > 0) 
					{
						
						strStateNameCombo = util.getOptionValue(vo.getStateNameWS(), "IND",
								"0^Select Value", false);
					} 
					else 
					{
						strStateNameCombo = "<option value='0'>Select Value</option>";
					}
				

				}
				/*
				 * strCommiteeNameValues =
				 * util.getOptionValue(vo.getCommiteeNameWS(), "0", "0^Select
				 * Value", false);
				 * vo.setStrCommiteeNameValues(strCommiteeNameValues);
				 * formBean.setStrCommiteeNameValues(vo.getStrCommiteeNameValues());
				 * 
				 * strSupplierGradeValues =
				 * util.getOptionValue(vo.getSupplierGradeWS(), "0", "0^Select
				 * Value", false);
				 * formBean.setStrSupplierGradeValues(strSupplierGradeValues);
				 */
				formBean.setStrItemCatNo(vo.getStrItemCatNo());
				formBean.setStrItemCategoryName(vo.getStrItemCategoryName());
				formBean.setStrStateNameCombo(strStateNameCombo);
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->initParamAddPage()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			util = null;
		}
	}
	/**
	 * This function is used to set initial parameters required to display on
	 * main page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void getState(HttpServletRequest request,HttpServletResponse response,
			SupplierMstFB formBean) {
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;
		HisUtil util = null;

		String strHospCode = "";
		String strCurrentDate = "";
		String strStateNameCombo = "";
		String strStateCode = "";
		// String strSupplierGradeValues = "";
		try {

			util = new HisUtil("mms", "SupplierMstDATA");

			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);

			vo = new SupplierMstVO();
			bo = new SupplierMstBO();

			String temp = request.getParameter("strCountryCode");
			
			
			vo.setStrCountryCode(temp);

			strHospCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strHospCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			formBean.setStrHospCode(strHospCode);
		
			vo.setStrHospCode(formBean.getStrHospCode());

			bo.getState(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{

				if (vo.getStateNameWS() != null
						&& vo.getStateNameWS().size() > 0) 
				{
					strStateCode = formBean.getStrStateCode();
					strStateNameCombo = util.getOptionValue(vo.getStateNameWS(), strStateCode,
							"0^Select Value", false);
				} 
				else 
				{
					strStateNameCombo = "<option value='0'>Select Value</option>";
				}
				
				//Set Response here
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strStateNameCombo);

			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->initParamAddPage()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			util = null;
		}
	}

	

	/*
	 * This function is used to insert data
	 */
	/**
	 * Insert.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void insert(HttpServletRequest request, SupplierMstFB formBean) {
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;
		String strHospCode;
		try {
			bo = new SupplierMstBO();

			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			strHospCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean.setStrHospCode(strHospCode);
			
			formBean.setStrLevelOneEsc(formBean.getStrLevelOneOpen()); 
			formBean.setStrLevelTwoEsc(formBean.getStrLevelTwoOpen());
			
			vo = (SupplierMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.SupplierMstVO", formBean);

			if (vo.getStrIsSupplier() == null
					|| vo.getStrIsSupplier().equals("")) {
				vo.setStrIsSupplier("0");
			}
			if (vo.getStrIsManufacturer() == null
					|| vo.getStrIsManufacturer().equals("")) {
				vo.setStrIsManufacturer("0");
			}
			if (vo.getStrIsAgent() == null || vo.getStrIsAgent().equals("")) {
				vo.setStrIsAgent("0");
			}
			if (vo.getStrIsBuyer() == null || vo.getStrIsBuyer().equals("")) {
				vo.setStrIsBuyer("0");
			}
			if (vo.getStrForeignerSuppFlag() == null
					|| vo.getStrForeignerSuppFlag().equals("")) {
				vo.setStrForeignerSuppFlag("0");
			}
			if (vo.getStrWhetherSupplierInterfacerequired() == null
					|| vo.getStrWhetherSupplierInterfacerequired().equals("")) {
				vo.setStrWhetherSupplierInterfacerequired("0");
			}
			
			// Calling BO Method
			//System.out.println("Data File 1");
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			} else if (vo.getStrWarnMsType().equals("1")) {
				formBean.setStrWarnMssgstring("Data is already Exist");
			} else {
				formBean.setStrItemCatNo(vo.getStrItemCatNo());

				formBean
						.setStrNormMssgstring("Record is successfully inserted");
			}
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->insert()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

	/**
	 * This function is used to invoke Bo's method to bring data on modify page.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void modify(HttpServletRequest request, SupplierMstFB formBean) {
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;
		HisUtil util = null;
		String temp1,strHospCode;
		String chk;
		String strChk;
		String strSuppTurnOverUnitVal;
		String strItemCatNo;
		String strCurrentDate;
		String strSupplierTypeVals;
		String strCountryNameCombo;
		String temp[] = null;
		
		try 
		{
			          util = new HisUtil("mms", "SupplierMstDATA");
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			            vo = new SupplierMstVO();
	                    bo = new SupplierMstBO();
	                    
	                    //1410000@100@1$1
  			           chk = request.getParameter("chk");
  			        strChk = chk.replace("$", "@");
			          temp = strChk.split("@");

			formBean.setStrCurrentDate(strCurrentDate);
			
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			
			vo.setStrSupplierId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSlNo(temp[2]);

			/*
			 * if (formBean.getStrStoreTypeId() != null ||
			 * formBean.getStrStoreTypeId().equals("")) strStoreTypeId =
			 * formBean.getStrStoreTypeId(); else strStoreTypeId =
			 * formBean.getCombo()[0];
			 * 
			 * vo.setStrStoreTypeId(strStoreTypeId);
			 */

			if (formBean.getStrItemCatNo() == null
					|| formBean.getStrItemCatNo().equals(""))
				strItemCatNo = formBean.getCombo()[0];
			else
				strItemCatNo = formBean.getStrItemCatNo();

			vo.setStrItemCatNo(strItemCatNo);
            // Calling BO Method
			bo.setinitParam(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// Calling BO Method
			bo.modify(vo);
			if (vo.getCountryNameWS() != null
					&& vo.getCountryNameWS().size() > 0) 
			{
				strCountryNameCombo = util.getOptionValue(vo.getCountryNameWS(), vo.getStrCountryCode(),
						"0^Select Value", false);
			} 
			else 
			{
				strCountryNameCombo = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrCountryNameCombo(strCountryNameCombo);
			
			////System.out.println("stateCode::"+vo.getStrStateCode());
			request.setAttribute("stateCode", vo.getStrStateCode());
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{

				// // //System.out.println("data
				// getStrSupplierGradeCode"+vo.getStrSupplierGradeCode());

				if (vo.getSupplierGradeWS() != null	&& vo.getSupplierGradeWS().size() > 0)
				{
					temp1 = util.getOptionValue(vo.getSupplierGradeWS(), vo.getStrSupplierGradeCode(),"0^Select Value", false);
				} else {
					temp1 = "<option value='0'>Select Value</option>";
				}

				
				
				formBean.setStrSupplierValuesModi(temp1);

				if (vo.getCommiteeNameWS() != null
						&& vo.getCommiteeNameWS().size() > 0) 
				{
					temp1 = util.getOptionValue(vo.getCommiteeNameWS(), vo
							.getStrCommitteCode(), "0^Select Value", false);
				} else 
				{
					temp1 = "<option value='0'>Select Value</option>";
				}

				formBean.setStrCommitteValuesModi(temp1);

				TransferObjectFactory.populateData(formBean, vo);
				
				if (vo.getWsSupplierType() != null
						&& vo.getWsSupplierType().size() > 0) 
				{
					strSupplierTypeVals = util.getOptionValue(vo.getWsSupplierType(), vo.getStrSupplierTypeCode(),
							"0^Select Value", false);
				} 
				else 
				{
					strSupplierTypeVals = "<option value='0'>Select Value</option>";
				}
				
				if (vo.getStrSuppTurnOverUnit() != null || !vo.getStrSuppTurnOverUnit().equals(""))
				{
					if(vo.getStrSuppTurnOverUnit().equals("1"))
					{
						strSuppTurnOverUnitVal = "<select name='strSuppTurnOverUnit'  class='comboMin'><option value='1' selected>Thousand.</option><option value='2'>Lac.</option><option value='3'>Crore.</option></select>";
					}
					else
					{
						if(vo.getStrSuppTurnOverUnit().equals("2"))
						{
							strSuppTurnOverUnitVal = "<select name='strSuppTurnOverUnit'  class='comboMin'><option value='1' selected>Thousand.</option><option value='2' selected>Lac.</option><option value='3'>Crore.</option></select>";
						}
						else
						{
							strSuppTurnOverUnitVal = "<select name='strSuppTurnOverUnit'  class='comboMin'><option value='1' selected>Thousand.</option><option value='2' >Lac.</option><option value='3' selected>Crore.</option></select>";
						}	
					}	
				} 
				else 
				{
					strSuppTurnOverUnitVal = "<select name='strSuppTurnOverUnit'  class='comboMin'><option value='1'>Thousand.</option><option value='2'>Lac.</option><option value='3'>Crore.</option></select>";
				}
				
				formBean.setStrSuppTurnOverUnitVal(strSuppTurnOverUnitVal);
				formBean.setStrSupplierTypeVals(strSupplierTypeVals);
							
				formBean.setStrSupplierProvMaintenance(vo.getStrSupplierProvMaintenance());
				
				
				
				if (vo.getStrEsclationMtxAvl().equals("1"))
				{
					formBean.setStrLevelOneOpen(vo.getStrLevelOneEsc());
					formBean.setStrLevelTwoOpen(vo.getStrLevelTwoEsc());
						if(vo.getStrLevelOneEsc().equals("1")&& vo.getStrLevelTwoEsc().equals("1"))
						{	
							formBean.setStrCotactPersonForEscLevelOne(vo.getStrCotactPersonForEsc()[0]);
			
							formBean.setStrContactPersonDesgForEscLevelOne(vo.getStrContactPersonDesgForEsc()[0]);
			
							formBean.setStrCotactEmailIdForEscLevelOne(vo.getStrCotactEmailIdForEsc()[0]);
			
							formBean.setStrCotactNoForEscLevelOne(vo.getStrCotactNoForEsc()[0]);
			
							formBean.setStrCotactFaxForEscLevelOne(vo.getStrCotactFaxForEsc()[0]);
							
							formBean.setStrCotactPersonForEscLevelTwo(vo.getStrCotactPersonForEsc()[1]);
							
							formBean.setStrContactPersonDesgForEscLevelTwo(vo.getStrContactPersonDesgForEsc()[1]);
			
							formBean.setStrCotactEmailIdForEscLevelTwo(vo.getStrCotactEmailIdForEsc()[1]);
			
							formBean.setStrCotactNoForEscLevelTwo(vo.getStrCotactNoForEsc()[1]);
			
							formBean.setStrCotactFaxForEscLevelTwo(vo.getStrCotactFaxForEsc()[1]);
						}
						else
						{
							
							formBean.setStrCotactPersonForEscLevelOne(vo.getStrCotactPersonForEsc()[0]);
							
							formBean.setStrContactPersonDesgForEscLevelOne(vo.getStrContactPersonDesgForEsc()[0]);
			
							formBean.setStrCotactEmailIdForEscLevelOne(vo.getStrCotactEmailIdForEsc()[0]);
			
							formBean.setStrCotactNoForEscLevelOne(vo.getStrCotactNoForEsc()[0]);
			
							formBean.setStrCotactFaxForEscLevelOne(vo.getStrCotactFaxForEsc()[0]);
						}	
						
				}
				formBean.setStrEsclationMtxAvl(vo.getStrEsclationMtxAvl());
				////System.out.println("Esc in DATA::::"+formBean.getStrEsclationMtxAvl());

				formBean.setStrSupplierStatusCode(vo.getStrSupplierStatus());
				formBean.setStrChk(chk);
				formBean.setStrWhetherSupplierInterfacerequired(vo.getStrWhetherSupplierInterfacerequired());

			}
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->modify()-", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			util = null;
		}
	}


	/**
	 * This function is used to invoke Bo's update method to update data.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * 
	 * @return true, if update
	 */
	public static Boolean update(HttpServletRequest request,
			SupplierMstFB formBean) {
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;
		Boolean retValue = true;
		String chk = "";
		String strChk = "";
		String strCountryNameCombo ="";
		//HisUtil util = null;
		try {
			//util = new HisUtil("mms", "SupplierMstDATA");
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			//1410000@100@1$1
			chk = request.getParameter("chk");

			strChk = chk.replace("$", "@");
			String temp[] = strChk.split("@");

			vo = (SupplierMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.SupplierMstVO", formBean);
			bo = new SupplierMstBO();

			vo.setStrSupplierId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSlNo(temp[2]);

			if (vo.getStrLocalPurchaseSuppFlag() == null
					|| vo.getStrLocalPurchaseSuppFlag().equals("")) {
				vo.setStrLocalPurchaseSuppFlag("0");
			}
			if (vo.getStrIsSupplier() == null
					|| vo.getStrIsSupplier().equals("")) {
				vo.setStrIsSupplier("0");
			}
			if (vo.getStrIsManufacturer() == null
					|| vo.getStrIsManufacturer().equals("")) {
				vo.setStrIsManufacturer("0");
			}
			if (vo.getStrIsAgent() == null || vo.getStrIsAgent().equals("")) {
				vo.setStrIsAgent("0");
			}
			if (vo.getStrIsBuyer() == null || vo.getStrIsBuyer().equals("")) {
				vo.setStrIsBuyer("0");
			}
			if (vo.getStrForeignerSuppFlag() == null
					|| vo.getStrForeignerSuppFlag().equals("")) {
				vo.setStrForeignerSuppFlag("0");
			}
			vo.setStrWhetherSupplierInterfacerequired(formBean.getStrWhetherSupplierInterfacerequired());
			bo.update(vo);
			
			formBean.setStrCountryNameCombo(strCountryNameCombo);
			
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			} else if (vo.getStrWarnMsType().equals("1")) {
				retValue = false;
				formBean.setStrWarnMssgstring("Data is already Exist");
			} else {
				formBean.setStrNormMssgstring("Record is successfully updated");

			}
			formBean.setStrChk(chk);
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->update()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;

		} finally {
			bo = null;
			vo = null;

		}
		return retValue;
	}

	/**
	 * This function is used to invoke Bo's method to bring data on view page.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void view(HttpServletRequest request, SupplierMstFB formBean) {
		SupplierMstBO bo = null;
		SupplierMstVO vo = null;

		String chk = "";
		String strChk = "";

		try {

			vo = new SupplierMstVO();
			bo = new SupplierMstBO();

			chk = request.getParameter("chk");

			strChk = chk.replace("$", "@");
			String temp[] = strChk.split("@");

			vo.setStrSupplierId(temp[0]);
			vo.setStrHospCode(temp[1]);

			bo.getView(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			TransferObjectFactory.populateData(formBean, vo);
			
			
			formBean.setStrSupplierProvMaintenance(vo.getStrSupplierProvMaintenance());
			formBean.setStrEsclationMtxAvl(vo.getStrEsclationMtxAvl());
			
			if(formBean.getStrEsclationMtxAvl().equals("1"))
			{	
				if(vo.getStrLevelOneEsc().equals("1")&& vo.getStrLevelTwoEsc().equals("1"))
				{	
					formBean.setStrCotactPersonForEscLevelOne(vo.getStrCotactPersonForEsc()[0]);
	
					formBean.setStrContactPersonDesgForEscLevelOne(vo.getStrContactPersonDesgForEsc()[0]);
					String mail=vo.getStrCotactEmailIdForEsc()[0].replaceAll(".", "dot");
					String mail1=mail.replaceAll("@", "at");
					formBean.setStrCotactEmailIdForEscLevelOne(mail1);
	
					formBean.setStrCotactNoForEscLevelOne(vo.getStrCotactNoForEsc()[0]);
	
					formBean.setStrCotactFaxForEscLevelOne(vo.getStrCotactFaxForEsc()[0]);
					
					formBean.setStrCotactPersonForEscLevelTwo(vo.getStrCotactPersonForEsc()[1]);
					
					formBean.setStrContactPersonDesgForEscLevelTwo(vo.getStrContactPersonDesgForEsc()[1]);
					String mail2=vo.getStrCotactEmailIdForEsc()[1].replaceAll(".", "dot");
					String mail3=mail2.replaceAll("@", "at");
					formBean.setStrCotactEmailIdForEscLevelTwo(mail3);
	
					formBean.setStrCotactNoForEscLevelTwo(vo.getStrCotactNoForEsc()[1]);
	
					formBean.setStrCotactFaxForEscLevelTwo(vo.getStrCotactFaxForEsc()[1]);
					formBean.setStrLevelOneStatus("Level 1");
					formBean.setStrLevelTwoStatus("Level 2");
					formBean.setStrLevelOneOpen("1");
					formBean.setStrLevelTwoOpen("1");
					
				}
				else
				{
					formBean.setStrCotactPersonForEscLevelOne(vo.getStrCotactPersonForEsc()[0]);
					
					formBean.setStrContactPersonDesgForEscLevelOne(vo.getStrContactPersonDesgForEsc()[0]);
	
					formBean.setStrCotactEmailIdForEscLevelOne(vo.getStrCotactEmailIdForEsc()[0]);
	
					formBean.setStrCotactNoForEscLevelOne(vo.getStrCotactNoForEsc()[0]);
	
					formBean.setStrCotactFaxForEscLevelOne(vo.getStrCotactFaxForEsc()[0]);
					formBean.setStrLevelOneStatus("Level 1");
					
					formBean.setStrLevelOneOpen("1");
					
				}	
			}			
			formBean.setStrSuppTurnOver(vo.getStrSuppTurnOver());
			
			//System.out.println("vo.getStrEmailId1()"+vo.getStrEmailId1());
			
			
			
			if("0".equals(vo.getStrSupplierProvMaintenance())) 
			{
				formBean.setStrSupplierProvMaintenanceStatus("No.");
			}
			else 
				if("1".equals(vo.getStrSupplierProvMaintenance())) 
				{
				   formBean.setStrSupplierProvMaintenanceStatus("Yes.");
			    }
			
			
			if("0".equals(vo.getStrEsclationMtxAvl())) 
			{
				formBean.setStrEsclationAvlStatus("No.");
			}
			else
				if("1".equals(vo.getStrIsSupplier()))
				{
					formBean.setStrEsclationAvlStatus("Yes.");
			}
			/////////////////
			
			
			if("0".equals(vo.getStrIsSupplier())) {
				formBean.setStrIsSupplier("No.");
			}else if("1".equals(vo.getStrIsSupplier())) {
				formBean.setStrIsSupplier("Yes.");
			}
			
			if("0".equals(vo.getStrIsManufacturer())) {
				formBean.setStrIsManufacturer("No.");
			}else if("1".equals(vo.getStrIsManufacturer())) {
				formBean.setStrIsManufacturer("Yes.");
			}
			
			if("0".equals(vo.getStrIsAgent())) {
				formBean.setStrIsAgent("No.");
			}else if("1".equals(vo.getStrIsAgent())) {
				formBean.setStrIsAgent("Yes.");
			}
			
			if("0".equals(vo.getStrIsBuyer())) {
				formBean.setStrIsBuyer("No.");
			}else if("1".equals(vo.getStrIsBuyer())) {
				formBean.setStrIsBuyer("Yes.");
			}
			
			if("0".equals(vo.getStrForeignerSuppFlag())) {
				formBean.setStrForeignerSuppFlag("No.");
			}else if("1".equals(vo.getStrForeignerSuppFlag())) {
				formBean.setStrForeignerSuppFlag("Yes.");
			}
						
			formBean.setStrSupplierStatusCode(vo.getStrSupplierStatus());
			
			if("1".equals(vo.getStrSupplierStatus())) {
				formBean.setStrSupplierStatus("Active");
			} else if("2".equals(vo.getStrSupplierStatus())) {
				formBean.setStrSupplierStatus("Black Listed");
			} else {
				formBean.setStrSupplierStatus(vo.getStrSupplierStatus());
			}
			formBean.setStrTurnOverWithUnit(vo.getStrSuppTurnOver()+" "+vo.getStrSuppTurnOverUnit());
			
			formBean.setStrChk(chk);
			if("0".equals(vo.getStrWhetherSupplierInterfacerequired())) {
				formBean.setStrWhetherSupplierInterfacerequired("No.");
			}else if("1".equals(vo.getStrWhetherSupplierInterfacerequired())) {
				formBean.setStrWhetherSupplierInterfacerequired("Yes.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierMstDATA->view()-", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

}
