<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<!--  
 * Developer :Anshul Jindal
 * Version : 1.0 
 * Date : 23/June/2009
 * Module:MMS
 * Unit:Bill Approval others  
 -->
 


<html>
<head>
<meta charset=UTF-8">
<title>Bill Approval View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/BillApprovalOtherTrans.js"></script>
<script language="javaScript">
function initPage()
{
 // alert("document.forms[0].strPONoH.value-"+document.forms[0].strPONoH.value); 
	if(document.forms[0].strPONoH.value!="0")
	{
	document.getElementById("PODetailsDIV").style.display="block";
	document.getElementById("poNoTextDiv").style.display="block";
	document.getElementById("poNoDiv").style.display="none";
	if(document.forms[0].strAgentNameShow.value=="1")
	   document.getElementById("agentNameDivId").style.display="block";
	else
	   document.getElementById("agentNameDivId").style.display="none";   
	}
	else
	{
	document.getElementById("PODetailsDIV").style.display="none";
	document.getElementById("poNoTextDiv").style.display="none";
	document.getElementById("poNoDiv").style.display="block"; 
	}
	
}


//to save the data 
function validate1()
{
	 var retVal=true;
	//document.forms[0].strPONo.disabled=false; 
	var hisValidator = new HISValidator("billApprovalOtherTransBean");
	
	if(document.forms[0].strPONoH.value!="0")
	{
    hisValidator.addValidation("strBillNo","req","Bill No is a mandatory field" );
    hisValidator.addValidation("strBillDate","req","Bill Date is a mandatory field " );
    hisValidator.addValidation("strBillDate","dtltet="+document.forms[0].strCurrentDate.value,"Bill Date should be less than or equal to Current Date " );
    hisValidator.addValidation("strBillAmount","req","Bill Amount is a mandatory field" );
    hisValidator.addValidation("strBillAmount","amount=11,2","Bill Amount format should be 000000000.00" );
       
    retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
    }
    else{
    alert("Please Enter GO Button");
    retVal = false;
    }
	if(retVal)
	{
		document.getElementById("PODetailsDIV").style.display="block";
	 	document.forms[0].hmode.value="SAVE";
	 	document.forms[0].submit();
	}
	 else
	{
		return false;
	}
}

</script>
</head>
<body onLoad="initPage();">
<html:form name="billApprovalOtherTransBean" action="transactions/BillApprovalOtherTransCNT"
	type="mms.transactions.controller.fb.BillApprovalOtherTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="billApprovalOtherTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="billApprovalOtherTransBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="billApprovalOtherTransBean" property="strNormalMsg"/></div>
</center>	

			<tag:tab tabLabel="Bill Approval Verify"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>


<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	<tr>
		<td class="LABEL" colspan="1" width="25%">Store Name</td>
    	<td width="25%" colspan="1" class ="CONTROL">
    	<bean:write name="billApprovalOtherTransBean" property="strStoreName" filter="false" /></td>
    	<td class="LABEL" colspan="1" width="25%">Bill Type</td>
    	<td width="25%" colspan="1" class ="CONTROL">
    	<bean:write name="billApprovalOtherTransBean" property="strBillTypeName" filter="false" /></td>
	</tr>
	<tr>
		<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>PO No</td>
    	<td width="75%" colspan="3" class ="CONTROL">
    	            <div id="poNoDiv">
					<select  name="strPONo"><bean:write name="billApprovalOtherTransBean" property="strPONoCmb" filter="false"></bean:write></select>
					<img align="top" style="cursor: pointer; " title="To click for Records" src="../../hisglobal/images/Go.png" onclick="goFunc();" />
					</div>
					<div id="poNoTextDiv" align="left" style="display:none;color:blue">
					<bean:write name="billApprovalOtherTransBean" property="strPOPrefix" filter="false"></bean:write>
					 / <bean:write name="billApprovalOtherTransBean" property="strPONo" filter="false"></bean:write>
			</div>	</td>	
					
   	</tr>
