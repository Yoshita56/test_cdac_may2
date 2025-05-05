package mms.transactions.controller.data;

import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.SimpleDateFormat;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.patDtl.PatientDtlHLP;
import mms.transactions.bo.SupplierTransactionRecordBO;
import mms.transactions.controller.fb.SupplierTransactionRecordFB;
import mms.transactions.controller.hlp.SupplierTransactionRecordHLP;
import mms.transactions.vo.SupplierTransactionRecordVO;

public class SupplierTransactionRecordDATA {

	public static void initialStoreItemAdd(SupplierTransactionRecordFB formBean, HttpServletRequest request) {
		SupplierTransactionRecordVO vo = null;
		SupplierTransactionRecordBO bo = null;
		HisUtil hisutil = null;

		try {
			String strmsgText;
			try {
				vo = new SupplierTransactionRecordVO();
				bo = new SupplierTransactionRecordBO();

				hisutil = new HisUtil("mms", "SupplierTransactionRecordDATA");

				String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				String seatId = request.getSession().getAttribute("SEATID").toString();

				formBean.setStrHospitalCode(hosCode);
				formBean.setStrSeatId(seatId);

				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatId);

				bo.getstoreNameList(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				String tempStrCmb = "";
				if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
					if (vo.getWsStoreNameCombo().next()) { // brings simply cursor to 1st row if exist & return type is
															// boolean i.e. true or false
						vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
						// Default value for store Id will be
						System.out.println("Default:vo.setStrStoreId --" + vo.getStrStoreId());
						vo.getWsStoreNameCombo().beforeFirst();// before first row to make it ready for next iteration
																// to start from 1st position
					}
					tempStrCmb = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "0", "0^Select Value", false);
				} else {
					tempStrCmb = "<option value='0'>Select Value</option>";
				}
				formBean.setStrStoreNameCombo(tempStrCmb);

				bo.getCategoryList(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				String tempItmCmb = "";
				if (vo.getWsItemCategoryCombo() != null && vo.getWsItemCategoryCombo().size() > 0) {
					tempItmCmb = hisutil.getOptionValue(vo.getWsItemCategoryCombo(), "0", "0^Select Value", false);
				} else {
					tempItmCmb = "<option value='0'>Select Value</option>";
				}
				formBean.setStrItemCategoryCombo(tempItmCmb);

				String strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
				formBean.setStrCurrentDate(strCurrentDate);

			} catch (Exception var14) {
				var14.printStackTrace();
				strmsgText = var14.getMessage();
				HisException eObj = new HisException("mms", "SupplierTransactionRecordDATA->initialGenAdd()",
						strmsgText);
				formBean.setStrErrMsg(
						"Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
			}
		} finally {
			if (vo != null) {
				vo = null;
			}
			if (bo != null) {
				bo = null;
			}
			hisutil = null;
		}

	}

	public static void getDataTableDataOnSelection(SupplierTransactionRecordFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		SupplierTransactionRecordVO vo = null;
		SupplierTransactionRecordBO bo = null;
		String dataTablePrintHLP = "";
		Object var6 = null;

		try {
			vo = new SupplierTransactionRecordVO();
			bo = new SupplierTransactionRecordBO();
			new HisUtil("MMS Transactions", "getDataTableOnSelection");

			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCategoryId(request.getParameter("categoryId"));

			/*vo.setStrItemCategoryId(request.getParameter("categoryId") != null ? request.getParameter("categoryId").split("\\^")[0] : null);
			System.out.println("getDataTableOnSelection >> vo.setStrStoreId  ::" + request.getParameter("storeId"));
			System.out.println("getDataTableOnSelection >> vo.setStrItemCategoryId ::" + request.getParameter("categoryId"));*/

			bo.getDataTable(vo); //pkg_mms_view2.proc_supplier_receipt_list 2 Modeval

			System.out.println("DATA::getDataTableDataOnSelection::SIZE" + vo.getWrsData().size());

			dataTablePrintHLP = getdataTablePrintHLP(vo.getWrsData());

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(dataTablePrintHLP);

		} catch (Exception var13) {
			var13.printStackTrace();
			String msgStr = var13.getMessage();
			HisException eObj = new HisException("mms", "ReturnAgainstIssuedRPTDATA->getDataTableOnSelection()",
					msgStr);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (bo != null) {
				bo = null;
			}

			if (vo != null) {
				vo = null;
			}
		}
	}

