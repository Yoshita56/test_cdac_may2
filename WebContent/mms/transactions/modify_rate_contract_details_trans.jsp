<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Rate Contract Details</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>



<script language="javaScript">


function showPrevRenewDtls()
{
if(document.forms[0].strPrevRenewFlag.value==1)
document.getElementById("previousRenewDtlsDiv").style.display="block";

if(document.forms[0].strCancelDtlsFlag.value==1)
document.getElementById("cancelDtlsDiv").style.display="block";

document.forms[0].strContractToDate.focus();
}

function modify()
{   
      var hisValidator = new HISValidator("rateContractDtlBean"); 
       var retVal=true;
         
             hisValidator.addValidation("strDeliveryDays",     "req", "Delivery Day(s) is a Mandatory Field" );
             if(parseInt(document.forms[0].strDeliveryDays.value)==0)
             {
             	alert("Please Enter Delivery Day(s) Greater than Zero!!!");
             	return false;
             }
            //      alert(document.forms[0].strContractFromDate.value);
            hisValidator.addValidation("strContractFromDate", "req", "Contract From Date is a Mandatory Field" );
	        hisValidator.addValidation("strContractToDate",   "req", "Contract To Date is a Mandatory Field" ); 
            /* hisValidator.addValidation("strTenderDate",       "req", "Tender Date is a Mandatory Field" ); */
           /*  hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strPreviousContractFromDate}", "Contract From Date should be greater than to Previous Contract from Date"); */
           //  hisValidator.addValidation("strContractFromDate", "dtgt=${rateContractDtlBean.strContractFromDate}", "Contract from Date should be greater than Current Date");
            hisValidator.addValidation("strContractToDate",   "dtgt=${rateContractDtlBean.strContractFromDate}", "Contract To Date should be greater than Previous Contract To Date");
             
            /* hisValidator.addValidation("strTenderDate",       "dtltet="+document.forms[0].strContractFromDate.value+"", "Tender Date should be Less than or Equal to Contract From Date"); */
            hisValidator.addValidation("strRemarks",          "req", "Please enter the reason for RC Modification in Remarks" );
            hisValidator.addValidation("strRemarks",          "maxlen=250", "Remarks should have less than or equal to 250 Characters" );
            hisValidator.addValidation("strLastPurchaseRate",        "req", "Rate is a Mandatory Field" );  
            hisValidator.addValidation("strLastPurchaseRate",        "amount=11,2", "Rate should be in format 000000000.00" );
            /* hisValidator.addValidation("strRenewRateUnitId",  "dontselect=0", "Please select a Unit" ); */  
            hisValidator.addValidation("strRenewRateContQty",       "req",  "Qty is a Mandatory Field" );  
            hisValidator.addValidation("strRenewSecurityAmtPercent", "req", "Security Amount is a Mandatory Field" ); 
            retVal = hisValidator.validate(); 
            hisValidator.clearAllValidations();

           
           /*  if(document.forms[0].strRCChk.checked)
            	document.forms[0].strRCChk.value = "1";
            else
            	document.forms[0].strRCChk.value = "0";  */
           if(retVal)
           {
          				 document.forms[0].hmode.value = "MODIFYSAVE";
                        document.forms[0].submit();
            }
            else
            {
					return false;
			}
    }
</script>

</head>
<body onLoad="showPrevRenewDtls();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransCNT"
	type="mms.transactions.controller.fb.RateContractDtlTransFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>

