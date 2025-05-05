package dossier.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import dossier.masters.bo.DossierMstBO;
import dossier.masters.controller.fb.DossierMstFB;
import dossier.masters.controller.hlp.DossierMstHLP;
import dossier.masters.vo.DossierMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierMstDATA.
 */
public class DossierMstDATA {

	/**
	 * This function is used to set initial parameters required to display on
	 * main page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initParamAddPage(HttpServletRequest request,
			DossierMstFB formBean) 
	{
		DossierMstBO bo = null;
		DossierMstVO vo = null;
		HisUtil util = null;
		String temp1 = "";
		String strItemCatNo = "";
		String strSupplierTypeVals="";
		String strCountryNameCombo = "";
		
		String strSeatId="";
		String strDossierName="";
		String strDossierDescription="";
		String strDepartmentCode="";
		String strDepartmentName="";
		String strBillingMode="";
		String strHospCode = "";
		String strCurrentDate = "";
		String strServiceTypeId="";
		String strServiceTypeName="";
		String cmb="" , cmb1="";
		
		try {

			util = new HisUtil("dossier", "DossierMstDATA");

			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);

			vo = new DossierMstVO();
			bo = new DossierMstBO();
			
			//Added By Timsi
			if (formBean.getStrServiceTypeID() == null
					|| formBean.getStrServiceTypeID().equals(""))
				strServiceTypeId = formBean.getCombo()[0];
			else
				strServiceTypeId = formBean.getStrServiceTypeID();
			
			/*if (formBean.getStrDepartmentCode() == null
					|| formBean.getStrDepartmentCode().equals(""))
				strDepartmentCode = formBean.getCombo()[0];
			else
				strDepartmentCode = formBean.getStrDepartmentCode();
			*/
			
			//System.out.println("\n service type id -->"+strServiceTypeId);
			//System.out.println("\n department id -->"+strDepartmentCode);
			
			formBean.setStrServiceTypeID(strServiceTypeId); //Timsi
            //formBean.setStrDepartmentCode(strDepartmentCode);
            
			strHospCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strSeatId=request.getSession().getAttribute("SEATID").toString(); 
			
			//System.out.println("\n hosp_code -->"+strHospCode);
			//System.out.println("\n seat_id -->"+strSeatId);
			
			formBean.setStrHospCode(strHospCode);
			formBean.setStrSeatId(strSeatId);
			
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrServiceTypeID(formBean.getStrServiceTypeID());
			//vo.setStrDepartmentCode(formBean.getStrDepartmentCode());
			
			// Calling BO method
			bo.setinitParam(vo);
			
			cmb = util.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

			formBean.setStrLeftRequestTypeList(cmb);
			
			if (vo.getStrRightRequestTypeListWs() != null){
				cmb1 = util.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
			}
			
			formBean.setStrRightRequestTypeList(cmb1);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

								
				if (vo.getDepartmentNameWS() != null
						&& vo.getDepartmentNameWS().size() > 0) {
					temp1 = util.getOptionValue(vo.getDepartmentNameWS(), "0",
							"0^Select Value", false);
				} else {
					temp1 = "<option value='0'>Select Value</option>";
				}
				formBean.setStrDepartmentNameValues(temp1);
				