	private static String getdataTablePrintHLP(WebRowSet wrs) throws SQLException, Exception {

		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);

		int index = 0;

		new SimpleDateFormat("dd-MMM-yyyy");

		sbHeader.append("<thead>");
		sbHeader.append("<tr>");
		sbHeader.append("<th width='20%'>LPO No/LP Date</th>");
		sbHeader.append("<th width='20%'>Bill / DC NO</th>");
		sbHeader.append("<th width='10%'>Catg</th>");
		sbHeader.append("<th width='23%'>Supplier</th>");
		sbHeader.append("<th width='12%'>Value</th>");
		sbHeader.append("<th width='10%'>Status</th>");
		sbHeader.append("<th width='5%'>#</th>");

		sbHeader.append("</tr>");
		sbHeader.append("</thead>");
		sbHeader.append("<tbody>");

		if (wrs != null && wrs.size() > 0) {
			while (wrs.next()) {
				/*
				1. LPNO @ STORE ID @ HOSP CODE
				2. LP NO
				3. LP DATE
				4. SUPPLIER NAME
				5. CATG_NAME
				6. hstnum_invoice_no || ' / ' || hstnum_dc_no
				7. TOT_VALUE
				8. STORE NAME
				*/
				String hiddenVal = wrs.getString(1); // LPNO @ STORE ID @ HOSP CODE

				String lpono = wrs.getString(2);
				String lpodate = wrs.getString(3);
				String supplier = wrs.getString(4);
				String catg = wrs.getString(5);
				String billdcno = wrs.getString(6);
				String value = wrs.getString(7);
				String status = wrs.getString(8);

				sbBody.append("<tr>");
				sbBody.append("<input type='hidden' name='hiddenVal'  value='" + hiddenVal + "'>");
				sbBody.append("<td width='20%'>" + lpono + "/" + lpodate + "</td>");
				sbBody.append("<td width='20%'>" + billdcno + "</td>");
				sbBody.append("<td width='10%'>" + catg + "</td>");
				sbBody.append("<td width='23%'>" + supplier + "</td>");
				sbBody.append("<td width='12%'>" + value + "</td>");
				sbBody.append("<td width='10%'>" + status + "</td>");
				sbBody.append("<td width='5%'>" + "<button type='button' id='row" + index + "' "
						+ "class='btn btn-sm btn-success rounded-sm' data-placement='top' data-toggle='tooltip' "
						+ "title='View' onclick='getIssuePopUpFromHLP(this, " + index + ");'>"
						+ "<i class='fa fa-fw fa-eye' aria-hidden='true'></i>" + "</td>");

				sbBody.append("</tr>");
				++index;
			}
		} else {
			sbBody.append(
					"<tr style='text-align:center; color:red;'> <td colspan='7'>No Records to Display</td> </tr>");
		}
		sbHeader.append("</tbody>");