<tag:tab tabLabel="Rate Contract Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%" >Supplier Name</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strSupplierName" filter="false" /></td>
				
				<td class="LABEL" width="25%" >Contract Type</td>
			<td width="25%" class="CONTROL" ><bean:write name="rateContractDtlBean"
				property="strContractType" filter="false" /></td>
				

		</tr>
		<tr>
			<td class="LABEL" width="25%" >Item Category</td>
			<td class="CONTROL" colspan="3"><bean:write name="rateContractDtlBean"
				property="strItemCategoryName" filter="false" /></td>
				
				

		</tr>
		</table>
		<div id="previousRenewDtlsDiv" style="display: none" >
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr class="TITLE">
			<td colspan="4"><div id=''>Renew &gt;&gt;  Contract Details</div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Renew Date</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strPrevRenewDate" filter="false"/></td>

			<td class="LABEL" width="25%">Delivery Day(s)</td>
			<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strDeliveryDays" filter="false"/></td>

		</tr>
		
		<tr>
				<td width="25%" class="LABEL" >Contract From</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractFromDate" filter="false"></bean:write></td>
					<td width="25%" class="LABEL">Contract To</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewContractToDate" filter="false"></bean:write></td>
			</tr>
			
		<tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewTenderNo" filter="false"></bean:write>
				</td>
					<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevRenewQuotationNo" filter="false"></bean:write>
				</td>
			</tr>
			
			<tr>
				<td width="25%" class="LABEL">Tender Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevTenderDate" filter="false"></bean:write>
				</td>
					<td width="25%" class="LABEL">Quotation Date.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strPrevQuotationDate" filter="false"></bean:write>
				</td>
			</tr>
			
		
			<tr>
				<td width="25%" class="LABEL">TAX(%)</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevTaxWithType" filter="false"></bean:write>
				
			</td>
				
				<td width="25%" class="LABEL">Remarks</td>
				<td  class="CONTROL" >
				<bean:write name="rateContractDtlBean" property ="strPrevRenewRemarks" filter="false"></bean:write>
				</td>
				<tr class="TITLE">
			<td colspan="4"><div id=''>Renew &gt;&gt;  Drug Details</div></td>
		    </tr>
			<tr>
				<td colspan="1" width="25%" class="LABEL">Drug Name
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevRenewItemName" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Contracted Rate/Unit
				</td>
				<td colspan="1" width="25%" class="CONTROL">
				<bean:write name="rateContractDtlBean" property="strPrevRenewRate" filter="false"></bean:write>/
				<bean:write name="rateContractDtlBean" property="strPrevRenewRateUnit" filter="false"/>
				</td>
		    </tr>
		    <tr>
				<td colspan="1" width="25%" class="LABEL">Security Amt(%)
				</td>
				<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevSecurityAmt" filter="false"></bean:write>
				</td>
				<td colspan="1" width="25%" class="LABEL">Rate Contract Qty
				</td>
				<td colspan="2" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strPrevContractQty" filter="false"></bean:write>
				</td>
			</tr>
			
	
		</table> 
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
		<tr class="TITLE">
			<td colspan="4"><div id='' >Current &gt;&gt; Contract Details</div></td>
		</tr>
		
		
		<tr>
				<td width="25%" class="LABEL" >Contract From</td>
				<td width="25%" class="CONTROL">
				<dateTag:date name="strContractFromDate" value ="${rateContractDtlBean.strContractFromDate}"></dateTag:date>
				</td>
				<%-- <bean:write name="rateContractDtlBean" property ="strContractFromDate" filter="false"></bean:write></td> --%>
					<td width="25%" class="LABEL">Contract To</td>
				<td width="25%" class="CONTROL">
				<dateTag:date name="strContractToDate" value ="${rateContractDtlBean.strContractToDate}"></dateTag:date>
				</td>
				<%-- <bean:write name="rateContractDtlBean" property ="strContractToDate" filter="false"></bean:write></td> --%>
			</tr>
			
		<tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL">
				<input type="text" class="txtFldMax"
					name="strTenderNo" maxlength="50" value="${rateContractDtlBean.strTenderNo}"
					onkeypress="return validateData(event,8);">
				<%-- <td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strTenderNo" filter="false"></bean:write> --%>
				</td>
					<td width="25%" class="LABEL">Quotation No.</td>
					<td width="25%" class="CONTROL">
					<input type="text" class="txtFldMax"
					name="strQuotationNo" maxlength="50" value="${rateContractDtlBean.strQuotationNo}"
					onkeypress="return validateData(event,8);">
				<%-- <td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property ="strQuotationNo" filter="false"></bean:write> --%>
				</td>
			</tr>
			
			<tr>
				<td width="25%" class="LABEL">RC/Tender SNO.</td>
				<td width="25%" class="CONTROL">
				<input type="text" class="txtFldMax"
					name="strRcTenderSno" maxlength="10" value="${rateContractDtlBean.strRcTenderSno}"></td>
				
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"></td>
				
		
			</tr>
		
			<tr>
				<td width="25%" class="LABEL">TAX(%)</td>
				<td width="25%" class="CONTROL">
				<input type="text" class="txtFldMax"
					name="strTax" maxlength="4" value="${rateContractDtlBean.strTax}" onkeypress="return validateData(event,7);"
					onkeyup="notGreaterThanCent(this);">
				<%-- <td  class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strTaxWithType" filter="false"></bean:write> --%>
				
			</td>
			 <td width ="25%" class ="LABEL" >Remarks</td>
			 <td width="25%" class="CONTROL">
			 <textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks" value="${rateContractDtlBean.strRemarks}" onkeypress="return validateData(event,9);"></textarea>
			
  <%--   <td  class ="CONTROL" ><bean:write name="rateContractDtlBean" property="strRemarks" filter="false"></bean:write></td> --%>
  
			</tr>
			<tr class="TITLE">
			<td colspan="4"><div id='' >Current &gt;&gt; Drug Details</div></td>
		</tr>
	
		</table><table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
			<tr>
				<td colspan="1" width="25%" class="LABEL">Drug Name
				</td>
				<td colspan="1" width="25%" class="CONTROL"><font color="red"><bean:write name="rateContractDtlBean" property="strItemBrandName" filter="false"></bean:write></font>
				</td>
				<td colspan="1" width="25%" class="LABEL">Rate/Unit
				</td>
				<td colspan="1" width="25%" class="CONTROL">
				<input type="text" class="txtFldMax"
					name="strLastPurchaseRate" maxlength="12" value="${rateContractDtlBean.strLastPurchaseRate}"
					onkeypress="return validateData(event,7);">/
					 <select name="strRenewRateUnitId" id="strRenewRateUnitId" class="comboNormal" >
			   <bean:write name="rateContractDtlBean" property="strUnitCmbValues" filter="false"></bean:write>
					<%-- <input type="text" class="txtFldMax"
					name="strLastPurchaseRateUnit" maxlength="12" value="${rateContractDtlBean.strLastPurchaseRateUnit}"
					onkeypress="return validateData(event,5);"> --%>
				<%-- <bean:write name="rateContractDtlBean" property="strLastPurchaseRate" filter="false"></bean:write>/
			                                                <bean:write name="rateContractDtlBean" property="strLastPurchaseRateUnit" filter="false"/> --%>
				</td>
		    </tr>
		    <tr>
				<td colspan="1" width="25%" class="LABEL">Security Amt(%)
				</td>
				<td colspan="1" width="25%" class="CONTROL"><input type="text" class="txtFldMax"
					name="strRenewSecurityAmtPercent" maxlength="5" value="${rateContractDtlBean.strLastSecurityAmount}"
					onkeyup="notGreaterThanCent(this);"><%-- <><bean:write name="rateContractDtlBean" property="strLastSecurityAmount" filter="false"></bean:write> --%>
				</td>
				<td colspan="1" width="25%" class="LABEL"> Quantity
				</td>
				<td colspan="2" width="25%" class="CONTROL"><%-- <bean:write name="rateContractDtlBean" property="strLastContractQty" filter="false"></bean:write> --%>
				<input type="text" class="txtFldMax"
					name="strRenewRateContQty" maxlength="12" value="${rateContractDtlBean.strLastContractQty}"
					onkeypress="return validateData(event,7);">
				</td>
			</tr>
			 <tr>
				<td class="LABEL" width="25%">Delivery Day(s)</td>
				<td class="CONTROL" >
				<input type="text" class="txtFldMax"
					name="strDeliveryDays" maxlength="3" value="${rateContractDtlBean.strDeliveryDays}"
					onkeypress="return validateData(event,5);">
				</td>
				<%-- <td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strDeliveryDays" filter="false"/></td> --%>
				<td class="LABEL" width="25%">Whether Item Is imported</td>
				<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strImportTypeViewFlag" filter="false"/></td>
			</tr>
			
			 <tr>
				<td class="LABEL" width="25%">Shelf Life(In Days)</td>
				<td class="CONTROL" >
				<input type="text" class="txtFldMax"
					name="strRenewShelfLife" maxlength="3" value="${rateContractDtlBean.strRenewShelfLife}"
					onkeypress="return validateData(event,5);">
					</td>
				<%-- <td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"/></td> --%>
				<td class="LABEL" width="25%">Level</td>
				<td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strRenewLevel" filter="false"/></td>
			</tr>
			<tr>
				<td class="LABEL" width="25%">Pack Size</td>
				<td class="CONTROL" >
				<input type="text" class="txtFldNormal"
					name="strPackSize" maxlength="10" value="${rateContractDtlBean.strRenewPackSize}"
					onkeypress="return validateData(event,9);">
					</td>
				<%-- <td class="CONTROL" ><bean:write name="rateContractDtlBean" property ="strRenewShelfLife" filter="false"/></td> --%>
				<td class="LABEL" width="25%"></td>
				<td class="CONTROL" ></td>
			</tr>
		</table>
		<div id="cancelDtlsDiv" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
		<tr class="TITLE">
			<td colspan="4"><div id=''>Cancel Details</div></td>
		</tr>
	
		</table><table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td colspan="1" width="25%" class="LABEL">Cancel Date
			</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelDate" filter="false"></bean:write>
			</td>
			<td colspan="1" width="25%" class="LABEL">Cancel Seat Id
			</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelSeatId" filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Cancel Remarks
			</td>
			<td colspan="3"  class="CONTROL"><bean:write name="rateContractDtlBean" property="strCancelRemarks" filter="false"></bean:write>
			</td>
			
		</tr>
	</table>
	</div>
			<div id="id1"></div>
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
		<tr class="FOOTER">
			 <td colspan="4"> </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			
