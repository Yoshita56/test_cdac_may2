package dossier.masters.controller.data;

	import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

	import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

	import mms.MmsConfigUtil;
import dossier.masters.bo.DossierItemMstBO;
import dossier.masters.bo.DossierMstBO;
import dossier.masters.controller.fb.DossierItemMstFB;
import dossier.masters.controller.fb.DossierMstFB;
import dossier.masters.vo.DossierItemMstVO;
import dossier.masters.vo.DossierMstVO;
import dossier.masters.controller.hlp.*;


	// TODO: Auto-generated Javadoc
	/**
	 * The Class DossierItemMstDATA.
	 */
public class DossierItemMstDATA {
	
		/**
		 * to display the current date and item,brand & level unit combos.
		 * 
		 * @param formBean the form bean
		 * @param request the request
		 */
		public static void initialAdd(DossierItemMstFB formBean,
				HttpServletRequest request) {

			DossierItemMstBO bo = null;
			DossierItemMstVO vo = null;
			HisUtil hisutil = null;
			String temp[] = null;
			String strmsgText;
			// String strStoreTypeId = "";
			String strCategoryNo = null;
			String ctDate;
			String hosCode;
			String seatid;
			String strStoreCombo;
			String strDossierCombo;
			String cmb = "", cmb1 = null;
			String strComboName;
			String strDeptCombo = "",strServiceTypeCombo = "", strStoreNameWSCombo="";

			try {
				bo = new DossierItemMstBO();
				vo = new DossierItemMstVO();

				hisutil = new HisUtil("dossier", "DossierItemMstDATA");
				ctDate = hisutil.getASDate("dd-MMM-yyyy");
				formBean.setStrCtDate(ctDate);

				if (formBean.getStrComboValue().equals("")) {
					strComboName = request.getParameter("comboValue");

				} else {
					strComboName = formBean.getStrComboValue();
				}
				
				//System.out.println("strComboName="+strComboName);
				
				formBean.setStrComboValue(strComboName);
				temp = strComboName.replace('^', '#').split("#");
				String strServiceTypeName=temp[0];
				String strDossierName = temp[1];
				
				formBean.setStrServiceTypeName(strServiceTypeName);
				formBean.setStrDossierName(strDossierName);
				
				System.out.println("strDossierName----->>>>>>"+strDossierName);
				
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
						.toString();
				seatid = request.getSession().getAttribute("SEATID").toString();

				strServiceTypeCombo = formBean.getCombo()[0];
				strDossierCombo = formBean.getCombo()[1];
				
				formBean.setStrServiceTypeId(strServiceTypeCombo);
				formBean.setStrDossierId(strDossierCombo);
				vo.setStrServiceTypeId(formBean.getStrServiceTypeId());
				vo.setStrDossierId(formBean.getStrDossierId());				
				
				formBean.setStrServiceTypeName(strServiceTypeName);
				formBean.setStrDossierName(strDossierName);
				vo.setStrServiceTypeName(formBean.getStrServiceTypeName());
				vo.setStrDossierName(formBean.getStrDossierName());
				
				System.out.println("strServiceTypeCombo----->>>>>>"+strServiceTypeCombo);
	            
				formBean.setStrHospitalCode(hosCode);
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				formBean.setStrSeatId(seatid);
				vo.setStrSeatId(formBean.getStrSeatId());
				
				vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

				bo.initAdd(vo);
				if (vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrStoreNameWS() != null
						&& vo.getStrStoreNameWS().size() > 0) 
				{
					strStoreNameWSCombo = hisutil.getOptionValue(vo.getStrStoreNameWS(), vo.getStrStoreId(),
							"0^Select Value", false);
				} 
				else 
				{
					strStoreNameWSCombo = "<option value='0'>Select Value</option>";
				}
				
				formBean.setStrStoreNameValues(strStoreNameWSCombo);
				
				cmb = hisutil.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

				formBean.setStrLeftRequestTypeList(cmb);
				
				if (vo.getStrRightRequestTypeListWs() != null){
					cmb1 = hisutil.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
				}
				
				formBean.setStrRightRequestTypeList(cmb1);
								
				formBean.setStrDeptName(vo.getStrDeptName());
				formBean.setStrServiceTypeName(vo.getStrServiceTypeName());
				
				
			} catch (Exception e) {
				strmsgText = "DossierItemMaster.DossierItemMstDATA.initialAdd(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->initialAdd()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			} finally {

				hisutil = null;
			}

		}

		
		