		return sbHeader.toString() + sbBody.toString();
	}

	public static void initialDrugAdd(SupplierTransactionRecordFB formBean, HttpServletRequest request) {
		SupplierTransactionRecordBO bo = null;
		SupplierTransactionRecordVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;

		String supplierList = "";
		String ManufacturerList = "";
		String instituteList = "";
		String strItemBrandCombo = "";

		try {
			bo = new SupplierTransactionRecordBO();
			vo = new SupplierTransactionRecordVO();

			hisutil = new HisUtil("mms", "SupplierTransactionRecordDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
//       formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			formBean.setStrCtDate(ctDate);

			System.out.println("DATA:initialDrugAdd-->HOSPITAL_CODE"
					+ request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("SEATID" + request.getSession().getAttribute("SEATID").toString());

			System.out.println("formBean.getStrStoreId()-->" + formBean.getStrStoreId());
			System.out.println("formBean.getStrItemCategoryId()--->" + formBean.getStrItemCategoryId());

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryId(formBean.getStrItemCategoryId());

			bo.initialDrugAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// Drug List Combo
			if (vo.getStrItemBrandComboWS() != null && vo.getStrItemBrandComboWS().size() > 0) {
				strItemBrandCombo = hisutil.getOptionValue(vo.getStrItemBrandComboWS(), vo.getStrItemBrandId(),
						"0^Select Value", false);
			} else {
				strItemBrandCombo = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemBrandCombo(strItemBrandCombo);

			// Supplier List Combo
			if (vo.getStrSupplierWs() != null && vo.getStrSupplierWs().size() > 0) {
				supplierList = hisutil.getOptionValue(vo.getStrSupplierWs(), "0", "0^Select Value", true);
			} else {
				supplierList = "<option value='0'>Select Value</option>";
			}
			formBean.setStrSupplierCombo(supplierList);

			// Purchase Through Combo
			if (vo.getStrSupplierWs1() != null && vo.getStrSupplierWs1().size() > 0) {
				instituteList = hisutil.getOptionValue(vo.getStrSupplierWs1(), "0", "0^Select Value", true);
			} else {
				instituteList = "<option value='0'>Select Value</option>";
			}
			formBean.setStrInstituteCombo(instituteList);

			// Manufacturer List Combo
			if (vo.getStrManufactureComboWS() != null && vo.getStrManufactureComboWS().size() > 0) {
				ManufacturerList = hisutil.getOptionValue(vo.getStrManufactureComboWS(), "0", "0^Select Value", true);
			} else {
				ManufacturerList = "<option value='0'>Select Value</option>";
			}
			formBean.setStrSuppliedByValues(ManufacturerList);

		} catch (Exception var17) {
			var17.printStackTrace();
			strmsgText = "SupplierTransactionRecordDATA.initialDrugAdd(vo) --> " + var17.getMessage();
			HisException eObj = new HisException("mms", "SupplierTransactionRecordDATA->initialDrugAdd()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	public static void insert(SupplierTransactionRecordFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		String strmsgText = "";
		SupplierTransactionRecordBO bo = null;
		SupplierTransactionRecordVO vo = null;
		Object var4 = null;
		HisUtil hisutil = null;

		try {
			bo = new SupplierTransactionRecordBO();
			vo = (SupplierTransactionRecordVO) TransferObjectFactory.populateData("mms.transactions.vo.SupplierTransactionRecordVO", formBean);
			
			hisutil = new HisUtil("mms", "SupplierTransactionRecordDATA");

			//new MmsConfigUtil(formBean.getStrHospitalCode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			System.out.println("DATA-INSERT-->formBean.getStrHospitalCode--->" + formBean.getStrHospitalCode());
			System.out.println("DATA-INSERT-->formBean.getStrSeatId--->" + formBean.getStrSeatId());

			System.out.println("DATA-INSERT-->formBean.getStrItemCategoryId--->" + formBean.getStrItemCategoryId());

			System.out.println("DATA -print the supplier header field values");
			System.out.println("STRSUPPLIERID: " + formBean.getStrSupplierId());
			System.out.println("STRMANUFACTURERID: " + formBean.getStrManufacturerId());
			System.out.println("STRDCNO : " + formBean.getStrDCNo());
			System.out.println("STRLPONUMBER: " + formBean.getStrLpoNo());
			System.out.println("STRPODATE: " + formBean.getStrPoDate());
			System.out.println("STRCHALLANDATE: " + formBean.getStrChallanDate());
			System.out.println("STRINVOICENO: " + formBean.getStrInvoiceNo());
			System.out.println("STRINVOICEDATE: " + formBean.getStrInvoiceDate());
			System.out.println("STREXPDELIVERYDATE: " + formBean.getStrExpDeliveryDate());
			System.out.println("STRINSTITUTEID: " + formBean.getStrInstituteId());

			vo.setStrItemCategoryId(formBean.getStrItemCategoryId());

			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrManufacturerId(formBean.getStrManufacturerId());
			vo.setStrDCNo(formBean.getStrDCNo());
			vo.setStrLpoNo(formBean.getStrLpoNo());
			vo.setStrPoDate(formBean.getStrPoDate());
			vo.setStrChallanDate(formBean.getStrChallanDate());
			vo.setStrInvoiceNo(formBean.getStrInvoiceNo());
			vo.setStrInvoiceDate(formBean.getStrInvoiceDate());
			vo.setStrExpDeliveryDate(formBean.getStrExpDeliveryDate());
			vo.setStrInstituteId(formBean.getStrInstituteId());

			String[] strSearchDrugArray = formBean.getStrSearchDrug();
			System.out.println("DATA strSearchDrugArray.Arrays.toString --> " + Arrays.toString(strSearchDrugArray));
			System.out.println("DATA strSearchDrugArray Length -->" + strSearchDrugArray.length);

			String[] strBrandIdArray = formBean.getStrBrandIdTableArray();
			System.out.println("DATA strBrandIdArray.Arrays.toString --> " + Arrays.toString(strBrandIdArray));
			System.out.println("DATA strBrandIdArray Length -->" + strBrandIdArray.length);
			// daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemsIdArrayOM()[i],
			// 3);
			vo.setStrBrandIdTableArray(formBean.getStrBrandIdTableArray());

			String[] strItemsIdArray = formBean.getStrItemsIdTableArray();
			System.out.println("DATA strBrandIdArray.Arrays.toString --> " + Arrays.toString(strItemsIdArray));
			System.out.println("DATA strBrandIdArray Length -->" + strItemsIdArray.length);
			vo.setStrItemsIdTableArray(formBean.getStrItemsIdTableArray());

			int i;
			for (i = 0; i < strBrandIdArray.length; ++i) {
				System.out.println("strBrandIdArrayOM Value at index " + i + ": " + strBrandIdArray[i]);
			}

			for (i = 0; i < strItemsIdArray.length; ++i) {
				System.out.println("strItemsIdArrayOM Value at index " + i + ": " + strItemsIdArray[i]);
			}

			/* System.out.println("OBJECTMAPPER");
			 String jsonStrBrandId = formBean.getStrBrandId();
			 String jsonStrItemsId = formBean.getStrItemsId();
			 ObjectMapper objectMapper = new ObjectMapper();
			 String[] strBrandIdArrayOM = (String[])objectMapper.readValue(jsonStrBrandId, String[].class);
			 String[] strItemsIdArrayOM = (String[])objectMapper.readValue(jsonStrItemsId, String[].class);
			 vo.setStrBrandIdArrayOM(strBrandIdArrayOM);
			 vo.setStrItemsIdArrayOM(strItemsIdArrayOM);
			 System.out.println("strBrandIdArrayOM: " + Arrays.toString(strBrandIdArrayOM));
			 System.out.println("strBrandIdArray Length -->" + strBrandIdArrayOM.length);
			 System.out.println("strItemsIdArrayOM: " + Arrays.toString(strItemsIdArrayOM));
			 System.out.println("strItemsIdArrayOM Length -->" + strItemsIdArrayOM.length);
			
			 int i;
			 for(i = 0; i < strBrandIdArrayOM.length; ++i) {
			System.out.println("strBrandIdArrayOM Value at index " + i + ": " + strBrandIdArrayOM[i]);
			 }
			
			 for(i = 0; i < strItemsIdArrayOM.length; ++i) {
			System.out.println("strItemsIdArrayOM Value at index " + i + ": " + strItemsIdArrayOM[i]);
			 }*/

			/*  
			  new  chatgpt
			  String[] strBrandIdArrayOM = formBean.getStrBrandId(); // Directly retrieve the array
			  String[] strItemsIdArrayOM = formBean.getStrItemsId(); // Directly retrieve the array
			
			  // Set arrays in VO
			  vo.setStrBrandIdArrayOM(strBrandIdArrayOM);
			  vo.setStrItemsIdArrayOM(strItemsIdArrayOM);
			  
			  // Print details for debugging
			  System.out.println("strBrandIdArrayOM Contents: " + Arrays.toString(strBrandIdArrayOM));
			  System.out.println("strBrandIdArrayOM Length: " + (strBrandIdArrayOM != null ? strBrandIdArrayOM.length : "null or empty"));
			  System.out.println("strItemsIdArrayOM Contents: " + Arrays.toString(strItemsIdArrayOM));
			  System.out.println("strItemsIdArrayOM Length: " + (strItemsIdArrayOM != null ? strItemsIdArrayOM.length : "null or empty"));*/

			System.out.println("DATA batchNo: " + Arrays.toString(formBean.getStrBatchNo()));
			System.out.println("mfgDate: " + Arrays.toString(formBean.getMfgDate()));
			System.out.println("expDate: " + Arrays.toString(formBean.getExpDate()));
			System.out.println("strPuRate: " + Arrays.toString(formBean.getStrPuRate()));
			System.out.println("strPurQty: " + Arrays.toString(formBean.getStrPurQty()));
			System.out.println("strGst: " + Arrays.toString(formBean.getStrGst()));
			System.out.println("strAdm: " + Arrays.toString(formBean.getStrAdm()));

			System.out.println("strPuRateWitTax: " + Arrays.toString(formBean.getStrPuRateWitTax()));

			System.out.println("strDifference: " + Arrays.toString(formBean.getStrDifference()));

			System.out.println("DATA strCosttoPat: " + Arrays.toString(formBean.getStrCosttoPat()));

			vo.setStrExpiryDate(Arrays.toString(formBean.getExpDate()));
			vo.setStrInstituteId(formBean.getStrInstituteId());

			bo.insert(vo);
			/*
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrSerialNo(vo.getStrSerialNo());
			formBean.setStrNormalMsg("Data has been Successfully Saved !!");
			*/		

			System.out.println("vo.getStrLpoNo()"+vo.getStrLpoNo());
			
			bo.getPrintDetails(vo); // PKG_MMS_VIEW.PROC_HSTT_LP_DTL [ Mode - 1]

			String strPrintHLP = SupplierTransactionRecordHLP.getPrintItemDetails(vo.getWsPrint(),vo.getStrHospitalCode());
			//formBean.setStrPrintDtls(strPrintHLP);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPrintHLP);
			
		} catch (Exception var15) {
			strmsgText = "DrugInventory.SupplierTransactionRecordDATA.insertRecord(vo) --> " + var15.getMessage();
			HisException eObj = new HisException("mms", "SupplierTransactionRecordDATA->insertRecord()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			var4 = null;
		}

	}

	public static void issueDtlsInitNEW(SupplierTransactionRecordFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strSearchItemInitView = "", strPatientDtl = "";

		SupplierTransactionRecordBO bo = null;
		SupplierTransactionRecordVO vo = null;

		try {
			String strMode = "1";
			String strFromStoreId = "102010";
			String strIssueNo = "111111111";
			String strIndentNo = "222222222";
			String crNo = "108111241541334";
			String strIndentDate = "4-Dec-2024";

			bo = new SupplierTransactionRecordBO();
			vo = new SupplierTransactionRecordVO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); //

			System.out.println(
					"---- SupplierTransactionRecordDATA . issueDtlsInitNEW --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strMode        ----" + strMode);
			System.out.println("--strFromStoreId ----" + strFromStoreId);
			System.out.println("--strIssueNo     ----" + strIssueNo);
			System.out.println("--strIndentNo    ----" + strIndentNo);
			System.out.println("--crNo           ----" + crNo);
			System.out.println("----------------------------------");

			formBean.setStrStoreId(strFromStoreId);
			formBean.setStrInvoiceNo(strIssueNo);

			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrInvoiceNo(formBean.getStrInvoiceNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrStoreId(formBean.getStrStoreId());

			formBean.setStrDCNo(crNo);
			vo.setStrDCNo(crNo);

			System.out.println(
					"************** IssueTransODATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");

			strPatientDtl = PatientDtlHLP.patientWithAdmissionDtl(crNo, formBean.getStrHospitalCode(), true);

			System.out.println("*************************************************");

			vo.setStrDCNo(strPatientDtl);

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			bo.getIssueDtlsInitDtls(vo); // pkg_mms_view.Proc_Emp_Issue_Detail --[ Mode- 5 ]

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			vo.getItemWS().beforeFirst();
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			System.out.println("-WsIssueDetails --Size in HLP ----" + vo.getItemWS().size());

			vo.getItemWS().beforeFirst();
			// String strAfterSaveVoucher =
			// SupplierTransactionRecordHLP.getAfterSaveVoucher(vo,"1");
			response.setHeader("Cache-Control", "no-cache");
			// response.getWriter().print(strAfterSaveVoucher);
			System.out.println("---- SupplierTransactionRecordDATA . issueDtlsInitNEW --[ END ]--");

		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	public static void getPrintDetails(SupplierTransactionRecordFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		String strmsgText = "";
		SupplierTransactionRecordBO bo = null;
		SupplierTransactionRecordVO vo = null;
		HisUtil hisutil = null;

		try {
			hisutil = new HisUtil("mms", "SupplierTransactionRecordDATA");

			bo = new SupplierTransactionRecordBO();
			vo = new SupplierTransactionRecordVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrLpoNo(formBean.getStrPkey().split("\\@")[0]);
			vo.setStrStoreId(formBean.getStrPkey().split("\\@")[1]);

			System.out.println("getStrPkey-setStrLpoNo" + formBean.getStrPkey().split("\\@")[0]);
			System.out.println("getStrPkey-setStrStoreId" + formBean.getStrPkey().split("\\@")[1]);

			bo.getPrintDetails(vo); // PKG_MMS_VIEW.PROC_HSTT_LP_DTL [ Mode - 1]

			String strCurrentDate = hisutil.getASDate("dd-MMM-yyyy hh:mm");
			formBean.setStrCurrentDate(strCurrentDate);

			String strPrintHLP = SupplierTransactionRecordHLP.getPrintItemDetails(vo.getWsPrint(),vo.getStrHospitalCode());
			formBean.setStrPrintDtls(strPrintHLP);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPrintHLP);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DrugInventory.SupplierTransactionRecordDATA.insertRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "SupplierTransactionRecordDATA->insertRecord()", strmsgText);
			// formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() +
			// "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/* public static String getdataTablePrintHLP_new(WebRowSet wrsData_p) throws SQLException, Exception 
	 {
	   System.out.println("******************** SupplierTransactionRecordDATA.getPendingDayEndDetailsTable **********************");
	   
	  StringBuffer sbHeader = new StringBuffer(100);
	  StringBuffer sbBody = new StringBuffer(100);
	  int index = 0;
	 
	    sbHeader.append("<table class='table' id='data-table' >");
	  sbHeader.append("<thead>");
	  sbHeader.append("<tr>");
	  sbHeader.append("<th width='20%'>LPO No / Date</th>");    
	  sbHeader.append("<th width='15%'>Bill / DC NO</th>");
	  sbHeader.append("<th width='10%'>Catg</th>");
	  sbHeader.append("<th width='20%'>Supplier</th>");
	  sbHeader.append("<th width='10%'>Value</th>");
	  sbHeader.append("<th width='15%'>Store Name</th>");
	  sbHeader.append("<th width='10%'>#</th>");
	  
	  sbHeader.append("</tr>");
	  sbHeader.append("</thead>");
	  sbHeader.append("<tbody>");
	  
	  if (wrsData_p != null && wrsData_p.size() > 0) 
	  {
	     while(wrsData_p.next()) 
	     {
	    	 
	         1. LPNO @ STORE ID @ HOSP CODE
	         2. LP NO
	         3. LP DATE
	         4. SUPPLIER NAME
	         5. CATG_NAME
	         6. hstnum_invoice_no || ' / ' || hstnum_dc_no
	         7. TOT_VALUE
	         8. STORE NAME
	           
	    	     String hiddenVal	= wrsData_p.getString(1);  // LPNO @ STORE ID @ HOSP CODE
	        	 String lpono 		= wrsData_p.getString(2);
				 String lpodate 	= wrsData_p.getString(3);
				 String billdcno 	= wrsData_p.getString(6);
				 String catg 		= wrsData_p.getString(5);
				 String supplier 	= wrsData_p.getString(4);
				 String value 		= wrsData_p.getString(7);
				 String status 		= wrsData_p.getString(8);
			 
		        sbBody.append("<tr>");
		        sbBody.append("<input type='hidden' name='hiddenVal'  value='"+hiddenVal+"'>");
		        sbBody.append("<td width='20%'>" + lpono + "/" + lpodate + "</td>");
		        sbBody.append("<td width='15%'>" + billdcno + "</td>");
		        sbBody.append("<td width='10%'>" + catg + "</td>");
		        sbBody.append("<td width='20%'>" + supplier + "</td>");
		        sbBody.append("<td width='10%'>" + value + "</td>");
		        sbBody.append("<td width='10%'>" + status + "</td>"); 		       
		        sbBody.append("<td width='10'>"
					     + "<button type='button' id='row" + index + "' "
					     + "class='btn btn-sm btn-success rounded-sm' data-placement='top' data-toggle='tooltip' "
					     + "title='View' onclick='getIssuePopUpFromHLP(this, " + index + ");'>"
					     + "<i class='fa fa-fw fa-eye' aria-hidden='true'></i>"
					     + "</td>");
	
	            sbBody.append("</tr>");
	            
	            ++index;
	     }
	  }
	  else
	  {
	      sbBody.append("<tr><td colspan='7' style='text-align:center; color:red;'>No Records to Display</td></tr>");
	  }
	
	  sbHeader.append("</tbody>");
		sbHeader.append("</table>");
	
	  return sbHeader.toString() + sbBody.toString();
	 }*/
}