</table>

 <div id="PODetailsDIV" style="display:none">	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
			<td colspan="4"><div id="" style="color:blue;">PO Details</div>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				PO Date
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalOtherTransBean" property="strPODate" />
			</td>
			<td width="25%" colspan="1" class="LABEL">PO Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalOtherTransBean" property="strPOType"  />
			</td>
	   </tr>
	   <tr>
	       <td width="25%" colspan="1" class="LABEL">
				Supplier Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalOtherTransBean" property="strSupplierName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Category</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalOtherTransBean" property="strItemCategoryNameH" filter="false" />
			</td>
	   </tr>
	    <tr>
	       <td width="25%" colspan="1" class="LABEL">
				Currency Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalOtherTransBean" property="strCurrencyName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Currency Value</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalOtherTransBean" property="strCurrencyValue" filter="false" />
			</td>
	   </tr>
	    <tr>
	       <td width="25%" colspan="1" class="LABEL">
				PO Net Amount
			</td>
			<td width="75%" colspan="3" class="CONTROL">
				<bean:write name="billApprovalOtherTransBean" property="strPONetAmount" filter="false" />
			</td>
	   </tr>
     </table>
   <div id="agentNameDivId" style="display:none">  
    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">  
        <tr>
	       <td width="25%" colspan="2" class="LABEL">
				Agent Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="billApprovalOtherTransBean" property="strAgentName" filter="false" />
			</td>
			<td width="25%" colspan="1" class="LABEL">Clearing Agent Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="billApprovalOtherTransBean" property="strCAName" filter="false" />
			</td>
	   </tr>
     </table>
   </div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr><td class="TITLE" colspan="4"><div id="" style="color:blue;">Bill Details</div></td></tr>
	<tr>
	    <td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Bill No</td>
        <td class ="CONTROL" width="25%" colspan="1">
           <input type="text" class='txtFldMax' name="strBillNo" value ="" maxlength="20" onkeypress="return validateData(event,9);" >
        </td>
        <td class="LABEL" width="25%" colspan="1"><font color='red'>*</font>Bill Date</td>
        <td class ="CONTROL" width="25%" colspan="1">     
	       <date:date name="strBillDate" value="${billApprovalOtherTransBean.strCurrentDate}"></date:date>
       </td>  
    <tr>
	    <td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Bill Amt</td>
	    <td class="CONTROL" colspan="3" width="75%">
	       <input type="text"  name="strBillAmount" value="" class="txtFldNormal" onkeypress="return validateData(event,7);" maxlength="14">
	    </td>
    </tr>
    <tr>
	    <td class="LABEL" colspan="2" width="50%">Remarks</td>
	    <td class="CONTROL" colspan="2" width="50%">
	       <textarea rows="2" cols="15" name="strRemarks"></textarea>
	    </td>
    </tr>
    </table>  
 
 </div>
  
	
<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
		<tr>
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearFunc();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancel();" >
		</td>
		</tr>
</table>
<input type="hidden" name="hmode"/>


<input type="hidden" name="strCurrentDate" value="${billApprovalOtherTransBean.strCurrentDate}" />
<input type="hidden" name="strSupplierId" value="${billApprovalOtherTransBean.strSupplierId}" />
<input type="hidden" name="strPODate" value="${billApprovalOtherTransBean.strPODate}" />
<input type="hidden" name="strPOPrefix" value="${billApprovalOtherTransBean.strPOPrefix}" />
<input type="hidden" name="strPONoH" value="${billApprovalOtherTransBean.strPONo}" />
<input type="hidden" name="strPOStoreId" value="${billApprovalOtherTransBean.strPOStoreId}" />
<input type="hidden" name="strPOTypeId" value="${billApprovalOtherTransBean.strPOTypeId}" />
<input type="hidden" name="strStoreName" value="${billApprovalOtherTransBean.strStoreName}" />
<input type="hidden" name="strBillTypeName" value="${billApprovalOtherTransBean.strBillTypeName}" />
<input type="hidden" name="strBillType" value="${billApprovalOtherTransBean.strBillType}" />
<input type="hidden" name="strStoreId" value="${billApprovalOtherTransBean.strStoreId}" />
<input type="hidden" name="strAgentNameShow" value="${billApprovalOtherTransBean.strAgentNameShow}" />
<input type="hidden" name="strItemCategoryNoH" value="${billApprovalOtherTransBean.strItemCategoryNoH}" />
<input type="hidden" name="strItemCategoryNameH" value="${billApprovalOtherTransBean.strItemCategoryNameH}" />
<input type="hidden" name="strCurrencyValue" value="${billApprovalOtherTransBean.strCurrencyValue}" />
<input type="hidden" name="strCurrencyId" value="${billApprovalOtherTransBean.strCurrencyId}" />
<input type="hidden" name="strCurrencyName" value="${billApprovalOtherTransBean.strCurrencyName}" /> 
<input type="hidden" name="strComboValue" value="${billApprovalOtherTransBean.strComboValue}" />
<input type="hidden" name="strPath" value="${billApprovalOtherTransBean.strPath}"/>
<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>
