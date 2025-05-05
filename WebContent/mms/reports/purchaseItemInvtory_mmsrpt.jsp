<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>PO Register</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/select1.min.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/select2.min.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../hisglobal/js/jquery-1.11.1.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>


<script language="JavaScript" src="../../hisglobal/js/select2.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/select1.min.js"></script>


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">


$(document).ready(function() {
	 
	 $(".combojqrycls").select2({  placeholder: 'Select Value'  }); 
	 $(".combojqrycls1").select1({  placeholder: 'Select Value'  }); 

	 
});

function getPOType(obj)
{      
   document.forms[0].strSePOTypeId.value = obj.value;
}
function validate()
{

		var hisValidator = new HISValidator("purchaseItemInventoryBean");

		//hisValidator.addValidation("strHospitalCode", "dontselect=0","Please Select Hospital Name");
		hisValidator.addValidation("strSupplierId", "dontselect=-1","Supplier Name is a mandatory field");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	     var retVal = hisValidator.validate();
	     var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
// alert(dd);
         var dd2 = dd.split(' ')[0];
	     if( dd2> 365)
		     {
		     alert("Date difference couldn't be more than 365 days");
		    retVal= false;
		     }
	
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{
		document.forms[0].strSupplierName.value =  document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
		document.forms[0].strItemName.value =  document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
		if(document.forms[0].strPOType.value == '21')
		{	
		  document.forms[0].strPoTypeName.value =  "Bulk PO";
		}
		if(document.forms[0].strPOType.value == '22')
		{	
		  document.forms[0].strPoTypeName.value =  "Local PO";
		}
		
		document.forms[0].strPoStatusName.value = document.forms[0].strPoStatus[document.forms[0].strPoStatus.selectedIndex].text; 	
		
		    document.forms[0].hmode.value = "SHOWRPT";	
		
			document.forms[0].submit();
		
	}
}


	function onClearPage()
	{
		document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value ;
		document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value ;
	}

function cancelPage()
{
	document.forms[0].hmode.value="init";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

</script>
</head>
<body onload="">
<html:form action="/reports/PurchaseItemInventoryRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="purchaseItemInventoryBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="purchaseItemInventoryBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="purchaseItemInventoryBean" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Purchase Item Inventory" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
		
		<tr class="HEADER">
			<td colspan="4">Purchase Item Inventory</td>
		</tr>
		
		
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Supplier Combo</td>
			<td class="CONTROL" colspan="1">
				<select name="strSupplierId"  class="comboMax combojqrycls1">
					<bean:write name="purchaseItemInventoryBean" property="strSupplierCmb" filter="false" />
				</select>
			</td>
			
			<td class="LABEL" colspan="1"><font color="red">*</font>Item Combo</td>
			<td class="CONTROL" colspan="1"   >
				<select name="strItemBrandId"  class="comboMax combojqrycls">
					<bean:write name="purchaseItemInventoryBean" property="strItemCombo" filter="false" />
				</select>
			</td>
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${purchaseItemInventoryBean.strCurrentDate}" /></td>
		
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1">
				<dateTag:date name="strToDate" value="${purchaseItemInventoryBean.strCurrentDate}" />
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>PO Type</td>
			<td class="CONTROL" colspan="1"><input type="radio" name = "strPOType" value = "21" checked  onClick="getPOType(this);"/>Bulk PO<input type="radio" name = "strPOType" value = "22" onClick="getPOType(this);" />Local PO
			</td>
	
			<td class="LABEL" colspan="1"><font color="red">*</font>PO Status</td>
			<td class="CONTROL" colspan="1">
				<select name="strPoStatus" >
					<option value="1">Active</option>				
					
				</select>
			</td>
		</tr>		
				
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	

	<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>						
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
	</div>
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" 	value="${purchaseItemInventoryBean.strCurrentDate}"/>
<input type="hidden" name="strSupplierName" value="" />
<input type="hidden" name="strItemName" 	value="" />
<input type="hidden" name="strPoTypeName" 	value="" />
<input type="hidden" name="strSePOTypeId" 	value="" />
<input type="hidden" name="strPoStatusName" value="" />



</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>