				formBean.setStrServiceTypeName(vo.getStrServiceTypeName());
				formBean.setStrDepartmentName(vo.getStrDepartmentName());

			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierMstDATA->initParamAddPage()", strmsgText);
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
	public static void insert(HttpServletRequest request, DossierMstFB formBean) {
		DossierMstBO bo = null;
		DossierMstVO vo = null;
		String strHospCode;
		try {
			bo = new DossierMstBO();

			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo = (DossierMstVO) TransferObjectFactory.populateData(
					"dossier.masters.vo.DossierMstVO", formBean);
			
			
			//System.out.println("service type name -->> "+vo.getStrServiceTypeName()+"  servicetype id -->> "+vo.getStrServiceTypeID());
			// Calling BO Method
			
			vo.setStrIsValid("1");
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			} else if (vo.getStrWarnMsType().equals("1")) {
				formBean.setStrWarnMssgstring("Data already exists");
			} else {
				formBean.setStrItemCatNo(vo.getStrItemCatNo());

				formBean.setStrNormMssgstring("Record is successfully inserted");
			}
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierMstData->insert()", strmsgText);
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
	public static void modify(HttpServletRequest request, DossierMstFB formBean) {
		DossierMstBO bo = null;
		DossierMstVO vo = null;
		HisUtil util = null;
		String temp1,strHospCode,temp2;
		String chk;
		String strChk;
		String strServiceTypeId, strDepartmentCode;
		String strCurrentDate;
		String strDepartmentNameCombo;
		String temp[] = null;
		String cmb="" , cmb1="";
		
		try 
		{
			util = new HisUtil("dossier", "DossierMstData");
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			vo = new DossierMstVO();
			bo = new DossierMstBO();
	                    
			// 11@11@146@1 // DossierId @ ServiceTypeId @ DepartmentId $ Iterator 
			chk = request.getParameter("chk");
			strChk = chk.replace("$", "@");
			temp = strChk.split("@");

			if (formBean.getStrServiceTypeID() == null
					|| formBean.getStrServiceTypeID().equals(""))
				strServiceTypeId = formBean.getCombo()[0];
			else
				strServiceTypeId = formBean.getStrServiceTypeID();
			
				
			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				//formBean.setStrComboValues(strComboValues);
				//temp = strComboValues.replace('^', '#').split("#");
				System.out.println("strComboValues --->> "+strComboValues);
				formBean.setStrIsValid(strComboValues);
				formBean.setStrIsValidOld(strComboValues);				
			}
			
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrIsValidOld(formBean.getStrIsValidOld());
			
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrCurrentDate(formBean.getStrCurrentDate());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrHospCode(formBean.getStrHospCode());
			
			System.out.println("dossier mst modify data --->>"+temp[0]+"   "+temp[1]+" ***** ");
			
			vo.setStrDossierID(temp[0]);
			vo.setStrServiceTypeID(temp[1]);
			//vo.setStrDepartmentCode(temp[2]);
			
			formBean.setStrDossierID(temp[0]);
			formBean.setStrServiceTypeID(temp[1]);
			//formBean.setStrDepartmentCode(temp[2]);
			

			if (formBean.getStrServiceTypeID() == null
					|| formBean.getStrServiceTypeID().equals(""))
				strServiceTypeId = formBean.getCombo()[0];
			else
				strServiceTypeId = formBean.getStrServiceTypeID();

			vo.setStrServiceTypeID(strServiceTypeId);
			
			System.out.println("Service type id : --->>> "+vo.getStrServiceTypeID());

			/*if (formBean.getStrDepartmentCode() == null
					|| formBean.getStrDepartmentCode().equals(""))
				strDepartmentCode = formBean.getCombo()[0];
			else
				strDepartmentCode = formBean.getStrDepartmentCode();

			vo.setStrDepartmentCode(strDepartmentCode);*/
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			
			// Calling BO Method
			bo.modify(vo);
			
			/*if (vo.getDepartmentNameWS() != null
					&& vo.getDepartmentNameWS().size() > 0) 
			{
				strDepartmentNameCombo = util.getOptionValue(vo.getDepartmentNameWS(), vo.getStrDepartmentCode(),
						"0^Select Value", false);
			} 
			else 
			{
				strDepartmentNameCombo = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrDepartmentNameValues(strDepartmentNameCombo);
			
			if (vo.getServiceTypeNameWS() != null
					&& vo.getServiceTypeNameWS().size() > 0) {
				temp2 = util.getOptionValue(vo.getServiceTypeNameWS(), vo.getStrServiceTypeID(),
						"0^Select Value", false);
			} else {
				temp2 = "<option value='0'>Select Value</option>";
			}
			formBean.setStrServiceTypeNameValues(temp2);
			*/
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				TransferObjectFactory.populateData(formBean, vo);
				formBean.setStrChk(chk);
				
				cmb = util.getOptionValue(vo.getStrLeftRequestTypesListWs(),"", "", true);

				formBean.setStrLeftRequestTypeList(cmb);
				
				if (vo.getStrRightRequestTypeListWs() != null){
					cmb1 = util.getOptionValue(vo.getStrRightRequestTypeListWs(),"", "", true);
				}
				
				formBean.setStrRightRequestTypeList(cmb1);


			}
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierMstData->modify()-", strmsgText);
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
			DossierMstFB formBean) {
		DossierMstBO bo = null;
		DossierMstVO vo = null;
		Boolean retValue = true;
		String chk = "";
		String strChk = "";
		String strDepartmentNameValues ="";
		
		try {

			bo = new DossierMstBO();
			
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
						
			/*// 11@11$1 // DossierId @ ServiceTypeId  $ Iterator 
			chk = request.getParameter("chk");

			strChk = chk.replace("$", "@");
			String temp[] = strChk.split("@");*/

			vo = (DossierMstVO) TransferObjectFactory.populateData(
					"dossier.masters.vo.DossierMstVO", formBean);
			
			
			System.out.println("in update service type id --> "+formBean.getStrServiceTypeID());
			System.out.println("dossier mst update data --->>"+vo.getStrDossierID()+"   "+vo.getStrServiceTypeName()+" *** ");
			System.out.println("old isvalid -->> "+vo.getStrIsValidOld()+" -->> new is valid -->> "+vo.getStrIsValid());
			
			/*formBean.setStrDossierID(vo.getStrDossierID());
			formBean.setStrServiceTypeID(vo.getStrServiceTypeID());
			formBean.setStrDepartmentCode(vo.getStrDepartmentCode());*/
			
			
			bo.update(vo);
			
			/*System.out.println(" Dossier id: --->>> "+vo.getStrDossierID());
			System.out.println("dossier name: "+vo.getStrDossierName());
			System.out.println("desc: "+vo.getStrDossierDescription());
			System.out.println("service name: "+vo.getStrServiceName());
			System.out.println("service type id : "+vo.getStrServiceTypeID());
			System.out.println("service type name: "+vo.getStrServiceTypeName());
			System.out.println("bill mode: "+vo.getStrBillingMode());
			System.out.println("hosp-code: "+vo.getStrHospCode());
			System.out.println("seat id :"+vo.getStrSeatId());
			System.out.println("is valid: "+vo.getStrIsValid());
					*/
			formBean.setStrDepartmentNameValues(strDepartmentNameValues);
			
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			} else if (vo.getStrWarnMsType().equals("1")) {
				retValue = false;
				formBean.setStrWarnMssgstring("Data already exists");
			} else {
				formBean.setStrNormMssgstring("Record is successfully updated");

			}
			formBean.setStrChk(chk);
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierMstData->update()", strmsgText);
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
	public static void view(HttpServletRequest request, DossierMstFB formBean) {
		DossierMstBO bo = null;
		DossierMstVO vo = null;

		String chk = "";
		String strChk = "";

		try {

			vo = new DossierMstVO();
			bo = new DossierMstBO();

			chk = request.getParameter("chk");
			String strSeatId=request.getSession().getAttribute("SEATID").toString();
			String strHospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			if (request.getParameter("cmbVal3") != null) {
				String cmbVal3 = request.getParameter("cmbVal3");

				formBean.setStrIsValid(cmbVal3);
				vo.setStrIsValid(cmbVal3);
				System.out.println("is valid value in view() -->> "+cmbVal3);
			}
			
			// 11@11$1 // DossierId @ ServiceTypeId $ Iterator
			strChk = chk.replace("$", "@");
			String temp[] = strChk.split("@");
			
			vo.setStrDossierID(temp[0]);
			vo.setStrServiceTypeID(temp[1]);
			//vo.setStrDepartmentCode(temp[2]);
			
			formBean.setStrDossierID(temp[0]);
			formBean.setStrServiceTypeID(temp[1]);
			//formBean.setStrDepartmentCode(temp[2]);
			
			formBean.setStrHospCode(strHospCode);
			formBean.setStrSeatId(strSeatId);
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getView(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			TransferObjectFactory.populateData(formBean, vo);
			
			String res=DossierMstHLP.getDeptNamesForView(vo);
			formBean.setStrDeptDataDiv(res);
			
			formBean.setStrChk(chk);

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("dossier",
					"DossierMstData->view()-", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

}
