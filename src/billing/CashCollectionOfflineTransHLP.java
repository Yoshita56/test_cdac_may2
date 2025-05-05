package billing;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.BillingVO;
import billing.HLPbilling;

public class CashCollectionOfflineTransHLP {

	
	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	/**
	 * returns the required Off-line Part Payment Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Off-line Part Payment Details View
	 */
	public static String getOffLinePartPaymentDetailsView(CashCollectionOfflineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLinePartPaymentDetailsView()");
		String strApprovedBy = "";
		try 
		{
			if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() > 0) 
			{
				voObj.getOfflineApprovedByList().beforeFirst();
				strApprovedBy = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value",false);
			} 
			else 
			{
				strApprovedBy = "<option value='0'>Select Value</option>";
			}
			String strRemarks = "";
			
			if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() > 0) 
			{
				voObj.getOfflineRemarksList().beforeFirst();
				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),"", "", false);
				strRemarks = strRemarks + "<option value='0'>Others</option>";
			} 
			else 
			{
				strRemarks = "<option value='0' selected>Others</option>";
			}

			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td class='TITLE'>Part Payment Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr> ");

			sb.append("<td width='15%'class='LABEL'><div align='right'>Part Payment Amount:</div></td> ");

			if (!voObj.getStrOffLinePartPaymentAmount().equals("")) 
			{
				sb.append("<td width='10%' class='CONTROL'><div align='left'><input type='hidden' name='strdummypartpayment' value='"+ voObj.getStrOffLinePartPaymentAmount()+ "'>");
				sb.append("<input name='strPartpayment' tabindex='1' id='strPartpayment' type='text'  maxlength='7'  class='form-control' value='"+ voObj.getStrOffLinePartPaymentAmount()+ "' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);'>&nbsp;<img src='../../hisglobal/images/INR.png'></div></td> ");
			}
			else 
			{
				sb.append("<td width='10%' class='CONTROL'><div align='left'><input type='hidden' name='strdummypartpayment' value='0'>");
				sb.append("<input name='strPartpayment' tabindex='1' id='strPartpayment' type='text'  maxlength='7'  class='form-control' value='0' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'>&nbsp;<img src='../../hisglobal/images/INR.png'></div></td> ");
			}
			//System.out.println("voObj.getStrOffLineTreatmentCategory()"+voObj.getStrOffLineTreatmentCategory());
			
			if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#").length>=2)
			{
				String strCatGroup  	= voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1];//3,4- Credit,0-Paid 
				if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					/*sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("<option value='13'>Credit(Urgent)</option>");*/
					sb.append("</select>");
					sb.append("</td>");
					/*sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append(HisUtil.getDatePicker("strCreditLetterDate", "", true));	*/				
					//sb.append("<input type='hidden' name='strClientPatientNo'>");					
					//sb.append("<input type='hidden' name='strCreditFilePath'>");					
					//sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					//sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboOffline(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
					
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");						
					/*sb.append("<select class='comboMax' name='strCreditLetterNo' id='strCreditLetterNoId'> ");
					
					if (voObj.getCreditLettersWS() != null && voObj.getCreditLettersWS().size() > 0) 
					{
						sb.append(new HisUtil("Billing", "CashCollectionOfflineHLP").getOptionValue(voObj.getCreditLettersWS(), "", "0^Select Value", false));
						sb.append("</select>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}	*/	
					sb.append(creditListCombo);
					//sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					sb.append("</td>");					
				}
				else				
				{
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='10'>Paid</option>");
					//sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					/*sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append(HisUtil.getDatePicker("strCreditLetterDate", "", true));	*/				
					//sb.append("<input type='hidden' name='strClientPatientNo'>");					
					//sb.append("<input type='hidden' name='strCreditFilePath'>");					
					//sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					//sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true); 
					
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");						
					/*sb.append("<select class='comboMax' name='strCreditLetterNo' id='strCreditLetterNoId'> ");
					
					if (voObj.getCreditLettersWS() != null && voObj.getCreditLettersWS().size() > 0) 
					{
						sb.append(new HisUtil("Billing", "CashCollectionOfflineHLP").getOptionValue(voObj.getCreditLettersWS(), "", "0^Select Value", false));
						sb.append("</select>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}	*/	
					sb.append(creditListCombo);
					sb.append("</td>");					
				}
				/*if(strCatGroup.equals("4"))//Credit
				{
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					sb.append("</select>");
					sb.append("</td>");
					//adding Credit Client Details ....
					sb.append("<td width='24%' class='LABEL'>Arogyashri No/Card No.</td>");
					sb.append("<td width='24%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<input type='hidden' name='strClientPatientNo'>");					
					sb.append("<input type='hidden' name='strCreditFilePath'>");					
					sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
				}*/
			}
			//sb.append("<td width='50%'class='LABEL' > ");
			///sb.append("<div id='id11' style='display:block'> ");
			//sb
			//.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			//sb.append("<tr>  ");
			///sb.append("<td width='25%' class='LABEL'>Update:</td> ");
			///sb.append("<td width='25%' class='CONTROL'><input type='checkbox' name='strChk_value' value='0' onClick='ftnTick();'></td> ");
			//sb.append("</tr> ");
			//sb.append("</table> ");
			///sb.append("</div>");
			//sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr style='display:none'> ");
			//sb.append("<td width='50%'class='LABEL' > ");
			//sb.append("<div id='id12' style='display:block'> ");
			//sb
			//.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			//sb.append("<tr>  ");
			sb.append("<td width='25%' class='LABEL'><div style='display:none'> Against Security:</div></td> ");
			sb.append("<td width='25%' class='CONTROL'><div style='display:none'> <input type='checkbox' name='advSecFlag' value='0' onClick='ftnadvSecTick();' ></div></td> ");
			//sb.append("</tr> ");
			//sb.append("</table> ");
            //sb.append("</div>");
			//sb.append("</td> ");

			//end of code added by Garima Gotra
			
			sb.append("<td width='25%' class='LABEL' >Part Payment Remarks ");
			sb.append("</td> ");			
			sb.append("<td width='25%' colspan='3' class='CONTROL'> ");
			sb.append("<input type='text' name='strRemarks' disabled='true' class='txtFldBig' maxlength='100' onkeypress='return validateDataWithSpecialChars(event,9,\".\");' >");
			sb.append("</td> ");
			sb.append("</tr> ");

			sb.append("</table> ");

		
			sb.append("<div id='combo' style='display:none'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			
			if(voObj.getStrIsApprovalRequired().equals("1")){
				
				sb
				.append("<td width='25%' class='LABEL'><font color='red'>*</font>Approval By</td> ");
				
			}else{
				
				sb
				.append("<td width='25%' class='LABEL'>Approval By</td> ");
				
			}
			
		
			
			
			
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb
					.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb
					.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"
							+ voObj.getStrOffLineRemarks()
							+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div> ");

		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Off-line Advance Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Off-line Advance Details View
	 */
	public static String getOffLineAdvanceDetailsView(CashCollectionOfflineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLineAdvanceDetailsView()");

		String strApprovedBy = "";
		
		String strCatGroup="";
		try 
		{
			//voObj.getStrOffLineTreatmentCategory();
			
			strCatGroup  = voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1];//3,4- Credit,0-Paid
			if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() > 0) 
			{
				voObj.getOfflineApprovedByList().beforeFirst();
				strApprovedBy = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value",false);
			} 
			else 
			{
				strApprovedBy = "<option value='0'>Select Value</option>";
			}

			String strRemarks = "";

			if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() > 0) 
			{
				voObj.getOfflineRemarksList().beforeFirst();
				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),"", "", false);
				strRemarks = strRemarks + "<option value='0'>Others</option>";
			} 
			else 
			{
				strRemarks = "<option value='0' selected>Others</option>";
			}
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td class='TITLE'>Advance Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td width='12%' class='LABEL'>Advance Amount:</td> ");

			if (!voObj.getStrOffLineAdvanceAmount().equals("")) 
			{
				sb.append("<td width='12%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='"+ voObj.getStrOffLineAdvanceAmount()+ "'>");
				sb.append("<input name='strPartpayment' tabindex='1'  maxlength='7' id='strPartpayment' type='text' class='txtFldMin' value='"+ voObj.getStrOffLineAdvanceAmount()+ "' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);' >&nbsp;Rs</td> ");
			} 
			else 
			{
				sb.append("<td width='12%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='0'>");
				sb.append("<input name='strPartpayment' tabindex='1'  maxlength='7' id='strPartpayment' type='text' class='txtFldMin' value='0' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'>&nbsp;Rs</td> ");
			}
			if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
			{
				sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
				sb.append("<td width='10%' class='CONTROL'>");
				sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
				sb.append("<option value='11'>Credit</option>");
				sb.append("<option value='10'>Paid</option>");
				/*sb.append("<option value='12'>Paid(Urgent)</option>");
				sb.append("<option value='13'>Credit(Urgent)</option>");*/
				sb.append("</select>");
				sb.append("</td>");
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
				voBilling.setStrServiceType("2");//IPD Letters
				String creditListCombo=HLPbilling.getCreditLetterListComboOffline(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService());
				
				sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
				sb.append("<td class='CONTROL'>");
				sb.append(creditListCombo);
				sb.append("</td>");
			}
			else
			{
				sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
				sb.append("<td width='10%' class='CONTROL'>");
				sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
				sb.append("<option value='10'>Paid</option>");
				//sb.append("<option value='12'>Paid(Urgent)</option>");
				//sb.append("<option value='11'>Credit</option>");
				sb.append("</select>");
				sb.append("</td>");
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
				voBilling.setStrServiceType("2");//IPD Letters
				String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true);
				
				sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
				sb.append("<td class='CONTROL'>");
				sb.append(creditListCombo);
				sb.append("</td>");		
			}
			
			/*sb.append("<td width='50%' class='LABEL' > ");
			sb.append("<div id='id11' style='display:block'> ");
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>  ");
			sb.append("<td width='25%' class='LABEL'>Update:</td> ");
			sb.append("<td width='25%' class='CONTROL'><input type='checkbox' name='strChk_value' onClick='ftnTick();'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div>");
			sb.append("</td> ");*/
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<div id='combo' style='display:none'> ");
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			
			if(voObj.getStrIsApprovalRequired().equals("1"))
			{				
				sb.append("<td width='25%' class='LABEL'><font color='red'>*</font>Approval By</td> ");				
			}
			else
			{				
				sb.append("<td width='25%' class='LABEL'>Approval By</td> ");				
			}			
			
			sb.append("<td width='50%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"+ voObj.getStrOffLineRemarks()+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div> ");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			new HisException("Cash Collection Trans","CashCollectionTransHLP.getOffLineAdvanceDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Client Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOffLineClientDetailsView(CashCollectionOfflineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsClientDetails = voObj.getOfflineClientDetails();

		try {

			String strHidden = "";
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusoffLineClientDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("	src='../../hisglobal/images/plus.gif' name='plusoffLineClientDtl' ");
			sb.append("align='middle'  ");
			sb
					.append("onclick='showCltDetails(\"offLineClientDtlId\");' /></div> ");
			sb
					.append("<div id='minusoffLineClientDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusoffLineClientDtl' ");
			// sb.append("width='10' height='10' ");
			sb
					.append("onclick='hideCltDetails(\"offLineClientDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Client Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			sb.append("<div id='offLineClientDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");

			if (wsClientDetails != null && wsClientDetails.size() > 0) {
				if (wsClientDetails.next()) {

					String strClientName = wsClientDetails.getString(3);
					String strClientType = wsClientDetails.getString(4);
					String strApprovalNo = wsClientDetails.getString(5);
					String strSancAmount = wsClientDetails.getString(7);
					String strBalanceAmount = wsClientDetails.getString(9);
					String strRequestType = wsClientDetails.getString(14);
					String strPaidByClient = wsClientDetails.getString(18)
							.replace("^", "#").split("#")[2];

					strHidden = wsClientDetails.getString(18);

					if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strSancAmount == null)
						strSancAmount = "";
					// if(strClientName == null) strClientName = "";
					if (strBalanceAmount == null)
						strBalanceAmount = "";
					if (strApprovalNo == null)
						strApprovalNo = "";
					if (strRequestType == null)
						strRequestType = "";

					voObj.setStrOfflineClientName(strClientName);
					voObj.setStrOffLineClientType(strClientType);
					voObj.setStrOffLineSancAmount(strSancAmount);
					voObj.setStrOffLineBalanceAmount(strBalanceAmount);
					voObj.setStrOffLineApprovalNo(strApprovalNo);

					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Client Name<input type='hidden' name='strOfflineClientDetails' value='"
									+ strClientName
									+ "^"
									+ strClientType
									+ "^"
									+ strSancAmount
									+ "^"
									+ strBalanceAmount
									+ "^" + strApprovalNo + "^"+strPaidByClient+"'></td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientName + "</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strClientType
									+ " <input type='hidden' name='strOffLineClientType' value='"
									+ strClientType + "'></td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Sanction Amount</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strSancAmount
									+ " <input type='hidden' name='strOffLineSancAmount' value='"
									+ strSancAmount + "'></td>");
					sb
							.append("<td width='25%' class='LABEL'>Approval No.</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strApprovalNo
									+ " <input type='hidden' name='strOffLineApprovalNo' value='"
									+ strApprovalNo + "'></td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Balance Amount</td>");
					sb
							.append("<td  width='25%' class='CONTROL'>"
									+ strBalanceAmount
									+ " <input type='hidden' name='strOffLineBalanceAmount' value='"
									+ strBalanceAmount
									+ "'> <input type='hidden' name='strOffLineClientDetailsHidden' value='"
									+ strHidden + "'> </td>");
					sb
							.append("<td class='LABEL' width='25%'>Paid by Client</td>");
					sb.append("<td class='CONTROL'>" + strPaidByClient
							+ "</td>");
					sb.append("</tr>");
				}

				sb.append("</table>");
				sb.append("</div>");

			} else {
				sb = new StringBuffer("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getonLineClientDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

	public static String getOffLineOtherDetailsView(CashCollectionOfflineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strAccNo = voObj.getStrOffLineAccountNo();
		String strSpecialWardId = voObj.getStrOffLineSpecialWard();
		String strAccTreatCat = voObj.getStrOffLineTreatmentCategory();
		String strAccChargeType = voObj.getStrOffLineWard();
		String strAccDept = voObj.getStrOffLineRaisingDepartment();

		if (strAccNo.length() > 1) {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

			sb.append("<tr>");

			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusoffLineOtherDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/plus.gif' name='plusoffLineOtherDtl' ");
			sb.append("align='middle' ");
			sb
					.append("onclick='showCltDetails(\"offLineOtherDtlId\");' /></div> ");
			sb
					.append("<div id='minusoffLineOtherDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusoffLineOtherDtl' ");

			sb
					.append("onclick='hideCltDetails(\"offLineOtherDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Other Details</td>");
			sb.append("</tr>");
			sb.append("</table>");

			sb.append("<div id='offLineOtherDtlId' style='display: none'>");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>");

			sb.append("<td width='50%' class='LABEL'>Account No.</td>");
			sb
					.append("<td width='50%' class='CONTROL'>"
							+ strAccNo
							+ " <input type='hidden' name='strOffLineAccountNo' value='"
							+ strAccNo + "'><input type='hidden' name='strSpecialWardId' value='"
							+ strSpecialWardId + "'> <input type='hidden' name='strAccTreatCat' value='"
							+ strAccTreatCat + "'><input type='hidden' name='strAccChargeType' value='"
							+ strAccChargeType + "'><input type='hidden' name='strAccDept' value='"
							+ strAccDept + "'>  </td>");

			sb.append("</tr>");

			sb.append("</table>");
			sb.append("</div>");

		}

		return sb.toString();
	}

	/*public static String getOffLineThirdPartyAmountDtlView() {

		StringBuffer sb = new StringBuffer("");

		sb
				.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb
				.append("<td width='60%' class='LABEL'>Max Benefit From Client (<img src='/HBIMS/hisglobal/images/INR.png'>)</td> ");
		sb
				.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
		sb
				.append("<input type='hidden' name='strOfflineMaxClientBenefitAmount' id='strOfflineMaxClientBenefitAmount' value='0.00'> ");
		sb.append("<div id='offlineMaxClientBenefitDivId'>0.00</div> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		sb
				.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb
				.append("<td width='60%' class='LABEL'>Net Payable Amount By Patient (<img src='/HBIMS/hisglobal/images/INR.png'>)</td> ");
		sb
				.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
		sb
				.append("<input type='hidden' name='strOfflinePatNetPayAmount' id='strOfflinePatNetPayAmount' value='0.00'> ");
		sb.append("<div id='offlinePatNetPayDivId'>0.00</div> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");

		return sb.toString();
	}*/

	/**
	 * returns the required Off-line Client Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOffLinePackageDetailsView(
			CashCollectionOfflineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");
		String index = voObj.getStrOffLinePackageIndex();
		try {
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='3%'> </td>");
			sb.append("<td class='multiLabel' width='18%'>Tariff Name</td>");
			sb.append("<td class='multiLabel' width='8%'>Rate/Unit</td>");
			sb
					.append("<td class='multiLabel' width='8%'>Package Quantity</td>");
			sb.append("<td class='multiLabel' width='8%'>Quantity</td>");
			sb.append("<td class='multiLabel' width='8%'>Each Unit</td>");
			sb.append("<td class='multiLabel' width='10%'>Net Amount</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb
					.append("<td class='multiControl'><input type='checkbox' name='pkgTariffChk"
							+ index + "'/>");
			sb.append("</td>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='6' class='LABEL'>Total </td>");
			sb.append("<td class='CONTROL'/>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='7' align='center'>");
			sb
					.append("<table border='0' width='100%' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/add_tab.gif' onClick=''/></td>");
			sb
					.append("<td align='left'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/btn-ccl.png' onClick='hidePkgDtls(\""
							+ index + "\");'/></td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getonTariffClientDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the Required Off-Line Bill Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object.
	 * @return required Off-Line Bill Details View.
	 * @throws Exception
	 */
	public static String getBillDetails(CashCollectionOfflineTransVO voObj)
			throws Exception {

		WebRowSet billDetails = voObj.getOfflineBillList();
		StringBuffer sBuffer = new StringBuffer("");
		try {
			sBuffer
					.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer
					.append("<tr><td colspan='9' class='TITLE'>Receipt Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Receipt No.</td>");
			sBuffer
					.append("<td width='19%' class='multiLabel'>Receipt Date </td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Receipt Type</td>");
			sBuffer
					.append(" <td width='19%' class='multiLabel'>Receipt Amount</td>");
			sBuffer.append("</tr>");
			sBuffer
					.append("<input type='hidden' name='xmlVal' id='xmlValId' value='"
							+ voObj.getStrOffLineRefundPenalty() + "'>");

			if (billDetails != null && billDetails.size() > 0) {

				int i = 0;

				while (billDetails.next()) {
					String billno = billDetails.getString(1);

					String temp[] = (billDetails.getString(6))
							.replace("^", "#").split("#");
					String bNo_HpSrv = billno + "^" + billDetails.getString(3)
							+ "^" + temp[4];
					String billdate = billDetails.getString(2);

					if (i == 0) {
						voObj.setStrOffLineBillNumber(billno);

						//voObj.setStrOffLineAccountNo(temp[4]);
					}

					sBuffer
							.append("<input type='hidden' name='billNo_Id' value='"
									+ bNo_HpSrv + "'>");
					sBuffer.append("<tr><td width='5%' class='multiLabel'> ");

					if (i == 0) {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);' checked='checked'> ");
					} else {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);'> ");
					}
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billno);
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billdate);
					sBuffer.append("</td>");
					/*
					 * sBuffer.append("<td width='19%' class='multiControl'>");
					 * sBuffer.append(billDetails.getString(3));
					 * sBuffer.append("</td>");
					 */
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(4));
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(5));
					sBuffer.append("</td></tr>");
					temp = null;
					i++;
				}
			} else {

				sBuffer
						.append("<tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Refund Receipts Available</td></tr>");
			}
			sBuffer.append("</table>");
		} catch (Exception e) {
			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getBillDetails()-->"
					+ e.getMessage());
		}

		return sBuffer.toString();

	}
	
	public static String getBillDetails_BS(CashCollectionOfflineTransVO voObj)
			throws Exception {

		WebRowSet billDetails = voObj.getOfflineBillList();
		StringBuffer sBuffer = new StringBuffer("");
		try {
			sBuffer.append("<p class='subHeaders'><i class='fas fa-receipt isubheaders'></i>&nbsp;Reciept Details</p>");
			sBuffer.append("<table class='table'>");
			sBuffer.append("<thead>");
			sBuffer.append("<tr><th>#</th><th>Receipt No.</th>");
			sBuffer.append("<th>Receipt Date </th>");
			sBuffer.append("<th>Receipt Type</th>");
			sBuffer.append(" <th style='text-align: right;'>Receipt Amount</th>");
			sBuffer.append("</tr></thead>");
			sBuffer.append("<input type='hidden' name='xmlVal' id='xmlValId' value='"
							+ voObj.getStrOffLineRefundPenalty() + "'>");

			if (billDetails != null && billDetails.size() > 0) {

				int i = 0;

				while (billDetails.next()) {
					String billno = billDetails.getString(1);

					String temp[] = (billDetails.getString(6))
							.replace("^", "#").split("#");
					String bNo_HpSrv = billno + "^" + billDetails.getString(3)
							+ "^" + temp[4];
					String billdate = billDetails.getString(2);

					if (i == 0) {
						voObj.setStrOffLineBillNumber(billno);

						//voObj.setStrOffLineAccountNo(temp[4]);
					}

					sBuffer
							.append("<input type='hidden' name='billNo_Id' value='"
									+ bNo_HpSrv + "'>");
					sBuffer.append("<tbody><tr><td><label class='container'> ");

					if (i == 0) {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);' checked='checked'> ");
					} else {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);'> ");
					}
					sBuffer.append("<span class='checkmark'></span></label></td>");
					sBuffer.append("<td>");
					sBuffer.append(billno);
					sBuffer.append("</td>");
					sBuffer.append("<td >");
					sBuffer.append(billdate);
					sBuffer.append("</td>");
					/*
					 * sBuffer.append("<td width='19%' class='multiControl'>");
					 * sBuffer.append(billDetails.getString(3));
					 * sBuffer.append("</td>");
					 */
					sBuffer.append("<td>");
					sBuffer.append(billDetails.getString(4));
					sBuffer.append("</td>");
					sBuffer.append("<td style='text-align: right;'>");
					sBuffer.append(billDetails.getString(5));
					sBuffer.append("</td></tr>");
					temp = null;
					i++;
				}
			} else {

				sBuffer
						.append("<div>No Refund Receipts Available</div>");
			}
			sBuffer.append("</tbody></table>");
		} catch (Exception e) {
			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getBillDetails()-->"
					+ e.getMessage());
		}

		return sBuffer.toString();

	}
	
	/**
	 * returns the Required Off-Line Bill Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object.
	 * @return required Off-Line Bill Details View.
	 * @throws Exception
	 */
	public static String getOffLinePartPayRefundBillDetails(CashCollectionOfflineTransVO voObj)
			throws Exception {

		WebRowSet billDetails = voObj.getOfflineBillList();
		StringBuffer sBuffer = new StringBuffer("");
		try {
			sBuffer
					.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer
					.append("<tr><td colspan='9' class='TITLE'>Receipt Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Receipt No.</td>");
			sBuffer
					.append("<td width='19%' class='multiLabel'>Receipt Date </td>");
			//sBuffer.append("<td width='19%' class='multiLabel'>Receipt Type</td>");
			sBuffer
					.append(" <td width='19%' class='multiLabel'>Receipt Amount</td>");
			sBuffer.append("</tr>");
			sBuffer
					.append("<input type='hidden' name='xmlVal' id='xmlValId' value='"
							+ voObj.getStrOffLineRefundPenalty() + "'>");

			if (billDetails != null && billDetails.size() > 0) {

				int i = 0;

				while (billDetails.next()) {
					String billno = billDetails.getString(1);

					String temp[] = (billDetails.getString(6))
							.replace("^", "#").split("#");
					String bNo_HpSrv = billno + "^" + billDetails.getString(3)
							+ "^" + temp[4];
					String billdate = billDetails.getString(2);

					if (i == 0) {
						voObj.setStrOffLineBillNumber(billno);

						//voObj.setStrOffLineAccountNo(temp[4]);
					}

					sBuffer
							.append("<input type='hidden' name='billNo_Id' value='"
									+ bNo_HpSrv + "'>");
					sBuffer.append("<tr><td width='5%' class='multiLabel'> ");

					if (i == 0) {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getPartPayBillTariffDtls(this);' checked='checked'> ");
					} else {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getPartPayBillTariffDtls(this);'> ");
					}
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billno);
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billdate);
					sBuffer.append("</td>");
					/*
					 * sBuffer.append("<td width='19%' class='multiControl'>");
					 * sBuffer.append(billDetails.getString(3));
					 * sBuffer.append("</td>");
					 */
					/*sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(4));
					sBuffer.append("</td>");*/
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(5));
					sBuffer.append("</td></tr>");
					temp = null;
					i++;
				}
			} else {

				sBuffer
						.append("<tr><td colspan='8' class='multiControl' style='color:red;font-weight:bold'>No Refund Receipts Available</td></tr>");
			}
			sBuffer.append("</table>");
		} catch (Exception e) {
			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getBillDetails()-->"
					+ e.getMessage());
		}

		return sBuffer.toString();

	}
	

	/**
	 * returns Off-Line Tariff Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return required Off-Line Tariff Details View.
	 * @throws Exception
	 */
	public static String getTariffDetailsBS(CashCollectionOfflineTransVO voObj) throws Exception 
	{
		StringBuffer sBuffer = new StringBuffer("");
		WebRowSet tariffDetails = voObj.getOfflineBillTariffList();
		
		try 
		{
			HisUtil util = new HisUtil("", "");
			String app_id = "";
			String strUnitId = "";
			String strBaseUnitVal = "";
			int indxTrf = 1;
			sBuffer.append("<p class='subHeaders'><i class='fas fa-info-circle isubheaders'></i>&nbsp;Tariff Details</p>");
			sBuffer.append("<table class='table'>");		
			sBuffer.append("<thead><tr><th>#</th>");
			sBuffer.append("<th>Tariff Name</th>");
			sBuffer.append("<th>Balance Qty</th>");
			sBuffer.append("<th>Refund Type</th>");
			sBuffer.append("<th>Penalty (%)</th>");
			sBuffer.append(" <th>Refund Qty</th>");
			sBuffer.append(" <th>Unit</th>");
			sBuffer.append(" <th>Refund Cost(<img src='/HBIMS/hisglobal/images/INR.png'>)");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalServiceTaxAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalDiscountAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalPenaltyAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalActualTariffAmount' value='0' >");
			sBuffer.append("</th>");
			sBuffer.append("</tr></thead>");

			if (tariffDetails != null && tariffDetails.size() != 0) 
			{
				while (tariffDetails.next()) 
				{
					String TariffName = tariffDetails.getString(1);
					app_id = tariffDetails.getString(8) + "^"+ tariffDetails.getString(3)+ "^"+ tariffDetails.getString(15);
					strUnitId = app_id.replace("^", "#").split("#")[4];
					strBaseUnitVal = app_id.replace("^", "#").split("#")[13];
					
					sBuffer.append("<input type='hidden' name='lnkVal' value='"	+ app_id + "'>");
					sBuffer.append("<tbody><tr><td><div class='form-group'><input type='checkbox' class='form-control' name='strBillTariffVal' id='strBillTariffVal"+ indxTrf+ "' value='"+ app_id+ "' onClick='initBillTariff(this,\""+ indxTrf+ "\",\""+ tariffDetails.getString(2)+ "\");'><label for='strBillTariffVal"+ indxTrf+ "'></label></div></td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<input type='hidden' name='strOfflineRefundServiceTaxAmount' id='strOfflineRefundServiceTaxAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundDiscountAmount' id='strOfflineRefundDiscountAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundPenaltyAmount' id='strOfflineRefundPenaltyAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundActualTariffAmount' id='strOfflineRefundActualTariffAmount"
									+ indxTrf + "' value='0' >");

					sBuffer
							.append("<a name='strBillTariffName'  id='strBillTariffName" 
									+ indxTrf
									+ "' STYLE='CURSOR:POINTER; color:blue' value='"
									+ app_id
									+ "'  onClick='showTariffPopup(this,\""
									+ app_id + "\");'>" + TariffName + "</a>");
					sBuffer.append("</td>");
					sBuffer.append("<td>");
					sBuffer.append(tariffDetails.getString(2));
					sBuffer.append("</td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<select class='browser-default custom-select' name='strBillTariffPenaltyType' id='strBillTariffPenaltyType"
									+ indxTrf
									+ "' disabled='disabled' onChange='setPenalty(this,"
									+ indxTrf
									+ "),calcBillTariffRefundAmt(\""
									+ indxTrf
									+ "\",\""
									+ app_id
									+ "\");'><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select>");
					sBuffer.append("</td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<input type='hidden' class='form-control' name='strBillTariffPenalty' id='strBillTariffPenalty"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);' ><div id='strBillTariffPenaltyDivId"
									+ indxTrf + "'>0</div>");
					sBuffer.append("</td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<input type='text' class='form-control' name='strBillTariffRefund' id='strBillTariffRefund"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);'  disabled='disabled' onkeyup='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'>");
					sBuffer.append("</td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<select class='browser-default custom-select' name='strBillTariffUnit' id='strBillTariffUnit"
									+ indxTrf
									+ "' disabled='disabled' onChange='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'> ");

					voObj.setStrOffLineTariffUnitTempId(strUnitId);

					CashCollectionOfflineTransDAO.getOffLineTariffUnitList(voObj);

					// System.out.println("unit Val : "+strUnitId);
					
					//sBuffer.append(util.getOptionValue(voObj.getOfflineTariffUnit(), strUnitId + "^"+ strBaseUnitVal, "", false));
					sBuffer.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strUnitId + "^"+ strBaseUnitVal));

					sBuffer.append("</select>");
					sBuffer.append("</td>");
					sBuffer.append("<td>");

					sBuffer
							.append("<input type='hidden' class='form-control' disabled='disabled' name='strBillTariffRefundAmount' id='strBillTariffRefundAmount"
									+ indxTrf
									+ "' value='0' style='font-weight: bold'><div id='strBillTariffRefundAmountDivId"
									+ indxTrf
									+ "' style='font-weight:bold'>0.00</div></td> ");
					
					sBuffer
					.append("<input type='hidden' name='strOfflineRefundPayMode' id='strOfflineRefundPayMode_"
							+ indxTrf + "' value="+tariffDetails.getString(15)+" >");
					
					sBuffer
					.append("<input type='hidden' name='strOfflineRefundPatCat' id='strOfflineRefundPatCat_"
							+ indxTrf + "' value="+tariffDetails.getString(16)+">");
				
					
					indxTrf++;

				}
				sBuffer.append("</tr></tbody></table>");
			} else {

				sBuffer
						.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'><tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Tariff(s) Available/Credit Category Refund Not Allowed</td></tr></table>");

			}

		} catch (Exception e) {

			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getTariffDetails()-->"
					+ e.getMessage());
			
		}
		return sBuffer.toString();

	}
	public static String getTariffDetails(CashCollectionOfflineTransVO voObj) throws Exception 
	{
		StringBuffer sBuffer = new StringBuffer("");
		WebRowSet tariffDetails = voObj.getOfflineBillTariffList();
		
		try 
		{
			HisUtil util = new HisUtil("", "");
			String app_id = "";
			String strUnitId = "";
			String strBaseUnitVal = "";
			int indxTrf = 1;
			sBuffer.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer.append("<tr><td colspan='9' class='TITLE'>Tariff Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer.append("<td width='15%' class='multiLabel'>Tariff Name</td>");
			sBuffer.append("<td width='10%' class='multiLabel'>Balance Qty</td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Refund Type</td>");
			sBuffer.append("<td width='14%' class='multiLabel'>Penalty (%)</td>");
			sBuffer.append(" <td width='10%' class='multiLabel'>Refund Qty</td>");
			sBuffer.append(" <td width='10%' class='multiLabel'>Unit</td>");
			sBuffer.append(" <td width='10%' class='multiLabel'>Refund Cost(<img src='/HBIMS/hisglobal/images/INR.png'>)");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalServiceTaxAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalDiscountAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalPenaltyAmount' value='0' >");
			sBuffer.append("<input type='hidden' name='strOfflineRefundTotalActualTariffAmount' value='0' >");
			sBuffer.append("</td>");
			sBuffer.append("</tr></table>");

			if (tariffDetails != null && tariffDetails.size() != 0) 
			{
				while (tariffDetails.next()) 
				{
					String TariffName = tariffDetails.getString(1);
					app_id = tariffDetails.getString(8) + "^"+ tariffDetails.getString(3)+ "^"+ tariffDetails.getString(15);
					strUnitId = app_id.replace("^", "#").split("#")[4];
					strBaseUnitVal = app_id.replace("^", "#").split("#")[13];
					sBuffer.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
					sBuffer.append("<input type='hidden' name='lnkVal' value='"	+ app_id + "'>");
					sBuffer.append("<tr><td width='5%' class='multiLabel'><input type='checkbox' name='strBillTariffVal'id='strBillTariffVal"+ indxTrf+ "' value='"+ app_id+ "' onClick='initBillTariff(this,\""+ indxTrf+ "\",\""+ tariffDetails.getString(2)+ "\");'></td>");
					sBuffer.append("<td width='15%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' name='strOfflineRefundServiceTaxAmount' id='strOfflineRefundServiceTaxAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundDiscountAmount' id='strOfflineRefundDiscountAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundPenaltyAmount' id='strOfflineRefundPenaltyAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundActualTariffAmount' id='strOfflineRefundActualTariffAmount"
									+ indxTrf + "' value='0' >");

					sBuffer
							.append("<a name='strBillTariffName' id='strBillTariffName"
									+ indxTrf
									+ "' STYLE='CURSOR:POINTER; color:blue' value='"
									+ app_id
									+ "'  onClick='showTariffPopup(this,\""
									+ app_id + "\");'>" + TariffName + "</a>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");
					sBuffer.append(tariffDetails.getString(2));
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");

					sBuffer
							.append("<select class='comboNormal' name='strBillTariffPenaltyType' id='strBillTariffPenaltyType"
									+ indxTrf
									+ "' disabled='disabled' onChange='setPenalty(this,"
									+ indxTrf
									+ "),calcBillTariffRefundAmt(\""
									+ indxTrf
									+ "\",\""
									+ app_id
									+ "\");'><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='14%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' name='strBillTariffPenalty' id='strBillTariffPenalty"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);' ><div id='strBillTariffPenaltyDivId"
									+ indxTrf + "'>0</div>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='text' class='txtFldMin' name='strBillTariffRefund' id='strBillTariffRefund"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);'  disabled='disabled' onkeyup='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<select class='comboMin' name='strBillTariffUnit' id='strBillTariffUnit"
									+ indxTrf
									+ "' disabled='disabled' onChange='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'> ");

					voObj.setStrOffLineTariffUnitTempId(strUnitId);

					CashCollectionOfflineTransDAO.getOffLineTariffUnitList(voObj);

					// System.out.println("unit Val : "+strUnitId);
					
					//sBuffer.append(util.getOptionValue(voObj.getOfflineTariffUnit(), strUnitId + "^"+ strBaseUnitVal, "", false));
					sBuffer.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strUnitId + "^"+ strBaseUnitVal));

					sBuffer.append("</select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' disabled='disabled' name='strBillTariffRefundAmount' id='strBillTariffRefundAmount"
									+ indxTrf
									+ "' value='0' style='font-weight: bold'><div id='strBillTariffRefundAmountDivId"
									+ indxTrf
									+ "' style='font-weight:bold'>0.00</div></td> ");
					
					sBuffer
					.append("<input type='hidden' name='strOfflineRefundPayMode' id='strOfflineRefundPayMode_"
							+ indxTrf + "' value="+tariffDetails.getString(15)+" >");
					
					sBuffer
					.append("<input type='hidden' name='strOfflineRefundPatCat' id='strOfflineRefundPatCat_"
							+ indxTrf + "' value="+tariffDetails.getString(16)+">");
				
					
					indxTrf++;

				}
				sBuffer.append("</tr></table>");
			} else {

				sBuffer
						.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'><tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Tariff(s) Available/Credit Category Refund Not Allowed</td></tr></table>");

			}

		} catch (Exception e) {

			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getTariffDetails()-->"
					+ e.getMessage());
			
		}
		return sBuffer.toString();

	}

	
	/**
	 * returns Off-Line Tariff Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return required Off-Line Tariff Details View.
	 * @throws Exception
	 */
	public static String getPartPayTariffDetails(CashCollectionOfflineTransVO voObj)
			throws Exception {
		StringBuffer sBuffer = new StringBuffer("");
		WebRowSet tariffDetails = voObj.getOfflineBillTariffList();
		try {
			HisUtil util = new HisUtil("", "");
			String app_id = "";
			String strUnitId = "";
			String strBaseUnitVal = "";
			int indxTrf = 1;
			sBuffer
					.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer
					.append("<tr><td colspan='9' class='TITLE'>Tariff Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer
					.append("<td width='15%' class='multiLabel'>Tariff Name</td>");
			sBuffer
					.append("<td width='10%' class='multiLabel'>Balance Qty</td>");
			sBuffer
					.append("<td width='19%' class='multiLabel'>Refund Type</td>");
			sBuffer
					.append("<td width='14%' class='multiLabel'>Penalty (%)</td>");
			sBuffer
					.append(" <td width='10%' class='multiLabel'>Refund Qty</td>");
			sBuffer.append(" <td width='10%' class='multiLabel'>Unit</td>");
			sBuffer
					.append(" <td width='10%' class='multiLabel'>Refund Cost(in Rs)");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalServiceTaxAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalDiscountAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalPenaltyAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalActualTariffAmount' value='0' >");
			sBuffer.append("</td>");
			sBuffer.append("</tr></table>");

			if (tariffDetails != null && tariffDetails.size() != 0) {

				while (tariffDetails.next()) {

					String TariffName = tariffDetails.getString(1);

					app_id = tariffDetails.getString(8) + "^"
							+ tariffDetails.getString(3);

					strUnitId = app_id.replace("^", "#").split("#")[4];

					strBaseUnitVal = app_id.replace("^", "#").split("#")[13];

					sBuffer
							.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
					sBuffer.append("<input type='hidden' name='lnkVal' value='"
							+ app_id + "'>");

					sBuffer
							.append("<tr><td width='5%' class='multiLabel'><input type='checkbox' checked='checked'  name='strBillTariffVal'id='strBillTariffVal"
									+ indxTrf
									+ "' value='"
									+ app_id
									+ "' onClick='initBillTariff(this,\""
									+ indxTrf
									+ "\",\""
									+ tariffDetails.getString(2)
									+ "\");'></td>");
					sBuffer.append("<td width='15%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' name='strOfflineRefundServiceTaxAmount' id='strOfflineRefundServiceTaxAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundDiscountAmount' id='strOfflineRefundDiscountAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundPenaltyAmount' id='strOfflineRefundPenaltyAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundActualTariffAmount' id='strOfflineRefundActualTariffAmount"
									+ indxTrf + "' value='0' >");

					sBuffer
							.append("<a name='strBillTariffName' id='strBillTariffName"
									+ indxTrf
									+ "' STYLE='CURSOR:POINTER; color:blue' value='"
									+ app_id
									+ "'  onClick='showTariffPopup(this,\""
									+ app_id + "\");'>" + TariffName + "</a>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");
					sBuffer.append(tariffDetails.getString(2));
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");

					sBuffer
							.append("<select class='comboNormal' name='strBillTariffPenaltyType' id='strBillTariffPenaltyType"
									+ indxTrf
									+ "' disabled='disabled' onChange='setPenalty(this,"
									+ indxTrf
									+ "),calcBillTariffRefundAmt(\""
									+ indxTrf
									+ "\",\""
									+ app_id
									+ "\");'><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='14%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' name='strBillTariffPenalty' id='strBillTariffPenalty"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);' ><div id='strBillTariffPenaltyDivId"
									+ indxTrf + "'>0</div>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='text' class='txtFldMin' name='strBillTariffRefund' id='strBillTariffRefund"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);'  disabled='disabled' onkeyup='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<select class='comboMin' name='strBillTariffUnit' id='strBillTariffUnit"
									+ indxTrf
									+ "' disabled='disabled' onChange='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'> ");

					voObj.setStrOffLineTariffUnitTempId(strUnitId);

					CashCollectionOfflineTransDAO.getOffLineTariffUnitList(voObj);

					// System.out.println("unit Val : "+strUnitId);

					sBuffer.append(util.getOptionValue(voObj
							.getOfflineTariffUnit(), strUnitId + "^"
							+ strBaseUnitVal, "", false));

					sBuffer.append("</select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' disabled='disabled' name='strBillTariffRefundAmount' id='strBillTariffRefundAmount"
									+ indxTrf
									+ "' value='0' style='font-weight: bold'><div id='strBillTariffRefundAmountDivId"
									+ indxTrf
									+ "' style='font-weight:bold'>0.00</div></td> ");

					indxTrf++;

				}
				sBuffer.append("</tr></table>");
			} else {

				sBuffer
						.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'><tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Tariff(s) Available</td></tr></table>");

			}

		} catch (Exception e) {

			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getTariffDetails()-->"
					+ e.getMessage());
			
		}
		return sBuffer.toString();

	}

	
	
	/**
	 * returns Off-Line Bill Tariff Pop up Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return required Off-Line Bill Tariff Pop up Details View
	 */
	public static String getPopUp(CashCollectionOfflineTransVO voObj) {
		StringBuffer sb = new StringBuffer("");
		String strValmode = voObj.getStrOffLineTariffDetailsHiddenValue();
		String temp = "";
		String val[] = strValmode.replace('^', '#').split("#");
		String strRatePerUnit = val[3] + "/" + val[12];

		try {
			if (strValmode != null) {
				if (val[9].equals("2")){
					
					temp = "Percentage";
				}else{
					
					temp = "Fixed";
				}
					

				sb
						.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
				sb
						.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
				sb
						.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"offlineBillTariffPopupDetailsDivId\");'> </td></tr>");
				sb.append("</table> ");
				sb
						.append("<table width='400' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='20%'>Rate(Rs)/Unit</td>");
				sb.append("<td class='multiControl' width='20%'>"
						+ strRatePerUnit + "</td>");
				sb
						.append("<td class='multiLabel' width='20%'>Discount(Rs)</td>");
				sb.append("<td class='multiControl' width='20%'>" + val[8]
						+ "</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='20%'>Discount Type</td>");
				sb.append("<td class='multiControl' width='20%'>" + temp
						+ "</td>");
				sb
						.append("<td class='multiLabel' width='20%'>Service Tax(%)</td>");
				sb.append("<td class='multiControl' width='20%'>" + val[7]
						+ "</td>");
				sb.append("</tr>");
				sb.append("</table>");
				sb.append("<table width='400' align='center'>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='3'>&nbsp;</td>");
				sb.append("</tr></table>");
			} else {
				sb.append("<table width='400' align='center'>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='3'>&nbsp;</td>");
				sb.append("</tr></table>");
			}
		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPopUpDtl()-->", e.getMessage());
		}

		return sb.toString();

	}
 

	public static String getBillListingView(CashCollectionOfflineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getBillSearchList();

		try {

			int start = Integer.parseInt(voObj.getStrBillFromRow());
			int actualBlockSet = Integer.parseInt(voObj.getStrBillCtBlockSet());

			final int REC_PER_PAGE = Integer.parseInt(voObj
					.getStrBillRowPerPage());
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;

			int previous = 1;
			int next = 0;

			if (ws != null) {

				if (ws.size() != 0) {

					int actualFetchRecord = ws.size();

					if (actualBlockSet == 1)
						actualBlockSet = actualBlockSet + 1;

					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;

					if (totalFetchRecord != actualFetchRecord) {

						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;

					}

					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;

					if (reminder > 0)
						totalLayer = totalLayer + 1;

					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");

					if (start != 1) {
						sb
								.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""
										+ previous
										+ "\",\""
										+ (actualBlockSet - 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> &lt;&lt; Previous</FONT> </a> &nbsp;");

					}
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));

						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}

					if (next > 0)
						sb
								.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""
										+ next
										+ "\",\""
										+ (actualBlockSet + 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> Next &gt;&gt;</FONT></a>");

					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					/*
					 * sb .append("<table width='100%'align='center'
					 * cellspacing='1px'>");
					 * 
					 * sb.append("<tr>"); sb.append("<td class='LABEL'>&nbsp;");
					 * 
					 * if (start != 1) { sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + previous + "\",\"" +
					 * (actualBlockSet - 1) + "\");'> &lt;&lt; Previous</a>
					 * &nbsp;"); } for (int i = 1; i <= totalLayer; i++) {
					 * sb.append("<a href='#' onClick='layerIndexNavigator(\"" +
					 * i + "\",\"" + totalLayer + "\")'>" + (i + start - 1) + "</a>
					 * &nbsp;"); }
					 * 
					 * if (next > 0) sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + next + "\",\"" +
					 * (actualBlockSet + 1) + "\");'> Next &gt;&gt;</a>");
					 * 
					 * sb.append("</td>"); sb.append("</tr>"); sb.append("</table>");
					 */
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td width='5%'class='multiLabel'>");
					sb.append("</td>");
					sb
							.append("<td width='23%'class='multiLabel'>Patient Name");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Receipt No.");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Receipt Date");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Receipt Amount");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					for (int i = 1; i <= totalLayer; i++) {

						if (i < totalLayer
								|| (i == totalLayer && reminder == 0)) {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}

							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int j = 0; j < REC_PER_PAGE; j++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						} else {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}
							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						}

					}

					sb.append("</td>");
					sb.append("</'tr>");

					sb.append("</table>");

				} else {
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

			} else {

				throw new Exception("Patient List WebRowSet is Null");

			}

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPatientListingView()-->", e
							.getMessage());
		}

		return sb.toString();

	}
 
	/*public static String getOnLineReconcileTariffDetailsPopUp(
			CashCollectionOfflineTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrOnLineReconcileTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strTariffRatePerUnit = val[0];
		String strDisountUnit = val[1];
		String strServiceTax = val[3];
		if (val[2].equals("1")) {

			strDisountUnit = strDisountUnit + " Fixed";
		} else {
			strDisountUnit = strDisountUnit + " %";
		}

		try {

			sb
					.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
			sb
					.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"reconcilTariffPopupDetailsDivId\");'> </td></tr>");
			sb.append("</table> ");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Rate(Rs)/Unit</td>");
			sb.append("<td class='multiControl' width='20%'>"
					+ strTariffRatePerUnit + "</td>");
			sb.append("<td class='multiLabel' width='20%'>Discount(Rs)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strDisountUnit
					+ "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Service Tax(%)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strServiceTax
					+ "</td>");
			sb.append("<td class='multiLabel' colspan='2' width='20%'></td>");
			sb.append("</tr>");
			
			sb.append("</table>");
			sb.append("<table width='400' align='center'>");
			sb.append("<tr class='FOOTER'>");
			sb.append("<td colspan='3'>&nbsp;</td>");
			sb.append("</tr></table>");
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getOnLineReconcileTariffDetailsPopUp()-->",
					e.getMessage());
		}

		return sb.toString();

	}
*/
	public static String getAdmissionCancellationDetails(
			CashCollectionOfflineTransVO voObj, String mode) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;

		try {

			ws = voObj.getAdmissionCancellationDetails();

			if (ws.next()) {

				String strAccountNo = ws.getString(1);
				String strReceivedAmt = ws.getString(2);
				String strExpenceAmt = ws.getString(3);
				String strRefundAmt = ws.getString(4);
				String strBillNo = ws.getString(7);
					String paymode= ws.getString(10);
					String patcat= ws.getString(11);

					voObj.setMoreThanAdv(ws.getDouble((8)));
				
					
					if(Double.parseDouble(strRefundAmt)==0)
					{
						sb.append("@Advance amount already refunded/zero<br><font color='green'>ONLY ACCOUNT CATEGORY CAN BE CHANGED</font>");
					}else if(voObj.getMoreThanAdv() <=0)
						sb.append("@Advance amount already refunded/zero<br><font color='green'>ONLY ACCOUNT CATEGORY CAN BE CHANGED</font>");
					else{
					
					
					
					sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='4' class='TITLE'>Refund Advance Details</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='LABEL' width='25%'>Received Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strReceivedAmt
								+ "<input type='hidden' name='strAdmissionCancellationReceivedAmount' value='"
								+ strReceivedAmt
								+ "'><input type='hidden' name='strBillNo' value='"
								+ strBillNo
								+ "'><input type='hidden' name='strRefundAdvancePaneltyAmt' value='0'></td>");
				sb
						.append("<td class='LABEL' width='25%'>Expense Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strExpenceAmt
								+ "<input type='hidden' name='strAdmissionCancellationExpenseAmount' value='"
								+ strExpenceAmt + "'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				if (mode.equals("2")) {
					sb.append("<td class='LABEL' width='25%'>Refund Type</td>");
					sb
							.append("<td class='CONTROL' width='25%'><select onchange='setAdmissionCancellationPenalty(this);' name='strAdmissionCancellationRefundType' ><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select></td>");
					sb.append("<td class='LABEL'  width='25%'>Penalty</td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
				} else {
					sb.append("<td class='multiLabel'  width='25%'></td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
					sb
							.append("<td class='CONTROL' colspan='3' width='20%'></td>");
				}
				
				
				sb.append("<input type='hidden' name='strOfflineRefundPayMode' id='strOfflineRefundPayMode_1' value='"+paymode+"' >");
				
				sb.append("<input type='hidden' name='strOfflineRefundPatCat' id='strOfflineRefundPatCat_1' value='"+patcat+"' >");
				
				sb.append("</tr>");
				
				if(voObj.getMoreThanAdv()>1 || voObj.getMoreThanAdv()==0)
				{
					sb.append("<tr><input type='hidden' id='onlyRefund' value=1></tr>");
				}else
				{
					sb.append("<tr><input type='hidden' id='onlyRefund' value=0></tr>");
				}
				sb.append("</table>");

				sb.append("^" + strRefundAmt + "^" + strAccountNo);

			}}
		} catch (Exception e) {
			e.printStackTrace();
			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getAdmissionCancellationDetails()-->",
					e.getMessage());
		}

		return sb.toString();

	}
	
	
	public static String getPartPaymentCancellationDetails(
			CashCollectionOfflineTransVO voObj, String mode) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;

		try {

			//ws = voObj.getAdmissionCancellationDetails();
			ws = voObj.getOfflineBillList();
			if (ws.next()) {

				String strReceivedAmt ="0";
				String strBillNo = voObj.getStrBillNo();
				String strExpenceAmt = "0";
				String strRefundAmt = "0";
				String strAccountNo="abc";
				//String strAccountNo = ws.getString(1);
				//String strReceivedAmt = ws.getString(2);
				//String strExpenceAmt = ws.getString(3);
				//String strRefundAmt = ws.getString(4);
				//String strBillNo = ws.getString(7);

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='4' class='TITLE'>Refund PartPayment Details</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='LABEL' width='25%'>Received Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strReceivedAmt
								+ "<input type='hidden' name='strAdmissionCancellationReceivedAmount' value='"
								+ strReceivedAmt
								+ "'><input type='hidden' name='strBillNo' value='"
								+ strBillNo
								+ "'><input type='hidden' name='strRefundAdvancePaneltyAmt' value='0'></td>");
				sb
						.append("<td class='LABEL' width='25%'>Expense Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strExpenceAmt
								+ "<input type='hidden' name='strAdmissionCancellationExpenseAmount' value='"
								+ strExpenceAmt + "'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				if (mode.equals("2")) {
					sb.append("<td class='LABEL' width='25%'>Refund Type</td>");
					sb
							.append("<td class='CONTROL' width='25%'><select onchange='setAdmissionCancellationPenalty(this);' name='strAdmissionCancellationRefundType' ><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select></td>");
					sb.append("<td class='LABEL'  width='25%'>Penalty</td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
				} else {
					sb.append("<td class='multiLabel'  width='25%'></td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
					sb
							.append("<td class='CONTROL' colspan='3' width='20%'></td>");
				}
				sb.append("</tr>");
				sb.append("</table>");

				sb.append("^" + strRefundAmt + "^" + strAccountNo);

			}
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getPartPaymentCancellationDetails()-->",
					e.getMessage());
		}

		return sb.toString();

	}
	public static String getOffLinePackageAppDetailsView(CashCollectionOfflineTransVO voObj, String selectedTreatmentCat) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLinePackageAppDetailsView()");
		//String strApprovedBy = "";
		try 
		{
			/*if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() > 0) 
			{
				voObj.getOfflineApprovedByList().beforeFirst();
				strApprovedBy = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value",false);
			} 
			else 
			{
				strApprovedBy = "<option value='0'>Select Value</option>";
			}
			String strRemarks = "";
			
			if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() > 0) 
			{
				voObj.getOfflineRemarksList().beforeFirst();
				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),"", "", false);
				strRemarks = strRemarks + "<option value='0'>Others</option>";
			} 
			else 
			{
				strRemarks = "<option value='0' selected>Others</option>";
			}*/

			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td class='TITLE'>Package Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr> ");
            
			/*<div id="apppack">
			<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
			 <td width="50%" class="LABEL"><font color="red">*</font>Apply OT Package</td>
		    	   <td width="50%" class="LABEL"><div id="pack" align="left">
			    	   <select name="strPackageApply" class="comboNormal" onChange="setAdvAmt();">
					   	<bean:write name="cashCollectionOfflineTransBean" property="strPackageComboValues" filter="false"/>
					   </select></div>
		    	   </td>
		    	   </tr>
		    	   <tr>
		    	   <td width="50%" class="LABEL"><font color="red">*</font>Date of Applying Package</td>
		    	   <td width="50%" class="CONTROL">
		    	   <date:date name="strPackAppDate" value="${cashCollectionOfflineTransBean.strCurrentDate}"></date:date>
		    	   </td>
		    </table>
		    </div>*/
		    
			/*sb.append("<td width='12%'class='LABEL'><div align='right'><font color='red'>*</font>Apply OT Package</div></td> ");
	
			sb.append("<td width='13%' class='CONTROL'><div id='pack' align='left'><select name='strPackageApply' class='comboNormal' onChange='setAdvAmt();' >");
			//sb.append("<bean:write name='cashCollectionOfflineTransBean' property='strPackageComboValues' filter='false'/></select></div></td> ");
			
			sb.append("<td width='12%'class='LABEL'><div align='right'><font color='red'>*</font>Date of Applying Package</div></td> ");
			
			sb.append("<td width='13%' class='CONTROL'><div align='left'><date:date name='strPackAppDate' value='${cashCollectionOfflineTransBean.strCurrentDate}'></date:date></div></td>");*/
			
			//sb.append("<tr> ");
			//System.out.println("selectedTreatmentCat"+selectedTreatmentCat);
			
			if(selectedTreatmentCat.replace("^","#").split("#").length>=2)
			{
				String strCatGroup  	= selectedTreatmentCat.replace("^","#").split("#")[1];//3,4- Credit,0-Paid 
				if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<td width='25%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					/*sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("<option value='13'>Credit(Urgent)</option>");*/
					sb.append("</select>");
					sb.append("</td>");
					/*sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append(HisUtil.getDatePicker("strCreditLetterDate", "", true));	*/				
					//sb.append("<input type='hidden' name='strClientPatientNo'>");					
					//sb.append("<input type='hidden' name='strCreditFilePath'>");					
					//sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					//sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(selectedTreatmentCat);
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboOffline(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
					
					sb.append("<td width='25%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");						
					/*sb.append("<select class='comboMax' name='strCreditLetterNo' id='strCreditLetterNoId'> ");
					
					if (voObj.getCreditLettersWS() != null && voObj.getCreditLettersWS().size() > 0) 
					{
						sb.append(new HisUtil("Billing", "CashCollectionOfflineHLP").getOptionValue(voObj.getCreditLettersWS(), "", "0^Select Value", false));
						sb.append("</select>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}	*/	
					sb.append(creditListCombo);
					//sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					sb.append("</td>");					
				}
				else				
				{
					sb.append("<td width='25%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='10'>Paid</option>");
					//sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					/*sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append(HisUtil.getDatePicker("strCreditLetterDate", "", true));	*/				
					//sb.append("<input type='hidden' name='strClientPatientNo'>");					
					//sb.append("<input type='hidden' name='strCreditFilePath'>");					
					//sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					//sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true); 
					
					sb.append("<td width='25%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");						
					/*sb.append("<select class='comboMax' name='strCreditLetterNo' id='strCreditLetterNoId'> ");
					
					if (voObj.getCreditLettersWS() != null && voObj.getCreditLettersWS().size() > 0) 
					{
						sb.append(new HisUtil("Billing", "CashCollectionOfflineHLP").getOptionValue(voObj.getCreditLettersWS(), "", "0^Select Value", false));
						sb.append("</select>");
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
						sb.append("</select>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
					}	*/	
					sb.append(creditListCombo);
					sb.append("</td>");					
				}
				/*if(strCatGroup.equals("4"))//Credit
				{
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					sb.append("</select>");
					sb.append("</td>");
					//adding Credit Client Details ....
					sb.append("<td width='24%' class='LABEL'>Arogyashri No/Card No.</td>");
					sb.append("<td width='24%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' class='txtFldNormal' maxlength='50' onkeypress='return validateData(event,3);' autocomplete='off'>");
					sb.append("</td>");					
					sb.append("<input type='hidden' name='strClientPatientNo'>");					
					sb.append("<input type='hidden' name='strCreditFilePath'>");					
					sb.append("<input type='hidden' name='strCreditClientNo' value=''>");					
	//				sb.append("<input type='hidden' name='strEmployeeId'>");					
	//				sb.append("<input type='hidden' name='strEmployeeName'>");					
	//				sb.append("<input type='hidden' name='strRalationId'>");					
	//				sb.append("<input type='hidden' name='strCardValidity'>");
					sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='2'>");//Direct --No Approval
					sb.append("</td>");	
				}*/
			}
			//sb.append("<td width='50%'class='LABEL' > ");
			///sb.append("<div id='id11' style='display:block'> ");
			//sb
			//.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			//sb.append("<tr>  ");
			///sb.append("<td width='25%' class='LABEL'>Update:</td> ");
			///sb.append("<td width='25%' class='CONTROL'><input type='checkbox' name='strChk_value' value='0' onClick='ftnTick();'></td> ");
			//sb.append("</tr> ");
			//sb.append("</table> ");
			///sb.append("</div>");
			//sb.append("</td> ");
			sb.append("</tr> ");
			//sb.append("<tr style='display:none'> ");
			//sb.append("<td width='50%'class='LABEL' > ");
			//sb.append("<div id='id12' style='display:block'> ");
			//sb
			//.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			//sb.append("<tr>  ");
			/*sb.append("<td width='25%' class='LABEL'><div style='display:none'> Against Security:</div></td> ");
			sb.append("<td width='25%' class='CONTROL'><div style='display:none'> <input type='checkbox' name='advSecFlag' value='0' onClick='ftnadvSecTick();' ></div></td> ");*/
			//sb.append("</tr> ");
			//sb.append("</table> ");
            //sb.append("</div>");
			//sb.append("</td> ");

			//end of code added by Garima Gotra
			
			/*sb.append("<td width='25%' class='LABEL' >Part Payment Remarks ");
			sb.append("</td> ");			
			sb.append("<td width='25%' colspan='3' class='CONTROL'> ");
			sb.append("<input type='text' name='strRemarks' disabled='true' class='txtFldBig' maxlength='100' onkeypress='return validateDataWithSpecialChars(event,9,\".\");' >");
			sb.append("</td> ");
			sb.append("</tr> ");

			sb.append("</table> ");

		
			sb.append("<div id='combo' style='display:none'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			
			if(voObj.getStrIsApprovalRequired().equals("1")){
				
				sb
				.append("<td width='25%' class='LABEL'><font color='red'>*</font>Approval By</td> ");
				
			}else{
				
				sb
				.append("<td width='25%' class='LABEL'>Approval By</td> ");
				
			}
			
		
			
			
			
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb
					.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb
					.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"
							+ voObj.getStrOffLineRemarks()
							+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");*/
			sb.append("</table> ");
			//sb.append("</div> ");

		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}
	
	public static String getOffLinePackageAppDetailsViewBS(CashCollectionOfflineTransVO voObj, String selectedTreatmentCat) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLinePackageAppDetailsView()");
		//String strApprovedBy = "";
		try 
		{
			
			sb.append("<p class='subHeaders'>Package Details</p> ");
			
			
			sb.append("<div class='row'>");
			
           
			if(selectedTreatmentCat.replace("^","#").split("#").length>=2)
			{
				String strCatGroup  	= selectedTreatmentCat.replace("^","#").split("#")[1];//3,4- Credit,0-Paid 
				if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<div class='col-sm-3'><label>Payment Type</label></div>");
					sb.append("<div class='col-sm-3'>");
					sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					
					sb.append("</select>");
					sb.append("</div>");
					
					
					
					
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(selectedTreatmentCat);
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboOffline(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
					
					sb.append("<div class='col-sm-4'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></div>");
					sb.append("<div class='col-sm-2'>");						
						
					sb.append(creditListCombo);
					sb.append("</div>");					
				}
				else				
				{
					sb.append("<div class='col-sm-3'><label>Payment Type</label></div>");
					sb.append("<div class='col-sm-3'>");
					sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='10'>Paid</option>");
					sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("</select>");
					sb.append("</div>");
					
						
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true); 
					
					sb.append("<div class='col-sm-4'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></div>");
					sb.append("<div class='col-sm-2'>");						
					
					sb.append(creditListCombo);
					sb.append("</div>");					
				}
				
			}
			
			sb.append("</div> ");
			
			

		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}
	
	
	public static String getAdvanceDtlView(CashCollectionOfflineTransVO voObj) {
		StringBuffer sb =new StringBuffer("");
		WebRowSet ws=voObj.getAdvanceDtls();
		String billNo="";
		String billDate="";
		String advanceAmt="";
		String catcode="";
		String paymode="";
		
		try{
			if(ws!=null && ws.size() >0)
			{
				if(ws.next())
				{
					billNo=ws.getString(1)+"/"+ws.getString(2);
					billDate=ws.getString(3).split(" ")[0];
					advanceAmt=ws.getString(4);
					catcode=ws.getString(5);
					paymode=ws.getString(6);
				}
				
				
				
				sb.append("<table class='TABLEWIDTH' border='0' cellpadding='1px' cellspacing='1px' align='center'>");

				sb.append("<tr>");
				sb.append("<td width='25%' class='LABEL'>ADVANCE BILL NO:</td>");
				sb.append("<td width='25%' class='CONTROL'>"+billNo+"</td>");
				sb.append("<td width='25%' class='LABEL'>ADVANCE BILL DATE:</td>");
				sb.append("<td width='25%' class='CONTROL'>"+billDate+"</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='25%' class='LABEL'>ADVCANCE AMOUNT:</td>");
				sb.append("<td width='25%' class='CONTROL'>"+advanceAmt+"</td>");
				sb.append("<td width='25%' class='LABEL'>PAYMENT MODE:</td>");
				sb.append("<td width='25%' class='CONTROL'>"+paymode.split("#")[0]+"</td>");
			
				

				sb.append("</tr><tr>");
				sb.append("<td width='25%' class='CONTROL'><input type='hidden' id='accCatCode' value='"+catcode+"'></td>");
				sb.append("<td width='25%' class='CONTROL'><input type='hidden' id='advancePayMode' value='"+paymode.split("#")[1]+"'></td>");
				sb.append("<td width='25%' class='CONTROL'></td>");
				sb.append("<td width='25%' class='CONTROL'></td>");
				sb.append("</tr>");
				

				sb.append("	</table>");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();
	}

	
	public static String getOffLineOtherDetailsView_BS(CashCollectionOfflineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strAccNo = voObj.getStrOffLineAccountNo();
		String strSpecialWardId = voObj.getStrOffLineSpecialWard();
		String strAccTreatCat = voObj.getStrOffLineTreatmentCategory();
		String strAccChargeType = voObj.getStrOffLineWard();
		String strAccDept = voObj.getStrOffLineRaisingDepartment();

		if (strAccNo.length() > 1) {

			/*
			 * sb .append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 * 
			 * sb.append("<tr>");
			 * 
			 * sb.append("<td class='TITLE' width='20'> "); sb
			 * .append("<div id='plusoffLineOtherDtlId' ><img  style='cursor: hand; cursor: pointer'    "
			 * ); sb
			 * .append("src='../../hisglobal/images/plus.gif' name='plusoffLineOtherDtl' ");
			 * sb.append("align='middle' "); sb
			 * .append("onclick='showCltDetails(\"offLineOtherDtlId\");' /></div> "); sb
			 * .append("<div id='minusoffLineOtherDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    "
			 * ); sb
			 * .append("src='../../hisglobal/images/minus.gif' name='minusoffLineOtherDtl' "
			 * );
			 * 
			 * sb .append("onclick='hideCltDetails(\"offLineOtherDtlId\");'></div> ");
			 * sb.append("</td> ");
			 * sb.append("<td colspan='3' class='TITLE'>Other Details</td>");
			 * sb.append("</tr>"); sb.append("</table>");
			 * 
			 * sb.append("<div id='offLineOtherDtlId' style='display: none'>"); sb
			 * .append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 * sb.append("<tr>");
			 * 
			 * sb.append("<td width='50%' class='LABEL'>Account No.</td>"); sb
			 * .append("<td width='50%' class='CONTROL'>" + strAccNo +
			 * " <input type='hidden' name='strOffLineAccountNo' value='" + strAccNo +
			 * "'><input type='hidden' name='strSpecialWardId' value='" + strSpecialWardId +
			 * "'> <input type='hidden' name='strAccTreatCat' value='" + strAccTreatCat +
			 * "'><input type='hidden' name='strAccChargeType' value='" + strAccChargeType +
			 * "'><input type='hidden' name='strAccDept' value='" + strAccDept +
			 * "'>  </td>");
			 * 
			 * sb.append("</tr>");
			 * 
			 * sb.append("</table>"); sb.append("</div>");
			 */
			
			//sb.append("<div class='subHeaders'><i class='fas fa-university' style='font-size:26px;'></i>Other Details</div>");
			sb.append("<div class='row'>");
			sb.append("<div class='col-sm-6'>Account No.</div>");
			sb.append("<div class='col-sm-6'>"+ strAccNo+ "</div>"
					+ "<input type='hidden' name='strOffLineAccountNo' value=' "+ strAccNo +"'"
					+ "<input type='hidden' name='strSpecialWardId' value=' "+ strSpecialWardId +"'"
					+ "<input type='hidden' name='strAccTreatCat' value=' "+ strAccTreatCat +"'"
					+ "<input type='hidden' name='strAccChargeType' value=' "+ strAccChargeType +"'"
					+ "<input type='hidden' name='strAccDept' value=' "+ strAccDept +"'");
			sb.append("</div>");

		}

		return sb.toString();
	}
	public static String getOffLineAdvanceDetailsView_BS(CashCollectionOfflineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLineAdvanceDetailsView()");

		String strApprovedBy = "";
		
		String strCatGroup="";
		try 
		{
			//voObj.getStrOffLineTreatmentCategory();
			
			strCatGroup  = voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1];//3,4- Credit,0-Paid
			if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() > 0) 
			{
				voObj.getOfflineApprovedByList().beforeFirst();
				strApprovedBy = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value",false);
			} 
			else 
			{
				strApprovedBy = "<option value='0'>Select Value</option>";
			}

			String strRemarks = "";

			if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() > 0) 
			{
				voObj.getOfflineRemarksList().beforeFirst();
				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),"", "", false);
				strRemarks = strRemarks + "<option value='0'>Others</option>";
			} 
			else 
			{
				strRemarks = "<option value='0' selected>Others</option>";
			}
			//sb.append("<div class='subHeaders'><i class='fas fa-university' style='font-size:26px;'></i>Advance Details</div>");
			//sb.append("<table class='table'>");
			//sb.append("<thead></thead><tbody><tr> ");
			sb.append("<div class='row'><div class='col-sm-2'><label>Advance Amount(<i class=\"fas fa-rupee-sign\"></i>):</label></div> ");

			if (!voObj.getStrOffLineAdvanceAmount().equals("")) 
			{
				sb.append("<div class='col-sm-2'><input type='hidden' name='strdummypartpayment' value='"+ voObj.getStrOffLineAdvanceAmount()+ "'>");
				sb.append("<input name='strPartpayment' tabindex='1'  maxlength='7' id='strPartpayment' type='text' class='form-control' value='"+ voObj.getStrOffLineAdvanceAmount()+ "' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);' >&nbsp;</div> ");
			} 
			else 
			{
				sb.append("<div class='col-sm-2'><input type='hidden' name='strdummypartpayment' value='0'>");
				sb.append("<input name='strPartpayment' tabindex='1'  maxlength='7' id='strPartpayment' type='text' class='form-control' value='0' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'>&nbsp;</div> ");
			}
			
			String creditListCombo="";
			if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
			{
				sb.append("<div class='col-sm-2'>Payment Type</font></label><div>");
				sb.append("<div class='col-sm-2'>");
				sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
				sb.append("<option value='11'>Credit</option>");
				sb.append("<option value='10'>Paid</option>");
				sb.append("</select>");
				sb.append("</div>");
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
				voBilling.setStrServiceType("2");//IPD Letters
				 creditListCombo=HLPbilling.getCreditLetterListComboOffline_BS(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService());
				
			
			}
			else
			{
				sb.append("<div  class='col-sm-2' style='display:none;' ><label>Payment Type</label></div>");
				sb.append("<div  class='col-sm-2' style='display:none;'>");
				sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
				sb.append("<option value='10'>Paid</option>");
				//sb.append("<option value='12'>Paid(Urgent)</option>");
				//sb.append("<option value='11'>Credit</option>");
				sb.append("</select>");
				sb.append("</div>");
				
				BillingVO voBilling=new BillingVO();
				voBilling.setStrValue1(voObj.getStrCrNo());
				voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
				voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
				voBilling.setStrServiceType("2");//IPD Letters
				 creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true);
				
			
			}
			sb.append("<div  class='col-sm-2' ><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details</label></div>");
			sb.append("<div  class='col-sm-2' > ");
			sb.append(creditListCombo);
			sb.append("</div>");
			

			sb.append("</div> ");
			sb.append("<div id='combo' style='display:none'> ");
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			
			if(voObj.getStrIsApprovalRequired().equals("1"))
			{				
				sb.append("<td width='25%' class='LABEL'><font color='red'>*</font>Approval By</td> ");				
			}
			else
			{				
				sb.append("<td width='25%' class='LABEL'>Approval By</td> ");				
			}			
			
			sb.append("<td width='50%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"+ voObj.getStrOffLineRemarks()+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div> ");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			new HisException("Cash Collection Trans","CashCollectionTransHLP.getOffLineAdvanceDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

	public static String getOffLinePartPaymentDetailsView_BS(CashCollectionOfflineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		HisUtil util = new HisUtil("BILLING","CashCollectionTransHLP.getOffLinePartPaymentDetailsView()");
		String strApprovedBy = "";
		try 
		{
			if (voObj.getOfflineApprovedByList() != null && voObj.getOfflineApprovedByList().size() > 0) 
			{
				voObj.getOfflineApprovedByList().beforeFirst();
				strApprovedBy = util.getOptionValue(voObj.getOfflineApprovedByList(), "0", "0^Select Value",false);
			} 
			else 
			{
				strApprovedBy = "<option value='0'>Select Value</option>";
			}
			String strRemarks = "";
			
			if (voObj.getOfflineRemarksList() != null && voObj.getOfflineRemarksList().size() > 0) 
			{
				voObj.getOfflineRemarksList().beforeFirst();
				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),"", "", false);
				strRemarks = strRemarks + "<option value='0'>Others</option>";
			} 
			else 
			{
				strRemarks = "<option value='0' selected>Others</option>";
			}

			
			
			sb.append("<div class='row'><div class='col-sm-2'><label>Part Payment Amount(<i class=\"fas fa-rupee-sign\"></i>):</label></div> ");

			if (!voObj.getStrOffLinePartPaymentAmount().equals("")) 
			{
				sb.append("<div class='col-sm-2'><input type='hidden' name='strdummypartpayment' value='"+ voObj.getStrOffLinePartPaymentAmount()+ "'>");
				sb.append("<input name='strPartpayment' tabindex='1' id='strPartpayment' type='text'  maxlength='7'  class='form-control' value='"+ voObj.getStrOffLinePartPaymentAmount()+ "' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);'>&nbsp;<img src='../../hisglobal/images/INR.png'></div> ");
			}
			else 
			{
				sb.append("<div class='col-sm-2'><input type='hidden' name='strdummypartpayment' value='0'>");
				sb.append("<input name='strPartpayment' tabindex='1' id='strPartpayment' type='text'  maxlength='7'  class='form-control' value='0' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'></div>");
			}
			//System.out.println("voObj.getStrOffLineTreatmentCategory()"+voObj.getStrOffLineTreatmentCategory());
			
			if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#").length>=2)
			{
				String strCatGroup  	= voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1];//3,4- Credit,0-Paid 
				if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<div class='col-sm-2' style='display:none'>Payment Type</div>");
					sb.append("<div class='col-sm-2' style='display:none'>");
					sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					/*sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("<option value='13'>Credit(Urgent)</option>");*/
					sb.append("</select>");
					sb.append("</div>");
					
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboOffline(voBilling,"1",false,true,voObj.getStrOffLineHospitalService(),voObj.getStrOffLineBillingService()); 
					
					sb.append("<div class='col-sm-2'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details</label></div>");
					sb.append("<div class='col-sm-2'>");						
					sb.append(creditListCombo);
					sb.append("</div>");					
				}
				else				
				{
					sb.append("<div class='col-sm-2' style='display:none'>Payment Type</div>");
					sb.append("<div class='col-sm-2' style='display:none'>");
					sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this);calcCreditAmount(this,\"1\");'> ");
					sb.append("<option value='10'>Paid</option>");
					sb.append("</select>");
					sb.append("</div>");
					sb.append("</td>");	
					
					
					//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//IPD Letters
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true); 
					
					sb.append("<div class='col-sm-2'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details</label></div>");
					sb.append("<div class='col-sm-2'>");						
					sb.append(creditListCombo);
					sb.append("</div>");					
				}
				
			}
			
			sb.append("</div> ");
			sb.append("<div class='row' style='display:none'>");
			
			sb.append("<div class='col-sm-2' style='display:none'> Against Security:</div>");
			sb.append("<div class='col-sm-2' style='display:none'> <input type='checkbox' name='advSecFlag' value='0' onClick='ftnadvSecTick();' ></div>");
			

			//end of code added by Garima Gotra
			
			sb.append("<div class='col-sm-2'><label>Part Payment Remarks</label></div>");
			sb.append("<div class='col-sm-2'>");
			sb.append("<input type='text' name='strRemarks' disabled='true' class='txtFldBig' maxlength='100' onkeypress='return validateDataWithSpecialChars(event,9,\".\");' >");
			sb.append("</div> ");
			sb.append("</div> ");

			sb.append("<div id='combo' style='display:none' class='row'> ");
						
			if(voObj.getStrIsApprovalRequired().equals("1"))
			{				
				sb.append("<div class='col-sm-2'><label><font color='red'>*</font>Approval By</label></div>");				
			}
			else
			{				
				sb.append("<div class='col-sm-2'><label>Approval By</label></div> ");				
			}
				
			
			sb.append("<div class='col-sm-2'>");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</div> ");
			
			sb.append("<div class='col-sm-2'><label>Remarks</label></div>");
			sb.append("<div class='col-sm-2'>");
			sb.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"
							+ voObj.getStrOffLineRemarks()
							+ "' disabled='disabled'></div>");
			
			sb.append("</div> ");

		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}


}
