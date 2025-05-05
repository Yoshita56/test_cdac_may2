package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.SimpleDateFormat;

import mms.MmsConfigUtil;
import mms.VOMms;
import mms.masters.bo.DrugMstBO;
import mms.masters.bo.GenericDrugMstBO;
import mms.masters.controller.fb.DrugMstFB;
import mms.masters.controller.fb.GenericDrugMstFB;
import mms.masters.vo.DrugMstVO;
import mms.masters.vo.GenericDrugMstVO;
import mms.setup.MmsConfigGeneral;
import mms.transactions.bo.SupplierTransactionRecordBO;
import mms.transactions.controller.fb.SupplierTransactionRecordFB;
import mms.transactions.vo.SupplierTransactionRecordVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class DrugMstDATA {

	/**
	 * Inits the param add.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void initParamAdd(HttpServletRequest request,DrugMstFB formBean)
	{
		HisUtil util = null;
		DrugMstBO bo = null;
		DrugMstVO vo = null;

		try {

			util = new HisUtil("MMS", "DrugMstDATA");
			vo = new DrugMstVO();
			bo = new DrugMstBO();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean.setStrHospitalCode(hosCode);

			if (request.getParameterValues("combo") != null)
			{
				String temp[] = request.getParameterValues("combo");
				formBean.setStrGroupId(temp[0]);
			}

			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			if (request.getParameter("comboValue") != null) 
			{
				String strComboValue = request.getParameter("comboValue");
				formBean.setStrComboValue(strComboValue);
			}
			String[] strTemp = formBean.getStrComboValue().replace("^", "#").split("#");
			formBean.setStrGroupName(strTemp[0]);
			// formBean.setStrGenericItemName(strTemp[1]);
			// vo.setStrGenericItemId(strGenericItemId)

			vo.setStrInventoryUnitId(MmsConfigUtil.UNIT_ID_PATNA);
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrItemCatId("10");
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			// Calling BO Method
			bo.initializeAdd(vo);

			
			
			

			formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			/*
			 * formBean.setStrUnitValues(util.getOptionValue(vo.getUnitValWs(),
			 * "0", "0^Select Value", false));
			 */

			formBean.setStrRateUnitId(vo.getStrRateUnitId());
			formBean.setStrRateUnitName(vo.getStrRateUnitName());
			
			
			//System.out.println("rate unit id is"+vo.getStrRateUnitId()+" "+vo.getStrRateUnitName());
			

			formBean.setStrManufacturerVal(util.getOptionValue(vo.getManufacturerWs(), "0", "0^Select Value", false));
			formBean.setStrItemTypeValues(util.getOptionValue(vo.getItemTypeWs(), "0", "0^Select Value", false));
			formBean.setStrGenericItemValues(util.getOptionValue(vo.getWsGenericItemValues(), "0", "0^Select Value", false));			
			formBean.setStrApprovedTypeOptions(util.getOptionValue(vo.getWrsApprovedTypeOptions(), "", "", false));			
			formBean.setStrIssueTypeComboOptions(util.getOptionValue(vo.getIssueTypeWs(), "0", "", false));
			formBean.setStrDrugClass(util.getOptionValue(vo.getDrugClassWs(), "0", "0^Select Value", false));
			
			

		} catch (Exception _e) {
			_e.printStackTrace();
			HisException eObj = new HisException("MMS",
					"DrugMstDATA->initParamAdd()", _e.getMessage());
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	/**
	 * Insert.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void insert(HttpServletRequest request, DrugMstFB formBean) {
		DrugMstBO bo = null;
		DrugMstVO vo = null;
		MmsConfigUtil mcu=null;
		String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		
		try 
		{  
			
			formBean.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
	
			vo = new DrugMstVO();
			bo = new DrugMstBO();

			String temp[] = request.getParameterValues("combo");

			if (temp[1] == null || temp[1].equals("") || temp[1].equals("0")) {
				temp[1] = "0";
			}

			String temp2[] = formBean.getStrGenericItemId().replace('^', '#').split("#");
			vo.setStrGroupId(temp[0]);
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemCatId("10");
			vo.setStrGenericItemId(temp2[0]);
			vo.setStrDrugName(formBean.getStrDrugName());
			vo.setStrManufacturerId(formBean.getStrManufacturerId());
			
			vo.setTEMP_SENS_FLAG(formBean.getTEMP_SENS_FLAG());
			vo.setMAX_VALUE(formBean.getMAX_VALUE());
			vo.setMIN_VALUE(formBean.getMIN_VALUE());
			
			vo.setHospCode(hospCode);
			
			

			/*
			 * Modified by Aritra Kumar Dhawa on 21st Dec. Reason: Change
			 * Request from Ajay Gupta.(Default should not be mandatory.)
			 */
			if (formBean.getStrDefaultRate() != null
					&& !formBean.getStrDefaultRate().trim().equals("")) {
				vo.setStrDefaultRate(formBean.getStrDefaultRate());
			} else {
				vo.setStrDefaultRate("0");
			}
			/* -0- */

			vo.setStrUnitId(formBean.getStrRateUnitId());
			vo.setStrApprovalType(formBean.getStrApprovedType());
			vo.setStrIssueType(formBean.getStrIssueType());
			vo.setStrSpecification(formBean.getStrSpecification());
			vo.setStrItemMake(formBean.getStrItemMake());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrIsValid("1");
			vo.setStrIsSachet(formBean.getStrIsItemSachet());
			vo.setStrItemType(formBean.getStrItemType());
			vo.setStrIsQuantified(formBean.getStrIsQuantifiable());
			vo.setStrBreakageFlg(formBean.getStrBreakageFlg());
			
			vo.setStrQCType(formBean.getStrQCType()); //	Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
			
			vo.setStrMktRate(formBean.getStrMktRate());
			vo.setStrMktRateUnitId(formBean.getStrMktRateUnitId());
			
			vo.setStrDrugClass(formBean.getStrDrugClass());
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			vo.setStrEdlCat(formBean.getStrEdlCat());
			vo.setStrIsMisc(formBean.getStrIsMisc());
			/*
			 * if (formBean.getStrIsItemCodeRequired().equals("1")) {
			 * 
			 * vo.setStrCPACode(temp2[2] + "." + formBean.getStrCPACode());
			 * 
			 * } else {
			 * 
			 * vo.setStrCPACode("0.0");
			 * 
			 * }
			 */

			if (formBean.getStrCPACode() != null
					&& !formBean.getStrCPACode().trim().equals("")) {
				if("0".equals(temp2[2])) {
					vo.setStrCPACode(formBean.getStrCPACode());
				} else {
					vo.setStrCPACode(temp2[2] + "." + formBean.getStrCPACode());	
				}
				

			} else {
				/*
				 * This block will be in action when HSTNUM_ITEMCODE_FLAG field
				 * in sstt_item_category_mst table is set to 0 for
				 * SSTNUM_ITEM_CAT_NO=10. Because in that case Item Code field
				 * is not mandatory in the screen. So user may left this field
				 * blank.
				 */
				vo.setStrCPACode(""); // Empty String
			}

			vo.setStrDrugType(formBean.getStrDrugType());
			
			if(formBean.getStrIssueRateConfigFlg().equals("1"))
			{	
			  vo.setStrConfigIssueRate(formBean.getStrConfigIssueRate());
			}
			else
			{
			  vo.setStrConfigIssueRate("0");	
			}	
			
			
			vo.setStrConfigIssueRate(formBean.getStrConfigIssueRate());
			vo.setStrHSNCode(formBean.getStrHSNCode());
			
			System.out.println("formBean.getMAX_VALUE()---------DATA-------->"+vo.getMAX_VALUE());
			System.out.println("formBean.getTEMP_SENS_FLAG()----------------->"+vo.getTEMP_SENS_FLAG());
			System.out.println("formBean.getMIN_VALUE()----------------->"+vo.getMIN_VALUE());
			
			
			// Calling BO Method
			bo.insert(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			if (vo.getBExistStatus() == false) {
				formBean.setStrWarningMsg("Data already exist");
			} else {
				formBean.setStrNormalMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugMstDATA->insert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * Modify.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void modify(HttpServletRequest request, DrugMstFB formBean) {
		DrugMstBO bo = null;
		DrugMstVO vo = null;
		HisUtil util = null;
		String temp[] = null;
		String cmb = "";
		String cmb1 = "";
		// String cmb2 = "";
		String strChk = "";
		String temp1[] = null;
		try {
			vo = new DrugMstVO();
			bo = new DrugMstBO();

			String temp3[] = request.getParameterValues("combo");

			formBean.setStrGroupId(temp3[0]);
			formBean.setStrGenericItemId(temp3[1]);

			if (temp3[1] == null || temp3[1].equals("") || temp3[1].equals("0")) {
				temp3[1] = "0";
			}

			/*
			 * String temp2[] = formBean.getStrGenericItemId().replace('^', '#')
			 * .split("#"); vo.setStrGenericItemId(temp2[0]);
			 * vo.setStrInventoryUnitId(temp2[1]);
			 */

			formBean.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			if (request.getParameter("chk") != null) {
				strChk = request.getParameter("chk");
				strChk = strChk.replace("$", "@");
				temp = strChk.split("@");
				formBean.setStrChk(strChk);
			} else {
				strChk = formBean.getStrChk();
				strChk = strChk.replace("$", "@");
				temp = strChk.split("@");
			}
			vo.setStrItemBrandId(temp[0]);
			vo.setStrHospitalCode(temp[1]);
			vo.setStrItemType(temp[2]);
			vo.setStrSerialNo(temp[3]);
			vo.setStrInventoryUnitId(MmsConfigUtil.UNIT_ID_PATNA);
			
			vo.setStrItemCatId("10");// Item Category 10 is for drug.
			

			if (request.getParameter("comboValue") != null) 
			{

				String strCmbVal = request.getParameter("comboValue");
				strCmbVal = strCmbVal.replace("^", "#");
				temp1 = strCmbVal.split("#");
				formBean.setStrTempCmbValue(strCmbVal);

			}
			else 
			{
				String strCmbVal = formBean.getStrTempCmbValue();
				strCmbVal = strCmbVal.replace("^", "#");
				temp1 = strCmbVal.split("#");
			}
			
            // Calling BO Method
			bo.modify(vo);
			
			bo.getItemCodeRequired(vo);
			bo.getIssueType(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				util = new HisUtil("MMS", "DrugMstDATA");

				cmb = util.getOptionValue(vo.getItemTypeWs(),
						vo.getStrItemType(), "0^Select Value", false);
				formBean.setStrItemTypeValues(cmb);

				cmb1 = util.getOptionValue(vo.getManufacturerWs(),
						vo.getStrManufacturerId(), "0^Select Value", false);
				formBean.setStrManufacturerVal(cmb1);

				/*
				 * This code is added by Aritra on 31st May, 2010 Reason: to
				 * show Rate Unit combo properly.
				 */
				String cmb2 = util.getOptionValue(vo.getUnitValWs(),
						vo.getStrRateUnitId(), "0^Select Value", false);
				formBean.setStrUnitValues(cmb2);

				/*
				 * This line of code is deactivated by Aritra on 31st May, 2010
				 * Reason: Rate unit combo not beeing shown
				 * formBean.setStrRateUnitId(vo.getStrRateUnitId());
				 * formBean.setStrRateUnitName(vo.getStrRateUnitName());
				 */

				formBean.setStrGroupName(temp1[0]);
				// formBean.setStrGenericItemName(temp1[1]);
				// formBean.setStrDrugType(temp1[2]);

				formBean.setStrDrugName(vo.getStrDrugName());
				formBean.setStrDefaultRate(vo.getStrDefaultRate());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());
				formBean.setStrIssueType(vo.getStrIssueType());
				formBean.setStrApprovedType(vo.getStrApprovalType());
				formBean.setStrItemMake(vo.getStrItemMake());
				formBean.setStrSpecification(vo.getStrSpecification());
				formBean.setStrIsItemSachet(vo.getStrIsSachet());
				formBean.setStrIsQuantifiable(vo.getStrIsQuantified());

				formBean.setStrGenericItemName(vo.getStrGenericItemName());
				formBean.setStrConfigIssueRate(vo.getStrConfigIssueRate());
				formBean.setStrQCType(vo.getStrQCType()); //Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
				
				formBean.setStrMktRate(vo.getStrMktRate());
				formBean.setStrMktRateUnitId(vo.getStrMktRateUnitId());
				formBean.setStrGenericItemId(vo.getStrGenericItemId());
				
				
				formBean.setStrDrugClass(vo.getStrDrugClass());
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				formBean.setStrIsMisc(vo.getStrIsMisc());
				formBean.setStrGroupId(vo.getStrGroupId());
				/*
				 * Previously generic drug part of the drug code was referenced
				 * as Prev CPA code.
				 */
				formBean.setStrPrevCPACode(vo.getStrGenericDrugCode());
				if (vo.getStrNewCPACode() != null
						&& !vo.getStrNewCPACode().equals("")) {
					/*
					 * The following code will extract drug part of drug code. If
					 * drug code is PAR.003 then PAR is generic drug part and
					 * 003 is drug part.
					 */
					String strDrugCode = vo.getStrNewCPACode();
					String strDrugCodeDrugPart;
					int nFirstIndexOfDot = strDrugCode.indexOf('.');
					strDrugCodeDrugPart = strDrugCode
							.substring(nFirstIndexOfDot + 1);

					/*
					 * Previously drug part of the drug code was referenced as
					 * new CPA code.
					 */

					formBean.setStrNewCPACode(strDrugCodeDrugPart);
				} else {
					formBean.setStrNewCPACode(""); // empty string
				}

				/*
				 * String[] strCPACodes = vo.getStrNewCPACode().replace(".",
				 * "#") .split("#");
				 * 
				 * if (strCPACodes.length > 1) {
				 * 
				 * formBean.setStrPrevCPACode(strCPACodes[0]);
				 * formBean.setStrNewCPACode(strCPACodes[1]);
				 * 
				 * } else if (strCPACodes.length == 0) {
				 * 
				 * formBean.setStrPrevCPACode("0");
				 * formBean.setStrNewCPACode("0");
				 * 
				 * } else {
				 * 
				 * formBean.setStrPrevCPACode(strCPACodes[0]);
				 * formBean.setStrNewCPACode("0");
				 * 
				 * }
				 */

				formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
				formBean.setStrDrugType(vo.getStrDrugType());
				
				/*Added by Aritra */
				formBean.setStrApprovedTypeOptions(util.getOptionValue(
						vo.getWrsApprovedTypeOptions(), vo.getStrApprovalType() , "0^Select Value", false));
				
				formBean.setStrIssueTypeComboOptions(util.getOptionValue(
						vo.getIssueTypeWs(), vo.getStrIssueType(), "", false));
				
				formBean.setStrHSNCode(vo.getStrHSNCode());
//				
				
				formBean.setStrEdlCat(vo.getStrEdlCat());
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());

				}
				util = new HisUtil("MMS Master", "DrugMstDATA");
				String unitCmb = "<option value='0'>Select Value</option>";

				if (vo.getWsUnitList()!=null &&  vo.getWsUnitList().size() > 0) 
				{			//	//System.out.println(" vo.getStrRateUnitId()"+ vo.getStrRateUnitId()); 
					unitCmb = util.getOptionValue(vo.getWsUnitList(), "", "",true);

				}else{
					
					unitCmb = "<option value='0'>Select Value</option>";
				}

				formBean.setStrMktRateUnitIdValues(unitCmb);
				
				// added by vikram on 13 Dec 2021 for max, min, temp fields
				formBean.setMAX_VALUE(vo.getMAX_VALUE());
				formBean.setMIN_VALUE(vo.getMIN_VALUE());
				formBean.setTEMP_SENS_FLAG(vo.getTEMP_SENS_FLAG());
				
				//System.out.println("formbeans"+formBean.getMAX_VALUE()+""+formBean.getMIN_VALUE()+""+formBean.getTEMP_SENS_FLAG());
				

			}
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugMstDATA->modify()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			util = null;
		}
	}

	/**
	 * Update.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if successful
	 */
	public static boolean update(HttpServletRequest request, DrugMstFB formBean) 
	{
		DrugMstBO bo = null;
		DrugMstVO vo = null;
		boolean retValue = true;
		String temp[] = null;
		try 
		{
			bo = new DrugMstBO();
			vo = new DrugMstVO();
			formBean.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			String strChk = request.getParameter("chk");
			temp = strChk.replace('@', '#').split("#");

			vo.setStrDrugName(formBean.getStrDrugName());

			/*
			 * Modified by Aritra Kumar Dhawa on 21st Dec. Reason: Change
			 * Request from Ajay Gupta.(Default should not be mandatory.)
			 */
			if (formBean.getStrDefaultRate() != null
					&& !formBean.getStrDefaultRate().trim().equals("")) {
				vo.setStrDefaultRate(formBean.getStrDefaultRate());
			} else {
				vo.setStrDefaultRate("0");
			}
			/* -0- */

			vo.setStrUnitId(formBean.getStrRateUnitId());
			vo.setStrManufacturerId(formBean.getStrManufacturerId());
			vo.setStrApprovalType(formBean.getStrApprovedType());
			vo.setStrIssueType(formBean.getStrIssueType());
			vo.setStrSpecification(formBean.getStrSpecification());
			vo.setStrItemMake(formBean.getStrItemMake());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrIsSachet(formBean.getStrIsItemSachet());
			vo.setStrItemType(formBean.getStrItemType());
			vo.setStrIsQuantified(formBean.getStrIsQuantifiable());
			vo.setStrConfigIssueRate(formBean.getStrConfigIssueRate());
			vo.setStrGenericItemId(formBean.getStrGenericItemId());
						
			vo.setStrQCType(formBean.getStrQCType()); //	Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
			vo.setStrMktRate(formBean.getStrMktRate());
			vo.setStrMktRateUnitId(formBean.getStrMktRateUnitId());
			
			vo.setStrItemBrandId(temp[0]);
			vo.setStrHospitalCode(temp[1]);
			vo.setStrSerialNo(temp[3]);
			vo.setStrItemCatId("10");
			
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			vo.setStrDrugClass(formBean.getStrDrugClass());
			vo.setStrIsMisc(formBean.getStrIsMisc());
			vo.setStrGroupId(formBean.getStrGroupId());
			/*
			 * if (formBean.getStrIsItemCodeRequired().equals("1")) {
			 * 
			 * vo.setStrCPACode(formBean.getStrPrevCPACode() + "." +
			 * formBean.getStrNewCPACode());
			 * 
			 * } else {
			 * 
			 * vo.setStrCPACode("0.0");
			 * 
			 * }
			 */

			if (formBean.getStrNewCPACode() != null
					&& !formBean.getStrNewCPACode().trim().equals("")) {

			//	if("0".equals(formBean.getStrPrevCPACode())) {
					vo.setStrCPACode(formBean.getStrNewCPACode());
			//	} else {
				//	vo.setStrCPACode(formBean.getStrPrevCPACode() + "."	+ formBean.getStrNewCPACode());	
				//}
				

			} else {

				vo.setStrCPACode("");

			}
			vo.setStrDrugType(formBean.getStrDrugType());
			vo.setStrHSNCode(formBean.getStrHSNCode());
			vo.setStrEdlCat(formBean.getStrEdlCat());
			
			vo.setTEMP_SENS_FLAG(formBean.getTEMP_SENS_FLAG());
			vo.setMAX_VALUE(formBean.getMAX_VALUE());
			vo.setMIN_VALUE(formBean.getMIN_VALUE());
			
			
            // Calling BO Method
			bo.update(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getBExistStatus() == false) {
				formBean.setStrWarningMsg("Data already exist");
				retValue = false;
			} else {
				formBean.setStrNormalMsg("Data Saved Successfully");
			}
		} catch (Exception e) {
			retValue = false;
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugMstDATA->update()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * View.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void view(HttpServletRequest request, DrugMstFB formBean) {
		DrugMstBO bo = null;
		DrugMstVO vo = null;

		String temp[] = null;
		String temp1[] = null;
		try {
			vo = new DrugMstVO();
			bo = new DrugMstBO();
			formBean.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			String strChk = request.getParameter("chk");
			strChk = strChk.replace("$", "@");
			temp = strChk.split("@");

			vo.setStrItemBrandId(temp[0]);
			vo.setStrHospitalCode(temp[1]);

			if (request.getParameter("comboValue") != null) {

				String strCmbVal = request.getParameter("comboValue");
				strCmbVal = strCmbVal.replace("^", "#");
				temp1 = strCmbVal.split("#");
				formBean.setStrTempCmbValue(strCmbVal);

			} else {
				String strCmbVal = formBean.getStrTempCmbValue();
				strCmbVal = strCmbVal.replace("^", "#");
				temp1 = strCmbVal.split("#");
			}

			bo.view(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				/*
				 * cmb = util.getOptionValue(vo.getItemTypeWs(),
				 * vo.getStrItemType(), "0^Select Value", false);
				 * formBean.setStrItemTypeValues(cmb);
				 * 
				 * cmb = util.getOptionValue(vo.getManufacturerWs(),
				 * vo.getStrManufacturerId(), "0^Select Value", false);
				 * formBean.setStrManufacturerVal(cmb);
				 * 
				 * cmb = util.getOptionValue(vo.getUnitValWs(),
				 * vo.getStrUnitId(),"0^Select Value", false);
				 * formBean.setStrUnitValues(cmb);
				 */

				// formBean.setStrGroupName(temp1[0]);
				// formBean.setStrGenericItemName(temp1[1]);
				// formBean.setStrDrugType(temp1[2]);
				formBean.setStrDrugType("0");

				formBean.setStrDrugName(vo.getStrDrugName());
				formBean.setStrDefaultRate(vo.getStrDefaultRate());
				formBean.setStrUnit(vo.getStrUnit());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());
				formBean.setStrManufacturer(vo.getStrManufacturer());

				/*if ("1".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("Only To Patient");
				} else if ("2".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("Only To Staff");
				} else if ("3".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("Patient/Staff");
				} else {
					formBean.setStrIssueType(vo.getStrIssueType());
				}*/

				if ("1".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("S");
				} else if ("2".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("T");
				} else if ("3".equals(vo.getStrIssueType())) {
					formBean.setStrIssueType("U");
				} else {
					formBean.setStrIssueType(vo.getStrIssueType());
				}
				
				formBean.setStrApprovedTypeName(vo.getStrApprovedTypeName());

				if ("1".equals(vo.getStrItemMake())) {
					formBean.setStrItemMake("Indian");
				} else if ("2".equals(vo.getStrItemMake())) {
					formBean.setStrItemMake("Foreign");
				} else {
					formBean.setStrItemMake(vo.getStrItemMake());
				}

				// formBean.setStrItemMake(vo.getStrItemMake());
				formBean.setStrSpecification(vo.getStrSpecification());
				formBean.setStrItemType(vo.getStrItemType());

				if ("0".equals(vo.getStrIsSachet())) {
					formBean.setStrIsItemSachet("No.");
				} else if ("1".equals(vo.getStrIsSachet())) {
					formBean.setStrIsItemSachet("Yes.");
				} else {
					formBean.setStrIsItemSachet(vo.getStrIsSachet());
				}

				if ("0".equals(vo.getStrIsQuantified())) {
					formBean.setStrIsQuantifiable("No.");
				} else if ("1".equals(vo.getStrIsQuantified())) {
					formBean.setStrIsQuantifiable("Yes.");
				} else {
					formBean.setStrIsQuantifiable(vo.getStrIsQuantified());
				}

				formBean.setStrCPACode(vo.getStrCPACode());
				formBean.setStrGenericItemName(vo.getStrGenericItemName());
				formBean.setStrGroupName(vo.getStrGroupName());
				formBean.setStrConfigIssueRate(vo.getStrConfigIssueRate());
				formBean.setStrQCType(vo.getStrQCType()); //Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011

				formBean.setStrMktRate(vo.getStrMktRate());
				formBean.setStrMktRateUnitId(vo.getStrMktRateUnitId());
				formBean.setStrEdlCat(vo.getStrEdlCat());
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "DrugMstDATA->view()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}
	
	
	
	public static void getStrMktUnitIdBasedOnItemId(DrugMstFB formBean,	HttpServletRequest request, HttpServletResponse response) {

		DrugMstBO bo = null;
		DrugMstVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DrugMstBO();
			voObj = new DrugMstVO();
			
			formBean.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrGenericItemId((request.getParameter("genericItemId")==null || request.getParameter("genericItemId").equals(""))?"0":request.getParameter("genericItemId"));
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrItemCatId("10");
			
			//System.out.println("generic item id is "+request.getParameter("genericItemId"));
			
			bo.getUnitNameComboBasedOnItemId(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Master", "DrugMstDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getWsUnitList()!=null &&  voObj.getWsUnitList().size() > 0) 
			{				
				temp = util.getOptionValue(voObj.getWsUnitList(), "", "",true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
//			e.printStackTrace();
			strmsgText = "mms.transactions.DrugMstDATA.getDDWList --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"DrugMstDATA->getDDWList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	
public static void checkDATAExists(DrugMstFB fb,String[] strChk){
		
		DrugMstVO vo = null;
		vo = new DrugMstVO();
		
		vo = (DrugMstVO) TransferObjectFactory.populateData("mms.masters.vo.DrugMstVO", fb);
		DrugMstBO.checkDataExists(vo,strChk);
		
		
		fb = (DrugMstFB) TransferObjectFactory.populateData("mms.masters.controller.fb.DrugMstFB", vo);
		HelperMethods.populate(fb,vo);
		if(vo.getBExistStatus() == true)
		{
			fb.setStrNormalMsg("Can Not Delete The Data.Child Record Exists.)");
		}
		else
		{
			
		}
		if(fb.getStrMsgType().equals("1"))
			fb.setStrErrMsg("DrugMstDATA.deleteData() -->"+fb.getStrErrMsg());
	}

	public static void checkDrugDuplicacy(DrugMstFB fb,  HttpServletRequest request, HttpServletResponse response) {
	String getExistingDrugCodeTablePrint = "";

    try {
        DrugMstVO vo = new DrugMstVO();
        DrugMstBO bo = new DrugMstBO();

        //vo = (DrugMstVO) TransferObjectFactory.populateData("mms.masters.vo.DrugMstVO", fb);

        String newCPACode = request.getParameter("strNewCPACode");
	     if (newCPACode == null || newCPACode.trim().isEmpty()) {
	         newCPACode = "0";
	     }
		 System.out.println("strNewCPACode--->"+request.getParameter("strNewCPACode"));
		 System.out.println("strDrugName--->"+request.getParameter("strDrugName"));
			/*System.out.println("strItemBrandId--->"+request.getParameter("strItemBrandId"));
			System.out.println("strGenericItemId--->"+request.getParameter("strGenericItemId"));*/
		 System.out.println("mode--->"+request.getParameter("mode"));

	     String strNewCPACode = request.getParameter("strNewCPACode");
		 fb.setStrNewCPACode(strNewCPACode);
	     vo.setStrNewCPACode(request.getParameter("strNewCPACode"));

	     String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
	     vo.setStrHospitalCode(hosCode);
	     
	     vo.setStrModeVal(request.getParameter("mode"));
	     vo.setStrDrugName(request.getParameter("strDrugName"));
			/*vo.setStrItemBrandId(request.getParameter("strItemBrandId"));
			vo.setStrGenericItemId(request.getParameter("strGenericItemId"));*/

	     DrugMstBO.checkDrugDuplicacy(vo);// pkg_mms_view2.Proc_Validate_Cpa_Code_Data 

	     System.out.println("DATA--CHECKDRUGDUPLICACY--SIZE-->" + vo.getDrugClassWs().size());

	     getExistingDrugCodeTablePrint = getExistingDrugCodeTablePrintHLP(vo.getDrugClassWs());

	     response.setHeader("Cache-Control", "no-cache");
	     response.getWriter().print(getExistingDrugCodeTablePrint);
        
    } catch (Exception e) {
        e.printStackTrace();
    	}
	}
	
	private static String getExistingDrugCodeTablePrintHLP(WebRowSet wrs) throws SQLException, Exception {

		StringBuffer sb= new StringBuffer(100);

		int i = 1;

		new SimpleDateFormat("dd-MMM-yyyy");
		sb.append("<table class='TABLEWIDTH text-uppercase' style='text-align:center;'>");
		sb.append("<tr class='TITLE'>");
		sb.append("<td colspan='6' style='text-align:left;'>Existing Items For Entered Drug Code</td>");
		
		sb.append("<td colspan='6' style='text-align: right;'>");
		sb.append("<div id='printImg' style='display: inline-block;'>");
		sb.append("<img style='cursor: pointer;' title='Close Page' src='../../hisglobal/images/stop.png' onclick='hideExistingDrugCodeBlock();' />");
		sb.append("</div>");
		sb.append("</td>");
		
		sb.append("</tr>");
		sb.append("</table>");

		sb.append("<table class='TABLEWIDTH text-uppercase' style='text-align:center;text-transform:uppercase;background-color:#CBEFBE; border:1px solid black'>");
		sb.append("<tr>");
		sb.append("<thead>");
		sb.append("<td width='20%'>SR NO</td>");
		sb.append("<td width='40%'>ITEM NAME</td>");
		sb.append("<td width='40%'>DRUG CODE</td>");
		sb.append("</thead>");
		sb.append("</tr>");
		
		sb.append("<tbody>");

		if (wrs != null && wrs.size() > 0) {
			while (wrs.next()) {
				/*
				1.HSTSTR_CPA_CODE
				2. hststr_item_name
				3. hstnum_default_rate
				4. hstnum_item_id
				5. hstnum_itembrand_id
				6. hstnum_itemtype_id
				*/
				String drugCode = wrs.getString(1);
				String itemName = wrs.getString(2);
				//String defaultRate = wrs.getString(3);
				
				sb.append("<tr>");
				sb.append("<td width='20%'>" +i+"</td>");
				sb.append("<td width='40%' style='color:red;'>" + itemName + "</td>");
				sb.append("<td width='40%' style='color:red;'>" + drugCode + "</td>");
//				sb.append("<td width='30%'>" + defaultRate + "</td>");
				sb.append("</tr>");
				i++;
			}
		} else {
			sb.append("<tr style='text-align:center; color:red;'><td colspan='4'>No records found for the entered Drug code/Drug Name</td></tr>");
		}
		sb.append("</tbody>");
		sb.append("</table>");

		return sb.toString();
	}

	
	
}
