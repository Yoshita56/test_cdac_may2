<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Issue To Patient Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("ItemListingRPT");

	
		hisValidator.addValidation("strItemCatId", "dontselect=-1","Select Item Category From Item Category Combo");
		 
		 
		 var retVal = hisValidator.validate();
		// alert(document.forms[0].strIsMisc.checked);
		if(document.forms[0].strIsMisc.checked==true)
			{
			document.forms[0].strIsMisc.value=1;
			}
		else
			{
			document.forms[0].strIsMisc.value=0;
			}

		if(document.forms[0].strIsQuant.checked==true)
		{
		document.forms[0].strIsQuant.value=1;
		}
	else
		{
		document.forms[0].strIsQuant.value=0;
		}
		
			
	hisValidator.clearAllValidations();

	
	if(retVal){
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}

		document.forms[0].submit();
	}
	else
		{
         return false;
		}		
	}
	
	
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="ItemListingRPTCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
	}
}
function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="ItemListingRPTCNT_NEW.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	document.forms[0].strItemCatNo.value="0";
}
}
function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onChange=' ' >"+res+"</select>";		
		
	}	

	if(mode=="2"){ 
		
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId' class='comboNormal'>"+res+"</select>";		
	
}	
}		
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadpage(){
	
	document.forms[0].strItemCatNo.value = "0";
	
	
//	document.forms[0].strStoreId.value = "0";
//	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	//document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;

}

</script>
</head>
<body onload="onLoadpage();">
<html:form action="/reports/ItemListingCNT_NEW" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="ItemListingRPT" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="ItemListingRPT" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="ItemListingRPT" property="strWarningMsg"/></div>


	<!--<tag:tab tabLabel="Issue To Patient Report"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>-->

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Item Listing Report</td>
		</tr>
		
	
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
				<td width="50%" colspan="2" class="CONTROL">
					<div id="itemCatDivId">
						<select	name="strItemCatId" class="comboNormal">
					<bean:write name="ItemListingRPT" property="strItemCategCmb"
						filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Only miscellaneous 
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			
			<input type="checkbox" name="strIsMisc" value="0" > 
			</td>
			
			
		</tr>
			<tr>
			<td width="50%" colspan="2" class="LABEL">
			Only Unit Items
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input type="checkbox" name="strIsQuant" value="0" > 
			</td>
			
		</tr>
	
	
		
	
		
	
	
			
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option>
			</select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="ItemListingRPT" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			User Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"> <font color='red'>*</font>Mandatory Field</td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${ItemListingRPT.strCurrentDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>