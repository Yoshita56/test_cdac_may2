package dossier.masters.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dossier.masters.bo.DossierItemBrandMstBO;
import dossier.masters.controller.fb.DossierItemBrandMstFB;
import dossier.masters.controller.hlp.DossierItemBrandMstHLP;
import dossier.masters.vo.DossierItemBrandMstVO;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc

public class DossierItemBrandMstDATA {
	/**
	 * For Initial Values.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void initAdd(HttpServletRequest request, DossierItemBrandMstFB formBean) {
		HisUtil hisutil = null;
		DossierItemBrandMstBO bo = null;
		DossierItemBrandMstVO vo = null;
		String cmb = "";
		String strmsgText = "";
		String[] temp = null;
		
		String hosCode = "";
		String seatid = "";
		String strItemCategoryId = "";
		String strGroupId = "";
		String hosp_code = "";
		String cmb1 = "",strDeptCode="";
		
		try {

			vo = new DossierItemBrandMstVO();
			bo = new DossierItemBrandMstBO();

			hisutil = new HisUtil("dossier", "DossierItemBrandMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(ctDate);

			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				formBean.setStrComboValues(strComboValues);
				temp = strComboValues.replace('^', '#').split("#");

				//formBean.setStrItemCatName(temp[0]);
				//formBean.setStrGroupName(temp[1]);
				formBean.setStrDeptName(temp[0]);
				

			}
			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			hosp_code = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			seatid = request.getSession().getAttribute("SEATID").toString();
			/*if(formBean.getStrItemCatNo() == "" || formBean.getStrGroupId()== "")
				if (formBean.getCombo()[0] != null) {
				strItemCategoryId = formBean.getCombo()[0];
				strGroupId = formBean.getCombo()[1];
				
				formBean.setStrItemCatNo(strItemCategoryId);
				formBean.setStrGroupId(strGroupId);
				System.out.println("item category id --->> "+strItemCategoryId);
				System.out.println("group id --->> "+strGroupId);
				
			}*/
			if(formBean.getStrDeptCode() == "")
				if (formBean.getCombo()[0] != null) {
				
				strDeptCode = formBean.getCombo()[0];
				formBean.setStrDeptCode(strDeptCode);
				
			}
			
			System.out.println("dept code :: -->> "+strDeptCode);
			formBean.setStrHospCode(hosp_code);
			formBean.setStrSeatId(seatid);
			formBean.setStrIsMisc(request.getParameter("strIsMisc"));
			
			vo.setStrHospCode(hosp_code);
			vo.setStrSeatId(seatid);
			vo.setStrDeptCode(formBean.getStrDeptCode());
			vo.setStrDeptName(formBean.getStrDeptName());
			/*vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrGroupId(formBean.getStrGroupId());*/
			vo.setStrIsMisc(formBean.getStrIsMisc());
			
			bo.initialAdd(vo);

			cmb = hisutil.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

			formBean.setStrLeftRequestTypeList(cmb);
			
			if (vo.getStrRightRequestTypeListWs() != null){
				cmb1 = hisutil.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
			}
			
