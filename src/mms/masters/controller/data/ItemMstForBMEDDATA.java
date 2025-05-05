/**
 * 
 */
package mms.masters.controller.data;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.masters.bo.ItemMstForBMEDBO;
import mms.masters.controller.fb.ItemMstForBMEDFB;
import mms.masters.vo.ItemMstForBMEDVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 15/May/2009
 */
public class ItemMstForBMEDDATA {

	/**
	 * For Initial Values.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void initAdd(HttpServletRequest request, ItemMstForBMEDFB formBean) {
		HisUtil hisutil = null;
		ItemMstForBMEDBO bo = null;
		ItemMstForBMEDVO vo = null;
		String cmb = "";
		String strmsgText = "";
		String[] temp = null;
		// String[] temp1 = null;
		String hosCode = "";
		String seatid = "";
		String strItemCategoryId = "";
		String strGroupId = "";
		// String strGenItemId = "";
		// String strItemType = "";

		try {

			vo = new ItemMstForBMEDVO();
			bo = new ItemMstForBMEDBO();

			hisutil = new HisUtil("MMS", "ItemMstForBMEDDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(ctDate);

			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				formBean.setStrComboValues(strComboValues);
				temp = strComboValues.replace('^', '#').split("#");

				formBean.setStrItemCatName(temp[0]);
				formBean.setStrGroupName(temp[1]);

			}
			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

			seatid = request.getSession().getAttribute("SEATID").toString();
			if(formBean.getStrItemCatNo() == "" || formBean.getStrGroupId()== "")
				if (formBean.getCombo()[0] != null) {
				strItemCategoryId = formBean.getCombo()[0];
				strGroupId = formBean.getCombo()[1];
				// strGenItemId = formBean.getCombo()[2];
				// strItemType = formBean.getCombo()[3];

				// temp1 = strGenItemId.replace('^', '#').split("#");

				formBean.setStrItemCatNo(strItemCategoryId);
				formBean.setStrGroupId(strGroupId);
				// formBean.setStrGenItemId(temp1[0]);
				// formBean.setStrItemType(strItemType);
			}
			
					

			
			 System.out.println("strItemCategoryId-->"+strItemCategoryId);
			 System.out.println("strGroupId-->"+strGroupId);
//			 System.out.println("strGenItemId-->"+strGenItemId);
			 

			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatid);

			formBean.setStrInventoryUnitId(MmsConfigUtil.UNIT_ID_PATNA);

			vo.setStrHospCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			// vo.setStrGenItemId(formBean.getStrGenItemId());
			vo.setStrInventoryUnitId(formBean.getStrInventoryUnitId());
			
			bo.initialAdd(vo);

			if (vo.getItemTypeWS() != null && vo.getItemTypeWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getItemTypeWS(), "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemTypeCombo(cmb);

			if (vo.getManufacturerWS() != null
					&& vo.getManufacturerWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getManufacturerWS(), "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrManufacturerCombo(cmb);

			if (vo.getWsGenericItems() != null
					&& vo.getWsGenericItems().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWsGenericItems(), "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrGenItemValues(cmb);

			formBean.setStrRateUnitId(vo.getStrRateUnitId());
			formBean.setStrRateUnitName(vo.getStrRateUnitName());
			formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
			formBean.setStrApprovedTypeOptions(hisutil.getOptionValue(vo.getWrsApprovedTypeOptions(), "0", "", false));

			/*
			 * if (vo.getRateUnitWS() != null && vo.getRateUnitWS().size() > 0)
			 * { cmb = hisutil.getOptionValue(vo.getRateUnitWS(), "",
			 * "0^Select Value", false); } else { cmb =
			 * "<option value='0'>Select Value</option>"; }
			 * 
			 * formBean.setStrRateUnitCombo(cmb);
			 */

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "Item Master.ItemMstForBMEDDATA.initAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemMstForBMEDDATA->initAdd()", strmsgText);

			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	
	public static void getUploadedFile(ItemMstForBMEDFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		String strmsgText = null;
		String strLocation = "";
		String strFileName = "";
		File f = null;
		FileInputStream fis = null;
		byte[] fileContent = new byte[1024];
		
		try {
			
			strLocation = formBean.getStrUploadFileLocation();
			strFileName = formBean.getStrUploadFileId();	
			String[] strTemp = strFileName.replace(".", "#").split("#");
			String strExt = strTemp[strTemp.length - 1];
			
		
			if (strExt.equalsIgnoreCase("pdf")) {

				response.setContentType("application/pdf");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);

			} else if (strExt.equalsIgnoreCase("html")
					|| strExt.equalsIgnoreCase("htm")) {
				
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			}else if (strExt.equalsIgnoreCase("xml")) {
				
				response.setContentType("application/xml");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			} else if (strExt.equalsIgnoreCase("doc") || strExt.equalsIgnoreCase("docx")) {
				
				response.setContentType("application/msword");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			} else if (strExt.equalsIgnoreCase("rdf")) {
				
				response.setContentType("application/msword");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			} else if (strExt.equalsIgnoreCase("rtf")) {
				
				response.setContentType("application/msword");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			} else {

				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Content-disposition",
						"attachment; filename="+strLocation+""+strFileName);
				
			}
			////System.out.println("FILE_PATH:::"+strLocation+""+strFileName);
			f = new File(strLocation+""+strFileName);

			if (!f.isFile()) 
			{

				throw new Exception("Invalid File Path");
			}

			fis = new FileInputStream(f);

			while (fis.read(fileContent) != -1) 
			{
                
				response.getOutputStream().write(fileContent);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.master.ItemMstForBMEDDATA.getUploadedFile --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemMstForBMEDDATA->getUploadedFile()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
	
			if (f != null)
				f = null;
			if (fis != null)
				fis = null;
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

	public static void insert(ItemMstForBMEDFB formBean, HttpServletRequest request) 
	{
		String strmsgText = "";
		ItemMstForBMEDBO bo = null;
		ItemMstForBMEDVO vo = null;

		
		String seatid = "";
		String strFileExt;
		String[] temp = null;
		String strCurrentDate;
		String strFileId = null;
		HisUtil hisutil = null;
		//AttachFileGlobal fs=null;
		

		try 
		{
			bo = new ItemMstForBMEDBO();
			// vo = new ItemMstForBMEDVO();
			hisutil = new HisUtil("","");
			//fs=new AttachFileGlobal();
			
			System.out.println("------------ ItemMstForBMEDDATA.insert()-------------");
			
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			seatid = request.getSession().getAttribute("SEATID").toString();
			strCurrentDate = hisutil.getDSDate("DD-Mon-YYYY HH24_MI_SS");
			String hospiCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
						
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrSeatId(seatid);
				
				
				vo = (ItemMstForBMEDVO) TransferObjectFactory.populateData("mms.masters.vo.ItemMstForBMEDVO",formBean);
				////System.out.println("Value is"+vo.getStrConsumableType());
				vo.setStrHospiCode(hospiCode);			vo.setStrHospiCode(hospiCode);
				String temp2[] = formBean.getStrGenItemId().replace('^', '#').split("#");
	
				if (formBean.getStrNewCPACode() != null
						&& !formBean.getStrNewCPACode().trim().equals("")) {
					
					if("0".equals(temp2[2])) 
					{						
						vo.setStrCPACode(formBean.getStrNewCPACode());						
					} 
					else 
					{					
						vo.setStrCPACode(temp2[2] + "." + formBean.getStrNewCPACode());
					}	
				} 
				else 
				{
					/*
					 * This block will be in action when HSTNUM_ITEMCODE_FLAG field
					 * in sstt_item_category_mst table is set to 0 for
					 * SSTNUM_ITEM_CAT_NO=10. Because in that case Item Code field
					 * is not mandatory in the screen. So user may left this field
					 * blank.
					 */
					vo.setStrCPACode(""); // Empty String
				}
				vo.setStrItemType(formBean.getStrItemType());
				if(formBean.getStrDefaultRate()==null || formBean.getStrDefaultRate().trim().equals("")) {
					formBean.setStrDefaultRate("0");
					vo.setStrDefaultRate("0");
				}
				vo.setStrHSNCode(formBean.getStrHSNCode());
				
				
				vo.setTEMP_SENS_FLAG(formBean.getTEMP_SENS_FLAG());
				vo.setMAX_VALUE(formBean.getMAX_VALUE());
				vo.setMIN_VALUE(formBean.getMIN_VALUE());
				
				
				vo.setStrSerialNo(formBean.getStrSerialNo());
				vo.setMACNo(formBean.getMACNo());
				vo.setStrloc(formBean.getStrloc());
				vo.setStrWarrantyStartDate(formBean.getStrWarrantyStartDate());
				vo.setStrWarrantyUpTo(formBean.getStrWarrantyUpTo());
				vo.setStrUnitId(formBean.getStrUnitId());
				
				System.out.println(vo.getStrSerialNo());
				System.out.println(vo.getMACNo());
				System.out.println(vo.getStrloc());
				System.out.println(vo.getStrWarrantyStartDate());
				System.out.println(vo.getStrWarrantyUpTo());
				System.out.println(vo.getStrUnitId());
				
				
	            // Calling BO  Method
				bo.insertQuery(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}

				if (vo.getBExistStatus() == false) 
				{
					formBean.setStrWarnMssgstring("Data already exist");
				} 
				else 
				{
					formBean.setStrNormMssgstring("Data Saved Successfully");
				}
		    //}

			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "ItemMaster.ItemMstForBMEDDATA.insert(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","ItemMstForBMEDDATA->insert()", strmsgText);
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
	public static void modifyRecord(ItemMstForBMEDFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ItemMstForBMEDBO bo = null;
		ItemMstForBMEDVO vo = null;
		String chk = "";
		String temp[] = null;
		String strtemp[] = null;
		String strtemp2[] = null;

		HisUtil hisutil = null;

		String cmb = "";

		try 
		{
			bo = new ItemMstForBMEDBO();
			vo = new ItemMstForBMEDVO();

			hisutil = new HisUtil("mms", "ItemMstForBMEDDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospCode());
			
			
            String osType = System.getProperties().getProperty("os.name");
			
			if(osType.startsWith("Win"))
			{
				formBean.setStrUploadFileLocation(mmscofigutil.getStrWinLocation());   // Save Location Of File for O.S. WIN
			}
			else
			{
				formBean.setStrUploadFileLocation(mmscofigutil.getStrLinLocation());   // Save Location Of File for O.S. LINUX
			}
			
			formBean.setStrCurrentDate(ctDate);
 
			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				formBean.setStrComboValues(strComboValues);
				temp = strComboValues.replace('^', '#').split("#");
			}
			formBean.setStrItemCatName(temp[0]);
			formBean.setStrGroupName(temp[1]);
//
//			if (request.getParameter("chk") != null) {
//				chk = request.getParameter("chk");
//				strtemp = chk.replace('@', '#').split("#");
//				strtemp2 = strtemp[1].replace('$', '#').split("#");
//			}
			if (request.getParameter("chk") != null) {
				chk = request.getParameter("chk");

				strtemp  = chk.replace('@', '#').split("#");
				strtemp2 = strtemp[3].replace('$', '#').split("#");
			}
			
			vo.setStrItemBrandId(strtemp[0]);
			vo.setStrHospCode(strtemp[1]);
			vo.setStrItemType(strtemp[2]);
			vo.setStrSerialNo(strtemp2[0]);

//			vo.setStrItemBrandId(strtemp[0]);
//			vo.setStrHospCode(strtemp2[0]);
			vo.setStrItemCatNo(formBean.getCombo()[0]);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrItemTypeId(vo.getStrItemTypeId());
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setStrManufacturerId(vo.getStrManufacturerId());
			formBean.setStrDefaultRate(vo.getStrDefaultRate());
			formBean.setStrRateUnitId(vo.getStrRateUnitId());
			formBean.setStrInventoryUnitId(vo.getStrInventoryUnitId());
			formBean.setStrApprovedType(vo.getStrApprovedType());
			formBean.setStrIssueType(vo.getStrIssueType());
			formBean.setStrItemMake(vo.getStrItemMake());
			formBean.setStrSparePartFlag(vo.getStrSparePartFlag());
			formBean.setStrSetSachetFlag(vo.getStrSetSachetFlag());
			formBean.setStrIsQuantified(vo.getStrIsQuantified());
			formBean.setStrSpecification(vo.getStrSpecification());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrGenericItem(vo.getStrGenItemName());
			formBean.setStrBrandReserveFlag(vo.getStrBrandReserveFlag());
			formBean.setStrSterilizationFlag(vo.getStrSterilizationFlag());
			formBean.setStrSterilizationLife(vo.getStrSterilizationLife());
			formBean.setStrUploadFileId(vo.getStrUploadFileId());
			formBean.setStrUploadFileName(vo.getStrUploadFileName());
			formBean.setStrIsMisc(vo.getStrIsMisc());
			
			formBean.setMAX_VALUE(vo.getMAX_VALUE());
			formBean.setMIN_VALUE(vo.getMIN_VALUE());
			formBean.setTEMP_SENS_FLAG(vo.getTEMP_SENS_FLAG());
			
			if (vo.getItemTypeWS() != null && vo.getItemTypeWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getItemTypeWS(),vo
						.getStrItemTypeId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemTypeCombo(cmb);

			if (vo.getManufacturerWS() != null
					&& vo.getManufacturerWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getManufacturerWS(), vo
						.getStrManufacturerId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrManufacturerCombo(cmb);

			/*
			 * if (vo.getRateUnitWS() != null && vo.getRateUnitWS().size() > 0)
			 * {
			 * 
			 * cmb = hisutil.getOptionValue(vo.getRateUnitWS(), vo
			 * .getStrRateUnitId(), "0^Select Value", false);
			 * 
			 * } else { cmb = "<option value='0'>Select Value</option>"; }
			 * 
			 * formBean.setStrRateUnitCombo(cmb);
			 */

			formBean.setStrRateUnitId(vo.getStrRateUnitId());
			formBean.setStrRateUnitName(vo.getStrRateUnitName());
			formBean.setStrItemCatNo(vo.getStrItemCatNo());
			
			
			formBean.setStrItemClass(vo.getStrItemClass());
			//formBean.setStrBatchNo(vo.getStrBatchNo());     Not used incase of BMED
			//formBean.setStrExpiryDate(vo.getStrExpiryDate());  Not Used incase of BMED
			formBean.setStrConsumableType(vo.getStrConsumableType());
			//formBean.setStrManufDate(vo.getStrManufDate()); Not Used incase of BMEd
			

			/*String[] strCPACodes = vo.getStrCPACode().replace(".", "#").split(
					"#");

			if (strCPACodes.length > 1) {

				formBean.setStrPrevCPACode(strCPACodes[0]);
				formBean.setStrNewCPACode(strCPACodes[1]);

			} else if (strCPACodes.length == 0) {

				formBean.setStrPrevCPACode("0");
				formBean.setStrNewCPACode("0");

			} else {

				formBean.setStrPrevCPACode(strCPACodes[0]);
				formBean.setStrNewCPACode("0");

			}*/
			
			/*
			 * Previously generic drug part of the drug code was referenced
			 * as Prev CPA code.
			 */
			formBean.setStrPrevCPACode(vo.getStrGenericItemCode());
			if (vo.getStrNewCPACode() != null
					&& !vo.getStrNewCPACode().equals("")) {
				/*
				 * The following code will extract item part of item code. If
				 * item code is PAR.003 then PAR is generic item part and
				 * 003 is item part.
				 */
				String strItemCode = vo.getStrNewCPACode();
				String strItemCodeItemPart;
				int nFirstIndexOfDot = strItemCode.indexOf('.');
				strItemCodeItemPart = strItemCode
						.substring(nFirstIndexOfDot + 1);

				/*
				 * Previously drug part of the drug code was referenced as
				 * new CPA code.
				 */

				formBean.setStrNewCPACode(strItemCodeItemPart);
			} else {
				formBean.setStrNewCPACode(""); // empty string
			}

			formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());

			formBean.setStrChk(request.getParameter("chk"));
			/*Added by Aritra */
			formBean.setStrApprovedTypeOptions(hisutil.getOptionValue(
					vo.getWrsApprovedTypeOptions(), vo.getStrApprovedType(), "0^Select Value", false));
			
			formBean.setStrGenericItemId(vo.getStrGenItemId());
			formBean.setStrHSNCode(vo.getStrHSNCode());
		

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ItemMaster.ItemMstForBMEDDATA.modifyRecord(vo) -->"
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemMstForBMEDDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(ItemMstForBMEDFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ItemMstForBMEDVO vo = null;
		ItemMstForBMEDBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String strCurrentDate;
		String strFileExt;
		AttachFileGlobal fs=null;
		
		String seatid;
		HisUtil hisutil;
		String temp[] = null;
		String strFileId;

		try 
		{
			bo = new ItemMstForBMEDBO();
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospCode());
			hisutil = new HisUtil("mms", "ItemMstForBMEDDATA");
			
//			     chk = formBean.getStrChk();
//			 strtemp = chk.replace('@', '#').split("#");
//			strtemp2 = strtemp[1].replace('$', '#').split("#");
			
	
			if (formBean.getStrChk() != null) 
			{
				     chk = formBean.getStrChk();
				strtemp  = chk.replace('@', '#').split("#");
				strtemp2 = strtemp[3].replace('$', '#').split("#");
			}
			
			
			/*
			
			String osType = System.getProperties().getProperty("os.name");
			if(osType.startsWith("Win"))
			{
				formBean.setStrUploadFileLocation(mmscofigutil.getStrWinLocation());   // Save Location Of File for O.S. WIN
			}
			else
			{
				formBean.setStrUploadFileLocation(mmscofigutil.getStrLinLocation());   // Save Location Of File for O.S. LINUX
			}
			*/
			/////////////////////////////////  File-Up Load  /////////////////////////////////////////////////// 
			/*
			if(formBean.getStrUploadFlag().equals("1"))
			{	
				             fs = new AttachFileGlobal();
				 strCurrentDate = hisutil.getDSDate("DD-Mon-YYYY HH24_MI_SS");
				FormFile myFile = formBean.getStrLocation();
					 strFileExt = myFile.getFileName();
					       temp = strFileExt.replace('.', '#').split("#");
					 strFileExt = temp[temp.length-1];
					  strFileId = strtemp[0]+"_"+(strCurrentDate.replace(" ", "_")).replace("-", "_")+"."+strFileExt;					   
						    formBean.setStrUploadFileId(strFileId);
						    formBean.setStrUploadFileName(myFile.getFileName());
						   
			}
			*/
						
            /////////////////////////////////////////////////////////////////////////////////
					    
			      vo = (ItemMstForBMEDVO) TransferObjectFactory.populateData("mms.masters.vo.ItemMstForBMEDVO", formBean);		    
			        vo.setStrItemBrandId(strtemp[0]);
					vo.setStrHospCode(strtemp[1]);
					vo.setStrItemType(strtemp[2]);
					vo.setStrSerialNo(strtemp2[0]);

			seatid = request.getSession().getAttribute("SEATID").toString();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			formBean.setStrHospCode(hosCode);
			formBean.setStrLastModSeatId(seatid);
			
			
			if (formBean.getStrNewCPACode() != null
					&& !formBean.getStrNewCPACode().trim().equals("")) {
				
			//	if("0".equals(formBean.getStrPrevCPACode())) {
					vo.setStrCPACode(formBean.getStrNewCPACode());
					
			//	} else {
			//		vo.setStrCPACode(formBean.getStrPrevCPACode() + "."
			//				+ formBean.getStrNewCPACode());
			//	}

				

			} else {

				vo.setStrCPACode("");

			}
			
			if(formBean.getStrDefaultRate()==null || formBean.getStrDefaultRate().trim().equals("")) {
				formBean.setStrDefaultRate("0");
				vo.setStrDefaultRate("0");
			}
			vo.setStrGenItemId(formBean.getStrGenericItemId());
			vo.setStrBrandReserveFlag(formBean.getStrBrandReserveFlag());
			vo.setStrSeatId(seatid);
			vo.setStrManufDate(formBean.getStrManufDate());
			vo.setStrIsMisc(formBean.getStrIsMisc());
			
			vo.setTEMP_SENS_FLAG(formBean.getTEMP_SENS_FLAG());
			vo.setMAX_VALUE(formBean.getMAX_VALUE());
			vo.setMIN_VALUE(formBean.getMIN_VALUE());
			
            // Calling BO Method
			bo.updateRecord(vo);

			formBean.setStrChk(request.getParameter("chk"));
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getBExistStatus() == true) {
				retValue = false;
				formBean.setStrWarnMssgstring("Data already exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			retValue = false;
			strmsgText = "ItemMaster.ItemMstForBMEDDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->updateRecord()", strmsgText);
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
	public static void view(HttpServletRequest request, ItemMstForBMEDFB formBean) {
		ItemMstForBMEDVO vo = null;
		ItemMstForBMEDBO bo = null;
		HisUtil hisutil = null;
		String cmb = "";
		String strtemp[] = null;
		String temp[] = null;
		String[] strtemp2 = null;

		try {
			vo = new ItemMstForBMEDVO();
			bo = new ItemMstForBMEDBO();

			hisutil = new HisUtil("mms", "ItemMstForBMEDDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(ctDate);

			if (request.getParameter("comboValue") != null) {
				String strComboValues = request.getParameter("comboValue");
				formBean.setStrComboValues(strComboValues);
				temp = strComboValues.replace('^', '#').split("#");

				formBean.setStrItemCatName(temp[0]);
				formBean.setStrGroupName(temp[1]);

			}

			if (request.getParameter("chk") != null) {
				String chk = request.getParameter("chk");

				strtemp  = chk.replace('@', '#').split("#");
				strtemp2 = strtemp[3].replace('$', '#').split("#");
			}
			
			vo.setStrItemBrandId(strtemp[0]);
			vo.setStrHospCode(strtemp[1]);
			vo.setStrItemType(strtemp[2]);
			vo.setStrSerialNo(strtemp2[0]);
			// Calling BO Method
			bo.view(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrItemTypeName(vo.getStrItemTypeName());
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setStrDefaultRate(vo.getStrDefaultRate());
			formBean.setStrRateUnitName(vo.getStrRateUnitName());
			formBean.setStrManufacturerName(vo.getStrManufacturerName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());

			if ("1".equals(vo.getStrIssueType())) {
				formBean.setStrIssueType("Only to Patient");
			} else if ("2".equals(vo.getStrIssueType())) {
				formBean.setStrIssueType("Only to Staff");
			} else if ("3".equals(vo.getStrIssueType())) {
				formBean.setStrIssueType("Patient/Staff");
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

			formBean.setStrSpecification(vo.getStrSpecification());

			if ("0".equals(vo.getStrSparePartFlag())) {
				formBean.setStrSparePartFlag("Not a spare part.");
			} else if ("1".equals(vo.getStrSparePartFlag())) {
				formBean.setStrSparePartFlag("Spare part.");
			}
			// formBean.setStrSparePartFlag(vo.getStrSparePartFlag());

			if ("0".equals(vo.getStrSetSachetFlag())) {
				formBean.setStrSetSachetFlag("Not a Set/Sachet.");
			} else if ("1".equals(vo.getStrSetSachetFlag())) {
				formBean.setStrSetSachetFlag("Set/Sachet.");
			}
			// formBean.setStrSetSachetFlag(vo.getStrSetSachetFlag());

			if ("0".equals(vo.getStrIsQuantified())) {
				formBean.setStrIsQuantified("No.");
			} else if ("1".equals(vo.getStrIsQuantified())) {
				formBean.setStrIsQuantified("Yes.");
			}
			// formBean.setStrIsQuantified(vo.getStrIsQuantified());

			bo.initialAdd(vo);

			if (vo.getItemTypeWS() != null && vo.getItemTypeWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getItemTypeWS(), vo
						.getStrItemTypeId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemTypeCombo(cmb);

			if (vo.getManufacturerWS() != null
					&& vo.getManufacturerWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getManufacturerWS(), vo
						.getStrManufacturerId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrManufacturerCombo(cmb);

			if (vo.getRateUnitWS() != null && vo.getRateUnitWS().size() > 0) {

				cmb = hisutil.getOptionValue(vo.getRateUnitWS(), vo
						.getStrRateUnitId(), "0^Select Value", false);

			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrRateUnitCombo(cmb);

			formBean.setStrGenItemName(vo.getStrGenItemName());
			formBean.setStrGroupName(vo.getStrGroupName());
			formBean.setStrItemCatName(vo.getStrItemCatName());

			String strBrandReserveStatus = (vo.getStrBrandReserveFlag()
					.equals("1")) ? "Branded" : (vo.getStrBrandReserveFlag()
					.equals("2")) ? "Non Branded" : "Reserved";

			formBean.setStrBrandReserveStatus(strBrandReserveStatus);
			formBean.setStrCPACode(vo.getStrCPACode());

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemMstForBMEDDATA->view()",
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
	
	
	public String getconsumeCombo(ItemMstForBMEDFB fb) {
		

		String strCsCmb = "";
		ItemMstForBMEDBO bo = new ItemMstForBMEDBO();
		ItemMstForBMEDVO vo = null;

		try {
			vo = (ItemMstForBMEDVO) TransferObjectFactory.populateData("mms.masters.vo.ItemMstForBMEDVO",fb);
            vo = new ItemMstForBMEDVO();
            bo = new ItemMstForBMEDBO();
            vo.setStrGenericItem(fb.getStrGenericItem());
            vo.setStrItemBrandId(fb.getStrItemBrandId());
            vo.setStrInventoryUnitId(fb.getStrInventoryUnitId());
            bo.consumeCombo(vo);
            strCsCmb=vo.getStrConsumableType();
		} catch (Exception e) {
			new HisException("mms", "ItemMstForBMEDDATA.getconsumeCombo()", e.getMessage());
		}

		return strCsCmb;
	}
	

}