		public static void getItemCatValues(DossierItemMstFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			DossierItemMstBO bo = null;
			DossierItemMstVO voObj = null;
			String strmsgText = null;
			HisUtil util = null;
			try {

				bo = new DossierItemMstBO();
				voObj = new DossierItemMstVO();
				
				String strStoreId = "1012010"; //formBean.getStrId();
				String strModeVal = "5";//request.getParameter("modeVal");
				if (strStoreId == null)
					strStoreId = "0";
				
				voObj.setStrStoreId(strStoreId);
				voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE")
						.toString());
					
				
				bo.getItemCatDtls(voObj);

				if (voObj.getStrMsgType().equals("1")) {
					throw new Exception(voObj.getStrMsgString());

				}
				util = new HisUtil("MMS Transactions", "IssueTransDATA");
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
				strmsgText = "dossier.masters.DossierItemMstDATA.getItemCatDtls --> "
						+ e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->getItemCatDtls()", strmsgText);
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
		 * @param formBean the form bean
		 * @param request the request
		 */
		public static void insertRecord(DossierItemMstFB formBean,
				HttpServletRequest request) {
			DossierItemMstBO bo = null;
			DossierItemMstVO vo = null;
			HisUtil util=null;
			String strmsgText = "";
			String temp[] = null;

			String strCategoryNo = "";
			String strStoreId = "";
			String hosCode = "",strCurrentDate="";
			String seatid = "";
			String strDeptCombo = "";
			String strServiceTypeCombo="";
			String strDossierId="";
			int nRightListLen = 0;
			String rightItemListArray[] = null;
			try {
				util = new HisUtil("dossier", "DossierMstData");
				strCurrentDate = util.getASDate("dd-MMM-yyyy");
				vo = new DossierItemMstVO();
				bo = new DossierItemMstBO();

				hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
						.toString();
				seatid = request.getSession().getAttribute("SEATID").toString();

				strServiceTypeCombo = formBean.getCombo()[0];
				strDossierId = formBean.getCombo()[1];
				
				formBean.setStrServiceTypeId(strServiceTypeCombo);
				formBean.setStrDossierId(strDossierId);
				vo.setStrServiceTypeId(formBean.getStrServiceTypeId());
				vo.setStrDossierId(formBean.getStrDossierId());
				
				/*String str[]=formBean.getStrRightRequestTypes();
				
				for(int i=0;i<str.length;i++){
					System.out.println("right request types: ----->>> "+str[i]);
				}*/
				
				System.out.println("current date : --->> "+strCurrentDate);
				
				formBean.setStrHospitalCode(hosCode);
				formBean.setStrSeatId(seatid);
				formBean.setStrIsValid("1");
				formBean.setStrCtDate(strCurrentDate);
				
				vo.setItemParamValue(formBean.getItemParamValue());
				vo.setStrQtyText(formBean.getStrQtyText());
				vo.setStritemcat(formBean.getStritemcat());
				vo.setIsBroughtByPatient(formBean.getIsBroughtByPatient());
				vo.setStrDefRateText(formBean.getStrDefRateText());
				
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrIsValid("1");
				
				vo = (DossierItemMstVO) TransferObjectFactory.populateData(
						"dossier.masters.vo.DossierItemMstVO", formBean);
				
				vo.setStrEntryDate(strCurrentDate);
				
				System.out.println("total cost of dossier -->> "+vo.getStrDossierTotalCost());
				
				/*rightItemListArray = formBean.getStrRightRequestTypes();
				nRightListLen = rightItemListArray.length;
				vo.setStrRightRequestTypes(rightItemListArray);
				
				System.out.println("right item list length --->>>> "+nRightListLen);*/
								
				System.out.println("category no  --->> "+formBean.getStritemcat());
				
				for(int i=0;i<vo.getStrQtyText().length;i++)
					System.out.println("Quantity array values --->>> "+vo.getStrQtyText()[i]);
				
				for(int i=0;i<vo.getStrIsMisc().length;i++)
					System.out.println("getStrIsMisc array values --->>> "+vo.getStrIsMisc()[i]);
				
				for(int i=0;i<vo.getItemParamValue().length;i++)
					System.out.println("item param value array values --->>> "+vo.getItemParamValue()[i]);
				
				for(int i=0;i<vo.getIsBroughtByPatient().length;i++)
					System.out.println("is brought by patient array values --->>> "+vo.getIsBroughtByPatient()[i]);
				
				for(int i=0;i<vo.getStrDefRateText().length;i++)
					System.out.println("def rate array values --->>> "+vo.getStrDefRateText()[i]);
				
				System.out.println("store name--->>> "+vo.getStrStoreName());
				bo.insertRecord(vo);
				
				System.out.println("after insert --->>");
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				else {
					formBean.setStrMsg("Data Saved Successfully");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "DossierItemMaster.DossierItemMstDATA.insertRecord(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->insertRecord()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			} finally {
				bo = null;
				vo = null;
			}

		}

		/**
		 * to get the data for modify page.
		 * 
		 * @param formBean the form bean
		 * @param request the request
		 */
		public static void modifyRecord(DossierItemMstFB formBean,
				HttpServletRequest request) {
			DossierItemMstBO bo = null;
			DossierItemMstVO vo = null;
			String strmsgText = "";
			String strtemp="";
			String chk = "";
			HisUtil hisutil = null;
			String strtempchk[]=null;
			String cmb = "", cmb1 = "";

			String hosCode = "";
			String seatid = "";
			String strStoreCombo = "";
			String strStoreName = "";
			String strDossierCombo = "";
			String strDossierName="";
			
			String ctDate = "",strStoreNameWSCombo="";

			try {
				bo = new DossierItemMstBO();
				vo = new DossierItemMstVO();
				hisutil = new HisUtil("dossier", "DossierItemMstDATA");
				ctDate = hisutil.getASDate("dd-MMM-yyyy");
				formBean.setStrCtDate(ctDate);
	
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
						.toString();
				seatid = request.getSession().getAttribute("SEATID").toString();
				
				vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);

				if (vo.getStrMsgType().equals("1")) {

					throw new Exception(vo.getStrMsgString());
				}

				chk = request.getParameter("chk");
				
				System.out.println("chk --->"+chk);
				// 16$8 //DossierId @ StoreId $ Iterator
	            
				/*strtemp = chk.replace('@', '#');
				strtempchk = strtemp.replace('$','#').split("#");
				*/
				strtempchk = chk.replace('$','#').split("#");
				
				vo.setStrDossierId(strtempchk[0]);
				//vo.setStrStoreId(strtempchk[1]);
				
				formBean.setStrDossierId(strtempchk[0]);
				//formBean.setStrStoreId(strtempchk[1]);
		
				System.out.println("in modify --->> "+vo.getStrDossierId()+" *** "+vo.getStrStoreId());
				
				if (request.getParameter("comboValue") != null) {
					String strComboValues = request.getParameter("comboValue");
					//formBean.setStrComboValues(strComboValues);
					//temp = strComboValues.replace('^', '#').split("#");
					System.out.println("strComboValues --->> "+strComboValues);
					formBean.setStrIsValid(strComboValues);
				}
				
				vo.setStrIsValid(formBean.getStrIsValid());
				
				bo.modifyRecord(vo);
				
				System.out.println("after --->> modify");
				
				/*
				cmb = hisutil.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

				formBean.setStrLeftRequestTypeList(cmb);
				
				cmb1 = hisutil.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
				
				formBean.setStrRightRequestTypeList(cmb1);
				*/
				
				String res=DossierItemMstHLP.getItemDetails(vo);
				formBean.setStrItemDataDiv(res);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				/*if (vo.getStrStoreNameWS() != null
						&& vo.getStrStoreNameWS().size() > 0) 
				{
					strStoreNameWSCombo = hisutil.getOptionValue(vo.getStrStoreNameWS(), vo.getStrStoreId(),
							"0^Select Value", false);
				} 
				else 
				{
					strStoreNameWSCombo = "<option value='0'>Select Value</option>";
				}
				
				formBean.setStrStoreNameValues(strStoreNameWSCombo);
				*/
				formBean.setStrChk1(chk);
				formBean.setStrIsValid("1");
				TransferObjectFactory.populateData(formBean, vo);
				
				
			} catch (Exception e) {

				strmsgText = "DossierItemMaster.DossierItemMstDATA.modifyRecord(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->modifyRecord()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
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
		 * @param formBean the form bean
		 * @param request the request
		 * 
		 * @return true, if update record
		 */
		public static boolean updateRecord(DossierItemMstFB formBean,
				HttpServletRequest request) {

			DossierItemMstBO bo = null;
			DossierItemMstVO vo = null;
			String strmsgText = "";
			boolean retValue = true;
			String strtemp = null;
			String strtempchk[] = null;
			String chk = "";
			String seatid = "";
			String hosCode = "";
			String rightItemListArray[] = null;
			int nRightListLen = 0;
			HisUtil util = null;
			
			try 
			{
				bo = new DossierItemMstBO();
	            vo = new DossierItemMstVO();
	            
				// 16@10201100$8	// DossierId @ StoreId $ Iterator
				/*chk = request.getParameter("chk");
				System.out.println("chk --->> "+chk);
				strtemp = chk.replace('@', '#');
				strtempchk = strtemp.replace('$','#').split("#");
	            */
	            
				seatid = request.getSession().getAttribute("SEATID").toString();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
				formBean.setStrHospitalCode(hosCode);
				formBean.setStrSeatId(seatid);
				
				String oldStore=formBean.getStrStoreId();
				String dossierId=formBean.getStrDossierId();
				
				System.out.println("old store id -->>"+formBean.getStrStoreName());
				System.out.println("dossier id:--->>"+dossierId);
				System.out.println("new store id -->>>"+formBean.getStrNewStoreName());
				
				vo = (DossierItemMstVO) TransferObjectFactory.populateData(
						"dossier.masters.vo.DossierItemMstVO", formBean);

				vo.setStrEntryDate(formBean.getStrCtDate());
				
				/*rightItemListArray = formBean.getStrRightRequestTypes();
				nRightListLen = rightItemListArray.length;
				vo.setStrRightRequestTypes(rightItemListArray);*/
				
				// Calling BO Method
				System.out.println("old store id :--->>>"+vo.getStrStoreId());
				System.out.println("new store id :--->>>"+vo.getStrNewStoreName());
				System.out.println("dossier id :--->>>"+vo.getStrDossierId());
				System.out.println("is valid value :--->>>"+vo.getStrIsValid());
				/*
				for(int i=0;i<vo.getStrQtyText().length;i++)
					System.out.println("Quantity array values --->>> "+vo.getStrQtyText()[i]);
				
				for(int i=0;i<vo.getIsBroughtByPatient().length;i++)
					System.out.println("is brought by patient array values --->>> "+vo.getIsBroughtByPatient()[i]);
				
				for(int i=0;i<vo.getStrDefRateText().length;i++)
					System.out.println("def rate array values --->>> "+vo.getStrDefRateText()[i]);
				
				for(int i=0;i<vo.getStrQtyText1().length;i++)
					System.out.println("Quantity text 1 value array values --->>> "+vo.getStrQtyText1()[i]);
				
				for(int i=0;i<vo.getIsBroughtByPatient1().length;i++)
					System.out.println("is brought by patient 1 array values --->>> "+vo.getIsBroughtByPatient1()[i]);
				
				for(int i=0;i<vo.getStrDefRateText1().length;i++)
					System.out.println("def rate 1 array values --->>> "+vo.getStrDefRateText1()[i]);
				
				for(int i=0;i<vo.getStrItemBrandIdArray().length;i++)
					System.out.println("getStrItemBrandIdArray values --->>> "+vo.getStrItemBrandIdArray()[i]);
				
				for(int i=0;i<vo.getStrItemIdArray().length;i++)
					System.out.println("getStrItemIdArray values --->>> "+vo.getStrItemIdArray()[i]);
				
				for(int i=0;i<vo.getStrItemTypeIdArray().length;i++)
					System.out.println("getStrItemTypeIdArray values --->>> "+vo.getStrItemTypeIdArray()[i]);
				
				for(int i=0;i<vo.getStrIsRC1().length;i++)
					System.out.println("in dao modify  RC1 values--->> "+vo.getStrIsRC1()[i]);
				
				*/
				
				bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) {
					retValue = false;
					throw new Exception(vo.getStrMsgString());
				}
				
				

			} catch (Exception e) {

				strmsgText = "DossierItemMaster.DossierItemMstDATA.updateRecord(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->updateRecord()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

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
		public static void view(HttpServletRequest request, DossierItemMstFB formBean) {
			DossierItemMstBO bo = null;
			DossierItemMstVO vo = null;

			String chk = "";
			String strChk = "";

			try {

				vo = new DossierItemMstVO();
				bo = new DossierItemMstBO();

				chk = request.getParameter("chk");
				String strSeatId=request.getSession().getAttribute("SEATID").toString();
				String strHospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
				if (request.getParameter("cmbVal3") != null) {
					String cmbVal3 = request.getParameter("cmbVal3");
					
					formBean.setStrIsValid(cmbVal3);
					System.out.println("is valid value in view() -->> "+cmbVal3);
				}
				
				vo.setStrIsValid(formBean.getStrIsValid());
				
				// 11$1 // DossierId   $ Iterator
				strChk = chk.replace("$", "@");
				String temp[] = strChk.split("@");
				
				vo.setStrDossierId(temp[0]);
				//vo.setStrStoreId(temp[1]);
				
				formBean.setStrDossierId(temp[0]);
				//formBean.setStrStoreId(temp[1]);
				
				formBean.setStrHospitalCode(strHospCode);
				formBean.setStrSeatId(strSeatId);
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				bo.getView(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				TransferObjectFactory.populateData(formBean, vo);
				
				String res=DossierItemMstHLP.getItemDetailsForView(vo);
				formBean.setStrItemDataDiv(res);
								
				formBean.setStrChk1(chk);

			} catch (Exception e) {
				e.printStackTrace();
				String strmsgText = e.getMessage();
				HisException eObj = new HisException("dossier",
						"DossierItemMstDATA->view()-", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			} finally {
				bo = null;
				vo = null;

			}
		}

		
}

///////////////////////////////////////////////////////////////////////////////////////////////