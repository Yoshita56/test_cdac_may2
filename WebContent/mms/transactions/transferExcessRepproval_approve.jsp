  <%@ page language="java"contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Transfer Excess Reapproval</title>


<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/jquery-3.3.1.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/base64.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../js/indentViewTrans.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/dropdown.js"></script>
<script language="Javascript" src="../js/transferExcessApprovalTrans.js"></script>
<script type="text/javascript">

$(function() {
var divHeight=150;
	var initialHeight=716;
	var heightPer = (divHeight*100)/initialHeight; 
	 var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
	
	fixedHeaderTableTrans("wrapper",newHeight);
});

function initPage()
{
   var chkObj = document.getElementsByName("strInsSancQty");
   var issueFrmReservStockObj= document.getElementsByName("strIssueFrmReservStock");
	var len = chkObj.length;
	
	for ( var i = 0; i < len; i++)
	{	
		if(document.getElementById("strInsSancQty" + i))
		{
			document.getElementById("strInsSancQty" + i).value = '0';
		}
		
		if(issueFrmReservStockObj[i])
		{
			issueFrmReservStockObj[i].checked=false;
		}
	}
	document.forms[0].strRemarks.value="";
}
function calUnitBaseCost(index,selected_obj)
{
              
               var issueQty      = (document.forms[0].strInsSancQty.value)*(selected_obj.value.split("^")[1]);
		       //var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		       var avlQtyBaseVal = document.forms[0].strAvlQtyReceving.value;
		       		    
			    if (parseFloat(avlQtyBaseVal) < parseFloat(issueQty)) 
			    {
				  alert("Approved Quantity cannot be greater than Avalaible Quantity in Rasining Store!!!");
				  document.forms[0].strInsSancQty.value = "0";
				  document.getElementsByName("strInsUnitCombo"+ index).value = "0";
							 
				   return false;
			    }                  
}


function calculateCostOnChange(index,obj) 
{

	if (document.getElementById("strInsUnitCombo" + index).value != "0"	&& document.getElementById("strInsUnitCombo" + index).value != "") 
	{
	    var bkgQtyQtyUnit  = document.getElementById("strInsUnitCombo" + index).value;
		var bkgQty      = (document.getElementById("strInsSancQty" + index).value)*(bkgQtyQtyUnit.split("^")[1]);
		
		
		
		var avlQtyBaseVal = document.forms[0].strAvlQtyReceving.value;

		
		if (parseFloat(avlQtyBaseVal) < parseFloat(bkgQty)) 
		{
			alert("Approved Quantity cannot be greater than Avalaible Quantity in Rasining Store!!!");
			document.getElementById("strInsSancQty" + index).value = 0;
			
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
		
		
		return false;

	}
	
}
</script>

	
</head>
<body onload="OnLoadCheck()"; class="background" >
<html:form name="transferExcessApprovalTransBean" action="/transactions/TransferExcessApprovalTransCNT" type="mms.transactions.controller.fb.TransferExcessApprovalTransFB" styleClass="formbg">
<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	

<center>
	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferExcessApprovalTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferExcessApprovalTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferExcessApprovalTransBean" property="strNormalMsg" /></div>
</center>
	
	<div  id ="Raising" style="display:block">
       <table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
			 <tr class="HEADER">
				<td colspan="4"><bean:message key="label.common.Transfer_excess_approval"/> &gt;&gt; <bean:message key="label.common.Reapproval"/></td>
			 </tr>
		 </table>
	</div>	 
		 <table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
		      <bean:write name="transferExcessApprovalTransBean" property="strIndentDetails" filter="false" />
		 </table>
	
	<bean:write name="transferExcessApprovalTransBean" property="strTransferOrderDetails"	filter="false" />
		
	<bean:write name="transferExcessApprovalTransBean" property="strSetApprovedDetails"  filter="false" /></br>
	
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1"> 
	    <tr>
			<td class="LABEL" width="25%"><bean:message key="label.common.Approval_status"/></td>
			<td width="25%" class="CONTROL" colspan="3">
			<input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this),setApprovedQty();"/>Approved
			<input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>Rejected
		</tr>
		</table>	
<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">
		<tr>
		<td width="50%" class="LABEL" ><div id="remarks">
		Remarks</div></td>
			<td width="50%" class="CONTROL" colspan="3"><textarea
				name="strRemarks" cols="25" rows="2"></textarea></td>
	   </tr>
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>			


<div>
<div class="legends"><font size="2" color="red">*</font> <bean:message key="label.common.Mandatory_Field(s)"/></div>  
	<div class="control_button">
		<table  class="TABLEWIDTH" align="center">
			<tr id="saveId">
			  <td align="center">
			    <div >
					<a href="#" style="cursor:pointer;" title="Click to Save Record" class="button" onClick="validate1();"><span class="verify"><bean:message key="label.common.Verify"/></span></a>
					<a href="#" style="cursor:pointer;" title="Click to Clear Page" class="button" onclick="clearPage();"><span class="clear"><bean:message key="label.common.Clear"/></span></a>
					<a href="#" style="cursor:pointer;" title="Click Here Go Back To Main Desk" class="button" onClick="cancel('cancelToList');"><span class="back"><bean:message key="label.common.Back"/></span></a>				 
				</div>
			  </td>
			</tr>	  
		</table>
	</div>
</div>	           		
	<input type="hidden" name="strApprovalFlag"    value="${transferExcessApprovalTransBean.strApprovalFlag}">
	<input type="hidden" name="strReApprovalFlag"  value="1">	
	<input type="hidden" name="strReqTypeId"       value="${transferExcessApprovalTransBean.strReqTypeId}">	
	<input type="hidden" name="strStoreId"	 value="${transferExcessApprovalTransBean.strStoreId}" />
	<input type="hidden" name="strStoreName" value="${transferExcessApprovalTransBean.strStoreName}" />
	<input type="hidden" name="strReqDate" value="${transferExcessApprovalTransBean.strReqDate}" />
	<input type="hidden" name="strCtDate"  value="${transferExcessApprovalTransBean.strCtDate}">
	<input type="hidden" name="strPath"  value="${transferExcessApprovalTransBean.strPath}">
    <input type="hidden" name="strChk"             value="${transferExcessApprovalTransBean.strChk}">
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers/>
	</html:form>
	<tag:autoIndex></tag:autoIndex>  
</body>
