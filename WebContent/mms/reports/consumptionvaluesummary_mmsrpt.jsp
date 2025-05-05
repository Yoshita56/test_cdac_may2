<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Consumption Value Summary</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){


	var hisValidator = new HISValidator("consumptionValueSumRpt");

	  hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category");
	  hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
	  hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
	  hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
	  hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal){
	
	
	
			 var count = selectListRecords("strStoreName");
        		        		 
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		}else{
			return false;
		}
	}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onStoreCombo(){
	if(document.forms[0].strStoreId.value == "1"){
		document.getElementById("listOpenButtonId").style.display = "block";
		
	}else if(document.forms[0].strStoreId.value == "0"){
		document.getElementById("listOpenButtonId").style.display = "none";
		document.getElementById("listValuesId").style.display = "none";
		}		
}

function getSelectedStoreDtl(){
		var url ="ConsumptionValueSummaryRptCNT.cnt?hmode=STORECMB&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
	if(mode=="1"){ 
				var objVal= document.getElementById("LeftStoreDivId");
				objVal.innerHTML = "<select name='strLeftStore' size='8' multiple style='width: 280px'>"+res+"</select>";	
		}	
}



function getShowDetailsPlus(){

	
	var hisValidator = new HISValidator("consumptionValueSumRpt");

	  hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category First");
	 	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal){

	document.getElementById("listValuesId").style.display = "block";
	document.getElementById("minus").style.display="block";
  	document.getElementById("plus").style.display="none";
  	
  	}
}
function getShowDetailsMinus(){
	document.getElementById("listValuesId").style.display = "none";
	document.getElementById("minus").style.display="none";
  	document.getElementById("plus").style.display="block";
}

function LeftListTransfer()
{
	//var ob1=document.forms[0].strLeftStores.value;
	//var ob=document.getElementById("LeftStores");
	shiftToRight("strLeftStore","strStoreName",1);
}
/*
function callOk()
{
	
	var storeId = document.forms[0].strStoreId.value;
	var selectedStoreNamesArr = document.getElementsByName("strStoreName");
	var selectedStoreNames ="";
	alert("selectedStoreNamesArr.length-"+selectedStoreNamesArr.length);

	alert("selectedStoreNamesArr[0].value"+selectedStoreNamesArr[0].value); 
	//	selectedStoreIds = selectedStoreNames+"^"+selectedStoreNamesArr[i].value;
	//}
	//document.forms[0].strStoreId.value = selectedStoreIds;
//	alert("store"+document.forms[0].strStoreId.value); 

getShowDetailsMinus(); 
	
}*/

function onClearPage(){
	document.forms[0].strStoreId.value="0";
	document.forms[0].strItemCatNo.value="0";
	document.getElementById("listValuesId").style.display = "none";
	document.getElementById("listOpenButtonId").style.display = "none";
	document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;
}

function onLoadPage(){

	document.forms[0].strStoreId.value="0";
	document.forms[0].strItemCatNo.value="0";


}

</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ConsumptionValueSummaryRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="consumptionValueSumRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="consumptionValueSumRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="consumptionValueSumRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Consumption Value Summary"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strItemCatNo" class="comboNormal" >
					<bean:write name="consumptionValueSumRpt" property="strItemCatValues"
						filter="false" />
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Drug Warehouse Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="onStoreCombo();">
					<option value="0">All</option>
					<option value="1">Selected</option>
				</select>
			</td>
			<td width="25%" colspan="1" class="CONTROL" align="center">
				<div id="listOpenButtonId" style="display: none;">
				<img src="../../hisglobal/images/plus.gif" id="plus"
				style="display: block; cursor: pointer; " 
				onclick="getSelectedStoreDtl(),getShowDetailsPlus();">
				<img src="../../hisglobal/images/minus.gif" id="minus"
				style="display: none; cursor: pointer; "
				onclick="getShowDetailsMinus();"></div>
			</td>
		</tr>
		</table>
		
		
		<div id="listValuesId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
 			 <tr>
  			 <td class="CONTROL" colspan="3">
  			 
			<div id="LeftStoreDivId" align="right"></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick='shiftAllToRight("strLeftStore","strStoreName",1);'></center>
				
				<center>
				
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick="shiftAllToLeft('strLeftStore','strStoreName',1);">
				</center>
				
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onClick='shiftToLeft("strLeftStore","strStoreName",1);'></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightStoreDivId" align="left"><select name="strStoreName" size="8" 
			multiple style="width: 280px"><bean:write name="consumptionValueSumRpt" property="strRightStore" filter="false"/>
			</select></div>
			</td>		
			</tr>
		
			<tr>
			<td  class="LABEL" colspan="8"> <center><img src="../../hisglobal/images/btn-ok.png" 
				
				onClick='getShowDetailsMinus();'></center></td>
			</tr>
		</table>
		
		
		</div>
		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate"
				value="${consumptionValueSumRpt.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strToDate"
				value="${consumptionValueSumRpt.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="consumptionValueSumRpt" value="1"></html:checkbox>
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
			 <td colspan="4"> </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="onClearPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${consumptionValueSumRpt.strCurrentDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>