<img style="cursor: pointer; " title="Click Here To Come Back On Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table> -->
<br>
<div align="center" id="">		
                        <a href="#" class="button" onclick="modify();"><span class="save">Modify</span></a>			 
					 	<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
					


<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="searchItemsDtlsDivId" style="display:block;"></div>
</td>
</tr>
</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPrevRenewFlag" value="${rateContractDtlBean.strPrevRenewFlag}"/>
<input type="hidden" name="strCancelDtlsFlag" value="${rateContractDtlBean.strCancelDtlsFlag}"/>
<input type="hidden" name="ctDate" value="${rateContractDtlBean.strCtDate}"/>
<input type="hidden" name="strSupplierId" value="${rateContractDtlBean.strSupplierId}"/>
<input type="hidden" name="strSupplierName" value="${rateContractDtlBean.strSupplierName}"/>
<input type="hidden" name="strContractTypeID" value="${rateContractDtlBean.strContractTypeID}"/>
<input type="hidden" name="strContractType" value="${rateContractDtlBean.strContractType}"/>
<input type="hidden" name="strItemCategoryNo" value="${rateContractDtlBean.strItemCategoryNo}"/>
<input type="hidden" name="strItemCategoryName" value="${rateContractDtlBean.strItemCategoryName}"/>
<input type="hidden" name="strItemID" value="${rateContractDtlBean.strItemID}"/>
<input type="hidden" name="strItemBrandID" value="${rateContractDtlBean.strItemBrandID}"/>
<input type="hidden" name="strSlNo" value="${rateContractDtlBean.strSlNo}"/>

<input type="hidden" name="strDeiveryLeadTime" value="${rateContractDtlBean.strDeiveryLeadTime}"/>
<input type="hidden" name="strDeiveryLeadTimeUnit" value="${rateContractDtlBean.strDeiveryLeadTimeUnit}"/>

<input type="hidden" name="strChk1" value="${rateContractDtlBean.strChk1}"/>
<input type="hidden" name="comboValue" value="${rateContractDtlBean.comboValue}"/>
<input type="hidden" name="strTenderDate" value="${rateContractDtlBean.strTenderDate}"/>
<input type="hidden" name="strTaxType" value="${rateContractDtlBean.strTaxType}"/>
<input type="hidden" name="strRenewSecurityAmount" value="${rateContractDtlBean.strRenewSecurityAmount}"/>
<input type="hidden" name="strRenewLevel" value="${rateContractDtlBean.strRenewLevel}"/>
<input type="hidden" name="strQuotationDate" value="${rateContractDtlBean.strQuotationDate}"/>




<input type="hidden" name="strPreviousContractFromDate" value="${rateContractDtlBean.strPreviousContractFromDate}"/>
</div>

<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>