			formBean.setStrRightRequestTypeList(cmb1);
							

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "Dossier Item Brand Master.DossierItemBrandMstDATA.initAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierItemBrandMstDATA->initAdd()", strmsgText);

			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	public static void getItemCatValues(DossierItemBrandMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DossierItemBrandMstBO bo = null;
		DossierItemBrandMstVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DossierItemBrandMstBO();
			voObj = new DossierItemBrandMstVO();
			
			String strStoreId = "1012010"; //formBean.getStrId();
			String strModeVal = "5";//request.getParameter("modeVal");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE")
					.toString());
				
			
			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("Dossier Masters", "DossierItemBrandMstDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "10", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			//response.setHeader("Cache-Control", "no-cache");
			//response.getWriter().print(temp);
			formBean.setStrItemCatValues(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "dossier.masters.DossierItemBrandMstDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierItemBrandMstDATA->getItemCatDtls()", strmsgText);
			/*formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");*/

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
	 * to insert the data.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */

	public static void insert(DossierItemBrandMstFB formBean, HttpServletRequest request) 
	{
		DossierItemBrandMstBO bo = null;
		DossierItemBrandMstVO vo = null;
		HisUtil util=null;
		String strmsgText = "";
		String temp[] = null;

		String strCategoryNo = "", strDeptCode="";
		String strStoreId = "";
		String hosCode = "",strCurrentDate="";
		String seatid = "";
		String strStoreCombo = "";
		String strDossierCombo="";
		String strDossierId="";
		int nRightListLen = 0;
		String rightItemListArray[] = null;
		String strItemCategoryId="", strGroupId="";
		HisUtil hisutil = null;

		try {
			util = new HisUtil("dossier", "DossierMstData");
			bo = new DossierItemBrandMstBO();
			vo = new DossierItemBrandMstVO();

			String hosp_code = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			//String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatid);
		
			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				formBean.setStrComboValues(strComboValues);
				temp = strComboValues.replace('^', '#').split("#");

				//formBean.setStrItemCatName(temp[0]);
				//formBean.setStrGroupName(temp[1]);
				formBean.setStrDeptName(temp[0]);
				
				System.out.println("dept name --->> "+temp[0]);
				//System.out.println("group name --->> "+temp[1]);

			}
			
			/*if(formBean.getStrDeptCode() == "")
				if (formBean.getCombo()[0] != null) {
				//strItemCategoryId = formBean.getCombo()[0];
				//strGroupId = formBean.getCombo()[1];
					strDeptCode = formBean.getCombo()[0];
					formBean.setStrDeptCode(strDeptCode);
				//formBean.setStrItemCatNo(strItemCategoryId);
				//formBean.setStrGroupId(strGroupId);
				System.out.println("dept id --->> "+strDeptCode);
				//System.out.println("group id --->> "+strGroupId);
				
			}
*/
			formBean.setStrIsValid("1");
			//formBean.setStrIsMisc(request.getParameter("strIsMisc"));
			formBean.setStrEffectiveFrom(strCurrentDate);
			
			//System.out.println("is misc --->> "+request.getParameter("strIsMisc"));
			
			vo = (DossierItemBrandMstVO) TransferObjectFactory.populateData(
					"dossier.masters.vo.DossierItemBrandMstVO", formBean);
			
			/*vo.setStrIsValid("1");
			vo.setStrIsMisc(request.getParameter("strIsMisc"));
			vo.setStrEffectiveFrom(strCurrentDate);
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrItemCatName(formBean.getStrItemCatName());
			vo.setStrGroupName(formBean.getStrGroupName());*/
			
			/*rightItemListArray = formBean.getStrRightRequestTypes();
			nRightListLen = rightItemListArray.length;
			vo.setStrRightRequestTypes(rightItemListArray);
			
			System.out.println("right item list length --->>>> "+nRightListLen);
			*/
			/*for (int i = 0; i < nRightListLen; i++) {
				if (!rightItemListArray[i].equals("0")) {
					vo.setStrItemBrandId(rightItemListArray[i]);
					bo.insertRecord(vo);
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
				}

			}*/

			/*temp = vo.getStrItemId().replace("^", "#").split("#");
			vo.setStrItemId(temp[0]);
			
			System.out.println("vo.setStrItemId ---->>>>>>>>>> "+vo.getStrItemId());*/
			
			vo.setStrHospiCode(hosp_code);
			//System.out.println("dept code -->> "+formBean.getStrDeptCode());

			System.out.println("global hosp code --->>"+vo.getStrHospiCode());
			
			System.out.println("dept code --->>> "+vo.getStrDeptCode());
			
			for(int i=0;i<vo.getStrQtyText().length;i++)
				System.out.println("Quantity array values --->>> "+vo.getStrQtyText()[i]);
			
			for(int i=0;i<vo.getItemParamValue().length;i++)
				System.out.println("item param value array values --->>> "+vo.getItemParamValue()[i]);
					
			for(int i=0;i<vo.getStrDefRateText().length;i++)
				System.out.println("def rate array values --->>> "+vo.getStrDefRateText()[i]);
				
				System.out.println("item kit name -->> *"+vo.getStrItemKitName()+"* dept code -->> "+vo.getStrDeptCode());
				bo.insertQuery(vo);
				
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}

				if (vo.getBExistStatus() == false) 
				{
					formBean.setStrWarnMssgstring("Data already exists");
				} 
				else 
				{
					formBean.setStrNormMssgstring("Data Saved Successfully");
				}			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "DossierItemBrandMaster.DossierItemBrandMstDATA.insert(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("dossier","DossierItemBrandMstDATA->insert()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			vo = null;
			bo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void modifyRecord(DossierItemBrandMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DossierItemBrandMstVO vo = null;
		DossierItemBrandMstBO bo = null;
		boolean retValue = true;
		String strtemp = null;
		String strtemp2[] = null;
		String chk = "";
		String seatid="";
		HisUtil hisutil;
		String temp[] = null;
		
		String strtempchk[] = null;
		String hosCode = "";
		String rightItemListArray[] = null;
		int nRightListLen = 0;

		String strItemGroupName = "";
		String strComboName = "";
		String strItemCategoryName = "";
		String cmb = "" , cmb1 = "";
		String ctDate = "";
		String strItemCategoryId = "" , strGroupId = "";

		try 
		{
			hisutil = new HisUtil("dossier", "DossierItemMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(ctDate);

			bo = new DossierItemBrandMstBO();
            vo = new DossierItemBrandMstVO();
            
            // 11@16100009@161030$7 // MiscId @ ItemBrandId @ ItemTypeId $ Iterator
			chk = request.getParameter("chk");
			
			strtemp = chk.replace('@', '#');
			strtempchk = strtemp.replace('$','#').split("#");
            
			seatid = request.getSession().getAttribute("SEATID").toString();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrMiscId(strtempchk[0]);
			formBean.setStrDeptCode(strtempchk[1]);
			formBean.setStrItemBrandId(strtempchk[2]);
					
			vo = (DossierItemBrandMstVO) TransferObjectFactory.populateData(
					"dossier.masters.vo.DossierItemBrandMstVO", formBean);
			
			System.out.println("hosp code---->>>"+hosCode);
			System.out.println("seat id code---->>>"+seatid);
			System.out.println("misc id---->>>"+strtempchk[0]);
			System.out.println("dept id---->>>"+strtempchk[1]);
			System.out.println("item brand id---->>>"+strtempchk[2]);
					
            // Calling BO Method
			bo.modifyRecord(vo);
			
			TransferObjectFactory.populateData(formBean, vo);
			
			cmb = hisutil.getOptionValue(vo.getStrDeptNameWS(),vo.getStrDeptCode(),
					"0^Select Value",false);

			formBean.setStrDeptNameValues(cmb);
			
			String res=DossierItemBrandMstHLP.getItemDetails(vo);
			formBean.setStrItemDataDiv(res);
			
			/*
			cmb = hisutil.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

			formBean.setStrLeftRequestTypeList(cmb);
			
			cmb1 = hisutil.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
			
			formBean.setStrRightRequestTypeList(cmb1);
			*/
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			//formBean.setStrChk(chk);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DossierItemBrandMaster.DossierItemBrandMstDATA.modifyRecord(vo) -->"
					+ e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierItemBrandMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(DossierItemBrandMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DossierItemBrandMstVO vo = null;
		DossierItemBrandMstBO bo = null;
		boolean retValue = true;
		String strtemp = null;
		String strtemp2[] = null;
		String chk = "";
		String strCurrentDate="";
		String seatid="";
		HisUtil hisutil=null;
		String temp[] = null;
		String strFileId;

		String strtempchk[] = null;
		String hosCode = "";
		String rightItemListArray[] = null;
		int nRightListLen = 0;

		String strItemGroupName = "";
		String strComboName = "";
		String strItemCategoryName = "";
		String cmb = "" , cmb1 = "";
		String ctDate = "";
		
		try 
		{
			hisutil = new HisUtil("dossier", "DossierItemMstDATA");
			
			bo = new DossierItemBrandMstBO();
            vo = new DossierItemBrandMstVO();
            
            String hosp_code = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			seatid = request.getSession().getAttribute("SEATID").toString();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatid);
					
			System.out.println("is valid --->>> "+formBean.getStrIsValid());
			System.out.println("misc id --->>> "+formBean.getStrMiscId());
			System.out.println("dept code --->>> "+formBean.getStrDeptCode());
			System.out.println("item brand id --->>> "+formBean.getStrItemBrandId());
			
			vo = (DossierItemBrandMstVO) TransferObjectFactory.populateData(
					"dossier.masters.vo.DossierItemBrandMstVO", formBean);
			
			/*rightItemListArray = formBean.getStrRightRequestTypes();
			nRightListLen = rightItemListArray.length;
			vo.setStrRightRequestTypes(rightItemListArray);*/
			
			vo.setStrCurrentDate(formBean.getStrCurrentDate());
			
			System.out.println("vo.getStrIsValid() value in update method---->>> "+vo.getStrIsValid());
			
			vo.setStrHospiCode(hosp_code); //global hospital code
			
            // Calling BO Method
			bo.updateRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			retValue = false;
			strmsgText = "DossierItemBrandMaster.DossierItemBrandMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierItemBrandMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	public static void view(HttpServletRequest request, DossierItemBrandMstFB formBean) {
		DossierItemBrandMstVO vo = null;
		DossierItemBrandMstBO bo = null;
		HisUtil hisutil = null;
		String cmb = "";
		String strtemp[] = null;
		String temp[] = null;
		String[] strtemp2 = null;
		String seatId = "" , hosCode = "";
		String strItemCategoryId = "", strGroupId = "";

		try {
			vo = new DossierItemBrandMstVO();
			bo = new DossierItemBrandMstBO();

			hisutil = new HisUtil("dossier", "DossierItemBrandMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(ctDate);
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			if (request.getParameter("chk") != null) {
				String chk = request.getParameter("chk");

				String strtemp1  = chk.replace('@', '#');
				strtemp = strtemp1.replace('$', '#').split("#");
			}
			
			if (request.getParameter("cmbVal3") != null) {
				String cmbVal3 = request.getParameter("cmbVal3");

				formBean.setStrIsValid(cmbVal3);
				System.out.println("is valid value in view() -->> "+cmbVal3);
			}
			
			formBean.setStrMiscId(strtemp[0]);
			formBean.setStrDeptCode(strtemp[1]);
			formBean.setStrItemBrandId(strtemp[2]);
			
			vo.setStrMiscId(strtemp[0]);
			vo.setStrDeptCode(strtemp[1]);
			vo.setStrItemBrandId(strtemp[2]);
			vo.setStrIsValid(formBean.getStrIsValid());
			
			System.out.println("in view func --->>> "+vo.getStrMiscId() +" --->>>> "+vo.getStrDeptCode()+" --->>>> "+vo.getStrItemBrandId());
			
			// Calling BO Method
			bo.view(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			TransferObjectFactory.populateData(formBean, vo);
			
			String res=DossierItemBrandMstHLP.getItemDetailsForView(vo);
			formBean.setStrItemDataDiv(res);
			
			/*formBean.setStrItemKitName(vo.getStrItemKitName());
			formBean.setStrItemKitDescription(vo.getStrItemKitDescription());
			formBean.setStrItemKitRate(vo.getStrItemKitRate());
			formBean.setStrBillingMode(vo.getStrBillingMode());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrDeptName(vo.getStrDeptName());
			formBean.setStrIsValid(vo.getStrIsValid());*/
			
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier", "DossierItemBrandMstDATA->view()",
					strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}
	}
	
	
}

